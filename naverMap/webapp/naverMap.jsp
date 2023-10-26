<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=3tull6ku3q"></script>
<body>
    맵 위에 선 그리기 (산책로)
    <div id="map" style="width:400px; height:400px;"></div>
    <button id="btn">완성</button>
    <br>
    
    <script>
        var map = new naver.maps.Map('map');
        var chk = true;
        var btn = document.querySelector("#btn");
        btn.addEventListener("click", function() {
            chk = false;
        });

        var polylines = [];
        var isDrawing = false;

        naver.maps.Event.addListener(map, 'click', function(e) {
            if (chk) {
                if (!isDrawing) {
                    isDrawing = true;
                    var path = [];
                    path.push(e.latlng);

                    var newPolyline = new naver.maps.Polyline({
                        map: map,
                        path: path,
                        strokeColor: '#5347AA',
                        strokeWeight: 5,
                        clickable: true,
                    });

                    naver.maps.Event.addListener(newPolyline, 'click', function(e) {
                        if (!chk) {
                            var marker = new naver.maps.Marker({
                                position: e.latlng,
                                map: map
                            });

                            polylines.push(newPolyline);
                            isDrawing = false;
                        }
                    });

                    for (var i = 0; i < polylines.length; i++) {
                        highlightOverlap(polylines[i], newPolyline);
                    }
                }
            }
        });

        function highlightOverlap(polyline1, polyline2) {
            var path1 = polyline1.getPath();
            var path2 = polyline2.getPath();
            
            var overlapPath = [];

            for (var i = 0; i < path1.length; i++) {
                for (var j = 0; j < path2.length; j++) {
                    if (naver.maps.Geometry.getDistance(path1.getAt(i), path2.getAt(j)) < 5) {
                        overlapPath.push(path1.getAt(i));
                        break;
         dud           }
                }
            }

            var overlapPolyline = new naver.maps.Polyline({
                map: map,
                path: overlapPath,
                strokeColor: 'red',
                strokeWeight: 7,
                clickable: false,
            });

            if (overlapPath.length > 0) {
                alert("폴리라인이 겹쳤습니다!");
            }
        }
    </script>
</body>
</html>