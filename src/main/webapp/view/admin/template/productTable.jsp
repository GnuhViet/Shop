<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
  <div>
    <div class="table-responsive">
      <div class="table-wrapper">
        <div class="table-title">
          <div class="row">
            <div class="col-sm" style="display: flex; align-items: baseline; gap: 0 10px">
              <i id="menu-bar" style="font-size: 24px; cursor: pointer;" class="fa fa-bars" aria-hidden="true"></i>
              <h2>Product <b>Management</b></h2>
            </div>
            <form class="col-sm-6 form-inline" action="${pageContext.request.contextPath}/admin/user" method="get">
              <input name="search" class="form-control" type="search" placeholder="name" aria-label="Search" style="width: 80%;">
              <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
            <div class="col-sm">
              <a href="register" class="btn btn-secondary"><i class="material-icons">&#xE147;</i>
                <span>Add New Product</span></a>
              <a href="#" class="btn btn-secondary"><i class="material-icons">&#xE24D;</i>
                <span>Export to Excel</span></a>
            </div>
          </div>
        </div>

        <table class="table table-striped table-hover">
          <thead>
            <tr>
              <th>#</th>
              <th>Id</th>
              <th>Name</th>
              <th>Type</th>
              <th>Price</th>
              <th>Rating</th>
              <th>Color</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="p" items="${requestScope.products}" varStatus="loop">
              <tr>
                <td>${loop.index + requestScope.startIndex}</td>
                <td>
                  <a href="#"><img src="${pageContext.request.contextPath}/user-image/${p.image}" class="avatar" alt="Avatar" width="40"> ${p.id}
                  </a>
                </td>
                <td>${p.name}</td>
                <td>${p.type}</td>
                <td>${p.price}</td>
                <td>${p.rating}</td>
                <td>${p.color}</td>
                <td>
                  <a href="${pageContext.request.contextPath}/admin/product/setting?id=${u.id}" class="settings" title="Settings" data-toggle="tooltip"><i class="material-icons">&#xE8B8;</i></a>
                  <a href="${pageContext.request.contextPath}/admin/product/remove?id=${u.id}" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE5C9;</i></a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>

        <div class="clearfix">
          <div class="hint-text">Showing <b>${requestScope.userPerPage}</b> out of
            <b>${requestScope.totalUsers}</b> entries
          </div>
          <ul class="pagination">
            <c:set var="c" value="${requestScope.currentPage}"/>
            <c:choose>
              <c:when test="${requestScope.search == null}">
                <c:if test="${c > 1}">
                  <li class="page-item">
                    <a href="${pageContext.request.contextPath}/admin/product?page=${c-1}" class="page-link">Previous</a>
                  </li>
                </c:if>
                <c:forEach varStatus="loop" begin="1" end="${requestScope.totalPages}" step="1">
                  <li class="page-item ${loop.index == c ? "" : "active"}">
                    <a href="${pageContext.request.contextPath}/admin/product?page=${loop.index}" class="page-link">${loop.index}</a>
                  </li>
                </c:forEach>
                <c:if test="${c < requestScope.totalPages}">
                  <li class="page-item">
                    <a href="${pageContext.request.contextPath}/admin/product?page=${c+1}" class="page-link">Next</a>
                  </li>
                </c:if>
              </c:when>

              <c:otherwise>
                <c:if test="${c > 1}">
                  <li class="page-item">
                    <a href="${pageContext.request.contextPath}/admin/product?search${requestScope.search}&page=${c-1}" class="page-link">Previous</a>
                  </li>
                </c:if>
                <c:forEach varStatus="loop" begin="1" end="${requestScope.totalPages}" step="1">
                  <li class="page-item ${loop.index == c ? "" : "active"}">
                    <a href="${pageContext.request.contextPath}/admin/product?search=${requestScope.search}&page=${loop.index}" class="page-link">${loop.index}</a>
                  </li>
                </c:forEach>
                <c:if test="${c < requestScope.totalPages}">
                  <li class="page-item">
                    <a href="${pageContext.request.contextPath}/admin/product?search=${requestScope.search}&page=${c+1}" class="page-link">Next</a>
                  </li>
                </c:if>
              </c:otherwise>
            </c:choose>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>