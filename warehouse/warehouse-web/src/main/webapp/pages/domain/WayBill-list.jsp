<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>
<%@ taglib uri="http://www.openkoala.org/i18n" prefix="koala" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import="java.util.Date"%>
<% String formId = "form_" + new Date().getTime();
   String gridId = "grid_" + new Date().getTime();
   String path = request.getContextPath()+request.getServletPath().substring(0,request.getServletPath().lastIndexOf("/")+1);
   String M = "zh_CN";
	if(request.getSession().getAttribute("locale") != null){
		M = (String)request.getSession().getAttribute("locale"); //从session里把a拿出来，并赋值给M  	
	}
%>
<script type="text/javascript">
var grid;
var form;
var _dialog;
$(function (){
	var id = '<%=M %>';
	jQuery.i18n.properties({//加载资浏览器语言对应的资源文件
		name:'strings', //资源文件名称
		path:'resources/i18n/warehouse/', //资源文件路径
		mode:'map', //用Map的方式使用资源文件中的值
		language:id,// 对应的语言
		callback: function() {//加载成功后设置显示内容
			
		}
	});
	grid = $("#<%=gridId%>");
    form = $("#<%=formId%>");
	PageLoader = {
	   //
	    initSearchPanel:function(){
	        	         var startTimeVal = form.find('#createDateID_start');
	                     var startTime = startTimeVal.parent();
	                     var endTimeVal = form.find('#createDateID_end');
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
	                             minView: 3,
	                             pickerPosition: 'bottom-left'
	                     }).on('changeDate', function(ev){
	                                startTime.datetimepicker('setEndDate', endTimeVal.val());
	                           }).datetimepicker('setDate', new Date()).trigger('changeDate');//加载日期选择器
	                     startTime.datetimepicker('setDate', yesterday).trigger('changeDate');
	                	            	                	            	                	            	        	     },
	    initGridPanel: function(){
	         var self = this;
	         var width = 120;
	         return grid.grid({
	                identity:"id",
	                buttons: [
// 	                        {content: '<button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-plus"><span>添加</button>', action: 'add'},
	                        {content: '<button class="btn btn-success" type="button"><span class="glyphicon glyphicon-edit"><span>修改</button>', action: 'modify'},
							{content: '<button class="btn btn-info" type="button"><span class="glyphicon glyphicon-th-large"><span>'+$.i18n.prop('express.warehouse.out')+'</button>', action: 'outWayBillByAll'},
	                        {content: '<button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove"><span>'+$.i18n.prop('delete')+'</button>', action: 'delete'}
// 	                        {content: '<button class="btn btn-info" type="button"><span class="glyphicon glyphicon-th-large"><span>快速出库</button>', action: 'outWayBill'},
	                        
	                    ],
	                url:"${pageContext.request.contextPath}/WayBill/pageJson.do",
	                columns: [
										   { title: $.i18n.prop('customer.id'), name: 'eurPrice', width: width},
	               	                       { title: $.i18n.prop('express.no'), name: 'waybillId', width: width+20},
	               	                       { title: $.i18n.prop('out.flag'), name: 'outFlag', width: 70},
	                   	                   { title: $.i18n.prop('out.time'), name: 'outTime', width: 100},
	                   	                   { title: $.i18n.prop('express.arrived.time'), name: 'arrivalTime', width: 100},
	                   	                   { title: $.i18n.prop('express.box.count'), name: 'wayBillNum', width: 70},
	               	                       { title: $.i18n.prop('express.company'), name: 'wayBillCoo', width: width},
	                   	                   { title: $.i18n.prop('express.goods.addr'), name: 'wayBillFrom', width: width+80},
	                   	                   { title: $.i18n.prop('express.goods.url'), name: 'wayBillInternet', width: width+80}
// 	                   	                   { title: '金额类型', name: 'payType', width: width},
// 	                   	                   { title: '金额', name: 'money', width: width},
	                   	                   
// 	             					        { title: '操作', width: 120, render: function (rowdata, name, index)
// 	                                 {
// 	                                     var param = '"' + rowdata.id + '"';
// 	                                     var h = "<a href='javascript:openDetailsPage(" + param + ")'>查看</a>";
// 	                                     return h;
// 	                                 }
// 	                             }
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
	                                content: $.i18n.prop('only.one')
	                            })
	                            return;
	                        }
	                        if(indexs.length > 1){
	                            $this.message({
	                                type: 'warning',
	                                content: $.i18n.prop('must.one')
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
	                                   content:$.i18n.prop('delete.rows')
	                            });
	                            return;
	                        }
	                        var remove = function(){
	                            self.remove(indexs, $this);
	                        };
	                        $this.confirm({
	                            content:  $.i18n.prop('delete.confirm'),
	                            callBack: remove
	                        });
	                   },
	                   'outWayBill': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                type: 'warning',
	                                content: $.i18n.prop('only.one')
	                            })
	                            return;
	                        }
	                        if(indexs.length > 1){
	                            $this.message({
	                                type: 'warning',
	                                content: $.i18n.prop('must.one')
	                            })
	                            return;
	                        }
	                       self.outWayBill(indexs[0], $this);
	                    },
	                    'outWayBillByAll': function(event, data){
	                        var indexs = data.data;
// 	                        alert(JSON.stringify(data));
							var items = data.item;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                type: 'warning',
	                                content: $.i18n.prop('only.one')
	                            })
	                            return;
	                        }
	                        for(var i = 0; i < items.length; i++){
	                      	   if(items[i].outFlag == '是'){
	                      		   $this.message({
	                                     type: 'warning',
	                                     content: $.i18n.prop('error')+',info:含有已经出库的运单，请不要重复出库~'
	                                 })
	                                 return;
	                      	   }
	                         }
	                       self.outWayBillByAll(indexs, items, $this);
	                    }
	         });
	    },
	    add: function(grid){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog">'
	        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
	        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
	        	+'<h4 class="modal-title">'+$.i18n.prop('insert')+'</h4></div><div class="modal-body">'
	        	+'<p>One fine body&hellip;</p></div><div class="modal-footer">'
	        	+'<button type="button" class="btn btn-default" data-dismiss="modal">'+$.i18n.prop('cancel')+'</button>'
	        	+'<button type="button" class="btn btn-success" id="save">'+$.i18n.prop('confirm')+'</button></div></div>'
	        	+'</div></div>');
	        $.get('<%=path%>/WayBill-add.jsp').done(function(html){
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
	              $.post('${pageContext.request.contextPath}/WayBill/add.do', dialog.find('form').serialize()).done(function(result){
	                   if(result.success ){
	                        dialog.modal('hide');
	                        e.data.grid.data('koala.grid').refresh();
	                        e.data.grid.message({
	                            type: 'success',
	                            content: $.i18n.prop('success')
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
	        openTab('/WayBill/get/' + id + '.do','运单信息修改');
// 	        var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">'+$.i18n.prop('modify')+'</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">'+$.i18n.prop('cancel')+'</button><button type="button" class="btn btn-success" id="save">'+$.i18n.prop('confirm')+'</button></div></div></div></div>');
<%-- 	        $.get('<%=path%>/WayBill-update.jsp').done(function(html){ --%>
// 	               dialog.find('.modal-body').html(html);
// 	               self.initPage(dialog.find('form'));
// 	               $.get( '${pageContext.request.contextPath}/WayBill/get/' + id + '.do').done(function(json){
// 	                       json = json.data;
// 	                        var elm;
// 	                        for(var index in json){
// 	                            elm = dialog.find('#'+ index + 'ID');
// 	                            if(elm.hasClass('select')){
// 	                                elm.setValue(json[index]);
// 	                            }else{
// 	                                elm.val(json[index]);
// 	                            }
// 	                        }
// 	                });
// 	                dialog.modal({
// 	                    keyboard:false
// 	                }).on({
// 	                    'hidden.bs.modal': function(){
// 	                        $(this).remove();
// 	                    }
// 	                });
// 	                dialog.find('#save').on('click',{grid: grid}, function(e){
// 	                    if(!Validator.Validate(dialog.find('form')[0],3))return;
// 	                    $.post('${pageContext.request.contextPath}/WayBill/update.do?id='+id, dialog.find('form').serialize()).done(function(result){
// 	                        if(result.success){
// 	                            dialog.modal('hide');
// 	                            e.data.grid.data('koala.grid').refresh();
// 	                            e.data.grid.message({
// 	                            type: 'success',
// 	                            content: $.i18n.prop('success')
// 	                            });
// 	                        }else{
// 	                            dialog.find('.modal-content').message({
// 	                            type: 'error',
// 	                            content: result.actionError
// 	                            });
// 	                        }
// 	                    });
// 	                });
// 	        });
	    },
	    outWayBill: function(id, grid){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">'+$.i18n.prop('express.warehouse.out')+'</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">'+$.i18n.prop('cancel')+'</button><button type="button" class="btn btn-success" id="save">'+$.i18n.prop('confirm')+'</button></div></div></div></div>');
	        $.get('<%=path%>/WayBill-out.jsp').done(function(html){
	               dialog.find('.modal-body').html(html);
	               self.initPage(dialog.find('form'));
	               $.get( '${pageContext.request.contextPath}/WayBill/get/' + id + '.do').done(function(json){
	                       json = json.data;
	                        var elm;
	                        for(var index in json){
	                            elm = dialog.find('#'+ index + 'ID2');
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
	                    if($("#waybillIdID2").val() != $("#waybillID2_").val()){
	                    		alert("运单号确认错误");
	                            return;
	                    }
	                    $.post('${pageContext.request.contextPath}/WayBill/out.do?id='+id, dialog.find('form').serialize()).done(function(result){
	                        if(result.success){
	                            dialog.modal('hide');
	                            e.data.grid.data('koala.grid').refresh();
	                            e.data.grid.message({
	                            type: 'success',
	                            content:$.i18n.prop('success')
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
	    outWayBillByAll: function(ids, items,grid){
	    	var data = [{ name: 'ids', value: ids.join(',') }];
	        var self = this;
            var ydID = [];
            for(var i = 0; i < items.length; i++){
         	   ydID.push(items[i].waybillId);
            }
	        var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">'+$.i18n.prop('express.warehouse.out')+'</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">'+$.i18n.prop('cancel')+'</button><button type="button" class="btn btn-success" id="save">'+$.i18n.prop('confirm')+'</button></div></div></div></div>');
	        $.get('<%=path%>/WayBill-out-list.jsp').done(function(html){
	               dialog.find('.modal-body').html(html);
	               self.initPage(dialog.find('form'));
	               var elm = dialog.find('#waybillIdID3');
	               elm.val(ydID.join(','));
	                dialog.modal({
	                    keyboard:false
	                }).on({
	                    'hidden.bs.modal': function(){
	                        $(this).remove();
	                    }
	                });
	                dialog.find('#save').on('click',{grid: grid}, function(e){
	                    if(!Validator.Validate(dialog.find('form')[0],3))return;
// 	                    $.post('${pageContext.request.contextPath}/OutWay/add.do?id='+id, dialog.find('form').serialize()).done(function(result){
						$.post('${pageContext.request.contextPath}/OutWay/add.do', dialog.find('form').serialize()).done(function(result){
	                        if(result.success){
	                            dialog.modal('hide');
	                            e.data.grid.data('koala.grid').refresh();
	                            e.data.grid.message({
	                            type: 'success',
	                            content: $.i18n.prop('success')
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
	                   minView: 3,
	                   pickerPosition: 'bottom-left'
	               }).datetimepicker('setDate', new Date());//加载日期选择器
	               form.find('.select').each(function(){
	                    var select = $(this);
	                    var idAttr = select.attr('id');
	                    select.select({
	                        title: $.i18n.prop('choose'),
	                        contents: selectItems[idAttr]
	                    }).on('change', function(){
	                        form.find('#'+ idAttr + '_').val($(this).getValue());
	                    });
	               });
	    },
	    remove: function(ids, grid){
	    	var data = [{ name: 'ids', value: ids.join(',') }];
	    	$.post('${pageContext.request.contextPath}/WayBill/delete.do', data).done(function(result){
	                        if(result.success){
	                            grid.data('koala.grid').refresh();
	                            grid.message({
	                                type: 'success',
	                                content: $.i18n.prop('success')
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
        var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">'+$.i18n.prop('detail')+'</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-info" data-dismiss="modal">'+$.i18n.prop('cancel')+'</button></div></div></div></div>');
        $.get('<%=path%>/WayBill-view.jsp').done(function(html){
               dialog.find('.modal-body').html(html);
               $.get( '${pageContext.request.contextPath}/WayBill/get/' + id + '.do').done(function(json){
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
          <label class="control-label" style="width:150px;float:left;"><koala:i18n key="express.no"/>:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="waybillId" class="form-control" type="text" style="width:180px;" id="waybillIdID"  />
        </div>
                    
            </div>
                </td>
                
       <td style="vertical-align: bottom;"><button id="search" type="button" style="position:relative; margin-left:35px; top: -15px" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>&nbsp;<koala:i18n key="query"/></button></td>
  </tr>
</table>	
</form>
<!-- grid -->
<div id=<%=gridId%>></div>
</div>
</body>
</html>
