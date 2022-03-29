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
    <title>Tacos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body class="bg-dark">
    <main>
        <div class="container py-5">
            <div class="row">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header">
                            <h3>Change ${babyName.getName()}</h3>
                        </div>
                        <div class="card-body">
                            <form:form action="/update" method="post" modelAttribute="edit_baby_name">
                                <div class="form-group row py-1" >
                                    <form:label path="name" class="col-md-4 col-form-label">New Name: </form:label>
                                    <div class="col-md-8">
                                        <form:errors path="name" class="text-danger"/>
                                        <form:input type="text" path="name" value="${babyName.getName()}" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group row py-1">
                                    <form:label path="Gender" class="col-md-4 col-form-label">Typical Gender: </form:label>
                                    <div class="col-md-8">
                                        <form:errors path="Gender" class="text-danger" />
                                        <form:select path="Gender" class="form-control custom-select">
                                            <form:option value="">${babyName.getGender()}</form:option>
                                            <form:option value="Male">
                                                Male
                                            </form:option>
                                            <!--Female, Neutral-->
                                            <form:option value="Female">
                                                Female
                                            </form:option>
                                            <form:option value="Neutral">
                                                Neutral
                                            </form:option>
                                        </form:select>
                                    </div>
                                </div>
                                <div class="form-group row py-1">
                                    <form:label path="Origin" class="col-md-4 col-form-label">Origin: </form:label>
                                    <div class="col-md-8">
                                        <form:errors path="Origin" class="text-danger" />
                                        <form:input type="text" path="Origin" value="${babyName.getOrigin()}" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group row py-1">
                                    <form:label path="description" class="col-md-4 col-form-label">Meaning: </form:label>
                                    <div class="col-md-8">
                                        <form:errors path="description" class="text-danger" />
                                        <form:input type="text" path="description" value="${babyName.getDescription()}" class="form-control"/>
                                    </div>
                                </div>
                                <form:input type="hidden" path="id" value="${babyName.getId()}" />
                                <div class="form-group row py-2">
                                    <div class="col">
                                        <a href="/delete/${babyName.getId()}"><button type="button" class="btn btn-danger">DELETE</button></a>
                                    </div>
                                    <div class="col-auto">
                                        <a href="/home"><button type="button" class="btn btn-danger">Cancel</button></a>
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>
</html>