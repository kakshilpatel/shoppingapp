<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Your Shopping Cart</h1>
	<table border="1" cellspacing="5">
		<tr aling="center">
			<th>Quantity</th>
			<th>Name</th>
			<th>Price</th>
			<th>Amount</th>
			<th />
		</tr>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<c:forEach var="item" items="${cart.items}">
			<tr valign="top">
				<td align="center">
					<form action="<c:url value='/cart'/>" method="post">
						<input type="hidden" name="product_Name"
							value="${item.product.name}"> <input type=text size=2
							name="quantity" value="${item.quantity}"> <input
							type="submit" value="Update">
					</form>
				</td>
				<td align="center">${item.product.name}</td>
				<td align="right">${item.product.priceCurrencyFormat}</td>
				<td align="right">${item.totalCurrencyFormat}</td>
				<td>
					<form action="<c:url value='/cart' />" method="post">
						<input type="hidden" name="product_Name"
							value="${item.product.name}"> <input type="hidden"
							name="quantity" value="0"> <input type="submit"
							value="Remove Item">
					</form>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<p>
					<b>To change the quantity</b>, enter the new quantity and click on
					the Update button.
				</p>
			</td>
		</tr>
	</table>
	<form action="product" method="post">
		<input type="submit" value="Go on shopping" />
	</form>
	<form action="<c:url value='/checkout.jsp' />" method="post">
		<input type="submit" value="Check out" name="checkout" />
	</form>
</body>
</html>