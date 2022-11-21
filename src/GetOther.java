import org.junit.Test;

import java.lang.annotation.Annotation;
import java.net.URL;

/**
 * 反射获取其他的demo
 * @author HMB-XS
 * @date 2022年11月20日22:56:47
 **/
public class GetOther {
	// 1：获取类对象
	public  Class<Student> studentClass = Student.class;

	@Test
	public void getAnnotations(){
		// 获取所有的注释
		Annotation[] annotations = studentClass.getAnnotations();
		int length = annotations.length;
		System.out.println(length);
	}

	@Test
	public void desiredAssertionStatus(){
		// 获取该类的断言状态
		boolean b = studentClass.desiredAssertionStatus();
		System.out.println(b);
	}

	@Test
	public void otherMethod(){
		// 获取名称
		String name = studentClass.getName();
		// 获取标准类名
		String canonicalName = studentClass.getCanonicalName();
		// 获取包名
		Package aPackage = studentClass.getPackage();
		// 获取类名
		String typeName = studentClass.getTypeName();
		// 判断是否是数组
		boolean array = studentClass.isArray();
		// 判断是否是枚举
		boolean anEnum = studentClass.isEnum();
		// 判断是否是匿名类
		boolean anonymousClass = studentClass.isAnonymousClass();
		// 判断是否是内部类
		boolean localClass = studentClass.isLocalClass();
		// 判断是否是成员类
		boolean memberClass = studentClass.isMemberClass();
		// 打印输出
		System.out.println("getName ===>"+name);
		System.out.println("getCanonicalName ===>"+canonicalName);
		System.out.println("getPackage ===>"+aPackage);
		System.out.println("getTypeName ===>"+typeName);
		System.out.println("isArray ===> "+array);
		System.out.println("isEnum ===>"+anEnum);
		System.out.println("isAnonymousClass ===>"+anonymousClass);
		System.out.println("isLocalClass ===>"+localClass);
		System.out.println("isMemberClass ===>"+memberClass);
	}

	/**
	 * 通过类对象判断是否为数组
	 * 因为可以通过对象获取类对象，对象可以是一个类的实例，也可以是数组
	 */
	@Test
	public void isArray(){
		// 1：创建一个对象数组
		Student[] s = new Student[5];
		// 2：获取类对象
		Class<? extends Student[]> aClass = s.getClass();
		//:3：判断是否为数组
		boolean array = aClass.isArray();
		//:4：打印结果
		System.out.println(array);
	}

	/**
	 * 通过类对象判断是否为枚举
	 */
	@Test
	public void isEnum()throws Exception {
		// 1：获取类对象
		Class<StudentEnum> enumClass = StudentEnum.class;
		// 2：判断是否为枚举
		boolean anEnum = enumClass.isEnum();
		// 3：打印结果
		System.out.println(anEnum);
	}


}
