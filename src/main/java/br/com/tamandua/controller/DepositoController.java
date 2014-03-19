package br.com.tamandua.controller;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tamandua.model.Deposito;
import br.com.tamandua.tasks.TaskCliente;
import br.com.tamandua.tasks.TaskClienteServiceLocator;

@Controller
public class DepositoController {
	
	@RequestMapping("trandeposito")
	public ModelAndView transaldo(Deposito deposito) {
		ModelAndView mv = null;
		try {
			TaskCliente cliente = new TaskClienteServiceLocator().getTaskCliente();
			mv = new ModelAndView("servico/deposito");
			mv.addObject("deposito", cliente.taskdeposito(String.valueOf(deposito.getNrocontabeneficiado()), deposito.getValor()));
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("deposito")
	public String deposito() {
		return "deposito";
	}
}
