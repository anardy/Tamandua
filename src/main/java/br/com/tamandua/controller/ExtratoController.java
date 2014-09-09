package br.com.tamandua.controller;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tamandua.mode.Extrato;
import br.com.tamandua.tasks.TaskCliente;
import br.com.tamandua.tasks.TaskClienteServiceLocator;

@Controller
public class ExtratoController {

	@RequestMapping("extrato")
	public String extrato() {
		return "servico/extrato";
	}
	
	@RequestMapping("tranextrato")
	public ModelAndView transaldo(Extrato extrato) {
		ModelAndView mv = null;
		try {
			TaskCliente cliente = new TaskClienteServiceLocator().getTaskCliente();
			mv = new ModelAndView("servico/resultado");
			mv.addObject("msgm", cliente.taskextrato(String.valueOf(extrato.getNroconta()), extrato.getDatainicio(), extrato.getDatafinal()));
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}
}
