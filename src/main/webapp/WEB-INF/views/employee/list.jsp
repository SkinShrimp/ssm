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
            <form class="form-inline" id="searchForm" action="/employee/list" method="post">
                <input type="hidden" name="currentPage" id="currentPage" value="1">
                <div class="form-group">
                    <label for="keyword">关键字:</label>
                    <input type="text" class="form-control" id="keyword" name="keyWord" value="${qo.keyWord}"
                           placeholder="请输入姓名/邮箱">
                </div>
                <div class="form-group">
                    <label for="dept">部门:</label>
                    <select class="form-control" id="dept" name="deptId">
                        <option value="-1">全部</option>
                        <c:forEach var="dept" items="${departments}">
                            <option value="${dept.id}">${dept.name}</option>
                        </c:forEach>
                    </select>
                    <script>
                        $("#dept option[value='${qo.deptId}']").prop("selected", true);
                    </script>
                </div>
                <input type="submit" id="btn_query" class="btn btn-default" value="查询">
                <a href="/employee/input" class="btn btn-success">添加</a>
            </form>

            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>姓名</th>
                    <th>密码</th>
                    <th>年龄</th>
                    <th>邮箱</th>
                    <th>管理员</th>
                    <th>所在部门</th>
                    <th>操作</th>
                </tr>
                </thead>
                <c:forEach items="${pageResult.result}" var="employee" varStatus="vs">
                    <tr>
                        <td>${vs.count}</td>
                        <td>${employee.name}</td>
                        <th>${employee.password}</th>
                        <th>${employee.age}</th>
                        <th>${employee.email}</th>
                        <th>${employee.admin}</th>
                        <th>${employee.department.name}</th>
                        <td>
                            <a class="btn btn-info btn-xs" href="/employee/input?id=${employee.id}">
                                <span class="glyphicon glyphicon-pencil"></span>编辑
                            </a>
                            <a href="/employee/delete?id=${employee.id}" class="btn btn-danger btn-xs">
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