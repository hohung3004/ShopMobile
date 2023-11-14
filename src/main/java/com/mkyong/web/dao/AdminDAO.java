package com.mkyong.web.dao;

import java.util.List;

import com.mkyong.web.entities.Admin;

public interface AdminDAO {
	public List<Admin> loginAmin(String email, String password); 
}
