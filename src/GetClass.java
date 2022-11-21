import org.junit.Test;

/**
 * 获取类对象的三种方式
 * @author HMB-XS
 * @date 2022年11月19日14:30:42
 **/
public class GetClass {
	// 获取Class对象的方法一 Class.froName(限定名)
	@Test
	public void test() throws Exception {
		Class<?> s = Class.forName("Student");
		System.out.println(s);
	}

	// 获取Class对象的方法二  类名.class
	@Test
	public void test1() throws Exception {
		Class<Student> s = Student.class;
		System.out.println(s);
	}

	// 获取Class对象的方法三  对象.getClass()
	@Test
	public void test2() throws Exception {
		Student student = new Student();
		Class<? extends Student> s = student.getClass();
		System.out.println(s);
	}


}
