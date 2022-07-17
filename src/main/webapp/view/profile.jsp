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
        <title>User Profile</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/account.css">
        <jsp:include page="template/webstyle.jsp"/>
    <body>
        <jsp:include page="template/header.jsp"/>
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row">
                <div class="col-md-3 border-right">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                        <img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold">Edogaru</span><span class="text-black-50">edogaru@mail.com.my</span><span> </span>
                    </div>
                </div>
                <div class="col-md-5 border-right">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Profile Settings</h4>
                        </div>
                        <div class="row mt-2">
                            <div class="col-md-6">
                                <label class="labels">Name</label><input type="text" class="form-control" placeholder="first name" value="">
                            </div>
                            <div class="col-md-6">
                                <label class="labels">Surname</label><input type="text" class="form-control" value="" placeholder="surname">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-12">
                                <label class="labels">Mobile Number</label><input type="text" class="form-control" placeholder="enter phone number" value="">
                            </div>
                            <div class="col-md-12">
                                <label class="labels">Address</label><input type="text" class="form-control" placeholder="enter address line 1" value="">
                            </div>
                            <div class="col-md-12">
                                <label class="labels">Email ID</label><input type="text" class="form-control" placeholder="enter email id" value="">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-6">
                                <label class="labels">Country</label><input type="text" class="form-control" placeholder="country" value="">
                            </div>
                            <div class="col-md-6">
                                <label class="labels">State/Region</label><input type="text" class="form-control" value="" placeholder="state">
                            </div>
                        </div>
                        <div class="mt-5 text-center">
                            <button class="btn btn-primary profile-button" type="button" >Save Profile</button>
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
                            <label class="labels">Experience in Designing</label><input type="text" class="form-control" placeholder="experience" value="">
                        </div>
                        <br>
                        <div class="col-md-12">
                            <label class="labels">Additional Details</label><input type="text" class="form-control" placeholder="additional details" value="">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="template/footer.jsp"/>
        <jsp:include page="template/webscript.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
