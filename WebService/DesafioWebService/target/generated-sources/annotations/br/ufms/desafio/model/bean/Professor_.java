package br.ufms.desafio.model.bean;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Professor.class)
public abstract class Professor_ extends br.ufms.desafio.model.bean.Jogador_ {

	public static volatile SingularAttribute<Professor, Titulacao> titulacao;
	public static volatile ListAttribute<Professor, Turma> turmas;
	public static volatile ListAttribute<Professor, Escola> escolas;

}

