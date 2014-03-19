package br.com.tamandua.controller;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tamandua.model.Conta;
import br.com.tamandua.tasks.TaskCliente;
import br.com.tamandua.tasks.TaskClienteServiceLocator;

@Controller
public class SaldoController {

	@RequestMapping("transaldo")
	public ModelAndView transaldo(Conta conta) {
		ModelAndView mv = null;
		try {
			TaskCliente cliente = new TaskClienteServiceLocator().getTaskCliente();
			mv = new ModelAndView("servico/saldo");
			mv.addObject("saldo", cliente.tasksaldo(String.valueOf(conta.getNroconta()), conta.getSenha()));
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("saldo")
	public String saldo() {
		return "saldo";
	}
}
