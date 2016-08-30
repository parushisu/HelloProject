package jp.co.sample.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class HelloFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException{ } // フィルタがインスタンス化された直後に行いたい処理を書く場所

    // 設定したサーブレットクラスが呼ばれた（リクエストされた）時に行いたい処理を書く場所
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		request.setCharacterEncoding("windows-31j");
//		response.setContentType("text/html;charset=windows-31j");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		chain.doFilter(request, response);
    }

    public void destroy(){ } // フィルタのインスタンスが破棄される直前に行いたい処理を書く場所

}
