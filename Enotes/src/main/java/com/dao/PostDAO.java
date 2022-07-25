package com.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.user.Post;
import com.user.UserDetails;

public class PostDAO {
	private Connection conn;

	public PostDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean AddNotes(String ti, String co, int id) {

		try {
			String query = "insert into post(uid,title,content) values (?,?,?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, ti);
			ps.setString(3, co);

			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			}
			System.out.print(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public List<Post> getData(int id) {

		List<Post> list = new ArrayList<Post>();
		Post po = new Post();
		try {
			String qu = "select * from post where uid=?";
			PreparedStatement ps = conn.prepareStatement(qu);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				po=new Post();
				po.setId(rs.getInt(1));
				po.setTitle(rs.getString(2));
				po.setContent(rs.getString(3));
				po.setPdate(rs.getTimestamp(4));
				list.add(po);
			}
		} catch (Exception e) {

		}
		return list;

	}
	public Post getDataById(int id)
	{
		Post po=null;
		try
		{
			String query="Select * from post where id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				po=new Post();
				po.setId(rs.getInt(1));
				po.setTitle(rs.getString(2));
				po.setContent(rs.getString(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return po;
	}
	public boolean deleteNote(int pid)
	{
		boolean f=false;
		try
		{
			String qu="delete from post where id=?";
			
			PreparedStatement ps=conn.prepareStatement(qu);
			ps.setInt(1,pid);
			ps.execute();
			f=true;
		}
		catch(Exception e)
		{
			
		}
		return f;
	}
	public boolean PostUpdateMethod(int id,String title,String content)
	{
		boolean f=false;
		try
		{
			String querry="update post set title=?,content=? where id=?";
			PreparedStatement ps=conn.prepareStatement(querry);
			ps.setString(1,title);
			ps.setString(2,content);
			ps.setInt(3, id);
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
						
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}

}
