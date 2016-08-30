package jp.co.sample.hello.tag;

import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloWorldTag2 implements Tag {

	private PageContext pageContext = null;

	private Tag parentTag = null;

	private String msg = "";

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	public Tag getParent() {
		return parentTag;
	}

	public void setParent(Tag parentTag) {
		this.parentTag = parentTag;
	}

	public int doStartTag() throws JspException {
		Object attr = pageContext.getRequest().getAttribute(msg);
		if (attr == null) {
			return SKIP_BODY;
		}

		if (attr instanceof String) {
			if ("".equals(attr)) {
				return SKIP_BODY;
			}
		} else if (attr instanceof Collection<?>) {
			if (((Collection<?>)attr).size() == 0) {
				return SKIP_BODY;
			}
		}

		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
//		try {
//			if (msg.equals("aaa")) {
//				pageContext.getOut().print("Hello World " + msg);
//			}
//		} catch (IOException e) {
//			throw new JspException(e.getMessage());
//		}

		return EVAL_PAGE;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}

	public void release() {
	}

}