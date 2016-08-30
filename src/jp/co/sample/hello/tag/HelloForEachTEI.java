package jp.co.sample.hello.tag;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

/**
 * forEachタグライブラリの変数定義
 **/
public class HelloForEachTEI extends TagExtraInfo {
	public VariableInfo[] getVariableInfo(TagData tagData) {
		String varName = tagData.getAttributeString("var");
		String varType = tagData.getAttributeString("type");
		if (varType == null) {
			varType = "java.lang.String";
		}

		return new VariableInfo[] { new VariableInfo(varName, varType, true, VariableInfo.NESTED) };
	}
}
