package com.bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookRegister
 */
@WebServlet("/BookRegister")
public class BookRegister extends Books {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see Books#Books()
     */
    public BookRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter p=response.getWriter();
			PreparedStatement pre=connection.prepareStatement("insert into books values(?,?,?,?,?,?)");
			pre.setInt(1, ++id);
			pre.setString(2, request.getParameter("name"));
			pre.setString(3, request.getParameter("author"));
			pre.setString(4, request.getParameter("subject"));
			pre.setInt(5, Integer.parseInt(request.getParameter("price")));
			pre.setString(6, request.getParameter("file"));
			
			if(pre.executeUpdate()==1)
				p.print("Book Inserted Successfully!!. Book Id is "+id);
			else {
				p.print("Book was not Inserted");
				id--;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	

}
