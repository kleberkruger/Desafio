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

import br.ufms.desafio.model.bean.Municipio;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author kleberkruger
 */
@Component
@SuppressWarnings("unchecked")
public class MunicipioDAO extends HibernateDAO<Municipio> {

    public MunicipioDAO() {
        super(Municipio.class);
    }

    /**
     * Busca um município pelo nome.
     *
     * @param nome
     * @return
     */
    public List<Municipio> findByName(String nome) {
        Query q = getSession().createQuery("FROM Municipio WHERE LOWER(nome) LIKE LOWER(?)");
        q.setString(0, "%" + nome + "%");
        return q.list();
    }

    /**
     * Consulta os municípios de um estado
     *
     * @param uf
     * @return
     */
    public List<Municipio> findByUF(String uf) {
        Query q = getSession().createQuery("FROM Municipio WHERE uf = ?");
        q.setString(0, uf);
        return q.list();
    }

}
