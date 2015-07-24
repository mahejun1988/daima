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
<script type="text/javascript" src="<c:url value='/js/jquery.form.js' />"></script>
</head>
<body>
<form class="form-horizontal" id="submit" enctype="multipart/form-data">
	
		<div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="goods_code"/>:</label>
	                <div class="col-lg-9">
                           <input name="goodsId" style="display:inline;" class="form-control"  type="text" dataType="Require" id="goodsIdID" />
							<span class="required">*</span>	    
					</div>
	</div>
	
	<div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="goods_name"/>:</label>
	                <div class="col-lg-9">
						   <textarea name="goodsName" style="display:inline;" class="form-control" dataType="Require" id="goodsNameID" rows="1" cols="22"></textarea>
						   <span class="required">*</span>	    
					</div>
	</div>
	<div class="form-group">
					<label class="col-lg-2 control-label"><koala:i18n key="goods.std"/>:</label>
	                    <div class="col-lg-9">
                           <input name="goodsType" style="display:inline;" class="form-control"  type="text"  id="goodsTypeID" />
			    	</div>
		</div>

	<div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="YEN"/>:</label>
	                    <div class="col-lg-3">
                           <input name="jpyPrice" style="display:inline;" class="form-control"  type="text"  id="jpyPriceID" />
			    </div>
                    <label class="col-lg-2 control-label"><koala:i18n key="RMB"/>:</label>
	                    <div class="col-lg-3">
                           <input name="cnyPrice" style="display:inline;" class="form-control"  type="text"  id="cnyPriceID" />
			    </div>
	</div>
	<div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="USD"/>:</label>
	                    <div class="col-lg-3">
                           <input name="usdPrice" style="display:inline;" class="form-control"  type="text"  id="usdPriceID" />
			    </div>
                    <label class="col-lg-2 control-label"><koala:i18n key="EUR"/>:</label>
	                    <div class="col-lg-3">
                           <input name="eurPrice" style="display:inline;" class="form-control"  type="text"  id="eurPriceID" />
			    </div>
	</div>
		<div class="form-group">
			    	 <label class="col-lg-2 control-label"><koala:i18n key="goods_count"/>:</label>
	                <div class="col-lg-3">
                           <input name="goodsNum" style="display:inline;" class="form-control"  type="text" dataType="Require" id="goodsNumID" />
							<span class="required">*</span>	    
					</div>
                    <label class="col-lg-2 control-label"><koala:i18n key="weight"/>(KG):</label>
	                    <div class="col-lg-3">
                           <input name="weight" style="display:inline;" class="form-control"  type="text"  id="weightID" />
			    </div>
	</div>
	<div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="length"/>(CM):</label>
	                    <div class="col-lg-3">
                           <input name="length" style="display:inline;" class="form-control vm"  type="text"  dataType="Number" require="false" id="lengthID" />
			    </div>
                    <label class="col-lg-2 control-label"><koala:i18n key="width"/>(CM):</label>
	                    <div class="col-lg-3">
                           <input name="width" style="display:inline;" class="form-control vm"  type="text"  dataType="Number" require="false" id="widthID" />
			    </div>
	</div>
	<div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="height"/>(CM):</label>
	                    <div class="col-lg-3">
                           <input name="height" style="display:inline;" class="form-control vm"  type="text"  dataType="Number" require="false" id="heightID" />
			    </div>
				<label class="col-lg-2 control-label"><koala:i18n key="VOL_WT"/>:</label>
	                    <div class="col-lg-3">
                           <input name="volume" style="display:inline;" class="form-control"  type="text"  dataType="Number" require="false" id="volumeID" />
			    </div>
	</div>
	<div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="PIC"/>:</label>
	                    <div class="col-lg-4">
<!-- 	                       <input type="file" onchange="upload($(this))" id="imageID" name="image"></input> -->
						   <input type="file"  onchange="upload($(this),this)"  name="file"></input>
						<!--<input name="image" style="display:inline;" class="form-control"  type="text"  id="imageID" /> -->
								<img class="img-thumbnail image" src=""/>
								<input type="hidden"  id="goodsimage" name="image">
			    </div>
	</div>
	<div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="goods_kind"/>:</label>
	                    <div class="col-lg-3">
                           <div class="btn-group select" id="bigTypeID"></div>
	                       <input type="hidden" id="bigTypeID_"  name="bigType" />
			    </div>
                    <label class="col-lg-2 control-label"><koala:i18n key="goods_class"/>:</label>
	                    <div class="col-lg-3">
                           <div class="btn-group select" id="smallTypeID"></div>
	                       <input type="hidden" id="smallTypeID_"  name="smallType" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="goods_brand"/>:</label>
	                    <div class="col-lg-3">
                           <input name="model" style="display:inline;" class="form-control"  type="text"  id="modelID" />
			    </div>

                    <label class="col-lg-2 control-label"><koala:i18n key="goods_made_in"/>:</label>
	                    <div class="col-lg-3">
                           <div class="btn-group select" id="countryID"></div>
	                       <input type="hidden" id="countryID_"  name="country" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="goods_material"/>:</label>
	                <div class="col-lg-9">
                    <textarea class="form-control" style="display:inline;width:94%" rows="3" id="compositionID" name="composition"  ></textarea>
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
    	var contents2 = [{title:$.i18n.prop('choose'), value: ''}];
        selectItems['smallTypeID'] = contents2;
        var contents4 = [{title:$.i18n.prop('choose'), value: ''}];
        selectItems['countryID'] = contents4;
       
		function upload(obj,file){
			 if (file.files && file.files[0]) {
				 var reader = new FileReader();
				 reader.onload = function(evt){
					 obj.next().attr("src",evt.target.result);
				 }
				 reader.readAsDataURL(file.files[0]);
			 }
		}
     </script>
</body>
</html>