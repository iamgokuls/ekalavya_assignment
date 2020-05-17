package hibernate_demo;



public class MainApp {

	public static void main(String[] args) {
		 
		 StudentDao sd=new StudentDao();
		 
		 
		 sd.insertOp(109,"Arya",3,20,"9631028457","arya@asdf.com"); //INSERT operation
		 
		 sd.updateOp(109,"aryas@asdf.com");							//update operatioin
		 
		 sd.deleteOp(109);											//deletion operatioin
		 
		 sd.selectOp();												//selection operation
		 
		 System.out.println("Operations are completed");

	}

}
