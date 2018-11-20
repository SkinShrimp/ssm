<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul id="menu" class="list-group">
	<li class="list-group-item">
		<a href="#" data-toggle="collapse" data-target="#strategy_detail">
			<span>系统管理</span>
		</a>
		<ul class="in" id="strategy_detail">
			<li class="department"><a href="/department/list">部门管理</a></li>
            <li class="employee"><a href="/employee/list">员工管理</a></li>
			<li class="role"><a href="/role/list">角色管理</a></li>
			<li class="permission"><a href="/permission/list">权限管理</a></li>
		</ul>
	</li>
	<li class="list-group-item">
		<a href="#" data-toggle="collapse" data-target="#travel_detail">
			<span>客户管理</span>
		</a>
		<ul class="in" id="travel_detail">
			<li class="travel"><a href="#">潜在客户</a></li>
            <li class="audit_list"><a href="#">资源池</a></li>
            <li class="travelCommend"><a href="#">客户开发计划</a></li>
		</ul>
	</li>
	<li class="list-group-item">
		<a href="#" data-toggle="collapse" data-target="#hr_detail">
			<span>人事管理</span>
		</a>
		<ul class="in" id="hr_detail">
			<li class="user"><a href="#">员工管理</a></li>
			<li class="region"><a href="#">招聘计划</a></li>
			<li class="region"><a href="#">工资管理</a></li>
		</ul>
	</li>
	<li class="list-group-item">
		<a href="#" data-toggle="collapse" data-target="#person_detail">
			<span>个人管理</span>
		</a>
		<ul class="in" id="person_detail">
			<li class="user"><a href="#">修改密码</a></li>
            <li class="region"><a href="#">个人偏好</a></li>
			<li class="region"><a href="#">签到签退</a></li>
		</ul>
	</li>
</ul>


<script type="text/javascript">
	var url = location.pathname;
	url = url.substring(1);
    var indexE = url.indexOf("/");
    var currentMenu = url.substring(0, indexE);

    $(".in li."+currentMenu).addClass("active");
</script>
