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
                    Products <a href="<c:url value="/product/add"/> ">Add new product</a>
                </div>
                <table id="datatablesSimple">

                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>ISBN</th>
                        <th>Description</th>
                        <th>Category</th>
                        <th>Type</th>
                        <th>Supplier</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.title}</td>
                            <td>${product.author.name}</td>
                            <td>${product.isbn}</td>
                            <td>${product.description}</td>
                            <td>${product.category.name}</td>
                            <td>${product.productType}</td>
                            <td>${product.supplier.name}</td>
                            <td>
                                <a href="<c:url value="/product/delete/${product.id}"/>">Delete</a>
                                <a href="<c:url value="/product/${product.id}"/>">Update</a>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>


<%@include file="../fragments/footer.jsp" %>