package jp.co.test.delegate;

import jp.co.test.bean.HelloBean;

public class HelloDelegate003 /*implements HelloDB.MyClassCallbacks*/ {

//	int columnCount = 0;
//	ArrayList<HelloData> resultList = null;
//
//	public void callbackColumnCount(int cnt) {
//		if (resultList == null) {
//			columnCount = cnt;
//
//			resultList = new ArrayList<HelloData>();
//		}
//	}
//
//	public void callbackOneData(int row, int col, Object obj) {
//    	HelloData sl = null;
//    	if (col == 1) {
//    		sl = new HelloData();
//    		sl.setCarKatasiki(obj.toString());
//    		resultList.add(sl);
//    	} else if (col == 2) {
//    		sl = resultList.get(row - 1);
//    		sl.setCarName(obj.toString());
//    	}
//    }

	public String execute(HelloBean bean, String path) {
		String ret = null;
//		String text1 = null;
//		ArrayList<HelloData> outText1 = null;
//		String errText = null;
//		int row = 0;
//
//		text1 = "SELECT CAR_KATASIKI, CAR_NAME FROM OWNER_CAR_MASTER WHERE CAR_KATASIKI LIKE 'ZBA-%' ORDER BY CAR_KATASIKI";
//
//		HelloDB db = new HelloDB();
//		try {
//			db.setCallbacks(this);
//
//			db.init(path);
//
//			db.connect();
//
//			row = db.select(text1);
//
//			outText1 = resultList;
//		} catch (Exception ex) {
//			errText = ex.getMessage();
//		} finally {
//			try {
//				db.disconnect();
//			} catch (Exception ex) {
//				;
//			}
//		}
//
//		errText = HelloUtils.getSanitizedString(errText);
//		errText = "   TEST    ";	//@@@
//
//		bean.setErrText(errText);
//		bean.setResultList(outText1);

		ret = "HelloOut";

		return ret;
	}

}
