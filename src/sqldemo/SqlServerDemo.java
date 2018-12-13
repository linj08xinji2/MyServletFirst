package sqldemo;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SqlServerDemo {

	public static void main(String[] args) {
			try {
				//������������
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				//�������ݿ�����
				String url = "jdbc:sqlserver://172.28.171.150\\MSSQLSERVERV1;databaseName=WyglDBV1";
				Connection conn = DriverManager.getConnection(url, "sa", "123456a!1");
				//�������������ִ��sql���
				Statement stmt = conn.createStatement();
				//ִ��SQL���
				String sql = "select TOP 2  ID,SERVICEID,NCID from SR_Repair";
				ResultSet rs = stmt.executeQuery(sql);
				//ʹ�ý�� rs
				
				while(rs.next()){
					String mname = rs.getString("ID");
					String price = rs.getString("NCID");
					System.out.println("���ƣ�"+mname+"\t�۸�"+price);
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
