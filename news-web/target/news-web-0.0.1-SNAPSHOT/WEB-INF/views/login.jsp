<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<div class="position-relative">
		<div id="login-box" class="login-box visible widget-box no-border">
			<div class="widget-body">
				<div class="widget-main">
					<h4 class="header blue lighter bigger">
						<i class="ace-icon fa fa-coffee green"></i>
						<spring:message code="Label.Login" />
					</h4>
					<c:if test="${param.incorrectAccount != null}">
                    <div class="alert alert-block alert-danger">
							<spring:message code="Error.NotFound.loginForm.account" />
						</div>
					</c:if>
					<c:if test="${param.accessDenied != null}">
						<div class="alert alert-block alert-danger">
						<spring:message code="Error.User.Permission" /></div>
					</c:if>
					<div class="space-6"></div>

					<form action="j_spring_security_check" method="POST">
						<fieldset>
							<label class="block clearfix"> <span
								class="block input-icon input-icon-right"> <input
									type="text" class="form-control" id="username"
									name="j_username" placeholder="User name" required>

							</span>
							</label> <label class="block clearfix"> <span
								class="block input-icon input-icon-right"> <input
									type="password" class="form-control" id="password"
									name="j_password" placeholder="Password" required>
							</span>
							</label>

							<div class="space"></div>
							<div class="clearfix">
								<button type="submit"
									class="width-35 pull-right btn btn-sm btn-primary">
									<span class="bigger-110"><spring:message code="Label.login" text="Login"/></span>
								</button>
							</div>
							<div class="space-4"></div>
						</fieldset>
					</form>
					<div class="space-6"></div>
				</div>
				<!-- /.widget-main -->
			</div>
			<!-- /.widget-body -->
		</div>
		<!-- /.login-box -->
	</div>
	<!-- /.position-relative -->
</body>
</html>