/**
 * 进行格式转换
 */

$(function(){
    var imageServer = "http://119.29.209.127";
    $('#table').bootstrapTable({
		url: baselocation+"/product/common/getImagesList",
        dataType: "json",
        toolbar: '#toolbar',
        pagination: true,
        sidePagination: "server",
        strictSearch: true,
        clickToSelect: true,

        columns: [
        {
            checkbox: true,
            align: 'center',
            valign: 'middle',
        },{
            field: 'fileName',
            align: 'center',
            title: '图片名称'
        }, {
            field: 'fileUrl',
            align: 'center',
            title: '图片URL',
            formatter: function (value, row, index) {
                return '<img src="' + imageServer+row.fileUrl + '" style="width:90px;height:60px; " class="img-rounded">';
            }
        }],

        onLoadSuccess: function(){  //加载成功时执行

        },
        onLoadError: function(){  //加载失败时执行

        }

    });
})



function ensureImages() {
    var select = $('#table').bootstrapTable('getSelections');
    var index = this.parent.layer.getFrameIndex(window.name);
    parent.selectdata=select;
    this.parent.layer.close(index);
}



