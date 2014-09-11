package br.com.tamandua.controller;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tamandua.json.JSONObject;
import br.com.tamandua.mode.Conta;
import br.com.tamandua.tasks.TaskCliente;
import br.com.tamandua.tasks.TaskClienteServiceLocator;

@Controller
public class SaldoController {

	@RequestMapping(value="transaldo", produces="application/json")
	public ModelAndView transaldo(Conta conta) {
		ModelAndView mv = null;
		JSONObject result = new JSONObject();
		try {
			TaskCliente cliente = new TaskClienteServiceLocator().getTaskCliente();
			mv = new ModelAndView("servico/resultado");
			result.put("msgm", cliente.tasksaldo(String.valueOf(conta.getNroconta()), conta.getSenha()));
			mv.addObject("msgm", result.toString());
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("saldo")
	public String saldo() {
		return "servico/saldo";
	}
}
