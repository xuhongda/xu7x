<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/20
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>post</title>
</head>
<script src="/static/jquery-3.2.1.js" type="text/javascript"></script>
<body>
<input type="file" name="fileUpload" id="post"/>
<input type="submit"  id="up" value="上传"/>
</body>
<script>
    let $post = $("#post");
    let $up = $("#up");
    $up.click(function () {
        send();
    });

    var path = '${pageContext.request.contextPath}';

    function send() {
        console.log("///////////send");
        var value = $post[0].files;
        var form = new FormData();
        console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>"+value.length);
        for (var i =0;i<value.length;i++){
            form.append("files",value[i])
        }
        form.append("user","xuhongda");
        form.append("password","7777");
        console.log(">>>>>>>>>"+form);
        $.ajax({
            url:path+"/post",
            type:"post",
            contentType:false,
            processData:false,
            data:form,
            success:function () {
                console.log("success");
                alert("上传成功");
            },
            error:function(){
                console.log("error");
            }
        })
    };

</script>
</html>
