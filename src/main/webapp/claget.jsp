<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级详情</title>
</head>
<body>
    <h3>班级详情</h3>
    <a href="claquery">去查询</a>
    <a href="clatoadd">去新加</a>
    <div>${msg}</div>
    <c:remove var="msg" scope="session"></c:remove>
    <form action="clamod" method="post">
        <table>
            <tr>
                <td>班级编号:</td>
                <td>
                    <input name="cid" value="${g.cid}" readonly>
                </td>
            </tr>
            <tr>
                <td>班级名称:</td>
                <td>
                    <input name="cname" value="${g.cname}">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="修改">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
