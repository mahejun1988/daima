<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>
<%@ taglib uri="http://www.openkoala.org/i18n" prefix="koala" %>
<form  class="form-horizontal">

	           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="goods_code"/>:</label>
                    <div class="col-lg-9">
                           <p class="form-control-static" id="goodsIdID"></p>
                    </div>
                </div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="goods_name"/>:</label>
                    <div class="col-lg-9">
                           <p class="form-control-static" id="goodsNameID"></p>
                    </div>
                </div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="goods.std"/>:</label>
                    <div class="col-lg-9">
                           <p class="form-control-static" id="goodsTypeID"></p>
                    </div>
                </div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="YEN"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="jpyPriceID"></p>
                    </div>
                    <label class="col-lg-3 control-label"><koala:i18n key="RMB"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="cnyPriceID"></p>
                    </div>
                </div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="USD"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="usdPriceID"></p>
                    </div>
                    <label class="col-lg-3 control-label"><koala:i18n key="EUR"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="eurPriceID"></p>
                    </div>
                </div>
                <div class="form-group">
                	<label class="col-lg-3 control-label"><koala:i18n key="goods_count"/>:</label>
	                <div class="col-lg-3">
                           <p class="form-control-static" id="goodsNumID"></p>
					</div>
				</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="goods_kind"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="bigTypeID"></p>
                    </div>
                    <label class="col-lg-3 control-label"><koala:i18n key="goods_class"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="smallTypeID"></p>
                    </div>
                </div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="goods_brand"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="modelID"></p>
                    </div>
                    <label class="col-lg-3 control-label"><koala:i18n key="goods_made_in"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="countryID"></p>
                    </div>
                </div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="goods_material"/>:</label>
                    <div class="col-lg-9">
                           <p class="form-control-static" id="compositionID"></p>
                    </div>
                </div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="weight"/>(KG):</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="weightID"></p>
                    </div>
                    <label class="col-lg-3 control-label"><koala:i18n key="length"/>(CM):</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="lengthID"></p>
                    </div>
                </div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="width"/>(CM):</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="widthID"></p>
                    </div>
                    <label class="col-lg-3 control-label"><koala:i18n key="height"/>(CM):</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="heightID"></p>
                    </div>
                </div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="VOL_WT"/>:</label>
                    <div class="col-lg-3">
                           <p class="form-control-static" id="volumeID"></p>
                    </div>
                </div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label"><koala:i18n key="PIC"/>:</label>
                    <div class="col-lg-9">
                           <img style="width:180px;height:auto;" class="form-control-static" id="imageID" src=""></img>
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