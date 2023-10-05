<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<div id="header" class="clearfix">
		
			<c:if test="${requestScope.blogVo.getBlogTitle()==null}">
			<h1><a href="">${requestScope.userVo.getUserName()}의 블로그입니다.</a></h1>
			</c:if>
			
			<ul class="clearfix">
			
			
			
				<!-- 로그인 전 메뉴 -->
				<c:if test="${sessionScope.authUser.id == null}">
				<li><a class="btn_s" href="${pageContext.request.contextPath}/user/loginForm">로그인</a></li>
				
				
				</c:if>
				
				
				<c:if test="${sessionScope.authUser.id == requestScope.blogVo.getId()}">
				<!-- 로그인 후 메뉴 
				자신의 블로그일때만 관리 메뉴가 보인다.-->
				
				<li><a class="btn_s" href="">내블로그 관리</a></li>
				
		 		</c:if>
		 		<c:if test="${sessionScope.authUser.id != null}">
		 		<li><a class="btn_s" href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
		 		</c:if>
			</ul>
		</div>
		<!-- //header -->
		