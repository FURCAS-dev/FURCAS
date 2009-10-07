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
 * Created on 03.02.2006
 */
package org.eclipse.emf.query2.internal.moinql.ast;

import org.eclipse.emf.query2.report.ProcessReport;

/**
 * The InternalQuery is the basic representation of internally processed
 * queries. It is the result of the preprocessor and is transformed by the
 * scheduler to be interpreted by the MQL interpreter.
 */
public abstract class InternalQuery extends FromEntry implements PreparedQuery {

	private ProcessReport report = null;

	public ProcessReport getPreparationReport() {

		return this.report;
	}

	public void setReport(ProcessReport _report) {

		this.report = _report;
	}

	abstract public String toString(int indent, StringBuilder accumSb);

	@Override
	public String toString() {

		return toString(0, new StringBuilder());
	}
}
