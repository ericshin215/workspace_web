<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/index.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/98aecd1b62.js" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>


	<div class="backgroundImg">
		<img src="${pageContext.request.contextPath}/assets/images/산책로.png" alt="">

	</div>



	<section>
		<div class="contents">




			<div class="profileSection">
				<div class="calendar"></div>

				<div class="profileWrapper">
					<div class="wrap">
						<div class="profileImg">
							<img src="${pageContext.request.contextPath}/assets/images/마루쉐.png" alt="">
						</div>
						<h1 class="userName">호두마루</h1>
						<button class="followButton">팔로우</button>
					</div>
					<div class="maindogCard"></div>


				</div>



			</div>

			<div class="mainWrapper">

				<div class="mainPosts">
					
					<div class="category">
					<div class="tab record active">산책기록</div>
					<div class="tab meeting">산책모임</div>
					<div class="tab following">팔로잉</div>
					<div class="tab blank"></div>
					</div>
					<h2>팔로잉</h2>
					<div class="selector">
					<select class="form-select form-select-sm" aria-label="Small select example">
						<option selected>팔로잉</option>
						<option value="1">팔로워</option>
						
						
					</select>
					</div>
					
					


				</div>


				<div class="mainSidebar">
					<div class="clubsWrapper">
						<h3 class="clubs">동아리</h3>
						<div class="clubBox">
							<div></div>
							<div></div>
							<div></div>
							<div></div>
							<div></div>
							<div></div>
						</div>
					</div>
					<div class="socialWrapper">
						<div class="socialBox">
						<h3 class="social">소셜 네트워크</h3>
						<div class="followingBox">
						<div class="followText">팔로잉</div>
						<div class="followNum">1</div>
						</div>
						<div class="followerBox">
						<div class="followText">팔로워</div>
						<div class="followNum">0</div>
						</div>
						</div>
						
						
					</div>
					<div class="stats"></div>
				</div>

			</div>



		</div>

	</section>

</body>



</html>