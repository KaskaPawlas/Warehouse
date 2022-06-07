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
                    Authors <a href="<c:url value="/supplier/add"/> ">Add new supplier</a>
                </div>
                <table id="datatablesSimple">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>NIP</th>
                        <th>Type</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${suppliers}" var="supplier">
                        <tr>
                            <td>${supplier.id}</td>
                            <td>${supplier.name}</td>
                            <td>${supplier.nip}</td>
                            <td>${supplier.type}</td>
                            <td>
                                <a href="<c:url value="/supplier/delete/${supplier.id}"/>">Delete</a>
                                <a href="<c:url value="/supplier/${supplier.id}"/>">Update</a>
                                <a href="">Products</a>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>


<%@include file="../fragments/footer.jsp" %>