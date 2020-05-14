package assignmentSpring;

import org.springframework.beans.factory.annotation.Autowired;


public class Circle {
	private Point center;
	
	Circle(){
		System.out.println("Circle created");
	}

	public Circle(Point center) {
		
		this.center = center;
	}

	public Point getCenter() {
		return center;
	}

   // use of annotation	
	@Autowired
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public void draw() {
		
		System.out.println("Circle centerd on "+this.center);
	}

}
