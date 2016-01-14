<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<jsp:include page="../admin/admTemplate.jsp"></jsp:include>
<form:form class="form-horizontal" method="POST" commandName="adminForm">
    <h2>User Info</h2>
    <div class="form-group">
        <label for="email" class="col-md-offset-2 col-md-2 control-label ">Email</label>
        <div class="col-sm-4 ">
            <input type="email" class="form-control" id="email" value="${adminForm.email}" name="email" placeholder="${adminForm.email}"/>
        </div>
    </div>


    <div class="form-group">
        <label for="login" class="col-md-offset-2 col-md-2 control-label">Login</label>
        <div class="col-sm-4 ">
            <input type="text" class="form-control" value="${adminForm.login}" id="login" name="login" placeholder="${adminForm.login}"/>
        </div>
    </div>


    <div class="form-group">
        <label for="password" class="col-md-offset-2 col-md-2 control-label">Password</label>
        <div class="col-sm-4 ">
            <input type="password" class="form-control" value="${adminForm.password}" id="password" name="password"
                   placeholder="${adminForm.password}"/>
        </div>
    </div>

    <div class="form-group">
        <label for="name" class="col-md-offset-2 col-md-2 control-label">Full name</label>
        <div class="col-sm-4 ">
            <input type="text" class="form-control" value="${adminForm.name}" id="name" name="name" placeholder="${adminForm.name}"/>
        </div>
    </div>
    <div class="col-md-6 col-lg-offset-2">
        <div id="form_roles">
            <form:checkboxes path="checkRoles" items="${adminForm.allRoles}" itemLabel="name"
                             itemValue="id" delimiter="<strong>"/>
        </div>
    </div>
    <div class="col-md-6">
    <div class="checkbox">
        <label>
            <input type="checkbox" path="active" value="true" id="active" name="active">
            Active
        </label>
    </div>
    <div class="checkbox">
        <label >
            <input type="checkbox" path="confirmed" value="true" id="confirmed" name="confirmed">
            Confirmed
        </label>
    </div>
    </div>

    <button type="submit" class="btn btn-success">Save</button>
</form:form>