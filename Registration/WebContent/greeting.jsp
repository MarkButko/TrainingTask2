<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Congratulations</title>

<!-- Bootstrap core CSS -->
<link href="css/core.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/floating.css" rel="stylesheet">
</head>
<body>
	<form class="form-signin">
		<div class="text-center mb-4">
			<h1 class="h3 mb-3 font-weight-normal">You are successfully
				subscribed</h1>
		</div>

		<div class="form-label-group">
			<input type="email" id="inputEmail" class="form-control"
				placeholder="Email address" disabled> <label
				for="inputEmail">${email}</label>
		</div>

		<div class="form-label-group">
			<input type="text" id="inputName" class="form-control"
				placeholder="Name" disabled> <label for="inputName">name</label>
		</div>
	</form>
</body>
</html>