<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Goods</title>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0" align="center" width="60%">
		<thead>
			<tr>
				<td colspan="7">
					商品分类:
					<select name="goodsType">
						<c:forEach items="${goodsType}" var="type">
							<option value="${type.key}" />${type.value}
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>商品ID</th>
				<th>商品名称</th>
				<th>生产日期</th>
				<th>保质期</th>
				<th>商品描述</th>
				<th>商品价格</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:choose>
            <c:when test="${goods != null || goods != ''}">
                <c:forEach var="good" items="${goods}" varStatus="status">
				<tr>
					<td>${good.id}</td>
					<td>${good.name}</td>
					<td><fmt:formatDate value="${good.productDate}" pattern="yyyy-MM-dd hh:mm:ss" type="date" dateStyle="long" /></td>
					<td>${good.shelfLife}</td>
					<td>${good.description}</td>
					<td>${good.price}</td>
					<td>
						<a href="${pageContext.request.contextPath }/goods/getGoodById.action?good_id=${good.id}">修改</a>
					</td>
				</tr>
				</c:forEach>
            </c:when>
            <c:otherwise>
                              错误信息:${errorInfo}
            </c:otherwise>
        </c:choose>
		</tbody>
	</table>
</body>
</html>