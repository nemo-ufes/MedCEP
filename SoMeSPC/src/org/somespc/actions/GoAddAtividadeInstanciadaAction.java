/*
    SoMeSPC - powerful tool for measurement
    
    Copyright (C) 2013 Ciro Xavier Maretto
    Copyright (C) 2015 Henrique N�spoli Castro, Vin�cius Soares Fonseca                          

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/lgpl.html>.    
 */
package org.somespc.actions;

import org.openxava.actions.*;

public class GoAddAtividadeInstanciadaAction extends GoAddElementsToCollectionAction { 
	
	// adding collection elements list
	public void execute() throws Exception {
		super.execute(); 
		
		Integer id = getPreviousView().getValueInt("id");
		Integer idProcessoPadrao = getPreviousView().getValueInt("baseadoEm.id");

		getTab().setBaseCondition(idProcessoPadrao 
			+ " IN (SELECT p.id from ProcessoPadrao p JOIN p.atividadePadrao a WHERE a.id = ${baseadoEm.id}) AND ${id} NOT IN (SELECT aa.id from OcorrenciaProcesso pp JOIN pp.ocorrenciaAtividade aa WHERE pp.id = "+ id +")"
		);
	}
	
}