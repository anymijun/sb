package com.sb.hyh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class LogFilter implements Filter {
	private static final Logger logger = Logger.getLogger(LogFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// 记录日志
		logger.info("LogFilter截获到用户的请求的地址" + req.getServletPath());
		chain.doFilter(request, response);
		// 再次记录日志
		logger.info("LogFilter过滤结束请求被定位到" + req.getRequestURI());
	}

	@Override
	public void destroy() {
	}
}
