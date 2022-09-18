package day12;

public class MethodOverriding {

	public static void main(String[] args) {
		Developer developer = new Developer();
		developer.work(); // call developer
		
		developer = new FrontendDeveloper();
		developer.work();
		
		developer = new BackendDeveloper();
		developer.work();
	}

}

class Developer {
	public void work() {
		System.out.println("doing some work");
	}
}

class FrontendDeveloper extends Developer{
	
	@Override
	public void work() {
		System.out.println("developing with Vue.js");
	}
}

class BackendDeveloper extends Developer {
	
	@Override
	public void work() {
		System.out.println("developing with Node.js");
	}
}