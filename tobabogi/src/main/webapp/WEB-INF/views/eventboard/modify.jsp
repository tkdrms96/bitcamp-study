<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0">게시글 수정</h1>
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

                        <!-- /.card-header -->
                        <form id="form1">
                            <input type="hidden" name="page" value="${pageRequestDTO.page}">
                            <input type="hidden" name="size" value="${pageRequestDTO.size}">
                            <c:if test="${pageRequestDTO.type != null}">
                                <input type="hidden" name="type" value="${pageRequestDTO.type}">
                                <input type="hidden" name="keyword" value="${pageRequestDTO.keyword}">
                            </c:if>

                            <div class="card-body">
                                <div class="form-group">
                                    <label for="exampleInputEmail10">게시글번호</label>
                                    <input type="text" name="enbno_id" class="form-control" id="exampleInputEmail10" value="<c:out value="${eventBoardDTO.enbno_id}"></c:out>" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">제목</label>
                                    <input type="text" name="title" class="form-control" id="exampleInputEmail1" value="<c:out value="${eventBoardDTO.title}"></c:out>" ></div>

                                <div class="row">
                                    <div class="col-sm-12">
                                        <!-- textarea -->
                                        <div class="form-group">
                                            <label>내용</label>
                                            <textarea name="description" class="form-control" rows="15" ><c:out value="${eventBoardDTO.description}"></c:out></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="temp"></div>
                            <!-- /.card-body -->

                            <div class="card-footer">
                                <button type="submit" class="btn btn-default btnList">목록가기</button>
                                <button type="submit" class="btn btn-info btnMod">수정하기</button>
                            </div>
                        </form>
                    </div>

                    <label for="exampleInputFile">File input</label>
                    <div class="input-group">
                        <div class="custom-file">
                            <input type="file" name="uploadFiles" class="custom-file-input" id="exampleInputFile" multiple>
                            <label class="custom-file-label" for="exampleInputFile">Choose file</label>
                        </div>
                        <div class="input-group-append">
                            <span class="input-group-text" id="uploadBtn">Upload</span>
                        </div>
                    </div>

                    <div class="uploadResult">
                        <c:if test="${eventBoardDTO.files[0].uuid != null}">
                            <c:forEach items="${eventBoardDTO.files}" var="attach">
                                <div data-uuid="${attach.uuid}"
                                     data-filename="${attach.fileName}"
                                     data-path="${attach.Path}"
                                     data-isimage="${attach.image}"
                                     data-img_thumbnail_name="${attach.img_thumbnail_name}">

                                    <c:if test="${attach.image}">
                                        <img src="/eventboard/viewFile?file=${attach.img_thumbnail_name}">
                                    </c:if>

                                    <span>${attach.fileName}</span>
                                    <button onclick="javascript:removeDiv(this)">x</button>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>


                    <!-- /.card -->
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
</form>


<%@include file="../includes/footer.jsp"%>





<script>
    const form = document.querySelector("#form1")
    const actionForm = document.querySelector("#actionForm")

    document.querySelector(".btnList").addEventListener("click", (e) => {
        e.preventDefault()
        e.stopPropagation()
        actionForm.submit();
    },false);


    document.querySelector(".btnMod").addEventListener("click", (e) => {
        e.preventDefault()
        e.stopPropagation()

        const fileDivArr = uploadResultDiv.querySelectorAll("div")

        if(fileDivArr && fileDivArr.length > 0){
            let str ="";
            for(let i = 0; i < fileDivArr.length; i++){
                const target = fileDivArr[i]
                const uuid = target.getAttribute("data-uuid")
                const fileName = target.getAttribute("data-filename")
                const path = target.getAttribute("data-path")
                const image = target.getAttribute("data-isimage")
                const img_thumbnail_name = target.getAttribute("data-img_thumbnail_name")

                str += `<input type='hidden' name='files[\${i}].uuid' value='\${uuid}' >`
                str += `<input type='hidden' name='files[\${i}].fileName' value='\${fileName}' >`
                str += `<input type='hidden' name='files[\${i}].path' value='\${path}' >`
                str += `<input type='hidden' name='files[\${i}].img_thumbnail_name' value='\${img_thumbnail_name}' >`
                str += `<input type='hidden' name='files[\${i}].image' value='\${image}' >'`
            }
            document.querySelector(".temp").innerHTML = str
        }//end if

        form.setAttribute("action","/eventboard/modify")
        form.setAttribute("method","post")
        form.submit()

    },false);


</script>


<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<script>

    const uploadResultDiv = document.querySelector(".uploadResult")

    document.querySelector("#uploadBtn").addEventListener("click",(e) => {

        const formData = new FormData()
        const fileInput = document.querySelector("input[name='uploadFiles']")

        for(let i = 0; i < fileInput.files.length; i++){

            //console.log(fileInput.files[i])

            formData.append("uploadFiles", fileInput.files[i])
        }

        console.log(formData)

        const headerObj = { headers: {'Content-Type': 'multipart/form-data'}}

        axios.post("/eventboard/upload", formData, headerObj).then((response) => {
            const arr = response.data
            console.log(arr)
            let str = ""
            for (let i = 0; i < arr.length; i++) {
                const {uuid, fileName, path, image, img_thumbnail_name, fileLink} = {...arr[i]}

                console.log(arr[i])

                if (image) {
                    str += `<div data-uuid='\${uuid}' data-filename='\${fileName}' data-path='\${path}' data-isimage='\${image}' data-img_thumbnail_name='\${img_thumbnail_name}'>
                            <img src='/eventboard/viewFile?file=\${img_thumbnail_name}'/>
                            <br><span>\${fileName}</span>
                            <button onclick="javascript:removeFile('\${fileLink}',this)" >x</button></div>`
                } else {
                    str += `<div data-uuid='\${uuid}'data-filename='\${fileName}' data-path='\${path}' data-isimage='\${image}'><a href='/eventboard/downFile?file=\${fileLink}'>\${fileName}</a>
                    <button onclick="javascript:removeFile('\${fileLink}',this)" >x</button></div></div>`
                }


            }//end for
            uploadResultDiv.innerHTML += str

        })



    },false)

    function removeDiv(ele){
        ele.parentElement.remove()
    }

</script>

</body>
</html>
