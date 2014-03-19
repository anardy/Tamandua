package br.com.tamandua.controller;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tamandua.model.Transferencia;
import br.com.tamandua.tasks.TaskCliente;
import br.com.tamandua.tasks.TaskClienteServiceLocator;

@Controller
public class TransferenciaController {

	@RequestMapping("trantransferencia")
	public ModelAndView transaldo(Transferencia transferencia) {
		ModelAndView mv = null;
		try {
			TaskCliente cliente = new TaskClienteServiceLocator()
					.getTaskCliente();
			mv = new ModelAndView("servico/transferencia");
			mv.addObject("transferencia", cliente.tasktransferencia(
					String.valueOf(transferencia.getNroconta_concedente()),
					String.valueOf(transferencia.getNroconta_beneficiado()),
					transferencia.getValor(),
					transferencia.getSenha_concedente()));
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("transferencia")
	public String transferencia() {
		return "transferencia";
	}
}
