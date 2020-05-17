package hibernate_demo;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	private int sid;
	private String sname;
	private int sem;
	private int age;
	private String mobile;
	private String email;
	
	Student(){}
	
	
	
	public Student(int sid, String sname, int sem, int age, String mobile, String email) {
		
		this.sid = sid;
		this.sname = sname;
		this.sem = sem;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
	}



	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}