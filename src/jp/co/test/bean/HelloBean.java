package jp.co.test.bean;

import java.util.ArrayList;

public class HelloBean {

	private String sql = null;

	private String errText = null;

	private ArrayList<HelloData> resultList = null;

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

	public ArrayList<HelloData> getResultList() {
		return resultList;
	}

	public void setResultList(ArrayList<HelloData> resultList) {
		this.resultList = resultList;
	}

}
