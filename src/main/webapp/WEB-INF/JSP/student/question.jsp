<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: caim6
  Date: 06.12.2015
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="studentTemplate.jsp"/>



<div class="panel panel-heading"><h1>${question.question}</h1></div>

    <form:form class="form-horizontal" method="POST" action="/student/passing-test">
        <c:forEach items="${question.answers}" var="answer">
            <c:if test="${answer.active}">
                <div class="form-group">
                    <div class="col-md-offset-1 col-md-11">
                        <label id="checkbox-label" class="checkbox-inline">
                            <input type="checkbox" name="answer" value="${answer.idAnswer}"/>${answer.answer}
                        </label>
                    </div>
                </div>
            </c:if>
        </c:forEach>
        <div class="col-md-offset-4 col-md-4">
            <button type="submit" class="btn-func">Next</button>
        </div>
        <input type="hidden" value="${question.idQuestion}" name="id"/>
    </form:form>


