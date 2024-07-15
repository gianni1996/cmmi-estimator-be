package com.nttdata.cmmiestimator.application.config;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.core.config.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(CORSFilter.class);

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {

		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;

		String origin = request.getHeader("Origin");
		response.setHeader("Access-Control-Allow-Origin", origin);

		// CORS "pre-flight" request
		response.addHeader("Access-Control-Allow-Credentials", "true");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
		response.addHeader("Access-Control-Max-Age", "3600");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type, Range, Authorization, X-Auth-Token, SYSTEM");
		response.addHeader("Access-Control-Expose-Headers","Accept-Ranges, Content-Encoding, Content-Length, Content-Range");

		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			try {
				chain.doFilter(req, res);
			} catch (Exception e) {
				log.error(String.format("Errore filtroCors: %s", e.getMessage()));
			}

		}
	}

	public void init(FilterConfig filterConfig) {

	}

	public void destroy() {

	}

}