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

import br.ufms.desafio.model.bean.Usuario;
import br.ufms.desafio.model.dao.UsuarioDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kleberkruger
 * @param <E>
 * @param <DAO>
 */
public class UsuarioService<E extends Usuario, DAO extends UsuarioDAO<E>>
        extends GenericService<E, DAO> {
    
    public List<E> findByNome(String nome) {
        return db.findByNome(nome);
    }

    public List<E> findByEmail(String email) {
        return db.findByEmail(email);
    }

    public List<E> findByUsuario(String usuario) {
        return db.findByUsuario(usuario);
    }

    public List<E> findByDataCriacao(Date criacao) {
        return db.findByDataCriacao(criacao);
    }
}
