package com.mvc_assignment.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mvc_assignment.dao.StudentDao;
import com.mvc_assignment.dto.StudentDto;
import com.mvc_assignment.util.TotalMarkRequest;
import com.mvc_assignment.util.TotalMarkResponse;


@Service
public class StudentService {
	
	@Autowired
	StudentDao s;

	
	public List<StudentDto> getStudents() {
		
		return s.getStudents();
	}
	
	public StudentDto fetchStudent(String id) {
		return s.fetchStudent(id);
	}
	
	public TotalMarkResponse calculate_total(TotalMarkRequest totalmarkrequest)	{
		
		StudentDto student=s.fetchStudent(totalmarkrequest.getId());
		TotalMarkResponse totalmarkresponse=new TotalMarkResponse();
		
		if(student == null) {
			totalmarkresponse.setMessage("No such student exists");
		}
		
		else {
			totalmarkresponse.setId(student.getId());
			totalmarkresponse.setName(student.getName());
			totalmarkresponse.setTotal(student.getChemistry()+student.getPhysics()+student.getMaths());
			totalmarkresponse.setMessage("Success");
		}
		
		
		
		return totalmarkresponse;
		
	}
	
	

}
