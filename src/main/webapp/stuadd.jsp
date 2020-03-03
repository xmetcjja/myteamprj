<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>学生新加</title>
    <script src="js/jquery-3.4.1.js"></script>
    <script src="js/myjs.js"></script>
</head>
<body>
    <h3>学生新加</h3>
    <a href="stuquery">去查询</a>
    <form action="stuadd" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>姓名:</td>
                <td>
                    <input name="sname">
                </td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    <label>男:<input type="radio" name="sex" value="男" checked></label>
                    <label>女:<input type="radio" name="sex" value="女"></label>
                </td>
            </tr>
            <tr>
                <td>学历:</td>
                <td>
                    <select name="xueli">
                        <option value="小学">小学</option>
                        <option value="中学">中学</option>
                        <option value="大专">大专</option>
                        <option value="本科" selected>本科</option>
                        <option value="本科之上">本科之上</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>班级:</td>
                <td>
                    <select name="cla.cid">
                        <option value="">-请选择-</option>
                        <c:forEach items="${clist}" var="c">
                            <option value="${c.cid}">${c.cname}</option>
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
                    <input type="submit" value="提交">
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
            <tr>
                <td><input name="list[0].lid" type="hidden"><input name="list[0].lname"></td>
                <td><input name="list[0].ltel"></td>
                <td><button class="delbut">删除</button></td>
            </tr>
            <tr>
                <td><input name="list[1].lid" type="hidden"><input name="list[1].lname"></td>
                <td><input name="list[1].ltel"></td>
                <td><button class="delbut">删除</button></td>
            </tr>
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
</body>
</html>
