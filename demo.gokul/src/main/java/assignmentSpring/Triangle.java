package assignmentSpring;

public class Triangle {
	
	private Point PointA;
	private Point PointB;
	private Point PointC;
	
	Triangle(){
		
	}
	
	
	Triangle(Point pointA, Point pointB, Point pointC) {
		
		this.PointA = pointA;
		this.PointB = pointB;
		this.PointC = pointC;
	}
	
	
	public Point getPointA() {
		return PointA;
	}
	public void setPointA(Point pointA) {
		this.PointA = pointA;
	}
	public Point getPointB() {
		return PointB;
	}
	public void setPointB(Point pointB) {
		this.PointB = pointB;
	}
	public Point getPointC() {
		return PointC;
	}
	public void setPointC(Point pointC) {
		this.PointC = pointC;
	}


	@Override
	public String toString() {
		return "Triangle [PointA=" + PointA + ", PointB=" + PointB + ", PointC=" + PointC + "]";
	}
	
	
	
}
