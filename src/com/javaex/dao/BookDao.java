package com.javaex.dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao {
	
	public int insert(BookVo book) {
		
		String title=book.getTitle();
		String pubs=book.getPubs();
		
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url,"webdb","webdb");
			System.out.println("접속성공");
			
			String query="insert into book values(seq_book_id.nextval,?,?,'07/01/01',3)";
			pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, title);
			pstmt.setString(2, pubs);
			int count=pstmt.executeUpdate();
			
			System.out.println(count+"건 처리");
		
			
		}catch(ClassNotFoundException e) {
			System.out.println("error:드라이벌딩 실패."+e);
		}catch(SQLException e) {
			System.out.println("error:"+e);
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(SQLException e) {
				System.out.println("error:"+e);
			}
		}
		return 1;
	}

	public ArrayList<BookVo> select(){
		
		ResultSet rs=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		ArrayList<BookVo> bookList=new ArrayList<BookVo>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url,"webdb","webdb");
			System.out.println("접속성공");
			
			String query="select book_id, "
					+"title, pubs,pub_date,author_id from book";
			pstmt=conn.prepareStatement(query);
			int count=pstmt.executeUpdate();
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int bookId=rs.getInt("book_id");
				String bookTitle=rs.getString("title");
				String bookPubs=rs.getString("pubs");
				String bookDate=rs.getString("pub_date");
				int author_id=rs.getInt("author_id");
				
				System.out.println(bookId+"\t"+bookTitle+"\t"+bookPubs+"\t"+bookDate+"\t"+author_id);
				
			}
			System.out.println(count+"건 처리");
		}catch(ClassNotFoundException e) {
			System.out.println("error:드라이벌딩 실패."+e);
		}catch(SQLException e) {
			System.out.println("error"+e);
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(SQLException e) {
				System.out.println("error:"+e);
			}
		}
		return bookList;
		
	}
	public void delete(BookVo book) {
		int num=book.getBookId();
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url,"webdb","webdb");
			System.out.println("접속성공");
			
			String query="delete from book "
					+"where book_id=3";
			pstmt=conn.prepareStatement(query);
			pstmt.executeQuery();
			
		}catch(ClassNotFoundException e) {
			System.out.println("error:드라이벌딩 실패."+e);
		}catch(SQLException e) {
			System.out.println("error"+e);
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(SQLException e) {
				System.out.println("error:"+e);
			}

	}

	}
	public void update(BookVo book) {
		int num=book.getBookId();
		String title=book.getTitle();
		String pubs=book.getPubs();
		String date=book.getDate();
		int anum =book.getAuthorId();
		
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url,"webdb","webdb");
			System.out.println("접속성공");
			
			String query="update book "
					+"set title='가나다', pubs='어디선가'"
					+ "where book_id=2";
			pstmt=conn.prepareStatement(query);
			pstmt.executeQuery();
			
		}catch(ClassNotFoundException e) {
			System.out.println("error:드라이벌딩 실패."+e);
		}catch(SQLException e) {
			System.out.println("error"+e);
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(SQLException e) {
				System.out.println("error:"+e);
			}

	}
	}
	
}
