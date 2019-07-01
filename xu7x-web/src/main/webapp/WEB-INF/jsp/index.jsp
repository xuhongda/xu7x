<%@ page import="pojo.Xu7xIndex" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/20
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>xu7x-时光杂志</title>
</head>
<script src="/static/jquery-3.2.1.js" type="text/javascript"></script>

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.css" crossorigin="anonymous">
<link rel="stylesheet" href="/static/layui/css/layui.css" media="all">
<body>
<div style="height: 15%">
    <br>
    <div style="margin-left: 15%">
        <img src="/static/news_blue.png" alt="inc"/> <span style="font-size: large; color: #60a3bc">南方青年杂志</span>
    </div>
</div>
<div>
    <table class="table table-hover" style="text-align:center" id="roleTable">
        <thead>
        <tr>
            <%--  <td>序号</td>--%>
            <td style="font-size: x-large;color: #60a3bc">文章</td>
            <td style="font-size: x-large;color: #60a3bc">发布日期</td>
        </tr>
        </thead>

        <tbody>

        </tbody>

        <tfoot>
        <tr>
            <td colspan="6" align="center">
                <ul class="pagination">
                    <%--页码--%>
                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                        <legend>
                            想过这一天......
                            你不认识我，
                            我不认识你，
                            在街上，
                            在田野，
                            记忆模糊起来，
                            想象清晰开来，
                            我不认识你，你不认识我。 2019-6-24
                        </legend>
                    </fieldset>
                    <div id="demo7"></div>
                </ul>
            </td>
        </tr>
        </tfoot>
    </table>


    <form style="text-align: center">
        <div>
            <button type="button" id="join-us" class="btn btn-primary">加入我们</button>
        </div>
        <br>
        <ul id="more" style="display: none">
            <button id="pp" class="btn btn-info">投稿</button>
            <button id="dd" type="button" class="btn btn-info">成为开发者</button>
            <button id="aa" class="btn btn-info">提出建议</button>
        </ul>
    </form>

    <%--logo--%>
    <div id="logo" style="text-align: center">
        <img src="/static/about_us.png" alt="logo"/>
        <p style="color: #60a3bc">xuhongda org</p>
    </div>

</div>


</body>


<script>

</script>

<script src="/static/layui/layui.js" charset="utf-8"></script>
<script>

    $(function () {

        showT(1, 2);

        function showT(curr, limit) {
            console.log("showT");
            var v = '${pageContext.request.contextPath}';
            var path = v + "indexs";
            $.ajax({
                url: path,
                data: {"pageNum": curr, "pageSize": limit},
                success: function (data) {
                    init(data);
                    page();
                }
            });
        }

        function show(curr, limit) {
            console.log("show");
            var v = '${pageContext.request.contextPath}';
            var path = v + "indexs";
            $.ajax({
                url: path,
                data: {"pageNum": curr, "pageSize": limit},
                success: function (data) {
                    init(data);
                },
                error: function () {
                  layer.msg("服务出错")
                }
            });
        }

        var total = 0;

        function init(data) {
            var table = $("#roleTable tbody");
            /*在构建之前先清空*/
            table.empty();
            total = data.total;
            console.log("total == " + total);
            var data = data.list;
            $.each(data, function (index, value) {
                console.log("value == " + value);
                var tr = $("<tr></tr>"); //创建这个tr对象
                var x = tr.append("<td indexId=" + value.id + " id='name'> <a style='font-size: large;color: #38ada9'>" + value.name + "</a></td>").append("<td>" + formatDate(value.createTime) + "</td>");
                x.appendTo(table)
            });
        }

        function page() {
            console.log("ppppp");
            layui.use(['laypage', 'layer'], function () {
                var laypage = layui.laypage
                    , layer = layui.layer;

                //完整功能
                laypage.render({
                    elem: 'demo7'
                    , count: total //总条数
                    , theme: '#60a3bc'
                    , limit: 2
                    , limits: [7, 15, 30] //每页条数
                    , layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
                    , jump: function (obj) {
                        console.log(">>>" + obj.curr);
                        console.log(">>>" + obj.limit);
                        initPage(obj.curr, obj.limit);
                    }
                });

            });
        }


        function initPage(curr, limit) {
            console.log("curr=" + curr + "---limit=" + limit);
            show(curr, limit);
        }

        $("body").on('click', '#name', function () {
            //获取文章 ID
            var indexId = $(this).attr('indexId');
            console.log("indexId == " + indexId);
            getContent(indexId);
        });

        function getContent(id) {
            window.location.href = "content" + "?id=" + id;
        }


        /*more*/

        $("#join-us").click(function () {
            $("#more").show(1000);
        });

        /*成为开发者*/
        $("#dd").click(function () {
            layer.alert("<a href='https://github.com/xuhongda/xu7x'>点击查看项目源码</a>")
        });

        //js 时间转换 函数
        function formatDate(date) {
            var d = new Date(date),
                month = '' + (d.getMonth() + 1),
                day = '' + d.getDate(),
                year = d.getFullYear();
            if (month.length < 2) month = '0' + month;
            if (day.length < 2) day = '0' + day;
            return [year, month, day].join('-');
        }

    });


</script>


</html>
