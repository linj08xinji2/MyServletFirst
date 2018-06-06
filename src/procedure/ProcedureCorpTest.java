package procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcedureCorpTest {

	public static void main(String[] args) {
		try {
	          DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
	          Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.9.18:1521:hdwydb", "hddc_wy", "Hddc_Wy_002");

	          CallableStatement stmt = conn.prepareCall("BEGIN recepaypro(?); END;");
	          //CallableStatement stmt = conn.prepareCall("{ call GETCITY(?, ?) }");  //用此调用方法不能实现多行语法

//	          stmt.setString(1, "021");
	          stmt.registerOutParameter(1, -10 /* OracleTypes.CURSOR = -10 */); //REF CURSOR(OracleTypes.CURSOR==-10)
	          stmt.execute();
	          ResultSet rs = (ResultSet) stmt.getObject(1);
	          while (rs.next()) {
	            System.out.println(rs.getString("docname")+"  ::  "+rs.getString("unitname")+": "+
	          rs.getString("SUM(DQYZYJ)")+" :"+rs.getString("SUM(LSYZYJ)"));
	          }
	          rs.close();
	          rs = null;
	          stmt.close();
	          stmt = null;
	          conn.close();
	          conn = null;
	        }
	        catch (SQLException e) {
	          System.out.println(e.getLocalizedMessage());
	        }

	}

}
