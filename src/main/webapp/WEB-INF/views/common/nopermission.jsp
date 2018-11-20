<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>叩丁狼客户管理系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="/static/css/error_css.css" rel="stylesheet" type="text/css" />
	<%@include file="../common/header.jsp"%>
</head>
<body>

<div class="container " style="margin-top: 20px">
	<%@include file="../common/top.jsp"%>
	<div class="row">
		<div class="col-sm-3">
			<%@include file="../common/menu.jsp"%>
		</div>
		<div class="col-sm-9">
			<div class="row">
				<div class="col-sm-12">
					<h1 class="page-head-line">权限信息</h1>
				</div>
				<div class="row col-sm-10" >
					<div id="login_center">
						<div id="login_area">
							<div id="login_box">
								<div id="login_form">
									<H2>你没有执行该操作的权限！</H2>
									<span>请联系管理员解决！</span>
									<span>联系电话：020-29007520</span>
									<span>联系邮件：service@wolfcode.cn</span>
									<span>&copy;广州狼码教育科技有限公司</span>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>

		</div>
	</div>
</div>
</body>
</html>

