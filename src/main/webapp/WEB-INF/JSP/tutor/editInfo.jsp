<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: caim6
  Date: 24.12.2015
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="tutorTemplate.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form class="form-horizontal" method="POST" commandName="userForm">
    <h1>Your info</h1>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-4 ">
            <input type="email" class="form-control" value="${userForm.email}" id="email" name="email"/>
        </div>
</div>

        <div class="form-group">
            <label for="login" class="col-sm-2 control-label">Login</label>
            <div class="col-sm-4 ">
                <input type="text" class="form-control" value="${userForm.login}" id="login" name="login"/>
            </div>
            </div>


            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">Password</label>
                <div class="col-sm-4 ">
                    <input type="password" class="form-control" value="${userForm.password}" id="password" name="password"/>
                </div>
            </div>

            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">Full name</label>
                <div class="col-sm-4 ">
                    <input type="text" class="form-control" id="name" value="${userForm.name}" name="name"/>
                </div>
            </div>


            <button type="submit" class="btn btn-success">Save</button>

</form:form>