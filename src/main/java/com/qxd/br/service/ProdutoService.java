package com.qxd.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qxd.br.model.Produto;
import com.qxd.br.repository.ProdutoRepository;
import com.qxd.br.util.ArquivoUtils;

@Service
public class ProdutoService {


	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public void adicionarProduto(Produto produto, MultipartFile imagem) {
		
		produtoRepository.save(produto);
		String caminho = "imagem/" + produto.getId() + ".png";
		ArquivoUtils.salvarImagem(caminho,imagem);
		
		
	}
	public List<Produto> retornarTodosOsProdutos() {
		
		return produtoRepository.findAll();
	}
	public void removerProduto(Long id) {
		produtoRepository.deleteById(id);
		
	}
	public Produto buscarPorId(Long id) {
		return produtoRepository.getOne(id);
	}

	

	
}
