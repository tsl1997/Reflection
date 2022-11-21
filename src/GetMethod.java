import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 反射获取方法
 * @author HMB-XS
 * @date 2022年11月20日22:22:45
 **/
public class GetMethod {

	/**
	 * 获取所有公开方法
	 */
	@Test
	public void getMethods()throws Exception {
		// 1：获取类对象
		Class<Student> studentClass = Student.class;
		// 2：获取方法 所有公开的
		Method[] methods = studentClass.getMethods();
		// 3：遍历结果
		for (Method method : methods) {
			System.out.println(method);
		}
	}


	/**
	 * 获取指定名称的公开方法
	 */
	@Test
	public void getMethod()throws Exception {
		// 1：获取类对象
		Class<Student> studentClass = Student.class;
		// 2：获取指定方法 方法名 类对象
		Method setName = studentClass.getMethod("setName", String.class);
		// 3：打印方法
		System.out.println(setName);
	}

	/**
	 * 获取指定名称的公开方法   执行方法
	 */
	@Test
	public void invoke()throws Exception {
		// 1：获取类对象
		Class<Student> studentClass = Student.class;
		// 2：获取指定方法 方法名 类对象
		Method setName = studentClass.getMethod("setName", String.class);
		// 3：创建对象
		Student student = new Student("韩信", 18, "刺客");
		// 4：执行方法
		setName.invoke(student, "孙悟空");
		// 5：验证结果
		System.out.println(student.getName());
	}

	/**
	 * 获取所有方法 包括私有的
	 * 该方法会忽略Object类自带的方法
	 */
	@Test
	public void getDeclaredMethods()throws Exception {
		// 1：获取类对象
		Class<Student> studentClass = Student.class;
		// 2：获取方法 所有公开的
		Method[] methods = studentClass.getDeclaredMethods();
		// 3：遍历结果
		for (Method method : methods) {
			System.out.println(method);
		}
	}

	/**
	 * 获取指定名称的私有方法
	 */
	@Test
	public void getDeclaredMethod()throws Exception {
		// 1：获取类对象
		Class<Student> studentClass = Student.class;
		// 2：获取指定方法 方法名 类对象
		Method setA = studentClass.getDeclaredMethod("setA", String.class);
		// 3：打印方法
		System.out.println(setA);
	}

	/**
	 * 获取指定名称的私有方法   执行方法
	 */
	@Test
	public void invokePrivate()throws Exception {
		// 1：获取类对象
		Class<Student> studentClass = Student.class;
		// 2：获取指定方法 方法名 类对象
		Method setA = studentClass.getDeclaredMethod("setA", String.class);
		// 3：创建对象
		Student student = new Student("韩信", 18, "刺客");
		// 4：暴力破解权限
		setA.setAccessible(true);
		// 5：执行方法
		setA.invoke(student, "战士");
		// 6：验证结果
		System.out.println(student.a);
	}

	/**
	 * 获取封闭方法
	 */
	@Test
	public void EnclosingMethod()throws Exception {
		// 1：获取类对象
		Class<?> aClass = (new Student()).EnclosingMethod().getClass();
		// 2：获取封闭方法
		Method enclosingMethod = aClass.getEnclosingMethod();
		// 3：打印输出
		System.out.println(enclosingMethod);
	}

}
