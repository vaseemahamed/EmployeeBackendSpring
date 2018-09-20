
package com.example.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter {

	private final Logger log = LoggerFactory.getLogger(CORSFilter.class);

	public CORSFilter() {
		log.info("SimpleCORSFilter init");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Accept, X-Requested-With, remember-me, Authorization ,X-OrganizationKey");
		/*
		 * Hiding the server details with custom message.
		 */
		response.setHeader("Server", "happy to serve you");

		/*
		 * manually blocking all the request excepts GET & POST. This is a work
		 * around, until proper security has been implemented.
		 */
		if (request.getMethod().equalsIgnoreCase("get") || request.getMethod().equalsIgnoreCase("post")
				|| request.getMethod().equalsIgnoreCase("delete") || request.getMethod().equalsIgnoreCase("put")) {
			chain.doFilter(req, res);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) {
		// Nothing to initialize
	}

	@Override
	public void destroy() {
		// Nothing to cleanup
	}

}