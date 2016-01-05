<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--
  Created by IntelliJ IDEA.
  User: caim6
  Date: 12.12.2015
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="tutorTemplate.jsp"></jsp:include>


    <h1>New test</h1>
    <form:form class="form-horizontal" method="POST" commandName="testForm">
        <div class="text-center">
        <table class="table table-hover">

            <div class="form-group">
                <label for="title" class="col-sm-2 control-label">Test name</label>
                <div class="col-sm-4 ">
                    <input  type="text" class="form-control" id="title" name="title" placeholder="Write title"/>
                </div>
            </div>

            <div class="form-group">
                <label for="periodPerQuestion" class="col-sm-2 control-label">Period per question</label>
                <div class="col-sm-4 ">
                    <input type="number" class="form-control" name="periodPerQuestion" placeholder="Period per question"/>
                </div>
            </div>

            <div class="form-group">
                <label for="description" class="col-sm-2 control-label">Description</label>
                <div class="col-sm-4 ">
                    <input type="text" class="form-control" name="description" placeholder="Period per question"/>
                </div>
            </div>

            <button type="submit" class="btn btn-success">Add new test</button>
        </table>
        </div>
    </form:form>

