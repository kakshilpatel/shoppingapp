<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>Welcome Page</title>
</head>
<body>
	<h1>Welcome to online store!</h1>
	<form action="<%=request.getContextPath()%>/product" method="post">
		<input type="submit" value="Product List">
	</form>
	<form action="<%=request.getContextPath()%>/cart" method="post">
		<input type="submit" value="My Cart">
	</form>
</body>
</html>