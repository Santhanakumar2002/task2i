package jdbc.demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class db {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(" com.mysql.jdbc.Driver ");

		Connection connection = DriverManager.getConnection("jdbc:dbms://101.53.155.156:3306/dbms_april_2023","dbms_april_2023", "Ebrain@20");

		return connection;
	}

	public static void saveVendor(String vendor_name, String vendor_email, Integer phone, String address)
			throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tb_sk_vendor( vendor_name,vendor_email,phone,address) VALUES(?,?,?,?) ");
		preparedStatement.setString(1, vendor_name);
		preparedStatement.setString(2, vendor_email);
		preparedStatement.setInt(3, phone);
		preparedStatement.setString(4, address);
		preparedStatement.executeUpdate();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Connection connection = getConnection();
//		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tb_sk_vendor( vendor_name,vendor_email,phone,address) VALUES(?,?,?,?) ");
//ResultSet resultSet=preparedStatement.executeQuery();
//while(resultSet.next()) {
//	
//}
		saveVendor("ranjithkumar", "ranjithkumar10@gmail.com", 8988964, "maharajapuram, watrap");
		System.out.println("complete succesfully.....");
	}

}
