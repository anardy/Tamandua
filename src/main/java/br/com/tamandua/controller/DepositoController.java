package br.com.tamandua.controller;

import java.rmi.RemoteException;

import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tamandua.mode.Deposito;
import br.com.tamandua.tasks.TaskCliente;
import br.com.tamandua.tasks.TaskClienteServiceLocator;

@Controller
public class DepositoController {
	
	@RequestMapping("trandeposito")
	public ModelAndView transaldo(Deposito deposito, HttpSession session) {
		ModelAndView mv = null;
		try {
			TaskCliente cliente = new TaskClienteServiceLocator().getTaskCliente();
			mv = new ModelAndView("servico/resultado");
			mv.addObject("msgm", cliente.taskdeposito(String.valueOf(deposito.getNrocontabeneficiado()), deposito.getValor(), session.getAttribute("codigoUsuario").toString()));
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("deposito")
	public String deposito() {
		return "servico/deposito";
	}
}
