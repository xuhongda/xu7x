<!DOCTYPE html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<script type="text/javascript" src="/static/jquery-3.2.1.js"></script>
<body>
<h2>Demo注册页</h2>

<form action="/user/acc" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit" name="type" value="regist">认证</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>