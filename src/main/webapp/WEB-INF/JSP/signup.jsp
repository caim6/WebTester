<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%--
  Created by IntelliJ IDEA.
  User: caim6
  Date: 27.11.2015
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<div class="text-center col-md-10">

    <form:form class="form-horizontal" action="/signup/ok" commandName="signUpForm">

        <tr>
            <td colspan="2" class="errors"><form:errors path="*"/></td>
        </tr>
        <div class="form-group">
            <h2>Sign up </h2>
            <label for="login" class="col-sm-2 control-label">Login</label>
            <div class="col-sm-8 ">
                <input type="text" class="form-control" name="login" placeholder="Write login"/>
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-8 ">
                <input type="text" class="form-control" name="email" placeholder="Write email"/>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" name="password" placeholder="Write password"/>
            </div>
        </div>

        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Full name</label>
            <div class="col-sm-8 ">
                <input type="text" class="form-control" name="name" placeholder="Write full name"/>
            </div>


        </div>
        <button type="submit" class="btn btn-success">Sign up</button>


    </form:form>
</div>

