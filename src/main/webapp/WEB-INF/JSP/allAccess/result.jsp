
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--
  Created by IntelliJ IDEA.
  User: caim6
  Date: 06.12.2015
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
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


