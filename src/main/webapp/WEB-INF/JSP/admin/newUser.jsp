<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--
  Created by IntelliJ IDEA.
  User: caim6
  Date: 24.12.2015
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="../admin/admTemplate.jsp"></jsp:include>
<form:form class="form-horizontal" method="POST" commandName="adminForm">
    <h1>User Info</h1>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-4 ">
            <input type="email" class="form-control" id="email" name="email"/>
        </div>
    </div>
    <div class="form-group">
        <label for="login" class="col-sm-2 control-label">Login</label>
        <div class="col-sm-4 ">
            <input type="text" class="form-control" id="login" name="login"/>
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-4 ">
            <input type="password" class="form-control" id="password" name="password"/>
        </div>
    </div>
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Full name</label>
        <div class="col-sm-4 ">
            <input type="text" class="form-control" id="name" name="name"/>
        </div>
    </div>
    <button type="submit" class="btn btn-success">Add new user</button>

</form:form>
