<%-- 
    Document   : adminHeader
    Created on : Jun 23, 2020, 3:55:24 PM
    Author     : SE130205
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="admin" value="${sessionScope.ADMIN}"/>
        <nav class="navbar navbar-light bg-dark" style="margin-bottom: 5%">
            <a class="navbar-brand text-light" href="#">FPTU Library</a>
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
                    <a class="nav-link" href="SearchUserController">User Management</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="SearchBookController">Book Management</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
            </ul>

            <form action="MainController" class="form-inline">
                <input class="form-control mr-sm-2" type="search" placeholder="Search by full name" name="txtSearch" value="${param.txtSearch}">
                <button class="btn btn-outline-secondary my-2 my-sm-0 " type="submit" name="btnAction" value="SearchUser">Search</button>
            </form>
        </nav>
    </body>
</html>
