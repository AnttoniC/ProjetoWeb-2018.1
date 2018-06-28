package com.qxd.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qxd.br.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	
}


