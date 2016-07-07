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
package br.ufms.desafio.model.dao;

import br.ufms.desafio.model.bean.Entidade;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author kleberkruger
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class HibernateDAO<E extends Entidade> {

    protected Class<E> clazz;
    protected Session session;

    @Autowired
    private SessionFactory sessionFactory;

    /**
     *
     * @param clazz
     */
    public HibernateDAO(Class<E> clazz) {
        this.clazz = clazz;
    }

    /**
     *
     * @param entity
     */
    public void save(E entity) {
        getSession().save(entity);
    }

    /**
     *
     * @param entity
     */
    public void update(E entity) {
        getSession().update(entity);
    }

    /**
     *
     * @param entity
     */
    public void saveOrUpdate(E entity) {
        getSession().saveOrUpdate(entity);
    }

    /**
     *
     * @param entity
     */
    public void delete(E entity) {
        getSession().delete(entity);
    }

    /**
     *
     * @param id
     * @return
     */
    public E load(Serializable id) {
        return (E) getSession().load(this.clazz, id);
    }

    /**
     *
     * @param id
     * @return
     */
    public E get(Serializable id) {
        return (E) getSession().get(this.clazz, id);
    }

    /**
     *
     * @return
     */
    public List<E> getAll() {
        return getSession().createQuery("FROM " + clazz.getName()).list();
    }

    /**
     *
     * @param query
     * @return
     */
    protected Query createQuery(String query) {
        return getSession().createQuery(query);
    }

    /**
     *
     * @return
     */
    protected Criteria createCriteria() {
        return getSession().createCriteria(this.clazz);
    }

    /**
     *
     * @param sessionFactory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     *
     * @return
     */
    public Session getSession() {
        if (sessionFactory != null) {
            session = sessionFactory.getCurrentSession();
        }
        if (session == null) {
            throw new RuntimeException("Hibernate session is null");
        }
        return session;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
