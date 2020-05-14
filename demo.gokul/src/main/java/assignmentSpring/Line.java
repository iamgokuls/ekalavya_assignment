package assignmentSpring;

import java.util.ArrayList;
import java.util.List;

public class Line {
	
	List<Point> endpoints=new ArrayList<Point>();
	
	Line(){
		
		System.out.println("Line created");
	}

	public Line(List<Point> endpoints) {
		super();
		this.endpoints = endpoints;
	}

	public List<Point> getEndpoints() {
		return endpoints;
	}

	public void setEndpoints(List<Point> endpoints) {
		this.endpoints = endpoints;
	}
	
	public void draw() {
		
		System.out.println("End points are:");
		for(Point point:this.endpoints) {
			System.out.println(point);
		}
	}

}
