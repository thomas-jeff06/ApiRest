package br.ufc.web.atividade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.web.atividade.model.Funcionario;
import br.ufc.web.atividade.service.FuncionarioService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/funs")
public class FuncionarioController {

	@Autowired
	FuncionarioService funService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Funcionario>> getFunionarios() {
		return new ResponseEntity<List<Funcionario>>(funService.getFuncionarios(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ResponseEntity<Funcionario> getUser(@PathVariable("id") Integer id) {
		return new ResponseEntity<Funcionario>(funService.getFuncionario(id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<List<Funcionario>> getAllsByCargo(@RequestParam("cargo") String cargo) {
		return new ResponseEntity<List<Funcionario>>(funService.getAllsByCargo(cargo), HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Funcionario> addFuncionario(@RequestBody Funcionario fun) {
		return new ResponseEntity<Funcionario>(funService.addFuncionario(fun.getNome(), fun.getCargo(), fun.getNascimento(), fun.getData()), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public ResponseEntity<Funcionario> updateFuncionario(@PathVariable("id") Integer id, @RequestBody Funcionario fun) {
		return new ResponseEntity<Funcionario>(funService.updateFuncionario(id, fun.getNome(), fun.getCargo(), fun.getNascimento(), fun.getData()), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public ResponseEntity<Void> deleteFuncionario(@PathVariable("id") Integer id) {
		if (funService.removeFuncionario(id)) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
