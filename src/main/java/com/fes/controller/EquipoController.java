package com.fes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.fes.entity.Equipo;
import com.fes.service.EquipoService;

@Controller
@RequestMapping("consecutivos")
public class EquipoController {

	@Autowired
	private EquipoService equipoService;

	@GetMapping("equipo/{id}")
	public ResponseEntity<Equipo> find(@PathVariable("id") Integer id) {

		Equipo equipo = equipoService.find(id);
		return new ResponseEntity<Equipo>(equipo, HttpStatus.OK);

	}

	@PostMapping("equipo")
	public ResponseEntity<Void> create(@RequestBody Equipo equipo, UriComponentsBuilder builder) {

		boolean flag = equipoService.create(equipo);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("equipo/{id}").buildAndExpand(equipo.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("equipos")
	public ResponseEntity<List<Equipo>> read() {
		
		List<Equipo> list = equipoService.read();
		return new ResponseEntity<List<Equipo>>(list, HttpStatus.OK);
	}

	@PutMapping("equipo")
	public ResponseEntity<Equipo> update(@RequestBody Equipo equipo) {

		equipoService.update(equipo);
		return new ResponseEntity<Equipo>(equipo, HttpStatus.OK);
	}

	@DeleteMapping("equipo/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {

		equipoService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
