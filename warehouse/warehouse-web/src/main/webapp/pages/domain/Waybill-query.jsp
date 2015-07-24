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
	        	         
	                	            	                	            	                	            	        	     
	    },
	    initGridPanel: function(){
	         var self = this;
	         var width = 120;
	         return grid.grid({
	                identity:"id",
	                buttons: [
							{content: '<button class="btn btn-info" type="button"><span class="glyphicon glyphicon-th-large"><span>'+$.i18n.prop('export.excel')+'</button>', action: 'exportExcel'},	                    
	                    ],
	                url:"${pageContext.request.contextPath}/WayBill/query.do",
	                columns: [
								{ title: $.i18n.prop('express.no'), name: 'waybillId', width: width},
								{ title: $.i18n.prop('customer.id'), name: 'billEur', width: width},
								{ title: $.i18n.prop('express.company'), name: 'wayBillCoo', width: width},
								{ title: $.i18n.prop('express.goods.addr'), name: 'wayBillFrom', width: width},
								{ title: $.i18n.prop('express.goods.url'), name: 'wayBillInternet', width: width},
								{ title: $.i18n.prop('YEN'), name: 'billJpy', width: 80},
								{ title: $.i18n.prop('RMB'), name: 'billCny', width: 80},
								{ title: $.i18n.prop('USD'), name: 'billUsd', width: 80},
								{ title: $.i18n.prop('express.arrived.time'), name: 'ArrivalTime', width: 80},
								{ title: $.i18n.prop('out.flag'), name: 'outFlag', width: width},	                          
	                          	
								{ title: $.i18n.prop('weight')+'(KG)', name: 'boxWeight', width: width},
                  	 			{ title: $.i18n.prop('length')+'(CM)', name: 'boxLength', width: width},
                  	 			{ title: $.i18n.prop('width')+'(CM)', name: 'boxWidth', width: width},
              	         	 	{ title: $.i18n.prop('height')+'(CM)', name: 'boxHeight', width: width},
              	       			{ title: $.i18n.prop('VOL_WT'), name: 'boxVolume', width: width},
	               	            
              	       		   { title: $.i18n.prop('goods_code'), name: 'goodsId', width: width+20},
    	                       { title: $.i18n.prop('goods_name'), name: 'goodsName', width: 80},
        	                   { title: $.i18n.prop('goods.std'), name: 'goodsType', width: 100},
        	                   { title: $.i18n.prop('goods_count'), name: 'goodsNum', width: 100},
        	                   { title: $.i18n.prop('YEN'), name: 'goodsJpy', width: 80},
        	                   { title: $.i18n.prop('RMB'), name: 'goodsCny', width: 80},
        	             	   { title: $.i18n.prop('USD'), name: 'goodsUsd', width: 80},
        	          		   { title: $.i18n.prop('EUR'), name: 'goodsEur', width: 80},
    	                       { title: $.i18n.prop('goods_kind'), name: 'bigType', width: width},
    	                       { title: $.i18n.prop('goods_class'), name: 'smallType', width: width},
        	                   { title: $.i18n.prop('goods_brand'), name: 'model', width: width},
        	                   { title: $.i18n.prop('goods_made_in'), name: 'country', width: width},
        	                   { title: $.i18n.prop('goods_material'), name: 'composition', width: width},
        	                   { title: $.i18n.prop('weight')+'(KG)', name: 'goodsWeight', width: width},
           	                   { title: $.i18n.prop('length')+'(CM)', name: 'goodsLength', width: width},
               	               { title: $.i18n.prop('width')+'(CM)', name: 'goodsWidth', width: width},
               	         	   { title: $.i18n.prop('height')+'(CM)', name: 'goodsHeight', width: width},
               	       		   { title: $.i18n.prop('VOL_WT'), name: 'goodsVolume', width: width},
	   	                   	   
               	       		   { title: $.i18n.prop('express.out.no'), name: 'outWayId', width: width},
              				   { title: $.i18n.prop('express.company'), name: 'outWayCoo', width: width},
              				   { title: $.i18n.prop('express.received.addr'), name: 'recieverAddr', width: 80},
              				   { title: $.i18n.prop('customer.name'), name: 'customerName', width: width},
       	             	       { title: $.i18n.prop('merge.flag'), name: 'mergeFlag', width: 80},
       	             		   { title: $.i18n.prop('weight')+'(KG)', name: 'outWeight', width: width},
          	 				   { title: $.i18n.prop('length')+'(CM)', name: 'outLength', width: width},
          	 				   { title: $.i18n.prop('width')+'(CM)', name: 'outWidth', width: width},
       	         	 		   { title: $.i18n.prop('height')+'(CM)', name: 'outHeight', width: width},
       	       				   { title: $.i18n.prop('VOL_WT'), name: 'outVolume', width: width}
	                	]
	        	 }).on({
	                   'exportExcel': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        var exportExcel = function(){
	                            self.exportExcel(indexs, $this);
	                        };
	                        $this.confirm({
	                            content: '确定要导出符合查询条件的记录吗（仅提供前5000条数据）?',
	                            callBack: exportExcel
	                        });
	                   }
	         });
	    },
	    exportExcel: function(form){
	    	location.href="${pageContext.request.contextPath}/BillGoods/exportExcel.do?waybillId="+$('#waybillIdID').val()
	    			+"&goodsId="+$('#goodsIdID').val()+"&goodsName="+$('#goodsNameID').val();  
            var params = {};
//             form.find('input').each(function(){
//                 var $this = $(this);
//                 var name = $this.attr('name');
//                 if(name){
//                     params[name] = $this.val();
//                 }
//             });
<%--             $.post('${pageContext.request.contextPath}/BillGoods/exportExcel.do', $('#<%=formId%>').serialize()).done(function(result){ --%>
//                 if(result.success ){
//                      dialog.modal('hide');
//                      e.data.grid.data('koala.grid').refresh();
//                      e.data.grid.message({
//                          type: 'success',
//                          content: $.i18n.prop('success')
//                       });
//                  }else{
//                      dialog.find('.modal-content').message({
//                          type: 'error',
//                          content: result.actionError
//                      });
//                   }
//            });
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
         <label class="control-label" style="width:100px;float:left;"><koala:i18n key="express.no"/>:&nbsp;</label>
         <div style="margin-left:15px;float:left;">
            <input name="waybillId" class="form-control" type="text" style="width:180px;" id="waybillIdID"  />
         </div>
         <label class="control-label" style="width:100px;float:left;"><koala:i18n key="goods_code"/>:&nbsp;</label>
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
