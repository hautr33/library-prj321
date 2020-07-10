<%-- 
    Document   : adminHomePage
    Created on : Jul 9, 2020, 3:10:29 PM
    Author     : SE130205
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
        <style>
            body{background-color: #f7f7f7}
            nav{margin-bottom: 5%;}
            img{height: calc(10em + 5rem + 2px);width: calc(10em + 5rem + 2px);}
            .nav-link{color: #b2b2b2}
            .nav-link:hover{color: #ffffff}
            .active{color: #ffffff}
            .table-striped:nth-of-type(odd){background-color: #fcfcfc}
            .table-hover tbody tr:hover{background-color: #d8d8d8}
        </style>
    </head>
    <body>
        <c:set var="admin" value="${sessionScope.ADMIN}"/>
        <nav class="navbar navbar-light bg-dark">
            <a class="navbar-brand text-light" href="MainController?btnAction=HomePage"><h3>FPTU <small>Library</small></h3></a>
            <ul class="nav mr-auto">
                <li class="nav-item dropdown show">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Hi, ${admin.getFullName()}</a>
                    <div class="dropdown-menu dropdown-menu bg-dark">
                        <a class="dropdown-item text-light" href="#">Your Profile</a>
                        <a class="dropdown-item text-light" href="#">Change Password</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item text-light" href="MainController?btnAction=Logout">Sign out</a> 
                    </div>
                </li>
            </ul>
            <ul class="nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="MainController?btnAction=HomePage">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="MainController?btnAction=ViewBook">View Book</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="MainController?btnAction=AddBookPage">Add New Book</a>
                </li>
            </ul>
            <form action="MainController" class="form-inline">
                <input class="form-control mr-sm-2" type="search" placeholder="Search by title" name="txtSearch" value="${param.txtSearch}">
                <button class="btn btn-outline-secondary my-2 my-sm-0 " type="submit" name="btnAction" value="SearchBook">Search</button>
            </form>
        </nav>
        <c:import url="footer.jsp"/>
    </body>
</html>
