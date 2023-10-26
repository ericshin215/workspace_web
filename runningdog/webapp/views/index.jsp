<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			
			
				<div class="profileWrapper">
				<div class="profileImg">
				<img src="${pageContext.request.contextPath}/assets/images/마루쉐.png" alt="">
			</div>
				<h1 class="userName">호두마루</h1>
				<button class="followButton">팔로우</button>
				
				</div>
				
				<div class="calendar">
				
				</div>

			</div>

		</div>

	</section>

</body>



</html>