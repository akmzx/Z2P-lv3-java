package assignment3;

public class Student implements Comparable<Student>{
	
	private int rollno;
	private String name;
	private int age;
	
	public Student(int rollno, String name, int age) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
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

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	  public int compareTo(Student otherStudent)
    {
        return Integer.compare(getRollno(), otherStudent.getRollno());
    }
}

