<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.jsp" %>


<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0">이벤트 공지사항</h1>
                </div><!-- /.col -->
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">이벤트 공지사항</li>
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

                        <c:if test="${eventBoardDTO.files[0].uuid != null}">
                            <div id="slideShow">
                                <ul class="slides">
                                    <c:forEach items="${eventBoardDTO.files}" var="attach">
                                        <c:if test="${attach.image}">
                                            <li><img onclick="javascript:showOrigin('${attach.getFileLink()}')"
                                                     src="/eventboard/viewFile?file=${attach.img_thumbnail_name}"></li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                                <p class="controller"> <!-- &lang: 왼쪽 방향 화살표 &rang: 오른쪽 방향 화살표 -->
                                    <span class="prev"> &lang; </span> <span class="next"> &rang; </span>
                                </p>
                            </div>
                        </c:if>


                        <div class="card-body">
                            <div class="form-group">
                                <label for="exampleInputEmail10">게시글번호</label>
                                <input type="text" name="bno" class="form-control" id="exampleInputEmail10"
                                       value="<c:out value="${eventBoardDTO.enbno_id}"></c:out>" readonly>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">제목</label>
                                <input type="text" name="title" class="form-control" id="exampleInputEmail1"
                                       value="<c:out value="${eventBoardDTO.title}"></c:out>" readonly>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <!-- textarea -->
                                    <div class="form-group">
                                        <label>내용</label>
                                        <textarea name="content" class="form-control" rows="15" disabled><c:out
                                                value="${eventBoardDTO.description}"></c:out>
                                        </textarea>
                                    </div>
                                </div>
                            </div>

                            <%--첨부파일 목록에 대한 css 와 html 코드--%>

                            첨부파일[<span id="toc-toggle" onclick="openCloseToc()">DownLoad</span>]
                            <ol id="toc-content">
                                <c:forEach items="${eventBoardDTO.files}" var="attach">
                                    <li>
                                        <a href="/eventboard/downFile?file=${attach.getFileLink()}">${attach.fileName}</a>
                                        <br></li>
                                </c:forEach>
                            </ol>

                            <%--CSS코드 --%>
                            <style>
                                #toc-content {
                                    display: none;
                                }

                                #toc-toggle {
                                    cursor: pointer;
                                    color: #2962ff;
                                }

                                #toc-toggle:hover {
                                    text-decoration: underline;
                                }
                            </style>


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

                    <div class="card direct-chat direct-chat-primary">
                        <div class="card-header">
                            <h3 class="card-title">댓글</h3>
                            <div class="card-tools">
                                <span class="badge badge-primary addReplyBtn">댓글 달기</span>
                                <button type="button" class="btn btn-tool" data-card-widget="collapse">
                                    <i class="fas fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-tool" title="Contacts"
                                        data-widget="chat-pane-toggle">
                                    <i class="fas fa-comments"></i>
                                </button>
                                <button type="button" class="btn btn-tool" data-card-widget="remove">
                                    <i class="fas fa-times"></i>
                                </button>
                            </div>
                        </div>
                        <!-- /.card-header -->


                        <div class="card-body">
                            <!-- Conversations are loaded here -->
                            <div class="direct-chat-messages">

                            </div>
                            <!--/.direct-chat-messages-->
                        </div>

                        <%--댓글이 들어갈 곳--%>

                        <div class="card-footer clearfix replyPagingDiv">



                        </div>
                        <%--/댓글이 들어갈 곳--%>


                    </div>
                    <!-- /.cardfooter -->

                </div>


            </div>
        </div>

    </section>

</div>
<!-- /.content-wrapper -->

<form id="actionForm" action="/eventboard/list" method="get">
    <input type="hidden" name="page" value="${pageRequestDTO.page}">
    <input type="hidden" name="size" value="${pageRequestDTO.size}">
    <c:if test="${pageRequestDTO.type != null}">
        <input type="hidden" name="type" value="${pageRequestDTO.type}">
        <input type="hidden" name="keyword" value="${pageRequestDTO.keyword}">
    </c:if>
    <input type="hidden" name="enbno_id" value="${eventBoardDTO.enbno_id}">
</form>
<%--submit할때 가지고갈 actionform임 --%>


<%--<form id="replyActionForm" action="/replies/list/${eventBoardDTO.enbno_id}" method="get">--%>
<%--    <input type="hidden" name="page" value="${pageMaker.page}">--%>
<%--    <input type="hidden" name="size" value="10">--%>
<%--</form>--%>


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

<div class="modal fade" id="modal-sm">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Reply</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" name="replyer" value="admin" readonly>
                <input type="text" name="reply">
            </div>
            <div class="modal-footer justify-content-between">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary operBtn">Save changes</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<div class="modal fade" id="modal-lg">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Modify/Remove</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="hidden" name="encno_id">
                <input type="text" name="replyerMod" value="admin" readonly>
                <%--                임시로 value admin 넣어놓음--%>
                <input type="text" name="replyMod">

            </div>

            <%--            좋아요 OR 싫어요--%>


            <div class="modal-footer justify-content-between">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-info btnModReply">Modify</button>
                <button type="button" class="btn btn-danger btnRem">Remove</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<div class="modal fade" id="modal-reply">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">답글달기</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" name="replyer" value="admin" readonly>
                <input type="text" name="replymodalbtn">
            </div>
            <div class="modal-footer justify-content-between">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary operReplyBtn">Save changes</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
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

    if (slides) {
        slides.style.width = (slideWidth + slideMargin) * slideCount + "px";
    }

    function moveSlide(num) {
        slides.style.left = -num * 400 + "px";
        currentIdx = num;
    }

    if (prev) {
        prev.addEventListener('click', function () {
            if (currentIdx !== 0) moveSlide(currentIdx - 1);
        });
    }

    if (next) {
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


        actionFrom.setAttribute("action", "/eventboard/modify")
        // actionForm.innerHTML += `<input type='hidden' name='nbno_id' value='\${nbno_id}'>`
        actionFrom.submit()
    }, false)


    document.querySelector(".btnDel").addEventListener("click", (e) => {
        e.preventDefault()
        e.stopPropagation()

        actionFrom.setAttribute("action", "/eventboard/remove")
        actionFrom.setAttribute("method", "post")
        actionFrom.submit()


    }, false);
</script>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="/resources/js/reply.js"></script>


<script>
    const modalImage = new bootstrap.Modal(document.querySelector('#modal-image'))

    function showOrigin(fileLink) {

        document.querySelector("#targetImage").src = `/viewFile?file=\${fileLink}`

        modalImage.show()

    }


    function getList(page) {
        const target = document.querySelector(".direct-chat-messages")
        const replyPagingTarget = document.querySelector(".replyPagingDiv")
        const enbno_id = '${eventBoardDTO.enbno_id}' //230

        function convertTemp(replyObj) {
            console.log("여기다 convertTemp")
            console.log(replyObj)

            const {encno_id, enbno_id, comment, regDate, modDate, level, sequence, parent, isDelete} = {...replyObj} //tbl_member_id 날림

            const levelValue = level === 1 ? "40px;" : "0px;"
            const levelText = level === 1 ? "re:" : ""
            const levelButton = level === 1 ? "" : "답글 달기"

            const temp = `<div class="direct-chat-msg" style="margin-left: \${levelValue}>">
                <div class="direct-chat-infos clearfix">
                    <span class="direct-chat-name float-left">\${encno_id}     -----   admin &nbsp;</span>
                    <span class="badge badge-primary" onclick="javascript:startAddLevelReply('\${regDate}', '\${encno_id}', '\${level}', '\${sequence}', '\${parent}','\${enbno_id}')">\${levelButton}</span>
                    <span class="direct-chat-timestamp float-right">\${regDate}</span>
                </div>
                <div class="direct-chat-text" data-encno_id='\${encno_id}'>\${levelText} \${isDelete ? "삭제된 댓글입니다" : comment}</div>
            </div>
            `

            return temp
        }


        function convertPaging(data){

            let pagingNum = "<ul class='pagination pagination-sm m-0 float-right'>";


            const {count, dtoList, pageMaker} = {...data}

            console.log(pageMaker.page)
            console.log(pageMaker)
            console.log("pageMakertest")

            if(pageMaker.prev){
                pagingNum += `<li class="page-item"><a class="page-link" onclick="javascript:prevReplyPage(\${pageMaker.start-1})"> << </a></li>`
            }

            for(let i = pageMaker.start; i < pageMaker.end + 1; i++ ){
                 pagingNum += `<li class="page-item"><a class="page-link" onclick="javascript:moveReplyPage(\${i})">\${i}</a></li>`

            }

            if(pageMaker.next){

                pagingNum += `<li class="page-item"><a class="page-link" onclick="javascript:nextReplyPage(\${pageMaker.end + 1})"> >> </a></li>`
            }

            pagingNum += "</ul>"


            replyPagingTarget.innerHTML = pagingNum



        }




        getReplyList(enbno_id,page).then(data => {
            console.log("pageNumtest start")

            console.log(page)
            console.log("pageNumtest")

            let str = "";

            data.dtoList.forEach(reply => {
                str += convertTemp(reply)
            })
            //pageMaker
            convertPaging(data)

            target.innerHTML = str
        })




    }

    //최초 실행
    getList(1)


    const modalDiv = $("#modal-sm")

    document.querySelector(".addReplyBtn").addEventListener("click", function () {
        modalDiv.modal('show')
    }, false)

    document.querySelector(".operBtn").addEventListener("click", function () {

        const replyerInput = document.querySelector("input[name='replyer']")
        const replyInput = document.querySelector("input[name='reply']")

        <%--const encno_id = '${ .encno_id}'--%>

        // console.log(encno_id)

        const enbno_id = '${eventBoardDTO.enbno_id}'

        // const encno_id = document.querySelector("input[name='encon_id']")

        const comment = replyInput.value
        // const tbl_member_id = admin // admin 고정됨으로 admin으로 박아놓음 replyInput.value를 지움

        const replyObj = {enbno_id, comment, replyerInput} // tbl_member_id 는 아직 아이디 구현 안되었으니 안나옴 ,encno_id


        addReply(replyObj).then(result => {
            getList(1)
            modalDiv.modal('hide')
            // replyerInput.value =""
            replyInput.value = ""
        })

    }, false)

    //수정/삭제 dom
    const modModal = $("#modal-lg")
    // const modReplyer =  document.querySelector("input[name='replyerMod']")
    const modReply = document.querySelector("input[name='replyMod']")
    const modRno = document.querySelector("input[name='encno_id']")


    document.querySelector(".direct-chat-messages").addEventListener("click", (e) => {
        //dom 관련

        const target = e.target
        const enbno_id = '${eventBoardDTO.enbno_id}'

        if (target.matches(".direct-chat-text")) {
            const rno = target.getAttribute("data-encno_id")
            // const replyer = target.getAttribute("data-tbl_member_id")
            const comment = target.innerHTML
            modRno.value = rno
            modReply.value = comment
            // modReplyer.value = replyer

            // console.log(replyer)
            document.querySelector(".btnRem").setAttribute("data-encno_id", rno)

            modModal.modal('show')

        }

    }, false)

    document.querySelector(".btnRem").addEventListener("click", (e) => {
        const encno_id = e.target.getAttribute("data-encno_id")
        removeReply(encno_id).then(result => {
            getList(1)
            modModal.modal("hide")
        })

    }, false)

    document.querySelector(".btnModReply").addEventListener("click", (e) => {


        const replyObj = {encno_id: modRno.value, comment: modReply.value}


        modifyReply(replyObj).then(result => {
            getList(1)
            modModal.modal("hide")

        })
    }, false)


    const levelReplyModal = $("#modal-reply")

    let regDate, encno_id, level, sequence, parent, enbno_id;

    function startAddLevelReply(regDate1, encno_id1, level1, sequence1, parent1, enbno_id1) {

        regDate = regDate1
        encno_id = encno_id1
        level = level1
        sequence = sequence1
        parent = parent1
        enbno_id = enbno_id1

        levelReplyModal.modal('show')

    }

    document.querySelector(".operReplyBtn").addEventListener("click", function (e) {

        e.preventDefault();
        e.stopPropagation();

        const reply = document.querySelector("input[name='replymodalbtn']")
        const comment = reply.value

        let levelReplyObj = {
            regDate: regDate,
            encno_id: encno_id,
            level: level,
            sequence: sequence,
            parent: parent,
            enbno_id: enbno_id,
            comment: comment
        }


        addLevelReply(levelReplyObj).then(result => {


            levelReplyModal.modal("hide")
            reply.value = ""
            getList(1)
        }, false)
    })

    // const replyActionForm = document.querySelector("#replyActionForm")


    function moveReplyPage (page) {
        // replyActionForm.querySelector("input[name='page']").setAttribute("value", pageNum)

        getList(page)

    }

    function prevReplyPage (page){
        console.log(page)
        getList(page)
    }

    function nextReplyPage(page){

        console.log(page)
        getList(page)
    }



</script>

<%-- 첨부파일 download에 대한 자바스크립트 코드--%>
<script>
    function openCloseToc() {
        if (document.getElementById('toc-content').style.display === 'block') {
            document.getElementById('toc-content').style.display = 'none';
            document.getElementById('toc-toggle').textContent = 'downLoad';
        } else {
            document.getElementById('toc-content').style.display = 'block';
            document.getElementById('toc-toggle').textContent = '숨기기';
        }
    }
</script>

</body>
</html>


