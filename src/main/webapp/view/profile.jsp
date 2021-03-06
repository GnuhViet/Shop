<%@ page import="com.example.shopbanhang.model.User" %>
<%@ page import="com.example.shopbanhang.dao.service.UserService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gnuh
  Date: 17/07/2022
  Time: 12:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Profile Settings</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/account.css">
        <jsp:include page="template/webstyle.jsp"/>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <body>
        <jsp:include page="template/header.jsp"/>

        <c:set var="u" value="${sessionScope.user}"/>

        <form action="profile" method="post" enctype="multipart/form-data">
            <div class="container rounded bg-white mt-5 mb-5">
                <div class="row">

                    <%--start-profile-image--%>
                    <div class="container col-md-3 border-right">
                        <div class="avatar-upload">
                            <div class="avatar-edit">
                                <input type='file' name="image" id="imageUpload" accept=".jpg" value="${null}"/>
                                <label for="imageUpload" style="line-height: 1"></label>
                            </div>
                            <div class="avatar-preview" style="box-sizing: content-box">
                                <div id="imagePreview" style="background-image: url(${pageContext.request.contextPath}/user-image/${u.image});">
                                </div>
                            </div>
                        </div>

                        <%--                        <c:choose>--%>
                        <%--                            <c:when test="${u.image == null}">--%>
                        <%--                                <div class="d-flex flex-column align-items-center text-center p-3 py-5">--%>
                        <%--                                    <img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold">Edogaru</span><span class="text-black-50">edogaru@mail.com.my</span><span> </span>--%>
                        <%--                                </div>--%>
                        <%--                            </c:when>--%>
                        <%--                            <c:otherwise>--%>
                        <%--                                <div class="d-flex flex-column align-items-center text-center p-3 py-5">--%>
                        <%--                                    <img class="rounded-circle mt-5" width="150px" src="${pageContext.request.contextPath}/user-image/${u.image}">--%>
                        <%--                                </div>--%>
                        <%--                            </c:otherwise>--%>
                        <%--                        </c:choose>--%>
                        <%--                        <input type="file" name="image" class="custom-file-input">--%>
                    </div>

                    <%--end-profile-image--%>

                    <div class="col-md-5 border-right">
                        <div class="p-3 py-5">
                            <c:choose>
                                <c:when test="${param.status != null}">
                                    <div class="d-flex justify-content-between align-items-center mb-3">
                                        <h4 class="text-right">Profile Settings - Update ${param.status}</h4>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="d-flex justify-content-between align-items-center mb-3">
                                        <h4 class="text-right">Profile Settings</h4>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                            <div class="row mt-2">
                                <div class="col-md-9">
                                    <label class="labels">Name</label><input type="text" name="name" class="form-control" value="${u.name}">
                                </div>
                                <div class="col-md-3">
                                    <label class="labels">Age</label><input type="number" name="age" min="0" class="form-control" value="${u.age}">
                                </div>
                            </div>

                            <div class="row mt-4">
                                <div class="col-md-4">
                                    <label class="labels">Gender</label>
                                </div>
                                <div class="col-md-3">
                                    <label class="labels">Male</label><input type="radio" name="gender" class="" value="male" ${u.gender == 'male' ? 'checked' : ''}>
                                </div>
                                <div class="col-md-3">
                                    <label class="labels">Female</label><input type="radio" name="gender" class="" value="female" ${u.gender == 'female' ? 'checked' : ''}>
                                </div>
                            </div>

                            <div class="row mt-3">
                                <div class="col-md-12">
                                    <label class="labels">Mobile Number</label><input type="text" name="phone" class="form-control" value="${u.phone}">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Address</label><input type="text" name="address" class="form-control" value="${u.address}">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Email</label><input type="text" name="email" class="form-control" value="${u.email}">
                                </div>
                            </div>
                            <div class="row mt-3">
                                <div class="col-md-6">
                                    <label class="labels">Country</label><input type="text" name="country" class="form-control" value="${u.country}">
                                </div>
                                <div class="col-md-6">
                                    <label class="labels">State/Region</label><input type="text" name="region" class="form-control" value="${u.region}">
                                </div>
                            </div>
                            <div class="mt-5 text-center">
                                <button class="btn btn-primary profile-button" type="submit">Save Profile</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center experience">
                                <span>Edit Experience</span><span class="border px-3 p-1 add-experience"><i class="fa fa-plus"></i>&nbsp;Experience</span>
                            </div>
                            <br>
                            <div class="col-md-12">
                                <label class="labels">Experience in Designing</label><input type="text" class="form-control" value="">
                            </div>
                            <br>
                            <div class="col-md-12">
                                <label class="labels">Additional Details</label><input type="text" class="form-control" value="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>

        <jsp:include page="template/footer.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
        <jsp:include page="template/webscript.jsp"/>
    </body>
</html>
