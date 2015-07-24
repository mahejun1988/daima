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
                    <label class="col-lg-3 control-label">出货单号:</label>
	                    <div class="col-lg-9">
                           <input name="outWayId" style="display:inline; width:94%;" class="form-control"  type="text"  id="outWayIdID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">物流公司:</label>
	                    <div class="col-lg-9">
                           <input name="outWayCoo" style="display:inline; width:94%;" class="form-control"  type="text"  id="outWayCooID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">箱子数量:</label>
	                    <div class="col-lg-9">
                           <input name="boxCount" style="display:inline; width:94%;" class="form-control"  type="text"  id="boxCountID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">日元（JPY）:</label>
	                    <div class="col-lg-9">
                           <input name="jpyPrice" style="display:inline; width:94%;" class="form-control"  type="text"  id="jpyPriceID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">人民币（CNY）:</label>
	                    <div class="col-lg-9">
                           <input name="cnyPrice" style="display:inline; width:94%;" class="form-control"  type="text"  id="cnyPriceID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">美元（USD）:</label>
	                    <div class="col-lg-9">
                           <input name="usdPrice" style="display:inline; width:94%;" class="form-control"  type="text"  id="usdPriceID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">欧元（EUR）:</label>
	                    <div class="col-lg-9">
                           <input name="eurPrice" style="display:inline; width:94%;" class="form-control"  type="text"  id="eurPriceID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">箱子重量:</label>
	                    <div class="col-lg-9">
                           <input name="weight" style="display:inline; width:94%;" class="form-control"  type="text"  id="weightID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">箱子长度:</label>
	                    <div class="col-lg-9">
                           <input name="length" style="display:inline; width:94%;" class="form-control"  type="text"  id="lengthID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">箱子宽度:</label>
	                    <div class="col-lg-9">
                           <input name="width" style="display:inline; width:94%;" class="form-control"  type="text"  id="widthID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">箱子高度:</label>
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
                    <label class="col-lg-3 control-label">提货仓库地址:</label>
	                    <div class="col-lg-9">
                           <input name="pickup_Addr" style="display:inline; width:94%;" class="form-control"  type="text"  id="pickup_AddrID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">收货地址:</label>
	                    <div class="col-lg-9">
                           <input name="reciever_Addr" style="display:inline; width:94%;" class="form-control"  type="text"  id="reciever_AddrID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">客户编码:</label>
	                    <div class="col-lg-9">
                           <input name="Customer_ID" style="display:inline; width:94%;" class="form-control"  type="text"  id="Customer_IDID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">客户姓名:</label>
	                    <div class="col-lg-9">
                           <input name="Customer_Name" style="display:inline; width:94%;" class="form-control"  type="text"  id="Customer_NameID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">是否合箱:</label>
	                    <div class="col-lg-9">
                           <div class="btn-group select" id="Merge_FlagID"></div>
	                       <input type="hidden" id="Merge_FlagID_"  name="Merge_Flag" />
			    </div>
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
                                                                                                                                                                                    var contents = [{title:'请选择', value: ''}];
        selectItems['Merge_FlagID'] = contents;
        </script>
</body>
</html>