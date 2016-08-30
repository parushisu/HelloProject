package jp.co.sample.delegate;

import java.util.ArrayList;

import jp.co.sample.bean.HelloBean;
import jp.co.sample.db.HelloDB;
import jp.co.sample.utils.HelloUtils;

public class HelloDelegate implements HelloDB.MyClassCallbacks {

	int columnCount = 0;
//	StringBuffer result = null;
	ArrayList<String[]> resultList = null;

	public void callbackColumnCount(int cnt) {
		if (resultList == null) {
			columnCount = cnt;

//			result = new StringBuffer();

			resultList = new ArrayList<String[]>();
		}
	}

	public void callbackOneData(int row, int col, Object obj) {
//		String s = obj.toString();

//		result.append(s);
//    	if (col == columnCount) {
//    		result.append("\n");
//    	} else {
//    		result.append("\t");
//    	}

    	String[] sl = null;
    	if (col == 1) {
    		sl = new String[columnCount];
    		resultList.add(sl);
    	} else {
    		sl = resultList.get(row - 1);
    	}

    	sl[col - 1] = obj.toString();
    }

	public String execute(HelloBean bean, String path) {
		String ret = null;
		String text1 = null;
		ArrayList<String[]> outText1 = null;
		String errText = null;
		int row = 0;

//		text1 = HelloUtils.getSanitizedString(bean.getText1());
		text1 = "SELECT CAR_KATASIKI, CAR_NAME FROM OWNER_CAR_MASTER WHERE CAR_KATASIKI LIKE 'ZBA-%' ORDER BY CAR_KATASIKI";

		HelloDB db = new HelloDB();
//		String result = null;
		try {
			db.setCallbacks(this);

			db.init(path);

			db.connect();

			row = db.select(text1);

			StringBuffer result = new StringBuffer();
			for (String[] sl : resultList) {
				int cnt = sl.length;
		    	for (int i = 0; i < cnt; i++) {
			    	result.append(sl[i]);
			    	if (i < (cnt - 1)) {
			    		result.append("\t");
			    	} else {
				    	result.append("\n");
			    	}
		    	}
			}
			outText1 = resultList;
//			outText1 = result.toString();

//			outText1 = "※あなたが送信した内容<br>" + "<font color=#FF0000>" + text1 + "</font>";
		} catch (Exception ex) {
			errText = ex.getMessage();
		} finally {
			try {
				db.disconnect();
			} catch (Exception ex) {
				;
			}
		}

		if (errText != null) {
			errText = HelloUtils.getSanitizedString(errText);
		}

		bean.setErrText(errText);
		bean.setOutText1(outText1);

		ret = "HelloOut";

		return ret;
	}

}
