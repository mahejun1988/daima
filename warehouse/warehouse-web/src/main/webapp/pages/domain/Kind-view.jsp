<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>
<%@ taglib uri="http://www.openkoala.org/i18n" prefix="koala" %>
<form  class="form-horizontal">
	           
	           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="kind.code"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="codeTypeID"></p>
                    </div>
                    <label class="col-lg-3 control-label"><koala:i18n key="kind.name"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="typeNameID"></p>
                    </div>
                </div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="kind.parent.code"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="upCodeID"></p>
                    </div>
                    <label class="col-lg-3 control-label"><koala:i18n key="kind.sub.code"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="codeID"></p>
                    </div>
                </div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="kind.sub.name"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="codeNameID"></p>
                    </div>
                    <label class="col-lg-3 control-label"><koala:i18n key="mark"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="remarkID"></p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="insert.time"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="createTimeID"></p>
                    </div>
                    <label class="col-lg-3 control-label"><koala:i18n key="insert.id"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="createUserID"></p>
                    </div>
                </div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="modify.time"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="updateTimeID"></p>
                    </div>
                    <label class="col-lg-3 control-label"><koala:i18n key="modify.id"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="updateUserID"></p>
                    </div>
                </div>
</form>