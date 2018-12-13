package sqldemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTest {

    public static void main(String[] args) {
        //����Connection����
        Connection con;
        //����������
        String driver = "com.mysql.jdbc.Driver";
        //URLָ��Ҫ���ʵ����ݿ���mydata
//        String url = "jdbc:mysql://localhost:3306/mysql";
        // mycat 
        String url = "jdbc:mysql://172.28.171.134:8066/TESTDB";
        //MySQL����ʱ���û���
        String user = "test";
        //MySQL����ʱ������
        String password = "test";
        //������ѯ�����
        try {
            //������������
            Class.forName(driver);
            //1.getConnection()����������MySQL���ݿ⣡��
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.����statement���������ִ��SQL��䣡��
            Statement statement = con.createStatement();
            //Ҫִ�е�SQL���
//            String sql = "select * from item ";
            StringBuilder sb=new StringBuilder();
            sb.append("  select top 2 SS.ID, ");
            sb.append(" ss.sources ,ss.servicesid , ");
            sb.append(" ss.customerroomname ");
            sb.append(" from SR_Services ss ");
            sb.append(" left join SR_Feedback sf  on sf.ServiceID=ss.id ");
            sb.append(" left join SR_ServiceType sst on sst.ServiceTypeID=ss.servicetypeid ");
            sb.append(" left join SR_ServiceType sstb on sstb.servicetypeid=sst.FatherID ");
            sb.append(" left join System_ParamValue b on  b.ParamValue=sf.Satisfaction ");
            sb.append(" where sst.StyleID in ('W','J','K','8')   ");
            sb.append("  and ss.id in ('12695','548') ");
            //3.ResultSet�࣬������Ż�ȡ�Ľ��������
            ResultSet rs = statement.executeQuery(sb.toString());
            System.out.println("-----------------");
            System.out.println("ִ�н��������ʾ:");  
             
            String sources = null;
            String id = null;
            String servicesid = null;
            String customerroomname = null;
            while(rs.next()){
            	id = rs.getString("id");
            	sources = rs.getString("sources");
            	servicesid = rs.getString("servicesid");
            	customerroomname = rs.getString("customerroomname");
                //������
                System.out.println(id + "\t" + sources+"\t"
                + servicesid+"\t" + customerroomname);
            }
            rs.close();
            con.close();
        } catch(ClassNotFoundException e) {   
            //���ݿ��������쳣����
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //���ݿ�����ʧ���쳣����
            e.printStackTrace();  
            }catch (Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println("���ݿ����ݳɹ���ȡ����");
        }
    }

}