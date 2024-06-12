<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 관리</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
 <link rel="stylesheet" type="text/css" href="./css/global.css">
 <script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
 <script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
</head>
<body>
 <header id="main-header" class="py-2 btn-dark text-white">
 <div class="container">
 <div class="row">
 <div class="col-md-6">
 <h1> 부서 관리 </h1>
 </div>
 </div>
 </div>
 </header>
 <section id="dept" class="py-4 mb-4 bg-light">
 </section>
 <section id="details">
 <div class="container">
 <div class="row">
 <div class="col-md-12">
 <div class="card">
 <div class="card-header">
 <h5> 부서 목록 </h5>
 </div>
 <div class="card-body">
 <table class="table table-hover">
 <thead class="thead-light">
 <tr class="text-center">
 <th> 부서 번호 </th> <th> 부서 이름 </th> <th> 부서 지역 </th> <th></th>
 </tr>
 </thead>
 <tbody>
 
 <c:forEach var="list" items="${list}">
 <tr class="text-center">
 <td>${list.deptno}</td>
 <td>${list.dname}</td>
 <td>${list.loc}</td>
 <td>
 <a href="./DeptSelectDetail?deptno=${list.deptno}" class="btn btn-outline-info">부서 상세 보기</a>
 
 </c:forEach>
</body>
</html>