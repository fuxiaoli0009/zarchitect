package com.zarchitect.mybatis.p01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrigJdbc {

	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	private static String DB_URL = "jdbc:mysql://39.105.142.63:3306/fuxiaoli_stock?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";
	
	private static String USER = "root";
	
	private static String PSWD = "Shenghuo2018";
	
	private static String sql = "SELECT * FROM tb_history_data LIMIT 5";
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		//步骤1.导入包：需要包含数据库编程所需的JDBC类的包。 大多数情况下，使用import java.sql.*就足够了。
		try {
			//步骤2.注册JDBC驱动:需要初始化驱动程序，以便可以程序中打开数据库的通信通道。
			Class.forName(JDBC_DRIVER);
			//步骤3.打开一个连接:需要使用DriverManager.getConnection()方法来创建一个Connection对象，它表示与数据库服务器的物理连接。
			conn = DriverManager.getConnection(DB_URL, USER, PSWD);
			//步骤4.执行查询：需要使用类型为Statement的对象来构建和提交SQL语句，以在选择的数据库的表中查询数据记录。
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			//步骤5.提取数据：执行SQL查询后，可以从表中获取记录。 
			while(rs.next()){
				System.out.println(rs.getString("code") + "-" + rs.getString("name"));
			}
			//步骤6.清理环境：需要明确地关闭所有数据库资源，而不依赖于JVM的垃圾收集。
			rs.close();
			statement.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement!=null){
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
