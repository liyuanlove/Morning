/**
 * 进行格式转换
 */
function timeFormatter(value) {
	return new Date(value).Format("yyyy-MM-dd HH:mm:ss");
}
function statusFormatter(value) {
	if (value == 1) {
		return '<span class="label label-primary">显示</span>'
	} else if (value == 0) {
		return '<span class="label label-danger">隐藏</span>'
	}
}
function navFormatter(value) {
	if (value == 1) {
		return '<span class="label label-primary">显示</span>'
	} else if (value == 0) {
		return '<span class="label label-danger">隐藏</span>'
	}
}
function topFormatter(value) {
	if (value == 1) {
		return '<span class="label label-danger">置顶</span>'
	} else if (value == 0) {
		return '<span class="label label-primary">默认</span>'
	}
}
function hotFormatter(value) {
	if (value == 1) {
		return '<span class="label label-danger">热门</span>'
	} else if (value == 0) {
		return '<span class="label label-primary">默认</span>'
	}
}

function actionFormatter(value, row, index) {
	if (row.status == 1) {
		return [
			'<a class="freeze m-r-sm text-info" href="javascript:void(0)" title="隐藏">',
			'<i class="glyphicon glyphicon-pause"></i>',
			'</a>',
			'<a class="edit m-r-sm text-warning" href="javascript:void(0)" title="编辑">',
			'<i class="glyphicon glyphicon-edit"></i>',
			'</a>',
			'<a class="remove m-r-sm text-danger" href="javascript:void(0)" title="删除">',
			'<i class="glyphicon glyphicon-remove"></i>',
			'</a>',
			'<a class="log m-r-sm text-primary" href="javascript:void(0)" title="添加下级类目">',
			'<i class="glyphicon glyphicon-sort-by-attributes-alt"></i>',
			'</a>',
		].join('');
	} else {
		return [
			'<a class="normal m-r-sm text-info" href="javascript:void(0)" title="显示">',
			'<i class="glyphicon glyphicon-play"></i>',
			'</a>',
			'<a class="edit m-r-sm text-warning" href="javascript:void(0)" title="编辑">',
			'<i class="glyphicon glyphicon-edit"></i>',
			'</a>',
			'<a class="remove m-r-sm text-danger" href="javascript:void(0)" title="删除">',
			'<i class="glyphicon glyphicon-remove"></i>',
			'</a>',
			'<a class="log m-r-sm text-primary" href="javascript:void(0)" title="添加下级类目">',
			'<i class="glyphicon glyphicon-sort-by-attributes-alt"></i>',
			'</a>',
		].join('');
	}
}

function detailFormatter(index, row, $detail) {
	InitSubTable(index, row, $detail);
}

//初始化子表格(无线循环)
InitSubTable = function(index, row, $detail) {
	var parentid = row.categoryId;
	var cur_table = $detail.html('<table></table>').find('table');
	$(cur_table).bootstrapTable({
		url : baselocation + '/product/category/gid/' + parentid,
		method : 'get',
		sidePagination : 'server',
		clickToSelect : true,
		uniqueId : "categoryId",
		pagination : true,
		pageSize : 10,
		pageList : [ 10, 25 ],
		pageNumber : 1,
		columns : [ {
			field : 'categoryId',
			title : '分类编号',
			halign : 'center',
			align : 'center',
			sortable : 'true'
		}, {
			field : 'name',
			title : '分类名称',
			halign : 'center',
			align : 'center',
			sortable : 'true'
		}, {
			field : 'sort',
			title : '排序',
			halign : 'center',
			align : 'center',
			sortable : 'true'
		}, {
			field : 'status',
			title : '状态',
			halign : 'center',
			align : 'center',
			sortable : 'true',
			formatter : 'statusFormatter'
		}, {
			field : 'showInNav',
			title : '是否导航',
			halign : 'center',
			align : 'center',
			sortable : 'true',
			formatter : 'navFormatter'
		}, {
			field : 'showInTop',
			title : '是否置顶',
			halign : 'center',
			align : 'center',
			sortable : 'true',
			formatter : 'topFormatter'
		}, {
			field : 'showInHot',
			title : '是否热门',
			halign : 'center',
			align : 'center',
			sortable : 'true',
			formatter : 'hotFormatter'
		}, {
			title : '操作',
			halign : 'center',
			align : 'center',
			sortable : 'true',
			formatter : 'actionFormatter',
			events : 'actionEvents'
		}, ],
		//无线循环取子表，直到子表里面没有记录
		onExpandRow : function(index, row, $Subdetail) {
			oInit.InitSubTable(index, row, $Subdetail);
		}
	});
};

window.actionEvents = {
	'click .freeze' : function(e, value, row, index) {
		status_stop(e, index, row.categoryId);
	},
	'click .normal' : function(e, value, row, index) {
		status_start(index, row.categoryId);
	},
	'click .edit' : function(e, value, row, index) {
		layer_show(row.name, baselocation + '/product/category/' + row.categoryId + '/edit', 900, 650)
	},
	'click .remove' : function(e, value, row, index) {
		admin_delete(index, row.categoryId);
	},
	'click .log' : function(e, value, row, index) {
		layer_show(row.name, baselocation + '/product/category/' + row.categoryId + '/create', 900, 650)
	}
};

/**
 * 隐藏分类
 */
function status_stop(e, index, value) {
	console.info(e);
	layer.confirm('确认要隐藏该分类吗？', {
		btn : [ '确定', '取消' ] //按钮
	}, function() {
		$.ajax({
			dataType : 'json',
			type : 'put',
			url : baselocation + '/product/category/' + value + '/audit',
			success : function(result) {
				if (result.code == 1) {
					$('#table').bootstrapTable('refresh', {
						silent : true
					});
					layer.msg('该分类隐藏成功!', {
						icon : 5,
						time : 1000
					});
				} else {
					layer.alert(result.message, {
						icon : 2
					});
				}
			}
		})
	});
}

/**
 * 显示分类
 */
function status_start(index, value) {
	layer.confirm('确认要显示该分类吗？', {
		btn : [ '确定', '取消' ] //按钮
	}, function() {
		$.ajax({
			dataType : 'json',
			type : 'put',
			url : baselocation + '/product/category/' + value + '/audit',
			success : function(result) {
				if (result.code == 1) {
					$('#table').bootstrapTable('refresh', {
						silent : true
					});
					layer.msg('该分类显示成功!', {
						icon : 6,
						time : 1000
					});
				} else {
					layer.alert(result.message, {
						icon : 2
					});
				}
			}
		})
	});
}

/**
 * 删除分类
 */
function admin_delete(index, value) {
	layer.confirm('确认要删除该分类吗？', {
		btn : [ '确定', '取消' ] //按钮
	}, function() {
		$.ajax({
			type : 'delete',
			dataType : 'json',
			url : baselocation + '/product/category/' + value,
			success : function(result) {
				if (result.code == 1) {
					$('#table').bootstrapTable('hideRow', {
						index : index
					});
					layer.msg('该分类删除成功!', {
						icon : 1,
						time : 1000
					});
				} else {
					layer.alert(result.message, {
						icon : 2
					});
				}
			}
		})
	});
}



var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));

elems.forEach(function(html) {
	var switchery = new Switchery(html, {
		size : 'small'
	});
});

/**
 * 系统提示
 */
$(function() {
	$('.status-tip').on("click", function() {
		layer.tips('"显示" 代表此数据可用<br>"隐藏" 代表此数据不可用', '.status-tip');
	})
})


/**
 * 表单验证
 */
$(function() {
	$('#form').bootstrapValidator({
		container : 'tooltip',
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			'name' : {
				message : '分类名称验证失败',
				validators : {
					notEmpty : {
						message : '分类名称不能为空'
					}
				}
			},
			'code' : {
				message : '分类标志验证失败',
				validators : {
					notEmpty : {
						message : '分类标志不能为空'
					}
				}
			},
			'showNumber' : {
				message : '显示数量验证失败',
				validators : {
					notEmpty : {
						message : '分类栏显示数量不能为空'
					},
					regexp : {
						regexp : /^[0-9]*$/,
						message : '分类栏显示数量只能为数字'
					}
				}
			},
			'width' : {
				message : '宽度验证失败',
				validators : {
					notEmpty : {
						message : '宽度不能为空'
					},
					regexp : {
						regexp : /^[0-9]*$/,
						message : '宽度只能为数字'
					}
				}
			},
			'height' : {
				message : '高度验证失败',
				validators : {
					notEmpty : {
						message : '高度不能为空'
					},
					regexp : {
						regexp : /^[0-9]*$/,
						message : '高度只能为数字'
					}
				}
			},
		}
	})
		.on('success.form.bv', function(e) {
			// Prevent form submission
			e.preventDefault();

			// Get the form instance
			var $form = $(e.target);

			// Get the BootstrapValidator instance
			var bv = $form.data('bootstrapValidator');

			var method = $('#form').attr('data-method');
			// Use Ajax to submit form data
			if (method == 'put') {
				$.ajax({
					data : $form.serialize(),
					dataType : 'json',
					type : 'put',
					url : $form.attr('action'),
					success : function(result) {
						if (result.code == 1) {
							parent.layer.msg("更新分类成功!", {
								shade : 0.3,
								time : 1500
							}, function() {
								window.parent.location.reload(); // 刷新父页面
							});
						} else {
							layer.msg(result.message, {
								icon : 2,
								time : 1000
							});
						}
					}
				})
			} else if (method == 'post') {
				$.ajax({
					data : $form.serialize(),
					dataType : 'json',
					type : 'post',
					url : $form.attr('action'),
					success : function(result) {
						if (result.code == 1) {
							parent.layer.msg("创建分类成功!", {
								shade : 0.3,
								time : 1500
							}, function() {
								window.parent.location.reload(); // 刷新父页面
							});
						} else {
							layer.msg(result.message, {
								icon : 2,
								time : 1000
							});
						}
					}
				})
			}
		});
})