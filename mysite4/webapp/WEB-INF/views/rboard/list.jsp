<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">

</head>


<body>
	<div id="wrap">

		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<!-- //nav -->

		<div id="container" class="clearfix">
			<div id="aside">
				<h2>게시판</h2>
				<ul>
					<li><a href="">일반게시판</a></li>
					<li><a href="">댓글게시판</a></li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">

				<div id="content-head">
					<h3>댓글게시판</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>게시판</li>
							<li class="last">댓글게시판</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->

				<div id="board">
					<div id="list">
						<form action="search" method="">
							<div class="form-group text-right">
								<input type="text" name="word">
								<button type="submit" id=btn_search>검색</button>
							</div>
						</form>
						<table>
							<thead>
								<tr>
									<th>no</th>
									<th>title</th>
									<th>name</th>
									<th>hit</th>
									<th>작성일</th>
									<th>group_no</th>
									<th>order_no</th>
									<th>depth</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody >
							
							<c:forEach items="${rboardList}" var="rboardVo">
								<tr>
									<td>${rboardVo.no}</td>
									<td class="text-left"><a href="${pageContext.request.contextPath}/rboard/read?no=${rboardVo.no}">${rboardVo.title}</a></td>
									<td>${rboardVo.name}</td>
									<td>${rboardVo.hit}</td>
									<td>${rboardVo.reg_date}</td>
									<td>${rboardVo.group_no}</td>
									<td>${rboardVo.order_no}</td>
									<td>${rboardVo.depth}</td>
									<c:if test="${rboardVo.userNo == authUser.no}" >
							<td><a href="${pageContext.request.contextPath}/rboard/delete?no=${rboardVo.no}">[삭제]</a></td>
							</c:if>
									
								</tr>
							</c:forEach>
								
								
							</tbody>
						</table>

						<div id="paging">
							<ul>
								<li><a href="">◀</a></li>
								<li><a href="">1</a></li>
								<li><a href="">2</a></li>
								<li><a href="">3</a></li>
								<li><a href="">4</a></li>
								<li class="active"><a href="">5</a></li>
								<li><a href="">6</a></li>
								<li><a href="">7</a></li>
								<li><a href="">8</a></li>
								<li><a href="">9</a></li>
								<li><a href="">10</a></li>
								<li><a href="">▶</a></li>
							</ul>


							<div class="clear"></div>
						</div>
						<c:if test="${authUser.no != null}" >
						<a id="btn_write" href="${pageContext.request.contextPath}/rboard/writeForm">글쓰기</a>
						</c:if>
					</div>
					<!-- //list -->
				</div>
				<!-- //board -->
			</div>
			<!-- //content  -->

		</div>
		<!-- //container  -->

		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

</html>
