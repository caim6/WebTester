<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--
  Created by IntelliJ IDEA.
  User: caim6
  Date: 20.12.2015
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="advancedTutorTemplate.jsp"></jsp:include>

    <h1>Question</h1>
    <form:form class="form-horizontal" method="post"  commandName="questionForm">

        <div class="form-group">
            <label for="question" class="col-sm-2 control-label">Question</label>
            <div class="col-sm-4 ">
                <input type="text" class="form-control" value="${questionForm.name}" name="name" placeholder="Write question"/>
            </div>
        </div>

        <button type="submit" class="btn btn-success">Save Question</button>
    </form:form>

