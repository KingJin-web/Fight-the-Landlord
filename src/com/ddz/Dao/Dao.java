package com.ddz.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.ddz.model.His_Ach;
import com.ddz.model.User;





public class Dao {

	
	protected static String dbClassName = "com.mysql.cj.jdbc.Driver";
	protected static String dbUrl = "jdbc:mysql://localhost:3306/ddz?serverTimezone=UTC&characterEncoding=utf-8";
			
		//	"jdbc:mysql://localhost:3306/db_library";
			
	protected static String dbUser = "root";
	protected static String dbPwd = "100864";
	protected static String second = null;
	private static Connection conn = null;
	private Dao() {
		try {
			if (conn == null) {
				Class.forName(dbClassName);//.newInstance()
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
			}
			else {
				return;
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}

	}
	public static User check(String username,String password) {
		int i = 0;
		User user=new User();
		String sql = "select *  from user where username='" + username
				+ "' and password='" + password+"'" ;
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				String names = rs.getString(1);
				
				
				user.setName(rs.getString("username"));
				user.setMoney(rs.getInt("money"));
				
				user.setPassword(rs.getString("password"));
				if (names != null) {
					i = 1;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return user;
	}
	
	private static ResultSet executeQuery(String sql) {
		try {
			if(conn==null)
			new Dao();
			return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}
	public static int executeUpdate(String sql) {
		
		try {
			if(conn==null)
				new Dao();
			return conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
				
			return -1;
		} finally {
		}
	}

	public static List selectHis_ach(String username){
		List list=new ArrayList();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String sql="select  result ,time from his_ach where name ='"+username+"'";
		System.out.print(sql);
		ResultSet s=Dao.executeQuery(sql);
		try {
			while(s.next()){
				His_Ach his=new His_Ach();
				his.setResult(s.getString("result"));
				his.setTime(new String ( df.format(s.getDate("time"))));
				
				list.add(his);
			}
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return list;
		
		
	}
	public static int addUser(String username,String password) {
		int i=0;
		
		try{
			String sql = "insert into user values('"+username+"','"+password+"',0)";
		    i=Dao.executeUpdate(sql);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return i;
		
	}
	
	public static void close() {
		try {
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn = null;
		}
	}
}
