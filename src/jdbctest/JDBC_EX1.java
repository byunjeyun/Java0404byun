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
//		String query2="delete from memberinfo where id='오지배'";
		String query3="insert into memberinfo(num, name, id, pw, email) values(5, '이순신', 'white', '11111', 'white@daum.net')";
				
				
		ResultSet ret = null; // query 값을 받는 ResultSet 클래스
		
		Connection conn = null;///DB 연결 객체 선언 
		Statement stmt = null; // sql 실행 객체 선언 
		
		
		try {
			Class.forName(driverName);//mysql jdbc 드라이버 호출
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("DB연결 완료!!");
		
			stmt = conn.createStatement();//SQL실행용 statement 객체 생ㅇ성
			ret = stmt.executeQuery(query); //select 호출 시 query
//			int = stmt.executeUpdate(); // 나머지 호출 시 update 
			
			while(ret.next()) {
				int pnum = ret.getInt("num");
				String pid = ret.getString("id");
				String ppw = ret.getString("pw");
				System.out.println(pnum);
				System.out.println(pid);
				System.out.println(ppw);
			}
				
//			int rnum = stmt.executeUpdate(query2);// 성공여부 반환 1이면 성공
//			
//			if(rnum == 1) {
//				System.out.println("회원탈퇴 성공!!");
//			} else {
//				System.out.println("회원탈퇴 실패!!");
//			}
			
			
			int rnum = stmt.executeUpdate(query3);// 성공여부 반환 1이면 성공
			
			if(rnum == 1) {
				System.out.println("회원가입 성공!!");
			} else {
				System.out.println("회원가입 실패!!");
			}
			
		} catch(ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러!!");
			
		} catch(SQLException e) {
			System.out.println("DB 연결 에러!!");
		}
	}

}
