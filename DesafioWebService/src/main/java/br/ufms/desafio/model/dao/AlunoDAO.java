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

import br.ufms.desafio.model.bean.Aluno;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author kleberkruger
 */
@Component
@SuppressWarnings("unchecked")
public class AlunoDAO extends HibernateDAO<Aluno> {

    public AlunoDAO() {
        super(Aluno.class);
    }

    /**
     * Busca um aluno pelo nome.
     *
     * @param nome
     * @return
     */
    public List<Aluno> findByName(String nome) {
        Query q = getSession().createQuery("FROM Aluno WHERE LOWER(nome) LIKE LOWER(?)");
        q.setString(0, "%" + nome + "%");
        return q.list();
    }
    
}
