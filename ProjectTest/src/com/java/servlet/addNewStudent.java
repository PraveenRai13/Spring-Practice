package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DAO.CollegeClassDAOImpl;
import com.java.DAO.StudentDAOImpl;
import com.java.persistance.CollegeClass;
import com.java.persistance.Student;

/**
 * Servlet implementation class addNewStudent
 */
@WebServlet("/addNewStudent")
public class addNewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNewStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String studentName=request.getParameter("studentName");
		int classId=Integer.valueOf(request.getParameter("classes"));	
		CollegeClass collegeClass =new CollegeClassDAOImpl().getCollegeClasses(classId);
		Student student=new Student();
		student.setStudentName(studentName);
		student.setCollegeClass(collegeClass);
		
		try {
			int status=new StudentDAOImpl().addStudent(student);
			if(status>0) {
				pw.println("<h3>Student Added succesfully</h3>");
				request.getRequestDispatcher("index.jsp").include(request,response);
			}
			else {
				pw.println("<h3>sorry unable to save record</h3>");
				request.getRequestDispatcher("index.jsp").include(request,response);
			}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
	}

}
