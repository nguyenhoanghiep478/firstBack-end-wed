<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/tagLib.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Danh Sách Bài Viết</title>
</head>

<body>
    <div class="main-content">
        <form action='<c:url value="/admin-user"/>' id="submitForm">
            <div class="main-content-inner">
                <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="#">Trang chủ</a>
                        </li>
                    </ul><!-- /.breadcrumb -->
                </div>
                <div class="page-content">
                    <div class="row">
                        <div class="col-xs-12">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                    	<th>Username</th>
                                        <th>Tên người dùng </th>
                                        <th>Trạng thái</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${model.listResult}">
                                        <tr>
                                        	<td>${item.userName }</td>
                                            <td>${item.fullName}</td>
                                            <td>
                                            <c:if test="${item.status==true}">đang tồn tại
                                            </c:if>
                                            <c:if test="${item.status==false}">đã nghỉ
                                            </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <ul class="pagination" id="pagination"></ul>
                            <input type="hidden" id="page" name="page"/>
                            <input type="hidden" id="maxPageItems" name="maxPageItems"/>
                            <input type="hidden" id="sortName" name="sortName"/>
                            <input type="hidden" id="sortBy" name="sortBy"/>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div><!-- /.main-content -->
    <script type="text/javascript">
        var limit=6;
        var totalPages=${model.totalPages};
        var currentPage=${model.page};
        $(function () {
            window.pagObj = $('#pagination').twbsPagination({
                totalPages: totalPages,
                visiblePages: 10,
                startPage:currentPage,
                onPageClick: function (event, page) {        
                	if(currentPage!=page){
                		$('#page').val(page);
                        $('#maxPageItems').val(limit);   
                        $('#sortName').val('id');
                        $('#sortBy').val('desc');
                        $('#submitForm').submit();
                	} 
	              }
            });
        });
    </script>
</body>
</html>