<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.jsp" %>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0">Read Page</h1>
                </div><!-- /.col -->
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Dashboard v1</li>
                    </ol>
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
        <div class="container-fluid">
            <div class="row">
                <!-- left column -->
                <div class="col-md-12">
                    <!-- general form elements -->
                    <div class="card card-primary">
                        <div class="card-header">
                            <h3 class="card-title">공 지 사 항</h3>
                        </div>

                        <style>
                            * {
                                margin: 0;
                                padding: 0;
                                box-sizing: border-box;
                            }

                            li {
                                list-style-type: none;
                            }

                            /* 보여줄 구간의 높이와 넓이 설정 */
                            #slideShow {
                                width: 500px;
                                height: 300px;
                                position: relative;
                                margin: 50px auto;
                                overflow: hidden; /*리스트 형식으로 이미지를 일렬로 정렬할 것이기 때문에, 500px 밖으로 튀어 나간 이미지들은 hidden으로 숨겨줘야됨*/
                            /*    hiden옵션 날림 -> hidden옵션 하면 가로길이 짧은거는 이상할 수 있음*/
                            }

                            .slides {
                                position: absolute;
                                left: 0;
                                top: 0;
                                width: 2500px; /* 슬라이드할 사진과 마진 총 넓이 */
                                transition: left 0.5s ease-out; /*ease-out: 처음에는 느렸다가 점점 빨라짐*/
                            }

                            /* 첫 번째 슬라이드 가운데에 정렬하기위해 첫번째 슬라이드만 margin-left조정 */
                            .slides li:first-child {
                                margin-left: 100px;
                            }

                            /* 슬라이드들 옆으로 정렬 */
                            .slides li:not(:last-child) {
                                float: left;

                                margin-right: 100px;
                            }

                            .slides li {
                                float: left;

                            }

                            .controller span {
                                position: absolute;
                                background-color: transparent;
                                color: black;
                                text-align: center;
                                border-radius: 50%;
                                padding: 10px 20px;
                                top: 50%;
                                font-size: 1.3em;
                                cursor: pointer;
                            }

                            /* 이전, 다음 화살표에 마우스 커서가 올라가 있을때 */
                            .controller span:hover {
                                background-color: rgba(128, 128, 128, 0.11);
                            }

                            .prev {
                                left: 10px;
                            }

                            /* 이전 화살표에 마우스 커서가 올라가 있을때 이전 화살표가 살짝 왼쪽으로 이동하는 효과*/
                            .prev:hover {
                                transform: translateX(-10px);
                            }

                            .next {
                                right: 10px;
                            }

                            /* 다음 화살표에 마우스 커서가 올라가 있을때 이전 화살표가 살짝 오른쪽으로 이동하는 효과*/
                            .next:hover {
                                transform: translateX(10px);
                            }
                        </style>

                        <c:if test="${noticeBoardDTO.files[0].nano_id != null}">
                            <div id="slideShow">
                                <ul class="slides">
                                    <c:forEach items="${noticeBoardDTO.files}" var="attach">
                                        <c:if test="${attach.image}">
                                            <li><img onclick="javascript:showOrigin('${attach.getFileLink()}')"
                                                     src="/noticeboard/viewFile?file=${attach.img_thumbnail_name}"></li>
                                        </c:if>
                                    </c:forEach>
                                </ul>

                                <p class="controller"> <!-- &lang: 왼쪽 방향 화살표 &rang: 오른쪽 방향 화살표 -->
                                    <span class="prev">&lang;</span> <span class="next">&rang;</span>
                                </p>

                            </div>
                        </c:if>

                    <div class="card-body">
                        <div class="form-group">
                            <label for="exampleInputEmail10">게시글번호</label>
                            <input type="text" name="bno" class="form-control" id="exampleInputEmail10"
                                   value="<c:out value="${noticeBoardDTO.nbno_id}"></c:out>" readonly>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">제목</label>
                            <input type="text" name="title" class="form-control" id="exampleInputEmail1"
                                   value="<c:out value="${noticeBoardDTO.title}"></c:out>" readonly>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <!-- textarea -->
                                <div class="form-group">
                                    <label>내용</label>
                                    <textarea name="content" class="form-control" rows="15" disabled><c:out
                                            value="${noticeBoardDTO.description}"></c:out>
                                        </textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.card-body -->

                    <div class="card-footer float-right">
                        <button type="button" class="btn btn-default btnList">목록가기</button>
                        <%--얘는 아직 시큐리티를 안넣었으니 나중에 시큐리티 넣으면 권한있는사람만 보기를 추가해야함--%>
                        <button type="button" class="btn btn-info btnMod">수정하기</button>
                        <button type="submit" class="btn btn-danger btnDel">삭제하기</button>
                        <%--얘는 아직 시큐리티를 안넣었으니 나중에 시큐리티 넣으면 권한있는사람만 보기를 추가해야함--%>
                    </div>

                </div>
                <!-- /.card -->


            </div>
        </div>
</div>
</section>

</div>
<!-- /.content-wrapper -->

<form id="actionForm" action="/noticeboard/list" method="get">
    <input type="hidden" name="page" value="${pageRequestDTO.page}">
    <input type="hidden" name="size" value="${pageRequestDTO.size}">
    <c:if test="${pageRequestDTO.type != null}">
        <input type="hidden" name="type" value="${pageRequestDTO.type}">
        <input type="hidden" name="keyword" value="${pageRequestDTO.keyword}">
    </c:if>
    <input type="hidden" name="nbno_id" value="${noticeBoardDTO.nbno_id}">
</form>
<%--submit할때 가지고갈 actionform임 --%>


<div class="modal fade" id="modal-image">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-body">
                <img id="targetImage">
            </div>
            <div class="modal-footer justify-content-between">
                <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
            </div>
        </div>
    </div>
</div>
<!-- /.modal -->

<style>
    #targetImage {
        width: 100%;
        height: 100%;
        /*    이미지 모달의 화면을 꽉채우게 하기위한 css*/
    }
</style>

<%@include file="../includes/footer.jsp" %>

<script>
    let slides = document.querySelector(".slides");
    let slideImg = document.querySelectorAll(".slides li");
    currentIdx = 0;
    slideCount = slideImg.length;
    prev = document.querySelector(".prev");
    next = document.querySelector(".next");
    slideWidth = 300;
    slideMargin = 100;

    if(slides) {
        slides.style.width = (slideWidth + slideMargin) * slideCount + "px";
    }

    function moveSlide(num) {
        slides.style.left = -num * 400 + "px";
        currentIdx = num;
    }

    if(prev) {
        prev.addEventListener('click', function () {
            if (currentIdx !== 0) moveSlide(currentIdx - 1);
        });
    }

    if(next) {
        next.addEventListener('click', function () {
            if (currentIdx !== slideCount - 1) moveSlide(currentIdx + 1);
        })
    }


    //목록가기와 수정 하는 스크립트
    const actionFrom = document.querySelector("#actionForm")

    document.querySelector(".btnList").addEventListener("click", () => {
        actionFrom.submit()
    }, false)

    document.querySelector(".btnMod").addEventListener("click", () => {


        actionFrom.setAttribute("action", "/noticeboard/modify")
        // actionForm.innerHTML += `<input type='hidden' name='nbno_id' value='\${nbno_id}'>`
        actionFrom.submit()
    }, false)


    document.querySelector(".btnDel").addEventListener("click", (e) => {
        e.preventDefault()
        e.stopPropagation()

        actionFrom.setAttribute("action", "/noticeboard/remove")
        actionFrom.setAttribute("method", "post")
        actionFrom.submit()


    }, false);
</script>

<script>
    const modalImage = new bootstrap.Modal(document.querySelector('#modal-image'))

    function showOrigin(fileLink) {


        document.querySelector("#targetImage").src = `/viewFile?file=\${fileLink}`

        modalImage.show()

    }
</script>

</body>
</html>

