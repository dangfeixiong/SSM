<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>updateGoodsDisplay</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/goods/updateGoodsDisplay.action" method="post">
	商品ID:<input type="text" name="id" value="${good.id}" /><br/>
	商品名称:<input type="text" name="name" value="${good.name}" /><br/>
	生产日期:<input type="text" name="productDate" value="${good.productDate}" /><br/>
	保质期:<input type="text" name="shelfLife" value="${good.shelfLife}"><br/>
	商品描述:<input type="text" name="description" value="${good.description}"><br/>
	商品价格:<input type="text" name="price" value="${good.price}">
	<input type="submit" value="提交" />
	</form>
</body>
</html>