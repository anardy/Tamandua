package br.com.tamandua.controller;

import java.rmi.RemoteException;

import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tamandua.json.JSONObject;
import br.com.tamandua.mode.Saque;
import br.com.tamandua.tasks.TaskCliente;
import br.com.tamandua.tasks.TaskClienteServiceLocator;

@Controller
public class SaqueController {
	
	@RequestMapping("saque")
	public String saldo() {
		return "servico/saque";
	}
	
	@RequestMapping("transaque")
	public ModelAndView transaldo(Saque saque, HttpSession session) {
		ModelAndView mv = null;
		JSONObject result = new JSONObject();
		try {
			TaskCliente cliente = new TaskClienteServiceLocator().getTaskCliente();
			mv = new ModelAndView("servico/resultado");
			result.put("msgm", cliente.tasksaque(String.valueOf(saque.getNroconta()), saque.getValor(), saque.getSenha(), session.getAttribute("codigoUsuario").toString()));
			mv.addObject("msgm", result.toString());
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}

}
