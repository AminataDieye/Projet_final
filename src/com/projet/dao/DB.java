package com.projet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	private int ok;

	public void getConnexion()
	{
		String url = "jdbc:mysql://localhost:3306/gestion_ecole";
		String user =  "root";
		String password = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void closeConnexion(){
			try {
				if(con != null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public void initPrepare(String sql)
	{
		try {
			getConnexion();
			if(sql.toLowerCase().startsWith("insert")){
				pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			}else{
				pstm = con.prepareStatement(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int executeMAJ()
	{
		try {
			ok=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}
	public ResultSet executeSELECT()
	{
		try {
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public PreparedStatement getPstm(){
		return this.pstm;
	}
}
