package br.com.tamandua.controller;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tamandua.model.Saque;
import br.com.tamandua.tasks.TaskCliente;
import br.com.tamandua.tasks.TaskClienteServiceLocator;

@Controller
public class SaqueController {
	
	@RequestMapping("saque")
	public String saldo() {
		return "saque";
	}
	
	@RequestMapping("transaque")
	public ModelAndView transaldo(Saque saque) {
		ModelAndView mv = null;
		try {
			TaskCliente cliente = new TaskClienteServiceLocator().getTaskCliente();
			mv = new ModelAndView("servico/saque");
			mv.addObject("msgm", cliente.tasksaque(String.valueOf(saque.getNroconta()), saque.getValor(), saque.getSenha()));
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}

}
