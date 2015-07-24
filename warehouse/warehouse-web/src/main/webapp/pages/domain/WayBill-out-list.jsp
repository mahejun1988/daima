<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>
<%@ taglib uri="http://www.openkoala.org/i18n" prefix="koala" %>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
	<div class="form-group">
        <label  class="col-lg-3 control-label"><koala:i18n key="express.no"/>:</label>
	    <div class="col-lg-9">
        	<input name="waybillId" readonly style="display:inline; width:94%;" class="form-control"  type="text"  id="waybillIdID3" />
		</div>
	</div>
	   	 <div class="form-group">
              <label class="col-lg-3 control-label"><koala:i18n key="express.company"/>:</label>
	          <div class="col-lg-9">
                   <input name="outWayCoo" style="display:inline; width:94%;" class="form-control"  type="text"  id="outWayCooID" />
			  </div>
		</div>
				<div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="express.out.no"/>:</label>
	                    <div class="col-lg-9">
                           <input name="outWayId" style="display:inline; width:94%;" class="form-control"  type="text"  id="outWayIdID" />
			    </div>
	</div>
		<div class=" form-group">
               <label class="col-lg-3 control-label"><koala:i18n key="express.received.addr"/>:</label>
	           <div class="col-lg-9">
                    <input name="reciever_Addr" style="display:inline; width:94%;" class="form-control"  type="text"  id="reciever_AddrID" />
			    </div>
		</div>
		<div class="form-group">
	         <label class="col-lg-3 control-label"><koala:i18n key="customer.name"/>:</label>
	         <div class="col-lg-9">
                   <input name="Customer_Name" style="display:inline; width:94%;" class="form-control"  type="text"  id="Customer_NameID" />
			 </div>
		</div>

<!-- 		            <div class="form-group"> -->
<!--                     <label class="col-lg-3 control-label">日元（JPY）:</label> -->
<!-- 	                    <div class="col-lg-9"> -->
<!--                            <input name="jpyPrice" style="display:inline; width:94%;" class="form-control"  type="text"  id="jpyPriceID" /> -->
<!-- 			    </div> -->
<!-- 	</div> -->
<!-- 		           <div class="form-group"> -->
<!--                     <label class="col-lg-3 control-label">人民币（CNY）:</label> -->
<!-- 	                    <div class="col-lg-9"> -->
<!--                            <input name="cnyPrice" style="display:inline; width:94%;" class="form-control"  type="text"  id="cnyPriceID" /> -->
<!-- 			    </div> -->
<!-- 	</div> -->
<!-- 		           <div class="form-group"> -->
<!--                     <label class="col-lg-3 control-label">美元（USD）:</label> -->
<!-- 	                    <div class="col-lg-9"> -->
<!--                            <input name="usdPrice" style="display:inline; width:94%;" class="form-control"  type="text"  id="usdPriceID" /> -->
<!-- 			    </div> -->
<!-- 	</div> -->
<!-- 		           <div class="form-group"> -->
<!--                     <label class="col-lg-3 control-label">欧元（EUR）:</label> -->
<!-- 	                    <div class="col-lg-9"> -->
<!--                            <input name="eurPrice" style="display:inline; width:94%;" class="form-control"  type="text"  id="eurPriceID" /> -->
<!-- 			    </div> -->
<!-- 	</div> -->
		<div class="form-group">
             <label class="col-lg-3 control-label"><koala:i18n key="merge.flag"/>:</label>
	         <div class="col-lg-3">
                  <div class="btn-group select" id="Merge_FlagID"></div>
	              <input type="hidden" id="Merge_FlagID_"  name="Merge_Flag" />
			 </div>
                    <label class="col-lg-3 control-label"><koala:i18n key="weight"/>(KG):</label>
	                    <div class="col-lg-3">
                           <input name="weight" style="display:inline; width:94%;" class="form-control"  type="text"  id="weightID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="length"/>(CM):</label>
	                    <div class="col-lg-3">
                           <input name="length" style="display:inline; width:94%;" onblur="getVolume();" class="form-control"  type="text"  id="lengthID" />
			    </div>
                    <label class="col-lg-3 control-label">箱<koala:i18n key="width"/>(CM):</label>
	                    <div class="col-lg-3">
                           <input name="width" style="display:inline; width:94%;" onblur="getVolume();" class="form-control"  type="text"  id="widthID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="height"/>(CM):</label>
	                    <div class="col-lg-3">
                           <input name="height" style="display:inline; width:94%;" onblur="getVolume();" class="form-control"  type="text"  id="heightID" />
			    </div>
                    <label class="col-lg-3 control-label"><koala:i18n key="VOL_WT"/>:</label>
	                    <div class="col-lg-3">
                           <input name="volume" style="display:inline; width:94%;"  class="form-control"  type="text"  id="volumeID" />
			    </div>
	</div>
		          
	</form>
<script type="text/javascript">
    var selectItems = {};
    var contents = [{title:'请选择', value: ''},{title:'是',value:'1'},{title:'否',value:'2'}];
	selectItems['Merge_FlagID'] = contents;
    function getVolume(){
    	if( $("#lengthID") == "" ||  $("#widthID") == "" ||  $("#heightID") == ""){
    		$("#volumeID").val("");
    	}else{
    		$("#volumeID").val(
    				($("#lengthID"). val() * $("#widthID").val() * $("#heightID").val() / 5000 ).toFixed(3)  
    		)
    	}
    	return;
    }
</script>
</body>
</html>