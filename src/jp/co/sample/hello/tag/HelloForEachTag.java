package jp.co.sample.hello.tag;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * forEach繰り返し表示タグライブラリ
 **/
public class HelloForEachTag extends TagSupport {
	private String var;
	private String type;
	private Object items;
	private Iterator iterator;

	/** varの設定 **/
	public void setVar(String var) {
		this.var = var;
	}

	/** typeの設定 **/
	public void setType(String type) {
		this.type = type;
	}

	/** itemsの設定 **/
	public void setItems(Object items) {
		this.items = items;
	}

	/** タグ初期処理（繰り返しの初期処理） **/
	public int doStartTag() throws JspException {
		// データがない場合は処理しない
		if (items == null) {
			return SKIP_BODY;
		}

		// Array型からIteratorに変換
		if (items instanceof Object[]) {
			Object[] array = (Object[]) items;
			iterator = Arrays.asList(array).iterator();

			// Collection型からIteratorに変換
		} else if (items instanceof Collection) {
			Collection collection = (Collection) items;
			iterator = collection.iterator();

			// Iterator型からIteratorに変換
		} else if (items instanceof Iterator) {
			iterator = (Iterator) items;

			// その他のデータ型の場合はエラー
		} else {
			throw new JspException("Invalid type: " + items.getClass().getName());
		}

		// 次の要素を取得
		if (iterator.hasNext()) {
			pageContext.setAttribute(var, iterator.next());
			return EVAL_BODY_INCLUDE;

		} else {
			return SKIP_BODY;
		}
	}

	/** 繰り返しの後処理 **/
	public int doAfterBody() throws JspException {
		// データがない場合は処理しない
		if (iterator == null) {
			return SKIP_BODY;
		}

		// 次の要素を取得
		if (iterator.hasNext()) {
			pageContext.setAttribute(var, iterator.next());
			return EVAL_BODY_AGAIN;

		} else {
			return SKIP_BODY;
		}
	}
}
