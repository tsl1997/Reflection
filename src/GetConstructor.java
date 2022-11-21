import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 反射获取构造方法Demo
 * @author HMB-XS
 * @date 2022年11月20日21:27:23
 **/
public class GetConstructor {

	/**
	 * 获取构造器  所有公开的
	 */
	@Test
	public void getConstructors(){
		// 1：获取类对象
		Class<Student> studentClass = Student.class;
		// 2：获取构造器 所有公开的
		Constructor<?>[] constructors = studentClass.getConstructors();
		// 3：遍历所有构造器
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
	}

	/**
	 * 获取指定构造器  传入参数类对象
	 */
	@Test
	public void getConstructor()throws Exception {
		// 1：获取类对象
		Class<Student> studentClass = Student.class;
		// 2：获取指定构造器 参数类对象
		Constructor<Student> constructor = studentClass.getConstructor(String.class, int.class);
		// 3：通过构造器构造对象
		Student s = constructor.newInstance("李信", 19);
		System.out.println(s);
	}

	/**
	 * 获取构造器  所有(包括私有的)
	 */
	@Test
	public void getConstructorsPrivate(){
		// 1：获取类对象
		Class<Student> studentClass = Student.class;
		// 2：获取构造器 所有(包括私有的)
		Constructor<?>[] constructors = studentClass.getDeclaredConstructors();
		// 3：遍历所有构造器
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
	}

	/**
	 * 获取私有构造器  构造对象
	 */
	@Test
	public void getConstructorsPrivateNew()throws Exception {
		// 1：获取类对象
		Class<Student> studentClass = Student.class;
		// 2：获取构造器 指定私有的
		Constructor<Student> constructor = studentClass.getDeclaredConstructor(int.class);
		// 3：暴力破解权限
		constructor.setAccessible(true);
		// 4：构造对象
		Student student = constructor.newInstance(16);
		System.out.println(student.getAge());
	}


	/**
	 * 获取封闭构造器
	 */
	@Test
	public void getEnclosingConstructor()throws Exception {
		// 1：获取类对象
		Class<?> aClass = (new Student()).b.getClass();
		// 2：获取封闭构造器
		Constructor<?> constructor = aClass.getEnclosingConstructor();
		// 3：打印输出
		System.out.println(constructor);
	}

	/**
	 * 获取枚举构造器
	 */
	@Test
	public void getEnumConstants()throws Exception {
		// 1：获取类对象
		Class<StudentEnum> enumClass = StudentEnum.class;
		// 2：获取枚举构造器
		StudentEnum[] enumConstants = enumClass.getEnumConstants();
		// 3：遍历结果
		for (StudentEnum enumConstant : enumConstants) {
			System.out.println(enumConstant);
		}
	}

	/**
	 * 通过类对象构造对象   默认调用无参构造方法
	 */
	@Test
	public void newInstance()throws Exception{
		// 1：获取类对象
		Class<Student> studentClass = Student.class;
		// 2：通过类对象构造对象
		Student student = studentClass.newInstance();
		// 3：打印输出
		System.out.println(student);
	}
}
