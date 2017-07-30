<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <link href="assets/js/bootstrap3/css/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/css/common.css" rel="stylesheet" />
    <link href='assets/message/flatty.css' rel='stylesheet'>

    <script src="assets/js/vue.js"></script>
    <script src="assets/js/jquery-2.1.3.min.js"></script>
    <script src="assets/js/bootstrap3/js/bootstrap.min.js"></script>
    <script src="assets/js/bootstrap3/js/bootstrap.min.js"></script>

    <script src='assets/message/humane.min.js'></script>
    <script src="assets/js/common.js"></script>
    <style>
        .page-form-control {
            width: 50px;
            height: 32px;
            padding: 6px 12px;
            font-size: 14px;
            line-height: 1.42857143;
            color: #555;
            background-color: #fff;
            background-image: none;
            border: 1px solid #ccc;
            border-radius: 4px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
            -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
            transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
        }
    </style>
</head>
<body>
<div id="kongwc">
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="false">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">{{popTitle}}</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control"  placeholder="请输入名字" v-model="user.name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">电话</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control"  placeholder="请输入电话" v-model="user.phone">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control"  placeholder="请输入邮箱" v-model="user.email">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" @click="confirm">确认</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
     <div class="container">
         <div class="panel-heading">
             <h3 class="panel-title"><strong>用户管理</strong></h3>
         </div>
         <div class="panel-body">
             <button type="submit" class="btn btn-success pull-left" @click="add">新增</button>
             <form class="form-inline pull-right" role="form" style="margin-bottom: 10px;">
                 <div class="form-group">
                     <label class="sr-only" for="name">名称</label>
                     <input type="text" class="form-control" id="name" placeholder="请输入姓名" v-model="search">
                 </div>
                 <button type="submit" class="btn btn-info">搜索</button>
             </form>
             <table class="table table-bordered table-hover table-striped">
                 <!--<caption>用户列表</caption>-->
                 <thead>
                 <tr>
                     <th>姓名</th>
                     <th>电话</th>
                     <th>邮箱</th>
                     <th>操作</th>
                 </tr>
                 </thead>
                 <tbody>
                 <template v-for="user in searchData">
                     <tr>
                         <td class="text-center">{{user.name}}</td>
                         <td class="text-center">{{user.phone}}</td>
                         <td class="text-center">{{user.email}}</td>
                         <td class="text-center">
                             <button class="btn btn-warning btn-xs" @click="modify(user)">修改</button>
                             <button class="btn btn-danger btn-xs" @click="deleteUser(user)">删除</button>
                         </td>
                     </tr>
                 </template>
                 </tbody>
             </table>
             <ul class="pager" style="padding:10px;">
                 <li><a href="#" @click="toPage(pageInfo.prePage)">上一页</a></li>
                 <li><a href="#" @click="toPage(pageInfo.nextPage)">下一页</a></li>
                 <li><label>共{{pageInfo.total}}条</label></li>
                 <li><label>共{{pageInfo.pages}}条</label></li>
                 <li><label>每页显示
                     <select @change="toPage()" v-model="pageSize">
                        <option selected>10</option>
                        <option>20</option>
                        <option>30</option>
                    </select>
                     条</label></li>
                 <li><label>第{{pageInfo.pageNum}}页</label></li>
                 <li><label>跳转到第<input class="page-form-control" v-model="goPage"/>页</label></li>
                 <li><button class="btn btn-info" @click="derectivePage()">GO</button></li>
             </ul>
         </div>
    </div>

</div>
</body>
<script src="assets/js/user/user.js"></script>
</html>