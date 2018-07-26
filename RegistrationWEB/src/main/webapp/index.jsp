<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language"
	value="${not empty param.language? param.language: not empty language? language: pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="messages" />
<!doctype html>
<html lang="${language}">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta hhtp-equiv="pragma" content="no-cache"/>
<title><fmt:message key="registration" /></title>

<!-- Bootstrap core CSS -->
<link href="css/core.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/floating.css" rel="stylesheet">
</head>
<body>
	<form id="lang-form">
		<input class="lang-button" name="language" type="image" value="en"
			src="css/eng.jpg" ${language == 'en' ? 'selected' : ''} /> <input
			class="lang-button" name="language" type="image" value="ru"
			src="css/ru.png" ${language == 'ru' ? 'selected' : ''} />
	</form>
	<form class="form-signin" action="registration" method="POST">
		<div class="text-center mb-4">
			<h1 class="h3 mb-3 font-weight-normal">
				<fmt:message key="registration" />
			</h1>
			<p>
				<fmt:message key="input.request" />
			</p>
		</div>

		<div class="form-label-group">
			<input type="email" name="inputEmail" class="form-control"
				placeholder=<fmt:message key="input.email"/> required autofocus>
			<%-- 			<label for="inputEmail"><fmt:message key="input.email" /></label> --%>
		</div>

		<div class="form-label-group">
			<input type="text" name="inputName" class="form-control"
				placeholder="<fmt:message key="input.name"/>" required>
<%-- 				 <label for="inputName"><fmt:message key="input.name" /></label> --%>
		</div>

		<div class="form-label-group">
			<input type="password" name="inputPassword" class="form-control"
				placeholder="<fmt:message key="input.password"/>" required>
<%-- 			<label for="inputPassword"><fmt:message key="input.password" /></label> --%>
		</div>

		<button class="btn btn-lg btn-primary btn-block" type="submit">
			<fmt:message key="button.subscribe" />
		</button>
	</form>
</body>
</html>