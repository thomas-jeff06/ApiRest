package br.ufc.web.atividade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.web.atividade.model.Funcionario;
import br.ufc.web.atividade.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository funRepo;
	
	public Funcionario addFuncionario(String nome, String cargo, String nascimento, String data) {
		Funcionario fun = new Funcionario(nome, cargo, nascimento, data);
		return funRepo.save(fun);
	}
	
	public boolean removeFuncionario(Integer id) {
		if(funRepo.existsById(id)) {
			funRepo.deleteById(id);
			return true;
		}
		
		return false;
	}
	
	public List<Funcionario> getFuncionarios() {
		return funRepo.findAll();
	}
	
	public Funcionario getFuncionario(Integer id) {
		return funRepo.findById(id).get();
	}
	
	public List<Funcionario> getAllsByCargo(String cargo) {
		return (List<Funcionario>) funRepo.findAllsByCargo(cargo);
	}
	
	public Funcionario updateFuncionario(Integer id, String nome, String cargo, String nascimento, String data) {
		Funcionario funAux = funRepo.findById(id).get();
		
		if(funAux != null) {
			funAux.setNome(nome);
			funAux.setCargo(cargo);
			funAux.setNascimento(nascimento);
			funAux.setData(data);
			funRepo.save(funAux);			
		}
		
		return funAux;
	}
}