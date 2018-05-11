/**
 * 进行格式转换
 */

var E = window.wangEditor;
var editor = new E('#editor');
var ztree;

$(function(){
    editor.customConfig.menus = [
        'head',
        'bold',
        'italic',
        'underline',
        'strikeThrough',
        'foreColor',
        'backColor',
        'list',
        'undo',
        'redo',
    ];
    editor.create();
    //获取富文本内容
    $.ajax({
        type: 'GET',
        url: baselocation+'/product/common/productDescription',
        data: {productNumber:productNumber},
        success: function(data){
            editor.txt.html(data['message']);
        },
        dataType: 'json'
    });

    var setting = {
        view:{
            selectedMulti:false,
            dblClickExpand:false,
            showIcon: true
        },
        check:{
            enable:false,
            nocheckInherit:true
        },

        async:{
            enable:true,
            url:baselocation+"/product/common/treedata",
            dataType:"json",
            type:"get",
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: 1
            }
        }
    };

    ztree = $.fn.zTree.init($("#ztree"), setting, null);



})



function uploadImages() {
    layer.alert("上传提交",{icon:1});
    $("#imagesDeUpload").ajaxSubmit({
        url: baselocation+'/product/common/describeImages',
        type: "Post",
        dataType: 'json',
        success: function (data) {
            if(data != null){
                if(data.code === 1){
                    layer.alert(data.message,{icon:1});
                }else {
                    layer.alert(data.message,{icon:2});
                }
            }else {
                layer.alert("服务器端出现错误",{icon:5});
            }
        },
        error: function(data){

        }
    });
    //清空表单
    var file = $("#filecheck") ;
    file.after(file.clone().val(""));
    file.remove();
}

//从子元素来的返回值
//并把选择的值追加到富文本编辑器里面
var selectdata = null;
function selectImages() {
    //图片服务器地址
    var imageServer = "http://119.29.209.127";
    layer.open({
        type: 2,
        area: [($(window).width()-400)+'px',($(window).height()-100)+'px'],
        fixed: false, //不固定
        maxmin: true,
        content: baselocation+'/product/common/selectImages',
        end: function () {
            selectdata.forEach(function (value) {
                editor.txt.append('<p><center><img class="img-responsive" src="'+imageServer+value.fileUrl+'"/></center></p>');
            })
        }
    });
}


function modify() {

    $('#createProduct').bootstrapValidator({
        container : 'tooltip',
        message : '这个值不合法',
        feedbackIcons : {
            valid : 'glyphicon glyphicon-ok',
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        fields : {
            'name' : {
                message : '商品名不合法',
                validators : {
                    notEmpty : {
                        message : '商品名不能为空'
                    }
                }
            },
            'showScore' : {
                message : '积分值不合法',
                validators : {
                    notEmpty : {
                        message : '商品积分不能为空'
                    }
                }
            },
            'showPrice' : {
                validators : {
                    notEmpty : {
                        message : '商品价格不能为空'
                    }
                }
            },
            'introduce' : {
                validators : {
                    notEmpty : {
                        message : '商品介绍不能为空'
                    }
                }
            },
            'imgFile' : {
                validators : {
                    notEmpty : {
                        message : '商品图片不能为空'
                    }
                }
            },
            'stock' : {
                validators : {
                    notEmpty : {
                        message : '库存量设置不能为空'
                    }
                }
            }
        }
    })

    //手动触发验证
    var selectedNodes = ztree.getSelectedNodes();
    var bootstrapValidator = $('#createProduct').data('bootstrapValidator');
    bootstrapValidator.validate();
    if(bootstrapValidator.isValid()){

        $("#createProduct").ajaxSubmit({
            url: baselocation+'/product/common/createProduct',
            type: "post",
            dataType: 'json',
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            data: {
              'description' : editor.txt.html(),
              'categoryID' : selectedNodes[0].id
            },
            success: function (data) {
                if(data != null){
                    if(data.code === 1){
                        layer.alert(data.message,{icon:1});
                    }else {
                        layer.alert(data.message,{icon:2});
                    }
                }else {
                    layer.alert("服务器端出现错误",{icon:5});
                }
            },
            error: function(data){
                //请求发送错误
            }
        });
        //清空表单
        this.location.reload();
    }


}



