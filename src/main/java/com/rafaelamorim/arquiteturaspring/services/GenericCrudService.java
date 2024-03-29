package com.rafaelamorim.arquiteturaspring.services;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelamorim.arquiteturaspring.domain.Categoria;
import com.rafaelamorim.arquiteturaspring.services.exception.DataIntegrityException;

public class GenericCrudService<MODEL, PK, REPOSITORY extends JpaRepository<MODEL, PK>> {

	@Autowired
	REPOSITORY repository;

	MODEL model;

	public MODEL find(PK id) {
		Optional<MODEL> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(Categoria.class,
				"Objeto não encontrado! Id: " + id + ", Tipo: " + model.getClass().getName()));
	}

	@Transactional
	public MODEL insert(MODEL obj) {
		return repository.save(obj);
	}

	public MODEL update(MODEL obj) {
		find(this.getId(obj));
		return repository.save(obj);
	}

	public void delete(PK id) {
		find(id);

		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir categoria que contém produtos");
		}
	}

	public List<MODEL> findAll() {
		return repository.findAll();
	}

	@SuppressWarnings("unchecked")
	private PK getId(MODEL obj) {
		Field[] fields = obj.getClass().getDeclaredFields();

		String nomeAtributo = "";

		for (Field field : fields) {
			Annotation[] annotations = field.getAnnotations();
			for (Annotation annotation : annotations) {
				if (annotation instanceof Id) {
					nomeAtributo = field.getName();
				}
			}
		}

		String nomeMetodo = "get" + nomeAtributo.substring(0, 1).toUpperCase() + nomeAtributo.substring(1);

		System.out.println(nomeMetodo);

		PK pk = null;

		try {
			Method m = obj.getClass().getMethod(nomeMetodo, new Class[] {});

			pk = (PK) m.invoke(obj, new Object[] {});

			System.out.println(pk);

		} catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.out.println("Deu pt no processo de reflexão");
			e.printStackTrace();
		} 

		return pk;
	}

}
