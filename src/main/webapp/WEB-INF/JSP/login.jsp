<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div>
    <h2>Please login</h2>
    <form class="form-horizontal" method="POST" action="${context }/loginHandler">
        <c:if test="${sessionScope.SPRING_SECURITY_LAST_EXCEPTION != null }">
            ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message }
        </c:if>

        <div class="form-group">
            <label for="j_username" class="col-sm-2 control-label">Login</label>
            <div class="col-sm-4 ">
                <input type="text" class="form-control" name="j_username" placeholder="Write login"/>
            </div>
        </div>

        <div class="form-group">
            <label for="j_password" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" name="j_password" placeholder="Write Password"/>
            </div>
        </div>

        <div class="col-md-4 col-lg-offset-2">
            <select class="form-control" name="idRole">
                <c:forEach var="role" items="${roles }">
                    <option value="${role.idRole }">${role.name }</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-success">Login</button>
    </form>
    <a class="btn btn-default" href="/forget" role="button">Forget password</a>

    <a class="btn btn-default" href="/signup" role="button">New user</a>


    <div class="checkbox">
        <label>
            <input type="checkbox" value="true" name="_spring_security_remember_me">
            Remember me
        </label>
    </div>
</div>


<%--
<tr>
    <td colspan="2" style="text-align:center;padding-top:20px;">
        <a href="${context }/fbLogin">
            <img alt="fbLogin" src="${context }/resources/images/login-facebook.png"/>

--%>

