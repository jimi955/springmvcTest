<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>入门程序</h3>
    <br />
    <a href="hello">hello</a>
    <br />
    <a href="hello/testRequestMapping?username=heihei">helloWithUserName</a>
    <br />
    <a href="param/testParam?username=xiaoxin&password=123">paramTest</a>
    <br />
    <a href="user/testRequestMapping?username=heihei">RequestMapping注解</a>
    <br />

    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username"/> <br/>
        密码：<input type="text" name="password"/> <br/>
        金额：<input type="text" name="money"/> <br/>

        用户名称：<input type="text" name="user.uname"/> <br/>
        用户年龄：<input type="text" name="user.age"/> <br/>
        用户生日：<input type="text" name="user.date"/> <br/>

        用户名称list1：<input type="text" name="list[0].uname"/> <br/>
        用户年龄list1：<input type="text" name="list[0].age"/> <br/>

        用户名称map['one']：<input type="text" name="map['one'].uname"/> <br/>
        用户年龄map['one']：<input type="text" name="map['one'].age"/> <br/>

        <input type="submit" value="提交"/>

    </form>

    <br />

    <a href="param/testServlet">原生的ServletApi测试</a>

</body>
</html>
