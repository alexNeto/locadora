package com.blog.usuario;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usuario")
public class UsuarioControlador extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5476389992978057424L;

	protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta)
			throws ServletException, IOException {

		UsuarioDao usuarioRepositorio = UsuarioDaoJpa.pegaInstancia();
		boolean usuarioExiste = usuarioRepositorio.encontrarPeloNome(requisicao.getParameter("apelido")) != null;
		resposta.setContentType("application/json");
		PrintWriter respostaEscritor = resposta.getWriter();
		respostaEscritor.print(usuarioExiste);
		respostaEscritor.flush();
	}
}
