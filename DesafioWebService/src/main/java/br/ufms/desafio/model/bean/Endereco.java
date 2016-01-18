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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "endereco")
@XmlRootElement
@NamedQueries({
    // TODO: Como buscar pelo município? //
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.findByCodigo", query = "SELECT e FROM Endereco e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "Endereco.findByLogradouro", query = "SELECT e FROM Endereco e WHERE e.logradouro = :logradouro"),
    @NamedQuery(name = "Endereco.findByNumero", query = "SELECT e FROM Endereco e WHERE e.numero = :numero"),
    @NamedQuery(name = "Endereco.findBySemNumero", query = "SELECT e FROM Endereco e WHERE e.sn = :sn"),
    @NamedQuery(name = "Endereco.findByComplemento", query = "SELECT e FROM Endereco e WHERE e.complemento = :complemento"),
    @NamedQuery(name = "Endereco.findByBairro", query = "SELECT e FROM Endereco e WHERE e.bairro = :bairro"),
    @NamedQuery(name = "Endereco.findByCep", query = "SELECT e FROM Endereco e WHERE e.cep = :cep")
})
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo")
    private Long codigo;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "s_n")
    private Boolean sn;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cep")
    private String cep;

    @JoinColumn(name = "codigo_municipio", referencedColumnName = "codigo")
    @ManyToOne
    private Municipio municipio;

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
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the sn
     */
    public Boolean getSemNumero() {
        return sn;
    }

    /**
     * @param sn the sn to set
     */
    public void setSemNumero(Boolean sn) {
        this.sn = sn;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the municipio
     */
    public Municipio getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
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
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        return !((this.codigo == null && other.codigo != null)
                || (this.codigo != null && !this.codigo.equals(other.codigo)));
    }

    @Override
    public String toString() {
        return getClass().toString() + "[codigo=" + codigo + "]";
    }

}
