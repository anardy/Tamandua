package br.com.tamandua.controller;

import java.rmi.RemoteException;

import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tamandua.mode.Funcionario;
import br.com.tamandua.tasks.TaskCliente;
import br.com.tamandua.tasks.TaskClienteServiceLocator;

@Controller
public class LoginController {
	
	@RequestMapping("login")
	public String extrato() {
		return "login";
	}
	
	@RequestMapping("/efetuaLogin")
	public String efetuarLogin(Funcionario funcionario, HttpSession session, final RedirectAttributes redirectAttributes) {
		String error = null;
		br.com.tamandua.Model.Funcionario func;
		try {
			TaskCliente cliente = new TaskClienteServiceLocator().getTaskCliente();
			if (cliente.tasklogin(funcionario.getLogin(), funcionario.getSenha())) {
				func = cliente.taskdadosFuncionario(funcionario.getLogin(), funcionario.getSenha());
					session.setAttribute("usuarioLogado", func.getNome());
					session.setAttribute("funcao", func.getFuncao());
					session.setAttribute("codigoUsuario", func.getCpf());
					return "redirect:area.do";
			} else {
				error = "Login ou Senha errado";
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		redirectAttributes.addFlashAttribute("erro", error);
		return "redirect:login.do";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.do";
	}
}
