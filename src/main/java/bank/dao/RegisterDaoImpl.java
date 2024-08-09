package bank.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import bank.model.Login;
import bank.model.Register;

public class RegisterDaoImpl implements RegisterDao{


	public int createRecord(List<Register> reglst) {
		int i=0;
		Connection con=DBConnection.myConnection();
		Register eobj=reglst.get(0);

		try {
			PreparedStatement p = con.prepareStatement("insert into crudBank values(?,?,?,?,?)");
			p.setInt(1, eobj.getAccNo());
			p.setString(2, eobj.getfName());
			p.setString(3, eobj.getuName());
			p.setString(4, eobj.getPassword());
			p.setFloat(5, eobj.getAccBal());
			i=p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public int deleteRecord(int accNo) {
		Connection con=DBConnection.myConnection();
		int i=0;
		try {
			PreparedStatement p=con.prepareStatement("delete from crudBank where acc_num=?");
			p.setInt(1, accNo);
			i=p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateRecord(List<Register> reglst) {
	    Connection con = DBConnection.myConnection();
	    int i = 0;
	    for (Register r : reglst) {
	        try {
	            PreparedStatement p = con.prepareStatement("update crudBank set u_name=? where acc_num=?");
	            p.setString(1, r.getuName());
	            p.setInt(2, r.getAccNo());
	            i += p.executeUpdate(); // Use += to accumulate the total updates
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return i;
	}

	@Override
	public List<Register> retriveRecord(int accNo) {
	    System.out.println("dao1");

		Connection con=DBConnection.myConnection();
		List<Register> rlst=null;

		try {
			PreparedStatement p=con.prepareStatement("select * from crudBank where acc_num=?");
			p.setInt(1, accNo);
			ResultSet r=p.executeQuery();
		    System.out.println("dao2");

			if(r.next()) {
				int accNo1=r.getInt(1);
				String accFname=r.getString(2);
				String accUname=r.getString(3);
				String accPass=r.getString(4);
				float accBal=r.getFloat(5);

				Register robj=new Register(accNo1, accFname, accUname, accPass, accBal);
				rlst=new LinkedList<Register>();
				rlst.add(robj);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rlst;
	}

	@Override
	public List<Register> displayAll() {
		System.out.println("test1");

		Connection con=DBConnection.myConnection();
		ResultSet r=null;
		List<Register> rlst=new LinkedList<Register>();
		String str="select * from crudBank";
		System.out.println("test2");
		try {
			Statement s=con.createStatement();
			r=s.executeQuery(str);

			while(r.next()) {
				Register robj=new Register(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getFloat(5));
				rlst.add(robj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("test3");

		return rlst;
	}

	/*
	 * public boolean validation(List<Login> lst) { boolean b=false;
	 * 
	 * Connection con=DBConnection.myConnection(); Login lobj=lst.get(0);
	 * 
	 * try { PreparedStatement
	 * p=con.prepareStatement("select * from crudbank where u_name=? and password=?"
	 * ); p.setString(1, lobj.getuName()); p.setString(2, lobj.getPassword());
	 * ResultSet r=p.executeQuery();
	 * 
	 * if(r.next()) { b=true; } } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * return b; }
	 */
	public boolean validateLogin(Login login) {
	    if (login == null) {
	        throw new IllegalArgumentException("Login object cannot be null");
	    }

	    try (Connection connection = DBConnection.myConnection()) {
	        System.out.println("Database connection established");

	        PreparedStatement statement = connection.prepareStatement("SELECT * FROM crudbank WHERE u_name = ? AND password = ?");
	        statement.setString(1, login.getuName());
	        statement.setString(2, login.getPassword());

	        System.out.println("uName: " + login.getuName());
	        System.out.println("password: " + login.getPassword());

	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                System.out.println("Login credentials are valid");
	                return true;
	            } else {
	                System.out.println("Login credentials are invalid");
	                return false;
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Error validating login: " + e.getMessage());
	        return false;
	    }
	}
}
