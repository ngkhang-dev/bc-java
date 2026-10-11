<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html lang="vi">

	<head>
		<meta charset="UTF-8">
		<title>Bài 1 - Máy tính cộng trừ</title>
		<style>
			body {
				font-family: Arial, sans-serif;
				background: #f4f6f8;
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
			}

			h2 {
				text-align: center;
				color: #2c3e50;
			}

			input,
			select,
			button {
				width: 100%;
				padding: 8px;
				margin: 8px 0;
				box-sizing: border-box;
				border-radius: 5px;
				border: 1px solid #ccc;
			}

			button {
				background: #3498db;
				color: #fff;
				border: none;
				cursor: pointer;
				font-weight: bold;
			}

			button:hover {
				background: #2980b9;
			}
		</style>
	</head>

	<body>
		<div class="box">
			<h2>Máy tính cộng trừ</h2>
			<form action="CalculatorServlet" method="post">
				<label>Số A:</label>
				<input type="number" name="a" step="any" required>

				<label>Số B:</label>
				<input type="number" name="b" step="any" required>

				<label>Phép toán:</label>
				<select name="op">
					<option value="+">Cộng (+)</option>
					<option value="-">Trừ (-)</option>
				</select>

				<button type="submit">Tính</button>
			</form>
		</div>
	</body>

	</html>
