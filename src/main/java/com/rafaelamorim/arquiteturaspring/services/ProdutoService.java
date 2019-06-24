package com.rafaelamorim.arquiteturaspring.services;

import org.springframework.stereotype.Service;

import com.rafaelamorim.arquiteturaspring.domain.Produto;
import com.rafaelamorim.arquiteturaspring.repositories.ProdutoRepository;

@Service
public class ProdutoService extends GenericCrudService<Produto, Integer, ProdutoRepository>{
	
	

}
