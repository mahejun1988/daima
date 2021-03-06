<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>
<%@ taglib uri="http://www.openkoala.org/i18n" prefix="koala" %>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<% 
   String M = "zh_CN";
	if(request.getSession().getAttribute("locale") != null){
		M = (String)request.getSession().getAttribute("locale"); //从session里把a拿出来，并赋值给M  	
	}
%>
</head>
<body>
<form class="form-horizontal">
   	<div class="form-group upCodeName">
   					<label class="col-lg-2 control-label"><koala:i18n key="kind.parent.name"/>:</label>
	                <div class="col-lg-9">
                           <input name="upCodeName" readonly style="display:inline;"  class="form-control" id="upCodeNameID" />
                           <input name="upCode"type="hidden" readonly style="display:inline;"  class="form-control" id="upCodeID" />
					</div>
	</div>
	<div class="form-group codeTypeSelect">
			    	<label class="col-lg-2 control-label"><koala:i18n key="kind.sub.code"/>:</label>
				    <div class="col-lg-4">
			        	<div class="btn-group select" id="codeTypeID" ></div>
				        <input type="hidden" id="codeTypeID_"  name="codeType" />
				        <input type="hidden" id="codeTypeID_name"  name="typeName" />
					</div>
	</div>
	<div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="kind.sub.name"/>:</label>
	                <div class="col-lg-9">
                           <input name="codeName" style="display:inline; width:94%;" class="form-control"  type="text" dataType="Require" id="codeNameID" />
							<span class="required">*</span>	    
					</div>
	</div>
	<div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="mark"/>:</label>
	                <div class="col-lg-9">
                           <input name="remark" style="display:inline; width:94%;" class="form-control"  type="text"  id="remarkID" />
			        </div>
	</div>
		        
	</form>
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
        contents.push({title:$.i18n.prop('express.company') , value:'express'});
        contents.push({title:$.i18n.prop('goods_kind') , value:'kind'});
        contents.push({title:$.i18n.prop('goods_made_in') , value:'country'});
        selectItems['codeTypeID'] = contents;
    var contents1 = [{title:$.i18n.prop('choose'), value: ''}];
        selectItems['codeID'] = contents1;
</script>
</body>
</html>