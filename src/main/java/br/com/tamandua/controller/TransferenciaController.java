package br.com.tamandua.controller;

import java.rmi.RemoteException;

import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tamandua.json.JSONObject;
import br.com.tamandua.mode.Transferencia;
import br.com.tamandua.tasks.TaskCliente;
import br.com.tamandua.tasks.TaskClienteServiceLocator;

@Controller
public class TransferenciaController {

	@RequestMapping("trantransferencia")
	public ModelAndView transaldo(Transferencia transferencia, HttpSession session) {
		ModelAndView mv = null;
		JSONObject result = new JSONObject();
		try {
			TaskCliente cliente = new TaskClienteServiceLocator()
					.getTaskCliente();
			mv = new ModelAndView("servico/resultado");
			result.put("msgm", cliente.tasktransferencia(
					String.valueOf(transferencia.getNrocontaconcedente()),
					String.valueOf(transferencia.getNrocontabeneficiado()),
					transferencia.getValor(),
					transferencia.getSenhaconcedente(),
					session.getAttribute("codigoUsuario").toString()));
			mv.addObject("msgm", result.toString());
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("transferencia")
	public String transferencia() {
		return "servico/transferencia";
	}
}
