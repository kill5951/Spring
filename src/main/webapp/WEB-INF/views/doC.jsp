<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WEB-INF/views/doC.jsp</h1>

	<!-- 둘다 사용 가능하지만 el표현식을 사용할 예정임
	 왜냐하면 데이터가 null일때 자동으로 빈공백으로 출력됨(컴파일에러가안남), 같은상황일시 스크립틀릿코드는 컴파일에러가뜸 -->
	<h2> 전달 데이터 : <%=request.getParameter("msg") %> </h2>
	<h2> 전달 데이터(el) : ${msg }</h2> 
	
</body>
</html>