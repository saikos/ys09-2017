package gr.uoa.di.ys09;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class TestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		try {
			res.setContentType("text/plain; charset=utf-8");
			Writer writer = res.getWriter();
			writer.write("Test");
			writer.close();
		}
		catch(Exception e) {
			throw new ServletException(e.getMessage(), e);
		}
	}

}