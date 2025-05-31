import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign_pro.Model;

@WebServlet("/SaveRecord")
public class SaveRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String usn = request.getParameter("usn");
		pw.println(usn);
		String name = request.getParameter("name");
		pw.println(name);
		String marks1 = request.getParameter("marks1");
		pw.println(marks1);
		String marks2 = request.getParameter("marks2");
		pw.println(marks2);
		String marks3 = request.getParameter("marks3");
		pw.println(marks3);
		String percentage = request.getParameter("percentage");
		pw.println();

		// Using wrapper classes explicitly
		int m1 = Integer.parseInt(marks1);
		int m2 = Integer.parseInt(marks2);
		int m3 = Integer.parseInt(marks3);
		float per = Float.parseFloat(percentage);
  
		

		Model m = new Model();
		m.setUsn(usn);
		m.setName(name);
		m.setMarks1(m1);
		m.setMarks2(m2);
		m.setMarks3(m3);
		m.setPercentage(per);
		
		m.saveRecord();
		int num = m.getNum();
		
		if(num >=1) {
			response.sendRedirect("/assign_pro/disp.html");
		}
		else {
			response.sendRedirect("/assign_pro/error.html");
		}
		m.closeConnection();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

} 