package jp.co.test.delegate;

import java.util.ArrayList;

import jp.co.sample.hello.db.HelloDB;
import jp.co.sample.hello.utils.HelloUtils;
import jp.co.test.bean.HelloBean;
import jp.co.test.bean.HelloData;

public class TestHelloDelegate implements HelloDB.MyClassCallbacks {

	int columnCount = 0;
//	StringBuffer result = null;
	ArrayList<HelloData> resultList = null;

	public void callbackColumnCount(int cnt) {
		if (resultList == null) {
			columnCount = cnt;

//			result = new StringBuffer();

			resultList = new ArrayList<HelloData>();
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

    	HelloData sl = null;
    	if (col == 1) {
    		sl = new HelloData();
    		sl.setCarKatasiki(obj.toString());
    		resultList.add(sl);
    	} else if (col == 2) {
    		sl = resultList.get(row - 1);
    		sl.setCarName(obj.toString());
    	}
    }

	public String execute(HelloBean bean, String path) {
		String ret = null;
		String text1 = null;
		ArrayList<HelloData> outText1 = null;
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

//			StringBuffer result = new StringBuffer();
//			for (String[] sl : resultList) {
//				int cnt = sl.length;
//		    	for (int i = 0; i < cnt; i++) {
//			    	result.append(sl[i]);
//			    	if (i < (cnt - 1)) {
//			    		result.append("\t");
//			    	} else {
//				    	result.append("\n");
//			    	}
//		    	}
//			}
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

//		if (errText != null) {
			errText = HelloUtils.getSanitizedString(errText);
//		}
		errText = "   TEST    ";	//@@@

		bean.setErrText(errText);
		bean.setOutText1(outText1);

		ret = "HelloOut";

		return ret;
	}

}
