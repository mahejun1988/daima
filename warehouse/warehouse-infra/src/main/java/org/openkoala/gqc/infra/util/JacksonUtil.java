package org.openkoala.gqc.infra.util;

import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.TypeReference;

/**
 * Jackson Json 工具类
 * 
 *   时间转换格式： "yyyy-MM-dd HH:mm:ss"
 * 
 * @author 
 */
public class JacksonUtil {

	private static ObjectMapper mapper;
	
	static{
		mapper = new ObjectMapper();// 设置输出包含的属性
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,false);
		//mapper.setSerializationInclusion(Inclusion.NON_NULL);  
	}

	/**
	 * 将对象转化为json数据
	 * @author mhj
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static String object2json(Object obj) throws Exception{
		if(obj == null){
			throw new IllegalArgumentException("this argument is required; it must not be null");
		}
		Writer strWriter = new StringWriter();
		mapper.writeValue(strWriter, obj);
		return strWriter.toString();
	}

	/**
	 * json数据转化为对象(包括Object和Array)
	 * 
	 * <br>e.g.
	 * <br>	  User u = JacksonUtil.json2object(jsonValue, User.class);
	 * <br>   User[] arr = JacksonUtil.json2object(jsonValue, User[].class);
	 * 
	 * @author suihonghua
	 * @param jsonValue
	 * @param classValue
	 * @return
	 * @throws Exception 
	 */
	public static <T> T json2object(String jsonValue, Class<T> valueType) throws Exception{
		if(jsonValue == null || valueType == null){
			throw new IllegalArgumentException("this argument is required; it must not be null");
		}
		return mapper.readValue(jsonValue, valueType);
	}
	/**
	 * json转对象（忽略valueType不存在的属性）
	 * @author mhj
	 *
	 * @param jsonValue
	 * @param valueType
	 * @return
	 * @throws Exception
	 */
	public static <T> T json2object(String jsonValue, Class<T> valueType,boolean ignoreUnkownPropertis) throws Exception{
		if(jsonValue == null || valueType == null){
			throw new IllegalArgumentException("this argument is required; it must not be null");
		}
		if(ignoreUnkownPropertis){
			mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		}

//       获取实体序列化配置对象
         DeserializationConfig cfg = mapper.getDeserializationConfig();
         SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
         cfg.setDateFormat(fmt);
         mapper = mapper.setDeserializationConfig(cfg);
		return mapper.readValue(jsonValue, valueType);
	}
	
	/**
	 * 将list<Object>转化成json字符串
	 * 
	 * @author mhj
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public static String list2json(List<?> list)  throws Exception {
		if(list == null){
			throw new IllegalArgumentException("this argument is required; it must not be null");
		}
		if(list.isEmpty()){
			return "";
		}
		return mapper.writeValueAsString(list);
	}
	
	/**
	 * 将json字符串转成list
	 * @param jsonValue
	 * @param typeRef
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List<?> json2List(String jsonValue, TypeReference typeRef) {
		List<?> resultArr = new ArrayList<Object>();
		try {
			if (jsonValue != null) {
				resultArr = mapper.readValue(jsonValue, typeRef);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultArr;
	}
	/**
	 * json转list 是否忽略未知字段
	 * @author mhj
	 *
	 * @param jsonValue
	 * @param typeRef
	 * @param ignoreUnkownPropertis
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static List<?> json2List(String jsonValue, TypeReference typeRef,boolean ignoreUnkownPropertis) throws Exception{
		List<?> resultArr = new ArrayList<Object>();
		if(ignoreUnkownPropertis){
			mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		}
		if (jsonValue != null) {
			resultArr = mapper.readValue(jsonValue, typeRef);
		}
		return resultArr;
	}


}
