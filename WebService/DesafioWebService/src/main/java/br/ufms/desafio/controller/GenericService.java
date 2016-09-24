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
package br.ufms.desafio.controller;

import br.ufms.desafio.model.bean.Entidade;
import br.ufms.desafio.model.dao.HibernateDAO;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kleberkruger
 *
 * @param <DAO>
 * @param <E>
 */
public class GenericService <E extends Entidade, DAO extends HibernateDAO<E>> {

    @Autowired
    protected DAO db;
    
    /**
     *
     * @param entity
     */
    @Transactional(rollbackFor = Exception.class)
    public void save(E entity) {
        db.saveOrUpdate(entity);
    }
    
    /**
     *
     * @param entity
     */
    @Transactional(rollbackFor = Exception.class)
    public void delete(E entity) {
        db.delete(entity);
    }

    /**
     *
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    public void delete(Serializable id) {
        db.delete(db.get(id));
    }

    /**
     *
     * @param id
     * @return
     */
    public E get(Serializable id) {
        return db.get(id);
    }

    /**
     *
     * @return
     */
    public List<E> getAll() {
        return db.getAll();
    }
}
