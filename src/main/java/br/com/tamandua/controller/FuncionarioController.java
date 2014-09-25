package br.com.tamandua.controller;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tamandua.mode.Funcionario;
import br.com.tamandua.hash.SenhaHash;
import br.com.tamandua.json.JSONObject;
import br.com.tamandua.tasks.TaskCliente;
import br.com.tamandua.tasks.TaskClienteServiceLocator;

@Controller
public class FuncionarioController {

	@RequestMapping("gerente/funcionario")
	public String funcionario() {
		return "gerente/funcionario/funcionario";
	}
	
	@RequestMapping("cadFuncionario")
	public String cadCliente() {
		return "gerente/funcionario/cadastrar";
	}
	
	@RequestMapping("pesquisaFuncionario")
	public ModelAndView pesquisaFuncionario(Funcionario funcionario) {
		ModelAndView mv = null;
		JSONObject result = new JSONObject();
		try {
			TaskCliente task = new TaskClienteServiceLocator().getTaskCliente();
			mv = new ModelAndView("servico/resultado");
			result.put("msgm", task.taskconsultaFuncionario(funcionario.getCpf()));
			mv.addObject("msgm", result.toString());
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("inserirFuncionario")
	public ModelAndView inserir(Funcionario funcionario) {
		ModelAndView mv = null;
		JSONObject result = new JSONObject();
		try {
			String senhaHash = new SenhaHash().hash_senha(funcionario.getSenha());
			TaskCliente task = new TaskClienteServiceLocator().getTaskCliente();
			result.put("msgm", task.taskinserirFuncionario(funcionario.getCpf(), funcionario.getNome(), funcionario.getLogin(), senhaHash, funcionario.getStatus(), funcionario.getFuncao()));
			mv = new ModelAndView("gerente/funcionario/resultado");
			mv.addObject("msgm", result.toString());
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("removerFuncionario")
	public ModelAndView remover(Funcionario funcionario) {
		ModelAndView mv = null;
		JSONObject result = new JSONObject();
		try {
			TaskCliente task = new TaskClienteServiceLocator().getTaskCliente();
			result.put("msgm", task.taskremoverFuncionario(funcionario.getCpf()));
			mv = new ModelAndView("gerente/funcionario/resultado");
			mv.addObject("msgm", result.toString());
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("editarFuncionario")
	public ModelAndView editar(Funcionario funcionario) {
		ModelAndView mv = null;
		JSONObject result = new JSONObject();
		try {
			TaskCliente task = new TaskClienteServiceLocator().getTaskCliente();
			result.put("msgm", task.taskeditarFuncionario(funcionario.getCpf(), funcionario.getNome(), funcionario.getLogin(), funcionario.getSenha(), funcionario.getStatus(), funcionario.getFuncao()));
			mv = new ModelAndView("gerente/funcionario/resultado");
			mv.addObject("msgm", result.toString());
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}
}
