package com.blog.autenticacao.sair;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.utilitario.RespostaPadrao;

@WebServlet("/sair")
public class SairControlador extends HttpServlet {

	/**
	* 
	*/
	private static final long serialVersionUID = -4293549827107647532L;

	@Override
	protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta)
			throws ServletException, IOException {
		requisicao.getSession().setAttribute("apelido", null);
		resposta.setStatus(200);
		resposta.setContentType("application/json");
		RespostaPadrao.json(resposta.getWriter());
	}

}
