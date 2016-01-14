
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">
    <div class="col-md-8">
    <h2>Your info</h2>
    <table class="table table-hover" align="center">
        <tr>
            <td>Email</td>
            <td>${account.email} </td>
        </tr>
        <tr>
            <td>Login</td>
            <td>${account.login} </td>
        </tr>
        <tr>
            <td>Full name</td>
            <td>${account.name} </td>
        </tr>
        <tr>
            <td>Created</td>
            <td>${account.created} </td>
        </tr>

    </table>
    </div>
</div>