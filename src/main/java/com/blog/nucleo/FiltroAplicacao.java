package com.blog.nucleo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/restrito/*")
public class FiltroAplicacao implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain corrente)
			throws ServletException, IOException {

		HttpServletRequest requisicao = (HttpServletRequest) req;
		HttpServletResponse resposta = (HttpServletResponse) res;
		HttpSession session = requisicao.getSession(false);

		boolean loggedIn = session != null && session.getAttribute("apelido") != null;

		if (loggedIn) {
			corrente.doFilter(requisicao, resposta);
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}