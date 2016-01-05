<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: caim6
  Date: 24.12.2015
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="advancedTutorTemplate.jsp"></jsp:include>

    <h1>Answer</h1>
    <form:form class="form-horizontal" method="post"  commandName="answerForm">

        <div class="form-group">
            <label for="answer" class="col-sm-2 control-label">Answer</label>
            <div class="col-sm-4 ">
                <input type="text" class="form-control" value="${answerForm.answer}" name="answer" placeholder="Write answer"/>
            </div>
        </div>

        <div class="checkbox">
            <label>
                <input type="checkbox" value="true" name="correct">
                Correct
            </label>
        </div>

        <button type="submit" class="btn btn-success">Save Question</button>
    </form:form>

