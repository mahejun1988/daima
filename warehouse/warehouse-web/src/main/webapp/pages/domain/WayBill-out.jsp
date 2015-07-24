<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>
<%@ taglib uri="http://www.openkoala.org/i18n" prefix="koala" %> 
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
	<input type="hidden" id="idID2" name="id" /> 
	<input type="hidden" id="versionID2" name="version" /> 
	
	           <div style="display:none"class="form-group">
                    	<label class="col-lg-3 control-label"><koala:i18n key="express.no"/>:</label>
	                    <div class="col-lg-9">
                           <input  name="waybillId"  style="display:inline; width:94%;" class="form-control"  type="text"  id="waybillIdID2" />
			    		</div>
				</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="express.no.confirm"/>:</label>
	                    <div class="col-lg-9">
                           <input name="waybillId_" style="display:inline; width:94%;" class="form-control"  type="text"  id="waybillID2_" />
			    </div>
	</div>
		          
	</form>
<script type="text/javascript">
    var selectItems = {};
                                                                                                                            </script>
</body>
</html>