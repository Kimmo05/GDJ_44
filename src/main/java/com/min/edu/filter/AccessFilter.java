package com.min.edu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccessFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("~~~~~~~~~~~~~~~~~~~~~~~~Filter 작동 시작~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String url = StringUtils.defaultIfEmpty(req.getRequestURL().toString(), "URL 없음");
		String queryString = StringUtils.defaultString(req.getQueryString(), "");
		
		log.info("~~~~~~~~~~~~~~~~~~~~~~~~URL : {}~~~~~~~~~~~~~~~~~~~~~~~~", url);
		log.info("~~~~~~~~~~~~~~~~~~~~~~~~queryString : {}~~~~~~~~~~~~~~~~~~~~~~~~", queryString);
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		log.info("~~~~~~~~~~~~~~~~~~~~~~~~Filter 작동 끝~~~~~~~~~~~~~~~~~~~~~~~~");
	}

}
