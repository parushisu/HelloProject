package jp.co.sample.hello.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HelloAction {

	public abstract String execute(HttpServletRequest request, HttpServletResponse response);

}
