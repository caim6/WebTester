<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: caim6
  Date: 17.12.2015
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="advancedTutorTemplate.jsp"></jsp:include>

    <h1>Question list of test with title: ${test.title}</h1>
    <a class="btn btn-default" href="/tutor/newQuestion/id${test.idTest}" role="button">Add new question</a>
    <div class="col-sm-6">
    <table class="table table-hover">
        <thead class="text-center">
        <th> Question</th>
        </thead>
            <c:forEach var="question" items="${questions}">

                <tr>
                    <td>
                        <a href="/tutor/editQuestion/id${question.id}">${question.question}</a>
                    </td>
                    <td><a class="btn-default" href="/tutor/delete/question/id${question.id}/${test.idTest}">Delete</a></td>

                </tr>
            </c:forEach>


    </table>
    </div>
