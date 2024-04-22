package com.akhil.service;

import java.util.List;

import com.akhil.model.Students;

public interface IStudentService {

	public String savingData(Students student);
	public List<Students> fetchingData();
}
