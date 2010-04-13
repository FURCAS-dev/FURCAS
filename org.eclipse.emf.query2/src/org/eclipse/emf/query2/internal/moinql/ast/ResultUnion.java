/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
/*
 * Created on 20.02.2006
 */
package org.eclipse.emf.query2.internal.moinql.ast;

import java.util.List;

import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.shared.AuxServices;
import org.eclipse.emf.query2.internal.shared.BugException;


/**
 * A ResultUnion is simply the union over the result sets of its operands. It is
 * required that the operands have type-compatible select entries.
 */
final public class ResultUnion extends InternalQuery {

	private List<InternalQuery> operands;

	public ResultUnion(AliasName _aliasName, List<InternalQuery> _operands) {

		this.aliasName = _aliasName;
		if (_operands == null || _operands.size() < 2) {
			throw new BugException(BugMessages.RESULT_UNION_EXPECTS_AT_LEAST_TWO_OPERANDS);
		}
		this.operands = _operands;
	}

	public boolean isEmpty() {

		return false;
	}

	public List<InternalQuery> getOperands() {

		return this.operands;
	}

	public void setOperands(List<InternalQuery> operands) {

		if (operands == null || operands.size() < 2) {
			throw new BugException(BugMessages.RESULT_UNION_EXPECTS_AT_LEAST_TWO_OPERANDS);
		}
		this.operands = operands;
	}

	/*
	 * Pretty-printing
	 */
	@Override
	public String toString(int indent, StringBuilder accumSb) {

		StringBuilder sb = new StringBuilder();

		sb.append(AuxServices.OPENPAREN_T);

		this.operands.get(0).toString(indent + 1, sb);
		for (int i = 1; i < this.operands.size(); i++) {
			sb.append(AuxServices.newLine(indent + 1) + AuxServices.UNION_T + AuxServices.newLine(indent + 1));
			this.operands.get(i).toString(indent + 1, sb);
		}

		sb.append(AuxServices.CLOSEPAREN_T + AuxServices.SPACE_T + AuxServices.AS_T + AuxServices.SPACE_T);
		sb.append(getAliasName().toString());

		accumSb.append(sb);

		return sb.toString();
	}

}
