<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级新加</title>
</head>
<body>
    <h3>班级新加</h3>
    <a href="claquery">去查询</a>
    <form action="claadd" method="post">
        <table>
            <tr>
                <td>班级名称:</td>
                <td>
                    <input name="cname">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
