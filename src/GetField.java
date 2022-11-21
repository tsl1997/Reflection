import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 反射获取属性的小Demo
 * @author HMB-XS
 * @date 2022年11月20日21:02:14
 **/
public class GetField {
	/**
	 * 获取属性使用Field 公开的
	 */
	@Test
	public void getFields(){
		// 1：获取类对象
		Class<Student> studentClass = Student.class;
		// 2：获取Field对象------>公开的 public修饰的
		Field[] fields = studentClass.getFields();
		// 3：遍历结果
		for (Field field : fields) {
			System.out.println(field);
		}
	}

	/**
	 * 获取属性使用Field 所有的
	 */
	@Test
	public void getDeclaredFields(){
		// 1：获取类对象
		Class<Student> studentClass = Student.class;
		// 2：获取Field对象------>所有的属性，包括私有的
		Field[] fields = studentClass.getDeclaredFields();
		// 3：遍历结果
		for (Field field : fields) {
			System.out.println(field);
		}
	}

	/**
	 * 根据名称获取属性  公开的
	 */
	@Test
	public void getField() throws Exception {
		// 1：获取类对象
		Class<Student> studentClass = Student.class;
		// 2：获取制定名称的属性
		Field a = studentClass.getField("a");
		// 3:打印输出
		System.out.println(a);
	}

	/**
	 * 根据名称获取属性  私有的
	 */
	@Test
	public void getDeclaredField() throws Exception {
		// 1：获取类对象
		Class<Student> studentClass = Student.class;
		// 2：获取制定名称的属性
		Field name = studentClass.getDeclaredField("name");
		// 3:打印输出
		System.out.println(name);
	}

	/**
	 * 获取属性的值和设置属性的值 公开的
	 * @throws Exception
	 */
	@Test
	public void getAndSet()throws Exception {
		// 1：获取类对象
		Class<Student> studentClass = Student.class;
		// 2：获取制定名称的属性
		Field a = studentClass.getField("a");
		// 3：创建一个对象
		Student student = new Student("韩信", 18, "刺客");
		// 4：获取属性的值 属性.get(对象)
		Object value = a.get(student);
		System.out.println(value);
		// 5：设置属性值 属性.set(对象,值)
		a.set(student,"王者荣耀");
		System.out.println(a.get(student));
	}

	/**
	 * 获取属性的值和设置属性的值 私有的
	 * @throws Exception
	 */
	@Test
	public void getAndSetPrivate()throws Exception {
		// 1：获取类对象
		Class<Student> studentClass = Student.class;
		// 2：获取制定名称的属性
		Field name = studentClass.getDeclaredField("name");
		// 3：创建一个对象
		Student student = new Student("韩信", 18, "刺客");
		// 4：破解访问权限 ==== 重点
		name.setAccessible(true);
		// 5：获取属性的值 属性.get(对象)
		Object value = name.get(student);
		System.out.println(value);
		// 6：设置属性值 属性.set(对象,值)
		name.set(student,"李白");
		System.out.println(name.get(student));
	}



}
