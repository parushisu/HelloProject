package jp.co.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sample.hello.action.HelloAction;
import jp.co.sample.hello.servlet.HelloServlet;
import jp.co.test.action.TestHelloAction001;
import jp.co.test.action.TestHelloAction002;
import jp.co.test.action.TestHelloAction003;

public class TestHelloServlet extends HelloServlet {

	protected String execGet(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		String id = request.getParameter("screenId");
//		String fn = request.getParameter("fn");
		HelloAction action = null;
//		String sql = request.getParameter("sql");
        String forward = null;

		switch (id) {
		case "SCR0001":
			action = new TestHelloAction001();
			break;
		case "SCR0002":
			action = new TestHelloAction002();
			break;
		case "SCR0003":
			action = new TestHelloAction003();
			break;
		}

		if (action != null) {
			forward = action.execute(request, response);
		}

//		if ("back".equals(fn)) {
//			return "index";
//		}
//
//        if (sql == null) {
//        	forward = "HelloIn";
//        } else {
//	        HelloBean bean = new HelloBean();
//
//	        bean.setSql(sql);
//
//			HelloDelegate001 hello = new HelloDelegate001();
//			forward = hello.execute(bean, path);
//
//			request.setAttribute("errText", bean.getErrText());
//			request.setAttribute("HelloBean", bean);
//        }

        return forward;
	}

}
