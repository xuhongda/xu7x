<!DOCTYPE html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<script type="text/javascript" src="/static/jquery-3.2.1.js"></script>
<link rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.css" crossorigin="anonymous">
<body>


<div style="margin-left: auto;margin-right: auto;text-align: center">
    <h2>身份认证</h2>
<form action="/user/acc" method="post">
    <table style="text-align: center;margin-right: auto;margin-left: auto">
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr><td></td></tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr><td></td></tr>
        <tr>
            <td colspan="2">
                <button type="submit" name="type" value="regist">认证</button>
            </td>
        </tr>
    </table>
</form>
</div>
</body>
</html>