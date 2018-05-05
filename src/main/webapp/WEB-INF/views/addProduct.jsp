<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Produkty</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">Wyloguj się</a>
        <div class="pull-right" style="padding-right: 50px">
            <a href="?language=pl">polski</a>|<a href="?language=eng">angielski</a>
        </div>
        <div class="container">
            <h1>Produkty</h1>
            <p>Dodaj produkty</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
        <fieldset>
            <legend>Dodaj nowy produkt</legend>
            <form:errors path="*" cssClass="alert alert-danger" elemet="div"/>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="productId">
                    <spring:message code="addProduct.form.productId.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input path="productId" id="productId" type="text" class="form:input-large"/>
                    <form:errors path="productId" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="name">
                <spring:message code="addProduct.form.name.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input path="name" id="name" type="text" class="form:input-large"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="unitPrice">
                    <spring:message code="addProduct.form.unitPrice.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input path="unitPrice" id="unitPrice" type="text" class="form:input-large"/>
                    <form:errors path="unitPrice" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="manufacturer">
                    <spring:message code="addProduct.form.manufacturer.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input path="manufacturer" id="manufacturer" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="category">
                    <spring:message code="addProduct.form.category.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input path="category" id="category" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="unitsInStock">
                    <spring:message code="addProduct.form.unitsInStock.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input path="unitsInStock" id="unitsInStock" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="description">
                    <spring:message code="addProduct.form.description.label"/>
                </label>
                <div class="col-lg-10">
                    <form:textarea path="description" id="description" rows="2"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="condition">Stan</label>
                <div class="col-lg-10">
                    <form:radiobutton path="condition" value="New"/>Nowy
                    <form:radiobutton path="condition" value="Old"/>Używany
                    <form:radiobutton path="condition" value="Refurbished"/>Odnowiony
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productImage">
                    <spring:message code="addProduct.form.productImage.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="productImage" path="productImage" type="file" class="form:input-large"/>
                </div>
            </div>


            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value="Dodaj"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>