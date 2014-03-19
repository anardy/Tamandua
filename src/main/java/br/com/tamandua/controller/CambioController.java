package br.com.tamandua.controller;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tamandua.model.Cambio;
import br.com.tamandua.tasks.TaskCliente;
import br.com.tamandua.tasks.TaskClienteServiceLocator;

@Controller
public class CambioController {
	
	@RequestMapping("trancambio")
	public ModelAndView transaldo(Cambio cambio) {
		ModelAndView mv = null;
		try {
			TaskCliente cliente = new TaskClienteServiceLocator().getTaskCliente();
			mv = new ModelAndView("servico/cambio");
			mv.addObject("cambio", cliente.taskcambio(cambio.getTipo(), cambio.getValor_tamandua(), cambio.getValor_real()));
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("cambio")
	public String cambio() {
		return "cambio";
	}
}
