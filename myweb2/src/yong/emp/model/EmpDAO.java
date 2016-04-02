package yong.emp.model;
import java.sql.*;
import java.util.*;

public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public EmpDAO(){
		
		
	}
	//사원추가
	public int empAdd(EmpDTO dto){
		try {
			conn= yong.db.YongDB.getConn();
			String sql = "insert into employee values(employee_idx.nextval,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getDept());
			
			int count = ps.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} 
	}
	//사원 삭제
	public int empDel(String name){
		try {
			conn= yong.db.YongDB.getConn();
			String sql = "delete from employee where name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			
			int count = ps.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} 
	}
	
	//모든 사원 보기
	public ArrayList<EmpDTO> empList(){
		try {
			conn = yong.db.YongDB.getConn();
			String sql="select * from employee order by idx desc";
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			ArrayList<EmpDTO> arr = new ArrayList<EmpDTO>();
			
			while(rs.next()){
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String dept = rs.getString("dept");
				
				EmpDTO temp = new EmpDTO(idx, name, email, dept);
				arr.add(temp);
			}
			return arr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	//사원 검색
	public ArrayList<EmpDTO> empSel(String empName){
		try {
			conn = yong.db.YongDB.getConn();
			String sql = "select * from employee where name=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, empName);
			rs=ps.executeQuery();
			
			ArrayList<EmpDTO> arr = new ArrayList<EmpDTO>();
			
			while(rs.next()){
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String dept = rs.getString("dept");
				
				EmpDTO temp = new EmpDTO(idx, name, email, dept);
				arr.add(temp);
			}
			return arr;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	//사원 조회(수정)
	public EmpDTO empUpdateInfo(int idx){
		try {
			conn = yong.db.YongDB.getConn();
			String sql = "select * from employee where idx=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
			rs=ps.executeQuery();
			
			EmpDTO dto =  null;
			if(rs.next()){
				String name = rs.getString("name");
				String email = rs.getString("email");
				String dept = rs.getString("dept");
				
				dto= new EmpDTO(idx, name, email, dept);
			}
			return dto;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//사원 정보 수정
	public int empUpdate(EmpDTO dto){
		try {
			conn = yong.db.YongDB.getConn();
			String sql = "update employee set name=?, email=?, dept=? where idx=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getDept());
			ps.setInt(4, dto.getIdx());
			
			int count = ps.executeUpdate();
			return count;
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			try {
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
