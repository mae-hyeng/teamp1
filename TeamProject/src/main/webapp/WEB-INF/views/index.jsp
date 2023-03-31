<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button onclick = "saveReq()">글작성</button>
	<a href = "/save">글작성</a>
</body>

<script>
	const saveReq = () => {
		location.herf = "/board/save";
	}
</script>
</html>