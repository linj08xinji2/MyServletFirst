package sqldemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTest {

    public static void main(String[] args) {
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
//        String url = "jdbc:mysql://localhost:3306/mysql";
        // mycat 
        String url = "jdbc:mysql://172.28.171.134:8066/TESTDB";
        //MySQL配置时的用户名
        String user = "test";
        //MySQL配置时的密码
        String password = "test";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
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
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sb.toString());
            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");  
             
            String sources = null;
            String id = null;
            String servicesid = null;
            String customerroomname = null;
            while(rs.next()){
            	id = rs.getString("id");
            	sources = rs.getString("sources");
            	servicesid = rs.getString("servicesid");
            	customerroomname = rs.getString("customerroomname");
                //输出结果
                System.out.println(id + "\t" + sources+"\t"
                + servicesid+"\t" + customerroomname);
            }
            rs.close();
            con.close();
        } catch(ClassNotFoundException e) {   
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
        }
    }

}