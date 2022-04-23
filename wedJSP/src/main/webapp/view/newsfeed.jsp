<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/tagLib.jsp"%>
<c:url value="/api-comment" var="APIurl" />
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>newsfeed</title>
</head>

<body>
    <div class="container">
        <div class="col-md-7">
            <c:forEach var="item" items="${newsModel.listResult}">
                <div class="social-feed-box">
                    <div class="pull-right social-action dropdown">
                        <button data-toggle="dropdown" class="dropdown-toggle btn-white">
                            <i class="fa fa-angle-down"></i>
                        </button>
                        <ul class="dropdown-menu m-t-xs">
                            <li><a href="#">Config</a></li>
                        </ul>
                    </div>
                    <div class="social-avatar">
                        <a href="" class="pull-left">
                            <img alt="image" src="https://bootdey.com/img/Content/avatar/avatar1.png">
                        </a>
                        <div class="media-body">
                            <a href="#">
                                Andrew Williams
                            </a>
                            <small class="text-muted">Today 4:21 pm - 12.06.2014</small>
                        </div>
                    </div>
                    <div class="social-body">
                        <p>
                            Many desktop publishing packages and web page editors now use Lorem Ipsum as their
                            default model text, and a search for 'lorem ipsum' will uncover many web sites still
                            in their infancy. Packages and web page editors now use Lorem Ipsum as their
                            default model text.
                        </p>

                        <div class="btn-group">
                            <button class="btn btn-white btn-xs"><i class="fa fa-thumbs-up"></i> Like this!</button>
                            <button class="btn btn-white btn-xs"><i class="fa fa-comments"></i> Comment</button>
                            <button class="btn btn-white btn-xs"><i class="fa fa-share"></i> Share</button>
                        </div>
                    </div>
                    <div class="social-footer">
                        <c:forEach var="commentItem" items="${commentModel.listResult}">
                            <div class="social-comment">
                                <a href="" class="pull-left">
                                    <img alt="image" src="https://bootdey.com/img/Content/avatar/avatar1.png">
                                </a>
                                <div class="media-body"> 
                                    <a href="#">
                                    ${commentItem.userName}
                                    </a>
                                    ${commentItem.content}
                                    <br>
                                    <a href="#" class="small"><i class="fa fa-thumbs-up"></i> 11 Like this!</a> -
                                    <small class="text-muted">10.07.2014</small>
                                </div>
                            </div>
                        </c:forEach>

                        <div class="social-comment" >
                            <a href="" class="pull-left">
                                <img alt="image" src="https://bootdey.com/img/Content/avatar/avatar1.png">
                            </a>
                            <div class="media-body" style="display: inline-block;width:95%;">
                                <form id="commentForm">
                                    <textarea class="form-control" id="commentField" name="content" style="resize: none;"
                                        placeholder="Write comment..."></textarea>
                                    <input type="hidden" name="userId" value="${userModel.id}">
                                    <input type="hidden" name="newsId" value="${item.id}">
                                    <input type="submit" id="commentSubmit" value="gửi"
                                        style="margin-left: 95%;margin-top : 10px;height: 30px;width: 60px;">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <script type="text/javascript">
                $(document).ready(function () {


                })

                $('form').each(function () {
                    $(this).on('submit', function (e) {
                        e.preventDefault();
                        var data = {};
                        var formData = $(this).serializeArray();
                        $.each(formData, function (i, v) {
                            data["" + v.name + ""] = v.value;
                        });
                        if ($('#commentField').val() != '') {
                            addComment(data);
                            $('#commentField').val('');
                        }
                    });
                });

                function addComment(data) {
                    $.ajax({
                        url: '${APIurl}',
                        type: 'POST',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        dataType: 'text',
                        success: function (result) {}
                    });
                }
            </script>
</body>

</html>