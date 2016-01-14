
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="studentTemplate.jsp"></jsp:include>


    <h1>Result</h1>

    <table class="table table-hover">
        <thead>
        <tr>
            <th> Test name </th>
            <th> User correct answers </th>
            <th> All correct answers </th>
            <th> Date </th>
        </tr>
        </thead>
        <c:forEach var="result" items="${results}">
            <tr>
                <td>
                        ${result.testName}
                </td>
                <td>
                        ${result.correctCount}
                </td>
                <td>
                        ${result.allCount}
                </td>
                <td>
                        ${result.created}
                </td>
            </tr>
        </c:forEach>
    </table>


