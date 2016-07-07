/*
 * Copyright (C) 2016 kleberkruger
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.ufms.desafio.test.junit;

import br.ufms.desafio.controller.GenericService;
import br.ufms.desafio.model.bean.Entidade;
import br.ufms.desafio.model.dao.HibernateDAO;
import br.ufms.desafio.test.junit.util.SpringUtil;

import java.lang.reflect.Field;
import javax.persistence.Id;

import org.junit.Test;


/**
 * Classe que define os métodos básicos de teste e inicializa o framework
 * spring.
 *
 * A herança para a classe TestCase foi comentada, porque com a classe TestCase
 * a anotação @Test não funciona. Com a classe TestCase, para se criar um método
 * de teste é necessário iniciar o nome do método com test. Exemplo: testSave()
 *
 * @author kleberkruger
 * @param <E>
 * @param <S>
 */
public abstract class JUnitTestBase<E extends Entidade, S extends GenericService<E, ? extends HibernateDAO<E>>> /*extends TestCase*/ {

    protected S service;

    public JUnitTestBase(Class<E> entityClass, Class<S> serviceClass) {
        // Cria o "bean" pelo Spring.
        service = (S) SpringUtil.getInstance().getBean(serviceClass);
    }
    
    private Field findFieldInClass(Class clazz, String name) {
        try {
            return clazz.getDeclaredField(name);
        } catch (NoSuchFieldException | SecurityException ex) {
        }
        return null;
    }

    protected Field getIdField(Class clazz) throws NoSuchFieldException {
        Field attr;
        // Tenta achar o atributo "codigo" desta classe
        attr = findFieldInClass(clazz, "codigo");
        if (attr != null) {
            return attr;
        }
        // Se não consegui, tenta achar por "id"
        attr = findFieldInClass(clazz, "id");
        if (attr != null) {
            return attr;
        }
        // Se ainda não deu certo, procura em todos os atributos o que tem a anotacion @Id
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getAnnotation(Id.class) != null) {
                return field;
            }
        }
        // Não tem nenhum atributo com anotação @Id nesta classe, olhe na superclasse
        if (attr == null) {
            Class superclass = clazz.getSuperclass();
            if (superclass != null) {
                attr = getIdField(superclass);
            } else {
                throw new NoSuchFieldException("Nenhum atributo ID encontrado");
            }
        }

        return attr;
    }
    
    protected Field getFieldByName(Class clazz, String fieldName) throws NoSuchFieldException {
        Field field;
        // Tenta achar o atributo com o nome informado na classe atual
        field = findFieldInClass(clazz, fieldName);
        if (field != null) {
            return field;
        }
        if (field == null) {
            Class superclass = clazz.getSuperclass();
            if (superclass != null) {
                field = getIdField(superclass);
            } else {
                throw new NoSuchFieldException("Nenhum atributo " + fieldName + " encontrado");
            }
        }

        return field;
    }

    @Test
    public abstract void testSave();

    @Test
    public abstract void testDelete();

    @Test
    public abstract void testGet();

    @Test
    public abstract void testGetAll();
    
    @Test
    public abstract void testPostGetPutDelete();

}
