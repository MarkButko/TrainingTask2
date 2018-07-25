<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="messages" />
<!doctype html>
<html lang="${language}">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title><fmt:message key="congratulations" /></title>

<!-- Bootstrap core CSS -->
<link href="css/core.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/floating.css" rel="stylesheet">
</head>
<body>
	<form class="form-signin">
		<div class="text-center mb-4">
			<h1 class="h3 mb-3 font-weight-normal">
				<fmt:message key="subscription.success" />
			</h1>
			<p>
				<fmt:message key="your.data" />
			</p>
		</div>

		<div class="form-label-group">
			<input type="email" id="inputEmail" class="form-control"
				placeholder="${email}" disabled>
		</div>

		<div class="form-label-group">
			<input type="text" id="inputName" class="form-control"
				placeholder="${name}" disabled>
		</div>
	</form>
</body>
</html>