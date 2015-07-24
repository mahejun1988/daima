var spHtml;
var spXF;
$(document).ready(function(){
	// 对Date的扩展，将 Date 转化为指定格式的String
	// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
	// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
	// 例子： 
	// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
	// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
	Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}
	
	var now = new Date(); 
//	var nowStr = now.format("yyyy-MM-dd"); 
	$("#today").val(now.Format("yyyy-MM-dd"));
	
	// 增加箱子
	var XZHtml = $("#xiangzi").html();
	var XZXF = $(".box-2").prop("outerHTML");
	Array.prototype.S=String.fromCharCode(2);
	Array.prototype.in_array=function(e)
	{
	var r=new RegExp(this.S+e+this.S);
	return (r.test(this.S+this.join(this.S)+this.S));
	}
	
	// 自动补全--物流公司
	$.ajax({
	  	   type: "POST",
	  	   async: false,
	  	   data: {upCode:'0',codeType:'express'},
	  	   url: contextPath+"/Kind/getCodeList.do",
	  	   success: function(data){
	  		 var arr = []; 
	  		 $.each(data, function (i, item) {
  		 		if(item.codeName!="" && !arr.in_array(item.codeName)){
  		 			arr.push(item.codeName);
  		 		}
	  		 });
	  		$("#coo").typeahead({
		 		    source: arr
		 	});
	  	   }
	});
	
	// 自动补全--购物来源、购物网站
	var company;
	$.ajax({
	  	   type: "POST",
	  	   async: false,
	  	   url: contextPath+"/WayBill/getAllCoo.do",
	  	   success: function(data){
	  		 	var arr = [];
	  		 	var arr2 = [];
	  		 	var arr3 = [];
	  		 	$.each(data, function (i, item) {
	  		 		if(item.wayBillCoo!="" && !arr.in_array(item.wayBillCoo)){
	  		 			arr.push(item.wayBillCoo);
	  		 		}
	  		 		if(item.wayBillFrom!="" && !arr2.in_array(item.wayBillFrom)){
	  		 			arr2.push(item.wayBillFrom);
	  		 		}
	  		 		if(item.wayBillInternet!="" && !arr3.in_array(item.wayBillInternet)){
	  		 			arr3.push(item.wayBillInternet);
	  		 		}
	  		 		
//	  		 		$("#coo").typeahead({
//	  		 		    source: arr
//	  		 		});
	  		 		$("#address").typeahead({
	  		 		    source: arr2
	  		 		});
	  		 		$("#url").typeahead({
	  		 		    source: arr3
	  		 		});
	  	        });
	  	   }
	  	})
	
	
	
	$("#xiangziNum").blur(function(){
		// $("#xiangzi").html("");
		// 原有箱子数量
		var i = $("#xiangzi").find(".xz").length;
		// 录入的箱子数量
		var size = parseInt($("#xiangziNum").val());
		if(i == size){// 相等--不变
			return;
		}
		if(i < size){// 箱子少，增加录入位数,增加悬浮框
			while(i < size){
				i++;
				//$(".yundan").append($("#xiangzi").prop("outerHTML"));
				var innerHtml = XZHtml.replace(new RegExp(/(箱子1)/g),"箱子"+i)
				.replace(new RegExp(/(1番目)/g),i+"番目").replace(new RegExp(/(No.1 Box)/g),"No."+i+"Box")
				.replace(new RegExp(/(xz-1)/g),"xz-"+i);
				$("#xiangzi").append(innerHtml);
				$("#xf").append(XZXF.replace(new RegExp(/(箱子1)/g),"箱子"+i)
						.replace(new RegExp(/(1番目)/g),i+"番目").replace(new RegExp(/(No.1 Box)/g),"No."+i+"Box")  
						.replace(new RegExp(/(xz-1)/g),"xz-"+i));
			}
			return;
		}
		if(i > size){// 箱子多，去掉末尾箱子
			while(i > size){				
				$("#xiangzi").find(".xz").eq(i-1).remove();
				$("#xf").find(".box-2").eq(i-1).remove();
				i--;
			}
			return;
		}
	})
	// 增加商品
	 spHtml = $(".shangpin").html();
	 spXF = $(".box-3").html();
	
});

// 自动计算体积重
function vkg(obj){
		// alert(obj.parent().parent().find('.length').val());
		var length = obj.parent().parent().parent().find('.length').val();
		var width = obj.parent().parent().parent().find('.width').val();
		var height = obj.parent().parent().parent().find('.height').val();
		
		if(length != null && length != "" && width != null && width != "" && height != null && height != ""){
			 obj.parent().parent().parent().find('.vkg').val((length*width*height/5000).toFixed(3));
		}else{
			 obj.parent().parent().parent().find('.vkg').val("");
		}
	
};

// 根据条形码获取商品信息
function getGoods(obj){
	$.ajax({
	  	   type: "POST",
	  	   async: false,
	  	   data:{goodsId:obj.val()},
	  	   url: contextPath+"/Goods/getByGoodsId.do",
	  	   success: function(data){
// 	  		 	obj.parent().parent().find("input[name='goodsName']").val(data.goodsName);
	  		 	obj.parent().parent().parent().find("input,textarea").each(function(){
	  		 		var inputName= $(this).attr("name");
	  		 		$(this).val(data[inputName]);
	  		 	});
	  		 	obj.parent().parent().parent().find("img").each(function(){
	  		 		$(this).attr("src",data["image"]);
	  		 	});
	  	   }
	  	});
}

// 自动补全 种类
function getBigKind(obj){
	$.ajax({
	  	   type: "POST",
	  	   async: false,
	  	   data: {upCode:'0',codeType:'kind'},
	  	   url: contextPath+"/Kind/getCodeList.do",
	  	   success: function(data){
	  			var arr = [];
	  		    $.each(data, function (i, item) {  
	  		 		if(item.codeName!=""){
	  		 			arr.push(item.codeName);
	  		 		}
	  	        });
	  			obj.typeahead({
	  				 source: function(query, process) {
	  					process(arr);
	  			      }
//		 		    source: arr
		 		});
	  	   }
	  	})
}

//自动补全 细类
function getSmallKind(obj){
	var bigtypeName = obj.parent().parent().parent().find("input[name='bigType']").val();
	$.ajax({
	  	   type: "POST",
	  	   async: false,
	  	   data: {codeName:bigtypeName,codeType:'kind'},
	  	   url: contextPath+"/Kind/getByCodeName.do",
	  	   success: function(data){
	  			var arr = [];
	  		    $.each(data, function (i, item) {  
	  		 		if(item.codeName!=""){
	  		 			arr.push(item.codeName);
	  		 		}
	  	        });
	  		  obj.typeahead({
		 		    source: arr
		 		});
	  	   }
	  	})
}
//自动补全 原产国
function getCountry(obj){
	 $.ajax({
	  	   type: "POST",
	  	   async: false,
	  	   data: {upCode:'0',codeType:'country'},
	  	   url: contextPath+"/Kind/getCodeList.do",
	  	   success: function(data){
	  			var arr = [];
	  		    $.each(data, function (i, item) {  
	  		 		if(item.codeName!=""){
	  		 			arr.push(item.codeName);
	  		 		}
	  	        });
	  		    
	  		  obj.typeahead({
		 		    source: arr
		 		});
	  	   }
	  	})
}

// 图片上传
function upload(obj,file){
	 if (file.files && file.files[0]) {
		 var reader = new FileReader();
		 reader.onload = function(evt){
			 obj.next().attr("src",evt.target.result);
		 }
		 reader.readAsDataURL(file.files[0]);
	 }
};
//function upload(file){
////	var form = obj.parent();
////	var $this = $(this);
////	obj.parent().ajaxSubmit({
////		type: "POST",
////		url:contextPath+"/WayBill/upload.do",
////		success: function(data){
////			obj.next().attr("src",contextPath+""+data);
////			obj.parent().find("[name='image']").val(contextPath+""+data);
////		},
////		error:function(e){
////			$this.message({
////				type : 'warning',
////				content : '图片上传失败'
////			});
////		}
////	});
//	 if (file.files && file.files[0]) {
//		 var reader = new FileReader();
//		 reader.onload = function(evt){
//			 file.next().attr("src",evt.target.result);
//		 }
//		 reader.readAsDataURL(file.files[0]);
//	 }
//};	


// 处理商品位栏目
function dealSP(sp){
		var tt = sp.parent().parent().parent().find(".shangpin");
		var i =  tt.find(".sp").length;// 实际商品数
		var xzid = sp.parent().parent().parent().attr("id")//箱子id
		// tt.html("");
		var size = parseInt(sp.val());// 录入商品数
		if(i == size){// 相等--不变
			return;
		}
		if(i < size){// 商品少，增加录入位数
			while(i < size){
				i++;
				var innerHtml = spHtml.replace(new RegExp(/(商品1)/g),"商品"+i)
				.replace(new RegExp(/(1個目)/g),i+"個目").replace(new RegExp(/(No.1 Goods)/g),"No."+i+"Goods")  
				.replace(new RegExp(/(sp-1)/g),"sp-"+i)
				.replace(new RegExp(/(箱子1)/g),"箱子"+xzid.replace("xz-",""))
				.replace(new RegExp(/(1番目)/g),xzid.replace("xz-","")+"番目")
				.replace(new RegExp(/(No.1 Box)/g),"No."+xzid.replace("xz-","")+"Box");
				
				tt.append(innerHtml);
				
				var spXFInner = spXF.replace(new RegExp(/(商品1)/g),"商品"+i)
				.replace(new RegExp(/(1個目)/g),i+"個目").replace(new RegExp(/(No.1 Goods)/g),"No."+i+"Goods") 
				.replace(new RegExp(/(sp-1)/g),"sp-"+i)
				.replace(new RegExp(/(箱子1)/g),"箱子"+xzid.replace("xz-",""))
				.replace(new RegExp(/(1番目)/g),xzid.replace("xz-","")+"番目").replace(new RegExp(/(No.1 Box)/g),"No."+xzid.replace("xz-","")+"Box")
				.replace(new RegExp(/(xz-1)/g),xzid);
				
				$("#xf").find("."+xzid).find(".box-3").append(spXFInner);
			}
			return;
		}
		if(i > size){// 商品多，去掉末尾商品
			while(i > size){				
				tt.find(".sp").eq(i-1).remove();
				$("#xf").find("."+xzid).find(".box-4").eq(i-1).remove();
				i--;
			}
			return;
		}	
}

function ajaxFileUpload(file){

	return false;
}

// 定位悬浮框
function toSP(xzId,spId){
	var container = $('body'),
	scrollTo = $('#'+xzId).find('#'+spId);			
	container.animate({scrollTop: scrollTo.offset().top},1000);
//	document.getElementById(xzId).getElementById(spId).scrollIntoView();
}

function toDiv(xzId){
	var container = $('body'),
	scrollTo = $('#'+xzId);			
	container.animate({scrollTop: scrollTo.offset().top},1000);
}

Date.prototype.format = function(format){ 
	var o = { 
	"M+" : this.getMonth()+1, //month 
	"d+" : this.getDate(), //day 
	"h+" : this.getHours(), //hour 
	"m+" : this.getMinutes(), //minute 
	"s+" : this.getSeconds(), //second 
	"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
	"S" : this.getMilliseconds() //millisecond 
	} 
	
	if(/(y+)/.test(format)) { 
	format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	} 
	
	for(var k in o) { 
	if(new RegExp("("+ k +")").test(format)) { 
	format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
	} 
	} 
	return format; 
} 


function IsValidDate(DateStr)   
{   
	var sDate=DateStr.replace(/(^\s+|\s+$)/g,''); //去两边空格;   
	if(sDate=='') return true;   
	//如果格式满足YYYY-(/)MM-(/)DD或YYYY-(/)M-(/)DD或YYYY-(/)M-(/)D或YYYY-(/)MM-(/)D就替换为''   
	//数据库中，合法日期可以是:YYYY-MM/DD(2003-3/21),数据库会自动转换为YYYY-MM-DD格式   
	var s = sDate.replace(/[\d]{ 4,4 }[\-/]{ 1 }[\d]{ 1,2 }[\-/]{ 1 }[\d]{ 1,2 }/g,'');   
	if (s=='') //说明格式满足YYYY-MM-DD或YYYY-M-DD或YYYY-M-D或YYYY-MM-D  
	{   
		var t=new Date(sDate.replace(/\-/g,'/'));   
		var ar = sDate.split(/[-/:]/);   
		if(ar[0] != t.getYear() || ar[1] != t.getMonth()+1 || ar[2] != t.getDate()){   
		    //alert('错误的日期格式！格式为：YYYY-MM-DD或YYYY/MM/DD。注意闰年。');   
		    return false;   
		}   
	}   
	else{   
		//alert('错误的日期格式！格式为：YYYY-MM-DD或YYYY/MM/DD。注意闰年。');   
		return false;   
	}   
	return true;   
}
//展开商品列表
function showSP(o){
	$(".box-3").hide();
	o.next().show();
}

// 入库保存
function save(){
	
	if(!Validator.Validate($("#content").find('form')[0],3)){
		return;
	}
	// 运单信息
	//箱子json信息
	var ydDataArr=[];
	var param={}
	//alert($("#yd-1").find("[name='yd_id']").val());
	param.waybillId = $("#yd-1").find("[name='yd_id']").val();
	param.wayBillCoo = $("#yd-1").find("[name='yd_coo']").val();
	param.arrivalTime = $("#yd-1").find("[name='yd_time']").val()+" 00:00:00" ;
	param.wayBillFrom = $("#yd-1").find("[name='yd_address']").val();
	param.wayBillInternet = $("#yd-1").find("[name='yd_url']").val();
	param.jpyPrice = $("#yd-1").find("[name='yd_jpy']").val();
	param.cnyPrice = $("#yd-1").find("[name='yd_cny']").val();
	param.usdPrice = $("#yd-1").find("[name='yd_usd']").val();
	param.eurPrice = $("#yd-1").find("[name='yd_eur']").val();
	param.wayBillNum = $("#yd-1").find("[name='yd_num']").val();
	ydDataArr.push(param);
	var ydArrJson = JSON.stringify(ydDataArr);
	
	//箱子json信息
	var xzDataArr=[];
	$("#xiangzi").find(".xiangzi").each(function(i,item){
		var num = $(this).find("input[name='box_num']").val();// 商品数量
		var weight = $(this).find("input[name='box_weight']").val();// 箱子重量
		var length = $(this).find("input[name='box_length']").val();// 长度
		var width = $(this).find("input[name='box_width']").val();// 宽
		var height = $(this).find("input[name='box_height']").val();// 高
		var vol = $(this).find("input[name='box_vol']").val();// 体积重
		var box_id = i+1;// 序号
		var param={}
		param.waybillId = $("#yd-1").find("[name='yd_id']").val();
		param.boxId = box_id;
		param.weight = weight;
		param.lenght = length;
		param.width = width;
		param.height = height;
		param.volume = vol;
		param.goodsNum = num;
		xzDataArr.push(param);
	})
	var xzArrJson = JSON.stringify(xzDataArr);
// 	<article class="shangpin">
	
	// 商品信息
	var spDataArr=[];
	$("#xiangzi").find("article[class='shangpin']").each(function(i,item){
		var xzId =  i+1;
		$(this).find(".sp").each(function(j,item2){
			var param={};
			param.boxId = xzId;
			param.spId = j + 1;
			param.waybillId = $("#yd-1").find("[name='yd_id']").val();
//			alert(this.parent().parent().find(".xz").attr("id").replace("xz-",""));
//			param.boxId = this.parent().parent().find(".xz").attr("id").replace("xz-","");
			param.goodsId = $(this).find("[name='goodsId']").val();
			param.goodsName = $(this).find("[name='goodsName']").val();
			param.goodsType = $(this).find("[name='goodsType']").val();
			param.goodsNum = $(this).find("[name='goodsNum']").val();
			param.jpyPrice = $(this).find("[name='jpyPrice']").val();
			param.cnyPrice = $(this).find("[name='cnyPrice']").val();
			param.usdPrice = $(this).find("[name='usdPrice']").val();
			param.eurPrice = $(this).find("[name='eurPrice']").val();
			param.bigType = $(this).find("[name='bigType']").val();
			param.smallType = $(this).find("[name='smallType']").val();
			param.model = $(this).find("[name='model']").val();
			param.country = $(this).find("[name='country']").val();
			param.composition = $(this).find("[name='composition']").val();
			param.weight = $(this).find("[name='weight']").val();
			param.length = $(this).find("[name='length']").val();
			param.width = $(this).find("[name='width']").val();
			param.height = $(this).find("[name='height']").val();
			param.volume = $(this).find("[name='volume']").val();
			param.composition = $(this).find("[name='composition']").val();
			param.image = $(this).find("[name='image']").val();
			spDataArr.push(param);
		})
	})
	var spArrJson = JSON.stringify(spDataArr);
	var $this = $(this);
	$.ajax({
	  	   type: "POST",
	  	   async: false,
	  	   data: {ydArrJson:ydArrJson,xzArrJson:xzArrJson,spArrJson:spArrJson},
	  	   url: contextPath+"/WayBill/addYd.do",
	  	   success: function(data){
	  		 if(data.success){
		  		 $("#yundanCode").message({
						type : 'success',
						content : '入库完毕！'
				  });
	  		 }else{
		  		 $("#yundanCode").message({
		  			 type: 'error',
                     content: data.errorMessage
				  });
                 }
	  	   }
	  	})
}
//快速出库
function outSave(){
	//var $("#yundanCode") = $(this);
	if($("#message-text").val() != $("#yundanCode").val()){
		$("#yundanCode").message({
			type : 'warning',
			content : '运单号录入不一致，请确认！'
		});
		}else{
			$.ajax({
			  	   type: "POST",
			  	   async: false,
			  	   data:{waybillId:$("#message-text").val()},
			  	   url: contextPath+"/WayBill/out.do",
			  	   success: function(data){
			  		   if(data.success){
			  			   $("#yundanCode").message({
								type : 'success',
								content : '快速出库完毕！'
			  			   });
			  		 	}else{
			  		 		$("#yundanCode").message({
				  			 type: 'error',
		                     content: data.errorMessage
			  		 		});
		                 }
 			 			$('#ckModal').modal('hide');
			  	   },
			  	   error: function(e){
			  		 $("#yundanCode").message({
							type : 'success',
							content : '快速出库失败，请先入库再出库！'
						});
			  	   }
			  	})	
		
	}
}
