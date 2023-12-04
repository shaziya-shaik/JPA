package com.RestFul.DemoRest;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlienRepository {
	//List<Alien> aliens;
	Connection con=null;
	public  AlienRepository()  {
//		aliens=new ArrayList<>();
//		System.out.println("hello");
//		Alien a=new Alien();
//		a.setId(101);
//		a.setName("shaziya");
//		a.setPoint(80);
//		
//		Alien a1=new Alien();
//		a1.setId(102);
//		a1.setName("begum");
//		a1.setPoint(60);
//		//List<Alien> aliens=Arrays.asList(a,a1);
//		aliens.add(a);
//		aliens.add(a1);
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restapi", "root", null);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Alien> getAliens() throws SQLException {
		List<Alien> aliens=new ArrayList<>();
		String sql="select * from alien";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			Alien a=new Alien();
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setPoint(rs.getInt(3));
			
			aliens.add(a);
			
		}
		return aliens;
	}
	
	public Alien getAlien(int id) throws SQLException {
		
		String sql="select * from alien where id="+id;
		Alien a=new Alien();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next()) {
			
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setPoint(rs.getInt(3));
		}
			
				return a;
	}

	public void create(Alien a1) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO alien (id, name, point) VALUES (?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);	
			st.setInt(1,a1.getId());
			st.setString(2,a1.getName());
			st.setInt(3,a1.getPoint());
			st.executeUpdate();	
	}
	
	public void update(Alien a1) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update alien set name=?,point=? where id=?" ;
		PreparedStatement st = con.prepareStatement(sql);	
			st.setInt(3,a1.getId());
			st.setString(1,a1.getName());
			st.setInt(2,a1.getPoint());
			st.executeUpdate();	
	}

	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from  alien  where id=?" ;
		PreparedStatement st = con.prepareStatement(sql);	
			st.setInt(1,id);
			
			st.executeUpdate();	
		
	}
	
	
	

}
