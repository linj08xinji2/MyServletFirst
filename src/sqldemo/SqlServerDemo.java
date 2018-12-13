package sqldemo;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SqlServerDemo {

	public static void main(String[] args) {
			try {
				//加载驱动程序
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				//建立数据库连接
				String url = "jdbc:sqlserver://172.28.171.150\\MSSQLSERVERV1;databaseName=WyglDBV1";
				Connection conn = DriverManager.getConnection(url, "sa", "123456a!1");
				//创建域对象，用于执行sql语句
				Statement stmt = conn.createStatement();
				//执行SQL语句
				String sql = "select TOP 2  ID,SERVICEID,NCID from SR_Repair";
				ResultSet rs = stmt.executeQuery(sql);
				//使用结果 rs
				
				while(rs.next()){
					String mname = rs.getString("ID");
					String price = rs.getString("NCID");
					System.out.println("名称："+mname+"\t价格："+price);
				}
				rs.close();
				stmt.close();
				conn.close();
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}

}
