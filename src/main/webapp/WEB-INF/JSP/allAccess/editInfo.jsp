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
  Date: 06.12.2015
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<div class="container">
    <h2>Your Info</h2>
    <form:form class="form-horizontal" action="editInfoOk" commandName="userForm">
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-4 ">
            <input type="email" class="form-control" name="email"/>
        </div>
        </div>

        <div class="form-group">
            <label for="login" class="col-sm-2 control-label">Login</label>
            <div class="col-sm-4 ">
                <input type="text" class="form-control" name="login"/>
            </div>
            </div>


            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">Password</label>
                <div class="col-sm-4 ">
                    <input type="password" class="form-control" name="password"/>
                </div>
                </div>

                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Full name</label>
                    <div class="col-sm-4 ">
                        <input type="text" class="form-control" name="name"/>
                    </div>
                    </div>


                    <button type="submit" class="btn btn-success" name="button" value="save">Save</button>

                    </form:form>
                </div>