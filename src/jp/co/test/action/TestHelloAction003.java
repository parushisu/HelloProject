package jp.co.test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sample.hello.action.HelloAction;
import jp.co.test.bean.HelloBean;

public class TestHelloAction003 extends HelloAction {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String fn = request.getParameter("fn");
//		ServletContext context = request.getServletContext();
//		String path = context.getRealPath("/WEB-INF/init.xml");

		if ("back".equals(fn)) {
			String sql = request.getParameter("sql");
	        HelloBean bean = new HelloBean();
	        bean.setSql(sql);
			return "HelloIn";
		} else {
			return "";
		}

//		String sql = request.getParameter("sql");
//        String forward = null;
//
//        if (sql == null) {
//        	forward = "HelloIn";
//        } else {
//	        HelloBean bean = new HelloBean();
//
//	        bean.setSql(sql);
//
//			HelloDelegate002 hello = new HelloDelegate002();
//			forward = hello.execute(bean, path);
//
//			request.setAttribute("errText", bean.getErrText());
//			request.setAttribute("HelloBean", bean);
//        }
//
//        return forward;
	}

}
