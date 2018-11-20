<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>叩丁狼</title>
    <%@include file="../common/header.jsp" %>
</head>

<script type="text/javascript">
    $(function () {
        $("#pagination").twbsPagination({
            totalPages: ${pageResult.totalPage},//总页数
            startPage: ${qo.currentPage},//当前页
            visiblePages: ${qo.pageSize},
            first: '首页',
            prev: '上一页',
            next: '下一页',
            last: '末页',
            onPageClick: function (event, page) {
                $("#currentPage").val(page);//修改表单中的页面参数
                $("#searchForm").submit();
            }
        });

        //还原权限列表
        $("#permissionOnload_btn").click(function () {
            alert("点击了！！！");
            $.get(
                "/permission/onload",
                function (data) {
                    alert("还原权限列表!!!");
                    window.location.reload();
                }
            );
        });
    });
</script>
<body>

<div class="container " style="margin-top: 20px">
    <%@include file="../common/top.jsp" %>
    <div class="row">
        <div class="col-sm-3">
            <%@include file="../common/menu.jsp" %>
        </div>
        <div class="col-sm-9">
            <div class="row">
                <div class="col-sm-12">
                    <h1 class="page-head-line">权限管理</h1>
                </div>
            </div>
            <!--高级查询--->
            <form class="form-inline" id="searchForm" action="/permission/list" method="post">
                <input type="hidden" name="currentPage" id="currentPage" value="1">
                <input type="button" id="permissionOnload_btn" class="btn btn-primary" value="还原权限列表"></input>
            </form>

            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>权限名称</th>
                    <th>权限表达式</th>
                    <th>操作</th>
                </tr>
                </thead>
                <c:forEach items="${pageResult.result}" var="permission" varStatus="vs">
                    <tr>
                        <td>${vs.count}</td>
                        <td>${permission.name}</td>
                        <th>${permission.expression}</th>
                        <td>
                            <a href="/permission/delete?id=${permission.id}" class="btn btn-danger btn-xs">
                                <span class="glyphicon glyphicon-trash"></span>删除
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div style="text-align: center;">
                <ul id="pagination" class="pagination"></ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>