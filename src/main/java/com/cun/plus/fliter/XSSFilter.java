package com.cun.plus.fliter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther: simon
 * @Date: 2019/4/2 10:04
 * @Description:
 */
//@WebFilter
public class XSSFilter implements Filter {

    private static final transient Logger logger = LoggerFactory.getLogger(XSSFilter.class);

    // XSS处理Map
    private static Map<String,String> xssMap = new LinkedHashMap<String,String>();

    public void init(FilterConfig filterConfig) throws ServletException {
        // 含有脚本： script
        xssMap.put("[s|S][c|C][r|R][i|I][p|P][t|T]", "");
        // 含有脚本 javascript
        xssMap.put("[\\\"\\\'][\\s]*[j|J][a|A][v|V][a|A][s|S][c|C][r|R][i|I][p|P][t|T]:(.*)[\\\"\\\']", "\"\"");
        // 含有函数： eval
        xssMap.put("[e|E][v|V][a|A][l|L]\\((.*)\\)", "");
        // 含有符号 <
        xssMap.put("<", "&lt;");
        // 含有符号 >
        xssMap.put(">", "&gt;");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        logger.debug("进入自定义Filter：XSSFilter");
        // 强制类型转换 HttpServletRequest
        HttpServletRequest httpReq = (HttpServletRequest)request;
        // 构造HttpRequestWrapper对象处理XSS
        XssHttpServletRequestWrapper httpReqWarp = new XssHttpServletRequestWrapper(httpReq,xssMap);
        chain.doFilter(httpReqWarp, response);
    }

    public void destroy() {
		logger.debug("销毁XSSFilter");
    }
}
