package co.longly.tools.objtools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 
 * 判断属性值的变化，同时子类实现句子的描述
 * 
 * @author longly
 * 
 */
public abstract class AbstractPackFields implements IPackFields {

	/**
	 *列举改变了属性值得字段
	 */
	@SuppressWarnings("unchecked")
	public List<Field> changeFields(Object first, Object second)
			throws IllegalArgumentException, IllegalAccessException {

		if (first == null) {
			throw new IllegalArgumentException("First argument is null");
		}

		if (first.equals(second)) {
			return ListUtils.EMPTY_LIST;
		}

		if (second == null) {
			throw new IllegalArgumentException("Second argument is null");
		}

		Class<? extends Object> class1 = first.getClass();
		Class<? extends Object> class2 = second.getClass();
		if (class1 != class2) {
			throw new IllegalArgumentException(
					"First and second arguments is not the same Class's object,please check.");
		}

		Field[] fields = class1.getDeclaredFields();

		List<Field> list = listFileds(first, second, fields);
		return list;
	}

	private List<Field> listFileds(Object first, Object second, Field[] fields)
			throws IllegalAccessException {
		List<Field> list = new ArrayList<Field>();
		for (Field f : fields) {
			if (!f.isAnnotationPresent(Note.class)) {
				continue;
			}

			Note noteAnnotation = f.getAnnotation(Note.class);
			if (!noteAnnotation.isInclude()) {
				continue;
			}
			String value = noteAnnotation.value();
			if (StringUtils.isEmpty(value)) {
				value = " ";
			}
			if (!f.isAccessible()) {
				f.setAccessible(true);
			}
			if (f.get(first).equals(f.get(second))) {
				continue;
			}
			list.add(f);
		}
		return list;
	}

	public abstract String packFieldValues(Object from, Object to)
			throws IllegalArgumentException, IllegalAccessException;

}
