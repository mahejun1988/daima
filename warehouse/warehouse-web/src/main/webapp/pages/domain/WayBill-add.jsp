<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>
<%@ taglib uri="http://www.openkoala.org/i18n" prefix="koala" %>
<%
	String M = "zh_CN";
	if(request.getSession().getAttribute("locale") != null){
		M = (String)request.getSession().getAttribute("locale"); //从session里把a拿出来，并赋值给M  	
	}
%>  
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.openkoala.org/i18n" prefix="koala" %> 
 <script type="text/javascript" src="<c:url value='js/jquery.i18n.properties-1.0.9.js' />"> </script>
<%-- <link rel="stylesheet" href="${contextPath}/css/bootstrap.min.css" /> --%>
<%-- <script type="text/javascript" src="${contextPath}/js/jquery.js"></script> --%>
<!-- <script src="/js/jquery.typeahead.js"></script> -->
<script type="text/javascript" src="<c:url value='/js/jquery.typeahead.js' />"></script>
<!-- <script src="/js/jquery.form.js"></script> -->
<script type="text/javascript" src="<c:url value='/js/jquery.form.js' />"></script>
<!-- <script src="/js/jquery.validate.js"></script> -->
<script type="text/javascript" src="<c:url value='/js/jquery.validate.js' />"></script>
<%-- <script src="${contextPath}/js/bootstrap.min.js"></script> --%>
<!-- <script src="/js/bootstrapValidator.js"></script> -->
<script type="text/javascript" src="<c:url value='/js/bootstrapValidator.js' />"></script>
<!-- <script src="/js/warehouse/waybill-add.js"></script> -->
<script type="text/javascript" src="<c:url value='/js/warehouse/waybill-add.js' />"></script>
<style>
.section{
	padding:10px;	
}
.form-inline{
	padding-bottom:18px;	
}
.form-group{
	padding-right:20px;	
}
label{
	padding-right:7px;
	width:80px;
	text-align:right;
	font-weight:500;
}
/* body{ */
/* 	background:-webkit-gradient(linear, 0 0, 0 100%, from(#75C0ED), to(#C5F9D3)); */
/* } */
article h2{
	-webkit-text-stroke-width:1px;
	-webkit-text-stroke-color:#123456;
	padding:20px;
	
}
.jpy{
	color:#fff;
	background:#C6BBE5;	
}
.cny{
	color:#E01111;
	background:#8789E0;	
}
.usd{
	color:#513ECA;
	background:#E5C9BB;	
}
.eur{
	color:#D222D7;
	background:#1EE8E1;	
}
.xiangzi{
	border-radius:10px;
	background:-webkit-gradient(linear, 0 0, 0 100%, from(#EBF0BB), to(#E4D172));
}
.shangpin{
	border-radius:10px;
	background:-webkit-gradient(linear, 0 0, 0 100%, from(#A0E285), to(#DBEAE6));
}
input[type=file]{
	display:inline-block;
	width:auto;
}
.num{
	text-align:right;	
}
.image{
	max-width:130px;
	max-height:130px;
	height:auto;
	width:auto;
	display:inline-block;
}
.right{
	right:-20px;
	left:initial;
	max-height:500px;
	overflow-y:auto;
	padding-right:20px;
}

				.box{
					width:80px;
					text-align:center;
					border-radius:6px;
					min-height:40px;
				}
				.box-1{	
					border:1px solid #75C0ED;
					background:#75C0ED;	
				}
				.box-2{	
					border:1px solid #75C0ED;
					background:#EBF0BB;	
				}
				.box-3{	
					
				}
				.box-4{
					border:1px solid #EBF0BB;
					background:#A0E285;	
				}
				.right span{
					text-align:center;
					display:inline-block;
					padding-top:10px;
				}
			
</style>
</head>
<body class="waybill">
	<section class="section" id="wayBillcontent">
			<form id="wayBillsubmit" enctype="multipart/form-data" >
			<article class="yundan" id="yd-1">
				<h2><koala:i18n key="express.info"/></h2>
				
				<div class="form-inline">
					<div class="form-group">
				  		<label><koala:i18n key="customer.id"/><span class="required">*</span></label><input dataType="Require" name="yd_eur"   type="text" class="form-control num"></input>
				 	</div>
					<div class="form-group">
				  		<label><koala:i18n key="express.no"/><span class="required">*</span></label><input dataType="Require" name="yd_id"   type="text" id="yundanCode" class="form-control num"></input>
				 	</div>
				  <div class="form-group">
				  	<label><koala:i18n key="express.company"/><span class="required">*</span></label><input dataType="Require" type="text" name="yd_coo" required data-provide="typeahead" id="coo" data-source='["Deluxe Bicycle","123123123", "Super Deluxe Trampoline", "Super Duper Scooter"]' class="form-control"></input>
				  </div>
				  <div class="form-group">
				  	<label><koala:i18n key="express.arrived.time"/><span class="required">*</span></label><input id="today" dataType="Require"  name="yd_time"  type="text" class="form-control"></input>
				  </div>
			  </div>
			  <div class="form-inline">
					<div class="form-group">
				  	<label><koala:i18n key="YEN"/></label><input type="text"  name="yd_jpy" class="form-control num jpy"></input>
				  </div>
				  <div class="form-group">
				  	<label><koala:i18n key="RMB"/></label><input type="text"  name="yd_cny" class="form-control num cny"></input>
				  </div>
				  <div class="form-group">
				  	<label><koala:i18n key="USD"/></label><input type="text" name="yd_usd" class="form-control num usd"></input>
				  </div>
<!-- 				  <div class="form-group"> -->
<%-- 				  	<label><koala:i18n key="EUR"/></label><input type="text" name="yd_eur" class="form-control num eur"></input> --%>
<!-- 				  </div>		   -->
			  </div>
			  <div class="form-inline">
					<div class="form-group">
				  	<label><koala:i18n key="express.box.count"/><span class="required">*</span></label><input type="text" dataType="Require" name="yd_num" required id="xiangziNum" class="form-control num" value="1"></input>
				  </div>
				  <div class="form-group">
				  	<label><koala:i18n key="express.goods.addr"/><span class="required">*</span></label><textarea id="address" dataType="Require" name="yd_address" class="form-control" rows="1" cols="22"></textarea>
				  </div>
				  <div class="form-group">
				  	<label><koala:i18n key="express.goods.url"/></label><textarea id="url" name="yd_url" class="form-control" rows="1" cols="22"></textarea>
				  </div>
			  </div>
			  <article class="xiangzi" id="xiangzi">
			  	<div class="xz xiangzi" id="xz-1">
					  <h2><koala:i18n key="express.box1"/></h2>
				      <div class="form-inline">	
						  <div class="form-group">
						  	<label><koala:i18n key="goods_count"/><span class="required">*</span></label><input type="text" dataType="Require" name="box_num" onblur="dealSP($(this))" class="form-control num shangpinNum" value="1"></input>
						  </div>
						  <div class="form-group">
						  	<label><koala:i18n key="weight"/>(KG)</label><input type="text"  name="box_weight" class="form-control num"></input>
						  </div>
					  </div>
					  <div class="form-inline">
						  <div class="form-group">
						  	<label><koala:i18n key="length"/>(CM)</label><input type="text" name="box_length"onblur="vkg($(this))" class="form-control vm length num"></input>
						  </div>
						  <div class="form-group">
						  	<label><koala:i18n key="width"/>(CM)</label><input type="text" name="box_width" onblur="vkg($(this))" class="form-control vm width num"></input>
						  </div>
						  <div class="form-group">
						  	<label><koala:i18n key="height"/>(CM)</label><input type="text" name="box_height" onblur="vkg($(this))" class="form-control vm height num"></input>
						  </div>
						  <div class="form-group">
						  	<label><koala:i18n key="VOL_WT"/>(KG)</label><input type="text" name="box_vol" class="form-control vkg num"></input>
						  </div>
					  </div>
					  <article class="shangpin">
					  	<div class="sp" id="sp-1">
								<h2 id="here"><koala:i18n key="box1goods1"/></h2>
								<div class="form-inline">
								  <div class="form-group">
								  	<label><koala:i18n key="goods_code"/><span class="required">*</span></label><input dataType="Require" type="text" name="goodsId" onblur="getGoods($(this));" class="form-control"></input>
								  </div>
								  <div class="form-group">
								  	<label><koala:i18n key="goods_name"/><span class="required">*</span></label><textarea name="goodsName" dataType="Require" class="form-control" rows="1" cols="22"></textarea>
								  </div>
								  <div class="form-group">
								  	<label><koala:i18n key="goods.std"/><span class="required">*</span></label><input type="text" dataType="Require" name="goodsType" class="form-control"></input>
								  </div>
								  <div class="form-group">
								  	<label><koala:i18n key="goods_count"/><span class="required">*</span></label><input type="text" dataType="Require" name="goodsNum" class="form-control num"></input>
								  </div>
							  </div>
							  <div class="form-inline">
									<div class="form-group">
								  	<label><koala:i18n key="YEN"/></label><input type="text" name="jpyPrice" class="form-control num jpy"></input>
								  </div>
								  <div class="form-group">
								  	<label><koala:i18n key="RMB"/></label><input type="text" name="cnyPrice" class="form-control num cny"></input>
								  </div>
								  <div class="form-group">
								  	<label><koala:i18n key="USD"/></label><input type="text" name="usdPrice" class="form-control num usd"></input>
								  </div>
								  <div class="form-group">
								  	<label><koala:i18n key="EUR"/></label><input type="text" name="eurPrice" class="form-control num eur"></input>
								  </div>		  
							  </div>
							  <div class="form-inline">
									<div class="form-group">
								  	<label><koala:i18n key="goods_kind"/><span class="required">*</span></label><input type="text" dataType="Require" onfocus="getBigKind($(this));" name="bigType" class="form-control"></input>
								  </div>
								  <div class="form-group">
								  	<label><koala:i18n key="goods_class"/><span class="required">*</span></label><input type="text" dataType="Require" onfocus="getSmallKind($(this));" name="smallType" class="form-control" ></input>
								  </div>
								  <div class="form-group">
								  	<label><koala:i18n key="goods_brand"/></label><textarea name="model" class="form-control" rows="1" cols="22"></textarea>
								  </div>
								  <div class="form-group">
								  	<label><koala:i18n key="goods_made_in"/><span class="required">*</span></label><input type="text"  dataType="Require" onfocus="getCountry($(this));" name="country" class="form-control" ></input>
								  </div>
							  </div>
							  <div class="form-inline">
							  	<label><koala:i18n key="goods_material"/></label><textarea name="composition" class="form-control" rows="6" cols="65"></textarea>
							  		<div class="form-group">
<!-- 									   		<form id="imageForm" action="" method="post" enctype="multipart/form-data" > -->
<!-- 									  			<label>商品照片1</label><input type="file"  onchange="upload($(this))" id="goodsimage" name="goodsimage"></input> -->
												<label><koala:i18n key="PIC"/></label><input type="file"  onchange="upload($(this),this)"  name="file"></input>
									  			<img class="img-thumbnail image" src=""/>
									  			<input type="hidden"  id="goodsimage" name="image">
<!-- 									  		</form> -->
									 </div>
							  	</div>
								<div class="form-inline">
								  <div class="form-group">
								  	<label><koala:i18n key="length"/>(CM)</label><input type="text" name="length" onblur="vkg($(this))" class="form-control vm length num"></input>
								  </div>
								  <div class="form-group">
								  	<label><koala:i18n key="width"/>(CM)</label><input type="text" name="width" onblur="vkg($(this))" class="form-control vm width num"></input>
								  </div>
								  <div class="form-group">
								  	<label><koala:i18n key="height"/>(CM)</label><input type="text"  name="height" onblur="vkg($(this))" class="form-control vm height num"></input>
								  </div>
								  <div class="form-group">
								  	<label><koala:i18n key="VOL_WT"/></label><input type="text" name="volume" class="form-control vkg"></input>
								  </div>
							  </div>
							  <div class="form-inline">
									<div class="form-group">
								  	<label><koala:i18n key="weight"/>(KG)</label><input type="text" name="weight" class="form-control num"></input>
								  </div>
								  
								</div>
								  
							  
							 </div>
						 </article>
					 </div>
				</article>
				<div style="text-align:center;padding-top:30px;">
					<button type="button" class="btn btn-info" onclick="save();"><span class="glyphicon glyphicon-plus"></span><koala:i18n key="express.warehouse.in"/></button>  
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ckModal" ><span class="glyphicon glyphicon-th-large"></span><koala:i18n key="express.warehouse.out"/></button>
				</div>
			</article>
			</form>
			<!--快速出库 -->
			<div class="modal fade" id="ckModal" tabindex="-1" role="dialog" aria-labelledby="ckModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="exampleModalLabel"><koala:i18n key="express.warehouse.out"/></h4>
			      </div>
			      <form>
			      <div class="modal-body">
			        
			        	<div class="form-inline">
				          <div >
				            <label style="width:auto;" for="message-text"><koala:i18n key="express.no.confirm"/></label>
				            <input type="text" style="width:300px;" class="form-control" id="message-text">
				          </div>
			          </div>
			       
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal"><koala:i18n key="cancel"/></button>
			        <button type="button" class="btn btn-primary" onclick="outSave();"><koala:i18n key="confirm"/></button>
			      </div>
			       </form>
			    </div>
			  </div>
			</div>
			
			
			<!--  悬浮框  -->
			<div class="navbar-fixed-bottom right" id="xf">
					<div class="box box-1"><a href="javascript:void(0);" onmouseover ="javascript:$('.box-3').hide();" onclick="toDiv('yd-1')"><span><koala:i18n key="express.info"/></span></a></div>
					<div class="box box-2 xz-1">
						<a href="javascript:void(0);"  onmouseover="showSP($(this))"  onclick="toDiv('xz-1')"><span><koala:i18n key="express.box1"/></span></a>
						<div  class="box box-3 sp-1" style="display:none;">
							<div  class="box box-4"><a href="javascript:void(0);"  onclick="toSP('xz-1','sp-1')"><span><koala:i18n key="box1goods1"/></span></a></div>
						</div>
					</div>		
			</div>
		</section>
		<script>
		var id = '<%=M %>';
		jQuery.i18n.properties({//加载资浏览器语言对应的资源文件
    		name:'strings', //资源文件名称
    		path:'resources/i18n/warehouse/', //资源文件路径
    		mode:'map', //用Map的方式使用资源文件中的值
    		language:id,// 对应的语言
    		callback: function() {//加载成功后设置显示内容
    			//alert($.i18n.prop('string_username'));
    		}
    	});
			
		</script>
</body>
</html>