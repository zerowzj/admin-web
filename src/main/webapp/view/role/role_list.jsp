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
    <legend>数据操作和左右列固定</legend>
</fieldset>
<table class="layui-table">
    <thead>
    <tr>
        <th lay-data="{checkbox:true, fixed: true}"></th>
        <th lay-data="{field:'id', width:80, sort: true, fixed: true}">角色编号</th>
        <th lay-data="{field:'username', width:80}">角色名</th>
        <th lay-data="{field:'sex', width:80, sort: true}">状态</th>
        <th lay-data="{field:'city', width:80}">创建时间</th>
        <th lay-data="{field:'city', width:80}">创建时间</th>
        <th lay-data="{fixed: 'right', width:160, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
    </thead>
    <tr>
        <th></th>
        <th>12321</th>
        <th>职业</th>
        <th>财富</th>
        <th>评分</th>
        <th>评分</th>
        <th>
        </th>
    </tr>
    <thead>
    </thead>
</table>

</body>
</html>
