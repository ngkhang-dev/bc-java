<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="models.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>

	<div style="width: 80%; margin: 0 auto;">
		<h1 style="text-align: center">Product</h1>

		<h2>Render with JSP</h2>
		<p>JSP lấy data từ requests > Cast về list Products > for() >
			getTen() > HTML</p>
		<%
		List<Product> products_old = (List<Product>) request.getAttribute("products");
		%>

		<div style="display: flex; gap: 20px; padding: 20px; flex-wrap: wrap;">

			<%
			for (Product p : products_old) {
			%>

			<div
				style="width: 260px; min-height: 300px; border: 2px solid #ff2f55; padding: 18px; border-radius: 8px; box-sizing: border-box; display: flex; flex-direction: column; background-color: white;">
				<p><%=p.getTen()%></p>
				<p><%=p.getGia()%></p>
				<!-- Hình ảnh/ Button "view" -->
			</div>
			<%
			}
			%>
		</div>

		<h2>Render with JSTL</h2>
		<p>JSP nhận data trực tiếp > JSTL duyệt ngay danh sách với giá trị
			nhận được > HTML</p>
		<div style="display: flex; gap: 20px; padding: 20px; flex-wrap: wrap;">
			<c:forEach items="${products}" var="item">
				<!-- items là danh sách cần duyệt, nhận từ attribute
				Trong mỗi lần lặp, var lấy một phần tử của products và đặt tên tạm cho phần tử đó là item -->
				<div
					style="width: 260px; min-height: 300px; border: 2px solid #ff2f55; padding: 18px; border-radius: 8px; box-sizing: border-box; display: flex; flex-direction: column; background-color: white;">
					<!-- item.ten : ten private-> tìm getTen lấy ra giá  -->
					<p>${item.getTen()}</p>
					<p>${item.getGia()}</p>
				</div>
			</c:forEach>
		</div>

		<h2>Demo Syntax JSTL</h2>

		<!-- Câu điều kiện -->
		<c:if test="true">Hello</c:if>

		<!-- Gán giá trị -->
		<c:set var="age" value="19" />

		<c:if test="${age >= 18}">Ban du 18 tuoi</c:if>

		<!-- In giá trị biến -->
		<c:out value="${age}" />
		<br /> ${age}

		<!-- when, choose, otherwise -->
		<c:set var="score" value="7" />
		<p>
			<b>Xep loai: </b>
			<c:choose>
				<c:when test="${score >=9}">
				Gioi
				</c:when>
				<c:when test="${score >=8}">
				Kha
				</c:when>
				<c:otherwise>
				Trung binh
				</c:otherwise>

			</c:choose>
		</p>

		<!-- For -->
		<p>
			<b>c:foreach</b>
			<c:forEach var="i" begin="1" end="5">
				<i>So: </i> ${i}
			</c:forEach>
		</p>

		<p>
			<b>c:forTokens</b> <br>
			<c:forTokens items="Java,C#,Reat,SQL,Golang" delims="," var="item">
				<i>Skill: </i> ${item} <br>
			</c:forTokens>
		</p>

		<!-- Catch -->
		<c:catch var="err">
			<%
			int x = 10 / 0;
			%>

		</c:catch>
		${err}

		<c:if test="${err != null}">
		Co loi xay ra vui long thu lai
		</c:if>
	</div>
</body>
</html>