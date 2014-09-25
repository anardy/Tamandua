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

			if (uri.contains("funcionario.do") || uri.contains("cliente.do")) {
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
					|| uri.contains("extrato.do")) {
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
