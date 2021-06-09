package com.estudo.jpa.config;


import static com.estudo.jpa.util.ConstantesUtil.CHARSET_UTF_8;
import static com.estudo.jpa.util.ConstantesUtil.OPTIONS;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * @author cleberson.pauluci
 *
 */
@Component
@Order(1)
public class CorsFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// não necessita de implementação
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, PATCH, OPTIONS, DELETE");
		res.setHeader("Access-Control-Allow-Headers",
				"Authorization,Origin, X-Requested-With, Content-Type, Accept, Key");
		res.setHeader("Access-Control-Max-Age", "3600");
		if (!req.getMethod().equals(OPTIONS)) {
			req.setCharacterEncoding(CHARSET_UTF_8);
			res.setCharacterEncoding(CHARSET_UTF_8);
			chain.doFilter(req, res);
		}
	}

	@Override
	public void destroy() {
		// não necessita de implementação
	}
}