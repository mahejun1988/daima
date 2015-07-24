<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/pages/common/header.jsp"%><!--引入权限系统该页面需无须引用header.jsp -->
<%@ page import="java.util.Date"%>
<% String formId = "form_" + new Date().getTime();
   String gridId = "grid_" + new Date().getTime();
   String path = request.getContextPath()+request.getServletPath().substring(0,request.getServletPath().lastIndexOf("/")+1);
%>
<script type="text/javascript">
var grid;
var form;
var _dialog;
$(function (){
    grid = $("#<%=gridId%>");
    form = $("#<%=formId%>");
	PageLoader = {
	   //
	    initSearchPanel:function(){
	        	            	                	            	                	            	                	                     var startTimeVal = form.find('#createTimeID_start');
	                     var startTime = startTimeVal.parent();
	                     var endTimeVal = form.find('#createTimeID_end');
	                     var endTime = endTimeVal.parent();
	                     startTime.datetimepicker({
	                                        language: 'zh-CN',
	                                        format: "yyyy-mm-dd",
	                                        autoclose: true,
	                                        todayBtn: true,
	                                        minView: 2,
	                                        pickerPosition: 'bottom-left'
	                     }).on('changeDate', function(){
	                                 endTime.datetimepicker('setStartDate', startTimeVal.val());
	                           });//加载日期选择器
	                     var yesterday = new Date();
	                     yesterday.setDate(yesterday.getDate() - 1);
	                     endTime.datetimepicker({
	                             language: 'zh-CN',
	                             format: "yyyy-mm-dd",
	                             autoclose: true,
	                             todayBtn: true,
	                             minView: 2,
	                             pickerPosition: 'bottom-left'
	                     }).on('changeDate', function(ev){
	                                startTime.datetimepicker('setEndDate', endTimeVal.val());
	                           }).datetimepicker('setDate', new Date()).trigger('changeDate');//加载日期选择器
	                     startTime.datetimepicker('setDate', yesterday).trigger('changeDate');
	                	            	                	            	                	            	                	                     var startTimeVal = form.find('#updateTimeID_start');
	                     var startTime = startTimeVal.parent();
	                     var endTimeVal = form.find('#updateTimeID_end');
	                     var endTime = endTimeVal.parent();
	                     startTime.datetimepicker({
	                                        language: 'zh-CN',
	                                        format: "yyyy-mm-dd",
	                                        autoclose: true,
	                                        todayBtn: true,
	                                        minView: 2,
	                                        pickerPosition: 'bottom-left'
	                     }).on('changeDate', function(){
	                                 endTime.datetimepicker('setStartDate', startTimeVal.val());
	                           });//加载日期选择器
	                     var yesterday = new Date();
	                     yesterday.setDate(yesterday.getDate() - 1);
	                     endTime.datetimepicker({
	                             language: 'zh-CN',
	                             format: "yyyy-mm-dd",
	                             autoclose: true,
	                             todayBtn: true,
	                             minView: 2,
	                             pickerPosition: 'bottom-left'
	                     }).on('changeDate', function(ev){
	                                startTime.datetimepicker('setEndDate', endTimeVal.val());
	                           }).datetimepicker('setDate', new Date()).trigger('changeDate');//加载日期选择器
	                     startTime.datetimepicker('setDate', yesterday).trigger('changeDate');
	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	        	     },
	    initGridPanel: function(){
	         var self = this;
	         var width = 180;
	         return grid.grid({
	                identity:"id",
	                buttons: [
	                        {content: '<button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-plus"><span>添加</button>', action: 'add'},
	                        {content: '<button class="btn btn-success" type="button"><span class="glyphicon glyphicon-edit"><span>修改</button>', action: 'modify'},
	                        {content: '<button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove"><span>删除</button>', action: 'delete'}
	                    ],
	                url:"${pageContext.request.contextPath}/OutWay/pageJson.do",
	                columns: [
	                     	                         	                         { title: '创建时间', name: 'createTime', width: width},
	                         	                         	                         	                         { title: '创建人', name: 'createUser', width: width},
	                         	                         	                         	                         { title: '更新时间', name: 'updateTime', width: width},
	                         	                         	                         	                         { title: '更新人', name: 'updateUser', width: width},
	                         	                         	                         	                         { title: '运单号', name: 'waybillId', width: width},
	                         	                         	                         	                         { title: '出货单号', name: 'outWayId', width: width},
	                         	                         	                         	                         { title: '物流公司', name: 'outWayCoo', width: width},
	                         	                         	                         	                         { title: '箱子数量', name: 'boxCount', width: width},
	                         	                         	                         	                         { title: '是否合箱', name: 'Merge_Flag', width: width},
	                         	                         	                         	                         { title: '日元（JPY）', name: 'jpyPrice', width: width},
	                         	                         	                         	                         { title: '人民币（CNY）', name: 'cnyPrice', width: width},
	                         	                         	                         	                         { title: '美元（USD）', name: 'usdPrice', width: width},
	                         	                         	                         	                         { title: '欧元（EUR）', name: 'eurPrice', width: width},
	                         	                         	                         	                         { title: '箱子重量', name: 'weight', width: width},
	                         	                         	                         	                         { title: '箱子长度', name: 'length', width: width},
	                         	                         	                         	                         { title: '箱子宽度', name: 'width', width: width},
	                         	                         	                         	                         { title: '箱子高度', name: 'height', width: width},
	                         	                         	                         	                         { title: '体积重', name: 'volume', width: width},
	                         	                         	                         	                         { title: '提货仓库地址', name: 'pickup_Addr', width: width},
	                         	                         	                         	                         { title: '收货地址', name: 'reciever_Addr', width: width},
	                         	                         	                         	                         { title: '客户编码', name: 'Customer_ID', width: width},
	                         	                         	                         	                         { title: '客户姓名', name: 'Customer_Name', width: width},
	                         	                         	                             { title: '操作', width: 120, render: function (rowdata, name, index)
	                                 {
	                                     var param = '"' + rowdata.id + '"';
	                                     var h = "<a href='javascript:openDetailsPage(" + param + ")'>查看</a> ";
	                                     return h;
	                                 }
	                             }
	                ]
	         }).on({
	                   'add': function(){
	                       self.add($(this));
	                   },
	                   'modify': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                type: 'warning',
	                                content: '请选择一条记录进行修改'
	                            })
	                            return;
	                        }
	                        if(indexs.length > 1){
	                            $this.message({
	                                type: 'warning',
	                                content: '只能选择一条记录进行修改'
	                            })
	                            return;
	                        }
	                       self.modify(indexs[0], $this);
	                    },
	                   'delete': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                   type: 'warning',
	                                   content: '请选择要删除的记录'
	                            });
	                            return;
	                        }
	                        var remove = function(){
	                            self.remove(indexs, $this);
	                        };
	                        $this.confirm({
	                            content: '确定要删除所选记录吗?',
	                            callBack: remove
	                        });
	                   }
	         });
	    },
	    add: function(grid){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog">'
	        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
	        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
	        	+'<h4 class="modal-title">新增</h4></div><div class="modal-body">'
	        	+'<p>One fine body&hellip;</p></div><div class="modal-footer">'
	        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
	        	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
	        	+'</div></div>');
	        $.get('<%=path%>/OutWay-add.jsp').done(function(html){
	            dialog.modal({
	                keyboard:false
	            }).on({
	                'hidden.bs.modal': function(){
	                    $(this).remove();
	                }
	            }).find('.modal-body').html(html);
	            self.initPage(dialog.find('form'));
	        });
	        dialog.find('#save').on('click',{grid: grid}, function(e){
	              if(!Validator.Validate(dialog.find('form')[0],3))return;
	              $.post('${pageContext.request.contextPath}/OutWay/add.do', dialog.find('form').serialize()).done(function(result){
	                   if(result.success ){
	                        dialog.modal('hide');
	                        e.data.grid.data('koala.grid').refresh();
	                        e.data.grid.message({
	                            type: 'success',
	                            content: '保存成功'
	                         });
	                    }else{
	                        dialog.find('.modal-content').message({
	                            type: 'error',
	                            content: result.actionError
	                        });
	                     }
	              });
	        });
	    },
	    modify: function(id, grid){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">修改</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">取消</button><button type="button" class="btn btn-success" id="save">保存</button></div></div></div></div>');
	        $.get('<%=path%>/OutWay-update.jsp').done(function(html){
	               dialog.find('.modal-body').html(html);
	               self.initPage(dialog.find('form'));
	               $.get( '${pageContext.request.contextPath}/OutWay/get/' + id + '.do').done(function(json){
	                       json = json.data;
	                        var elm;
	                        for(var index in json){
	                            elm = dialog.find('#'+ index + 'ID');
	                            if(elm.hasClass('select')){
	                                elm.setValue(json[index]);
	                            }else{
	                                elm.val(json[index]);
	                            }
	                        }
	                });
	                dialog.modal({
	                    keyboard:false
	                }).on({
	                    'hidden.bs.modal': function(){
	                        $(this).remove();
	                    }
	                });
	                dialog.find('#save').on('click',{grid: grid}, function(e){
	                    if(!Validator.Validate(dialog.find('form')[0],3))return;
	                    $.post('${pageContext.request.contextPath}/OutWay/update.do?id='+id, dialog.find('form').serialize()).done(function(result){
	                        if(result.success){
	                            dialog.modal('hide');
	                            e.data.grid.data('koala.grid').refresh();
	                            e.data.grid.message({
	                            type: 'success',
	                            content: '保存成功'
	                            });
	                        }else{
	                            dialog.find('.modal-content').message({
	                            type: 'error',
	                            content: result.actionError
	                            });
	                        }
	                    });
	                });
	        });
	    },
	    initPage: function(form){
	              form.find('.form_datetime').datetimepicker({
	                   language: 'zh-CN',
	                   format: "yyyy-mm-dd",
	                   autoclose: true,
	                   todayBtn: true,
	                   minView: 2,
	                   pickerPosition: 'bottom-left'
	               }).datetimepicker('setDate', new Date());//加载日期选择器
	               form.find('.select').each(function(){
	                    var select = $(this);
	                    var idAttr = select.attr('id');
	                    select.select({
	                        title: '请选择',
	                        contents: selectItems[idAttr]
	                    }).on('change', function(){
	                        form.find('#'+ idAttr + '_').val($(this).getValue());
	                    });
	               });
	    },
	    remove: function(ids, grid){
	    	var data = [{ name: 'ids', value: ids.join(',') }];
	    	$.post('${pageContext.request.contextPath}/OutWay/delete.do', data).done(function(result){
	                        if(result.success){
	                            grid.data('koala.grid').refresh();
	                            grid.message({
	                                type: 'success',
	                                content: '删除成功'
	                            });
	                        }else{
	                            grid.message({
	                                type: 'error',
	                                content: result.result
	                            });
	                        }
	    	});
	    }
	}
	PageLoader.initSearchPanel();
	PageLoader.initGridPanel();
	form.find('#search').on('click', function(){
            if(!Validator.Validate(document.getElementById("<%=formId%>"),3))return;
            var params = {};
            form.find('input').each(function(){
                var $this = $(this);
                var name = $this.attr('name');
                if(name){
                    params[name] = $this.val();
                }
            });
            grid.getGrid().search(params);
        });
});

var openDetailsPage = function(id){
        var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">查看</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-info" data-dismiss="modal">返回</button></div></div></div></div>');
        $.get('<%=path%>/OutWay-view.jsp').done(function(html){
               dialog.find('.modal-body').html(html);
               $.get( '${pageContext.request.contextPath}/OutWay/get/' + id + '.do').done(function(json){
                       json = json.data;
                        var elm;
                        for(var index in json){
                        if(json[index]+"" == "false"){
                        		dialog.find('#'+ index + 'ID').html("<span style='color:#d2322d' class='glyphicon glyphicon-remove'></span>");
                        	}else if(json[index]+"" == "true"){
                        		dialog.find('#'+ index + 'ID').html("<span style='color:#47a447' class='glyphicon glyphicon-ok'></span>");
                        	}else{
                          		 dialog.find('#'+ index + 'ID').html(json[index]+"");
                        	}
                        }
               });
                dialog.modal({
                    keyboard:false
                }).on({
                    'hidden.bs.modal': function(){
                        $(this).remove();
                    }
                });
        });
}
</script>
</head>
<body>
<div style="width:98%;margin-right:auto; margin-left:auto; padding-top: 15px;">
<!-- search form -->
<form name=<%=formId%> id=<%=formId%> target="_self" class="form-horizontal">
<input type="hidden" name="page" value="0">
<input type="hidden" name="pagesize" value="10">
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
          <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">创建人:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="createUser" class="form-control" type="text" style="width:180px;" id="createUserID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">更新人:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="updateUser" class="form-control" type="text" style="width:180px;" id="updateUserID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">创建时间:&nbsp;</label>
           <div style="margin-left:15px;float:left;">
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="createTime" id="createTimeID_start" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <div style="float:left; width:10px; margin-left:auto; margin-right:auto;">&nbsp;-&nbsp;</div>
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="createTimeEnd" id="createTimeID_end" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
       </div>
                      <label class="control-label" style="width:100px;float:left;">箱子高度:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="height" class="form-control" type="text" style="width:180px;" id="heightID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">提货仓库地址:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="pickup_Addr" class="form-control" type="text" style="width:180px;" id="pickup_AddrID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">更新时间:&nbsp;</label>
           <div style="margin-left:15px;float:left;">
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="updateTime" id="updateTimeID_start" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <div style="float:left; width:10px; margin-left:auto; margin-right:auto;">&nbsp;-&nbsp;</div>
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="updateTimeEnd" id="updateTimeID_end" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
       </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">客户编码:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="Customer_ID" class="form-control" type="text" style="width:180px;" id="Customer_IDID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">客户姓名:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="Customer_Name" class="form-control" type="text" style="width:180px;" id="Customer_NameID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">运单号:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="waybillId" class="form-control" type="text" style="width:180px;" id="waybillIdID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">箱子数量:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="boxCount" class="form-control" type="text" style="width:180px;" id="boxCountID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">出货单号:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="outWayId" class="form-control" type="text" style="width:180px;" id="outWayIdID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">日元（JPY）:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="jpyPrice" class="form-control" type="text" style="width:180px;" id="jpyPriceID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">物流公司:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="outWayCoo" class="form-control" type="text" style="width:180px;" id="outWayCooID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">美元（USD）:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="usdPrice" class="form-control" type="text" style="width:180px;" id="usdPriceID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">是否合箱:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="Merge_Flag" class="form-control" type="text" style="width:180px;" id="Merge_FlagID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">箱子重量:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="weight" class="form-control" type="text" style="width:180px;" id="weightID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">人民币（CNY）:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="cnyPrice" class="form-control" type="text" style="width:180px;" id="cnyPriceID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">箱子宽度:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="width" class="form-control" type="text" style="width:180px;" id="widthID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">欧元（EUR）:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="eurPrice" class="form-control" type="text" style="width:180px;" id="eurPriceID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">体积重:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="volume" class="form-control" type="text" style="width:180px;" id="volumeID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">箱子长度:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="length" class="form-control" type="text" style="width:180px;" id="lengthID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">收货地址:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="reciever_Addr" class="form-control" type="text" style="width:180px;" id="reciever_AddrID"  />
        </div>
            </div>
            </td>
       <td style="vertical-align: bottom;"><button id="search" type="button" style="position:relative; margin-left:35px; top: -15px" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button></td>
  </tr>
</table>	
</form>
<!-- grid -->
<div id=<%=gridId%>></div>
</div>
</body>
</html>
