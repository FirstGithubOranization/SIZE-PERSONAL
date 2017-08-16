<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<c:set var="dist" value="${ctx}"></c:set>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
    String userId = request.getParameter("userId");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">

    <script type="text/javascript">
        function move(id) {
            var value = document.getElementById(id).getAttribute('value');
//            alert(value);
            if (value == 'NO') {
                document.getElementById(id).setAttribute('value', 'YES');
                document.getElementById(getOtherId(id)).setAttribute("value", "NO");
            }else{
                var form = document.forms[0];
                form.submit();
            }
        }
        ;

        function getOtherValue(curr) {
            if (curr == 'YES') {
                return 'NO';
            } else {
                return 'YES';
            }
        }
        ;

        function getOtherId(id) {
            if (id == 'b1') {
                return 'b2';
            } else {
                return 'b1';
            }
        }

        function moveout(id) {

        }
        ;
    </script>

    <style>
        body {
            text-align: center
        }

        .divcss5 {position: absolute;width:400px;height:200px;left:50%;top:50%;
            margin-left:-200px;margin-top:-100px}


        /* CSS注释：设置对象边框、宽度、高度 便于观察布局效果 */
    </style>
</head>
<body>
<form id="form" action="pp.jsp">
<div class="divcss5" style="align-content: center;vertical-align: middle">小简笈，你是小臭猪吗？<br/><br/>
    <input id="b1" type="button" style="background: white ;width: 10em" value="YES"
           onmouseover="move('b1')" onmouseout="moveout('b1')">&nbsp&nbsp&nbsp&nbsp&nbsp<input id="b2" type="button"
                                                                                               style="background: white ;width: 10em"
                                                                                               value="NO"
                                                                                               onmouseover="move('b2')"
                                                                                               onmouseout="moveout('b2')">
</div>
<br/>
<div id=Layer1 style="position:relative; width:400px; height:115px;z-index:1;left: 341px;top:100px;">
</div>
</form>
</body>
</html>
