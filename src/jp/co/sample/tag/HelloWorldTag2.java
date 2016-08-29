package jp.co.sample.tag;

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
		if (msg.equals("aaa")) {
			return SKIP_BODY;
		} else {
			return EVAL_BODY_INCLUDE;
		}
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