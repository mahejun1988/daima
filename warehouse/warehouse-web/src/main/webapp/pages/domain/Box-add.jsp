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
                    <label class="col-lg-3 control-label">箱子序号:</label>
	                    <div class="col-lg-9">
                           <input name="boxId" style="display:inline; width:94%;" class="form-control"  type="text"  id="boxIdID" />
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
                           <input name="lenght" style="display:inline; width:94%;" class="form-control"  type="text"  id="lenghtID" />
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
                    <label class="col-lg-3 control-label">商品数量:</label>
	                    <div class="col-lg-9">
                           <input name="goodsNum" style="display:inline; width:94%;" class="form-control"  type="text"  id="goodsNumID" />
			    </div>
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
                                                                                                    </script>
</body>
</html>