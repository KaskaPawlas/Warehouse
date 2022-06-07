<%@include file="../fragments/header.jsp" %>
<%@include file="../fragments/sideMenu.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Dashboard</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">Dashboard</li>
            </ol>
            <div class="card mb-4 container-fluid px-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    Authors <a href="<c:url value="/category/add"/> ">Add new category</a>
                </div>
                <table id="datatablesSimple">

                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${categories}" var="category">
                        <tr>
                            <td>${category.id}</td>
                            <td>${category.name}</td>
                            <td>
                                <a href="<c:url value="/author/delete/${category.id}"/>">Delete</a>
                                <a href="<c:url value="/author/update/${category.id}"/>">Update</a>
                                <a href="">Products</a>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>


<%@include file="../fragments/footer.jsp" %>