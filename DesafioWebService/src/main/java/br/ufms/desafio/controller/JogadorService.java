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

import br.ufms.desafio.model.bean.Jogador;
import br.ufms.desafio.model.dao.JogadorDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kleberkruger
 * @param <E>
 * @param <DAO>
 */
public class JogadorService <E extends Jogador, DAO extends JogadorDAO<E>>
        extends GenericService<E, DAO>{
    
    public List<E> findByDataNascimento(Date nascimento) {
        return db.findByDataNascimento(nascimento);
    }
}
