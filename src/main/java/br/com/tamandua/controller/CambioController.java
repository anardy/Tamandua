package br.com.tamandua.controller;

import java.rmi.RemoteException;

import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tamandua.mode.Cambio;
import br.com.tamandua.tasks.TaskCliente;
import br.com.tamandua.tasks.TaskClienteServiceLocator;

@Controller
public class CambioController {
	
	@RequestMapping("trancambio")
	public ModelAndView transaldo(Cambio cambio, HttpSession session) {
		ModelAndView mv = null;
		try {
			TaskCliente cliente = new TaskClienteServiceLocator().getTaskCliente();
			mv = new ModelAndView("servico/resultado");
			mv.addObject("msgm", cliente.taskcambio(cambio.getTipo(), cambio.getValor_tamandua(), cambio.getValor_real(), session.getAttribute("codigoUsuario").toString()));
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("cambio")
	public String cambio() {
		return "servico/cambio";
	}
}
