/**
 * <copyright>
 *
 * Copyright (c) 2005, 2008 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *   E.D.Willink - refactored to separate from OCLAnalyzer and OCLParser
 *
 * </copyright>
 *
 * $Id: OCLAnalyzer.java,v 1.6 2008/05/04 01:17:02 cdamus Exp $
 */

package org.eclipse.ocl.parser;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.InitOrDerValueCS;
import org.eclipse.ocl.cst.InvCS;
import org.eclipse.ocl.cst.InvOrDefCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.PackageDeclarationCS;
import org.eclipse.ocl.cst.PrePostOrBodyDeclCS;
import org.eclipse.ocl.cst.PrePostOrBodyEnum;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.TypedElement;

/**
 * The <code>OCLAnalyzer</code> performs semantic analysis on a CST produced by
 * an <code>OCLParser</code> to create the OCL AST. It is necessary that syntactic
 * parsing and semantic analysis are performed in two steps
 * because LPG is a bottom up parser and cannot provide enough contextual
 * information to create the AST on the first pass.
 */
public class OCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		extends AbstractOCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {
	
    private OCLFactoryWithHistory history;
    
	/**
	 * Construct an OCL semantic analyzer that will use a given parser to perform syntactic
	 * and lexical analysis.
	 * 
	 * @param parser the syntactic (and lexical) parser
	 */
	public OCLAnalyzer(OCLParser parser) {
		super(parser);
	}
	
	/**
	 * Construct an OCL semantic analyzer with default syntactic and lexical parsers all
	 * operating within a given environment.
	 * 
	 * @param environment the symbolic and problem handling environment
	 */
	public OCLAnalyzer(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> environment) {
		this(new OCLParser(new OCLLexer(environment)));
	}

	/**
	 * Construct an OCL semantic analyzer with default syntactic and lexical parsers all
	 * operating within a given environment. Then prime the analyzer by performing keyword
	 * and lexical parsing of the given source text.
	 * 
	 * @param environment the symbolic and problem handling environment
	 * @param text the source text for analysis
	 */
	public OCLAnalyzer(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> environment, String text) {
		this(new OCLParser(new OCLLexer(environment, text.toCharArray())));
		getLexer().lexToTokens(getParser());
	}
    
	@Override
	public OCLParser getParser() {
		return (OCLParser) super.getParser();
	}
	
	@Override
	protected OCLFactory createOCLFactory(
	        Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
	    
	    history = new OCLFactoryWithHistory(super.createOCLFactory(env));
	    return history;
	}
	
	private <T> T sanitize(T parseResult) {
	    history.clear();
	    return parseResult;
	}
	
	/**
	 * Performs a concrete-syntax parser and throws <code>ParserException</code>
	 * if any parse errors are encountered.
	 * 
	 * @return the parsed CST, or <code>null</code> if it could not be parsed
	 */
	public CSTNode parseConcreteSyntax() {
		return getParser().parseTokensToCST();
	}
    
    /**
     * Parses the specified concrete syntax model to an abstract syntax model.
     * The result is contained by an <tt>Constraint</tt>, so care must be taken
     * when the result is no longer needed to dispose of the entire tree rooted
     * in the <tt>Constraint</tt>.
     * 
     * @param cst the OCL concrete syntax model
     * @param constraintType the kind of constraint to parse
     * 
     * @return the OCL expression, if it successfully parsed
     */
	public OCLExpression<C> parseAST(OCLExpressionCS cst, ConstraintKind constraintType) {
        OCLParser parser = getParser();   
        OCLExpression<C> result = null;
        switch (constraintType) {
        case PRECONDITION:
            PrePostOrBodyDeclCS pre = parser.createPrePostOrBodyDeclCS(
                PrePostOrBodyEnum.PRE_LITERAL, null, cst);
            result = uml.getSpecification(prePostOrBodyDeclCS(
                getOCLEnvironment(), pre)).getBodyExpression();
            break;
        case BODYCONDITION:
            PrePostOrBodyDeclCS body = parser.createPrePostOrBodyDeclCS(
                PrePostOrBodyEnum.BODY_LITERAL, null, cst);
            result = uml.getSpecification(prePostOrBodyDeclCS(
            	getOCLEnvironment(), body)).getBodyExpression();
            break;
        case POSTCONDITION:
            PrePostOrBodyDeclCS post = parser.createPrePostOrBodyDeclCS(
                PrePostOrBodyEnum.POST_LITERAL, null, cst);
            result = uml.getSpecification(prePostOrBodyDeclCS(
            	getOCLEnvironment(), post)).getBodyExpression();
            break;
        default:
            InvCS inv = parser.createInvCS(null, null, cst);
            result = uml.getSpecification(invCS(inv, getOCLEnvironment())).getBodyExpression();
            break;
        }
        
        return sanitize(result);
    }

	/**
	 * Parses the input as a PackageDeclarationCS.
	 * 
	 * @param constraints 
	 * @return the parsed constraints (as many as could be parsed)
	 */
	public List<CT> parsePackageDeclarationCS(List<CT> constraints) {
		CSTNode cstNode = parseConcreteSyntax();
		
		if ((cstNode != null) && !(cstNode instanceof PackageDeclarationCS)) {
			ERROR(cstNode, "parsePackageDeclarationCS",//$NON-NLS-1$
					OCLMessages.bind(OCLMessages.ParseCSTNodeType_ERROR_,
							"PackageDeclarationCS",//$NON-NLS-1$
							cstNode.eClass().getName()));
			return sanitize(constraints);
		}
		
		List<PackageDeclarationCS> packageDecls =
		    new BasicEList.FastCompare<PackageDeclarationCS>(4);
		
		// reverse the chain of package declarations to process them in the
		// forward order
		PackageDeclarationCS pkgdecl = (PackageDeclarationCS) cstNode;
		while (pkgdecl != null) {
		    packageDecls.add(0, pkgdecl);
			pkgdecl = pkgdecl.getPackageDeclarationCS();
		}
		
		for (PackageDeclarationCS packageDeclCS : packageDecls) {
		    packageDeclarationCS(packageDeclCS, constraints);
		}
		
		return sanitize(constraints);
	}

	/**
	 * Parses the input as an InvOrDefCS.
	 * 
	 * @return the parsed OCL constraint, or <code>null</code> if it
	 *    could not be parsed
	 */
	public CT parseInvOrDefCS() {
		
		CSTNode cstNode = parseConcreteSyntax();
		if (cstNode != null) {
			if (cstNode instanceof InvOrDefCS) {
				return sanitize(invOrDefCS((InvOrDefCS)cstNode, getOCLEnvironment()));
			}

			ERROR(cstNode, "parseInvOrDefCS",//$NON-NLS-1$
					OCLMessages.bind(OCLMessages.ParseCSTNodeType_ERROR_,
							"InvOrDefCS",//$NON-NLS-1$
							cstNode.eClass().getName()));
		}
		
		return sanitize(null);
	}

	/**
	 * Parses the input as a PrePostOrBodyDeclCS.
	 * 
	 * @return the parsed OCL constraint, or <code>null</code> if it
	 *    could not be parsed
	 */
	public CT parsePrePostOrBodyDeclCS() {
		
		CSTNode cstNode = parseConcreteSyntax();
		if (cstNode != null) {
			if (cstNode instanceof PrePostOrBodyDeclCS) {
				return sanitize(prePostOrBodyDeclCS(
						getOCLEnvironment(),
						(PrePostOrBodyDeclCS)cstNode));
			}
		}

		ERROR(cstNode, "parsePrePostOrBodyDeclCS",//$NON-NLS-1$
				OCLMessages.bind(OCLMessages.ParseCSTNodeType_ERROR_,
						"PrePostOrBodyDeclCS",//$NON-NLS-1$
						formatEClassName(cstNode)));
		return sanitize(null);
	}

	/**
	 * Parses the input as an InitOrDerValueCS.
	 * 
	 * @return the parsed OCL constraint, or <code>null</code> if it
	 *    could not be parsed
	 */
	public CT parseInitOrDerValueCS() {
		
		CSTNode cstNode = parseConcreteSyntax();
		if (cstNode != null) {
			if (cstNode instanceof InitOrDerValueCS) {
				return sanitize(initOrDerValueCS(
						getOCLEnvironment(),
						(InitOrDerValueCS)cstNode));
			}
		}

		ERROR(cstNode, "parseInitOrDerValueCS",//$NON-NLS-1$
				OCLMessages.bind(OCLMessages.ParseCSTNodeType_ERROR_,
						"InitOrDerValueCS",//$NON-NLS-1$
						formatEClassName(cstNode)));
		return sanitize(null);
	}

	/**
	 * Parses the input as a VariableDeclarationCS.
	 * 
	 * @param addToEnvironment boolean whether or not to add the
	 *                         the parsed variable to the environment
	 * @return the parsed variable declaration, or <code>null</code> if it
	 *    could not be parsed
	 */
	public Variable<C, PM>
	parseVariableDeclarationCS(boolean addToEnvironment) {
		
		CSTNode cstNode = parseConcreteSyntax();
		if (cstNode != null) {
			if (cstNode instanceof VariableCS) {
				return sanitize(variableDeclarationCS(
				        (VariableCS)cstNode, getOCLEnvironment(), true));
			}

			ERROR(cstNode, "parseVariableDeclarationCS",//$NON-NLS-1$
					OCLMessages.bind(OCLMessages.ParseCSTNodeType_ERROR_,
							"VariableDeclarationCS",//$NON-NLS-1$
							cstNode.eClass().getName()));
		}
		return sanitize(null);
	}
	
	@Override
	public void ERROR(List<?> problemObjects, String rule, String problemMessage) {
	    history.setDisposable();
	    super.ERROR(problemObjects, rule, problemMessage);
	}
	
	@Override
	public void ERROR(Object problemObject, String rule, String problemMessage) {
	    history.setDisposable();
	    super.ERROR(problemObject, rule, problemMessage);
	}
	
	@Override
	public void ERROR(String problemMessage) {
	    history.setDisposable();
	    super.ERROR(problemMessage);
	}
	
	@Override
	protected CT createConstraint() {
	    return history.record(super.createConstraint());
	}
	
	@Override
	protected ExpressionInOCL<C, PM> createExpressionInOCL() {
	    return history.record(super.createExpressionInOCL());
	}
	
	@Override
	protected boolean isErrorNode(TypedElement<C> expr) {
		return history.isErrorNode(expr);
	}
	
	@Override
	protected void markAsErrorNode(TypedElement<C> expr) {
		history.markAsErrorNode(expr);
	}
}
