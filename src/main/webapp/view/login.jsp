<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>
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
                    <form action="login" method="post" class="login100-form validate-form">
					<span class="login100-form-title p-b-43">
						Login to continue
					</span>


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

                        <div class="flex-sb-m w-full p-t-3 p-b-32">
                            <div class="contact100-form-checkbox">
                                <input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
                                <label class="label-checkbox100" for="ckb1">
                                    Remember me
                                </label>
                            </div>

                            <div>
                                <a href="register" class="txt1">
                                    Register
                                </a>
                            </div>
                        </div>

                        <c:if test="${param.status != null}">
                            <c:choose>
                                <c:when test="${param.status == 'not-exist'}">
                                    <span class="login100-form-title p-b-43">
                                        Your account is not exist
                                    </span>
                                </c:when>
                                <c:otherwise>
                                    <span class="login100-form-title p-b-43">
                                        Your username or password is incorrect
                                    </span>
                                </c:otherwise>
                            </c:choose>
                        </c:if>

                        <%--submit--%>
                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn" type="submit">
                                Login
                            </button>
                        </div>

                        <div class="text-center p-t-46 p-b-20">
						<span class="txt2">
							or sign up using
						</span>
                        </div>

                        <div class="login100-form-social flex-c-m">
                            <a href="#" class="login100-form-social-item flex-c-m bg1 m-r-5">
                                <i class="fa fa-facebook-f" aria-hidden="true"></i>
                            </a>

                            <a href="#" class="login100-form-social-item flex-c-m bg2 m-r-5">
                                <i class="fa fa-twitter" aria-hidden="true"></i>
                            </a>
                        </div>
                    </form>

                    <a href="${pageContext.request.contextPath}/home.jsp" class="login100-more" style="background-image: url('${pageContext.request.contextPath}/assets/images/bg-01.jpg');">
                    </a>
                </div>
            </div>
        </div>

        <jsp:include page="template/footer.jsp"/>
        <jsp:include page="template/webscript.jsp"/>
        <jsp:include page="template/loginscrip.jsp"/>
    </body>
</html>