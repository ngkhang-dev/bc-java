<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="vi">

  <head>
    <meta charset="UTF-8">
    <title>Bài 5 - Khảo sát sở thích</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background: #fdf6e3;
        display: flex;
        justify-content: center;
        margin-top: 60px;
      }

      .box {
        background: #fff;
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, .1);
        width: 340px;
      }

      h2 {
        text-align: center;
        color: #d35400;
      }

      input[type=text] {
        width: 100%;
        padding: 8px;
        margin: 8px 0;
        box-sizing: border-box;
        border-radius: 5px;
        border: 1px solid #ccc;
      }

      .checks label {
        display: block;
        margin: 6px 0;
      }

      button {
        width: 100%;
        padding: 9px;
        margin-top: 10px;
        background: #d35400;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-weight: bold;
      }

      button:hover {
        background: #a84300;
      }
    </style>
  </head>

  <body>
    <div class="box">
      <h2>Khảo sát sở thích</h2>

      <form action="SurveyServlet" method="post">
        <input type="text" name="username" placeholder="Tên của bạn" required>
        <p><b>Sở thích:</b></p>
        <div class="checks">
          <label><input type="checkbox" name="hobby" value="Game"> Game</label>
          <label><input type="checkbox" name="hobby" value="Music"> Music</label>
          <label><input type="checkbox" name="hobby" value="Sport"> Sport</label>
        </div>

        <button type="submit">Gửi khảo sát</button>
      </form>
    </div>
  </body>

  </html>
