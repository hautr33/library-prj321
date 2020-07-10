<%-- 
    Document   : manage
    Created on : Jun 12, 2020, 12:40:44 PM
    Author     : SE130205
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library Manager Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
        <style>
            body{background-color: #f7f7f7}
            nav{margin-bottom: 5%;}
            .nav-link{color: #b2b2b2}
            .nav-link:hover{color: #ffffff}
            .active{color: #ffffff}
            .table-striped:nth-of-type(odd){background-color: #fcfcfc}
            .table-hover tbody tr:hover{background-color: #d8d8d8}
            img{height: calc(5em + 2.5rem + 2px);width: calc(5em + 2.5rem + 2px);}
        </style>
    </head>
    <body>
        <nav class="navbar navbar-light bg-dark">
            <a class="navbar-brand text-light" href="MainController?btnAction=HomePage"><h3>FPTU <small>Library</small></h3></a>
            <ul class="nav mr-auto">
                <li class="nav-item dropdown show">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Hi, ${sessionScope.ADMIN.getFullName()}</a>
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
                    <a class="nav-link" href="MainController?btnAction=HomePage">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="MainController?btnAction=ViewBook">View Book</a>
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

        <div class="container" style="padding: 1%">
            <c:if test="${requestScope.LIST_BOOK != null and not empty requestScope.LIST_BOOK}">
                <table class="table table-hover table-striped">
                    <thead class="bg-secondary text-light">
                        <tr>
                            <th>No</th>
                            <th>Book ID</th>
                            <th>Title</th>
                            <th>Author</th>
                            <th>Publisher</th>
                            <th>Page Number</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Image</th>
                            <th class="text-center">Update</th>
                            <th class="text-center">Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="book" items="${requestScope.LIST_BOOK}" varStatus="counter">
                            <tr>
                                <th class="text-dark">${counter.count}</th>
                                <td>${book.bookID}</td>
                                <td>${book.title}</td>
                                <td>${book.author}</td>
                                <td>${book.publisher}</td>
                                <td>${book.pageNumber}</td>
                                <td>${book.price} VNĐ</td>
                                <td>${book.quantity}</td>
                                <td><img src="${book.imageURL}" class="img-thumbnail"></td>
                                <td>
                                    <a class="btn btn-block btn-outline-dark" href="MainController?btnAction=UpdateBookPage&txtBookID=${book.bookID}&txtSearch=${param.txtSearch}">Update</a>
                                </td>
                                <td>
                                    <a class="btn btn-block btn-outline-dark" href="MainController?btnAction=DeleteBook&txtBookID=${book.bookID}&txtSearch=${param.txtSearch}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${requestScope.BOOK_ERROR != null}">
                <div class="alert alert-danger text-center">
                    ${requestScope.BOOK_ERROR.notFoundErr}
                    ${requestScope.BOOK_ERROR.searchErr}
                </div>
            </c:if>
        </div>
        <c:import url="footer.jsp"/>
    </body>
</html>
