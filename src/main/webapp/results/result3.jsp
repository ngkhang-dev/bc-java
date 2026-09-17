<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="vi">

  <head>
    <meta charset="UTF-8">
    <title>Kết quả đăng nhập</title>
    <style>
      body {
        font-family: Arial;
        text-align: center;
        margin-top: 80px;
        background: #2c3e50;
      }

      .msg {
        font-size: 20px;
        padding: 25px 35px;
        display: inline-block;
        border-radius: 10px;
        color: #fff;
      }

      .ok {
        background: #27ae60;
      }

      .fail {
        background: #e74c3c;
      }

      a {
        color: #ecf0f1;
      }
    </style>
  </head>

  <body>
    <div>
      <div class="msg">
        <% if (request.getAttribute("trangThai").equals("success")) { %>
        <p class="ok">Đăng nhập thành công! Xin chào, ${tenDangNhap}</p>
        <% } else { %>
          <p class="fail">Sai tên đăng nhập hoặc mật khẩu!</p>
          <% } %>
      </div>

      <br><br>
      <a href="./index.jsp">&laquo; Quay lại trang Home</a>
    </div>
  </body>

  </html>
