<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<script src="/static/jquery-3.2.1.js" type="text/javascript"></script>

<body>

<%--<from>
    1:<input class="xx" type="text"/>
    2:<input class="xx" type="text"/>
    3:<input class="xx" type="text"/>
       <button type="button" id="btn">btn</button>
</from>--%>
<table>
    <tbody>
    <tr><td indexid="19" id="name"> spring  </td></tr>
    <tr><td indexid="18" id="name"> summer  </td></tr>
    </tbody>
</table>
<script>

    $("#name").click(function () {
        var indexId = $(this).attr('indexId');
        alert(indexId)
    });

    $("body").on('click','#name',function () {
        var indexId = $(this).attr('indexId');
        alert(indexId)
    });
</script>
</body>
</html>