

function getImage(picImg) {
    layer.open({
        type: 2,
        area: [($(document).width()-600)+'px',($(document).height()-260)+'px'],
        fixed: false, //不固定
        maxmin: true,
        title: '查看图片',
        content: baselocation+'/product/common/imageView?picImg='+picImg
    });
}


function addProduct() {
    layer.open({
        type: 2,
        area: [($(document).width()-600)+'px',($(document).height()-220)+'px'],
        fixed: false, //不固定
        maxmin: true,
        title: '创建商品',
        content: baselocation+'/product/common/tocreate'
    });
}


function detail(productNumber) {
    layer.open({
        type: 2,
        area: [($(document).width()-600)+'px',($(document).height()-60)+'px'],
        fixed: false, //不固定
        maxmin: true,
        title: '商品详情',
        content: baselocation+'/product/common/todetail?productNumber='+productNumber
    });
}


/**
 * 冻结商品
 */
function frozen(productNumber) {
    $.ajax({
        type: 'POST',
        url: baselocation+'/product/common/frozen',
        data: {productNumber:productNumber,type:1},
        success: function(){
            window.location.reload();
        },
        dataType: 'json'
    });
}


/**
 * 解冻商品
 */
function unfrozen(productNumber) {
    $.ajax({
        type: 'POST',
        url: baselocation+'/product/common/frozen',
        data: {productNumber:productNumber,type:2},
        success: function(){
            window.location.reload();
        },
        dataType: 'json'
    });
}



$(function(){
    $('#table').bootstrapTable({
		url: baselocation+"/product/common/json",
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
            field: 'productId',
            title: '顺序ID'
        }, {
            field: 'productNumber',
            align: 'center',
            title: '商品ID'
        }, {
            field: 'name',
            align: 'center',
            title: '商品名称'
        }, {
            field: 'showPrice',
            align: 'center',
            title: '商品单价'
        }, {
            field: 'showScore',
            align: 'center',
            title: '商品购买积分'
        }, {
            field: 'introduce',
            align: 'center',
            title: '商品介绍'
        }, {
            field: 'picImg',
            title: '商品图片路径',
            align: 'center',
            formatter: function (value, row, index) {
               return '<button class="btn btn-primary btn-sm" onclick="getImage(\'' + row.picImg + '\')">查看图片</button> ';
            }
        },{
            field: 'labelName',
            align: 'center',
            title: '商品类型'
        },{
                field: 'id',
                title: '操作',
                align: 'center',
                formatter: function (value, row, index) {
                    var result = '<button class="btn btn-success btn-sm" onclick="detail(\'' + row.productNumber + '\')">查看</button> ';
                    if(row.isFrozen == 1){
                        result += '<button class="btn btn-danger btn-sm" onclick="frozen(\'' + row.productNumber + '\')">冻结商品</button> ';
                    }else{
                        result += '<button class="btn btn-info btn-sm" onclick="unfrozen(\'' + row.productNumber + '\')">解冻商品</button> ';
                    }
                    return result;
                }
        }],

        onLoadSuccess: function(){  //加载成功时执行
        },
        onLoadError: function(){  //加载失败时执行
        }
    });
})






