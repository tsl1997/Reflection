import org.junit.Test;

/**
 * @author HMB-XS
 * @date 2022年11月19日14:31:14
 **/
public class Student {
	// 姓名
	private String name;
	/**
	 * 年龄
	 */
	private  int age;

	public String a;

	public Object b;

	public Student() {
		class GirlStudent{};
		b = new GirlStudent();
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Student(String name, int age, String a) {
		this.name = name;
		this.age = age;
		this.a = a;
	}

	private Student(int age){
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private void setA(String a){
		this.a = a;
	}

	public Object EnclosingMethod(){
		class  BoyStudent{};
		return  new BoyStudent();
	}

}
