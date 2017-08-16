<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<c:set var="dist" value="${ctx}"></c:set>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
    String userId = request.getParameter("userId");
%>
<html xml:lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Our Love Story - aaa & bbb</title>
    <style type="text/css">#ds-thread .ds-powered-by {
        display: none !important;
    }
    </style>
    <link rel="stylesheet" type="text/css" href="http://sandbox.runjs.cn/uploads/rs/320/wrq8edne/default.css">
    <script type="text/javascript" src="http://sandbox.runjs.cn/uploads/rs/320/wrq8edne/jquery.min.js"></script>
    <script type="text/javascript" src="http://sandbox.runjs.cn/uploads/rs/320/wrq8edne/jscex.min.js"></script>
    <script type="text/javascript" src="http://sandbox.runjs.cn/uploads/rs/320/wrq8edne/jscex-parser.js"></script>
    <script type="text/javascript" src="http://sandbox.runjs.cn/uploads/rs/320/wrq8edne/jscex-jit.js"></script>
    <script type="text/javascript"
            src="http://sandbox.runjs.cn/uploads/rs/320/wrq8edne/jscex-builderbase.m.js"></script>
    <script type="text/javascript" src="http://sandbox.runjs.cn/uploads/rs/320/wrq8edne/jscex-async.min.js"></script>
    <script type="text/javascript"
            src="http://sandbox.runjs.cn/uploads/rs/320/wrq8edne/jscex-async-powerpa.js"></script>
    <script type="text/javascript" src="http://sandbox.runjs.cn/uploads/rs/320/wrq8edne/functions.js"></script>
    <script type="text/javascript" src="http://sandbox.runjs.cn/uploads/rs/320/wrq8edne/love.js"></script>

    <style type="text/css">
        body {
            margin: 0;
            padding: 0;
            background: #ffe;
            font-size: 14px;
            font-family: '楷体', '楷体', sans-serif;
            color: #231F20;
            overflow: auto
        }

        a {
            color: #000;
            font-size: 14px;
        }

        #main {
            width: 100%;
        }

        #wrap {
            position: relative;
            margin: 0 auto;
            width: 1100px;
            height: 680px;
        }

        #text {
            width: 400px;
            height: 425px;
            left: 60px;
            top: 30px;
            position: absolute;
        }

        #code {
            display: none;
            font-size: 16px;
        }

        #clock-box {
            position: absolute;
            left: 60px;
            top: 550px;
            font-size: 28px;
            display: none;
        }

        #clock-box a {
            font-size: 28px;
            text-decoration: none;
        }

        #clock {
            margin-left: 48px;
        }

        #clock .digit {
            font-size: 64px;
        }

        #canvas {
            margin: 0 auto;
            width: 1100px;
            height: 680px;
        }

        #error {
            margin: 0 auto;
            text-align: center;
            margin-top: 60px;
            display: none;
        }

        .hand {
            cursor: pointer;
        }

        .say {
            margin-left: 5px;
        }

        .space {
            margin-right: 150px;
        }

    </style>

    <script type="text/javascript">
        $(document).ready(function () {
            var canvas = $('#canvas');
            if (!canvas[0].getContext) {
                $("#error").show();
                return false;
            }
            var width = canvas.width();
            var height = canvas.height();
            canvas.attr("width", width);
            canvas.attr("height", height);
            var opts = {
                seed: {
                    x: width / 2 - 20,
                    color: "rgb(190, 26, 37)",
                    scale: 2
                },
                branch: [
                    [535, 680, 570, 250, 500, 200, 30, 100, [
                        [540, 500, 455, 417, 340, 400, 13, 100, [
                            [450, 435, 434, 430, 394, 395, 2, 40]
                        ]],
                        [550, 445, 600, 356, 680, 345, 12, 100, [
                            [578, 400, 648, 409, 661, 426, 3, 80]
                        ]],
                        [539, 281, 537, 248, 534, 217, 3, 40],
                        [546, 397, 413, 247, 328, 244, 9, 80, [
                            [427, 286, 383, 253, 371, 205, 2, 40],
                            [498, 345, 435, 315, 395, 330, 4, 60]
                        ]],
                        [546, 357, 608, 252, 678, 221, 6, 100, [
                            [590, 293, 646, 277, 648, 271, 2, 80]
                        ]]
                    ]]
                ],
                bloom: {
                    num: 700,
                    width: 1080,
                    height: 650,
                },
                footer: {
                    width: 1200,
                    height: 5,
                    speed: 10,
                }
            }
            var tree = new Tree(canvas[0], width, height, opts);
            var seed = tree.seed;
            var foot = tree.footer;
            var hold = 1;
            canvas.click(function (e) {
                var offset = canvas.offset(), x, y;
                x = e.pageX - offset.left;
                y = e.pageY - offset.top;
                if (seed.hover(x, y)) {
                    hold = 0;
                    canvas.unbind("click");
                    canvas.unbind("mousemove");
                    canvas.removeClass('hand');
                }
            }).mousemove(function (e) {
                var offset = canvas.offset(), x, y;
                x = e.pageX - offset.left;
                y = e.pageY - offset.top;
                canvas.toggleClass('hand', seed.hover(x, y));
            });
            var seedAnimate = eval(Jscex.compile("async", function () {
                seed.draw();
                while (hold) {
                    $await(Jscex.Async.sleep(10));
                }
                while (seed.canScale()) {
                    seed.scale(0.95);
                    $await(Jscex.Async.sleep(10));
                }
                while (seed.canMove()) {
                    seed.move(0, 2);
                    foot.draw();
                    $await(Jscex.Async.sleep(10));
                }
            }));
            var growAnimate = eval(Jscex.compile("async", function () {
                do {
                    tree.grow();
                    $await(Jscex.Async.sleep(10));
                } while (tree.canGrow());
            }));
            var flowAnimate = eval(Jscex.compile("async", function () {
                do {
                    tree.flower(2);
                    $await(Jscex.Async.sleep(10));
                } while (tree.canFlower());
            }));
            var moveAnimate = eval(Jscex.compile("async", function () {
                tree.snapshot("p1", 240, 0, 610, 680);
                while (tree.move("p1", 500, 0)) {
                    foot.draw();
                    $await(Jscex.Async.sleep(10));
                }
                foot.draw();
                tree.snapshot("p2", 500, 0, 610, 680);
                canvas.parent().css("background", "url(" + tree.toDataURL('image/png') + ")");
                canvas.css("background", "#ffe");
                $await(Jscex.Async.sleep(300));
                canvas.css("background", "none");
            }));
            var jumpAnimate = eval(Jscex.compile("async", function () {
                var ctx = tree.ctx;
                while (true) {
                    tree.ctx.clearRect(0, 0, width, height);
                    tree.jump();
                    foot.draw();
                    $await(Jscex.Async.sleep(25));
                }
            }));
            var textAnimate = eval(Jscex.compile("async", function () {
                var together = new Date();
                together.setFullYear(2015, 02, -12); 			//时间年月日
                together.setHours(13);						//小时
                together.setMinutes(14);					//分钟
                together.setSeconds(2);					//秒前一位
                together.setMilliseconds(0);				//秒第二位
                $("#code").show().typewriter();
                $("#clock-box").fadeIn(500);
                while (true) {
                    timeElapse(together);
                    $await(Jscex.Async.sleep(1000));
                }
            }));
            var runAsync = eval(Jscex.compile("async", function () {
                $await(seedAnimate());
                $await(growAnimate());
                $await(flowAnimate());
                $await(moveAnimate());
                textAnimate().start();
                $await(jumpAnimate());
            }));
            runAsync().start();
        });

    </script>


</head>
<body>
<audio autoplay="autopaly">
    <source src="http://cdn.y.baidu.com/746dd400ec21750107a8cfd227d999f0.mp3" type="audio/mp3">
</audio>
<div id="main">
    <div id="error">XF注:本页面采用HTML5编辑，目前您的浏览器无法显示，请换成谷歌或者火狐浏览器，或者其他游览器的最新版本。</div>
    <div id="wrap">
        <div id="text" style="margin-top:0px;">
            <div id="code">
                <span class="say"><font color="cc1883"><h3>小猪宝呀 </h3></font></span><br>
                <span class="say">　</span><br>
                <span class="say"><font color="cc1883">我见，或者不见，小猪就在那里 </font></span><br>
                <span class="say"><font color="cc1883">不悲不喜</font></span><br>
                <span class="say">　</span><br>
                <span class="say"><font color="FF00FA">我念，或者不念，小猪在那里 </font></span><br>
                <span class="say"><font color="FF00FA">不来不去</font></span><br>
                <span class="say">　</span><br>
                <span class="say"><font color="F16D7E">我爱，或者不爱，小猪就在那里 </font></span><br>
                <span class="say"><font color="F16D7E">不增不减 </font></span><br>
                <span class="say">　</span><br>
                <span class="say"><font color="228567">我跟，或者不跟，你的手就在我手里 </font></span><br>
                <span class="say"><font color="228567">不舍不弃</font></span><br>
                <span class="say">　</span><br>
                <span class="say">来我的怀里</span><br>
                <span class="say">默然 相爱 寂静 欢喜</span><br>
                <span class="say">　</span><br>
                <span class="say"><font color="FF00FA">不经意相识，或许,只是缘分，或许，是上天注定 </font></span><br>
                <span class="say"><font color="FF00FA">     以后，不管世界怎样，你都有我</font></span><br>
                <span class="say">　</span><br>
                <span class="say"><font color="228567">陪伴在你的身边 </font></span><br>
                <span class="say"><font color="228567">一直守护你,永远爱着你 </font></span><br>
                <span class="say"><font color="228567">小猪小猪，我下班啦</font>　</span><br>
            </div>
        </div>
        <canvas class="" id="canvas" width="1100" height="680"></canvas>
    </div>

</div>
</body>
</html>