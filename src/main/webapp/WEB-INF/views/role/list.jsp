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
        console.log("=================");
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
                    <h1 class="page-head-line">员工管理</h1>
                </div>
            </div>
            <!--高级查询--->
            <form class="form-inline" id="searchForm" action="/role/list" method="post">
                <input type="hidden" name="currentPage" id="currentPage" value="1">
                <a href="/role/input" class="btn btn-success">添加</a>
            </form>

            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>角色名称</th>
                    <th>简称</th>
                    <th>操作</th>
                </tr>
                </thead>
                <c:forEach items="${pageResult.result}" var="role" varStatus="vs">
                    <tr>
                        <td>${vs.count}</td>
                        <td>${role.name}</td>
                        <th>${role.sn}</th>
                        <td>
                            <a class="btn btn-info btn-xs" href="/role/input?id=${role.id}">
                                <span class="glyphicon glyphicon-pencil"></span>编辑
                            </a>
                            <a href="/role/delete?id=${role.id}" class="btn btn-danger btn-xs">
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