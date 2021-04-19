<%@ page pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8"/>
</head>
	<!-- 
	frameset标签必须要放在head和body之间
	 -->
	<frameset rows="14%,86%" frameborder="0">
		<frame src="${pageContext.request.contextPath}/top" />
		<frameset cols="180px,*">
			<frame src="${pageContext.request.contextPath}/left" />
			<frame src="${pageContext.request.contextPath}/right" name="rightFrame"/>
		</frameset>
	</frameset>
	
<body>
	
</body>
</html>