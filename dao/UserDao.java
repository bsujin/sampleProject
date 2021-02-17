package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class UserDao {

	private UserDao(){}
	private static UserDao instance;
	public static UserDao getInstance(){
		if(instance == null){
			instance = new UserDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int inserUser(Map<String, Object> p){
		String sql = "INSERT INTO TB_JDBC_USER VALUES (?, ?, ?)";
				//USER 테이블 생성하기 
		List<Object> param = new ArrayList<>();
		param.add(p.get("USER_ID"));
		param.add(p.get("PASSWORD"));
		param.add(p.get("USER_NAME"));
		
		return jdbc.update(sql, param);
	}

	public Map<String, Object> selectUser(String userId, String password) {
		//id랑password가 일치하는 user가 있는지 확인하는 쿼리 작성
		
		String sql = "SELECT USER_ID, USER_NAME"
				+ " FROM TB_JDBC_USER"
				+ " WHERE USER_ID = ?"
				+ " AND PASSWORD = ?";
		List<Object> param = new ArrayList<>();
		param.add(userId);
		param.add(password);
		
		return jdbc.selectOne(sql, param);
	}
}
