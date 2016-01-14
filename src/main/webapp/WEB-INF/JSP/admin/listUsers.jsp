<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel="stylesheet" type="text/css" href="${context}/resources/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="${context}/resources/css/bootstrap-theme.css"/>



<jsp:include page="../admin/admTemplate.jsp"></jsp:include>
<h1> Users list</h1>
<div class="col-sm-12">
        <table class="table table-hover">
            <thead>
            <tr>
                <th> Login</th>
                <th>Active</th>
                <th> Email</th>
                <th> Confirmed</th>
                <th> Full name</th>

            </tr>
            </thead>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>
                        <a href="/admin/id${user.id}">${user.login}</a>
                    </td>

                    <td> ${user.active}</td>

                    <td>${user.email}</td>

                    <td>${user.confirmed}</td>

                    <td>${user.name}</td>

                    <td><a class="btn-default" href="/admin/delete/user/id${user.id}"> Delete</a> </td>

                </tr>

            </c:forEach>
        </table>
    </div>

<%--<jsp:include page="../templates/footer.jsp"/>--%>