package com.cg.balance.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.balance.DbUtil.DbUtil;
import com.cg.balance.exception.BalanceException;
import com.cg.bean.BalanceInfo;


public class BalanceDAOImpl implements IBalanceDAO{
	Connection conn=null;
public int insert(BalanceInfo bean) throws BalanceException{
		
		int row=0;
		int value=0;
		try{
			conn=DbUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into user_data values(?,?,transac_id.nextval)");
			
			ps.setInt(1,bean.getAccid());
			ps.setInt(2,bean.getAmount());
			ps.setInt(3,bean.getAmount());
			
			
			row=ps.executeUpdate();
		}
			
		catch(SQLException e)
		{
			//System.out.println(e.getMessage());
			throw new BalanceException("ERROR:" +e.getMessage());
		}
		return row;
}

	
		

	
	public ArrayList<Integer> retrieveId() throws BalanceException{
		ArrayList<Integer> list=new ArrayList<Integer>();
		try
		{
		conn=DbUtil.getConnection();
		String sl="Select accid from account_details";
		
		
		Statement stmt=conn.createStatement();
		
		ResultSet rs=stmt.executeQuery(sl);
		while(rs.next())
		{
			
			list.add(rs.getInt(1));
		}
		System.out.println(list);
	}
	catch(SQLException e)
	{
	
		///=System.out.println(e.getMessage());
		throw new BalanceException("ERROR:" +e.getMessage());
	}
	return list;
	}

}
