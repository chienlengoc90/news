<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="formUrl" value="/ajax/news"/>
<html>
<head>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
</head>
<body>
<div class="modal-dialog">
	<!-- Modal content-->
	<div class="modal-content">

		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">&times;</button>
			<h4 class="modal-title">Modal Header</h4>
		</div>

		<div class="modal-body">

			<form:form id="formEdit" commandName="model">

				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"><spring:message
							code="Label.User.userName" text="User Name" /></label>
					<div class="col-sm-9">
						<form:input path="userName" id="userName" name="userName" />
					</div>
				</div>
				<br />
				<br />
				
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"><spring:message
							code="Label.User.fullName" text="Full Name" /></label>
					<div class="col-sm-9">
						<form:input path="fullName" id="fullName" name="fullName" />
					</div>
				</div>
				<br />
				<br />
				
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"><spring:message
							code="abel.User.PassWord" text="PassWord" /></label>
					<div class="col-sm-9">
						<form:input path="password" id="password" name="password"/>
					</div>
				</div>
				<br />
				<br />
				
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"><spring:message
							code="Label.User.email" text="Email" /></label>
					<div class="col-sm-9">
						<form:input path="email" id="email" name="email" />
					</div>
				</div>
				<br />
				<br />
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"><spring:message
							code="Label.User.phoneNumber" text="Phone Number" /></label>
					<div class="col-sm-9">
						<form:input path="phoneNumber" id="phoneNumber" name="phoneNumber" />
					</div>
				</div>
				<br />
				<br />
				<form:hidden path="id" id="usersID" />
			</form:form>

			<br />
			<br />
		</div>
	</div>
	<div class="modal-footer">
		<c:if test="${not empty model.id}">
			<input type="submit" class="btn btn-white btn-warning btn-bold"
				value='<spring:message code="Label.New.Edit" text="Add new Post"/>'
				id="btnAddOrUpdateNews" />
		</c:if>
		<c:if test="${empty model.id}">
			<input type="submit" class="btn btn-white btn-warning btn-bold"
				value='<spring:message code="Label.New.Add" text="Update Post"/>'
				id="btnAddOrUpdateNews" />
		</c:if>
		<input type="button" class="btn btn-white btn-warning btn-bold"
			data-dismiss="modal" value="Close" />
	</div>
</div>

</body>
</html>
