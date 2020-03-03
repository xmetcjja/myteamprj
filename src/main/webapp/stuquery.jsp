<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生查询</title>
</head>
<body>
    <a href="stutoadd">去新加</a>
    <div>${msg}</div>
    <form action="stuquery" method="post">
        姓名:<input name="sname" value="${param.sname}">
        性别:<select name="sex" onchange="this.form.submit()">
        <option value="">-请选择-</option>
        <option value="男" ${param.sex=='男'?'selected':''}>男</option>
        <option value="女" ${param.sex=='女'?'selected':''}>女</option>
    </select>
        <input type="submit" value="查询">
        <table border="1" width="100%">
            <tr>
                <th>序号</th>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>班级</th>
                <th>学历</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${p.list}" var="s" varStatus="st">
                <tr>
                    <td>${(p.pageNum-1)*p.pageSize+st.count}</td>
                    <td>${s.sid}</td>
                    <td>${s.sname}</td>
                    <td>${s.sex}</td>
                    <td>${s.cla.cname}</td>
                    <td>${s.xueli}</td>
                    <td>
                        <a href="stuget/${s.sid}">详情</a>
                        <a href="cladel/${s.sid}" onclick="return confirm('你确定删除吗？')">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <%@include file="incinclude/fenpage.jsp"%>
    </form>

</body>
</html>
