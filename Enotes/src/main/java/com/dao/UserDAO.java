package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.user.UserDetails;

public class UserDAO {

	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addUser(UserDetails us)
	{
		boolean f=false;
		try
		{
			String query="insert into user(name,email,password) values(?,?,?)";
			
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,us.getName());
			ps.setString(2,us.getEmail());
			ps.setString(3,us.getPassword());
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return f;
	}
	public UserDetails loginUser(UserDetails us)
	{
		UserDetails user = null;
		String query="select * from  user where email=? and password=?";

		try
		{
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,us.getEmail());
			ps.setString(2,us.getPassword());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				user =new UserDetails();
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setId(Integer.parseInt(rs.getString("id")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	
}