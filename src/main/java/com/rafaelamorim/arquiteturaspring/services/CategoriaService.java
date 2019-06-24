package com.rafaelamorim.arquiteturaspring.services;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rafaelamorim.arquiteturaspring.domain.Categoria;
import com.rafaelamorim.arquiteturaspring.repositories.CategoriaRepository;
import com.rafaelamorim.arquiteturaspring.services.exception.DataIntegrityException;

@Service
public class CategoriaService extends GenericCrudService<Categoria, Integer, CategoriaRepository> {
	
	@Override
	public void delete(Integer id) {
		//Regras de negocio podem ser implementadas aqui 
		super.delete(id);
	}
}
