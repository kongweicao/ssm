/**
 * Created by kongwc on 2017/7/22.
 */
new Vue({
    el : '#kongwc',
    data : {
        userList : [],
        user : {name: null, phone: null,email: null},
        confirmFlag : 'add', //add新增  update修改
        popTitle : '新增用户'
    },
    created : function () {
        var _selft = this;
        $.ajax({
            url : "findAllUser",
            type : "GET",
            dataType : "json",
            success : function (data) {
                if(data.returnCode == "0000"){
                    _selft.userList = data.data;
                }
            }
        });
    },
    methods : {
        add : function () {
            this.confirmFlag = 'add';
            this.popTitle = '新增用户';
            $('#myModal').modal('show');
        },
        confirm : function () {
            var _self = this;
            var method = null;
            if(this.confirmFlag == 'add'){
                method = "addUser";
            }else if(this.confirmFlag == 'update'){
                method = "updateUser";
            }
            $.ajax({
                url : method,
                type : "post",
                data : JSON.stringify(_self.user),
                contentType : "application/json",
                success : function (data) {
                    if(data.returnCode == "0000"){
                        humane.log("新增成功");
                    }else{
                        humane.log("新增失败");
                    }
                    $('#myModal').modal('hide');
                }
            });
        }
    }
});