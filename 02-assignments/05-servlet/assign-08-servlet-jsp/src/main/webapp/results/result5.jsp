<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="vi">

  <head>
    <meta charset="UTF-8">
    <title>Kết quả khảo sát</title>
    <style>
      body {
        font-family: Arial;
        text-align: center;
        margin-top: 80px;
        background: #fdf6e3;
      }

      .msg {
        font-size: 18px;
        padding: 25px 35px;
        display: inline-block;
        border-radius: 10px;
        background: #fff;
        box-shadow: 0 2px 10px rgba(0, 0, 0, .1);
        text-align: left;
      }
    </style>
  </head>

  <body>
    <div class="msg">
      <p>Xin chào, <b>${tenNguoiDung}</b>!</p>
      <% String[] soThich=(String[]) request.getAttribute("soThich"); if (soThich==null || soThich.length==0) { %>
        <p>Bạn chưa chọn sở thích nào.</p>
        <% } else { %>
          <p>Sở thích của bạn:</p>
          <ul>
            <% for (String h : soThich) { %>
              <li>
                <%= h %>
              </li>
              <% } %>
          </ul>
          <% } %>
    </div>
    <br><br>
    <a href="./index.jsp">&laquo; Quay lại trang Home</a>
  </body>

  </html>
