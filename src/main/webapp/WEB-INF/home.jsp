<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formato (fechas) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- para errores de renderizado en rutas PUT -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project Manager Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-dark">
<main>
    <div class="container py-5">
        <div class="card">
            <div class="card-header">
                <div class="row">
                    <div class="col">
                        <h4 class="green">Hello, ${user.getUserName()}. Here are some name suggestion</h4>
                    </div>
                    <div class="col-auto">
                        <a href="/logout"><button type="button" class="btn btn-danger">Log out</button></a>
                    </div>
                </div>
            </div>
            <div class="card-body">
                <div class="row py-1">
                    <div class="col-12">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th scope="col">BabyNames</th>
                                <th scope="col"></th>
                                <th scope="col"></th>
                                <th scope="col"></th>
                                <th scope="col">Votes</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${babyNames}" var="babyName">
                                <tr>
                                    <td>
                                        <form:form action="/vote" method="post" modelAttribute="vote_user_babyname">
                                            <form:input type="hidden" path="babyname" value="${babyName.getId()}"/>
                                            <form:input type="hidden" path="user" value="${user.getId()}"/>
                                            <form:input type="hidden" path="typeofChoice" value="Vote"/>
                                            <button type="submit" class="btn btn-success">
                                                upvote!
                                            </button>
                                        </form:form>
                                    </td>
                                    <td>
                                        <a href="/names/${babyName.getId()}">${babyName.getName()}</a>
                                    </td>
                                    <td>
                                        ${babyName.getGender()}
                                    </td>
                                    <td>
                                        Origin: ${babyName.getOrigin()}
                                    </td>
                                    <td>
                                        ${babyName.getCountLikes()}
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
            <div class="card-footer">
                <a href="/names/new"><button type="button" class="btn btn-success">Add new name</button></a>
            </div>
        </div>
    </div>
</main>

</body>
</html>