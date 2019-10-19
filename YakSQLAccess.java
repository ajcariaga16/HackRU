import java.sql.*;
import java.util.ArrayList;

public class YakSQLAccess {
	private String url;
	private String user;
	private String password;
	
	private YakSQLAccess(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	private int[][] copyArray(int[][] newarray, int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < 5; j++) {
				newarray[i][j] = array[i][j];
			}
		}
		return newarray;
	}
	
	public int[][] getYakData(int numOfCols) {
		int[][] array = new int[100][5];
		try {
			Connection myConn = DriverManager.getConnection(url, user, password);
			Statement myStmt = myConn.createStatement();
			String sql = "select * from $databaseName$.contacts";
			ResultSet rs = myStmt.executeQuery(sql);
			
			int rowCount = 0;
			while(rs.next()) {
				++rowCount;
			}
			
			
			while(rs.next()) {
				for(int i = 0; i<rowCount; i++) {
					for(int j = 0; j<5; j++) {
						//only if array is full
						if (i == array.length - 1) {
							int[][] newarray = new int[2*array.length][5];
							array = copyArray(newarray, array);
						}
						//put values into array
						rs.getInt(j);
					}
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	

}
