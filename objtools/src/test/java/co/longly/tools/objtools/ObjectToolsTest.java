package co.longly.tools.objtools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

/**
 * Unit test for simple App.
 */
public class ObjectToolsTest {
	@Test
	public void test1() throws IllegalArgumentException, IllegalAccessException {

		ObjectTest o1 = new ObjectTest();
		o1.setObj1("String1");
		o1.setObj2(1234L);
		List<Object> list = new ArrayList<Object>();
		list.add("a");
		list.add("b");
		o1.setObj3(list);
		
		
		ObjectTest o2 = new ObjectTest();
		o2.setObj1("String");
		o2.setObj2(123L);
		List<Object> list2 = new ArrayList<Object>();
		list2.add("aa");
		list2.add("bb");
		o2.setObj3(list2);
		
		DefaultPackFields tools = new DefaultPackFields();
		List<Field> changeFields = tools.changeFields(o1, o2);
		String changeFieldsStrs = tools.packFieldValues(o1, o2);
		

	}

}
