package jp.co.test.bean;

import java.util.ArrayList;

public class HelloBean {

	private String text1 = null;

	private String errText = null;

	private ArrayList<HelloData> outText1 = null;

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
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
