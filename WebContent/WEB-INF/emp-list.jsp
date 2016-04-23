<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.11.3.js"></script>

<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var $tr = $(this).parent().parent();
			var flag = confirm("确认删除" + $(this).next(":input").val() + "的信息!");
			var url = $(this).attr("href");
			var data = {"time":new Date()};
			$.post(url, data, function(response){
				if(response == 0){
					alert("删除失败!");
				}
				else{
					$tr.remove();
					alert("删除成功!");
				}
			});
			return false;
		});
	});
</script>
</head>
<body>
	<h4>员工名单</h4>
	<s:if test="#request.employees == null || #request.employees.size() == 0">
		暂时没有员工信息, 请确认
	</s:if>
	<s:else>
		<table border=1>
			<tr>
				<th>ID</th>
				<th>LAST_NAME</th>
				<th>EMAIL</th>
				<th>BIRTH</th>
				<th>CREATETIME</th>
				<th>DEPT</th>
				<th>DELETE</th>
			</tr>
			<s:iterator value="#request.employees">
				<tr>
					<td>${id }</td>
					<td>${lastName }</td>
					<td>${email }</td>
					<td>${birth }</td>
					<td>${createTime }</td>
					<td>${department.deptName }</td>
					<td>
						<a href="testSSH-delete?id=${id }" class="delete">删除</a>
						<input type="hidden" value="${lastName}"/>
					</td>
				</tr>
			</s:iterator>
		</table>
	</s:else>
	
</body>
</html>