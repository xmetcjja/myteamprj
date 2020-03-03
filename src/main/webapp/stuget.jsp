<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>学生详情</title>
    <script src="js/jquery-3.4.1.js"></script>
    <script src="js/myjs.js"></script>
</head>
<body>
    <h3>学生详情</h3>
    <a href="stuquery">去查询</a>
    <a href="stutoadd">去新加</a>
    <div>${msg}</div>
    <c:remove var="msg" scope="session"></c:remove>
    <form action="stumod" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>学号:</td>
                <td>
                    <input name="sid" value="${g.sid}" readonly>
                </td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td>
                    <input name="sname" value="${g.sname}">
                </td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    <label>男:<input type="radio" name="sex" value="男" ${g.sex=='男'?'checked':''}></label>
                    <label>女:<input type="radio" name="sex" value="女" ${g.sex=='女'?'checked':''}></label>
                </td>
            </tr>
            <tr>
                <td>学历:</td>
                <td>
                    <select name="xueli">
                        <option value="小学" ${g.xueli=='小学'?'selected':''}>小学</option>
                        <option value="中学" ${g.xueli=='中学'?'selected':''}>中学</option>
                        <option value="大专" ${g.xueli=='大专'?'selected':''}>大专</option>
                        <option value="本科" ${g.xueli=='本科'?'selected':''}>本科</option>
                        <option value="本科之上" ${g.xueli=='本科之上'?'selected':''}>本科之上</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>班级:</td>
                <td>
                    <select name="cla.cid">
                        <option value="">-请选择-</option>
                        <c:forEach items="${clist}" var="c">
                            <option value="${c.cid}" ${g.cla.cid==c.cid?'selected':''}>${c.cname}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>相片:</td>
                <td>
                    <input name="pic" type="file">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="修改">
                    <input type="button" id="linkmanaddbut" value="新加联系人">
                </td>
            </tr>
        </table>
        <table width="500" border="1" id="linkmanTab">
            <tr>
                <th>联系人姓名</th>
                <th>联系人电话</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${g.list}" var="l" varStatus="st">
                <tr>
                    <td><input name="list[${st.index}].lid" type="hidden" value="${l.lid}"><input name="list[${st.index}].lname" value="${l.lname}"></td>
                    <td><input name="list[${st.index}].ltel" value="${l.ltel}"></td>
                    <td><button class="delbut">删除</button></td>
                </tr>
            </c:forEach>

        </table>
    </form>
    <div style="display: none">
        <table>
            <tr id="trmodel">
                <td><input name="list[0].lid" type="hidden"><input name="list[0].lname"></td>
                <td><input name="list[0].ltel"></td>
                <td><button class="delbut">删除</button></td>
            </tr>
        </table>
    </div>
    <img src="pics/${g.sid}.jpg?did=<%=new java.util.Date().getTime()%>" style="position:absolute;right:5px;top:5px;max-width: 500px;">
</body>
</html>
