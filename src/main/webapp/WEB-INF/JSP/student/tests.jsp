<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: caim6
  Date: 06.12.2015
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="studentTemplate.jsp"/>

<h1>Tests available!</h1>
<table class="table table-hover">
    <thead>
    <tr>
        <th> Title</th>
        <th>Period per question</th>
        <th> Description </th>
    </tr>
    </thead>
    <c:forEach var="test" items="${tests}">
        <tr>
            <td>
                <a href="/pass-test/id${test.id}"> ${test.title} </a>
            </td>
            <td> ${test.periodPerQuestion}</td>
            <td>${test.description}</td>
        </tr>
    </c:forEach>
</table>

