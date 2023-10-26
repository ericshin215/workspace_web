<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId={클라이언트id}"></script>
<body>
    맵 위에 선 그리기 (산책로)
    <div id="map" style="width:400px; height:400px;"></div>
    <button id="btn">완성</button>
    <br>
    
    <script>
        var map = new naver.maps.Map('map');
        var chk = true;
        var btn = document.querySelector("#btn");
        console.log(btn);
        btn.addEventListener("click", function(){
            chk = false;
        });

        var polylines = []; // 기존의 모든 폴리라인을 저장하는 배열
        var currentPolyline = null; // 현재 그리고 있는 폴리라인을 저장하는 변수

        naver.maps.Event.addListener(map, 'click', function(e) {
            if(chk){
                var point = e.coord;
                
                // 현재 폴리라인이 없거나 폴리라인이 닫혔을 때 새로운 폴리라인을 시작
                if (!currentPolyline || currentPolyline.getPath().getLength() > 1) {
                    currentPolyline = new naver.maps.Polyline({
                        map: map,
                        path: [],
                        strokeColor: '#5347AA',
                        strokeWeight: 5,
                        clickable: true,
                    });

                    // 현재의 폴리라인을 배열에 추가
                    polylines.push(currentPolyline);
                }
                
                var path = currentPolyline.getPath();
                path.push(e.coord);
                console.log(e.coord);
            }
        });

        naver.maps.Event.addListener(polylines, 'click', function(e) {
            if(!chk) {
                var marker = new naver.maps.Marker({
                    position: e.coord,
                    map: map
                });
            }
        });
    </script>
</body>
</html>