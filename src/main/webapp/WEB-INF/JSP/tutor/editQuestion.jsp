<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--
  Created by IntelliJ IDEA.
  User: caim6
  Date: 06.12.2015
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="tutorTemplate.jsp"></jsp:include>


    <div>
        <h3>Question: ${questionForm.name}</h3>
        <a class="btn-default" href="/tutor/edit/question/id${questionId}">Change name of question</a>
        <a class="btn-default" href="/tutor/edit/new/answer/id${questionId}">Add new answer</a>
    </div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Answer</th>
            <th>Correct</th>
        </tr>
        </thead>
        <c:forEach var="answer" items="${answers}">
            <tr>
                <td>
                    <a class="btn-default" href="/tutor/edit/answer/id${answer.id}/${questionId}">${answer.answer}</a>
                </td>
                <td>${answer.correct} </td>
                <td><a class="btn-default" href="/tutor/delete/answer/id${answer.id}/${questionId}">Delete</a></td>

            </tr>
        </c:forEach>

    </table>


