package com.zhuhao.mysql.mysqlnote;
/**
 * JDBC：
	java操作数据库。jdbc是oracle公司指定的一套规范(一套接口)
	驱动：jdbc的实现类，由数据库厂商提供。
	我们就可以通过一套规范操作不同的数据库(多态)
	jsbc作用：
		连接数据库
		发送sql语句
		处理结果

	JDBC操作步骤：
		1.创建数据库和表
		2.创建一个项目
		3.导入驱动jar包
			mysql-connector-java-8.0.11.jar
		4.编码：
			1.注册驱动
				Class.forName("com.mysql.jdbc.Driver");
			2.获取连接  //mysql 8.0 版本需要加 Timezon 时区配置
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybase?serverTimezone=UTC", "root", "0511");
			3.编写sql
				String sql="select * from product";
			4.创建一个预编译的语句执行者
				PreparedStatement pst = conn.prepareStatement(sql);
			5.设置参数
				pst.setObject(占位序号, "值");
			6.执行sql语句
				查询：ResultSet rs = pst.executeQuery();
				插入删除更新：int i = st.executeUpdate();
			7.处理结果
				rs.getString("字段名")
			8.释放资源
				rs.close();
				st.close();
				conn.close();

	jdbc-api详解：
		所有的包，都是java.sql或者javax.sql下的
		DriverManager：管理了一组jdbc的操作类
			常用方法：
				了解：注册驱动
					static void registerDriver(Driver driver)
					Driver：java.sql下的接口
					通过查看com.mysql.jdbc.Driver的源码，发现驱动被注册了两次。所以我们只需要将其中的静态块执行一次即可。
					只需要将类加载到内存中即可：
						方式1：
							Class.forName("全限定名");//包名+类名
						方式2：
							类名.class;
						方式3：
							对象.getClass();

				掌握：获取连接
					static Connection getConnection(String url,String user,String password)
						参数1：
							协议:数据库类型:子协议 参数
							mysql：jdbc:mysql://localhost:3306/数据库名称?serverTimezone=UTC
							oracle：jdbc:oracle:thin@localhost:1521@实例
						参数2：
							账户名称
						参数3：
							账户密码

		Connection：连接 接口
			常用方法：
				获取语句执行者：
					Statement createStatement()：获取普通的语句执行者 会出现sql注入
					PreparedStatement prepareStatement(String sql)：获取预编译语句执行者
					CallableStatement prepareCall(String sql)：获取调用存储过程的语句执行者

				事务相关：
					setAutoCommit(false)：手动开启事务
					commit()：提交事务
					rollback()：事务回滚

		Statement：语句执行者 接口
		PreparedStatement：预编译语句执行者 接口
			常用方法：
				设置参数：setObject(int 第几个占位 ,Object 实际参数);
				执行sql：
					ResultSet excuteQuery();执行查询语句
					int executeUpdate();执行增加删除更新语句

		ResultSet：结果集 接口
			执行查询语句之后返回的结果
				常用方法：
					bollean next();判断是否有下一条语句，若有返回true并将光标移至下一行，否则返回false
					getObject(int|String)
						若参数为int：第几列
						若参数为string：列名(字段名)

	常见的配置文件格式：
		1.properties
			内容格式 key-value
		2.xml
	若我们的配置文件为properties，并且放在src目录下，我们可以通过ResourceBundle工具类快速获取里面的配置数据
		使用步骤：
			1.获取ResourceBundle对象：
				static ResourceBundle getBundle("文件名称不带后缀名");
			2.通过ResourceBundle对象获取配置信息
				String getString(String key);
	若在其他目录
		使用步骤：
			1.IO流读取配置文件
				FileReader r = new FileReader("文件路径带后缀名");
			2.创建集合对象
				Properties pro = new Properties();
			3.调用集合方法load，传递流对象
				pro.load(r);
				r.close();
			4.获取配置信息
				pro.getProperty(String key);
 *
 *
 * @author junki
 * @date 2019年5月13日
 */
public class NoteJDBC {
}
