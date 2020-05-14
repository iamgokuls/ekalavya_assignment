package assignmentSpring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class ClientApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		Triangle t1=(Triangle) context.getBean("Triangle");
		
		System.out.println("Details:\n"+t1);
		
		Circle c1=(Circle) context.getBean("Circle");
		
		c1.draw();
		
		Line L1=(Line) context.getBean("Line");
		
		L1.draw();

	}

}
