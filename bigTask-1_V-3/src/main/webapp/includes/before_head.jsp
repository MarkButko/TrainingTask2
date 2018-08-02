<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language"
	value="${not empty param.language? param.language: not empty language? language: pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="i18n.menu.menu" />
<!doctype html>
<html lang="${language}">
<head>
<meta charset="utf-8">
<meta hhtp-equiv="pragma" content="no-cache" />
<link rel="stylesheet"
	href="css/bootstrap.css"
	type="text/css">