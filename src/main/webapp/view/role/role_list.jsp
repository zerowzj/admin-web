<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>基本表格</legend>
</fieldset>

<table class="layui-table" lay-data="{height:313, url:'/api/role/list'}">
    <thead>
    <tr>
        <th lay-data="{field:'id', width:80, sort: true}">ID</th>
        <th lay-data="{field:'username', width:80}">用户名</th>
        <th lay-data="{field:'sex', width:80, sort: true}">性别</th>
        <th lay-data="{field:'city', width:80}">城市</th>
        <th lay-data="{field:'sign', width:177}">签名</th>
        <th lay-data="{field:'experience', width:80, sort: true}">积分</th>
        <th lay-data="{field:'score', width:80, sort: true}">评分</th>
        <th lay-data="{field:'classify', width:80}">职业</th>
        <th lay-data="{field:'wealth', width:135, sort: true}">财富</th>
    </tr>
    </thead>
</table>
<div id="demo7"></div>
<script>
    layui.use(['table', 'laypage'], function () {
        var table = layui.table;
        var laypage = layui.laypage;
        laypage.render({
            elem: 'demo7'
            , count: 100
            , layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
            , jump: function (obj) {
                console.log(obj)
            }
        });
    });
</script>
</body>
</html>
