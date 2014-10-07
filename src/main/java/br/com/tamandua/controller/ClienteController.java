package br.com.tamandua.controller;

import java.rmi.RemoteException;

import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tamandua.hash.SenhaHash;
import br.com.tamandua.json.JSONObject;
import br.com.tamandua.mode.Cliente;
import br.com.tamandua.tasks.TaskCliente;
import br.com.tamandua.tasks.TaskClienteServiceLocator;

@Controller
public class ClienteController {

	@RequestMapping("cliente")
	public String cliente() {
		return "gerente/cliente/cliente";
	}
	
	@RequestMapping("pesquisaCliente")
	public ModelAndView pesquisaCliente(Cliente cliente, HttpSession session) {
		ModelAndView mv = null;
		JSONObject result = new JSONObject();
		try {
			TaskCliente task = new TaskClienteServiceLocator().getTaskCliente();
			mv = new ModelAndView("servico/resultado");
			result.put("msgm", task.taskconsultaCliente(cliente.getCpf()));
			mv.addObject("msgm", result.toString());
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("cadCliente")
	public String cadCliente() {
		return "gerente/cliente/cadastrar";
	}
	
	@RequestMapping("inserirCliente")
	public ModelAndView inserir(Cliente cliente) {
		ModelAndView mv = null;
		JSONObject result = new JSONObject();
		try {
			TaskCliente task = new TaskClienteServiceLocator().getTaskCliente();
			result.put("msgm", task.taskinserirCliente(cliente.getCpf(), cliente.getNome(), cliente.getTelefone(), cliente.getEndereco(), cliente.getStatus()));
			mv = new ModelAndView("gerente/cliente/resultado");
			mv.addObject("msgm", result.toString());
			String senhaHash = new SenhaHash().hash_senha(cliente.getSenhaConta());
			task.taskcriarConta(cliente.getCpf(), senhaHash);
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("removerCliente")
	public ModelAndView remover(Cliente cliente) {
		ModelAndView mv = null;
		JSONObject result = new JSONObject();
		try {
			TaskCliente task = new TaskClienteServiceLocator().getTaskCliente();
			result.put("msgm", task.taskremoverCliente(cliente.getCpf()));
			mv = new ModelAndView("gerente/cliente/resultado");
			mv.addObject("msgm", result.toString());
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("editarCliente")
	public ModelAndView editar(Cliente cliente) {
		ModelAndView mv = null;
		JSONObject result = new JSONObject();
		try {
			TaskCliente task = new TaskClienteServiceLocator().getTaskCliente();
			result.put("msgm", task.taskeditarCliente(cliente.getCpf(), cliente.getNome(), cliente.getTelefone(), cliente.getEndereco(), cliente.getStatus()));
			mv = new ModelAndView("gerente/cliente/resultado");
			mv.addObject("msgm", result.toString());
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mv;
	}
}
