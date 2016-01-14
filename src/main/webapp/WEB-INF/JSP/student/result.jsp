
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<jsp:include page="studentTemplate.jsp"></jsp:include>
<h3>Congratulations</h3>

<div id="result">
    <p>You have passed test named "${testResult.testName}"</p>

    <p>You have answered right on ${testResult.correctCount}
        ${testResult.correctCount > 1 ? "questions" : "question"} of ${testResult.allCount}</p>

    <p>All you test results statistic you can find in "test results" menu</p>
</div>