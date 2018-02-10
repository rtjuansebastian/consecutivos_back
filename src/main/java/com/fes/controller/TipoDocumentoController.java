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

import com.fes.entity.TipoDocumento;
import com.fes.service.TipoDocumentoService;

@Controller
@RequestMapping("consecutivos")
public class TipoDocumentoController {
	
	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	
	@GetMapping("tipoDocumento/{id}")
	public ResponseEntity<TipoDocumento> find(@PathVariable("id") Integer id){
		
		TipoDocumento tipoDoc=tipoDocumentoService.find(id);
		return new ResponseEntity<TipoDocumento>(tipoDoc,HttpStatus.OK);
	}

	@PostMapping("tipoDocumento")
	public ResponseEntity<Void> create(@RequestBody TipoDocumento tipoDocumento, UriComponentsBuilder builder ){
		
		boolean flag=tipoDocumentoService.create(tipoDocumento);
		if(flag==false) {			
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("tipoDocumento/{id}").buildAndExpand(tipoDocumento.getId()).toUri());		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("tiposDocumentos")
	public ResponseEntity<List<TipoDocumento>> read(){
		
		List<TipoDocumento> list=tipoDocumentoService.read();
		return new ResponseEntity<List<TipoDocumento>>(list, HttpStatus.OK);
	}
	
	@PutMapping("tipoDocumento")
	public ResponseEntity<TipoDocumento> update(@RequestBody TipoDocumento tipoDocumento){
		
		tipoDocumentoService.update(tipoDocumento);
		return new ResponseEntity<TipoDocumento>(tipoDocumento,HttpStatus.OK);
	}
	
	@DeleteMapping("tipoDocumento/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		tipoDocumentoService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
