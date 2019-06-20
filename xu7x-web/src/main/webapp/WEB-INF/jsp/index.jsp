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
    <title>xu7x</title>
</head>
<script src="/static/jquery-3.2.1.js" type="text/javascript"></script>
<body>


<table class="table  table-bordered" id="roleTable">
    <thead>
    <tr>

    </tr>
    </thead>

    <tbody>

    </tbody>

    <tfoot>
    <tr>
        <td colspan="6" align="center">
            <ul class="pagination">
                <%--页码--%>
            </ul>
        </td>
    </tr>
    </tfoot>
</table>

</body>


<script>
    $(function () {
        var v = '${pageContext.request.contextPath}';
        var path = v + "indexs";
        $.ajax({
            url: path,
            success: function (data) {
                init(data);
            }
        });

        function init(data) {
            var table = $("#roleTable tbody");
            $.each(data, function (index, value) {
                console.log("value == " + value);


                var tr = $("<tr></tr>"); //创建这个tr对象
                var x = tr.append("<td id ="+value.id+">" + value.id + "</td>").append("<td indexId="+value.id+" id='name'>" + value.name + "</td>").append("<td>" + formatDate(value.createTime) + "</td>");
                x.appendTo(table)
            });
        }
    });

    $("body").on('click','#name',function () {
        //获取文章 ID
        var indexId =$(this).attr('indexId');
        console.log("indexId == "+indexId);
        getContent(indexId);
    });

    function getContent() {

    }

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
</script>


</html>
