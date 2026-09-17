<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="vi">

  <head>
    <meta charset="UTF-8">
    <title>Màu nền</title>
    <style>
      body {
        font-family: Arial;
        text-align: center;
        margin-top: 80px;

        background:${bgColor};
      }

      .msg {
        font-size: 22px;
        padding: 20px 30px;
        display: inline-block;
        border-radius: 10px;
        background: #fff;
      }
    </style>
  </head>

  <body>
    <div class="msg">Màu nền hiện tại: <b>${nhan}</b></div>
    <br><br>
    <a href="./index.jsp">&laquo; Quay lại trang Home</a>
  </body>

  </html>
