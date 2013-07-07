package co.longly.tools.objtools;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 针对对象字段的操作
 * 
 * @author longly
 * 
 */
public interface IPackFields {

	/**
	 * 值修改的字段
	 * 
	 * @param to
	 * @return
	 */
	List<Field> changeFields(Object from,Object to) throws IllegalArgumentException,
			IllegalAccessException;

	/**
	 * 把修改值得字段组成描述的字符串
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	String packFieldValues(Object from,Object to) throws IllegalArgumentException, IllegalAccessException;

}
