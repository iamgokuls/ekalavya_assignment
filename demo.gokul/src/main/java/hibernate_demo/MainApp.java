package hibernate_demo;



public class MainApp {

	public static void main(String[] args) {
		 
		 StudentDao sd=new StudentDao();
		 System.out.println("successful");
		 
		 sd.insertOp(109,"Arya",3,20,"9631028457","arya@asdf.com");
		 
		 System.out.println("Operations are completed");

	}

}
