<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级查询</title>
</head>
<body>
    <a href="clatoadd">去新加</a>
    <div>${msg}</div>
    <form action="claquery" method="post">
        <table border="1" width="100%">
            <tr>
                <th>序号</th>
                <th>班级编号</th>
                <th>班级名称</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${p.list}" var="c" varStatus="st">
                <tr>
                    <td>${(p.pageNum-1)*p.pageSize+st.count}</td>
                    <td>${c.cid}</td>
                    <td>${c.cname}</td>
                    <td>
                        <a href="claget?cid=${c.cid}">详情</a>
                        <a href="cladel?cid=${c.cid}" onclick="return confirm('你确定删除吗？')">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <%@include file="incinclude/fenpage.jsp"%>
    </form>

</body>
</html>
