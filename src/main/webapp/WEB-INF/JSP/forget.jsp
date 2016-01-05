<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel="stylesheet" type="text/css" href="${context}/resources/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="${context}/resources/css/bootstrap-theme.css"/>

<%--
  Created by IntelliJ IDEA.
  User: caim6
  Date: 02.12.2015
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>

    <h2>Please write email</h2>
    <form:form class="form-horizontal" action="/forgetOk" commandName="signUpForm">
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-4 ">
                <input type="email" class="form-control" name="email" placeholder="Write email"/>
            </div>
        </div>
        <button type="submit" class="btn btn-success">Send</button>
    </form:form>

