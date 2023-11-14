package com.mkyong.web.dao;

import java.util.List;

import com.mkyong.web.entities.Users;

public interface UsersDAO {
	public List<Users> getUsers();
	public boolean insertUser (Users u);
	public List<Users> login(String email, String password);
}
