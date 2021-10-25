<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.jsp" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0">이벤트 공지사항 등록</h1>
                </div><!-- /.col -->
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Event Register</li>
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
                        <!-- form start -->
                        <form id="form1" action="/eventboard/register" method="post">






                            <div class="card-body">



                                <%--                                <div class="form-group">--%>
                                <%--                                    <label for="exampleInputEmail1">isImage</label>--%>
                                <%--                                    <input type="file" name="isImagefile">--%>
                                <%--                                </div>       isImage tag를 담는 그릇 만들기--%>

                                <div class="form-group">
                                    <label for="exampleInputEmail1">제목</label>
                                    <input type="text" name="title" class="form-control" id="exampleInputEmail1"
                                           placeholder="제목을 입력하세요">
                                </div>

                                <div class="row">
                                    <div class="col-sm-12">
                                        <!-- textarea -->
                                        <div class="form-group">
                                            <label>내용</label>
                                            <textarea name="description" class="form-control" rows="15"
                                                      placeholder="내용을 입력하세요"></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /.card-body -->

                            <div class="temp"></div>

                            <div class="card-footer">
                                <button type="submit" id="submitBtn" class="btn btn-primary">등록하기</button>
                                <button type="submit" class="btn btn-default btnList">목록가기</button>
                            </div>


                        </form>


                        <style>
                            .uploadResult {
                                display: flex;
                                justify-content: center;
                                flex-direction: row;
                                /*사진 썸네일처리 관련 css*/
                            }

                            <%-- 사진 이미지슬라이더 css--%>



                        </style>


                        <label for="exampleInputFile">파일 업로드</label>
                        <div class="input-group">
                            <div class="custom-file">
                                <input type="file" name="uploadFiles" class="custom-file-input" id="exampleInputFile"
                                       multiple>
                                <label class="custom-file-label" for="exampleInputFile">업로드할 파일을 올려주세요</label>
                            </div>

                            <div class="input-group-append">
                                <span class="input-group-text" id="uploadBtn">Upload</span>
                            </div>

                        </div>

                        <div class="uploadResult">

                        </div>


                    </div>
                    <!-- /.card -->
                </div>
            </div>
        </div>
    </section>
</div>
<!-- /.content-wrapper -->


<form id="actionForm" action="/eventboard/list" method="get">
</form>


<%@include file="../includes/footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>


<script>
    document.querySelector(".btnList").addEventListener("click", (e) => {
        e.preventDefault()
        e.stopPropagation()
        actionForm.submit();
    },false);

    const uploadResultDiv = document.querySelector(".uploadResult")

    document.querySelector("#uploadBtn").addEventListener("click", (e) => {

        const formData = new FormData()
        const fileInput = document.querySelector("input[name='uploadFiles']")

        for (let i = 0; i < fileInput.files.length; i++) {

            formData.append("uploadFiles", fileInput.files[i])
        }

        console.log(formData)

        const headerObj = {headers: {'Content-Type': 'multipart/form-data'}}

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


    }, false)

    function removeFile(Path, ele) {
        console.log(Path)
        axios.post("/removeFile", {fileName: Path}).then(response => {
            const targetDiv = ele.parentElement
            targetDiv.remove()
        })
    }


    document.querySelector("#submitBtn").addEventListener("click", (e) => {
        e.stopPropagation()
        e.preventDefault()
        //현재 화면에 있는 파일 정보를 hidden태그들로 변화
        const form1 = document.querySelector("#form1")
        const fileDivArr = uploadResultDiv.querySelectorAll("div")

        if (!fileDivArr) {

            form1.submit()

            return
        }

        let str = "";

        for (let i = 0; i < fileDivArr.length; i++) {
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

            console.log(path)
        }

        document.querySelector(".temp").innerHTML = str
        //form1.innerHTML += str
        form1.submit()
        //form을 submit

    }, false)

</script>


</body>
</html>


