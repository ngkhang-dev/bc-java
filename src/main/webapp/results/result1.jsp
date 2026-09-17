<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="vi">

  <head>
    <meta charset="UTF-8">
    <title>Kết quả</title>

    <style>
      body {
        text-align: center;
        margin-top: 80px;
      }

      .result {
        font-size: 24px;
        color: #2c3e50;
        padding: 20px;
        border: 2px solid #3498db;
        display: inline-block;
        border-radius: 10px;
      }
    </style>
  </head>

  <body>
    <div class="result">
      <% if ((Boolean) request.getAttribute("loi")) { %>
        <p>Dữ liệu nhập không hợp lệ!</p>
        <% } else { %>
          <p>${soA} ${phepToan} ${soB} = ${ketQua}</p>
          <% } %>
    </div>
    <br><br>
    <a href="./index.jsp">&laquo; Quay lại trang Home</a>
  </body>

  </html>
