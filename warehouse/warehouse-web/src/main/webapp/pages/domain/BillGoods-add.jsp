<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
	
	           <div class="form-group">
                    <label class="col-lg-3 control-label">创建时间:</label>
	                 <div class="col-lg-9">
                    <div class="input-group date form_datetime" style="width:160px;float:left;" >
                        <input type="text" class="form-control" style="width:160px;" name="createTime" id="createTimeID" >
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                     </div>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">创建人:</label>
	                    <div class="col-lg-9">
                           <input name="createUser" style="display:inline; width:94%;" class="form-control"  type="text"  id="createUserID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">更新时间:</label>
	                 <div class="col-lg-9">
                    <div class="input-group date form_datetime" style="width:160px;float:left;" >
                        <input type="text" class="form-control" style="width:160px;" name="updateTime" id="updateTimeID" >
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                     </div>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">更新人:</label>
	                    <div class="col-lg-9">
                           <input name="updateUser" style="display:inline; width:94%;" class="form-control"  type="text"  id="updateUserID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">运单号:</label>
	                    <div class="col-lg-9">
                           <input name="waybillId" style="display:inline; width:94%;" class="form-control"  type="text"  id="waybillIdID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">箱子号:</label>
	                    <div class="col-lg-9">
                           <input name="boxId" style="display:inline; width:94%;" class="form-control"  type="text"  id="boxIdID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">条形码:</label>
	                    <div class="col-lg-9">
                           <input name="goodsId" style="display:inline; width:94%;" class="form-control"  type="text"  id="goodsIdID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">名称:</label>
	                    <div class="col-lg-9">
                           <input name="goodsName" style="display:inline; width:94%;" class="form-control"  type="text"  id="goodsNameID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">规格:</label>
	                    <div class="col-lg-9">
                           <input name="goodsType" style="display:inline; width:94%;" class="form-control"  type="text"  id="goodsTypeID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">数量:</label>
	                    <div class="col-lg-9">
                           <input name="goodsNum" style="display:inline; width:94%;" class="form-control"  type="text"  id="goodsNumID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">日元:</label>
	                    <div class="col-lg-9">
                           <input name="jpyPrice" style="display:inline; width:94%;" class="form-control"  type="text"  id="jpyPriceID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">人民币:</label>
	                    <div class="col-lg-9">
                           <input name="cnyPrice" style="display:inline; width:94%;" class="form-control"  type="text"  id="cnyPriceID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">美元:</label>
	                    <div class="col-lg-9">
                           <input name="usdPrice" style="display:inline; width:94%;" class="form-control"  type="text"  id="usdPriceID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">欧元:</label>
	                    <div class="col-lg-9">
                           <input name="eurPrice" style="display:inline; width:94%;" class="form-control"  type="text"  id="eurPriceID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">种类:</label>
	                    <div class="col-lg-9">
                           <input name="bigType" style="display:inline; width:94%;" class="form-control"  type="text"  id="bigTypeID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">细类:</label>
	                    <div class="col-lg-9">
                           <input name="smallType" style="display:inline; width:94%;" class="form-control"  type="text"  id="smallTypeID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">品牌:</label>
	                    <div class="col-lg-9">
                           <input name="model" style="display:inline; width:94%;" class="form-control"  type="text"  id="modelID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">原产国:</label>
	                    <div class="col-lg-9">
                           <input name="country" style="display:inline; width:94%;" class="form-control"  type="text"  id="countryID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">成分:</label>
	                    <div class="col-lg-9">
                           <input name="composition" style="display:inline; width:94%;" class="form-control"  type="text"  id="compositionID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">重量:</label>
	                    <div class="col-lg-9">
                           <input name="weight" style="display:inline; width:94%;" class="form-control"  type="text"  id="weightID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">长:</label>
	                    <div class="col-lg-9">
                           <input name="length" style="display:inline; width:94%;" class="form-control"  type="text"  id="lengthID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">宽:</label>
	                    <div class="col-lg-9">
                           <input name="width" style="display:inline; width:94%;" class="form-control"  type="text"  id="widthID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">高:</label>
	                    <div class="col-lg-9">
                           <input name="height" style="display:inline; width:94%;" class="form-control"  type="text"  id="heightID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">体积重:</label>
	                    <div class="col-lg-9">
                           <input name="volume" style="display:inline; width:94%;" class="form-control"  type="text"  id="volumeID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">图片:</label>
	                    <div class="col-lg-9">
                           <input name="image" style="display:inline; width:94%;" class="form-control"  type="text"  id="imageID" />
			    </div>
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
                                                                                                                                                                                                            </script>
</body>
</html>