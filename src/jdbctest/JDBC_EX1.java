package jdbctest;

import java.sql.*;

public class JDBC_EX1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String driverName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/student";
		String username="root";
		String password="5542";
		String query="select * from memberinfo";
//		String query2="delete from memberinfo where id='������'";
		String query3="insert into memberinfo(num, name, id, pw, email) values(5, '�̼���', 'white', '11111', 'white@daum.net')";
				
				
		ResultSet ret = null; // query ���� �޴� ResultSet Ŭ����
		
		Connection conn = null;///DB ���� ��ü ���� 
		Statement stmt = null; // sql ���� ��ü ���� 
		
		
		try {
			Class.forName(driverName);//mysql jdbc ����̹� ȣ��
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("DB���� �Ϸ�!!");
		
			stmt = conn.createStatement();//SQL����� statement ��ü ������
			ret = stmt.executeQuery(query); //select ȣ�� �� query
//			int = stmt.executeUpdate(); // ������ ȣ�� �� update 
			
			while(ret.next()) {
				int pnum = ret.getInt("num");
				String pid = ret.getString("id");
				String ppw = ret.getString("pw");
				System.out.println(pnum);
				System.out.println(pid);
				System.out.println(ppw);
			}
				
//			int rnum = stmt.executeUpdate(query2);// �������� ��ȯ 1�̸� ����
//			
//			if(rnum == 1) {
//				System.out.println("ȸ��Ż�� ����!!");
//			} else {
//				System.out.println("ȸ��Ż�� ����!!");
//			}
			
			
			int rnum = stmt.executeUpdate(query3);// �������� ��ȯ 1�̸� ����
			
			if(rnum == 1) {
				System.out.println("ȸ������ ����!!");
			} else {
				System.out.println("ȸ������ ����!!");
			}
			
		} catch(ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����!!");
			
		} catch(SQLException e) {
			System.out.println("DB ���� ����!!");
		}
	}

}
