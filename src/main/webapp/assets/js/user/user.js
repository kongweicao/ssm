/**
 * Created by kongwc on 2017/7/22.
 */
new Vue({
    el : '#kongwc',
    data : {
        userList : [],
        user : {name: null, phone: null,email: null},
        confirmFlag : 'add', //add新增  update修改
        popTitle : '新增用户',
        pageInfo : {},
        search : '',
        pageNum : 1,
        pageSize : 10,
        goPage : ""
    },
    created : function () {
        var _self = this;
        $.ajax({
            url : "findAllUser?page=" + _self.pageNum + "&pageSize=" + _self.pageSize,
            type : "GET",
            dataType : "json",
            success : function (data) {
                if(data.returnCode == "0000"){
                    _self.pageInfo = data.data;
                }
            }
        });
    },
    computed: {
        searchData: function() {
            var search = this.search;
            if (search) {
                return this.pageInfo.list.filter(function (item) {
                    return item.name.indexOf(search) > -1
                })
            }
            return this.pageInfo.list;
        }
    },
    methods : {
        add: function () {
            this.user = {name: null, phone: null,email: null};
            this.confirmFlag = 'add';
            this.popTitle = '新增用户';
            $('#myModal').modal('show');
        },
        confirm: function () {
            var _self = this;
            var method = null;
            if (this.confirmFlag == 'add') {
                method = "addUser";
            } else if (this.confirmFlag == 'update') {
                method = "updateUser";
            }
            $.ajax({
                url: method,
                type: "post",
                data: JSON.stringify(_self.user),
                contentType: "application/json",
                success: function (data) {
                    if (data.returnCode == "0000") {

                        humane.log(data.returnMessage);
                    } else {
                        humane.log("请求失败");
                    }
                    $('#myModal').modal('hide');
                }
            });
        },
        toPage: function (page) {
            this.ajax(page, null);
        },
        derectivePage : function () {
            var goPage = this.goPage;
            this.ajax(goPage, null);
        },
        ajax: function (pageNum, pageSize) {
            if(pageSize == null){
                pageSize = this.pageSize;
            }

            if(pageNum == null){
                pageNum = 1;
            }else if(pageNum > this.pageInfo.lastPage){
                this.goPage = this.pageInfo.lastPage;
                pageNum = this.pageInfo.lastPage;
            }

            if(this.pageInfo.isLastPage && pageNum == 0){
                return false;
            }

            if(this.pageInfo.isFirstPage && pageNum == 0){
                return false;
            }
            var _self = this;
            $.ajax({
                url : "findAllUser?page=" + pageNum + "&pageSize=" + pageSize,
                type : "GET",
                dataType : "json",
                success : function (data) {
                    if(data.returnCode == "0000"){
                        _self.pageInfo = data.data;
                    }
                }
            });
        },
        modify : function (user) {
            this.user = user;
            this.confirmFlag = 'update';
            this.popTitle = '修改用户';
            $('#myModal').modal('show');
        },
        deleteUser : function (user) {
            $.ajax({
                url : "deleteUser?userId=" + user.userId,
                type : "GET",
                dataType : "json",
                success : function (data) {
                    if(data.returnCode == "0000"){
                        humane.log(data.returnMessage);
                        document.location.reload();
                    }
                }
            });
        }
    }
});