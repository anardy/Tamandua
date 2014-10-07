package br.com.tamandua.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TipoUsuarioInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object controller) throws Exception {

		String uri = request.getRequestURI();

		if (uri.endsWith("login.do") || uri.endsWith("efetuaLogin.do")
				|| uri.contains("area.do")) {
			return true;
		} else {

			if (uri.contains("funcionario.do") || uri.contains("cliente.do")
					|| uri.contains("pesquisaCliente.do")
					|| uri.contains("cadCliente")
					|| uri.contains("inserirCliente")
					|| uri.contains("removerCliente")
					|| uri.contains("editarCliente")
					|| uri.contains("cadFuncionario")
					|| uri.contains("pesquisaFuncionario")
					|| uri.contains("inserirFuncionario")
					|| uri.contains("removerFuncionario")
					|| uri.contains("editarFuncionario")) {
				if (request.getSession().getAttribute("funcao")
						.equals("gerente")) {
					return true;
				} else {
					response.sendRedirect("area.do");
					return false;
				}
			}

			if (uri.contains("cambio.do") || uri.contains("saque.do")
					|| uri.contains("saldo.do") || uri.contains("deposito.do")
					|| uri.contains("transferencia.do")
					|| uri.contains("extrato.do")
					|| uri.contains("trancambio.do")
					|| uri.contains("trandeposito")
					|| uri.contains("tranextrato")
					|| uri.contains("transaldo")
					|| uri.contains("transaque")
					|| uri.contains("trantransferencia")) {
				if (request.getSession().getAttribute("funcao")
						.equals("atendente")) {
					return true;
				} else {
					response.sendRedirect("area.do");
					return false;
				}
			}
		}

		return false;
	}
}
