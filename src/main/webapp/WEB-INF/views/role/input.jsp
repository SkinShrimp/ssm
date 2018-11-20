<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="../common/header.jsp" %>
</head>
<script type="text/javascript">
    function moveSelected(src, target) {
        $("." + target).append($("." + src + " option:selected"));
    }

    function moveAll(src, target) {
        $("." + target).append($("." + src + " option"));
    }

    $(function () {
        $("#btn_submit").click(function () {
            $(".selfPermissions option").prop("selected", true);
            $("#editForm").submit();
        });

        //消除重复
        var selfPermissionsArr = $.map($(".selfPermissions option"), function (value, index) {
            return $(value).val();
        });
        $.each($(".allPermissions option"), function (index, value) {
            if ($.inArray($(value).val(), selfPermissionsArr) != -1) {
                $(value).remove();
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
                    <h1 class="page-head-line">角色编辑</h1>
                </div>
            </div>
            <div class="row col-sm-10">
                <form class="form-horizontal" action="/role/saveOrUpdate" method="post" id="editForm">
                    <input type="hidden" value="${role.id}" name="id">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">角色名：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="name" name="name" value="${role.name}"
                                   placeholder="请输入角色名">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="sn" class="col-sm-2 control-label">简称：</label>
                        <div class="col-sm-6">
                            <input type="sn" class="form-control" id="sn" name="sn"
                                   value="${role.sn}" placeholder="请输入简称">
                        </div>
                    </div>

                    <div class="form-group" id="permission">
                        <div>
                            <label for="permission" class="control-label" style="margin-left: 60px">权限：</label>
                        </div>
                        <div class="row" style="margin-top: 10px">
                            <div class="col-sm-4 col-sm-offset-1">
                                <select multiple class="form-control allPermissions" size="15">
                                    <c:forEach items="${permissions}" var="permission">
                                        <option value="${permission.id}">${permission.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="col-sm-2" style="margin-top: 60px;" align="center">
                                <div>
                                    <a type="button" class="btn btn-info  " style="margin-top: 10px"
                                       onclick="moveSelected('allPermissions', 'selfPermissions')">&nbsp;&gt;&nbsp;</a>
                                    <br>
                                    <a type="button" class="btn btn-info " style="margin-top: 10px"
                                       onclick="moveSelected('selfPermissions', 'allPermissions')">&nbsp;&lt;&nbsp;</a>
                                    <br>
                                    <a type="button" class="btn btn-info " style="margin-top: 10px"
                                       onclick="moveAll('allPermissions', 'selfPermissions')">&gt;&gt;</a>
                                    <br>
                                    <a type="button" class="btn btn-info " style="margin-top: 10px"
                                       onclick="moveAll('selfPermissions', 'allPermissions')">&lt;&lt;</a>
                                </div>
                            </div>

                            <div class="col-sm-4">
                                <select multiple class="form-control selfPermissions" size="15" name="permissionIds">
                                    <c:forEach items="${role.permissonList}" var="permission">
                                        <option value="${permission.id}">${permission.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-1 col-sm-6">
                            <button id="btn_submit" class="btn btn-default">保存</button>
                            <button type="reset" class="btn btn-default">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>