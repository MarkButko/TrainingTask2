<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Registration form</title>

<!-- Bootstrap core CSS -->
<link href="css/core.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/floating.css" rel="stylesheet">
</head>
<body>
	<form class="form-signin" action="registration" method="POST">
		<div class="text-center mb-4">
			<h1 class="h3 mb-3 font-weight-normal">Registration</h1>
			<p>Input your data.</p>
		</div>

		<div class="form-label-group">
			<input type="email" name="inputEmail" class="form-control"
				placeholder="Email address" required autofocus> <label
				for="inputEmail">Email address</label>
		</div>

		<div class="form-label-group">
			<input type="text" name="inputName" class="form-control"
				placeholder="Name" required> <label for="inputName">Name</label>
		</div>
		
		<div class="form-label-group">
			<input type="password" id="inputPassword" class="form-control"
				placeholder="Password" required> <label for="inputPassword">Password</label>
		</div>

		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
	</form>
</body>
</html>