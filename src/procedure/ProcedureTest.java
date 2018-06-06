package procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProcedureTest {
	Connection con;
	Statement state;
	ResultSet rs;
	CallableStatement cs;// 调用存储过程使用的接口
	String url = "jdbc:microsoft:sqlserver://localhost:1433; DatabaseName=test";
	String user = "sa";
	String password = "";

	public void connectSQL() {

		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();

			// 创建存储过程SQL语句
			String createProcedure = " create procedure SHOW_SUPPLIERS "
					+ "as " + " select SUPPLIERS.SUP_NAME,COFFEES.COF_NAME "
					+ "from suppliers,coffees"
					+ "where suppliers.sup_id = coffees.sup_id "
					+ "order by sup_name";
			// 创建存储过程
			state.executeUpdate("USE TEST");
			state.executeUpdate(createProcedure);

			// 调用存储过程
			cs = con.prepareCall("{call SHOW_SUPPLIERS}");// 创建一个
															// CallableStatement
															// 对象来调用数据库存储过程
			// 返回调用的结果集
			rs = cs.executeQuery();

			// 输出结果
			System.out.println("SUPPLIERS.SUP_NAME COFFEES.COF_NAME");
			while (rs.next()) {
				String sup_name = rs.getString(1);
				String coffees_name = rs.getString(2);
				System.out.println(sup_name + " " + coffees_name);
			}
			con.close();
			state.close();
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ProcedureTest().connectSQL();
	}

}
