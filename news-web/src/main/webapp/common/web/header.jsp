<%@ page import="vn.chienlengoc.utils.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="header">
			<div class="headertop_desc">
				<div class="call">
					<p>
						<span>Need help?</span> call us
						<span class="number">1-22-3456789</span>
						
					</p>
				</div>
				<div class="account_desc">
					<ul>
						<security:authorize access="isAnonymous()"> 
							<li>
								<a href="#">Đăng ký</a>
							</li>
							<li>
								<a href='<c:url value="/dang-nhap"/>'>Đăng nhập</a>
							</li>						
						</security:authorize>	
						<security:authorize access="isAuthenticated()">
							<li>
								Welcome, <%=SecurityUtils.getPrincipal().getFullName()%>
							</li>
							<li>
								<a href='<c:url value="/logout"/>'>Thoát</a>
							</li>						
						</security:authorize>																	
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<div class="header_top">
				<div class="logo">
					<a href="index.html">
						<img src="images/logo.png" alt="">
					</a>
				</div>
				<div class="cart">
					<p>Welcome to our Online Store!
						<span>Cart:</span>
						</p><div id="dd" class="wrapper-dropdown-2"> 0 item(s) - $0.00
							<ul class="dropdown">
								<li>you have no items in your Shopping cart</li>
							</ul>
						</div>
					<p></p>
				</div>
				<script type="text/javascript">
					function DropDown(el) {
						this.dd = el;
						this.initEvents();
					}
					DropDown.prototype = {
						initEvents: function () {
							var obj = this;

							obj.dd.on('click', function (event) {
								$(this).toggleClass('active');
								event.stopPropagation();
							});
						}
					}

					$(function () {

						var dd = new DropDown($('#dd'));

						$(document).click(function () {
							// all dropdowns
							$('.wrapper-dropdown-2').removeClass('active');
						});

					});
				</script>
				<div class="clear">

				</div>
			</div>
			<div class="header_bottom">
				<div class="menu">
					<ul>
						<li class="active">
							<a href="index.html">Home</a>
						</li>
						<li>
							<a href="about.html">About</a>
						</li>
						<li>
							<a href="delivery.html">Delivery</a>
						</li>
						<li>
							<a href="news.html">News</a>
						</li>
						<li>
							<a href="contact.html">Contact</a>
						</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="search_box">
					<form>
						<input type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
						<input type="submit" value="">
					</form>
				</div>
				<div class="clear"></div>
			</div>

</div>