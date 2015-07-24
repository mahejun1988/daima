package com.ware.token.warehouse.facade.impl;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.text.MessageFormat;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;
import org.openkoala.koala.commons.InvokeResult;

import com.ware.token.warehouse.facade.dto.*;
import com.ware.token.warehouse.facade.impl.assembler.BillGoodsAssembler;
import com.ware.token.warehouse.facade.BillGoodsFacade;
import com.ware.token.warehouse.application.BillGoodsApplication;
import com.ware.token.warehouse.core.domain.*;

@Named
public class BillGoodsFacadeImpl implements BillGoodsFacade {

	@Inject
	private BillGoodsApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getBillGoods(Long id) {
		return InvokeResult.success(BillGoodsAssembler.toDTO(application.getBillGoods(id)));
	}
	
	public InvokeResult creatBillGoods(BillGoodsDTO billGoodsDTO) {
		application.creatBillGoods(BillGoodsAssembler.toEntity(billGoodsDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateBillGoods(BillGoodsDTO billGoodsDTO) {
		application.updateBillGoods(BillGoodsAssembler.toEntity(billGoodsDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeBillGoods(Long id) {
		application.removeBillGoods(application.getBillGoods(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeBillGoodss(Long[] ids) {
		Set<BillGoods> billGoodss= new HashSet<BillGoods>();
		for (Long id : ids) {
			billGoodss.add(application.getBillGoods(id));
		}
		application.removeBillGoodss(billGoodss);
		return InvokeResult.success();
	}
	
	public List<BillGoodsDTO> findAllBillGoods() {
		return BillGoodsAssembler.toDTOs(application.findAllBillGoods());
	}
	
	public Page<BillGoodsDTO> pageQueryBillGoods(BillGoodsDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _billGoods from BillGoods _billGoods   where 1=1 ");
	   	if (queryVo.getCreateTime() != null) {
	   		jpql.append(" and _billGoods.createTime between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTime());
	   		conditionVals.add(queryVo.getCreateTimeEnd());
	   	}	
	   	if (queryVo.getCreateUser() != null && !"".equals(queryVo.getCreateUser())) {
	   		jpql.append(" and _billGoods.createUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateUser()));
	   	}		
	   	if (queryVo.getUpdateTime() != null) {
	   		jpql.append(" and _billGoods.updateTime between ? and ? ");
	   		conditionVals.add(queryVo.getUpdateTime());
	   		conditionVals.add(queryVo.getUpdateTimeEnd());
	   	}	
	   	if (queryVo.getUpdateUser() != null && !"".equals(queryVo.getUpdateUser())) {
	   		jpql.append(" and _billGoods.updateUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getUpdateUser()));
	   	}		
	   	if (queryVo.getWaybillId() != null && !"".equals(queryVo.getWaybillId())) {
	   		jpql.append(" and _billGoods.waybillId like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWaybillId()));
	   	}		
	   	if (queryVo.getBoxId() != null && !"".equals(queryVo.getBoxId())) {
	   		jpql.append(" and _billGoods.boxId like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getBoxId()));
	   	}		
	   	if (queryVo.getGoodsId() != null && !"".equals(queryVo.getGoodsId())) {
	   		jpql.append(" and _billGoods.goodsId like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getGoodsId()));
	   	}		
	   	if (queryVo.getGoodsName() != null && !"".equals(queryVo.getGoodsName())) {
	   		jpql.append(" and _billGoods.goodsName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getGoodsName()));
	   	}		
	   	if (queryVo.getGoodsType() != null && !"".equals(queryVo.getGoodsType())) {
	   		jpql.append(" and _billGoods.goodsType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getGoodsType()));
	   	}		
	   	if (queryVo.getGoodsNum() != null && !"".equals(queryVo.getGoodsNum())) {
	   		jpql.append(" and _billGoods.goodsNum like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getGoodsNum()));
	   	}		
	   	if (queryVo.getJpyPrice() != null && !"".equals(queryVo.getJpyPrice())) {
	   		jpql.append(" and _billGoods.jpyPrice like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getJpyPrice()));
	   	}		
	   	if (queryVo.getCnyPrice() != null && !"".equals(queryVo.getCnyPrice())) {
	   		jpql.append(" and _billGoods.cnyPrice like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCnyPrice()));
	   	}		
	   	if (queryVo.getUsdPrice() != null && !"".equals(queryVo.getUsdPrice())) {
	   		jpql.append(" and _billGoods.usdPrice like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getUsdPrice()));
	   	}		
	   	if (queryVo.getEurPrice() != null && !"".equals(queryVo.getEurPrice())) {
	   		jpql.append(" and _billGoods.eurPrice like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEurPrice()));
	   	}		
	   	if (queryVo.getBigType() != null && !"".equals(queryVo.getBigType())) {
	   		jpql.append(" and _billGoods.bigType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getBigType()));
	   	}		
	   	if (queryVo.getSmallType() != null && !"".equals(queryVo.getSmallType())) {
	   		jpql.append(" and _billGoods.smallType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getSmallType()));
	   	}		
	   	if (queryVo.getModel() != null && !"".equals(queryVo.getModel())) {
	   		jpql.append(" and _billGoods.model like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getModel()));
	   	}		
	   	if (queryVo.getCountry() != null && !"".equals(queryVo.getCountry())) {
	   		jpql.append(" and _billGoods.country like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCountry()));
	   	}		
	   	if (queryVo.getComposition() != null && !"".equals(queryVo.getComposition())) {
	   		jpql.append(" and _billGoods.composition like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getComposition()));
	   	}		
	   	if (queryVo.getWeight() != null && !"".equals(queryVo.getWeight())) {
	   		jpql.append(" and _billGoods.weight like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWeight()));
	   	}		
	   	if (queryVo.getLength() != null && !"".equals(queryVo.getLength())) {
	   		jpql.append(" and _billGoods.length like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLength()));
	   	}		
	   	if (queryVo.getWidth() != null && !"".equals(queryVo.getWidth())) {
	   		jpql.append(" and _billGoods.width like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWidth()));
	   	}		
	   	if (queryVo.getHeight() != null && !"".equals(queryVo.getHeight())) {
	   		jpql.append(" and _billGoods.height like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getHeight()));
	   	}		
	   	if (queryVo.getVolume() != null && !"".equals(queryVo.getVolume())) {
	   		jpql.append(" and _billGoods.volume like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getVolume()));
	   	}		
	   	if (queryVo.getImage() != null && !"".equals(queryVo.getImage())) {
	   		jpql.append(" and _billGoods.image like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getImage()));
	   	}		
        Page<BillGoods> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<BillGoodsDTO>(pages.getStart(), pages.getResultCount(),pageSize, BillGoodsAssembler.toDTOs(pages.getData()));
	}

	@Override
	public HSSFWorkbook export(List<Map<String, String>> list,String[] excelHeader) {
		HSSFWorkbook wb = new HSSFWorkbook();    
        HSSFSheet sheet = wb.createSheet("warehouse");// sheet名称    
        HSSFRow row = sheet.createRow((int) 0);// 创建标题栏
        HSSFCellStyle style = wb.createCellStyle();// 设置样式
        // 设置居中样式  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中  
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 垂直居中
        
        // 单元格列宽  
        int[] excelHeaderWidth = { 80,
        						   350, 350, 350, 350, 350, 350, 350, 350, 350, 350,
        						   350, 350, 350, 350, 350, 350, 350, 350, 350, 350,
        						   350, 350, 350, 350, 350, 350, 350, 350, 350, 350,
        						   350, 350, 350, 350, 350, 350, 350, 350, 350, 350,
        						   350, 350, 350, 350, 350, 350, 350, 350, 350, 350,
        						   350, 350, 350};
        
     // 设置列宽度（像素）  
        for (int i = 0; i < excelHeaderWidth.length; i++) {  
            sheet.setColumnWidth(i, 32 * excelHeaderWidth[i]);  
        }  
        
        // 设置标题样式  
        HSSFCellStyle style1 = wb.createCellStyle();  
        Font font = wb.createFont();  
        font.setColor(HSSFColor.GREY_40_PERCENT.index);  
        font.setBoldweight(Font.BOLDWEIGHT_BOLD); // 粗体  
        style1.setFont(font);  
        style1.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中  
        style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 垂直居中
        
        // 赋值标题
        for (int i = 0; i < excelHeader.length; i++) {    
            HSSFCell cell = row.createCell(i);    
            cell.setCellValue(excelHeader[i]);    
            cell.setCellStyle(style1);    
            sheet.autoSizeColumn(i);    
        }
        
        // 赋值数据
        for (int i = 0; i < list.size(); i++) {    
            row = sheet.createRow(i + 1);    
            Map<String, String> map = list.get(i);    
            row.createCell(0).setCellValue(i+1);
            row.createCell(1).setCellValue(map.get("waybillId")); 
            row.createCell(2).setCellValue(map.get("billEur"));
            row.createCell(3).setCellValue(map.get("wayBillCoo"));
            row.createCell(4).setCellValue(map.get("wayBillFrom"));
            row.createCell(5).setCellValue(map.get("wayBillInternet"));
            row.createCell(6).setCellValue(map.get("billJpy"));
            row.createCell(7).setCellValue(map.get("billCny"));
            row.createCell(8).setCellValue(map.get("billUsd"));
            row.createCell(9).setCellValue(map.get("ArrivalTime"));
            row.createCell(10).setCellValue(map.get("outFlag"));
            
            row.createCell(11).setCellValue(map.get("boxWeight"));
            row.createCell(12).setCellValue(map.get("boxLength"));
            row.createCell(13).setCellValue(map.get("boxWidth"));
            row.createCell(14).setCellValue(map.get("boxHeight"));
            row.createCell(15).setCellValue(map.get("boxVolume"));
            
            row.createCell(16).setCellValue(map.get("goodsId"));
            row.createCell(17).setCellValue(map.get("goodsName"));
            row.createCell(18).setCellValue(map.get("goodsType"));
            row.createCell(19).setCellValue(map.get("goodsNum"));
            row.createCell(20).setCellValue(map.get("goodsJpy"));
            row.createCell(21).setCellValue(map.get("goodsCny")); 
            row.createCell(22).setCellValue(map.get("goodsUsd"));
            row.createCell(23).setCellValue(map.get("goodsEur"));
            row.createCell(24).setCellValue(map.get("bigType"));
            row.createCell(25).setCellValue(map.get("smallType"));
            row.createCell(26).setCellValue(map.get("model"));
            row.createCell(27).setCellValue(map.get("country"));
            row.createCell(28).setCellValue(map.get("composition"));
            row.createCell(29).setCellValue(map.get("goodsWeight"));
            row.createCell(30).setCellValue(map.get("goodsLength"));
            row.createCell(31).setCellValue(map.get("goodsWidth"));
            row.createCell(32).setCellValue(map.get("goodsHeight"));
            row.createCell(33).setCellValue(map.get("goodsVolume"));
            
            row.createCell(34).setCellValue(map.get("outWayId"));
            row.createCell(35).setCellValue(map.get("outWayCoo"));
            row.createCell(36).setCellValue(map.get("recieverAddr"));
            row.createCell(37).setCellValue(map.get("customerName"));
            row.createCell(38).setCellValue(map.get("mergeFlag"));
            row.createCell(39).setCellValue(map.get("outWeight"));
            row.createCell(40).setCellValue(map.get("outLength"));
            row.createCell(41).setCellValue(map.get("outWidth"));
            row.createCell(42).setCellValue(map.get("outHeight"));
            row.createCell(43).setCellValue(map.get("outVolume"));
        }    
        return wb; 
	}
	
	
}
