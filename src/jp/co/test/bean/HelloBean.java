package jp.co.test.bean;

import java.util.ArrayList;

public class HelloBean {

	private String sql = null;

	private String errText = null;

	private ArrayList<HelloData> outText1 = null;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getErrText() {
		return errText;
	}

	public void setErrText(String errText) {
		this.errText = errText;
	}

	public ArrayList<HelloData> getOutText1() {
		return outText1;
	}

	public void setOutText1(ArrayList<HelloData> outText1) {
		this.outText1 = outText1;
	}

}
