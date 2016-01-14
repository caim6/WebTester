<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<jsp:include page="advancedTutorTemplate.jsp"></jsp:include>

    <h1>Test list</h1>

            <a class="btn btn-default" href="/tutor/newTest" role="button">Add new test</a>

    <div class="col-sm-6">
    <table class="table table-hover">
        <thead class="text-center">
        <tr>
            <th> Title</th>
            <th> Period per question</th>
            <th>Description</th>
        </tr>
        </thead>
        <c:forEach var="test" items="${tests}">
            <tr>
                <td>
                    <a href="/tutor/questions/id${test.id}">${test.title}</a>
                </td>
                <td>${test.periodPerQuestion} </td>
                <td>${test.description}</td>
                <td><a class="btn-default" href="/tutor/delete/test/id${test.idTest}">Delete</a></td>

            </tr>
        </c:forEach>
    </table>
</div>



