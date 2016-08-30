package jp.co.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sample.hello.servlet.HelloServlet;
import jp.co.test.bean.HelloBean;
import jp.co.test.delegate.TestHelloDelegate;

public class TestHelloServlet extends HelloServlet {

	protected String execGet(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		String text1 = request.getParameter("text1");
        String forward = null;

        if (text1 == null) {
        	forward = "HelloIn";
        } else {
	        HelloBean bean = new HelloBean();

	        bean.setText1(text1);

			TestHelloDelegate hello = new TestHelloDelegate();
			forward = hello.execute(bean, path);

			request.setAttribute("errText", bean.getErrText());
//			request.setAttribute("outText1", bean.getOutText1());
			request.setAttribute("HelloBean", bean);
        }

        return forward;
	}

}
