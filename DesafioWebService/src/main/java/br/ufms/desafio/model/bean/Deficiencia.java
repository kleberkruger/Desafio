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
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kleberkruger
 */
@Entity
@Table(name = "deficiencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deficiencia.findAll", query = "SELECT d FROM Deficiencia d"),
    @NamedQuery(name = "Deficiencia.findByCodigo", query = "SELECT d FROM Deficiencia d WHERE d.codigo = :codigo"),
    @NamedQuery(name = "Deficiencia.findByTipo", query = "SELECT d FROM Deficiencia d WHERE d.tipo = :tipo")})
public class Deficiencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TipoDeficiencia codigo;

    @Column(name = "tipo", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private TipoDeficiencia tipo;

    @ManyToMany(mappedBy = "deficiencias")
    private List<Aluno> alunos;

    /**
     * @return the codigo
     */
    public TipoDeficiencia getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(TipoDeficiencia codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the tipo
     */
    public TipoDeficiencia getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoDeficiencia tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the alunos
     */
    @XmlTransient
    public List<Aluno> getAlunos() {
        return alunos;
    }

    /**
     * @param alunos the alunos to set
     */
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * Warning - this method won't work in the case the id fields are not set.
     *
     * @param object the other object
     * @return true if both objects have the same ID
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Deficiencia)) {
            return false;
        }
        Deficiencia other = (Deficiencia) object;
        return !((this.codigo == null && other.codigo != null)
                || (this.codigo != null && !this.codigo.equals(other.codigo)));
    }

    @Override
    public String toString() {
        return getClass().toString() + "[codigo=" + codigo + "]";
    }

}
