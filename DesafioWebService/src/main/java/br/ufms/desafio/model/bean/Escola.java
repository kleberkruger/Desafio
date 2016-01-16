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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kleberkruger
 */
@Entity
@Table(name = "escola")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escola.findAll", query = "SELECT e FROM Escola e"),
    @NamedQuery(name = "Escola.findByCodigo", query = "SELECT e FROM Escola e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "Escola.findByTipo", query = "SELECT e FROM Escola e WHERE e.tipo = :tipo")
})
public class Escola extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEscola tipo;

    @JoinTable(name = "escola_professor", joinColumns = {
        @JoinColumn(name = "codigo_escola", referencedColumnName = "codigo")}, inverseJoinColumns = {
        @JoinColumn(name = "codigo_professor", referencedColumnName = "codigo")})
    @ManyToMany
    private List<Professor> professores;

    @OneToMany(mappedBy = "escola")
    private List<Aluno> alunos;

    @OneToMany(mappedBy = "escola")
    private List<Turma> turmas;

    /**
     * @return the tipo
     */
    public TipoEscola getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoEscola tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the professores
     */
    @XmlTransient
    public List<Professor> getProfessores() {
        return professores;
    }

    /**
     * @param professores the professores to set
     */
    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
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

    /**
     * @return the turmas
     */
    @XmlTransient
    public List<Turma> getTurmas() {
        return turmas;
    }

    /**
     * @param turmas the turmas to set
     */
    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

}
