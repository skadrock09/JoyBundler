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
    <title>Show Name</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body class="bg-dark">
    <main>
        <div class="container py-5">
            <div class="card">
                <div class="card-header">
                    <h3>${babyName.getName()}</h3>
                    <p>(added by ${usercreated.getUserName()})</p>
                </div>
                <div class="card-body">
                    <h6>Gender: ${babyName.getGender()}</h6>
                    <h6>Origin: ${babyName.getOrigin()}</h6>
                    <p>Meaning: ${babyName.getDescription()}</p>
                </div>
                <div class="card-footer">
                    <c:choose>
                        <c:when test="${user.getUserName() == usercreated.getUserName()}">
                            <a href="/names/${babyName.getId()}/edit" class="btn btn-primary">Edit</a></a>
                        </c:when>
                    </c:choose>
                </div>
            </div>
        </div>
    </main>
</body>
</html>