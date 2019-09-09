package com.bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookSearch
 */
@WebServlet("/BookSearch")
public class BookSearch extends Books {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see Books#Books()
     */
    public BookSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			PrintWriter p=response.getWriter();
			int i=0;
			if(request.getParameter("id")!="")
				i=Integer.parseInt(request.getParameter("id"));
			String n=request.getParameter("name");
			String a=request.getParameter("author");
			String g=request.getParameter("genre");
			
			String sub="";
			if(i!=0) {
				sub+=" and id="+i;
			}
			if(n!="") {
				sub+=" and name like "+"'%"+n+"%'";
			}
			if(a!="") {
				sub+=" and author like "+"'%"+a+"%'";
			}
			if(g!="") {
				sub+=" and genre like "+"'%"+g+"%'";
			}
			if(i!=0 || n!="" || a!="" || g!="")
				sub="where" +sub.substring(4);
			PreparedStatement pre=connection.prepareStatement("select * from books "+sub);
			
			ResultSet rs=pre.executeQuery();
			p.print(
					 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>SearchBooks</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<h1>Book Details</h1>\r\n"
					+ "		<table style=\"width:75%;table-layout: fixed;text-align: center;\" >\r\n"
					+ "			<tr>\r\n" + 
					"		    <th>Id </th>\r\n" + 
					"		    <th>Name</th>\r\n" + 
					"		    <th>Author</th>\r\n" + 
					"		    <th>Genre</th>\r\n" + 
					"		    <th>Price</th>\r\n" + 
					"		    <th>File</th>\r\n" + 
					"		    \r\n" + 
					"		  </tr>\r\n");
			while(rs.next()) {
				
				p.print(" <tr>\r\n" + 
						"		    <td>"+rs.getInt(1)+"</td>\r\n" + 
						"		    <td>"+rs.getString(2)+"</td>\r\n" + 
						"		    <td>"+rs.getString(3)+"</td>\r\n" + 
						"		    <td>"+rs.getString(4)+"</td>\r\n" + 
						"		    <td>"+rs.getInt(5)+"</td>\r\n" + 
						"		    <td><a href=\"/Day10_project/BookDownload?file="+rs.getString(6)+"\">"+rs.getString(6)+"</a></td>\r\n" + 
						"		    \r\n" + 
						"		  </tr>\r\n");
			}
			p.print("</table>\r\n" + 
					"<br>\r\n" + 
					"<br>\r\n" + 
					"\r\n" + 
					"<a href=\"/Day10_project/SearchDownloadBooks.jsp\">Go Back</a>\r\n" + 
					
					"</body>\r\n" + 
					"</html>");
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
