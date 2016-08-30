package jp.co.sample.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {

	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print("こんにちは");
		} catch (Exception ex) {
			throw new JspException("HelloTag: " + ex.getMessage());
		}

		return SKIP_BODY;
	}

	public int doEndTag() {
		return EVAL_PAGE;
	}

}
