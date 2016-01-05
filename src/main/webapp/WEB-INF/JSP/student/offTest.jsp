
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: caim6
  Date: 06.12.2015
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Testing</title>
</head>

<h1>{$TestName}</h1>
<table align="center">
    <c:forEach var="test" items="${tests}">
        <tr>
            <td>
                <a href="/question/id${test.id}">${test.name}</a>
            </td>
        </tr>
    </c:forEach>
</table>
<body>

</body>
</html>