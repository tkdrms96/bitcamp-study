<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.jsp"%>

<%--<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0">공지사항</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Admin Page</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <!-- Main row -->
                <div class="row">
                    <!-- Left col -->
                    <section class="col-lg-12">
                        <!-- TO DO List -->
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title"></h3>
<%--                                <sec:authorize access="isAuthenticated()">--%>
                                <button class ="float-right"><a href="/noticeboard/register">게시글 등록</a></button>
<%--                                </sec:authorize>--%>
                            </div>

                            <!-- /.card-header -->
                            <div class="card-body">
                                <table class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th style="width: 10%">No</th>
                                        <th style="width: 50%">제목</th>
                                        <th style="width: 10%">작성자</th>
                                        <th style="width: 20%">작성일자</th>
                                        <th style="width: 10%">조회수</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${dtoList}" var="dto">

                                    <tr  onclick="javascript:moveRead(${dto.nbno_id})">
                                        <td><c:out value="${dto.nbno_id}"></c:out></td>
                                        <td><c:out value="${dto.title}"></c:out></td>
                                        <td>admin</td>
                                        <td><c:out value="${dto.regDate}"></c:out></td>
                                        <td><c:out value="${dto.hits}"></c:out></td>
                                    </tr>

                                    </c:forEach>

                                    </tbody>
                                </table>

                                <form action="/noticeboard/list" method="get">
                                    <input type="hidden" name="page" value="1">
                                    <input type="hidden" name="size" value="${pageMaker.size}">

                                    <div class="col-sm-3">
                                    <!-- select -->

                                    <div class="form-group">
                                        <select name="type" class="custom-select" style ="float:left; width :33%; height : 40px;">
                                            <option value="" >검색조건</option>
                                            <option value="T" ${pageRequestDTO.type=="T"?"selected":""}>제목</option>
                                            <option value="TC"  ${pageRequestDTO.type=="TC"?"selected":""}>제목내용</option>
                                            <option value="C"  ${pageRequestDTO.type=="C"?"selected":""}>내용</option>
                                        </select>


                                        <div class="input-group input-group-sm" style ="float:left; width :50%; height : 40px;">
                                            <input type="text" class="form-control" style="height: 40px; width: 100px;" name="keyword" value="${pageRequestDTO.keyword}">
                                            <span class="input-group-append"><button type="submit" class="btn btn-default btn-flat">검색</button></span>
                                        </div>
                                    </div>
                                </div>
<%--                                <div class="col-sm-4">--%>

<%--                                </div>--%>
                                </form>



                            </div>
                            <!-- /.card-body -->


                            <div class="card-footer clearfix">
                                <ul class="pagination pagination-sm m-0 float-right">

                                    <c:if test="${pageMaker.prev}">
                                    <li class="page-item"><a class="page-link" href="javascript:movePage(${pageMaker.start -1})"> << </a></li>
                                    </c:if>

                                    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
                                    <li class="page-item ${pageMaker.page == num?'active':''}"><a class="page-link" href="javascript:movePage(${num})">${num}</a></li>
                                    </c:forEach>

                                    <c:if test="${pageMaker.next}">
                                        <li class="page-item"><a class="page-link" href="javascript:movePage(${pageMaker.end +1})"> >> </a></li>
                                    </c:if>

                                </ul>
                            </div>
                        </div>
                        <!-- /.card -->
                    </section>
                    <!-- /.Left col -->
                </div>
                <!-- /.row (main row) -->
            </div><!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

<div class="modal fade" id="modal-sm">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Small Modal</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>One fine body&hellip;</p>
            </div>
            <div class="modal-footer justify-content-between">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<form id="actionForm" action="/noticeboard/list" method="get">
    <input type="hidden" name="page" value="${pageMaker.page}">
    <input type="hidden" name="size" value="${pageMaker.size}">
    <c:if test="${pageRequestDTO.type != null}">
    <input type="hidden" name="type" value="${pageRequestDTO.type}">
    <input type="hidden" name="keyword" value="${pageRequestDTO.keyword}">
    </c:if>
</form>

<%@include file="../includes/footer.jsp"%>



<script>

    const actionForm = document.querySelector("#actionForm")

    const result = '${result}'

    if(result && result !== ''){
        $('#modal-sm').modal('show')

        window.history.replaceState(null, '', '/noticeboard/list');
    }

    function movePage(pageNum){

        actionForm.querySelector("input[name='page']").setAttribute("value",pageNum)
        actionForm.submit()

    }

    function moveRead(bno){

        actionForm.setAttribute("action","/noticeboard/read")
        actionForm.innerHTML +=`<input type='hidden' name='nbno_id' value='\${bno}'>`
        actionForm.submit()
    }

</script>



</body>
</html>
