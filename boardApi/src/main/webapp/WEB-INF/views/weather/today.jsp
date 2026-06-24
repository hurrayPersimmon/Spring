<%--
  Created by IntelliJ IDEA.
  User: hurray
  Date: 2026. 6. 24.
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div>
  <title>Title</title>
  <h2>${city}</h2>
  오늘의 날씨: ${weather.weather[0].description} <img src="${iconUrl}"/>
</div>
<div>
  온도: ${weather.main.temp}° / 습도: ${weather.main.humidity}%
</div>
</body>
</html>
