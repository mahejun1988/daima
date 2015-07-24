<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%> 
<%@ taglib uri="http://www.openkoala.org/i18n" prefix="koala" %> 
<!DOCTYPEhtml> 
<html> 
<head> 
<title>I18N</title> 
<meta http-equiv="Content-Type"content="text/html; charset=UTF-8"> 
<script src="/lib/jquery-1.8.3.min.js" type="text/javascript"></script>
</head> 
<body> 11
	<select id="langSelect">
		<option value = "zh_CN">请选择</option>
		<option value = "zh_CN">中文</option>
		<option value = "en_US">English</option>
	</select>

	I18N:<koala:i18n key="登录"/>
</body> 
<script>
$(function(){ 
	$("#langSelect").change(function(){
		var value = this.value;
		if (this.value){
			$.post('${pageContext.request.contextPath}/international/switchLanguage.do?locale=' + this.value).done(function(data){
				if(data.result == 'success'){
					window.location.reload();
				}else{
					alert("fail");
				}
			});
		}else{
			
		}
	})
})
	
</script>

</html>