<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>
<%@ taglib uri="http://www.openkoala.org/i18n" prefix="koala" %>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="<c:url value='/js/jquery.form.js' />"></script>
</head>
<body>
<form class="form-horizontal" id="submit2" enctype="multipart/form-data">
	<input type="hidden" id="idID" name="id" /> 
	<input type="hidden" id="versionID" name="version" /> 
	<input type="hidden" id="goodsIdID" name="goodsId" />
	<input type="hidden" id="createTimeID"  name="createTime" />
	<input type="hidden" id="createUserID"  name="createUser" />
	           <div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="goods_name"/>:</label>
	                    <div class="col-lg-9">
                           <input name="goodsName" style="display:inline; width:94%;" class="form-control"  type="text" dataType="Require" id="goodsNameID" />
		<span class="required">*</span>	    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="goods.std"/>:</label>
	                    <div class="col-lg-9">
                           <input name="goodsType" style="display:inline; width:94%;" class="form-control"  type="text"  id="goodsTypeID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="YEN"/>:</label>
	                    <div class="col-lg-3">
                           <input name="jpyPrice" style="display:inline; width:94%;" class="form-control"  type="text"  id="jpyPriceID" />
			    </div>
                    <label class="col-lg-2 control-label"><koala:i18n key="RMB"/>:</label>
	                    <div class="col-lg-3">
                           <input name="cnyPrice" style="display:inline; width:94%;" class="form-control"  type="text"  id="cnyPriceID" />
			    </div>
	</div>
	                <div class="form-group">
                	<label class="col-lg-2 control-label"><koala:i18n key="goods_count"/>:</label>
	                <div class="col-lg-3">
	               		   <input name="goodsNum" style="display:inline; width:94%;" dataType="Require" class="form-control"  type="text"  id="goodsNumID" />
							<span class="required">*</span>	
					</div>
				</div>
		           <div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="USD"/>:</label>
	                    <div class="col-lg-3">
                           <input name="usdPrice" style="display:inline; width:94%;" class="form-control"  type="text"  id="usdPriceID" />
			    </div>
                    <label class="col-lg-2 control-label"><koala:i18n key="EUR"/>:</label>
	                    <div class="col-lg-3">
                           <input name="eurPrice" style="display:inline; width:94%;" class="form-control"  type="text"  id="eurPriceID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="weight"/>(KG):</label>
	                    <div class="col-lg-3">
                           <input name="weight" style="display:inline; width:94%;" class="form-control"  type="text"  dataType="Number" require="false" id="weightID" />
			    </div>
                    <label class="col-lg-2 control-label"><koala:i18n key="length"/>(CM):</label>
	                    <div class="col-lg-3">
                           <input name="length" style="display:inline; width:94%;" class="form-control vm"  type="text"  dataType="Number" require="false" id="lengthID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="width"/>(CM):</label>
	                    <div class="col-lg-3">
                           <input name="width" style="display:inline; width:94%;" class="form-control vm"  type="text"  dataType="Number" require="false" id="widthID" />
			    </div>
                    <label class="col-lg-2 control-label"><koala:i18n key="height"/>(CM):</label>
	                    <div class="col-lg-3">
                           <input name="height" style="display:inline; width:94%;" class="form-control vm"  type="text"  dataType="Number" require="false" id="heightID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="VOL_WT"/>:</label>
	                    <div class="col-lg-3">
                           <input name="volume" style="display:inline; width:94%;" class="form-control"  type="text"  dataType="Number" require="false" id="volumeID" />
			    </div>
	</div>
<!-- 		           <div class="form-group"> -->
<!--                     <label class="col-lg-2 control-label">图片:</label> -->
<!-- 	                    <div class="col-lg-9"> -->
<!--                            <input name="image" style="display:inline; width:94%;" class="form-control"  type="text"  id="imageID" /> -->
<!-- 			    </div> -->
<!-- 	</div> -->
			<div class="form-group">
                    <label class="col-lg-2 control-label"><koala:i18n key="PIC"/>:</label>
	                    <div class="col-lg-4">
<!-- 	                       <input type="file" onchange="upload($(this))" id="imageID" name="image"></input> -->
						   <input type="file"  onchange="upload($(this),this)"  name="file"></input>
						<!--<input name="image" style="display:inline;" class="form-control"  type="text"  id="imageID" /> -->
								<img class="img-thumbnail image" src=""/>
								<input type="hidden"  id="imageID" name="image">
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
                           <textarea class="form-control" style="display:inline; width:94%;" rows="1" id="modelID" name="model"  ></textarea>
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
                    <textarea class="form-control" style="display:inline; width:94%;" rows="3" id="compositionID" name="composition"  ></textarea>
			    </div>
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
        var contents = [{title:$.i18n.prop('choose'), value: ''}];
        selectItems['bigTypeID'] = contents;
                var contents = [{title:$.i18n.prop('choose'), value: ''}];
        selectItems['modelID'] = contents;
                var contents = [{title:$.i18n.prop('choose'), value: ''}];
        selectItems['smallTypeID'] = contents;
                var contents = [{title:$.i18n.prop('choose'), value: ''}];
        selectItems['countryID'] = contents;
        
//         function upload(obj){
// 			var form = obj.parent();
// 			var $this = $(this);
// 			$("#submit2").ajaxSubmit({
// 				type: "POST",
// 				url:contextPath+"/WayBill/upload.do",
// 				success: function(data){
// 					obj.next().attr("src",contextPath+""+data);
// 					obj.parent().find("[name='image']").val(contextPath+""+data);
// 				},
// 				error:function(e){
// 					$this.message({
// 						type : 'warning',
// 						content : $.i18n.prop('error')
// 					});
// 				}
// 			});
//      	}
	
		function upload(obj,file){
		 if (file.files && file.files[0]) {
			 var reader = new FileReader();
			 reader.onload = function(evt){
				 obj.next().attr("src",evt.target.result);
			 }
			 reader.readAsDataURL(file.files[0]);
		 }
	
};	
</script>
</body>
</html>