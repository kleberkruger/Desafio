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
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kleberkruger
 */
@Entity
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findByCodigo", query = "SELECT a FROM Aluno a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Aluno.findByEmailResponsavel", query = "SELECT a FROM Aluno a WHERE a.emailResponsavel = :emailResponsavel"),
    @NamedQuery(name = "Aluno.findBySerie", query = "SELECT a FROM Aluno a WHERE a.serie = :serie"),
    @NamedQuery(name = "Aluno.findByDeficiente", query = "SELECT a FROM Aluno a WHERE a.deficiente = :deficiente"),
    @NamedQuery(name = "Aluno.findByDataInicio", query = "SELECT a FROM Aluno a WHERE a.inicio = :inicio")
})
public class Aluno extends Jogador implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "email_responsavel", nullable = true)
    private String emailResponsavel;

    @Column(name = "serie", nullable = true)
    private Integer serie;

    @Column(name = "deficiente", nullable = true)
    private Boolean deficiente;

    @ManyToMany
    private List<Deficiencia> deficiencias;

    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date inicio;
    
    @ManyToMany(mappedBy = "alunos")
    private List<Responsavel> responsaveis;

    @ManyToMany(mappedBy = "alunos")
    private List<Turma> turmas;

    @JoinColumn(name = "codigo_escola", referencedColumnName = "codigo", nullable = true)
    @ManyToOne
    private Escola escola;
    
    /**
     * @return the emailResponsavel
     */
    public String getEmailResponsavel() {
        return emailResponsavel;
    }

    /**
     * @param emailResponsavel the emailResponsavel to set
     */
    public void setEmailResponsavel(String emailResponsavel) {
        this.emailResponsavel = emailResponsavel;
    }

    /**
     * @return the serie
     */
    public Integer getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    /**
     * @return the deficiente
     */
    public Boolean getDeficiente() {
        return deficiente;
    }

    /**
     * @param deficiente the deficiente to set
     */
    public void setDeficiente(Boolean deficiente) {
        this.deficiente = deficiente;
    }

    /**
     * @return the deficiencias
     */
    public List<Deficiencia> getDeficiencias() {
        return deficiencias;
    }

    /**
     * @param deficiencias the deficiencias to set
     */
    public void setDeficiencias(List<Deficiencia> deficiencias) {
        this.deficiencias = deficiencias;
    }

    /**
     * @return the inicio
     */
    public Date getDataInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setDataInicio(Date inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the responsaveis
     */
    @XmlTransient
    public List<Responsavel> getResponsaveis() {
        return responsaveis;
    }

    /**
     * @param responsaveis the responsaveis to set
     */
    public void setResponsaveis(List<Responsavel> responsaveis) {
        this.responsaveis = responsaveis;
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

}
