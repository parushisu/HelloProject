package jp.co.sample.hello.tag;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import jp.co.sample.hello.utils.HelloException;
import jp.co.sample.hello.utils.HelloProp;

public class HelloMessageTag implements Tag {

	private PageContext pageContext = null;

	private Tag parentTag = null;

	private String key = "";

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
		ResourceBundle objRb = (ResourceBundle)pageContext.getAttribute("message_bundle");
		if (objRb == null) {
			String path = pageContext.getServletContext().getRealPath("/WEB-INF/init.xml");
	    	HelloProp prop = new HelloProp();
	    	try {
	    		prop.loadPropertiesByXml(path);
	    	} catch (HelloException ex) {
	    		throw new JspException(ex.getMessage());
	    	}
	    	String baseName = prop.getProperty("message.basename");

	    	Locale objLcl = pageContext.getRequest().getLocale();
			if (objLcl == null) { objLcl = Locale.ENGLISH; }
			objRb = ResourceBundle.getBundle(baseName, objLcl);

			pageContext.setAttribute("message_bundle", objRb);
		}

		if ("".equals(key)) {
			return SKIP_BODY;
		}

		String message = objRb.getString(key);
		if (message == null) {
			message = "";
		}

		try {
			pageContext.getOut().print(message);
		} catch (Exception ex) {
			throw new JspException("HelloMessageTag: " + ex.getMessage());
		}

		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void release() {
	}

}