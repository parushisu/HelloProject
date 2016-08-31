package jp.co.test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sample.hello.action.HelloAction;

public class TestHelloAction001 extends HelloAction {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
//		String fn = request.getParameter("fn");
//		ServletContext context = request.getServletContext();
//		String path = context.getRealPath("/WEB-INF/init.xml");
//
//		if ("back".equals(fn)) {
//			return "index";
//		}
//
//		String sql = request.getParameter("sql");
        String forward = null;
//
//        if (sql == null) {
        	forward = "HelloIn";
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
