package com.bookstore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookDownload
 */
@WebServlet("/BookDownload")
public class BookDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q=request.getParameter("file");
		String f="";
		if(q.lastIndexOf(".")!=-1) {
			f=q.substring(q.lastIndexOf(".")+1).toLowerCase();//finds format
		}
		FileInputStream fis=null;
        
		if(f.equals("docx") ||f.equals("doc")  ){
			if(new File("F:\\Documents\\VISHNU Documents\\programs\\JavaTraining\\Day10_project\\WebContent\\books\\"+q).exists()) {
				fis=new FileInputStream("F:\\Documents\\VISHNU Documents\\programs\\JavaTraining\\Day10_project\\WebContent\\books\\"+q);
				response.setContentType("application/msword");
				     
			}
			
			
			
			
		}
		else if(f.equals("pdf")) {
			if(new File("F:\\Documents\\VISHNU Documents\\programs\\JavaTraining\\Day10_project\\WebContent\\books\\"+q).exists()) {
				
				fis=new FileInputStream("F:\\Documents\\VISHNU Documents\\programs\\JavaTraining\\Day10_project\\WebContent\\books\\"+q);
				response.setContentType("application/pdf");
			}
		}
		
		if(fis!=null) {
			response.setHeader("Content-Disposition", "attachment; filename=" + q);
	        
			ServletOutputStream outStream = response.getOutputStream();
	         
	        byte[] buffer = new byte[fis.available()];
	        fis.read(buffer);
	        outStream.write(buffer);
	        fis.close();
	        outStream.close();     
		}
			
		
	}

}
