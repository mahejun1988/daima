<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>
<%@ taglib uri="http://www.openkoala.org/i18n" prefix="koala" %>
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
   String M = "zh_CN";
	if(request.getSession().getAttribute("locale") != null){
		M = (String)request.getSession().getAttribute("locale"); //从session里把a拿出来，并赋值给M  	
	}
%>
<script type="text/javascript">

var grid;
var form;
var _dialog;
var id;
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
            var contents = [{title:$.i18n.prop('choose'), value: ''}];
            form.find('.select').each(function(){
                var select = $(this);
                var idAttr = select.attr('id');
                select.select({
                    title: $.i18n.prop('choose'),
                    contents: selectItems[idAttr]
                }).on('change', function(){
                    form.find('#'+ idAttr.replace("_SELECT","") + 'ID_').val($(this).getValue());
                    form.find('#'+ idAttr.replace("_SELECT","") + 'ID_name').val($(this).getItem());
                });
           });
        },
	    initGridPanel: function(){
	         var self = this;
	         var width = 180;
	         return grid.grid({
	                identity:"id",
	                buttons: [
	                        {content: '<button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-plus"><span>'+$.i18n.prop('insert')+'</button>', action: 'add'},
	                        {content: '<button class="btn btn-success" type="button"><span class="glyphicon glyphicon-edit"><span>'+$.i18n.prop('modify')+'</button>', action: 'modify'},
	                        {content: '<button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove"><span>'+$.i18n.prop('delete')+'</button>', action: 'delete'}
	                    ],
	                url:"${pageContext.request.contextPath}/Kind/pageJson.do",
	                columns: [
							   { title: $.i18n.prop('kind.code'), name: 'typeName', width: 100},
		                       { title: $.i18n.prop('kind.name'), name: 'codeName', width: 140},
		                       { title: $.i18n.prop('mark'), name: 'remark', width: 140},
	                     	   { title: $.i18n.prop('insert.time'), name: 'createTime', width: 120},
	                           { title: $.i18n.prop('insert.id'), name: 'createUser', width: 80},
	                           { title: $.i18n.prop('modify.time'), name: 'updateTime', width: 120},
	                           { title: $.i18n.prop('modify.id'), name: 'updateUser', width: 80},
	                           { title: $.i18n.prop('operate'), width: 80, render: function (rowdata, name, index)
		                           {
		                        	   var param = '"' + rowdata.id + '"';
		                               var h = "<a href='javascript:openDetailsPage(" + param + ")'>"+$.i18n.prop('detail')+"</a> ";
		                               return h;
		                            }
	          					}
	                		]
	         		}).on({
	                   'add': function(event, data){//data change item
	                	   
	       	        		var indexs = data.data;
	       	                var grid = $(this);        	  
	       		            if(indexs.length > 1){
	       		                     grid.message({
	       		                    type: 'warning',
	       		                    content: $.i18n.prop('only.one')
	       		                });
	       		                return;
	       		            }
	                       self.add($(this),(data.data?data.item[0]:null));
	                   },
	                   'modify': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                type: 'warning',
	                                content: $.i18n.prop('must.one')
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
	                                   content: $.i18n.prop('delete.rows')
	                            });
	                            return;
	                        }
	                        var remove = function(){
	                            self.remove(indexs, $this);
	                        };
	                        $this.confirm({
	                            content: $.i18n.prop('delete.confirm'),
	                            callBack: remove
	                        });
	                   }
	         });
	    },
	    add: function(grid,item){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog">'
	        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
	        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
	        	+'<h4 class="modal-title">'+$.i18n.prop('insert')+'</h4></div><div class="modal-body">'
	        	+'<p>One fine body&hellip;</p></div><div class="modal-footer">'
	        	+'<button type="button" class="btn btn-default" data-dismiss="modal">'+$.i18n.prop('cancel')+'</button>'
	        	+'<button type="button" class="btn btn-success" id="save">'+$.i18n.prop('confirm')+'</button></div></div>'
	        	+'</div></div>');
	        $.get('<%=path%>/Kind-add.jsp').done(function(html){
	            dialog.modal({
	                keyboard:false
	            }).on({
	                'hidden.bs.modal': function(){
	                    $(this).remove();
	                }
	            }).find('.modal-body').html(html);
	            self.initPage(dialog.find('form'),item);
	        });
	        dialog.find('#save').on('click',{grid: grid}, function(e){
	              if(!Validator.Validate(dialog.find('form')[0],3))return;
	              $.post('${pageContext.request.contextPath}/Kind/add.do', dialog.find('form').serialize()).done(function(result){
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
	        var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">'+$.i18n.prop('modify')+'</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">'+$.i18n.prop('cancel')+'</button><button type="button" class="btn btn-success" id="save">'+$.i18n.prop('confirm')+'</button></div></div></div></div>');
	        $.get('<%=path%>/Kind-update.jsp').done(function(html){
	               dialog.find('.modal-body').html(html);
	               self.initPage(dialog.find('form'));
	               $.get( '${pageContext.request.contextPath}/Kind/get/' + id + '.do').done(function(json){
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
	                    $.post('${pageContext.request.contextPath}/Kind/update.do?id='+id, dialog.find('form').serialize()).done(function(result){
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
	    initPage: function(form,item){
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
	                        title: $.i18n.prop('choose'),
	                        contents: selectItems[idAttr]
	                    }).on('change', function(){
	                        form.find('#'+ idAttr + '_').val($(this).getValue());
	                        form.find('#'+ idAttr + '_name').val($(this).getItem());
	                    });
	               });
				if(item != null && item.codeType == "kind"){
	                form.find("input[name='upCodeName']").val(item.codeName);
	                form.find("input[name='upCode']").val(item.code);
	                form.find("input[name='codeType']").val(item.codeType);
	                form.find("input[name='typeName']").val($.i18n.prop('goods_class'));
	                form.find(".codeTypeSelect").hide();
				}else{//添加菜单的时候不选中记录，那么就不显示父菜单。
	                form.find(".upCodeName").hide();
					
	            }
	    },
	    remove: function(ids, grid){
	    	var data = [{ name: 'ids', value: ids.join(',') }];
	    	$.post('${pageContext.request.contextPath}/Kind/delete.do', data).done(function(result){
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
	form.find('#kindsearch').on('click', function(){
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
        $.get('<%=path%>/Kind-view.jsp').done(function(html){
               dialog.find('.modal-body').html(html);
               $.get( '${pageContext.request.contextPath}/Kind/get/' + id + '.do').done(function(json){
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
<!-- <input  name="page" value="0"> -->
<!-- <input  name="pagesize" value="10"> -->
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
        <div class="form-group">
          <label class="control-label" style="width:100px;float:left;"><koala:i18n key="kind.parent.code"/>${tt}:&nbsp;</label>
             <div style="margin-left:15px;float:left;">
	             <div class="btn-group select" id="codeType_SELECT"></div>
		         <input type="hidden" id="codeTypeID_"  name="codeType" />
	         </div>
          <label class="control-label" style="width:100px;float:left;"><koala:i18n key="kind.sub.code"/>:&nbsp;</label>
             <div style="margin-left:15px;float:left;">
	             <div class="btn-group select" id="code_SELECT"></div>
		         <input type="hidden" id="upCodeID_"  name="upCode" value="0"/>
	         </div>
        </div>  
     </td>
     <td style="vertical-align: bottom;"><button id="kindsearch" type="button" style="position:relative; margin-left:35px; top: -15px" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>&nbsp;<koala:i18n key="query"/></button></td>
  </tr>
</table>	
</form>
<!-- grid -->
<div id=<%=gridId%>></div>
</div>
<script type="text/javascript">
	var id = '<%=M %>';
	jQuery.i18n.properties({//加载资浏览器语言对应的资源文件
		name:'strings', //资源文件名称
		path:'resources/i18n/warehouse/', //资源文件路径
		mode:'map', //用Map的方式使用资源文件中的值
		language:id,// 对应的语言
		callback: function() {//加载成功后设置显示内容
			
		}
	});
    var selectItems = {};
    var contents = [{title:$.i18n.prop('choose'), value: ''}];
    var contents1 = [{title:$.i18n.prop('choose'), value: '0'}];
    selectItems['code_SELECT'] = contents1;
        contents.push({title:$.i18n.prop('express.company') , value:'express'});
        contents.push({title:$.i18n.prop('goods_kind') , value:'kind'});
        contents.push({title:$.i18n.prop('goods_made_in') , value:'country'});
        selectItems['codeType_SELECT'] = contents;
        
     // 自动补全 种类
//         function getBigKind(){
        	$.ajax({
        	  	   type: "POST",
        	  	   async: false,
        	  	   data: {upCode:'0',codeType:'kind'},
        	  	   url: contextPath+"/Kind/getCodeList.do",
        	  	   success: function(data){
        	  			var arr = [];
        	  		    $.each(data, function (i, item) {  
        	  		 		if(item.codeName!=""){
        	  		 			contents1.push({title:item.codeName,value:item.code});
        	  		 		}
        	  	        });
        	  		  selectItems['code_SELECT'] = contents1;
        	  	   }
        	  	})
//         }
</script>
</body>
</html>
