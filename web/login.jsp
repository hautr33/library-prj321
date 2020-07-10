<%-- 
    Document   : login
    Created on : Jun 11, 2020, 2:43:03 PM
    Author     : SE130205
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <style>
            body{
                background-image: url("https://images.wallpaperscraft.com/image/books_library_shelves_138556_2560x1600.jpg");
                height: 100%;
                width: 100%;
                background-position: top;
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
    </head>
    <body>
        <div class="container" style="padding: 10% 0 5%">
            <div class="col-5 bg-white" style="margin: auto;padding: 3%;">
                <form action="MainController" method="POST">
                    <h3 class="display-4 text-center text-muted">
                        FPTU
                        <small class="text-muted">Library</small>
                    </h3>
                    <hr/>
                    <div class="form-group">
                        <label>User ID</label>
                        <input type="text" class="form-control" name="txtUserID" value="" autocomplete="off">
                        <c:if test="${requestScope.LOGIN_ERROR.userIDErr != null}">
                            <div class="alert-danger text-center">
                                <c:out value="${requestScope.LOGIN_ERROR.userIDErr}"></c:out>
                                </div>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" class="form-control" name="txtPassword" value="">
                        <c:if test="${requestScope.LOGIN_ERROR.passwordErr != null}">
                            <div class="alert-danger text-center">
                                <c:out value="${requestScope.LOGIN_ERROR.passwordErr}"/>
                            </div>
                        </c:if>
                    </div>
                    <button class="btn btn-block btn-secondary" type="submit" name="btnAction" value="Login">Login</button>
                    <button class="btn btn-block btn-outline-secondary" type="reset">Reset</button>
                    <c:if test="${requestScope.LOGIN_ERROR.wrongUserIDPasswordErr != null}">
                        <div class="alert-danger text-center" style="margin-top: 5%">
                            <c:out value="${requestScope.LOGIN_ERROR.wrongUserIDPasswordErr}"/>
                        </div>
                    </c:if>
                </form>
                <hr/>
                <label>
                    <p class="mb-0 text-dark">New to Library? <strong><a class="text-dark" href="MainController?btnAction=RegisterNewAccount">Create new account!</a></strong></p>
                </label>
            </div>
        </div>
        <c:import url="footer.jsp"/>
    </body>
</html>
