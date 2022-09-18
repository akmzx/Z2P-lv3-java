package day13.abstraction;

public class Demo {

	public static void main(String[] args) {
//		OnClickListener obj = new onClickListener();
		var btn1 = new Button("btn-login");
		var btn2 = new Button("btn-cancel");
		
		btn1.display();
		btn1.onClick();
		btn1.onDoubleClick();
		System.out.println("-------------");
		btn2.display();
		btn2.onClick();
		btn2.onDoubleClick();
	}
}
