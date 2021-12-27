<%--
  Created by IntelliJ IDEA.
  User: bpf
  Date: 2021/12/26
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Spring Web</title>
  </head>
  <body>
    <div align="center">
      <h2>注册学生</h2>
      <form method="post" action="add">
        <table>
          <tr>
            <td>姓名：</td>
            <td><input type="text" name="name"></td>
          </tr>
          <tr>
            <td>年龄：</td>
            <td><input type="number" name="age"></td>
          </tr>
          <tr>
            <td><input type="submit" value="注册学生"></td>
          </tr>
        </table>
      </form>

      <hr>
      <h2>查询学生</h2>
      <form method="get" action="query">
        <table>
          <tr>
            <td>年龄：</td>
            <td><input type="number" name="id"></td>
          </tr>
          <tr>
            <td><input type="submit" value="查询学生"></td>
          </tr>
        </table>
      </form>
    </div>
  </body>
</html>
