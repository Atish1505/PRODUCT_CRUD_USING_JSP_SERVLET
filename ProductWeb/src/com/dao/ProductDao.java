package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.MyDatabase.ConnectionProvider;
import com.model.Product;


public class ProductDao {
	public int InsertProduct(Product p)
	{
		int check=0;
		PreparedStatement pst=null;
		Connection con=null;
		con=ConnectionProvider.getConnection();
		String sql="insert into productweb(pname,ptype,pdesc,pprice) values(?,?,?,?)";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, p.getPname());
			pst.setString(2, p.getPtype());
			pst.setString(3, p.getPdesc());
			pst.setDouble(4, p.getPprice());
			check=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			new ConnectionProvider().CloseConnection(pst, con);
		}
		
		return check;
	}
	public int DeleteProductByID(int id)
	{
		int check=0;
		PreparedStatement pst=null;
		Connection con=ConnectionProvider.getConnection();
		String sql="delete from productweb where pid=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			check=pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			new ConnectionProvider().CloseConnection(pst, con);
		}
		return check;
	}
	
	public Product DisplayProductByID(int id)
	{
		Product p=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Connection con=ConnectionProvider.getConnection();
		String sql="select pid,pname,ptype,pdesc,pprice from productweb where pid=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next())
			{
				p=new Product();
				p.setPid((int)rs.getObject("pid"));
				p.setPname((String)rs.getObject("pname"));
				p.setPtype((String)rs.getObject("ptype"));
				p.setPdesc((String)rs.getObject("pdesc"));
				p.setPprice((double)rs.getObject("pprice"));
			}
				
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			new ConnectionProvider().CloseConnection(rs, pst, con);
		}
		
		return p;
	}
	
	public int UpdateProductByID(Product p)
	{
		int check=0;
		  PreparedStatement pst=null;
		  Connection con=ConnectionProvider.getConnection();
		  String sql="update productweb set pname=?,ptype=?,pdesc=?,pprice=? where pid=?";
		  try {
			pst=con.prepareStatement(sql);
			pst.setString(1, p.getPname());
			pst.setString(2, p.getPtype());
			pst.setString(3, p.getPdesc());
			pst.setDouble(4, p.getPprice());
			pst.setInt(5, p.getPid());
			check=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  finally
		  {
			  new ConnectionProvider().CloseConnection(pst, con);
		  }
		  
		return check;
	}
	
	public List<Product> DisplayAll()
	{
		List<Product> list=new ArrayList<>();
		Connection con=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select pid,pname,ptype,pdesc,pprice from productweb";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Product p=new Product();
				p.setPid((int)rs.getObject("pid"));
				p.setPname((String)rs.getObject("pname"));
				p.setPtype((String)rs.getObject("ptype"));
				p.setPdesc((String)rs.getObject("pdesc"));
				p.setPprice((double)rs.getObject("pprice"));
				
				list.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			new ConnectionProvider().CloseConnection(rs, pstmt, con);
		}
	
		return list;
	}
	

}
