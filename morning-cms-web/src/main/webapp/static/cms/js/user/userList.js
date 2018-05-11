
$(function(){
    $('#table').bootstrapTable({
		url: baselocation+"/system/user/json",
        dataType: "json",
        toolbar: '#toolbar',
        pagination: true,
        sidePagination: "server",
        columns: [
        /*{
            checkbox: true,
            align: 'center',
            valign: 'middle',
        },*/
        {
            field: 'userNumber',
            title: '用户编号',
            align: 'center',
        }, {
            field: 'userName',
            title: '用户昵称',
            align: 'center',
        }, {
		    field: 'realName',
            title: '真实姓名',
            align: 'center',
        },{
            field: 'sex',
            title: '性别',
            align: 'center',
                formatter: function (value, row, index) {
                    if(row.sex == 0){
                        return '<span class="text-primary">男</span> ';
                    }else{
                        return '<span class="text-primary">女</span> ';
                    }
                }
        }, {
            field: 'age',
            title: '年龄',
            align: 'center',
        }, {
            field: 'emailIsActive',
            title: '邮件状态',
            align: 'center',
                formatter: function (value, row, index) {
                    if(row.emailIsActive == 1){
                        return '<button class="btn btn-danger btn-sm" onclick="frozenemail(\'' + row.userNumber +  '\')">冻结邮箱</button> ';
                    }else{
                        return '<button class="btn btn-primary btn-sm" onclick="unfrozenemail(\'' + row.userNumber + '\')">解冻邮箱</button> ';
                    }
                }
        }, {
            field: 'email',
            title: '邮箱',
            align: 'center',
        },{
            field: 'telephone',
            title: '手机号码',
            align: 'center',
        }, {
                field: 'status',
                title: '状态',
                align: 'center',
                formatter: function (value, row, index) {
                    if(row.status == 1){
                        return '<button class="btn btn-danger btn-sm" onclick="frozenUser(\'' + row.userNumber + '\')">冻结用户</button> ';
                    }else{
                        return '<button class="btn btn-primary btn-sm" onclick="unfrozenUser(\'' + row.userNumber + '\')">解冻用户</button> ';
                    }
                }
            }],

        onLoadSuccess: function(){  //加载成功时执行

        },
        onLoadError: function(){  //加载失败时执行

        }
    });
})


//解冻账号
function unfrozenUser(userNumber) {
    $.ajax({
        type: 'POST',
        url: baselocation+'/system/user/frozenuser',
        data: {userNumber:userNumber,type:2},
        success: function(){
            window.location.reload();
        },
        dataType: 'json'
    });

}

/**
 * 冻结账户
 */
function frozenUser(userNumber){
    $.ajax({
        type: 'POST',
        url: baselocation+'/system/user/frozenuser',
        data: {userNumber:userNumber,type:1},
        success: function(){
            window.location.reload();
        },
        dataType: 'json'
    });

}


/**
 * 冻结邮箱
 * @param userNumber
 */
function frozenemail(userNumber) {
    $.ajax({
        type: 'POST',
        url: baselocation+'/system/user/frozenuser',
        data: {userNumber:userNumber,type:3},
        success: function(){
            window.location.reload();
        },
        dataType: 'json'
    });
}


/**
 * 解冻邮箱
 * @param userNumber
 */
function unfrozenemail(userNumber) {
    $.ajax({
        type: 'POST',
        url: baselocation+'/system/user/frozenuser',
        data: {userNumber:userNumber,type:4},
        success: function(){
            window.location.reload();
        },
        dataType: 'json'
    });
}





