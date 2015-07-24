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
	        	            			var contents = [{title:$.i18n.prop('choose'), value: ''}];
	                     	            form.find('#smallType_SELECT').select({
	                                          title: $.i18n.prop('choose'),
	                                          contents: contents
	                                    }).on('change',function(){
	                                          form.find('#smallTypeID_').val($(this).getValue());
	                                    });
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
	                	            	        var contents = [{title:$.i18n.prop('choose'), value: ''}];
	                     	                    form.find('#model_SELECT').select({
	                                            title: $.i18n.prop('choose'),
	                                            contents: contents
	                                       }).on('change',function(){
	                                           form.find('#modelID_').val($(this).getValue());
	                                       });
	                	            	       var contents = [{title:$.i18n.prop('choose'), value: ''}];
	                     	                     form.find('#country_SELECT').select({
	                                            title: $.i18n.prop('choose'),
	                                            contents: contents
	                                       }).on('change',function(){
	                                           form.find('#countryID_').val($(this).getValue());
	                                       });
	                	            	        var contents = [{title:$.i18n.prop('choose'), value: ''}];
	                     	                    form.find('#bigType_SELECT').select({
	                                            title: $.i18n.prop('choose'),
	                                            contents: contents
	                                       }).on('change',function(){
	                                           form.find('#bigTypeID_').val($(this).getValue());
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
	                url:"${pageContext.request.contextPath}/Goods/pageJson.do",
	                columns: [
							   
							   { title: $.i18n.prop('goods_code'), name: 'goodsId', width: 120},
							   { title: $.i18n.prop('goods_name'), name: 'goodsName', width: width},
							   { title: $.i18n.prop('goods.std'), name: 'goodsType', width: 160},
							   { title: $.i18n.prop('YEN'), name: 'jpyPrice', width: 60},
							   { title: $.i18n.prop('RMB'), name: 'cnyPrice', width: 60},
							   { title: $.i18n.prop('USD'), name: 'usdPrice', width: 60},
							   { title: $.i18n.prop('EUR'), name: 'eurPrice', width: 60},
							   { title: $.i18n.prop('goods_kind'), name: 'bigType', width: 120},
							   { title: $.i18n.prop('goods_class'), name: 'smallType', width: 140},
							   { title: $.i18n.prop('goods_brand'), name: 'model', width: 120},
							   { title: $.i18n.prop('goods_made_in'), name: 'country', width: 60},
							   { title: $.i18n.prop('insert.time'), name: 'createTime', width: 100},
							   { title: $.i18n.prop('operate'), width: 60, render: function (rowdata, name, index){
	                                     var param = '"' + rowdata.id + '"';
	                                     var h = "<a href='javascript:openDetailsPage(" + param + ")'>"+$.i18n.prop('detail')+"</a> ";
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
	                                   content: $.i18n.prop('delete.rows')
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
	                   }
	         });
	    },
	    add: function(grid){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog modal-lg">'
	        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
	        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
	        	+'<h4 class="modal-title">'+$.i18n.prop('insert')+'</h4></div><div class="modal-body">'
	        	+'<p>One fine body&hellip;</p></div><div class="modal-footer">'
	        	+'<button type="button" class="btn btn-default" data-dismiss="modal">'+$.i18n.prop('cancel')+'</button>'
	        	+'<button type="button" class="btn btn-success" id="save">'+$.i18n.prop('confirm')+'</button></div></div>'
	        	+'</div></div>');
	        $.get('<%=path%>/Goods-add.jsp').done(function(html){
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
// 	              var dataArr = [];
// 	              var param = {};
// 	              param.height = "333";
// 	              dataArr.push(param);
// 	              var dataArrJson = JSON.stringify(param);
// 	              $.ajax({
// 	            	   type: "POST",
// 	            	   url: "${pageContext.request.contextPath}/Goods/add.do",
// 	            	   data: {formData:dataArrJson},
// 	            	   success: function(resultdata){}
// 	              });
// 	              $.post('${pageContext.request.contextPath}/Goods/add.do', dialog.find('form').serialize()).done(function(result){
// 	                   if(result.success ){
// 	                        dialog.modal('hide');
// 	                        e.data.grid.data('koala.grid').refresh();
// 	                        e.data.grid.message({
// 	                            type: 'success',
// 	                            content: $.i18n.prop('success')
// 	                         });
// 	                    }else{
// 	                        dialog.find('.modal-content').message({
// 	                            type: 'error',
// 	                            content: result.actionError
// 	                        });
// 	                     }
// 	              });
	              
	              $("#submit").ajaxSubmit({
       				type: "POST",
       				url:contextPath+"/Goods/add.do",
       				data:dialog.find('form').serialize(),
       				success: function(result){
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
       				},
       				error:function(e){
       					dialog.find('.modal-content').message({
       						type : 'warning',
       						content : $.i18n.prop('error')
       					});
       				}
       			});
	              
	        });
	    },
	    modify: function(id, grid){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog modal-lg"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">'+$.i18n.prop('modify')+'</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">'+$.i18n.prop('cancel')+'</button><button type="button" class="btn btn-success" id="save">'+$.i18n.prop('confirm')+'</button></div></div></div></div>');
	        $.get('<%=path%>/Goods-update.jsp').done(function(html){
	               dialog.find('.modal-body').html(html);
	               self.initPage(dialog.find('form'));
	               $.get( '${pageContext.request.contextPath}/Goods/get/' + id + '.do').done(function(json){
	                       json = json.data;
// 	                       alert(JSON.stringify(json));
	                       dialog.find('#bigTypeID').setValue(json.bigtypeID);
	                       dialog.find('#smallTypeID').setValue(json.smallTypeID);
	                       dialog.find('#countryID').setValue(json.countryID);
	                       dialog.find('img').attr('src',json.image);
// 	                       dialog.find('#imageID').attr('src',json.image);
	                        var elm;
// 	                        alert(JSON.stringify(json));
	                        for(var index in json){
	                            elm = dialog.find('#'+ index + 'ID');
	                            if(elm.hasClass('select')){
// 	                                elm.setValue(json[index]);
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
	         			$("#submit2").ajaxSubmit({
	         				type: "POST",
	         				url:contextPath+"/Goods/update.do?id="+id,
	         				data:dialog.find('form').serialize(),
	         				success: function(result){
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
	         				},
	         				error:function(e){
	         					dialog.find('.modal-content').message({
	         						type : 'warning',
	         						content : $.i18n.prop('error')
	         					});
	         				}
	         			});
// 	                    $.post('${pageContext.request.contextPath}/Goods/update.do?id='+id, dialog.find('form').serialize()).done(function(result){
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
	                var contents1 = [{title:$.i18n.prop('choose'), value: '-1'}];
		        	var contents2 = [{title:$.i18n.prop('choose'), value: ''}];
		        	var contents3 = [{title:$.i18n.prop('choose'), value: ''}];
	            	$.ajax({
	          	  	   type: "POST",
	          	  	   async: false,
	          	  	   data: {upCode:'0',codeType:'kind'},
	          	  	   url: "${pageContext.request.contextPath}/Kind/getCodeList.do",
	          	  	   success: function(data){
	          	  		   $.each(data, function (i, item) {  
	          	  	           var param = {};
	          	       		   param.title = item.codeName;
	          	       		   param.value = item.code;
	          	       		   contents1.push(param);
	          	  	        });
	          	  	   }
	          	  	})
	          	  	
	          	  	$.ajax({
	          	  	   type: "POST",
	          	  	   async: false,
	          	  	   data: {upCode:'0',codeType:'country'},
	          	  	   url: "${pageContext.request.contextPath}/Kind/getCodeList.do",
	          	  	   success: function(data){
	          	  		   $.each(data, function (i, item) {  
	          	  	           var param = {};
	          	       		   param.title = item.codeName;
	          	       		   param.value = item.code;
	          	       		   contents3.push(param);
	          	  	        });
	          	  	   }
	          	  	})
	          	  
	          	  	form.find("#bigTypeID").select({
                       title: $.i18n.prop('choose'),
                       contents: contents1
                   }).on('change', function(){
                	   form.find('#bigTypeID_').val($(this).getValue());
                	   contents2 = [{title:$.i18n.prop('choose'), value: ''}];
                	   $.ajax({
    	          	  	   type: "POST",
    	          	  	   async: false,
    	          	  	   data: {upCode:$(this).getValue(),codeType:'kind'},
    	          	  	   url: "${pageContext.request.contextPath}/Kind/getCodeList.do",
    	          	  	   success: function(data){
    	          	  		   $.each(data, function (i, item) {  
    	          	  	           var param = {};
    	          	       		   param.title = item.codeName;
    	          	       		   param.value = item.code;
    	          	       		   contents2.push(param);
    	          	  	        });
    	          	  		form.find("#smallTypeID").select({
    	                        title: $.i18n.prop('choose'),
    	                        contents: contents2
    	                    }).on('change', function(){
    	                 	   form.find('#smallTypeID_').val($(this).getValue());
    	                    })
    	          	  	   }
    	          	  	})
                   });
	            	
// 	            	if(form.find("#bigTypeID") != null){
	            	   contents2 = [{title:$.i18n.prop('choose'), value: ''}];
                	   $.ajax({
    	          	  	   type: "POST",
    	          	  	   async: false,
    	          	  	   data: {upCode:$(this).getValue(),codeType:'kind'},
    	          	  	   url: "${pageContext.request.contextPath}/Kind/getCodeList.do",
    	          	  	   success: function(data){
    	          	  		   $.each(data, function (i, item) {  
    	          	  	           var param = {};
    	          	       		   param.title = item.codeName;
    	          	       		   param.value = item.code;
    	          	       		   contents2.push(param);
    	          	  	        });
    	          	  		form.find("#smallTypeID").select({
    	                        title:$.i18n.prop('choose'),
    	                        contents: contents2
    	                    }).on('change', function(){
    	                 	   form.find('#smallTypeID_').val($(this).getValue());
    	                    })
    	          	  	   }
    	          	  	})	
// 	            	}
	            	
                   form.find("#countryID").select({
                       title: $.i18n.prop('choose'),
                       contents: contents3
                   }).on('change', function(){
                	   form.find('#countryID_').val($(this).getValue());
                   })
       			// 自动计算体积重
       			form.find(".vm").blur(function(){
       					// alert($(this).parent().parent().find('.length').val());
       					var length = form.find('input[name=length]').val();
       					var width = form.find('input[name=width]').val();
       					var height = form.find('input[name=height]').val();
       					
       					if(length != null && length != "" && width != null && width != "" && height != null && height != ""){
       						form.find('input[name=volume]').val((length*width*height/5000).toFixed(3));
       					}else{
       						form.find('input[name=volume]').val("");
       					}
       				
       			});
	               
	    },
	    remove: function(ids, grid){
	    	var data = [{ name: 'ids', value: ids.join(',') }];
	    	$.post('${pageContext.request.contextPath}/Goods/delete.do', data).done(function(result){
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
        var dialog = $('<div class="modal fade"><div class="modal-dialog  modal-lg"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">'+$.i18n.prop('detail')+'</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-info" data-dismiss="modal">'+$.i18n.prop('cancel')+'</button></div></div></div></div>');
        $.get('<%=path%>/Goods-view.jsp').done(function(html){
               dialog.find('.modal-body').html(html);
               $.get( '${pageContext.request.contextPath}/Goods/get/' + id + '.do').done(function(json){
                       json = json.data;
                        var elm;
                        for(var index in json){
                        if(json[index]+"" == "false"){
                        		dialog.find('#'+ index + 'ID').html("<span style='color:#d2322d' class='glyphicon glyphicon-remove'></span>");
                        	}else if(json[index]+"" == "true"){
                        		dialog.find('#'+ index + 'ID').html("<span style='color:#47a447' class='glyphicon glyphicon-ok'></span>");
                        	}else{
                        		 if(index=='image'){
                        			 dialog.find('#'+ index + 'ID').attr('src',json[index]+"");
                        		 }else{
                          		 	dialog.find('#'+ index + 'ID').html(json[index]+"");
                        		 }
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
          <label class="control-label" style="width:130px;float:left;"><koala:i18n key="goods_code"/>:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="goodsId" class="form-control" type="text" style="width:180px;" id="goodsIdID"  />
        </div>
        <label class="control-label" style="width:100px;float:left;"><koala:i18n key="goods_name"/>:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="goodsName" class="form-control" type="text" style="width:180px;" id="goodsNameID"  />
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
