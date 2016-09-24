package br.ufms.desafio.model.bean;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Deficiencia.class)
public abstract class Deficiencia_ {

	public static volatile SingularAttribute<Deficiencia, TipoDeficiencia> codigo;
	public static volatile SingularAttribute<Deficiencia, TipoDeficiencia> tipo;
	public static volatile ListAttribute<Deficiencia, Aluno> alunos;

}

