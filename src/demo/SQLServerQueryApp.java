package demo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 连接并使用数据库示例
 */
public class SQLServerQueryApp {		
   public static void main(String[] args) {
      ApplicationContext context = 
             new ClassPathXmlApplicationContext("Beans.xml");
      //使用jdbc
      JdbcTemplate jdbcTemplateObject = new JdbcTemplate((DataSource) context.getBean("dataSource")) ;
      String SQL = "select count(*) from dbo.[userT]";
      int rowCount = jdbcTemplateObject.queryForObject(SQL, Integer.class);
      System.out.println(rowCount);   
      
      //使用c3p0
      DataSource ds = context.getBean("dataSource2", DataSource.class);
      Connection conn;
		try {
			conn = ds.getConnection();
			 PreparedStatement pStatement = conn.prepareStatement("select * from note");
		      ResultSet resultSet =pStatement.executeQuery();
		      List<Map<String, Object>> list = new ArrayList<>();
				while (resultSet.next()) {
					Map<String, Object> map = new HashMap<>();
					ResultSetMetaData metaData = resultSet.getMetaData();
					int count = metaData.getColumnCount();
					for(int i = 1; i <= count; i++) {
						Object object = resultSet.getObject(i);
						map.put(metaData.getColumnLabel(i), object);
					}
					list.add(map);
				}
				System.out.println("查询结果："+list.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
}