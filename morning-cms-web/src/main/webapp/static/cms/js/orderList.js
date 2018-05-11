/**
 * 进行格式转换
 */
//出货事件
function shipment(oid) {
    layer.open({
        type: 2,
        area: [($(window).width()-700)+'px',($(window).height()-200)+'px'],
        fixed: false, //不固定
        maxmin: true,
        content: baselocation+'/system/order/shipment?id='+oid
    });
}


$(function(){
    $('#table').bootstrapTable({
		url: "json/",
        dataType: "json",
        toolbar: '#toolbar',
        pagination: true,
        sidePagination: "server",
        columns: [
        {
            checkbox: true,
            align: 'center',
            valign: 'middle',
        },{
            field: 'oid',
            title: '订单顺序号',
            visible: false
        }, {
            field: 'name',
            title: '名称'
        }, {
            field: 'productSpecName',
            title: '产品名'
        }, {
            field: 'price',
            title: '价格'
        }, {
            field: 'buyNumber',
            title: '数量'
        }, {
            field: 'userName',
            title: '用户名'
        }, {
            field: 'userPhone',
            title: '用户号码'
        }, {
            field: 'updateTime',
            title: '创建时间'
        },{
                field: 'id',
                title: '操作',
                align: 'center',
                formatter: function (value, row, index) {
                    return '<button class="btn btn-primary btn-sm" onclick="test(\'' + row.oid + '\')">查看</button> '
                        +'<button class="btn btn-warning btn-sm" onclick="shipment(\'' + row.oid + '\')">出单凭证</button>'
                        ;
                }
        }],

        onLoadSuccess: function(){  //加载成功时执行
        },
        onLoadError: function(){  //加载失败时执行

        }



    });
})



