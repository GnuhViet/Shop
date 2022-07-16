<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Register</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->
        <link rel="icon" type="image/png" href="../assets/images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../assets/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../assets/webfonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../assets/webfonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../assets/vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../assets/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../assets/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../assets/vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../assets/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../assets/css/util.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/loginmain.css">
        <!--===============================================================================================-->
    </head>
    <body style="background-color: #666666;">
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <form action="../register" method="post" class="login100-form validate-form">
					<span class="login100-form-title p-b-43">
					    Register
					</span>


                        <div class="wrap-input100 validate-input" data-validate="Name is required">
                            <input class="input100" type="text" name="name">
                            <span class="focus-input100"></span>
                            <span class="label-input100">Name</span>
                        </div>


                        <div class="wrap-input100 validate-input" data-validate="Age is required">
                            <input class="input100" type="number" name="age"  min="1" max="300" >
                            <span class="focus-input100"></span>
                            <span class="label-input100">Age</span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Username is required">
                            <input class="input100" type="text" name="username">
                            <span class="focus-input100"></span>
                            <span class="label-input100">Username</span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Password is required">
                            <input class="input100" type="password" name="password">
                            <span class="focus-input100"></span>
                            <span class="label-input100">Password</span>
                        </div>

                        <c:if test="${param.status != null}">
                            <c:choose>
                                <c:when test="${param.status == 'successfully'}" >
                                    <span class="login100-form-title p-b-43">
                                        Register success
                                    </span>
                                </c:when>
                                <c:otherwise>
                                    <span class="login100-form-title p-b-43">
                                        Register failed
                                    </span>
                                </c:otherwise>
                            </c:choose>
                        </c:if>

                        <div class="flex-sb-m w-full p-b-32">
                            <div>
                                <a href="login.jsp" class="txt1">
                                    Login
                                </a>
                            </div>
                        </div>

                        <%--submit--%>
                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn" type="submit">
                                Register
                            </button>
                        </div>

                    </form>
                    <a href="../index.jsp" class="login100-more" style="background-image: url('../assets/images/bg-01.jpg');">
                    </a>
                </div>
            </div>
        </div>

        <!--===============================================================================================-->
        <script src="../assets/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="../assets/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="../assets/vendor/bootstrap/js/popper.js"></script>
        <script src="../assets/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="../assets/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="../assets/vendor/daterangepicker/moment.min.js"></script>
        <script src="../assets/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="../assets/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="../assets/js/main.js"></script>

    </body>
</html>