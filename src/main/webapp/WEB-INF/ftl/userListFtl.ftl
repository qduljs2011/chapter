<#import "spring.ftl" as spring />
<html>
	<head>
		<title>baobaotao</title>
	</head>
	<body>
		<table>
			<#list userList as user>
				<tr>
					<td>${user.userName}</td>
					<td>${user.lastVisit?string("yyyy-MM-dd")}</td>
				</tr>
	
			</#list>
		</table>
	</body>
</html>