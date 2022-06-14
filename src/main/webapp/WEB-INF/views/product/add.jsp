<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Register - SB Admin</title>
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet" />
    <script src="<c:url value="https://use.fontawesome.com/releases/v6.1.0/js/all.js"/> " crossorigin="anonymous"></script>
</head>
<body class="bg-primary">

<div id="layoutAuthentication">
    <div id="layoutAuthentication_content">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-7">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Add product</h3></div>
                            <div class="card-body">
                                <form:form method="post" modelAttribute="product">
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <form:input class="form-control"  id="inputTitle" type="text" placeholder="Enter product's title"  path="title"/>
                                                <label for="inputTitle">Title</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <form:input class="form-control"  id="inputDescription" type="textarea" placeholder="Enter product's description"  path="description"/>
                                                <label for="inputDescription">Description</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <form:input class="form-control"  id="inputIsbn" type="text" placeholder="Enter product's isbn"  path="isbn"/>
                                                <label for="inputIsbn">ISBN</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <form:select class="form-control"  id="inputType" items="${type}" placeholder="Choose product's type"  path="productType"/>
                                                <label for="inputType">Type</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <form:select class="form-control"  id="inputAuthor" itemValue="id" itemLabel="name" items="${author}" placeholder="Enter product's author"  path="author"/>
                                                <label for="inputAuthor">Author</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <form:select class="form-control"  id="inputCategory"  itemValue="id" itemLabel="name" items="${category}" placeholder="Choose product's categpry"  path="category"/>
                                                <label for="inputCategory">Category</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <form:select class="form-control"  id="inputSupplier" itemValue="id" itemLabel="name" items="${supplier}" placeholder="Choose product's supplier"  path="supplier"/>
                                                <label for="inputSupplier">Supplier</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mt-4 mb-0">
                                        <div class="d-grid"><input type="submit" class="btn btn-primary btn-block" value="Save"/></div>

                                    </div>
                                </form:form>
                            </div>
                            <div class="card-footer text-center py-3">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
    <div id="layoutAuthentication_footer">
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid px-4">
                <div class="d-flex align-items-center justify-content-between small">
                    <div class="text-muted">Copyright &copy; Katarzyna Pawlas 2022</div>
                    <div>
                        <a href="#">Privacy Policy</a>
                        &middot;
                        <a href="#">Terms &amp; Conditions</a>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>
<script src="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"/>" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/scripts.js"/>"></script>
</body>
</html>
