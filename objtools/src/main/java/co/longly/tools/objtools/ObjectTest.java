package co.longly.tools.objtools;

import java.util.Collection;

import lombok.Data;

@Data
public class ObjectTest {
	@Note(value="字段1")
	private String obj1;
	@Note(value="字段2")
	private Long obj2;

	@Note(value="字段3")
	private Collection<Object> obj3;

}
