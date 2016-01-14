<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="admTemplate.jsp"></jsp:include>
<form:form class="form-horizontal" method="POST" commandName="adminForm">
    <h1>Your info</h1>

    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-4 ">
            <input type="email" class="form-control" value="${adminForm.email}" id="email" name="email"/>
        </div>
    </div>




    <div class="form-group">
        <label for="login" class="col-sm-2 control-label">Login</label>
        <div class="col-sm-4 ">
            <input type="text" class="form-control" value="${adminForm.login}" id="login" name="login"/>
        </div>
    </div>



    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-4 control-label">
            <input type="password" class="form-control" value="${adminForm.password}" id="password" name="password"/>
        </div>
    </div>

    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Full name</label>
        <div class="col-sm-4 ">
            <input type="text" class="form-control" value="${adminForm.name}" id="name" name="name"/>
        </div>
    </div>


    <button type="submit" class="btn btn-success">Save</button>

</form:form>