<% for(menuVO in menuVOLt){ %>
<li class="layui-nav-item layui-nav-itemed">
    <a href="javascript:;">${menuVO.pfName}</a>
    <dl class="layui-nav-child">
<% for(child in menuVO.children){ %>
        <dd><a href="${child.pfPath}">${child.pfName}</a></dd>
<%}%>
    </dl>
</li>
<%}%>