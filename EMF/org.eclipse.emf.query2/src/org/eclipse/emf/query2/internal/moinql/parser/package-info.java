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
/**
 * This package contains base functionality for all parsers used in MOIN. This
 * includes an abstract CstNode from which all generated nodes derive frome. All
 * general LPG messages are internationalized here. Moreover, two main LPG
 * templates which are shared among all parsers are kept here. Finally, the
 * AbstractAstBuilder is the base class for all visitors, which contains common
 * functionality with regard to error reporting as well as down and up maps.
 */
package org.eclipse.emf.query2.internal.moinql.parser;