<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<script type="text/javascript"
	src="http://www.baiyangwang.com/Static/Public/Shop/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#search").click(
				function() {
					var keyWord = $("#keyWord").val();
					$.ajax({
						type : "POST",
						url : "es/searchIndex.do",
						//traditional:true,
						data : {
							'keyWord' : keyWord,
						},
						dataType : "json",
						success : function(data) {
							if (data.status == 'ok') {
								$("#result").empty();
								$.each(data.proArr,
										function(i, Pro) {
											//select_add(Brands.brandId,Brands.brandName,'PPList');
											$("#result").append(
													"<li>" + Pro.productName
															+ "</li>");
										});
							} else {
								alert('检查输入的内容!');
							}
						},
						error : function() {
							alert("网络连接出错!");
						}
					});
				});
	})
</script>
</head>
<body style="text-align: center">
	<div
		style="margin: 60px auto; width: 500px; height: 200px; border: 1px solid #F00">
		<div style="margin: 90px auto;">
			<input type="text" name="keyWord" id="keyWord" style="width: 200px"
				value="" placeholder="请输入搜索信息" /> <input type="button" value="搜索"
				id="search" /> <br />
		</div>
	</div>
	<div>
		<ul id="result">
		</ul>
	</div>
</body>
</html>