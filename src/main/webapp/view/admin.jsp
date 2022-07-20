<%@ page import="com.example.shopbanhang.dao.service.UserService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shopbanhang.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Management Data Table</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link href='https://fonts.googleapis.com/css?family=Lato:400,300,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css">
    
    </head>
    <body>
        <div id="overlay" class="overlay"></div>
        <aside id="side-bar" class="sidebar">
            <header style="color: white; text-align: center; font-size: large">
                Menu
            </header>
            <nav class="sidebar-nav">

                <ul>
                    <li>
                        <a href="#"><i class="ion-bag"></i> <span>Shop</span></a>
                        <ul class="nav-flyout">
                            <li>
                                <a href="#"><i class="ion-ios-color-filter-outline"></i>Derps</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-ios-clock-outline"></i>Times</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-android-star-outline"></i>Hates</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-heart-broken"></i>Beat</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="ion-ios-settings"></i> <span class="">Controls</span></a>
                        <ul class="nav-flyout">
                            <li>
                                <a href="#"><i class="ion-ios-alarm-outline"></i>Watch</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-ios-camera-outline"></i>Creeper</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-ios-chatboxes-outline"></i>Hate</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-ios-cog-outline"></i>Grinder</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="ion-ios-briefcase-outline"></i> <span class="">Folio</span></a>
                        <ul class="nav-flyout">
                            <li>
                                <a href="#"><i class="ion-ios-flame-outline"></i>Burn</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-ios-lightbulb-outline"></i>Bulbs</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-ios-location-outline"></i>Where You</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-ios-locked-outline"></i>On Lock</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-ios-navigate-outline"></i>Ghostface</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="ion-ios-analytics-outline"></i> <span class="">Graphicals</span></a>
                        <ul class="nav-flyout">
                            <li>
                                <a href="#"><i class="ion-ios-timer-outline"></i>Timers</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-arrow-graph-down-left"></i>You Lose</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-ios-partlysunny-outline"></i>Stormy</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-ios-timer-outline"></i>Lookie Look</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-ios-game-controller-a-outline"></i>Dork Mfer</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="ion-ios-paper-outline"></i> <span class="">Papers</span></a>
                        <ul class="nav-flyout">
                            <li>
                                <a href="#"><i class="ion-ios-filing-outline"></i>File Cab</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-ios-information-outline"></i>Infos</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-ios-paperplane-outline"></i>Planes</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-android-star-outline"></i>Shop</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="ion-ios-navigate-outline"></i> <span class="">Ass Finder</span></a>
                        <ul class="nav-flyout">
                            <li>
                                <a href="#"><i class="ion-ios-flame-outline"></i>Burn</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-ios-lightbulb-outline"></i>Bulbs</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-ios-location-outline"></i>Where You</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-ios-locked-outline"></i>On Lock</a>
                            </li>
                            <li>
                                <a href="#"><i class="ion-ios-navigate-outline"></i>Ghostface</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="ion-ios-medical-outline"></i> <span class="">Cocaine</span></a>
                    </li>
                </ul>
            </nav>
        </aside>
        <div class="container-fluid">
            <div>
                <div class="table-responsive">
                    <div class="table-wrapper">
                        <div class="table-title">
                            <div class="row">
                                <div class="col-sm-5" style="display: flex; align-items: baseline; gap: 0 10px">
                                    <i id="menu-bar" style="font-size: 24px; cursor: pointer;" class="fa fa-bars" aria-hidden="true"></i>
                                    <h2>User <b>Management</b></h2>
                                </div>
                                <div class="col-sm-7">
                                    <a href="#" class="btn btn-secondary"><i class="material-icons">&#xE147;</i>
                                        <span>Add New User</span></a>
                                    <a href="#" class="btn btn-secondary"><i class="material-icons">&#xE24D;</i>
                                        <span>Export to Excel</span></a>
                                </div>
                            </div>
                        </div>

                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th>Date Created</th>
                                    <th>Role</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="u" items="${users}" varStatus="loop">
                                    <tr>
                                        <td>${loop.index + requestScope.startIndex}</td>
                                        <td>
                                            <a href="#"><img src="${pageContext.request.contextPath}/user-image/${u.image}" class="avatar" alt="Avatar" width="40"> ${u.name}</a>
                                        </td>
                                        <td>${u.age}</td>
                                        <td>${u.role}</td>
                                        <td><span class="status text-success">&bull;</span> Active</td>
<%--                                        <td><span class="status text-danger">&bull;</span> Suspended</td>--%>
<%--                                        <td><span class="status text-warning">&bull;</span> Inactive</td>--%>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/admin/user/setting?id=${u.id}" class="settings" title="Settings" data-toggle="tooltip"><i class="material-icons">&#xE8B8;</i></a>
                                            <a href="${pageContext.request.contextPath}/admin/user/remove?id=${u.id}" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE5C9;</i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                        <div class="clearfix">
                            <div class="hint-text">Showing <b>${requestScope.userPerPage}</b> out of <b>${requestScope.totalUsers}</b> entries</div>
                            <ul class="pagination">
                                <c:set var="c" value="${requestScope.currentPage}"/>
                                <c:if test="${c > 1}">
                                    <li class="page-item"><a href="${pageContext.request.contextPath}/admin/user?page=${c-1}" class="page-link">Previous</a></li>
                                </c:if>
                                <c:forEach varStatus="loop" begin="1" end="${requestScope.totalPages}" step="1">
                                    <li class="page-item ${loop.index == c ? "" : "active"}">
                                        <a href="${pageContext.request.contextPath}/admin/user?page=${loop.index}" class="page-link">${loop.index}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${c < requestScope.totalPages}">
                                    <li class="page-item"><a href="${pageContext.request.contextPath}/admin/user?page=${c+1}" class="page-link">Next</a></li>
                                </c:if>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();

                const menuBar = document.getElementById("menu-bar");
                const sideBar = document.getElementById("side-bar");
                const overlay = document.getElementById("overlay");

                menuBar.addEventListener("click", e => {
                    if (sideBar.classList.contains("active")) {
                        sideBar.classList.remove("active");
                        overlay.classList.remove("active");
                    } else {
                        sideBar.classList.add("active");
                        overlay.classList.add("active");
                    }
                });

                overlay.addEventListener("click", e => {
                    if (overlay.classList.contains("active")) {
                        sideBar.classList.remove("active");
                        overlay.classList.remove("active");
                    } else {
                        sideBar.classList.add("active");
                        overlay.classList.add("active");
                    }
                });

            });
        </script>
    </body>
</html>