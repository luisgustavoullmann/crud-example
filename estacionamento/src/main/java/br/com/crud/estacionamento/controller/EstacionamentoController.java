package br.com.crud.estacionamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.crud.estacionamento.dao.EstacionamentoDao;
import br.com.crud.estacionamento.entity.Estacionamento;

@Controller
@RequestMapping("estacionamento")
public class EstacionamentoController {
	
	private EstacionamentoDao dao;

	@GetMapping("cadastrar")
	public String abrirForm(Estacionamento estacionamento) {
		return "estacinamento/cadastro";
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarForm(Estacionamento estacionamento, RedirectAttributes redirect) {
		try {
			dao.cadastrar(estacionamento);
			redirect.addFlashAttribute("msg", "Estacionamento cadastrado");
		} catch (Exception e) {
			return new ModelAndView("estacionamento/cadastro").addObject("msg", 
					e.getMessage());
		}
		return new ModelAndView("redirect:/estacionamento/cadastrar");
	}
	
	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("estacionamento/lista").addObject("estacionamentos", dao.listar());
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView editar(@PathVariable("id") int codigo) {
		return new ModelAndView("estacionamento/edicao").addObject("estacionamento", dao.buscar(codigo));
	}
	
	@Transactional
	@PostMapping("editar")
	public ModelAndView editar(Estacionamento estacionamento, RedirectAttributes redirect) {
		try {
			dao.atualizar(estacionamento);
			redirect.addFlashAttribute("msg", "Atualizado");
		} catch (Exception e) {
			return new ModelAndView("estacionamento/edicao").addObject("msg", e.getMessage());
		}
		return new ModelAndView("redirect:/estacionamento/listar");
	}
	
	@Transactional
	@PostMapping("excluir")
	public ModelAndView excluir(int codigo, RedirectAttributes redirect) {
		try {
			dao.remover(codigo);
			redirect.addFlashAttribute("msg", "Excluido!");
		} catch (Exception e) {
			redirect.addFlashAttribute("msg", e.getMessage());
		}
		return new ModelAndView("redirect:/estacionamento/listar");
	}
}
