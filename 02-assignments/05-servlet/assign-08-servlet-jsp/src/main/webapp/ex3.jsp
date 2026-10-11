<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="vi">

  <head>
    <meta charset="UTF-8">
    <title>Bài 3 - Đăng nhập</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background: #2c3e50;
        display: flex;
        justify-content: center;
        margin-top: 60px;
      }

      .box {
        background: #fff;
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, .3);
        width: 320px;
      }

      h2 {
        text-align: center;
        color: #2c3e50;
      }

      input,
      button {
        width: 100%;
        padding: 9px;
        margin: 8px 0;
        box-sizing: border-box;
        border-radius: 5px;
        border: 1px solid #ccc;
      }

      button {
        background: #e74c3c;
        color: #fff;
        border: none;
        cursor: pointer;
        font-weight: bold;
      }

      button:hover {
        background: #c0392b;
      }

      .hint {
        font-size: 12px;
        color: #999;
        text-align: center;
      }
    </style>
  </head>

  <body>
    <div class="box">
      <h2>Đăng nhập</h2>

      <form action="LoginServlet" method="post">
        <input type="text" name="username" placeholder="Tên đăng nhập" required value="admin">
        <input type="password" name="password" placeholder="Mật khẩu" required value="123">
        <button type="submit">Đăng nhập</button>
      </form>

      <p class="hint">Gợi ý: admin / 123</p>
    </div>
  </body>

  </html>
