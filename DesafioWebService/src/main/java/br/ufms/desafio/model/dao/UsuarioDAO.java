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

import br.ufms.desafio.model.bean.Usuario;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author kleberkruger
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class UsuarioDAO<E extends Usuario> extends HibernateDAO<E> {

    public UsuarioDAO(Class<E> clazz) {
        super(clazz);
    }

    public List<E> findByNome(String nome) {
        Query q = getSession().createQuery("FROM Usuario WHERE LOWER(nome) LIKE LOWER(?)");
        q.setString(0, "%" + nome + "%");
        return q.list();
    }

    public List<E> findByEmail(String email) {
        Query q = getSession().createQuery("FROM Usuario WHERE LOWER(email) LIKE LOWER(?)");
        q.setString(0, "%" + email + "%");
        return q.list();
    }

    public List<E> findByUsuario(String usuario) {
        Query q = getSession().createQuery("FROM Usuario WHERE LOWER(usuario) LIKE LOWER(?)");
        q.setString(0, "%" + usuario + "%");
        return q.list();
    }

    public List<E> findByDataCriacao(Date criacao) {
        Query q = getSession().createQuery("FROM Usuario WHERE criacao = ?");
        q.setDate(0, criacao);
        return q.list();
    }
}
