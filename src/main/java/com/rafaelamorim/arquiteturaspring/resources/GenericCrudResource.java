package com.rafaelamorim.arquiteturaspring.resources;

import com.rafaelamorim.arquiteturaspring.services.GenericCrudService;

public class GenericCrudResource<MODEL, PK, SERVICE extends GenericCrudService> {
	
	/*
	@Autowired
	SERVICE service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable PK id) {
		MODEL obj = (MODEL) service.find(id);
		return ResponseEntity.ok().body(obj);
	} 
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Categoria> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody MODEL obj) {
		obj = (MODEL) service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody MODEL obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	} */
}
