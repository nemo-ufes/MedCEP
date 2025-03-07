/*
 * SoMeSPC - powerful tool for measurement
 * 
 * Copyright (C) 2013 Ciro Xavier Maretto
 * Copyright (C) 2015 Henrique N�spoli Castro, Vin�cius Soares Fonseca
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/lgpl.html>.
 */
package org.somespc.model.definicao_operacional_de_medida;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * Uma vez em cada projeto; Uma vez em cada ocorr�ncia da atividade;
 */
@Entity
@Views({
	@View(members = "nome; descricao"),
	@View(name = "Simple", members = "nome"),
})
@Tabs({
	@Tab(properties = "nome", defaultOrder = "${nome} asc")
})
public class Periodicidade
{

    @Id
    @TableGenerator(name="TABLE_GENERATOR", table="ID_TABLE", pkColumnName="ID_TABLE_NAME", pkColumnValue="PERIODICIDADE_ID", valueColumnName="ID_TABLE_VALUE")
    @GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GENERATOR")
     @Hidden
    private Integer id;

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    @Column(length = 255, unique = true)
    @Required
    private String nome;

    @Stereotype("TEXT_AREA")
    @Column(columnDefinition = "TEXT")
    private String descricao;

    public String getNome()
    {
	return nome;
    }

    public void setNome(String nome)
    {
	this.nome = nome;
    }

    public String getDescricao()
    {
	return descricao;
    }

    public void setDescricao(String descricao)
    {
	this.descricao = descricao;
    }

    @OneToMany(mappedBy = "periodicidadeDeMedicao")
    private Collection<DefinicaoOperacionalDeMedida> periodicidadeDeMedicao;

    @OneToMany(mappedBy = "periodicidadeDeAnaliseDeMedicao")
    private Collection<DefinicaoOperacionalDeMedida> periodicidadeDeAnaliseDeMedicao;

    public Collection<DefinicaoOperacionalDeMedida> getPeriodicidadeDeMedicao()
    {
	return periodicidadeDeMedicao;
    }

    public void setPeriodicidadeDeMedicao(
	    Collection<DefinicaoOperacionalDeMedida> periodicidadeDeMedicao)
    {
	this.periodicidadeDeMedicao = periodicidadeDeMedicao;
    }

    public Collection<DefinicaoOperacionalDeMedida> getPeriodicidadeDeAnaliseDeMedicao()
    {
	return periodicidadeDeAnaliseDeMedicao;
    }

    public void setPeriodicidadeDeAnaliseDemedicao(
	    Collection<DefinicaoOperacionalDeMedida> periodicidadeDeAnaliseDeMedicao)
    {
	this.periodicidadeDeAnaliseDeMedicao = periodicidadeDeAnaliseDeMedicao;
    }

}
