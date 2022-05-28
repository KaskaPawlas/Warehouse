<%@include file="../fragments/header.jsp"%>
<%@include file="../fragments/sideMenu.jsp"%>
<div class="card mb-4 container-fluid px-4">
    <div class="card-header">
        <i class="fas fa-table me-1"></i>
        DataTable Example
    </div>
    <div class="card-body">
        <table id="datatablesSimple">
            <thead>
            <tr>
                <th>ID</th>
                <th>First name</th>
                <th>Last Name</th>
                <th>Action</th>
            </tr>
            </thead>
<%--            <tfoot>--%>
<%--            <tr>--%>
<%--                <th>Name</th>--%>
<%--                <th>Position</th>--%>
<%--                <th>Office</th>--%>
<%--                <th>Age</th>--%>
<%--                <th>Start date</th>--%>
<%--                <th>Salary</th>--%>
<%--            </tr>--%>
<%--            </tfoot>--%>
            <tbody>
            <c:forEach items="${authors}" var="author">
                <tr>
                    <td>${author.id}</td>
                    <td>${author.firstName}</td>
                    <td>${author.lastName}</td>
                    <td>
                        <a href="<c:url value="/author/delete/${author.id}"/>">Delete</a>
                        <a href="<c:url value="/author/update/${author.id}"/>">Update</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>


<%@include file="../fragments/footer.jsp"%>