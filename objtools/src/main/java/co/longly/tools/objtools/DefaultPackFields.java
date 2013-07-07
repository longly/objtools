package co.longly.tools.objtools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.mozilla.javascript.ContinuationPending;

/**
 * Hello world!
 * 
 */
public class DefaultPackFields extends AbstractPackFields {

	/**
	 * 组装属性值的语句
	 * 
	 */
	public String packFieldValues(Object from, Object to)
			throws IllegalArgumentException, IllegalAccessException {
		List<Field> fields = changeFields(from, to);
		StringBuilder sb = new StringBuilder();
		for (Field f : fields) {
			Object object = f.get(from);
			Object object2 = f.get(to);
			Note note = f.getAnnotation(Note.class);
			String value = note.value();
			sb.append("字段").append(value).append("原值：")
					.append(object.toString()).append("改为：")
					.append(object2.toString()).append(";");
		}
		if (sb.length() > 0) {
			return sb.substring(0, sb.length() - 1);
		}
		return sb.toString();
	}

}
