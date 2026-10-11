<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="vi">

  <head>
    <meta charset="UTF-8">
    <title>Lời chào</title>
    <style>
      body {
        font-family: Arial;
        text-align: center;
        margin-top: 80px;
        background: #eef7f0;
      }

      .msg {
        font-size: 26px;
        color: #27ae60;
        padding: 25px;
        background: #fff;
        display: inline-block;
        border-radius: 10px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, .1);
      }
    </style>
  </head>

  <body>
    <div class="msg">${loiChao}</div>
    <br><br>
    <a href="./index.jsp">&laquo; Quay lại trang Home</a>
  </body>

  </html>
