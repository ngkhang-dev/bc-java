<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="vi">

  <head>
    <meta charset="UTF-8">
    <title>Bài 4 - Chọn màu nền</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        margin-top: 60px;
      }

      .box {
        background: #fff;
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, .15);
        width: 320px;
      }

      h2 {
        text-align: center;
        color: #333;
      }

      select,
      button {
        width: 100%;
        padding: 9px;
        margin: 8px 0;
        box-sizing: border-box;
        border-radius: 5px;
        border: 1px solid #ccc;
      }

      button {
        background: #8e44ad;
        color: #fff;
        border: none;
        cursor: pointer;
        font-weight: bold;
      }

      button:hover {
        background: #732d91;
      }
    </style>
  </head>

  <body>
    <div class="box">
      <h2>Chọn màu nền trang</h2>

      <form action="ColorServlet" method="get">
        <select name="color">
          <option value="red">Đỏ</option>
          <option value="blue">Xanh</option>
          <option value="green">Lá</option>
        </select>

        <button type="submit">Đổi màu</button>
      </form>
    </div>
  </body>

  </html>
