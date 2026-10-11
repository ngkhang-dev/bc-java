<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="vi">

  <head>
    <meta charset="UTF-8">
    <title>Bài 2 - Chào người dùng</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background: #eef7f0;
        display: flex;
        justify-content: center;
        margin-top: 60px;
      }

      .box {
        background: #fff;
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, .1);
        width: 320px;
        text-align: center;
      }

      h2 {
        color: #27ae60;
      }

      input,
      button {
        width: 100%;
        padding: 8px;
        margin: 8px 0;
        box-sizing: border-box;
        border-radius: 5px;
        border: 1px solid #ccc;
      }

      button {
        background: #27ae60;
        color: #fff;
        border: none;
        cursor: pointer;
        font-weight: bold;
      }

      button:hover {
        background: #1e8449;
      }
    </style>
  </head>

  <body>
    <div class="box">
      <h2>Xin chào!</h2>

      <form action="HelloServlet" method="get">
        <input type="text" name="name" placeholder="Nhập tên của bạn">
        <button type="submit">Gửi</button>
      </form>

      <p style="color:#888;font-size:13px;">Ví dụ URL: HelloServlet?name=NguyenVanA</p>
    </div>
  </body>

  </html>
