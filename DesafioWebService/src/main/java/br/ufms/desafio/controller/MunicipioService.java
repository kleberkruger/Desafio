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

import br.ufms.desafio.model.bean.Municipio;
import br.ufms.desafio.model.dao.MunicipioDAO;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author kleberkruger
 */
@Component
public class MunicipioService extends GenericService<Municipio, MunicipioDAO> {

    public List<Municipio> findByName(String name) {
        return db.findByName(name);
    }

    public List<Municipio> findByUF(String uf) {
        return db.findByUF(uf);
    }

}
