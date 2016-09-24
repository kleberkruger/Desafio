package br.ufms.desafio.model.bean;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Turma.class)
public abstract class Turma_ {

	public static volatile SingularAttribute<Turma, Long> codigo;
	public static volatile SingularAttribute<Turma, Professor> professor;
	public static volatile SingularAttribute<Turma, Escola> escola;
	public static volatile SingularAttribute<Turma, Periodo> periodo;
	public static volatile ListAttribute<Turma, Aluno> alunos;
	public static volatile SingularAttribute<Turma, String> nome;

}

