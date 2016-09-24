package br.ufms.desafio.model.bean;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Aluno.class)
public abstract class Aluno_ extends br.ufms.desafio.model.bean.Jogador_ {

	public static volatile SingularAttribute<Aluno, Escola> escola;
	public static volatile ListAttribute<Aluno, Turma> turmas;
	public static volatile ListAttribute<Aluno, Deficiencia> deficiencias;
	public static volatile SingularAttribute<Aluno, Integer> serie;
	public static volatile SingularAttribute<Aluno, Boolean> deficiente;
	public static volatile SingularAttribute<Aluno, Date> inicio;
	public static volatile ListAttribute<Aluno, Responsavel> responsaveis;
	public static volatile SingularAttribute<Aluno, String> emailResponsavel;

}

