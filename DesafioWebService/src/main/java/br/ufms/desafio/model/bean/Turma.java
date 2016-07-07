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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kleberkruger
 */
@Entity
@Table(name = "turma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turma.findAll", query = "SELECT t FROM Turma t"),
    @NamedQuery(name = "Turma.findByCodigo", query = "SELECT t FROM Turma t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "Turma.findByNome", query = "SELECT t FROM Turma t WHERE t.nome = :nome"),
    @NamedQuery(name = "Turma.findByPeriodo", query = "SELECT t FROM Turma t WHERE t.periodo = :periodo")
})
public class Turma extends Entidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(name = "nome", nullable = false)
    private String nome;

    @JoinColumn(name = "codigo_escola", referencedColumnName = "codigo")
    @ManyToOne(optional = true)
    private Escola escola;

    @JoinColumn(name = "codigo_professor", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Professor professor;

    @JoinTable(name = "turma_aluno", joinColumns = {
        @JoinColumn(name = "codigo_turma", referencedColumnName = "codigo")}, inverseJoinColumns = {
        @JoinColumn(name = "codigo_aluno", referencedColumnName = "codigo")
    })
    @ManyToMany
    private List<Aluno> alunos;

    @Column(name = "periodo", nullable = true)
    @Enumerated(EnumType.STRING)
    private Periodo periodo;

    /**
     * @return the codigo
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the escola
     */
    public Escola getEscola() {
        return escola;
    }

    /**
     * @param escola the escola to set
     */
    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    /**
     * @return the professor
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     * @return the alunos
     */
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
     * @return the periodo
     */
    public Periodo getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
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
        if (!(object instanceof Turma)) {
            return false;
        }
        Turma other = (Turma) object;
        return !((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo)));
    }

    @Override
    public String toString() {
        return getClass().toString() + "[codigo=" + codigo + "]";
    }

}
