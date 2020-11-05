package br.ufc.web.atividade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.web.atividade.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	
	List<Funcionario> findAllsByCargo(String cargo);

}

