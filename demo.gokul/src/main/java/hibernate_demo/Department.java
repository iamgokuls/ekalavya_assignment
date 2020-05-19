package hibernate_demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	
	@Id
	private int did;
	private String dname;
	@OneToMany
	private List<Professor> professors=new ArrayList<Professor>();
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public List<Professor> getProfessors() {
		return professors;
	}
	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}
	
	
	

}
