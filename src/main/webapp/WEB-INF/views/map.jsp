<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>카카오맵 마커</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&display=swap" rel="stylesheet">
</head>
<body>
<%-- html css 트렌드
<header> = 태그 안에는 header 만들 때 기본으로 만들어진 css가 장착
<div>    = 주로 사용하는 트렌드 -> 프레임워크 : react, vue 의 경우 div를 기준으로 코딩을 진행한다.

-%>
<%-- -- 헤더 -- --%>
<div class="header">
    <div class="header-dot"></div>
    <h1>카카오맵 마커</h1>
    <span>총 5개 저장소</span>
</div>

<div class="map-wrap">
    <div id="map"></div>
    <div class="side-panel">
        <h2>장소 목록</h2>
        <div id="place-list"></div>
    </div>
</div>
</body>
</html>