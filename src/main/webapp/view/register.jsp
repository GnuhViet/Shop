<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Register</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <jsp:include page="template/loginstyle.jsp"/>
        <jsp:include page="template/webstyle.jsp"/>
    </head>
    <body>
        <jsp:include page="template/header.jsp"/>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <form action="register" method="post" class="login100-form validate-form">
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
                                <a href="login" class="txt1">
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
                    <a href="home" class="login100-more" style="background-image: url('${pageContext.request.contextPath}/assets/images/bg-01.jpg');">
                    </a>
                </div>
            </div>
        </div>
        <jsp:include page="template/footer.jsp"/>
        <jsp:include page="template/webscript.jsp"/>
        <jsp:include page="template/loginscrip.jsp"/>

    </body>
</html>