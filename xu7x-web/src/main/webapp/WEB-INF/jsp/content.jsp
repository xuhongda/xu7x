<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/20
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/static/jquery-3.2.1.js" type="text/javascript"></script>
</head>
<body>

</body>
<script>
    $(function () {
        var id = ' ${requestScope.get("id")}';
        console.log("id == "+id);
        var v = '${pageContext.request.contextPath}';
        var path = v + "cc";
        $.ajax({
            url: path,
            data:{"id":id},
            success: function (data) {
                console.log("data == "+data);
                show(data);
            }
        });


        function show(data) {
            var body = $("body");
            $.each(data,function (index,value) {
                console.log("content == "+value.content);
                var p =$('<p></p>');
                p.append("<p>"+value.content+"</p>").appendTo(body)
            })
        }

    });




</script>
</html>
