package com.fes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.fes.entity.Usuario;
import com.fes.service.UsuarioService;

@Controller
@RequestMapping("consecutivos")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("usuario/{cedula}")
	public ResponseEntity<Usuario> find(@PathVariable("cedula") Integer cedula){
		
		Usuario usuario=usuarioService.find(cedula);
		return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
		
	}

	@PostMapping("usuario")
	public ResponseEntity<Void> create(@RequestBody Usuario usuario, UriComponentsBuilder builder){
		
		boolean flag=usuarioService.create(usuario);
		if(flag==false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("usuario/{cedula}").buildAndExpand(usuario.getCedula()).toUri());			
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("usuarios")
	public ResponseEntity<List<Usuario>> read(){
		
		List<Usuario> list=usuarioService.read();
		return new ResponseEntity<List<Usuario>>(list,HttpStatus.OK);
	}
	
	@PutMapping("usuario")
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario){
		
		usuarioService.update(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);		
	}
	
	@DeleteMapping("usuario/{cedula}")
	public ResponseEntity<Void> delete(@PathVariable("cedula") Integer cedula){
		
		usuarioService.delete(cedula);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
