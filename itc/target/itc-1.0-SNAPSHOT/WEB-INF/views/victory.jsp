<%--
  Created by IntelliJ IDEA.
  User: jing
  Date: 2022/12/8
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>视频上传成功，请上传图片封面</title>
    <link rel="stylesheet" href="/static/css/csslogup.css">
    <script src="/static/js/jquery.min.js"></script>
</head>
<body>
<div class="rg_layout" style="margin-top: 6%">
    <div class="rg_left">
        <p>补全视频信息</p>
        <p>COMPLETE INFO</p>
    </div>
    <div class="rg_center">
        <div class="rg_form">
            <form id="form" action="/addcover" method="post" enctype="multipart/form-data">
                <br><br><br><br>
                <table>
                    <!--label 标签的作用是当点击文字也会跳到文本输出框-->
                    <!--for属性与ID属性对应规定 label 绑定到哪个表单元素。-->
                    <tr>
                        <td class="td_left"><label for="title">视频的标题</label> </td>
                        <td class="td_right"><input type="text" name="title" id="title" class="password"></td>
                        <br><br>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="file">请选择要上传的图片</label> </td>
                        <td class="td_right"><input type="file" name="file" id="file" multiple="multiple"></td>
                        <br><br>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <br><br>
                            <button id="btn_sub">确认上传</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
