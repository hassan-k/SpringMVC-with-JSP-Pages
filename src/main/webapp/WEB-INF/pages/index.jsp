<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8" session="true" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html ng-app="index">
<head >
	<meta charset="utf-8">
	<title>fi.Span Sample</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="admin pages">
	<meta name="author" content="admin">
	<!-- Bootstrap core CSS -->
	<link href="css/fonts.css" rel="stylesheet">
	<link href="css/site.css" rel="stylesheet">
	<link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="bootstrap-3.3.7-dist/css/simple-sidebar.css" rel="stylesheet">
	<!-- <link href="bootstrap-3.3.5-dist/css/cover.css" rel="stylesheet"> -->
		<!-- Custom styles for this template -->
	<link href="bootstrap-3.3.7-dist/css/jumbotron-narrow.css" rel="stylesheet">
	<link href="css/fb-buttons.css" rel="stylesheet" />
	<script src="jquery/jquery.min.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
	<script src="bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
	<link href="bootstrap-3.3.7/dist/css/sticky-footer-navbar.css"  rel="stylesheet">
	
</head>
<body >
	<div class="container ">
	 <div class="row">
		 <div class=" col-md-9 col-sm-12 col-xs-12"  >
		     <div ng-view=""></div><!--container for views-->
	     </div>
		<%@ include file="/WEB-INF/pages/footer.jsp" %>
	 </div>
	</div>
	<%@ include file="/WEB-INF/pages/script.jsp" %>
</body>