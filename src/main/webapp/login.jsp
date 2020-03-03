<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>用户登陆</title>
    <script src="js/jquery-3.4.1.js"></script>
    <script src="js/jquery.validate.1.11.1.js"></script>
    <script src="js/messages_cn.js"></script>
    <script>
        $(document).ready(function(){
            $("#form1").validate({
                rules:{
                    uname:{
                        required:true,
                        rangelength:[4,50]
                    },
                    password:{
                        required:true,
                        rangelength:[4,50]
                    }
                }
            });
        });
    </script>
</head>
<body>
    <fieldset style="width: 50%;margin:0 auto">
        <legend>用户登陆</legend>
        <div>${error}</div>
        <form action="userlogin" method="post" id="form1">
            <table>
                <tr>
                    <td>用户名:</td><td><input name="uname" value="${param.uname}" autofocus></td>
                </tr>
                <tr>
                    <td>密码:</td><td><input type="password" name="password" value="${param.password}"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="登陆"></td>
                    <td><input type="reset" value="重置"></td>
                </tr>
            </table>
        </form>
    </fieldset>
</body>
</html>
