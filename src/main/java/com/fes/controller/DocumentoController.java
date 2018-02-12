package com.fes.controller;

import java.util.Date;
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

import com.fes.entity.Documento;
import com.fes.service.DocumentoService;

@Controller
@RequestMapping("consecutivos")
public class DocumentoController {
	
	@Autowired
	private DocumentoService documentoService;

	@GetMapping("documento/{id}")
	public ResponseEntity<Documento> find(@PathVariable("id") Integer id){
		
		Documento documento=documentoService.find(id);
		return new ResponseEntity<Documento>(documento,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://159.89.94.78:3000")
	@PostMapping("documento")
	public ResponseEntity<Void> create(@RequestBody Documento documento, UriComponentsBuilder builder){
		
		Date fecha=documento.getFecha();
		fecha.setDate(fecha.getDate()+1);
		documento.setFecha(fecha);
		boolean flag=documentoService.create(documento);
		if(flag==false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers= new HttpHeaders();
		headers.setLocation(builder.path("documento/{id}").buildAndExpand(documento.getId()).toUri());			
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);		
	}
	
	@CrossOrigin(origins = "http://159.89.94.78:3000")
	@GetMapping("documentos")
	public ResponseEntity<List<Documento>> read(){
		List<Documento> list=documentoService.read();
		return new ResponseEntity<List<Documento>>(list, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://159.89.94.78:3000")
	@PutMapping("documento")
	public ResponseEntity<Documento> update(@RequestBody Documento documento){
		
		documentoService.update(documento);
		return new ResponseEntity<Documento>(documento, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://159.89.94.78:3000")
	@DeleteMapping("documento/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
		
		documentoService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
