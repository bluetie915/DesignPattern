<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<br><br>
	<a href="springmvc/testViewAndViewResolver">Test ViewAndViewResolver</a>
	
	<!-- 
		模拟修改操作
		1.原始数据为：1,Tom,123456,Tom@qq.com,12
		2.密码不能修改
		3.表单回显，模拟操作直接在表单填写对应的属性值
	-->
	<br><br>
	<form action="springmvc/testModelAttribute" method="post">
		<input type="hidden" name="id" value="1"/>
		username:<input type="text" name="username" value="Tom"/>
		<br>
		enail:<input type="text" name="email" value="Tom@qq.com"/>
		<br>
		age:<input type="text" name="age" value="12"/>
		<br>
		<input type="submit" value="Submit"/>
	</form>

	<br><br>
	<a href="springmvc/testSessionAttributes">Test SessionAttributes</a>
	
	<br><br>
	<a href="springmvc/testMap">Test Map</a>
	
	<br><br>
	<a href="springmvc/testModelAndView">Test ModelAndView</a>
	
	<br><br>
	<a href="springmvc/testServletAPI">Test ServletAPI</a>

	<br><br>
	<form action="springmvc/testPojo" method="post">
		username:<input type="text" name="username"/>
		<br>
		password:<input type="password" name="password"/>
		<br>
		email:<input type="text" name="email"/>
		<br>
		age:<input type="text" name="age"/>
		<br>
		city:<input type="text" name="address.city"/>
		<br>
		province:<input type="text" name="address.province"/>
		<br>
		<input type="submit" value="Submit"/>
	</form>

	<br><br>
	<a href="springmvc/testCookieValue">Test CookieValue</a>
	
	<br><br>
	<a href="springmvc/testRequestHeader">Test RequestHeader</a>
	
	<br><br>
	<a href="springmvc/testRequestParam?username=zhangsan&age=11">Test RequestParam</a>
	
	<br><br>
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT"/> 
		<input type="submit" value="Test Rest PUT"/>
	</form>
	
	<br><br>
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="Test Rest DELETE"/>
	</form>
	
	<br><br>
	<form action="springmvc/testRest" method="post">
		<input type="submit" value="Test Rest POST"/>
	</form>
	
	<br><br>
	<a href="springmvc/testRest/1">Test Rest GET</a>
	
	<br><br>
	<a href="springmvc/testPathVariable/1">Test PathVariable</a>
	
	<br><br>
	<a href="springmvc/testAntPath/lalala/abc">Test AntPath</a>

	<br><br>
	<a href="springmvc/testParamsAndHeaders?username=zhangsan&age=10">Test ParamsAndHeaders</a>

	<br><br>
	<form action="springmvc/testMethod" method="post">
		<input type="submit" value="Submit">
	</form>
	
	<br><br>
	<a href="helloworld">Hello World</a>
	
	<br><br>
	<a href="helloworld">Hello World</a>
</body>
</html>