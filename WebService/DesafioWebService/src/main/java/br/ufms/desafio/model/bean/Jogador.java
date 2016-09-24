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
package br.ufms.desafio.model.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kleberkruger
 */
@Entity
@Table(name = "jogador")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jogador.findAll", query = "SELECT j FROM Jogador j"),
    @NamedQuery(name = "Jogador.findByCodigo", query = "SELECT j FROM Jogador j WHERE j.codigo = :codigo"),
    @NamedQuery(name = "Jogador.findByDataNascimento", query = "SELECT j FROM Jogador j WHERE j.nascimento = :nascimento")
})
public class Jogador extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    protected Date nascimento;

    /**
     * @return the nascimento
     */
    public Date getDataNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setDataNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
}
