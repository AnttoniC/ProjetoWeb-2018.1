package com.qxd.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.qxd.br.model.Produto;
import com.qxd.br.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping("/cadastro")
	public ModelAndView formularioProduto() {
		ModelAndView mv = new ModelAndView("cadastro");
		mv.addObject("produto", new Produto());
		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView salvarProduto(Produto produto,@RequestParam(value= "imagem") MultipartFile imagem) {
		produtoService.adicionarProduto(produto,imagem);
		
		ModelAndView mv = new ModelAndView("redirect:/produto/listar");
		
		return mv;
	}
	@GetMapping("/listar")
	public ModelAndView listarProduto() {
		List<Produto> produtos = produtoService.retornarTodosOsProdutos();
		ModelAndView mv = new ModelAndView("gallery");
		
		mv.addObject("todosOsProdutos", produtos);
		
		
		return mv;
	}
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluirPessoa(@PathVariable Long id) {
		produtoService.removerProduto(id);
		ModelAndView mv = new ModelAndView("redirect:/produto/listar");
		return mv;
	}
	
	
}
