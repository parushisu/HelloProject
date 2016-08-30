package jp.co.sample.hello.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
abstract public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected static final String JSP_ROOT = "/WEB-INF/jsp/";

    /**
     * Default constructor.
     */
    public HelloServlet() {
        // TODO Auto-generated constructor stub
    }

//    protected void initGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		request.setCharacterEncoding("windows-31j");
//		response.setContentType("text/html;charset=windows-31j");
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		String path = context.getRealPath("/WEB-INF/init.xml");

//		String text1 = request.getParameter("text1");
//        String forward = null;
//
//        if (text1 == null) {
//        	forward = "HelloIn";
//        } else {
//	        HelloBean bean = new HelloBean();
//
//	        bean.setText1(text1);
//
//			HelloDelegate hello = new HelloDelegate();
//			forward = hello.execute(bean, path);
//
//			request.setAttribute("errText", bean.getErrText());
//			request.setAttribute("outText1", bean.getOutText1());
//        }
		String forward = execGet(request, response, path);

		RequestDispatcher dispatcher = request.getRequestDispatcher(JSP_ROOT + forward + ".jsp");
		dispatcher.forward(request, response);
	}

	abstract protected String execGet(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
