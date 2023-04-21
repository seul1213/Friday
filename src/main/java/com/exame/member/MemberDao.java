package com.exame.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	String url="jdbc:oracle:thin:@localhost:1521:xe";//데이터베이스 서버 주소
	String user="web";//데이터베이스 접속 아이디
	String password="web01";//데이터베이스 접속 비밀번호
	
public List<MemberVo> selectMemberList() {
	   List<MemberVo> list = new ArrayList<MemberVo>();
		
		String sql="SELECT mem_id,MEM_PASS,MEM_NAME,MEM_POINT FROM MEMBER";
		
		//try() 내부에 선언된 변수의 값은
		//try-catch 블럭의 실행이 완료된 후 자동으로 close()메서드 실행
		try(Connection conn = DriverManager.getConnection(url, user, password);//지정한 데이터베이스에 접속(로그임)명령
				//해당 연결을 통해 실행할 SQL문을 담은 명령문 객체 생성
				PreparedStatement pstmt = conn.prepareStatement(sql);			
				//sql문 실행(insert,update,delete 문 실행은 executeUpdat()메서드 사용
				ResultSet rs = pstmt.executeQuery();//반환값은 조회한 결과가 담긴 레코드(row)들
				) {
			
			
			//처음 ResultSet 객체는 조회결과에서 첫 레코드(row) 이전을 가리키고 있음
			//.next()메서드를 실행하면 다음 레코드를 가리키게 된다
			//다음 레코드가 있으면 true반환하고 없으면 false를 반환		
			while (rs.next()) {
				MemberVo vo =new MemberVo();
			
				//컬럼값의 데이터타입에 따라서 get타입("컬럼명") 메서드를 사용해서 컬럼값읽기
				vo.setMemId (rs.getString("mem_id"));//현재 가리키는 레코드(row)의 "mem_id"컬럼값 읽기
				vo.setMemPass ( rs.getString("mem_pass"));//현재 가리키는 레코드(row)의 "MEM_PASS"컬럼값 읽기
				vo.setMemName ( rs.getString("mem_name"));//현재 가리키는 레코드(row)의 "MEM_NAME"컬럼값 읽기
				vo.setMemPoint ( rs.getInt("mem_point"));//현재 가리키는 레코드(row)의 "MEM_POINT"컬럼값 읽기
				
				list.add(vo);
			}
		
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return list;
	}


public int insertMember(MemberVo vo) {
	String sql="INSERT INTO MEMBER "+ "(mem_id,MEM_PASS,MEM_NAME,MEM_POINT) "
			+ "VALUES "+ "( ?,?,?,?)";
	//try() 내부에 선언된 변수의 값은
	//try-catch 블럭의 실행이 완료된 후 자동으로 close()메서드 실행
	int n=0;
	try(Connection conn = DriverManager.getConnection(url, user, password);//지정한 데이터베이스에 접속(로그임)명령
			//해당 연결을 통해 실행할 SQL문을 담은 명령문 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			) {
		//pstmt 명령문 객체에 담겨 있는 sql문의 ?에 값을 채워 넣기
		//채워넣는 값의 타입에 따라서 set타입명()메서드 사용
		pstmt.setString(1, vo.getMemId());//1번째 ?에 memId값을 넣기
		pstmt.setString(2, vo.getMemPass());//2번째 ?에 memPass값을 넣기
		pstmt.setString(3, vo.getMemName());//3번째 ?에 memName값을 넣기
		pstmt.setInt(4, vo.getMemPoint());//4번째 ?에 memPoint값을 넣기
		
		//sql문 실행(insert,update,delete 문 실행은 executeUpdat()메서드 사용
		
		n = pstmt.executeUpdate();//반환값은 sql문 실행으로 영향받은 레코드(row)수
		System.out.println(n+"명의 회원 추가 성공");

	} catch (SQLException e) {		
		e.printStackTrace();
	}
	return n;
}

public int deleteMember(String memId) {
	String sql="DELETE FROM member  WHERE mem_id= ? ";

	int n=0;
	try(Connection conn = DriverManager.getConnection(url, user, password);//지정한 데이터베이스에 접속(로그임)명령
			//해당 연결을 통해 실행할 SQL문을 담은 명령문 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			) {
		//pstmt 명령문 객체에 담겨 있는 sql문의 ?에 값을 채워 넣기
		//채워넣는 값의 타입에 따라서 set타입명()메서드 사용
		pstmt.setString(1, memId);//1번째 ?에 memId값을 넣기
//		pstmt.setString(2, memPass);//2번째 ?에 memPass값을 넣기
//		pstmt.setString(3, memName);//3번째 ?에 memName값을 넣기
//		pstmt.setInt(4, memPoint);//4번째 ?에 memPoint값을 넣기
		
		//sql문 실행(insert,update,delete 문 실행은 executeUpdat()메서드 사용
		
		n = pstmt.executeUpdate();//반환값은 sql문 실행으로 영향받은 레코드(row)수
		System.out.println(n+"명의 삭제 성공");

	} catch (SQLException e) {		
		e.printStackTrace();
	}
	return n;
}
}
