package br.ufms.desafio.model.bean;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Escola.class)
public abstract class Escola_ extends br.ufms.desafio.model.bean.Usuario_ {

	public static volatile SingularAttribute<Escola, TipoEscola> tipo;
	public static volatile ListAttribute<Escola, Aluno> alunos;
	public static volatile ListAttribute<Escola, Turma> turmas;
	public static volatile ListAttribute<Escola, Professor> professores;

}

