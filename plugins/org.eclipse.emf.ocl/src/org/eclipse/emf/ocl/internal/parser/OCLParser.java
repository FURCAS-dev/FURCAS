/**
 * <copyright>
 *
 * Copyright (c) 2005-2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLParser.java,v 1.3 2006/03/03 15:32:37 cdamus Exp $
 */

package org.eclipse.emf.ocl.internal.parser;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ocl.expressions.AssociationClassCallExp;
import org.eclipse.emf.ocl.expressions.AssociationEndCallExp;
import org.eclipse.emf.ocl.expressions.AttributeCallExp;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionItem;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.CollectionLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionLiteralPart;
import org.eclipse.emf.ocl.expressions.CollectionRange;
import org.eclipse.emf.ocl.expressions.EnumLiteralExp;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.IfExp;
import org.eclipse.emf.ocl.expressions.IntegerLiteralExp;
import org.eclipse.emf.ocl.expressions.IterateExp;
import org.eclipse.emf.ocl.expressions.IteratorExp;
import org.eclipse.emf.ocl.expressions.LetExp;
import org.eclipse.emf.ocl.expressions.LiteralExp;
import org.eclipse.emf.ocl.expressions.LoopExp;
import org.eclipse.emf.ocl.expressions.ModelPropertyCallExp;
import org.eclipse.emf.ocl.expressions.NavigationCallExp;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.RealLiteralExp;
import org.eclipse.emf.ocl.expressions.StringLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralExp;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.expressions.VariableExp;
import org.eclipse.emf.ocl.internal.OCLPlugin;
import org.eclipse.emf.ocl.internal.l10n.OCLMessages;
import org.eclipse.emf.ocl.parser.EcoreEnvironment;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.types.BagType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.OrderedSetType;
import org.eclipse.emf.ocl.types.PrimitiveType;
import org.eclipse.emf.ocl.types.SequenceType;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.TupleType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.internal.impl.AnyTypeImpl;
import org.eclipse.emf.ocl.types.internal.impl.CollectionTypeImpl;
import org.eclipse.emf.ocl.types.internal.impl.PrimitiveTypeImpl;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.uml.AssociationClass;
import org.eclipse.emf.ocl.uml.AssociationClassEnd;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.emf.ocl.uml.UMLFactory;
import org.eclipse.emf.ocl.uml.UMLPackage;
import org.eclipse.osgi.util.NLS;

import antlr.MismatchedTokenException;
import antlr.NoViableAltException;
import antlr.ParserSharedInputState;
import antlr.RecognitionException;
import antlr.SemanticException;
import antlr.Token;
import antlr.TokenBuffer;
import antlr.TokenStream;
import antlr.TokenStreamException;
import antlr.collections.impl.BitSet;

import com.ibm.icu.util.StringTokenizer;

public class OCLParser extends antlr.LLkParser       implements OCLParserTokenTypes
 {


	private static final String StringParse_ERROR_ =
	        OCLMessages.StringParse_ERROR_;

	private static final String ErrorMessage_ERROR_ =
	        OCLMessages.ErrorMessage_ERROR_;

	private static final String VariableUsed_ERROR_ =
	        OCLMessages.VariableUsed_ERROR_;

	private static final String VariableDeclaration_ERROR_ =
	        OCLMessages.VariableDeclaration_ERROR_;

	private static final String PackageNotFound_ERROR_ =
	        OCLMessages.PackageNotFound_ERROR_;

	private static final String UnrecognizedContext_ERROR_ =
	        OCLMessages.UnrecognizedContext_ERROR_;

	private static final String BooleanForIf_ERROR_ =
	        OCLMessages.BooleanForIf_ERROR_;

	private static final String MissingTypeForVar_ERROR_ =
	        OCLMessages.MissingTypeForVar_ERROR_;

	private static final String MissingInitForVar_ERROR_ =
	        OCLMessages.MissingInitForVar_ERROR_;

	private static final String VarInNavExp_ERROR_ =
	        OCLMessages.VarInNavExp_ERROR_;

	private static final String UnrecognizedVar_ERROR_ =
	        OCLMessages.UnrecognizedVar_ERROR_;

	private static final String DeclarationType_ERROR_ =
	        OCLMessages.DeclarationType_ERROR_;

	private static final String DeclarationNoInitExp_ERROR_ =
	        OCLMessages.DeclarationNoInitExp_ERROR_;

	private static final String DeclarationInitExp_ERROR_ =
	        OCLMessages.DeclarationInitExp_ERROR_;

	private static final String UnrecognizedVarType_ERROR_ =
	        OCLMessages.UnrecognizedVarType_ERROR_;

	private static final String NoType_ERROR_ =
	        OCLMessages.NoType_ERROR_;

	private static final String NoInitExp_ERROR_ =
	        OCLMessages.NoInitExp_ERROR_;

	private static final String InitExpNotAllowed_ERROR_ =
	        OCLMessages.InitExpNotAllowed_ERROR_;

	private static final String MissingTypeDecl_ERROR_ =
	        OCLMessages.MissingTypeDecl_ERROR_;

	private static final String DuplicateNameInTuple_ERROR_ =
	        OCLMessages.DuplicateNameInTuple_ERROR_;

	private static final String MissingInit_ERROR_ =
	        OCLMessages.MissingInit_ERROR_;

	private static final String UnrecognizedEnum_ERROR_ =
	        OCLMessages.UnrecognizedEnum_ERROR_;

	private static final String FirstLastTypeMismatch_ERROR_ =
	        OCLMessages.FirstLastTypeMismatch_ERROR_;

	private static final String UnrecognizedType_ERROR_ =
	        OCLMessages.UnrecognizedType_ERROR_;

	private static final String ILLEGAL_AT_PRE_ERROR_ =
	        OCLMessages.IllegalAtPre_ERROR_;

	private static final String ILLEGAL_QUALIFIERS_ERROR_ =
	        OCLMessages.IllegalQualifiers_ERROR_;

	private static final String MISMATCHED_QUALIFIERS_ERROR_ =
	        OCLMessages.MismatchedQualifiers_ERROR_;

	private static final String ASSOCIATION_CLASS_QUALIFIER_COUNT_ERROR_ =
	        OCLMessages.AssociationClassQualifierCount_ERROR_;

	private static final String ASSOCIATION_CLASS_QUALIFIER_TYPE_ERROR_ =
	        OCLMessages.AssociationClassQualifierType_ERROR_;

	private static final String ASSOCIATION_CLASS_AMBIGUOUS_ERROR_ =
	        OCLMessages.AssociationClassAmbiguous_ERROR_;

	/*
	 * Factories for creating OCL AST nodes
	 */	 	
	TypesPackage typesPackage = TypesPackage.eINSTANCE;
    TypesFactory typesFactory = typesPackage.getTypesFactory();
    	
    ExpressionsPackage expressionsPackage = ExpressionsPackage.eINSTANCE;
    ExpressionsFactory expressionsFactory = expressionsPackage.getExpressionsFactory();
    	   		 
    UMLPackage umlPackage = UMLPackage.eINSTANCE;
    UMLFactory umlFactory = umlPackage.getUMLFactory();
    
    private OCLToken lastOCLToken = null;
    private List tokenStack = new java.util.ArrayList();
    private int tokenStackPointer = -1;
 
    private boolean traceflag = true;	
    	
    private String errorString = "";		//$NON-NLS-1$

    public void setTraceFlag(boolean flag) {
    	traceflag = flag;
    }
    
    public boolean getTraceFlag() {
    	return traceflag;
    }
    
    private void TRACE( String rule, String message) {
	    if (traceflag) {
	    	System.out.println(rule + ": " + message);//$NON-NLS-1$
	    }
	}
		    
	private void TRACE(String rule, String message, Vector namelist) {		  			
		TRACE(rule, message + makeString(namelist)); 
	}
	
	/** Pushes the next token onto the token stack. */
	private OCLToken push() throws TokenStreamException {
		OCLToken result = null;
		
		if (inputState.guessing == 0) {
			result = (OCLToken) LT(1);
			
			push(result);
		}
		
		return result;
	}
	
	/** Pushes a specified token onto the token stack. */
	private void push(OCLToken token) {
		tokenStack.add(token);
		tokenStackPointer++;
	}
	
	/**
	 * Pops the top token off of the stack.  This is the first token in the
	 * expression that we have just matched.
	 */
	private OCLToken pop() {
		OCLToken result = (OCLToken) tokenStack.get(tokenStackPointer);
		tokenStack.remove(tokenStackPointer);
		tokenStackPointer--;
		return result;
	}
	
	/**
	 * Initializes the start and end positions of the specified OCL expression.
	 * This has the side-effect of popping the token stack.
	 *
	 * @param expr an OCL expression
	 */
	private void initStartEndPositions(OCLExpression expr) {
		OCLToken last = lastOCLToken;
		OCLToken first = pop();
		
		expr.setStartPosition(first.getStartPosition());
		expr.setEndPosition(last.getEndPosition());
	}
	
	/**
	 * Initializes the start and end positions of the specified variable
	 * declaration.
	 * This has the side-effect of popping the token stack.
	 *
	 * @param vdecl a variable declaration
	 */
	private void initStartEndPositions(VariableDeclaration vdecl) {
		OCLToken last = lastOCLToken;
		OCLToken first = pop();
		
		vdecl.setStartPosition(first.getStartPosition());
		vdecl.setEndPosition(last.getEndPosition());
	}

	/**
	 * Initializes the start and end positions of the property name in the
	 * specified model property call expression.
	 * This has no side-effects.
	 *
	 * @param expr a model property call expression
	 */
	private void initPropertyPositions(ModelPropertyCallExp expr, OCLToken token) {
		expr.setPropertyStartPosition(token.getStartPosition());
		expr.setPropertyEndPosition(token.getEndPosition());
	}
	
	/**
	 * Creates a fake OCL token starting at the specified location and having
	 * the specified length.
	 */
	private OCLToken createFakeToken(int start, int length) {
		StringBuffer buf = new StringBuffer(length);
		buf.setLength(length);  // fill with null characters
		
		OCLToken result = new OCLToken(0, buf.toString()); // invalid token type
		result.setStartPosition(start);
		return result;
	}
	
	/**
	 * Sets the last token recognized in the (sub)expression currently being
	 * parsed.  If it is the first token, also, then that is recorded.
	 */
	public void match(int t) throws MismatchedTokenException, TokenStreamException {
		lastOCLToken = (OCLToken) LT(1);
		
		super.match(t);
	}
	
	/**
	 * Sets the last token recognized in the (sub)expression currently being
	 * parsed.  If it is the first token, also, then that is recorded.
	 */
	public void match(BitSet b) throws MismatchedTokenException, TokenStreamException {
		lastOCLToken = (OCLToken) LT(1);
		
		super.match(b);
	}
	
	private String makeString(Vector namelist) {
		String msg = "";//$NON-NLS-1$
		for (int i = 0; i < namelist.size(); i++) {
			msg += " " + (String) namelist.elementAt(i);//$NON-NLS-1$
		}
		return msg;
	}
	
	/**
	 * Removes the "s surrounding a quoted string, if any.
	 * 
	 * @param quoted a possibly quoted string
	 * @return <code>quoted</code> without the surrounding quotes, or just
	 *     <code>quoted</code> verbatim if there were none
	 */
	private String unquote(String quoted) {
	    String result = quoted;
	
    	if ((result != null) && (result.length() > 1)) {
    		int max = result.length() - 1; // known BMP code point
	
    		if ((result.charAt(0) == '"') && (quoted.charAt(max) == '"')) { // known BMP code point
    			result = result.substring(1, max);
    			}
    			// this is a regexp, so the backslash needs to be
    			//   re-escaped, thus "\\" is rendered in a Java
    			//   string literal as "\\\\"
    			result = result.replaceAll("\\\\\"", "\"");  //$NON-NLS-2$//$NON-NLS-1$
    	}
    
		return result;
	}
	
	/**
	 * Sets the specified navigation call's qualifiers, if they are compatible
	 * with the navigated association end or association class.
	 * 
	 * @param env the OCL environment
	 * @param rule the rule name that parsed the qualifiers
	 * @param nc the navigation call expression
	 * @param qualifiers the qualifiers to set
	 * 
	 * @throws SemanticException if the qualifiers do not conform
	 */
	private void setQualifiers(Environment env, String rule,
			NavigationCallExp nc, EList qualifiers) throws SemanticException {
		
		if (nc instanceof AssociationEndCallExp) {
			EReference source = ((AssociationEndCallExp) nc).getReferredAssociationEnd();
			
			List expectedTypes = EcoreEnvironment.getQualifierTypes(source);
			
			if (expectedTypes.size()!= qualifiers.size()) {
				ERROR(rule, MISMATCHED_QUALIFIERS_ERROR_);
			} else {
				Iterator eiter = expectedTypes.iterator();
				Iterator qiter = qualifiers.iterator();
				
				while (eiter.hasNext()) {
					EClassifier expectedType = (EClassifier) eiter.next();
					OCLExpression qualifier = (OCLExpression) qiter.next();
					
					EClassifier qualifierType = qualifier.getType();
					if (AnyTypeImpl.typeCompare(expectedType, qualifierType) < 0) {
						ERROR(rule, MISMATCHED_QUALIFIERS_ERROR_);
					}
				}
			}
		} else if (nc instanceof AssociationClassCallExp) {
			if (qualifiers.size() != 1) {
				ERROR(rule, ASSOCIATION_CLASS_QUALIFIER_COUNT_ERROR_);
			}
			
			Object qualifier = qualifiers.get(0);
			if (!(qualifier instanceof AssociationEndCallExp)) {
				ERROR(rule, ASSOCIATION_CLASS_QUALIFIER_TYPE_ERROR_);
			}
			
			AssociationClassCallExp acc = (AssociationClassCallExp) nc;
			EClass assocClass = acc.getReferredAssociationClass();
			
			// can assume an EClass, otherwise we wouldn't have found an
			//   association class call expression
			EClass sourceType = (EClass) nc.getSource().getType();
			EReference ref = ((AssociationEndCallExp) qualifier).getReferredAssociationEnd();
			if ((ref instanceof AssociationClassEnd)
					&& sourceType.getEAllReferences().contains(ref)
					&& (((AssociationClassEnd) ref).getAssociationClass() == assocClass)) {
				acc.setNavigationSource(ref);
			} else {
				ERROR(rule, ASSOCIATION_CLASS_QUALIFIER_TYPE_ERROR_);
			}
		}
			
		// all's well
		nc.getQualifiers().addAll(qualifiers);
	}
	
	/**
	 * Asserts that the specified association class is not a reflexive
	 * association.
	 * 
	 * @param env the current environment
	 * @param rule the rule that we are matching
	 * @param acc the association class call expression
	 * 
	 * @throws SemanticException if the association class is reflexive
	 */
	private void checkNotReflexive(Environment env, String rule,
			AssociationClassCallExp acc) throws SemanticException {
		
		EClass assocClass = acc.getReferredAssociationClass();
		
		List ends;
		if (assocClass instanceof AssociationClass) {
			ends = ((AssociationClass) assocClass).getMemberEnds();
		} else {
			ends = ECollections.EMPTY_ELIST;
		}
		
		if (ends.size() == 2) {
			EReference end1 = (EReference) ends.get(0);
			EReference end2 = (EReference) ends.get(1);
			
			if (end1.getEReferenceType() == end2.getEReferenceType()) {
				ERROR(rule, ASSOCIATION_CLASS_AMBIGUOUS_ERROR_);
			}
		}
	}
	
	/**
	 * Convenience method for parsing OCL expressions
	 * String to be parsed is the argument for OCLLexer.
	 * @return the parsed OCL expression
	 */
	public OCLExpression parse() {
		boolean traceFlagSave = getTraceFlag();
		setTraceFlag(false);
		EList constraints = new BasicEList();
		try {
			classifierContextDeclCS(null, constraints);
		}
		catch (Exception e) {
            String message = NLS.bind(StringParse_ERROR_,
                    new Object[] { e.getMessage() });
            IllegalArgumentException error = new IllegalArgumentException(
                    message);
            OCLPlugin.throwing(getClass(), "parse", error);//$NON-NLS-1$
            throw error;
		}
		Constraint constraint = (Constraint) constraints.get(0);	
		setTraceFlag(traceFlagSave);
		
		return constraint.getBody();	
	}
	
	/**
	 * Hub for all semantic parsing messages -- 
	 * Should be changed if want to continue parsing, and not terminate
	 * on first exception.
	 */
	public static void ERR(String message) throws SemanticException {
		throw new SemanticException(message);
	}
	    
	private void ERROR(String rule, String errorMessage) throws SemanticException {
        String error = NLS.bind(ErrorMessage_ERROR_, new Object[] {
                rule, errorMessage });
        errorString += error;
        ERR(error);
	    
	    /*if (traceflag) {
	    	System.out.println(error);
	    }*/
	    
	}
		
	private void ERROR(String rule, String errorMessage, Vector namelist)
	throws SemanticException {		  	
		String msg = errorMessage;
		for (int i = 0; i < namelist.size(); i++) {
			msg += " " + (String) namelist.elementAt(i);//$NON-NLS-1$
		}
		ERROR(rule, msg); 
	}
	
	
	/**
	 * Generate a VariableDeclaration AST node, and add it to the environment.
	 * Variable declarations are generated for "self", let expression variables, and
	 * iterator and iterate variables, both implicit and explicit.
	 * For implicit variables, the name is generated by the Environment.
	 */
	private VariableDeclaration genVariableDeclaration(String rule, Environment env, String name, 
				EClassifier type, OCLExpression initExp, boolean explicitFlag,
				boolean addToEnvironment, boolean isSelf) throws RecognitionException {
			
		VariableDeclaration vdcl = expressionsFactory.createVariableDeclaration();		
 		vdcl.setVarName(name);
 		vdcl.setType(type);
 		vdcl.setInitExpression(initExp);
 		
 		if (addToEnvironment) {
 			boolean result = env.addElement(name, vdcl, explicitFlag);
 			if (!result) {
                if (name != null) {
                    String message = NLS.bind(VariableUsed_ERROR_,
                            new Object[] { name });
                    ERROR(rule, message);
                } else {
                    ERROR(rule, VariableDeclaration_ERROR_);
                }
 			}
 			
 			if (isSelf) {
 				env.setSelfVariable(vdcl);
 			}
 		}
 		
 		if (addToEnvironment) {
 			TRACE(rule, "adding variable declaration for " + vdcl.getVarName());//$NON-NLS-1$
 		}	
 		return vdcl;
	}
    	    
	/**
	 * Generate an OperationCallExp node. 
	 * operName is the input name of the operation, which
	 * must be matched against the datatype of the operation source.
	 * 
	 * @param env the current environemtn
	 * @param rule the name of the concrete syntax rule that we are processing
	 * @param operName the operation name
	 * @param source the operation's source expression
	 * @param ownerType the type that defines the operation, in which we will
	 *     look it up.  This can differ from the type of the source expression
	 *     in the case of an implicit collect iterator
	 * @param args the operation arguments
	 */ 
	private OperationCallExp genOperationCallExp(
			Environment env,
			String rule,
			String operName,
			OCLExpression source,
			EClassifier ownerType,
			EList args)
		throws SemanticException {

		OperationCallExp result;
		
		result = expressionsFactory.createOperationCallExp();
		result.setSource(source);	   
		
		// Performs method signature checking		
		EOperation oper = EcoreEnvironment.lookupOperation(ownerType, operName, args);
		if (oper == null) { 
			String message = NLS.bind(OCLMessages.OperationNotFound_ERROR_,
					new Object[] { operName });
			ERROR(rule, message);
			result.setType(Types.OCL_VOID);
		} else {
		  	TRACE(rule, oper.getName());
			result.setReferredOperation(oper);
		}
							
		// Set up arguments
		EList callargs = result.getArguments();
		if (args != null) {
		   	for (int i = 0; i < args.size(); i++) {
		   		OCLExpression arg = (OCLExpression) args.get(i);
		   		if (arg == null) {
					ERROR(rule, OCLMessages.BadArg_ERROR_);
		   			continue;
		   		}
		   		
		   		callargs.add(args.get(i));
		   	}
		}
				
		// Compute the result type, and perform conformance checking.
		if (oper != null) {
			EClassifier resultType = null;
			
		   	if (ownerType instanceof CollectionType) { 
		   		CollectionTypeImpl ct = (CollectionTypeImpl) ownerType;
		   		int opcode = ct.getOperationCode(operName);
		   		result.setOperationCode(opcode);
				resultType = ct.getResultType(opcode, args);
		   	} else if (ownerType instanceof PrimitiveType) {
		   		PrimitiveTypeImpl pt = (PrimitiveTypeImpl) ownerType;
		   		int opcode = pt.getOperationCode(operName);
		   		result.setOperationCode(opcode);
		   		resultType = pt.getResultType(opcode, args);
		   	} else {
		   		// source is a tuple, an EClass, or an enumeration
		   		int opcode = AnyTypeImpl.OCL_ANY_TYPE.getOperationCode(operName);
		   		result.setOperationCode(opcode);
		   		resultType = AnyTypeImpl.getResultType(ownerType, opcode, args);
		   	}
		   	if (resultType == null)
		   		resultType = EcoreEnvironment.getOCLType(oper);	   		
		   	result.setType(resultType);
		}
			
		return result;
	}

protected OCLParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public OCLParser(TokenBuffer tokenBuf) {
  this(tokenBuf,2);
}

protected OCLParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public OCLParser(TokenStream lexer) {
  this(lexer,2);
}

public OCLParser(ParserSharedInputState state) {
  super(state,2);
  tokenNames = _tokenNames;
}

	public final void packageDeclarationCS(
		EList constraints
	) throws RecognitionException, TokenStreamException {
		
			Vector pathname = null; 
			EPackage defaultPackage = null;
		
		
		{
		{
		switch ( LA(1)) {
		case LITERAL_package:
		{
			match(LITERAL_package);
			pathname=pathNameCS();
			
						defaultPackage = EcoreEnvironment.findPackage(pathname); 
					  	if (defaultPackage == null) {
			ERROR("packageDeclarationCS", PackageNotFound_ERROR_,//$NON-NLS-1$
			pathname);
					 	 }
					  
					  	TRACE("packageDeclarationCS", "Package ", pathname);	  	//$NON-NLS-2$//$NON-NLS-1$
					
			{
			int _cnt3058=0;
			_loop3058:
			do {
				if ((LA(1)==LITERAL_context)) {
					contextDeclarationCS(defaultPackage, constraints);
				}
				else {
					if ( _cnt3058>=1 ) { break _loop3058; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt3058++;
			} while (true);
			}
			match(LITERAL_endpackage);
			break;
		}
		case LITERAL_context:
		{
			{
			int _cnt3060=0;
			_loop3060:
			do {
				if ((LA(1)==LITERAL_context)) {
					contextDeclarationCS(defaultPackage, constraints);
				}
				else {
					if ( _cnt3060>=1 ) { break _loop3060; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt3060++;
			} while (true);
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(Token.EOF_TYPE);
		}
	}
	
	public final Vector  pathNameCS() throws RecognitionException, TokenStreamException {
		Vector sequenceOfNames;
		
		Token  p = null;
		Token  t = null;
		Token  n = null;
		
			sequenceOfNames = null;
		
		
		{
		switch ( LA(1)) {
		case PATHNAME:
		{
			p = LT(1);
			match(PATHNAME);
			
					StringTokenizer tokenizer = new StringTokenizer(p.getText(), "::");//$NON-NLS-1$
					sequenceOfNames = new Vector();
					while (tokenizer.hasMoreTokens()) {
						sequenceOfNames.add(unquote(tokenizer.nextToken()));
					}
				
			break;
		}
		case NAME:
		{
			t = LT(1);
			match(NAME);
			
					sequenceOfNames = new Vector();
					sequenceOfNames.add(unquote(t.getText()));
				
			break;
		}
		case NUMERICPATHNAME:
		{
			n = LT(1);
			match(NUMERICPATHNAME);
			
					StringTokenizer tokenizer = new StringTokenizer(n.getText(), "::");//$NON-NLS-1$
					sequenceOfNames = new Vector();
					while (tokenizer.hasMoreTokens()) {
						sequenceOfNames.add(unquote(tokenizer.nextToken()));
					}
				
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return sequenceOfNames;
	}
	
	public final void contextDeclarationCS(
		EPackage defpack, EList constraints
	) throws RecognitionException, TokenStreamException {
		
		Token  c = null;
		
			String selfName = null;
			Vector pathName = null;
		
		
		{
		match(LITERAL_context);
		{
		if ((LA(1)==NAME) && (LA(2)==COLON)) {
			c = LT(1);
			match(NAME);
			match(COLON);
			selfName = unquote(c.getText());
		}
		else if (((LA(1) >= PATHNAME && LA(1) <= NUMERICPATHNAME)) && (LA(2)==LPAREN||LA(2)==LITERAL_inv)) {
			// empty block generated by ANTLR
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		pathName=pathNameCS();
		{
		switch ( LA(1)) {
		case LPAREN:
		{
			operationContextDeclCS0(defpack, selfName, pathName, constraints);
			break;
		}
		case LITERAL_inv:
		{
			classifierContextDeclCS0(defpack, selfName, pathName, constraints);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		}
	}
	
	protected final void operationContextDeclCS0(
		EPackage defpack, String selfName,
			Vector operationName, EList constraints
	) throws RecognitionException, TokenStreamException {
		
			EOperation operation = null;
			EClassifier classifier = null;
			EList parms = new BasicEList(); 
			EList results = new BasicEList(); 
			Constraint astNode = null;
			String instanceVarName = null;
			Environment env = new EcoreEnvironment(defpack);
			Environment operationEnv = new EcoreEnvironment(env);
		
		
		{
		operationSig(operationEnv, parms, results);
		
					if (operationName.size() > 1) {
						int lastName = operationName.size() - 1;
						Vector className = new Vector(
							operationName.subList(0, lastName));
						classifier = env.lookupPathName(className);
						
						if (classifier != null) {
							operation = EcoreEnvironment.lookupOperation(
								classifier, (String) operationName.get(lastName), parms);
						}
					}
					
					if (operation == null) {
		String message = NLS.bind(
		UnrecognizedContext_ERROR_,
		new Object[] { makeString(operationName) });
		ERROR("operationContextDeclCS", message);//$NON-NLS-1$
		}
		
					genVariableDeclaration("\noperationContextDeclCS", env,//$NON-NLS-1$
									"self", classifier, null, true, true, true);//$NON-NLS-1$
										
					TRACE("operationContextDeclCS", "context", operationName);//$NON-NLS-2$//$NON-NLS-1$
					
					  
				
		{
		int _cnt3079=0;
		_loop3079:
		do {
			if (((LA(1) >= LITERAL_pre && LA(1) <= LITERAL_body))) {
				astNode=prePostOrBodyDeclCS0(operationEnv, operation);
				astNode.setInstanceVarName(instanceVarName);
							  constraints.add(astNode);
			}
			else {
				if ( _cnt3079>=1 ) { break _loop3079; } else {throw new NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt3079++;
		} while (true);
		}
		}
	}
	
	protected final void classifierContextDeclCS0(
		EPackage defpack, String selfName, Vector pathName, EList constraints
	) throws RecognitionException, TokenStreamException {
		
			EClassifier type = null;
			Constraint astNode = null;
		
		
		{
		Environment env = new EcoreEnvironment(defpack);
					type = env.lookupPathName(pathName);
					if (type == null) {
		String message = NLS.bind(
		UnrecognizedContext_ERROR_,
		new Object[] { makeString(pathName) });
		ERROR("classifierContextDeclCS", message);//$NON-NLS-1$
		}
		type = EcoreEnvironment.getOCLType(type);
					if (selfName == null || selfName.length() == 0) {
						selfName = "self";//$NON-NLS-1$
					}
					genVariableDeclaration("\nclassifierContextDeclCS", env,//$NON-NLS-1$
									selfName, type, null, true, true, true);
										
					TRACE("classifierContextDeclCS", "context", pathName);  //$NON-NLS-2$//$NON-NLS-1$
				
		{
		int _cnt3073=0;
		_loop3073:
		do {
			if ((LA(1)==LITERAL_inv)) {
				astNode=invOrDefCS0(env);
				astNode.setInstanceVarName(selfName);
							  constraints.add(astNode);
			}
			else {
				if ( _cnt3073>=1 ) { break _loop3073; } else {throw new NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt3073++;
		} while (true);
		}
		}
	}
	
	public final void classifierContextDeclCS(
		EPackage defpack, EList constraints
	) throws RecognitionException, TokenStreamException {
		
		Token  c = null;
			String selfName = null;
			Vector pathName = null;
		
		
		{
		match(LITERAL_context);
		{
		if ((LA(1)==NAME) && (LA(2)==COLON)) {
			c = LT(1);
			match(NAME);
			match(COLON);
			selfName = unquote(c.getText());
		}
		else if (((LA(1) >= PATHNAME && LA(1) <= NUMERICPATHNAME)) && (LA(2)==LITERAL_inv)) {
			// empty block generated by ANTLR
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		pathName=pathNameCS();
		classifierContextDeclCS0(defpack, selfName, pathName, constraints);
		}
	}
	
	protected final Constraint  invOrDefCS0(
		Environment env
	) throws RecognitionException, TokenStreamException {
		Constraint astNode;
		
		Token  n = null;
			OCLExpression oclexpr = null;
			astNode = null;
		
		
		{
		match(LITERAL_inv);
		{
		switch ( LA(1)) {
		case NAME:
		{
			n = LT(1);
			match(NAME);
			break;
		}
		case COLON:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(COLON);
		oclexpr=oclExpressionCS(env);
		
					/* create a constraint astNode  -- must reference the type of self...
				       also, can have a name n.  type of constraint is inv...
				       constraints can be of different types ??  inv or pre/post?
				    */
					astNode = umlFactory.createConstraint();
		
					if (n != null) {
						astNode.setName(unquote(n.getText()));
					}
					
					EClassifier type = env.getSelfVariable().getType();
					EList constrainedElement = astNode.getConstrainedElement();
					constrainedElement.add(type);
					astNode.setBody(oclexpr);
					astNode.setStereotype(Constraint.INVARIANT);
				
		}
		return astNode;
	}
	
	public final void operationContextDeclCS(
		EPackage defpack, EList constraints
	) throws RecognitionException, TokenStreamException {
		
			Vector operationName = null;
		
		
		{
		match(LITERAL_context);
		operationName=pathNameCS();
		operationContextDeclCS0(defpack, null, operationName, constraints);
		}
	}
	
	protected final void operationSig(
		Environment env, EList parms, EList results
	) throws RecognitionException, TokenStreamException {
		
			EClassifier type = null;
		
		
		{
		match(LPAREN);
		{
		switch ( LA(1)) {
		case NAME:
		{
			parametersCS(env, parms);
			break;
		}
		case RPAREN:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(RPAREN);
		match(COLON);
		{
		switch ( LA(1)) {
		case PATHNAME:
		case NAME:
		case NUMERICPATHNAME:
		case LPAREN:
		case LITERAL_Integer:
		case LITERAL_String:
		case LITERAL_Real:
		case LITERAL_Boolean:
		case LITERAL_OclAny:
		case LITERAL_OclVoid:
		case LITERAL_Set:
		case LITERAL_Bag:
		case LITERAL_Sequence:
		case LITERAL_Collection:
		case LITERAL_OrderedSet:
		case LITERAL_Tuple:
		{
			type=typeCS(env);
			break;
		}
		case EOF:
		case LITERAL_pre:
		case LITERAL_post:
		case LITERAL_body:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		
					if (type != null) {
						results.add(type);
						OCLTokenAdapter.getToken(type); // discard adapter if any
					}
				
		}
	}
	
	protected final Constraint  prePostOrBodyDeclCS0(
		Environment env, EOperation operation
	) throws RecognitionException, TokenStreamException {
		Constraint astNode;
		
		Token  n = null;
			OCLExpression oclexpr = null;
			EClassifier operationType = EcoreEnvironment.getOCLType(operation);
			astNode = null;
			String stereotype = null;
		
		
		{
		{
		switch ( LA(1)) {
		case LITERAL_pre:
		{
			{
			match(LITERAL_pre);
			}
			stereotype = Constraint.PRECONDITION;
			break;
		}
		case LITERAL_post:
		{
			{
			match(LITERAL_post);
			}
			
							 stereotype = Constraint.POSTCONDITION;
							 
							 // postconditions have an implicit variable "result" of the
							 //    same type as the operation
							 if ((operationType != null) && (env.lookupLocal("result") == null)) {//$NON-NLS-1$
								genVariableDeclaration(
									"prePostOrBodyDeclCS0", env,//$NON-NLS-1$
									"result", operationType, null, true, true, false);//$NON-NLS-1$
							 }
						
			break;
		}
		case LITERAL_body:
		{
			{
			match(LITERAL_body);
			}
			stereotype = Constraint.BODY;
			
			 // likewise, body conditions have an implicit variable "result"
			 if ((operationType != null) && (env.lookupLocal("result") == null)) {//$NON-NLS-1$
				genVariableDeclaration(
					"prePostOrBodyDeclCS", env,//$NON-NLS-1$
					"result", operationType, null, true, true, false);//$NON-NLS-1$
			 }
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		switch ( LA(1)) {
		case NAME:
		{
			n = LT(1);
			match(NAME);
			break;
		}
		case COLON:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(COLON);
		oclexpr=oclExpressionCS(env);
		
					/* create a constraint astNode  -- must reference the type of self...
				       also, can have a name n.  type of constraint is pre/post/body...
				    */
					astNode = umlFactory.createConstraint();
		
					if (n != null) {
						astNode.setName(unquote(n.getText()));
					}
					
					EList constrainedElement = astNode.getConstrainedElement();
					constrainedElement.add(operation);
					astNode.setBody(oclexpr);
					astNode.setStereotype(stereotype);
				
		}
		return astNode;
	}
	
	public final Vector  operationCS(
		Environment env, EList parms, EList results
	) throws RecognitionException, TokenStreamException {
		Vector operationName;
		
			operationName = null;
		
		
		{
		{
		operationName=pathNameCS();
		}
		operationSig(env, parms, results);
		}
		return operationName;
	}
	
	public final void parametersCS(
		Environment env, EList parms
	) throws RecognitionException, TokenStreamException {
		
			VariableDeclaration decl = null;
		
		
		{
		{
		decl=variableDeclarationCS(env, true);
		}
		parms.add(decl);
		{
		_loop3091:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				decl=variableDeclarationCS(env, true);
				parms.add(decl);
			}
			else {
				break _loop3091;
			}
			
		} while (true);
		}
		}
	}
	
	public final EClassifier  typeCS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		EClassifier astNode;
		
		
		astNode = null;
			Vector pathName = null;
		
		
		{
		switch ( LA(1)) {
		case PATHNAME:
		case NAME:
		case NUMERICPATHNAME:
		case LITERAL_Integer:
		case LITERAL_String:
		case LITERAL_Real:
		case LITERAL_Boolean:
		case LITERAL_OclAny:
		case LITERAL_OclVoid:
		{
			{
			switch ( LA(1)) {
			case LITERAL_Integer:
			case LITERAL_String:
			case LITERAL_Real:
			case LITERAL_Boolean:
			case LITERAL_OclAny:
			case LITERAL_OclVoid:
			{
				astNode=primitiveTypeCS();
				break;
			}
			case PATHNAME:
			case NAME:
			case NUMERICPATHNAME:
			{
				pathName=pathNameCS();
				
								astNode = env.lookupPathName(pathName);
							
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			OCLTokenAdapter.attach(astNode, lastOCLToken);
			break;
		}
		case LITERAL_Set:
		case LITERAL_Bag:
		case LITERAL_Sequence:
		case LITERAL_Collection:
		case LITERAL_OrderedSet:
		case LITERAL_Tuple:
		{
			push();
			{
			switch ( LA(1)) {
			case LITERAL_Set:
			case LITERAL_Bag:
			case LITERAL_Sequence:
			case LITERAL_Collection:
			case LITERAL_OrderedSet:
			{
				astNode=collectionTypeCS(env);
				break;
			}
			case LITERAL_Tuple:
			{
				astNode=tupleTypeCS(env);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
						// create a fake token for the collection or tuple type
						int fakeTokenStart = pop().getStartPosition();
						int fakeTokenLength = lastOCLToken.getEndPosition() - fakeTokenStart;
						OCLToken fakeToken = createFakeToken(fakeTokenStart, fakeTokenLength);
						OCLTokenAdapter.attach(astNode, fakeToken);
					
			break;
		}
		case LPAREN:
		{
			match(LPAREN);
			astNode=typeCS(env);
			match(RPAREN);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return astNode;
	}
	
	public final VariableDeclaration  variableDeclarationCS(
		Environment env, boolean addToEnvironment
	) throws RecognitionException, TokenStreamException {
		VariableDeclaration astNode;
		
		Token  t = null;
		
			  	String varName;
			  	EClassifier type = null;
			  	OCLExpression expr = null;
			  	
			  	astNode = null;
			
		
		push();
		{
		t = LT(1);
		match(NAME);
		{
		switch ( LA(1)) {
		case COLON:
		{
			match(COLON);
			type=typeCS(env);
			if (type == null) {
			String message = NLS.bind(
			UnrecognizedVarType_ERROR_, new Object[] {
				unquote(t.getText()) });
			ERROR("variableDeclarationCS", message);//$NON-NLS-1$
			break;
						}
						
			break;
		}
		case RPAREN:
		case COMMA:
		case EQUALS:
		case LITERAL_in:
		case RBRACE:
		case BAR:
		case SEMICOLON:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		switch ( LA(1)) {
		case EQUALS:
		{
			match(EQUALS);
			expr=oclExpressionCS(env);
			break;
		}
		case RPAREN:
		case COMMA:
		case LITERAL_in:
		case RBRACE:
		case BAR:
		case SEMICOLON:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		}
		
				varName = unquote(t.getText());
				astNode = genVariableDeclaration("variableDeclarationCS", env, varName, type, expr, //$NON-NLS-1$
								true, addToEnvironment, false);
				
				initStartEndPositions(astNode);
				
				OCLToken typeToken = OCLTokenAdapter.getToken(type);
				astNode.setTypeStartPosition(typeToken.getStartPosition());
				astNode.setTypeEndPosition(typeToken.getEndPosition());
			
		return astNode;
	}
	
	public final Constraint  prePostOrBodyDeclCS(
		Environment env, EOperation operation
	) throws RecognitionException, TokenStreamException {
		Constraint astNode;
		
		
		{
		astNode=prePostOrBodyDeclCS0(env, operation);
		}
		match(Token.EOF_TYPE);
		return astNode;
	}
	
	public final OCLExpression  oclExpressionCS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
			
			OCLExpression expr = null;
			astNode = null;
			EList args = null;
			boolean matchedOne = false;
			OCLToken oclToken = null;
		
		
		{
		oclToken = push();
		astNode=oclExpr1CS(env);
		{
		_loop3110:
		do {
			if ((LA(1)==LITERAL_implies) && (_tokenSet_0.member(LA(2)))) {
				
						  		if (matchedOne) {
						  			// re-push the first token of the composed implies expression
						  			push(oclToken);
						  		}
						  	
				{
				match(LITERAL_implies);
				expr=oclExpr1CS(env);
				}
				
						 		args = new BasicEList();
						 		args.add(expr);
						 		astNode = genOperationCallExp(env, "oclExpressionCS", "implies", astNode, astNode.getType(), args);	      //$NON-NLS-2$//$NON-NLS-1$
						 		matchedOne = true;
						 		initStartEndPositions(astNode);
						 	
			}
			else {
				break _loop3110;
			}
			
		} while (true);
		}
		
					if (!matchedOne) {
						// pop the redunant token that we didn't need
				 		pop();
					}
				
		}
		return astNode;
	}
	
	public final Constraint  invOrDefCS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		Constraint astNode;
		
		
		{
		astNode=invOrDefCS0(env);
		}
		match(Token.EOF_TYPE);
		return astNode;
	}
	
	public final OCLExpression  oclExpr1CS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
		
			OCLExpression expr = null;
			astNode = null;
			EList args = null;
			String operName = null;
			boolean matchedOne = false;
			OCLToken oclToken = null;
		
		
		{
		oclToken = push();
		astNode=oclExpr2CS(env);
		{
		_loop3118:
		do {
			if (((LA(1) >= LITERAL_and && LA(1) <= LITERAL_xor)) && (_tokenSet_0.member(LA(2)))) {
				
						  		if (matchedOne) {
						  			// re-push the first token of the composed expression
						  			push(oclToken);
						  		}
						  	
				{
				switch ( LA(1)) {
				case LITERAL_and:
				{
					{
					match(LITERAL_and);
					}
					operName = "and";//$NON-NLS-1$
					break;
				}
				case LITERAL_or:
				{
					{
					match(LITERAL_or);
					}
					operName = "or";//$NON-NLS-1$
					break;
				}
				case LITERAL_xor:
				{
					{
					match(LITERAL_xor);
					}
					operName = "xor";//$NON-NLS-1$
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				expr=oclExpr2CS(env);
				
						   		args = new BasicEList();
						   		args.add(expr);
						       	astNode = genOperationCallExp(env, "oclExpr1CS", operName, astNode, astNode.getType(), args);//$NON-NLS-1$
						 		matchedOne = true;
						 		initStartEndPositions(astNode);
						   	
			}
			else {
				break _loop3118;
			}
			
		} while (true);
		}
		
					if (!matchedOne) {
						// pop the redunant token that we didn't need
				 		pop();
					}
				
		}
		return astNode;
	}
	
	public final OCLExpression  oclExpr2CS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
		
			OCLExpression expr = null;
			astNode = null;
			EList args = null;
			String operName = null; 							   	    
			boolean matchedOne = false;
			OCLToken oclToken = null;
		
		
		{
		oclToken = push();
		astNode=oclExpr3CS(env);
		{
		_loop3129:
		do {
			if (((LA(1) >= EQUALS && LA(1) <= LE)) && (_tokenSet_0.member(LA(2)))) {
				
						  		if (matchedOne) {
						  			// re-push the first token of the composed expression
						  			push(oclToken);
						  		}
						  	
				{
				switch ( LA(1)) {
				case EQUALS:
				{
					{
					match(EQUALS);
					}
					operName = "oclEquals";//$NON-NLS-1$
					break;
				}
				case NEQUALS:
				{
					{
					match(NEQUALS);
					}
					operName = "oclNotEquals";//$NON-NLS-1$
					break;
				}
				case GT:
				{
					{
					match(GT);
					}
					operName = "greaterThan";//$NON-NLS-1$
					break;
				}
				case GE:
				{
					{
					match(GE);
					}
					operName = "greaterThanEqual";//$NON-NLS-1$
					break;
				}
				case LT:
				{
					{
					match(LT);
					}
					operName = "lessThan";//$NON-NLS-1$
					break;
				}
				case LE:
				{
					{
					match(LE);
					}
					operName = "lessThanEqual";//$NON-NLS-1$
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				expr=oclExpr3CS(env);
				
								args = new BasicEList();
								args.add(expr);
								astNode = genOperationCallExp(env, "oclExpr2CS", operName, astNode, astNode.getType(), args);//$NON-NLS-1$
						 		matchedOne = true;
						 		initStartEndPositions(astNode);
							
			}
			else {
				break _loop3129;
			}
			
		} while (true);
		}
		
					if (!matchedOne) {
						// pop the redunant token that we didn't need
				 		pop();
					}
				
		}
		return astNode;
	}
	
	public final OCLExpression  oclExpr3CS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
			astNode = null;
		
		{
		switch ( LA(1)) {
		case LITERAL_if:
		{
			astNode=ifExpCS(env);
			break;
		}
		case PATHNAME:
		case NAME:
		case LPAREN:
		case MINUS:
		case LITERAL_not:
		case LITERAL_let:
		case LITERAL_Integer:
		case LITERAL_String:
		case LITERAL_Real:
		case LITERAL_Boolean:
		case LITERAL_OclAny:
		case LITERAL_OclVoid:
		case LITERAL_Set:
		case LITERAL_Bag:
		case LITERAL_Sequence:
		case LITERAL_Collection:
		case LITERAL_OrderedSet:
		case LITERAL_Tuple:
		case NUMBER_LITERAL:
		case REAL_LITERAL:
		case LITERAL_true:
		case LITERAL_false:
		case STRING_LITERAL:
		case LITERAL_oclAsType:
		case LITERAL_oclIsKindOf:
		case LITERAL_oclIsTypeOf:
		case LITERAL_closure:
		case LITERAL_closureAll:
		case OPERATION_EXPR:
		{
			astNode=oclExpr4CS(env);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return astNode;
	}
	
	public final OCLExpression  ifExpCS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
			astNode = null; 
			OCLExpression expr1 = null;
			OCLExpression expr2 = null;
			OCLExpression expr3 = null;
			IfExp ifNode = null;
		
		
		push();
		{
		match(LITERAL_if);
		expr1=oclExpressionCS(env);
		match(LITERAL_then);
		expr2=oclExpressionCS(env);
		match(LITERAL_else);
		expr3=oclExpressionCS(env);
		match(LITERAL_endif);
		}
		
				TRACE("ifExpCS", " "); //$NON-NLS-2$//$NON-NLS-1$
				
				if (expr1.getType() != PrimitiveTypeImpl.OCL_BOOLEAN && 
									expr1 != Types.OCL_VOID) {
		ERROR("ifExpCS", BooleanForIf_ERROR_);//$NON-NLS-1$
				}
			
				ifNode = expressionsFactory.createIfExp();
				ifNode.setCondition(expr1);
				ifNode.setThenExpression(expr2);
				ifNode.setElseExpression(expr3);
				ifNode.setType(AnyTypeImpl.commonSuperType(expr2.getType(), expr3.getType()));
				astNode = ifNode;
				
				initStartEndPositions(astNode);
			
		return astNode;
	}
	
	public final OCLExpression  oclExpr4CS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
		
			OCLExpression expr = null;
			astNode = null;
			String operName = null;
			EList args = null;
			boolean matchedOne = false;
			OCLToken oclToken = null;
		
		
		{
		oclToken = push();
		astNode=oclExpr5CS(env);
		{
		_loop3140:
		do {
			if ((LA(1)==PLUS||LA(1)==MINUS) && (_tokenSet_1.member(LA(2)))) {
				
						  		if (matchedOne) {
						  			// re-push the first token of the composed expression
						  			push(oclToken);
						  		}
						  	
				{
				switch ( LA(1)) {
				case PLUS:
				{
					{
					match(PLUS);
					}
					operName = "plus";//$NON-NLS-1$
					break;
				}
				case MINUS:
				{
					{
					match(MINUS);
					}
					
							   	  		if (astNode.getType() instanceof CollectionType) {
							   	  			operName = "symmetricDifference";//$NON-NLS-1$
							   	  		} else {
							   	  			operName = "minus";//$NON-NLS-1$
							   	  		} 
							   	  	
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				expr=oclExpr5CS(env);
				
						   		args = new BasicEList();
						   		args.add(expr);
						   		astNode = genOperationCallExp(env, "oclExpr4CS", operName, astNode, astNode.getType(), args);	    	//$NON-NLS-1$
						 		matchedOne = true;
						 		initStartEndPositions(astNode);
					    	
			}
			else {
				break _loop3140;
			}
			
		} while (true);
		}
		
					if (!matchedOne) {
						// pop the redunant token that we didn't need
				 		pop();
					}
				
		}
		return astNode;
	}
	
	public final OCLExpression  oclExpr5CS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
		
			OCLExpression expr = null;
			astNode = null;
			EList args = null;
			String operName = null;
			boolean matchedOne = false;
			OCLToken oclToken = null;
		
		
		{
		oclToken = push();
		astNode=oclExpr6CS(env);
		{
		_loop3147:
		do {
			if ((LA(1)==MULTIPLY||LA(1)==DIVIDE) && (_tokenSet_1.member(LA(2)))) {
				
						  		if (matchedOne) {
						  			// re-push the first token of the composed expression
						  			push(oclToken);
						  		}
						  	
				{
				switch ( LA(1)) {
				case MULTIPLY:
				{
					{
					match(MULTIPLY);
					}
					operName = "times";//$NON-NLS-1$
					break;
				}
				case DIVIDE:
				{
					{
					match(DIVIDE);
					}
					operName = "divide";//$NON-NLS-1$
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				expr=oclExpr6CS(env);
				
								args = new BasicEList();
								args.add(expr);
								astNode = genOperationCallExp(env, "oclExpr5CS", operName, astNode, astNode.getType(), args);//$NON-NLS-1$
						 		matchedOne = true;
						 		initStartEndPositions(astNode);
							
			}
			else {
				break _loop3147;
			}
			
		} while (true);
		}
		
					if (!matchedOne) {
						// pop the redunant token that we didn't need
				 		pop();
					}
				
		}
		return astNode;
	}
	
	public final OCLExpression  oclExpr6CS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
		
			OCLExpression expr = null;
			astNode = null;
			String operName = null;
		
		
		{
		switch ( LA(1)) {
		case PATHNAME:
		case NAME:
		case LPAREN:
		case LITERAL_let:
		case LITERAL_Integer:
		case LITERAL_String:
		case LITERAL_Real:
		case LITERAL_Boolean:
		case LITERAL_OclAny:
		case LITERAL_OclVoid:
		case LITERAL_Set:
		case LITERAL_Bag:
		case LITERAL_Sequence:
		case LITERAL_Collection:
		case LITERAL_OrderedSet:
		case LITERAL_Tuple:
		case NUMBER_LITERAL:
		case REAL_LITERAL:
		case LITERAL_true:
		case LITERAL_false:
		case STRING_LITERAL:
		case LITERAL_oclAsType:
		case LITERAL_oclIsKindOf:
		case LITERAL_oclIsTypeOf:
		case LITERAL_closure:
		case LITERAL_closureAll:
		case OPERATION_EXPR:
		{
			astNode=oclExpr7CS(env);
			break;
		}
		case MINUS:
		case LITERAL_not:
		{
			{
			push();
			{
			switch ( LA(1)) {
			case MINUS:
			{
				{
				match(MINUS);
				}
				
									operName = "minus";//$NON-NLS-1$
								
				break;
			}
			case LITERAL_not:
			{
				{
				match(LITERAL_not);
				}
				operName = "not";//$NON-NLS-1$
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			expr=oclExpr6CS(env);
			
							astNode = genOperationCallExp(env, "oclExpr6CS", operName, expr, expr.getType(), new BasicEList());//$NON-NLS-1$
							initStartEndPositions(astNode);
						
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return astNode;
	}
	
	public final OCLExpression  oclExpr7CS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
		
			astNode = null;
			OCLToken oclToken = null;
		
		
		oclToken = (OCLToken) LT(1);
		{
		astNode=oclExprCS(env, null);
		astNode=dotOrArrowExtension(env, astNode, oclToken);
		}
		return astNode;
	}
	
	public final OCLExpression  oclExprCS(
		Environment env, OCLExpression source
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
			astNode = null;
				EList qualifiers = null;
				boolean isMarkedPre = false;
			
		
		push();
		{
		switch ( LA(1)) {
		case LITERAL_let:
		{
			astNode=letExpCS(env);
			break;
		}
		case PATHNAME:
		case LITERAL_Set:
		case LITERAL_Bag:
		case LITERAL_Sequence:
		case LITERAL_Collection:
		case LITERAL_OrderedSet:
		case LITERAL_Tuple:
		case NUMBER_LITERAL:
		case REAL_LITERAL:
		case LITERAL_true:
		case LITERAL_false:
		case STRING_LITERAL:
		{
			astNode=literalExpCS(env);
			break;
		}
		case LPAREN:
		{
			match(LPAREN);
			astNode=oclExpressionCS(env);
			match(RPAREN);
			break;
		}
		default:
			if ((_tokenSet_2.member(LA(1))) && (LA(2)==LPAREN)) {
				astNode=operationCallExpCS(env, source, false);
			}
			else if ((_tokenSet_3.member(LA(1))) && (_tokenSet_4.member(LA(2)))) {
				astNode=simpleVariableCS(env, source);
				{
				switch ( LA(1)) {
				case LBRACKET:
				{
					qualifiers=qualifiersCS(env, astNode);
					break;
				}
				case EOF:
				case LITERAL_endpackage:
				case LITERAL_context:
				case RPAREN:
				case COMMA:
				case LITERAL_pre:
				case LITERAL_post:
				case LITERAL_body:
				case LITERAL_inv:
				case LITERAL_implies:
				case LITERAL_and:
				case LITERAL_or:
				case LITERAL_xor:
				case EQUALS:
				case NEQUALS:
				case GT:
				case GE:
				case LT:
				case LE:
				case LITERAL_then:
				case LITERAL_else:
				case LITERAL_endif:
				case PLUS:
				case MINUS:
				case MULTIPLY:
				case DIVIDE:
				case DOT:
				case ARROW:
				case PRE:
				case RBRACKET:
				case LITERAL_in:
				case RBRACE:
				case DOTDOT:
				case BAR:
				case SEMICOLON:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case PRE:
				{
					match(PRE);
					isMarkedPre=true;
					break;
				}
				case EOF:
				case LITERAL_endpackage:
				case LITERAL_context:
				case RPAREN:
				case COMMA:
				case LITERAL_pre:
				case LITERAL_post:
				case LITERAL_body:
				case LITERAL_inv:
				case LITERAL_implies:
				case LITERAL_and:
				case LITERAL_or:
				case LITERAL_xor:
				case EQUALS:
				case NEQUALS:
				case GT:
				case GE:
				case LT:
				case LE:
				case LITERAL_then:
				case LITERAL_else:
				case LITERAL_endif:
				case PLUS:
				case MINUS:
				case MULTIPLY:
				case DIVIDE:
				case DOT:
				case ARROW:
				case RBRACKET:
				case LITERAL_in:
				case RBRACE:
				case DOTDOT:
				case BAR:
				case SEMICOLON:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		
			initStartEndPositions(astNode);
			
				if (isMarkedPre) {
					if (astNode instanceof ModelPropertyCallExp) {
						((ModelPropertyCallExp) astNode).setMarkedPre(isMarkedPre);
					} else {
		ERROR("oclExprCS", ILLEGAL_AT_PRE_ERROR_);//$NON-NLS-1$
					}
				}
				
				if (qualifiers != null) {
					if (astNode instanceof NavigationCallExp) {
						setQualifiers(env, "oclExprCS", (NavigationCallExp) astNode, qualifiers);//$NON-NLS-1$
					} else if ((astNode instanceof LoopExp)
							&& ((LoopExp) astNode).getBody() instanceof NavigationCallExp) {
						// might have parsed an implicit collect expression
						setQualifiers(env, "oclExprCS",//$NON-NLS-1$
							(NavigationCallExp) ((LoopExp) astNode).getBody(), qualifiers);
					} else {
						ERROR("oclExprCS", ILLEGAL_QUALIFIERS_ERROR_);//$NON-NLS-1$
					}
				} else if (astNode instanceof AssociationClassCallExp) {
					checkNotReflexive(env, "oclExprCS", (AssociationClassCallExp) astNode);//$NON-NLS-1$
				}
			
		return astNode;
	}
	
	public final OCLExpression  dotOrArrowExtension(
		Environment env, OCLExpression source, OCLToken oclToken
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
		
			OCLExpression expr = null;
			astNode = source;
		
		
		{
		_loop3162:
		do {
			if ((LA(1)==DOT||LA(1)==ARROW) && (_tokenSet_5.member(LA(2)))) {
				push(oclToken);
				{
				switch ( LA(1)) {
				case DOT:
				{
					{
					match(DOT);
					expr=modelPropertyCallExpCS(env, astNode);
					}
					
								  	TRACE("dotOrArrowExtension", "dot"); //$NON-NLS-2$//$NON-NLS-1$
								
					break;
				}
				case ARROW:
				{
					{
					match(ARROW);
					}
						
							   	  	/* The source must be a collection type.
							   	  	 */
							   	  	if (!(astNode.getType() instanceof CollectionType)) {
							   	  		CollectionLiteralExp astNode1 = expressionsFactory.createCollectionLiteralExp();
										astNode1.setKind(CollectionKind.SET_LITERAL);
										EList collectionParts = astNode1.getParts();
										CollectionItem collItem = expressionsFactory.createCollectionItem();
										collItem.setType(astNode.getType());
										collItem.setItem(astNode);				
										collectionParts.add(collItem);
							   	  		SetType type = typesFactory.createSetType(astNode.getType());
							   	  		type.setName("Set(" + type.getName() + ")" );//$NON-NLS-2$//$NON-NLS-1$
							   	  		astNode1.setType(type);
							   	  		astNode = astNode1;
							   	  	}	
							   	  		
							   	
					{
					expr=setExpCS(env, astNode);
					}
					
							   	  	TRACE("dotOrArrowExtension", "arrow"); //$NON-NLS-2$//$NON-NLS-1$
							   	
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				
						      astNode = expr;
						      initStartEndPositions(expr);	              	 
						
			}
			else {
				break _loop3162;
			}
			
		} while (true);
		}
		return astNode;
	}
	
	public final OCLExpression  modelPropertyCallExpCS(
		Environment env, OCLExpression source
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
			astNode = null;
				EList qualifiers = null;
				boolean isMarkedPre = false;
		
		{
		if ((_tokenSet_2.member(LA(1))) && (LA(2)==LPAREN)) {
			{
			astNode=operationCallExpCS(env, source, true);
			}
		}
		else if ((_tokenSet_3.member(LA(1))) && (_tokenSet_4.member(LA(2)))) {
			{
			astNode=simpleVariableCS(env, source);
			{
			switch ( LA(1)) {
			case LBRACKET:
			{
				qualifiers=qualifiersCS(env, astNode);
				break;
			}
			case EOF:
			case LITERAL_endpackage:
			case LITERAL_context:
			case RPAREN:
			case COMMA:
			case LITERAL_pre:
			case LITERAL_post:
			case LITERAL_body:
			case LITERAL_inv:
			case LITERAL_implies:
			case LITERAL_and:
			case LITERAL_or:
			case LITERAL_xor:
			case EQUALS:
			case NEQUALS:
			case GT:
			case GE:
			case LT:
			case LE:
			case LITERAL_then:
			case LITERAL_else:
			case LITERAL_endif:
			case PLUS:
			case MINUS:
			case MULTIPLY:
			case DIVIDE:
			case DOT:
			case ARROW:
			case PRE:
			case RBRACKET:
			case LITERAL_in:
			case RBRACE:
			case DOTDOT:
			case BAR:
			case SEMICOLON:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case PRE:
			{
				match(PRE);
				isMarkedPre=true;
				break;
			}
			case EOF:
			case LITERAL_endpackage:
			case LITERAL_context:
			case RPAREN:
			case COMMA:
			case LITERAL_pre:
			case LITERAL_post:
			case LITERAL_body:
			case LITERAL_inv:
			case LITERAL_implies:
			case LITERAL_and:
			case LITERAL_or:
			case LITERAL_xor:
			case EQUALS:
			case NEQUALS:
			case GT:
			case GE:
			case LT:
			case LE:
			case LITERAL_then:
			case LITERAL_else:
			case LITERAL_endif:
			case PLUS:
			case MINUS:
			case MULTIPLY:
			case DIVIDE:
			case DOT:
			case ARROW:
			case RBRACKET:
			case LITERAL_in:
			case RBRACE:
			case DOTDOT:
			case BAR:
			case SEMICOLON:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			}
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		
				if (isMarkedPre) {
					if (astNode instanceof ModelPropertyCallExp) {
						((ModelPropertyCallExp) astNode).setMarkedPre(isMarkedPre);
					} else {
		ERROR("modelPropertyCallExpCS", ILLEGAL_AT_PRE_ERROR_);//$NON-NLS-1$
					}
				}
				
				if (qualifiers != null) {
					if (astNode instanceof NavigationCallExp) {
						setQualifiers(env, "modelPropertyCallExpCS",//$NON-NLS-1$
							(NavigationCallExp) astNode, qualifiers);
					} else if ((astNode instanceof LoopExp)
							&& ((LoopExp) astNode).getBody() instanceof NavigationCallExp) {
						// might have parsed an implicit collect expression
						setQualifiers(env, "modelPropertyCallExpCS",//$NON-NLS-1$
							(NavigationCallExp) ((LoopExp) astNode).getBody(), qualifiers);
					} else {
						ERROR("modelPropertyCallExpCS", ILLEGAL_QUALIFIERS_ERROR_);//$NON-NLS-1$
					}
				} else if (astNode instanceof AssociationClassCallExp) {
					checkNotReflexive(env, "modelPropertyCallExpCS",//$NON-NLS-1$
						(AssociationClassCallExp) astNode);
				}
			
		return astNode;
	}
	
	public final OCLExpression  setExpCS(
		Environment env, OCLExpression source
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
			astNode = null;
		
		{
		switch ( LA(1)) {
		case LITERAL_forAll:
		case LITERAL_exists:
		case LITERAL_isUnique:
		case LITERAL_any:
		case LITERAL_one:
		case LITERAL_collect:
		case LITERAL_select:
		case LITERAL_reject:
		case LITERAL_collectNested:
		case LITERAL_sortedBy:
		{
			{
			astNode=iteratorExpCS(env, source);
			}
			break;
		}
		case LITERAL_iterate:
		{
			{
			astNode=iterateExpCS(env, source);
			}
			break;
		}
		case NAME:
		case LITERAL_oclAsType:
		case LITERAL_oclIsKindOf:
		case LITERAL_oclIsTypeOf:
		case LITERAL_closure:
		case LITERAL_closureAll:
		case OPERATION_EXPR:
		{
			{
			astNode=operationCallExpCS(env, source, false);
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return astNode;
	}
	
	public final LetExp  letExpCS(
		 Environment env
	) throws RecognitionException, TokenStreamException {
		LetExp astNode;
		
		
			  VariableDeclaration varDeclaration;
			  OCLExpression letSubExp;
			  String varName = null;	  
			  astNode = null;
		
		
		{
		match(LITERAL_let);
		varDeclaration=variableDeclarationCS(env, true);
		
			   		varName = varDeclaration.getVarName();
				if (varDeclaration.getType() == null) {
		String message = NLS.bind(MissingTypeForVar_ERROR_,
		new Object[] { varName });
		ERROR("letExpCS", message);//$NON-NLS-1$
			   		}
			   		if (varDeclaration.getInitExpression() == null) {
		String message = NLS.bind(MissingInitForVar_ERROR_,
		new Object[] { varName });
		ERROR("letExpCS", message);//$NON-NLS-1$
			   		} 
			
		letSubExp=letExpSubCS(env);
		}
		
			   
			   astNode = expressionsFactory.createLetExp(); 
			   astNode.setVariable(varDeclaration);
			   astNode.setIn(letSubExp);
			   astNode.setType(letSubExp.getType());
			   env.deleteElement(varName);
			
		return astNode;
	}
	
	public final OCLExpression  operationCallExpCS(
		Environment env,  OCLExpression source, boolean dotOperator
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
		Token  t = null;
		Token  t1 = null;
		Token  t2 = null;
		Token  t3 = null;
		Token  t4 = null;
		Token  t5 = null;
		Token  p = null;
		
			astNode = null;
			EList args = null;
			String operationName = null;
			IntegerLiteralExp intSource = null;
			OCLExpression referenceArg = null;
			boolean isMarkedPre = false;
			OCLToken oclToken = null;
			OCLToken nameToken = null;
		
		
		{
		switch ( LA(1)) {
		case LITERAL_oclAsType:
		case LITERAL_oclIsKindOf:
		case LITERAL_oclIsTypeOf:
		{
			{
			switch ( LA(1)) {
			case LITERAL_oclAsType:
			{
				{
				t = LT(1);
				match(LITERAL_oclAsType);
				operationName = "oclAsType";//$NON-NLS-1$
								  nameToken = (OCLToken) t;
				}
				break;
			}
			case LITERAL_oclIsKindOf:
			{
				{
				t1 = LT(1);
				match(LITERAL_oclIsKindOf);
				operationName = "oclIsKindOf";//$NON-NLS-1$
								  nameToken = (OCLToken) t1;
				}
				break;
			}
			case LITERAL_oclIsTypeOf:
			{
				{
				t2 = LT(1);
				match(LITERAL_oclIsTypeOf);
				operationName = "oclIsTypeOf";//$NON-NLS-1$
								  nameToken = (OCLToken) t2;
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			args=operationArgs(env, operationName);
			}
			break;
		}
		case LITERAL_closure:
		case LITERAL_closureAll:
		{
			{
			{
			switch ( LA(1)) {
			case LITERAL_closure:
			{
				t3 = LT(1);
				match(LITERAL_closure);
				operationName = "closure";//$NON-NLS-1$
								  nameToken = (OCLToken) t3;
				break;
			}
			case LITERAL_closureAll:
			{
				t4 = LT(1);
				match(LITERAL_closureAll);
				operationName = "closureAll";//$NON-NLS-1$
								  nameToken = (OCLToken) t4;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LPAREN);
			oclToken = (OCLToken) LT(1);
			referenceArg=modelPropertyCallExpCS(env, source);
			referenceArg=dotOrArrowExtension(env, referenceArg, oclToken);
			
					     	args = new BasicEList();
					     	args.add(referenceArg); 
					
			match(RPAREN);
			}
			break;
		}
		case NAME:
		{
			{
			t5 = LT(1);
			match(NAME);
			match(LPAREN);
			{
			switch ( LA(1)) {
			case PATHNAME:
			case NAME:
			case LPAREN:
			case LITERAL_if:
			case MINUS:
			case LITERAL_not:
			case LITERAL_let:
			case LITERAL_Integer:
			case LITERAL_String:
			case LITERAL_Real:
			case LITERAL_Boolean:
			case LITERAL_OclAny:
			case LITERAL_OclVoid:
			case LITERAL_Set:
			case LITERAL_Bag:
			case LITERAL_Sequence:
			case LITERAL_Collection:
			case LITERAL_OrderedSet:
			case LITERAL_Tuple:
			case NUMBER_LITERAL:
			case REAL_LITERAL:
			case LITERAL_true:
			case LITERAL_false:
			case STRING_LITERAL:
			case LITERAL_oclAsType:
			case LITERAL_oclIsKindOf:
			case LITERAL_oclIsTypeOf:
			case LITERAL_closure:
			case LITERAL_closureAll:
			case OPERATION_EXPR:
			{
				args=argumentsCS(env);
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RPAREN);
			}
			operationName = unquote(t5.getText());
					   nameToken = (OCLToken) t5;
			break;
		}
		case OPERATION_EXPR:
		{
			{
			p = LT(1);
			match(OPERATION_EXPR);
			}
			
						String text = p.getText();
						StringTokenizer tokenizer = new StringTokenizer(text, ".");//$NON-NLS-1$
						intSource = expressionsFactory.createIntegerLiteralExp();
						intSource.setType(PrimitiveTypeImpl.OCL_INTEGER);
						intSource.setIntegerSymbol(new Integer(tokenizer.nextToken()));
						operationName = unquote(tokenizer.nextToken());
						nameToken = createFakeToken(
							((OCLToken) p).getStartPosition() + text.indexOf('.' + 1), // known BMP code point
							operationName.length());
					
			{
			args=operationArgs(env, operationName);
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
			
				/*
				 * The type of the operation is specified by a path expression
				 * or self, or by an explicit source expression.  The source expression
				 * may be a collection type (-> operation) or a regular navigation expression
				 * (. operation)
				 */
				OCLExpression src = source;
				if (intSource != null) {
					src = intSource;  // source is an integer:  number.name(...)
				} else if (src == null) {  // create an implicit source
					VariableExp vexp = expressionsFactory.createVariableExp();
					VariableDeclaration implicitSource = 
							env.lookupImplicitSourceForOperation(operationName, args);
					vexp.setType(implicitSource.getType());
					vexp.setReferredVariable(implicitSource);
					vexp.setName(implicitSource.getVarName());
					src = vexp;
				}

				/*
				 * If the source type is a collection and operator is ".",
				 * then there is an implicit COLLECT operator.
				 */
				EClassifier operationSourceType = src.getType();
				boolean isImplicitCollect = dotOperator && (operationSourceType instanceof CollectionType);
				
				if (isImplicitCollect) {
					operationSourceType = ((CollectionType) operationSourceType).getElementType();
				}
				
				astNode = genOperationCallExp(env, "operationCallExpCS", operationName,//$NON-NLS-1$
						src, operationSourceType, args);
				
				((OperationCallExp) astNode).setMarkedPre(isMarkedPre);
				initPropertyPositions((OperationCallExp) astNode, nameToken);
		
				/*
				 * If the source type is a collection and operator is ".",
				 * then there is an implicit COLLECT operator.
				 */
				if (isImplicitCollect) {
					astNode = createImplicitCollect(src, (OperationCallExp) astNode, env); 			
			   	}
			
		return astNode;
	}

	/**
	 * Creates an implicit <code>collect</code> iterator expression for a
	 * property call on a collection-type source expression.
	 * 
	 * @param source the property call source expression
	 * @param propertyCall the property call expression
	 * @param env the current environment
	 * 
	 * @return the collect expression
	 * 
	 * @throws RecognitionException on failure to create the collect iterator variable
	 */
	private IteratorExp createImplicitCollect(OCLExpression source,
			ModelPropertyCallExp propertyCall, Environment env) throws RecognitionException {
		
		EClassifier sourceElementType = ((CollectionType) source.getType()).getElementType();
		
		IteratorExp result = expressionsFactory.createIteratorExp();
		
		VariableDeclaration itervar = genVariableDeclaration("modelPropertyCallCS", env,//$NON-NLS-1$
						null, sourceElementType, null, false, true, false);

		EList iters = result.getIterators();
		iters.add(itervar);
		result.setBody(propertyCall);
		result.setName("collect");//$NON-NLS-1$
		VariableExp vexp = expressionsFactory.createVariableExp();
		vexp.setType(itervar.getType());
		vexp.setReferredVariable(itervar);
		vexp.setName(itervar.getVarName());
		
		/* adjust the source variable for the body expression to be the
		   newly generated implicit iterator variable */
		propertyCall.setSource(vexp);
		
		if (!(propertyCall instanceof OperationCallExp)) {
			// the overall start and end positions are the property positions
			propertyCall.setStartPosition(propertyCall.getPropertyStartPosition());
			propertyCall.setEndPosition(propertyCall.getPropertyEndPosition());
		}
		
		result.setSource(source);
		
		// the result of a collect() is flattened, so if the property
		//   that we are collecting is a Collection type, the resulting
		//   type must be flattened by taking its element type
		EClassifier bodyType = propertyCall.getType();
		if (bodyType instanceof CollectionType) {
			bodyType = ((CollectionType) bodyType).getElementType();
		}
		
		if (source.getType() instanceof SequenceType ||
				source.getType() instanceof OrderedSetType) {
			result.setType(typesFactory.createSequenceType(bodyType));
		} else {
			result.setType(typesFactory.createBagType(bodyType));
		}
		
		env.deleteElement(itervar.getVarName());
		
		return result;
	}
	
	public final OCLExpression  literalExpCS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
			astNode = null;
		
		
		{
		switch ( LA(1)) {
		case NUMBER_LITERAL:
		case REAL_LITERAL:
		case LITERAL_true:
		case LITERAL_false:
		case STRING_LITERAL:
		{
			astNode=primitiveLiteralExpCS(env);
			break;
		}
		case LITERAL_Set:
		case LITERAL_Bag:
		case LITERAL_Sequence:
		case LITERAL_Collection:
		case LITERAL_OrderedSet:
		{
			astNode=collectionLiteralExpCS(env);
			break;
		}
		case LITERAL_Tuple:
		{
			astNode=tupleLiteralExpCS(env);
			break;
		}
		case PATHNAME:
		{
			astNode=enumerationOrClassLiteralExpCS(env);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return astNode;
	}
	
	public final OCLExpression  simpleVariableCS(
		Environment env, OCLExpression source
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
		Token  t = null;
		
				String simpleName;
				
				astNode = null;
				EAttribute eattr = null;
				EReference eref = null;
				EClassifier classifier = null;
				AttributeCallExp attr = null;
				AssociationEndCallExp ref = null;
				EClass assocClass = null;
				AssociationClassCallExp acref = null;
				VariableDeclaration vdcl = null;
			
		
		{
		switch ( LA(1)) {
		case NAME:
		{
			t = LT(1);
			match(NAME);
			break;
		}
		case LITERAL_Integer:
		case LITERAL_String:
		case LITERAL_Real:
		case LITERAL_Boolean:
		case LITERAL_OclAny:
		case LITERAL_OclVoid:
		{
			classifier=primitiveTypeCS();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		
				
				/* A name can be a variable defined by a Variable declaration, the special
				  variable "self", an attribute or a reference to another object.
				  If the source is not null, then the last token was a "." or "->"
				  The source is used to establish the navigation.
				  If no type is provided, then either the name is a the use of a variable,
				  or there is an implicit variable declaration (self or an iterator)
				  that is the source.		  		   
				 */
				if (t != null) {
					simpleName = unquote(t.getText());
				} else {
						simpleName = classifier.getName();
				}
				
				/*
				 * The source may be a collection type (for example, in self.children.name, children
				 * may be a set.)_  In this case, we have to get the element type of children, so
				 * that the attribute name can be found.
				 * The source type can also be a tuple type. In this case, we need to get the 
				 * EClass of the tuple.
				 * 
				 */ 
				EClassifier sourceElementType = null;
				if (source != null) {
					sourceElementType = source.getType();
					if (sourceElementType instanceof CollectionType) {
						sourceElementType = ((CollectionType) sourceElementType).getElementType();
					} 
				}
				
				Vector names = new Vector();
				names.addElement(simpleName);
				if (classifier == null) {
						classifier = env.lookupPathName(names);
				}
				if (classifier != null) {
					/* Variable is a classifier. Classifiers are used in
					 * allInstances, isKindOf, isTypeOf, asTypeOf operators
					 * It is not clear how to represent types as OclExpressions,
					 * so we generate an UnspecifiedValueExpression with correct type.
					 */
					
					UnspecifiedValueExp vexp = expressionsFactory.createUnspecifiedValueExp();	
					vexp.setType( classifier);
					astNode = vexp;			 		
				} else if (source == null && (vdcl = env.lookup(simpleName)) != null)  { 
					// Either a use of a declared variable or self
		
					TRACE("variableExpCS", "Variable Expression: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$
					
					/*if (source != null) {
						ERROR("simpleVariableExp", "Can't have a variable in the middle of a navigation path:"
										+ simpleName);
					}*/
					VariableExp vexp = expressionsFactory.createVariableExp();	
					vexp.setReferredVariable(vdcl);
					vexp.setName(vdcl.getVarName());
					vexp.setType( vdcl.getType());
					astNode = vexp;
				} else if ((eattr = env.lookupAttribute( sourceElementType, simpleName)) != null) {
					
					TRACE("variableExpCS", "Attribute: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$
					attr = expressionsFactory.createAttributeCallExp();
					attr.setReferredAttribute(eattr);
					attr.setType(EcoreEnvironment.getOCLType(eattr));
					if (source != null) {
						attr.setSource(source);
					} else {
						VariableExp src = expressionsFactory.createVariableExp();
						VariableDeclaration implicitSource = env.lookupImplicitSourceForAttribute(simpleName);
						src.setType(implicitSource.getType());
						src.setReferredVariable(implicitSource);
						src.setName(implicitSource.getVarName());
						attr.setSource(src);
					}
					initPropertyPositions(attr, (OCLToken) t);
					astNode = attr;
								
				} else if ((eref = env.lookupReference( sourceElementType, simpleName)) != null) {
					TRACE("variableExpCS", "Reference: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$
					ref = expressionsFactory.createAssociationEndCallExp();
					ref.setReferredAssociationEnd(eref);
					ref.setType(EcoreEnvironment.getOCLType(eref));
					
					if (source != null) {
						ref.setSource(source);
					} else {
						VariableExp src = expressionsFactory.createVariableExp();
						VariableDeclaration implicitSource = env.lookupImplicitSourceForAssociationEnd(simpleName);
						src.setType(implicitSource.getType());
						src.setReferredVariable(implicitSource);
						src.setName(implicitSource.getVarName());
						ref.setSource(src);
					}
					initPropertyPositions(ref, (OCLToken) t);
					astNode = ref;
					
				} else if ((assocClass = env.lookupAssociationClassReference(sourceElementType, simpleName)) != null) {
					TRACE("variableExpCS", "Association class: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$
					acref = expressionsFactory.createAssociationClassCallExp();
					acref.setReferredAssociationClass(assocClass);
					acref.setType(assocClass);
					
					if (source != null) {
						acref.setSource(source);
					} else {
						VariableExp src = expressionsFactory.createVariableExp();
						VariableDeclaration implicitSource = env.lookupImplicitSourceForAssociationClass(simpleName);
						src.setType(implicitSource.getType());
						src.setReferredVariable(implicitSource);
						src.setName(implicitSource.getVarName());
						acref.setSource(src);
					}
					initPropertyPositions(acref, (OCLToken) t);
					astNode = acref;
					
				} else {
					if (source != null && (vdcl = env.lookup(simpleName)) != null) {
		String message = NLS.bind(VarInNavExp_ERROR_,
		new Object[] { simpleName });
		ERROR("variableExpCS", message);//$NON-NLS-1$
					} else {
		String message = NLS.bind(UnrecognizedVar_ERROR_,
		new Object[] { simpleName });
		ERROR("variableExpCS", message);//$NON-NLS-1$
					}
				}
				
				/*
				 * If the source type is a collection, then need there is an implicit COLLECT operator.
				 * Not that this rule is not called after "->".
				 */
				if (source != null && source.getType() instanceof CollectionType) {
					astNode = createImplicitCollect(source, (ModelPropertyCallExp) astNode, env);
			   	}
			
		return astNode;
	}
	
	protected final EList  qualifiersCS(
		Environment env, OCLExpression navigation
	) throws RecognitionException, TokenStreamException {
		EList qualifiers;
		
		
			OCLExpression expr = null;
			OCLExpression source = null;
			
			if (navigation instanceof LoopExp) {
				// extract the navigation expression from an iteration expression,
				//    if any
				navigation = ((LoopExp) navigation).getBody();
			}
		
		
		match(LBRACKET);
		{
		if (((_tokenSet_6.member(LA(1))) && (_tokenSet_7.member(LA(2))))&&( navigation instanceof AssociationClassCallExp )) {
			{
			
							AssociationClassCallExp acc = (AssociationClassCallExp) navigation;
							source = acc.getSource();
							push((OCLToken) LT(1));
						
			expr=modelPropertyCallExpCS(env, source);
			
							initStartEndPositions(expr);
							qualifiers = new BasicEList();
							acc.setSource(source); // expr "stole" the source
							qualifiers.add(expr);
						
			}
		}
		else if ((_tokenSet_0.member(LA(1))) && (_tokenSet_8.member(LA(2)))) {
			qualifiers=argumentsCS(env);
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		match(RBRACKET);
		return qualifiers;
	}
	
	public final BasicEList  argumentsCS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		BasicEList arguments;
		
			arguments = null;
			OCLExpression expr; 
		
		
		{
		expr=oclExpressionCS(env);
		{
		switch ( LA(1)) {
		case COMMA:
		{
			match(COMMA);
			arguments=argumentsCS(env);
			break;
		}
		case RPAREN:
		case RBRACKET:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		}
		
		if (arguments == null) arguments = new BasicEList();
			    arguments.add(0, expr);	    
			
		return arguments;
	}
	
	public final IteratorExp  iteratorExpCS(
		Environment env, OCLExpression source
	) throws RecognitionException, TokenStreamException {
		IteratorExp astNode;
		
		
			astNode = null; 
			String name = null;
		
		
		{
		{
		switch ( LA(1)) {
		case LITERAL_forAll:
		{
			match(LITERAL_forAll);
			name = "forAll";//$NON-NLS-1$
			break;
		}
		case LITERAL_exists:
		{
			match(LITERAL_exists);
			name = "exists";//$NON-NLS-1$
			break;
		}
		case LITERAL_isUnique:
		{
			match(LITERAL_isUnique);
			name = "isUnique";//$NON-NLS-1$
			break;
		}
		case LITERAL_any:
		{
			match(LITERAL_any);
			name = "any";//$NON-NLS-1$
			break;
		}
		case LITERAL_one:
		{
			match(LITERAL_one);
			name = "one";//$NON-NLS-1$
			break;
		}
		case LITERAL_collect:
		{
			match(LITERAL_collect);
			name = "collect";//$NON-NLS-1$
			break;
		}
		case LITERAL_select:
		{
			match(LITERAL_select);
			name = "select";//$NON-NLS-1$
			break;
		}
		case LITERAL_reject:
		{
			match(LITERAL_reject);
			name = "reject";//$NON-NLS-1$
			break;
		}
		case LITERAL_collectNested:
		{
			match(LITERAL_collectNested);
			name = "collectNested";//$NON-NLS-1$
			break;
		}
		case LITERAL_sortedBy:
		{
			match(LITERAL_sortedBy);
			name = "sortedBy";//$NON-NLS-1$
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(LPAREN);
		astNode=iterContents(env, name, source);
		match(RPAREN);
		}
		return astNode;
	}
	
	public final IterateExp  iterateExpCS(
		Environment env, OCLExpression source
	) throws RecognitionException, TokenStreamException {
		IterateExp astNode;
		
		
			astNode = null; 
			VariableDeclaration vdcl = null;
			VariableDeclaration vdcl1 = null;
			OCLExpression expr = null;
		
		
		{
		{
		match(LITERAL_iterate);
		match(LPAREN);
		vdcl=variableDeclarationCS(env, true);
		{
		switch ( LA(1)) {
		case SEMICOLON:
		{
			match(SEMICOLON);
			vdcl1=variableDeclarationCS(env, true);
			break;
		}
		case BAR:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(BAR);
		}
		
					/* If there is only one variable declaration, then it is the result, vdcl1. 
				   		The missing variable declaration is treated as the implicit iterator vdcl.
				 	*/
					if (vdcl1 == null) {
						vdcl1 = vdcl;
						vdcl = null;
					}	
				
					if (vdcl == null) { // synthesize a new variable declaration.		
						vdcl = genVariableDeclaration("iterateExpCS", env, null, //$NON-NLS-1$
								((CollectionType) source.getType()).getElementType(), null, false, true, false);	
					} 
					if ( vdcl.getType() == null) {
						vdcl.setType(((CollectionType) source.getType()).getElementType());
					}
				
		{
		expr=oclExpressionCS(env);
		match(RPAREN);
		}
		}
		
				TRACE("iterateExpCS", "iterate");//$NON-NLS-2$//$NON-NLS-1$
				astNode = expressionsFactory.createIterateExp();
				astNode.setName("iterate");			//$NON-NLS-1$
				EList iterator = astNode.getIterators();
				iterator.add(vdcl);
				astNode.setSource(source);
				astNode.setResult(vdcl1);
				astNode.setBody(expr);
				
				
				if (vdcl1.getType() == null) {
		String message = NLS.bind(DeclarationType_ERROR_,
		new Object[] { vdcl1.getVarName() });
		ERROR("iterateExpCS", message);//$NON-NLS-1$
				}
				
				astNode.setType(vdcl1.getType());
				
				if (vdcl1.getInitExpression() == null) {
		String message = NLS.bind(DeclarationNoInitExp_ERROR_,
		new Object[] { vdcl1.getVarName() });
		ERROR("iterateExpCS", message);//$NON-NLS-1$
				}
				if (vdcl.getInitExpression() != null) {
		String message = NLS.bind(DeclarationInitExp_ERROR_,
		new Object[] { vdcl1.getVarName() });
		ERROR("iterateExpCS", message);//$NON-NLS-1$
				} 
				
				env.deleteElement(vdcl.getVarName());
				env.deleteElement(vdcl1.getVarName());
				
			
		return astNode;
	}
	
	public final OCLExpression  letExpSubCS(
		 Environment env
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
		
			VariableDeclaration varDeclaration;
			OCLExpression letSubExp;
			String varName = null;
			LetExp letExp;		
			astNode = null;
		
		
		switch ( LA(1)) {
		case COMMA:
		{
			{
			match(COMMA);
			varDeclaration=variableDeclarationCS(env, true);
			
						if (varDeclaration.getType() == null) {
			String message = NLS.bind(NoType_ERROR_,
			new Object[] { varName });
			ERROR("letExpSubCS", message);//$NON-NLS-1$
						}
						if (varDeclaration.getInitExpression() == null) {
			String message = NLS.bind(NoInitExp_ERROR_,
			new Object[] { varName });
			ERROR("letExpSubCS", message);//$NON-NLS-1$
						}
					
			letSubExp=letExpSubCS(env);
			}
			
					varName = varDeclaration.getVarName();
					env.deleteElement(varName);
			
					letExp = expressionsFactory.createLetExp(); 
					letExp.setVariable(varDeclaration);
					letExp.setIn(letSubExp);
					letExp.setType(letSubExp.getType());		
					astNode = letExp;
				
			break;
		}
		case LITERAL_in:
		{
			{
			match(LITERAL_in);
			astNode=oclExpressionCS(env);
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		return astNode;
	}
	
/**
 * primitiveTypeCS
 */
	public final EClassifier  primitiveTypeCS() throws RecognitionException, TokenStreamException {
		EClassifier astNode;
		
		astNode = null;
		
		
		{
		switch ( LA(1)) {
		case LITERAL_Integer:
		{
			match(LITERAL_Integer);
			
									astNode = PrimitiveTypeImpl.OCL_INTEGER;
			break;
		}
		case LITERAL_String:
		{
			match(LITERAL_String);
			
								 astNode = PrimitiveTypeImpl.OCL_STRING;
			break;
		}
		case LITERAL_Real:
		{
			match(LITERAL_Real);
			
								 astNode = PrimitiveTypeImpl.OCL_REAL;
			break;
		}
		case LITERAL_Boolean:
		{
			match(LITERAL_Boolean);
			
									astNode = PrimitiveTypeImpl.OCL_BOOLEAN;
			break;
		}
		case LITERAL_OclAny:
		{
			match(LITERAL_OclAny);
			astNode = AnyTypeImpl.OCL_ANY_TYPE;
			break;
		}
		case LITERAL_OclVoid:
		{
			match(LITERAL_OclVoid);
			astNode = Types.OCL_VOID;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return astNode;
	}
	
	public final CollectionType  collectionTypeCS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		CollectionType astNode;
		
			astNode = null;
			EClassifier type = null;
		
		
		{
		astNode=collectionTypeIdentifierCS();
		match(LPAREN);
		type=typeCS(env);
		match(RPAREN);
		}
		
				astNode.setElementType(type);
				astNode.setName(astNode.getName() + "(" + type.getName() + ")" );//$NON-NLS-2$//$NON-NLS-1$
				
				OCLToken typeToken = OCLTokenAdapter.getToken(type);
				astNode.setTypeStartPosition(typeToken.getStartPosition());
				astNode.setTypeEndPosition(typeToken.getEndPosition());
			
		return astNode;
	}
	
	public final EClassifier  tupleTypeCS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		EClassifier astNode;
		
		
			astNode = null;
			VariableDeclaration vdcl = null;
			HashSet names = null;
			EList vdcls = null;
			String nodeName = null;
		
		
		{
		match(LITERAL_Tuple);
		match(LPAREN);
		
					TRACE("typeTypeCS", "Tuple Type");//$NON-NLS-2$//$NON-NLS-1$
					names = new HashSet();
					vdcls = new BasicEList();		
				
		{
		switch ( LA(1)) {
		case NAME:
		{
			vdcl=variableDeclarationCS(env, false);
			
							String name = vdcl.getVarName();
							TRACE("tupleTypeCS", " name = " + name);//$NON-NLS-2$//$NON-NLS-1$
							names.add(name);
							if (vdcl.getInitExpression() != null) {
			String message = NLS.bind(InitExpNotAllowed_ERROR_,
			new Object[] { name });
			ERROR("tupleTypeCS", message);//$NON-NLS-1$
							}
							if (vdcl.getType() == null) {
			String message = NLS.bind(
			MissingTypeDecl_ERROR_, new Object[] { name });
			ERROR("tupleTypeCS", message);//$NON-NLS-1$
							}  else {
								vdcls.add(vdcl);
								nodeName = "Tuple(" + vdcl.getVarName() + ":" + vdcl.getType().getName();//$NON-NLS-2$//$NON-NLS-1$
								
							}										
						
			{
			_loop3201:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					vdcl=variableDeclarationCS(env, false);
					
										name = vdcl.getVarName();
										TRACE("tupleTypeCS", " name = " + name);//$NON-NLS-2$//$NON-NLS-1$
										if (names.contains(name)) {
					String message = NLS.bind(
					DuplicateNameInTuple_ERROR_,
					new Object[] { name });
					ERROR("tupleTypeCS", message);//$NON-NLS-1$
											vdcl.setVarName(null);
										} else {
											names.add(name);
										}
										
										if (vdcl.getInitExpression() != null) {
					String message = NLS.bind(
					InitExpNotAllowed_ERROR_,
					new Object[] { name });
					ERROR("tupleTypeCS", message);//$NON-NLS-1$
										}
										if (vdcl.getType() == null) {
					String message = NLS.bind(
					MissingTypeDecl_ERROR_,
					new Object[] { name });
					ERROR("tupleTypeCS", message);//$NON-NLS-1$
										}
										vdcls.add(vdcl);
										nodeName += ", " + vdcl.getVarName() + ":" + vdcl.getType().getName();					//$NON-NLS-2$//$NON-NLS-1$
									
				}
				else {
					break _loop3201;
				}
				
			} while (true);
			}
			break;
		}
		case RPAREN:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(RPAREN);
		
					astNode = typesFactory.createTupleType(vdcls);
					astNode.setName(nodeName + ")");//$NON-NLS-1$
				
		}
		return astNode;
	}
	
	public final CollectionType  collectionTypeIdentifierCS() throws RecognitionException, TokenStreamException {
		CollectionType astNode;
		
			astNode = null;
		
		
		{
		switch ( LA(1)) {
		case LITERAL_Set:
		{
			match(LITERAL_Set);
			
						astNode = typesFactory.createSetType();
						astNode.setName("Set");//$NON-NLS-1$
						TRACE("collectionTypeIdentifierCS", "SET");//$NON-NLS-2$//$NON-NLS-1$
					
			break;
		}
		case LITERAL_Bag:
		{
			match(LITERAL_Bag);
			
						astNode = typesFactory.createBagType();
						astNode.setName("Bag");  //$NON-NLS-1$
						TRACE("collectionTypeIdentifierCS", "BAG"); //$NON-NLS-2$//$NON-NLS-1$
					
			break;
		}
		case LITERAL_Sequence:
		{
			match(LITERAL_Sequence);
				
						astNode = typesFactory.createSequenceType();
						astNode.setName("Sequence");//$NON-NLS-1$
						TRACE("collectionTypeIdentifierCS", "SEQUENCE"); //$NON-NLS-2$//$NON-NLS-1$
					
			break;
		}
		case LITERAL_Collection:
		{
			match(LITERAL_Collection);
			
						astNode = typesFactory.createCollectionType();
						astNode.setName("Collection"); //$NON-NLS-1$
						TRACE("collectionTypeIdentifierCS", "COLLECTION"); //$NON-NLS-2$//$NON-NLS-1$
					
			break;
		}
		case LITERAL_OrderedSet:
		{
			match(LITERAL_OrderedSet);
			
						astNode = typesFactory.createOrderedSetType();
						astNode.setName("OrderedSet");//$NON-NLS-1$
						TRACE("collectionTypeIdentifierCS", "ORDERED_SET"); //$NON-NLS-2$//$NON-NLS-1$
					
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		astNode.setElementType(Types.OCL_VOID);
		return astNode;
	}
	
	public final LiteralExp  primitiveLiteralExpCS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		LiteralExp astNode;
		
		astNode = null;
		
		
		{
		switch ( LA(1)) {
		case NUMBER_LITERAL:
		{
			astNode=integerLiteralExpCS(env);
			break;
		}
		case REAL_LITERAL:
		{
			astNode=realLiteralExpCS(env);
			break;
		}
		case STRING_LITERAL:
		{
			astNode=stringLiteralExpCS(env);
			break;
		}
		case LITERAL_true:
		case LITERAL_false:
		{
			astNode=booleanLiteralExpCS(env);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return astNode;
	}
	
	public final CollectionLiteralExp  collectionLiteralExpCS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		CollectionLiteralExp astNode;
		
		
			astNode = null;
			CollectionKind kind = null;
			CollectionLiteralPart collectionLiteralPartExp = null;
			EList collectionParts = null;
			EClassifier type = null;
			CollectionType resultType = null;
		
		
		{
		resultType=collectionTypeIdentifierCS();
			if (resultType instanceof SetType)
						kind = CollectionKind.SET_LITERAL; 
					else if (resultType instanceof BagType)
						kind = CollectionKind.BAG_LITERAL;
					else if (resultType instanceof  SequenceType)
						kind = CollectionKind.SEQUENCE_LITERAL;
					else if (resultType instanceof OrderedSetType)
						kind = CollectionKind.ORDERED_SET_LITERAL;
											
					astNode = expressionsFactory.createCollectionLiteralExp();
					astNode.setKind(kind);
					collectionParts = astNode.getParts();
				
		match(LBRACE);
		{
		switch ( LA(1)) {
		case PATHNAME:
		case NAME:
		case LPAREN:
		case LITERAL_if:
		case MINUS:
		case LITERAL_not:
		case LITERAL_let:
		case LITERAL_Integer:
		case LITERAL_String:
		case LITERAL_Real:
		case LITERAL_Boolean:
		case LITERAL_OclAny:
		case LITERAL_OclVoid:
		case LITERAL_Set:
		case LITERAL_Bag:
		case LITERAL_Sequence:
		case LITERAL_Collection:
		case LITERAL_OrderedSet:
		case LITERAL_Tuple:
		case NUMBER_LITERAL:
		case REAL_LITERAL:
		case LITERAL_true:
		case LITERAL_false:
		case STRING_LITERAL:
		case LITERAL_oclAsType:
		case LITERAL_oclIsKindOf:
		case LITERAL_oclIsTypeOf:
		case LITERAL_closure:
		case LITERAL_closureAll:
		case OPERATION_EXPR:
		{
			collectionLiteralPartExp=collectionLiteralPartCS(env);
			
							collectionParts.add(collectionLiteralPartExp);				
							type = collectionLiteralPartExp.getType();				
						
			{
			_loop3225:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					collectionLiteralPartExp=collectionLiteralPartCS(env);
					
										EClassifier type1 = collectionLiteralPartExp.getType();					
										type = AnyTypeImpl.commonSuperType(type, type1);
										collectionParts.add(collectionLiteralPartExp);
									
				}
				else {
					break _loop3225;
				}
				
			} while (true);
			}
			break;
		}
		case RBRACE:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(RBRACE);
		
					
					if (collectionParts.isEmpty()) {
						resultType.setElementType(Types.OCL_VOID);
						resultType.setName(resultType.getName() + "()");//$NON-NLS-1$
					} else {
						resultType.setElementType(type);
						resultType.setName(resultType.getName() + "(" + type.getName() + ")" );//$NON-NLS-2$//$NON-NLS-1$
					}
					astNode.setType(resultType);
					 
				
		}
		return astNode;
	}
	
	public final TupleLiteralExp  tupleLiteralExpCS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		TupleLiteralExp astNode;
		
		
			astNode = null;
			VariableDeclaration vdcl = null;
			EList tupleParts = null;
			EList vdcls = null;
			HashSet names = null;
			String typeName = null;
		
		
		{
		match(LITERAL_Tuple);
		match(LBRACE);
		
					astNode = expressionsFactory.createTupleLiteralExp();
					tupleParts = astNode.getTuplePart();
					vdcls = new BasicEList();
					TRACE("tupleLiteralExpCS", "Tuple");//$NON-NLS-2$//$NON-NLS-1$
					typeName = "Tuple (";//$NON-NLS-1$
				
		vdcl=variableDeclarationCS(env, false);
		
					tupleParts.add(vdcl); 
					vdcls.add(vdcl);
					
					String name = vdcl.getVarName();
					names = new HashSet();		
					names.add(name);
					TRACE("tupleLiteralExpCS", " name = " + name);//$NON-NLS-2$//$NON-NLS-1$
					if (vdcl.getType() == null) {
		String message = NLS.bind(MissingTypeDecl_ERROR_,
		new Object[] { name });
		ERROR("tupleLiteralExpCS", message);//$NON-NLS-1$
					}
					if (vdcl.getInitExpression() == null) {
		String message = NLS.bind(MissingInit_ERROR_,
		new Object[] { name });
		ERROR("tupleLiteralExpCS", message);//$NON-NLS-1$
					}
					typeName += vdcl.getVarName() + ":" + vdcl.getType().getName();//$NON-NLS-1$
				
		{
		_loop3233:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				vdcl=variableDeclarationCS(env, false);
				
								tupleParts.add(vdcl);
								vdcls.add(vdcl);
								name = vdcl.getVarName();
								TRACE("tupleLiteralExpCS", " name = " + name);//$NON-NLS-2$//$NON-NLS-1$
								if (vdcl.getType() == null) {
				String message = NLS.bind(
				MissingTypeDecl_ERROR_,
				new Object[] { name });
				ERROR("tupleLiteralExpCS", message);//$NON-NLS-1$
								}
								if (vdcl.getInitExpression() == null) {
					                String message = NLS.bind(
					                        MissingInit_ERROR_, new Object[] { name });
					                ERROR("tupleLiteralExpCS", message);//$NON-NLS-1$
								}
								if (names.contains(name)) {
				String message = NLS.bind(
				DuplicateNameInTuple_ERROR_,
				new Object[] { name });
				ERROR("tupleLiteralExpCS", message);//$NON-NLS-1$
									vdcl.setVarName(null);
								} else {
									names.add(name);
								}
								typeName += ", " + vdcl.getVarName() + ":" + vdcl.getType().getName();//$NON-NLS-2$//$NON-NLS-1$
							
			}
			else {
				break _loop3233;
			}
			
		} while (true);
		}
		match(RBRACE);
		
					TupleType tt = typesFactory.createTupleType(vdcls);
					tt.setName(typeName + "}");//$NON-NLS-1$
					astNode.setType(tt);
				
		}
		return astNode;
	}
	
	public final OCLExpression  enumerationOrClassLiteralExpCS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		OCLExpression astNode;
		
		Token  t = null;
			astNode = null;
			Vector sequenceOfNames = null;
			String lastToken = null;
		
		
		
		{
		t = LT(1);
		match(PATHNAME);
		}
		
			StringTokenizer tokenizer = new StringTokenizer(t.getText(), "::");//$NON-NLS-1$
			sequenceOfNames = new Vector();
			while (tokenizer.hasMoreTokens()) {
				lastToken = unquote(tokenizer.nextToken());
				if (tokenizer.hasMoreTokens()) {
					sequenceOfNames.add(lastToken);
				}
			}	
				EEnumLiteral literal = null;		
				EClassifier enumType = env.lookupPathName(sequenceOfNames);
				if (enumType == null || ! (enumType instanceof EEnum)) {
					astNode = expressionsFactory.createUnspecifiedValueExp();
					
					// Check to see whether the pathname corresponds to a type
					sequenceOfNames.add(lastToken);
					EClassifier type = env.lookupPathName(sequenceOfNames);
					if (type == null) {		
		String message = NLS.bind(UnrecognizedEnum_ERROR_,
		new Object[] { sequenceOfNames });
		ERROR("enumerationOrClassLiteralExpCS", message);//$NON-NLS-1$
					} else {
						astNode.setType(type);
					}		
				} else { // is an enum
					astNode = expressionsFactory.createEnumLiteralExp();
					literal = ((EEnum) enumType).getEEnumLiteral(lastToken);
					if (literal == null) {
		String message = NLS.bind(UnrecognizedEnum_ERROR_,
		new Object[] { lastToken });
		ERROR("enumerationOrClassLiteralExpCS", message);//$NON-NLS-1$
					}
					EnumLiteralExp litExp = (EnumLiteralExp) astNode;
					litExp.setReferredEnumLiteral(literal);
					astNode = litExp;
					if (enumType == null || literal == null) {
						astNode.setType(Types.OCL_VOID);
					} else {
						astNode.setType(enumType);
					}			
				}
				TRACE("enumerationOrClassLiteralExpCS", t.getText());	//$NON-NLS-1$
			
		return astNode;
	}
	
	public final IntegerLiteralExp  integerLiteralExpCS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		IntegerLiteralExp astNode;
		
		Token  t = null;
		astNode = null;
		
		{
		t = LT(1);
		match(NUMBER_LITERAL);
		}
			
				astNode = expressionsFactory.createIntegerLiteralExp();
				astNode.setIntegerSymbol(new Integer(t.getText()));
				astNode.setType(PrimitiveTypeImpl.OCL_INTEGER);
				astNode.setName("Integer");//$NON-NLS-1$
				TRACE("integerLiteralExpCS", "Integer: " + t.getText());//$NON-NLS-2$//$NON-NLS-1$
			
		return astNode;
	}
	
	public final RealLiteralExp  realLiteralExpCS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		RealLiteralExp astNode;
		
		Token  t = null;
		astNode = null; 
		
		
		{
		t = LT(1);
		match(REAL_LITERAL);
		}
		
				astNode = expressionsFactory.createRealLiteralExp();
				astNode.setRealSymbol(new Double(t.getText()));
				astNode.setType(PrimitiveTypeImpl.OCL_REAL);
				astNode.setName("Real");//$NON-NLS-1$
				TRACE("realLiteralExpCS", "Real: " + t.getText());//$NON-NLS-2$//$NON-NLS-1$
			
		return astNode;
	}
	
	public final StringLiteralExp  stringLiteralExpCS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		StringLiteralExp astNode;
		
		Token  t = null;
		astNode = null; 
		
		
		{
		t = LT(1);
		match(STRING_LITERAL);
		}
		
				astNode = expressionsFactory.createStringLiteralExp();
				String stringLiteral = t.getText();
				if (stringLiteral.length() <= 2) {
					astNode.setStringSymbol("");//$NON-NLS-1$
				} else {
					astNode.setStringSymbol(stringLiteral.substring(1, stringLiteral.length()-1));
				}
				astNode.setType(PrimitiveTypeImpl.OCL_STRING);
				astNode.setName("String");//$NON-NLS-1$
				TRACE("stringLiteralExpCS", "String: " + t.getText());//$NON-NLS-2$//$NON-NLS-1$
			
		return astNode;
	}
	
	public final BooleanLiteralExp  booleanLiteralExpCS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		BooleanLiteralExp astNode;
		
			astNode = null; 
		
		
		{
		switch ( LA(1)) {
		case LITERAL_true:
		{
			match(LITERAL_true);
			
						astNode = expressionsFactory.createBooleanLiteralExp();
						astNode.setBooleanSymbol(Boolean.TRUE);
					
			break;
		}
		case LITERAL_false:
		{
			match(LITERAL_false);
			
						astNode = expressionsFactory.createBooleanLiteralExp(); 
						astNode.setBooleanSymbol(Boolean.FALSE);
					
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		
				astNode.setType(PrimitiveTypeImpl.OCL_BOOLEAN);
				astNode.setName("Boolean");//$NON-NLS-1$
				TRACE("boleanLiteralExpCS", "Boolean");//$NON-NLS-2$//$NON-NLS-1$
			
		return astNode;
	}
	
	public final CollectionLiteralPart  collectionLiteralPartCS(
		Environment env
	) throws RecognitionException, TokenStreamException {
		CollectionLiteralPart astNode;
		
		
			astNode = null;
			OCLExpression expr1 = null;
			OCLExpression expr2 = null;
			CollectionRange collRange = null;
			CollectionItem collItem = null;
		
		
		{
		{
		expr1=oclExpressionCS(env);
		{
		switch ( LA(1)) {
		case DOTDOT:
		{
			match(DOTDOT);
			expr2=oclExpressionCS(env);
			
								collRange = expressionsFactory.createCollectionRange();
								collRange.setFirst(expr1);
								collRange.setLast(expr2);
								collRange.setType(expr1.getType());
								// TODO:  What types are allowed in ranges.  Only Integers?
								if (expr1.getType() != expr2.getType()) {
			ERROR(
			"collectionLiteralPartCS", FirstLastTypeMismatch_ERROR_);//$NON-NLS-1$
								}
								astNode = collRange;
								TRACE("collectionLiteralPartCS", "collection range");//$NON-NLS-2$//$NON-NLS-1$
							
			break;
		}
		case COMMA:
		case RBRACE:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		}
		}
		
				if (expr2 == null) {
					collItem = expressionsFactory.createCollectionItem();
					collItem.setType(expr1.getType());
					collItem.setItem(expr1);
					astNode = collItem;
					TRACE("collectionLiteralPartCS", "collection item");//$NON-NLS-2$//$NON-NLS-1$
				}
			
		return astNode;
	}
	
	public final IteratorExp  iterContents(
		Environment env, String name, OCLExpression source
	) throws RecognitionException, TokenStreamException {
		IteratorExp astNode;
		
		
			astNode = null; 
			VariableDeclaration vdcl = null;
			VariableDeclaration vdcl1 = null;
			OCLExpression expr = null;
			EList iterators = null;
		
		
		{
		if (((LA(1)==NAME) && (_tokenSet_9.member(LA(2))))&&( LT(2).getText().equals(":") || LT(2).getText().equals(",")//$NON-NLS-2$//$NON-NLS-1$
   	 	 || LT(2).getText().equals(";") || LT(2).getText().equals("|") )) {//$NON-NLS-2$//$NON-NLS-1$
			{
			{
			vdcl=variableDeclarationCS(env, true);
				
							astNode = expressionsFactory.createIteratorExp();
							astNode.setName(name);
							iterators = astNode.getIterators();	
							if (vdcl.getType() == null) {
								EClassifier sourceType = source.getType();
								if (sourceType instanceof CollectionType) {
									vdcl.setType(((CollectionType) sourceType).getElementType());
								}
							}
							iterators.add(vdcl);
						
			{
			switch ( LA(1)) {
			case COMMA:
			{
				match(COMMA);
				vdcl1=variableDeclarationCS(env, true);
				
					  				if (vdcl1.getType() == null) {
										EClassifier sourceType = source.getType();
										if (sourceType instanceof CollectionType) {
											vdcl1.setType(((CollectionType) sourceType).getElementType());
										}
					  				}
					  				iterators.add(vdcl1);
					  			
				break;
			}
			case BAR:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(BAR);
			}
			expr=oclExpressionCS(env);
			}
		}
		else if ((_tokenSet_0.member(LA(1))) && (_tokenSet_10.member(LA(2)))) {
			
						astNode = expressionsFactory.createIteratorExp();
						astNode.setName(name);
						iterators = astNode.getIterators();	
						// Synthesize the iterator expression.
						vdcl = genVariableDeclaration("iteratorExpCS", env, null, //$NON-NLS-1$
							((CollectionType) source.getType()).getElementType(), null, false, true, false);
						iterators.add(vdcl);
					
			{
			expr=oclExpressionCS(env);
			}
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		
				TRACE("oclIteratorExpCS: ", name);//$NON-NLS-1$
				
				if (name.equals("forAll") || name.equals("exists") || name.equals("one") || name.equals("isUnique")) {//$NON-NLS-4$//$NON-NLS-3$//$NON-NLS-2$//$NON-NLS-1$
					astNode.setType(PrimitiveTypeImpl.OCL_BOOLEAN);
				} else if (name.equals("select") || name.equals("reject") ) {//$NON-NLS-2$//$NON-NLS-1$
					astNode.setType(source.getType());
				} else if (name.equals("collect")) {//$NON-NLS-1$
					// The result type for collect must be flattened
					EClassifier elementType = expr.getType();
					while (elementType instanceof CollectionType) {
						elementType = ((CollectionType) elementType).getElementType();
					}
					if (source.getType() instanceof SequenceType || 
									source.getType() instanceof OrderedSetType) {
						astNode.setType(typesFactory.createSequenceType(elementType));
					} else {
						astNode.setType(typesFactory.createBagType(elementType));
					}
				} else if (name.equals("collectNested")) {//$NON-NLS-1$
					if (source.getType() instanceof SequenceType || 
									source.getType() instanceof OrderedSetType) {
						astNode.setType(typesFactory.createSequenceType(expr.getType()));
					} else {
						astNode.setType(typesFactory.createBagType(expr.getType()));
					}
				} else if (name.equals("any")) {//$NON-NLS-1$
					astNode.setType(((CollectionType) source.getType()).getElementType());
				} else if (name.equals("sortedBy")) {//$NON-NLS-1$
					if ((source.getType() instanceof SequenceType) ||
							source.getType() instanceof BagType) {
						SequenceType osType = typesFactory.createSequenceType();
						osType.setElementType(((CollectionType) source.getType()).getElementType());
						astNode.setType(osType);
					} else { // set, ordered set
						OrderedSetType osType = typesFactory.createOrderedSetType();
						osType.setElementType(((CollectionType) source.getType()).getElementType());
						astNode.setType(osType);
					}
				} 
						
				astNode.setBody(expr);
				astNode.setSource(source);
				
				env.deleteElement(vdcl.getVarName());
				if (vdcl1 != null) {
					env.deleteElement(vdcl1.getVarName());
				}		
			
		return astNode;
	}
	
	public final BasicEList  operationArgs(
		Environment env, String operName
	) throws RecognitionException, TokenStreamException {
		BasicEList arguments;
		
			arguments = null;
			EClassifier typeArg;
		
		
		{
		if (((LA(1)==LPAREN) && (_tokenSet_11.member(LA(2))))&&( operName.equals("oclAsType") || operName.equals("oclIsTypeOf") ||//$NON-NLS-2$//$NON-NLS-1$
				operName.equals("oclIsKindOf") )) {//$NON-NLS-1$
			{
			match(LPAREN);
			typeArg=typeCS(env);
			match(RPAREN);
			}
			
							if (typeArg == null) {
			ERROR("operationArgs", UnrecognizedType_ERROR_);//$NON-NLS-1$
							}
							arguments = new BasicEList();
							UnspecifiedValueExp arg = expressionsFactory.createUnspecifiedValueExp();
							arg.setType(typeArg);
							arguments.add(arg);
							
							OCLToken typeToken = OCLTokenAdapter.getToken(typeArg);
							arg.setStartPosition(typeToken.getStartPosition());
							arg.setEndPosition(typeToken.getEndPosition());
						
		}
		else if ((LA(1)==LPAREN) && (_tokenSet_12.member(LA(2)))) {
			{
			match(LPAREN);
			{
			switch ( LA(1)) {
			case PATHNAME:
			case NAME:
			case LPAREN:
			case LITERAL_if:
			case MINUS:
			case LITERAL_not:
			case LITERAL_let:
			case LITERAL_Integer:
			case LITERAL_String:
			case LITERAL_Real:
			case LITERAL_Boolean:
			case LITERAL_OclAny:
			case LITERAL_OclVoid:
			case LITERAL_Set:
			case LITERAL_Bag:
			case LITERAL_Sequence:
			case LITERAL_Collection:
			case LITERAL_OrderedSet:
			case LITERAL_Tuple:
			case NUMBER_LITERAL:
			case REAL_LITERAL:
			case LITERAL_true:
			case LITERAL_false:
			case STRING_LITERAL:
			case LITERAL_oclAsType:
			case LITERAL_oclIsKindOf:
			case LITERAL_oclIsTypeOf:
			case LITERAL_closure:
			case LITERAL_closureAll:
			case OPERATION_EXPR:
			{
				arguments=argumentsCS(env);
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RPAREN);
			}
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		return arguments;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",//$NON-NLS-1$
		"EOF",//$NON-NLS-1$
		"<2>",//$NON-NLS-1$
		"NULL_TREE_LOOKAHEAD",//$NON-NLS-1$
		"\"package\"",//$NON-NLS-1$
		"\"endpackage\"",//$NON-NLS-1$
		"PATHNAME",//$NON-NLS-1$
		"NAME",//$NON-NLS-1$
		"NUMERICPATHNAME",//$NON-NLS-1$
		"\"context\"",//$NON-NLS-1$
		"COLON",//$NON-NLS-1$
		"LPAREN",//$NON-NLS-1$
		"RPAREN",//$NON-NLS-1$
		"COMMA",//$NON-NLS-1$
		"\"pre\"",//$NON-NLS-1$
		"\"post\"",//$NON-NLS-1$
		"\"body\"",//$NON-NLS-1$
		"\"inv\"",//$NON-NLS-1$
		"\"implies\"",//$NON-NLS-1$
		"\"and\"",//$NON-NLS-1$
		"\"or\"",//$NON-NLS-1$
		"\"xor\"",//$NON-NLS-1$
		"EQUALS",//$NON-NLS-1$
		"NEQUALS",//$NON-NLS-1$
		"GT",//$NON-NLS-1$
		"GE",//$NON-NLS-1$
		"LT",//$NON-NLS-1$
		"LE",//$NON-NLS-1$
		"\"if\"",//$NON-NLS-1$
		"\"then\"",//$NON-NLS-1$
		"\"else\"",//$NON-NLS-1$
		"\"endif\"",//$NON-NLS-1$
		"PLUS",//$NON-NLS-1$
		"MINUS",//$NON-NLS-1$
		"MULTIPLY",//$NON-NLS-1$
		"DIVIDE",//$NON-NLS-1$
		"\"not\"",//$NON-NLS-1$
		"DOT",//$NON-NLS-1$
		"ARROW",//$NON-NLS-1$
		"PRE",//$NON-NLS-1$
		"LBRACKET",//$NON-NLS-1$
		"RBRACKET",//$NON-NLS-1$
		"\"let\"",//$NON-NLS-1$
		"\"Integer\"",//$NON-NLS-1$
		"\"String\"",//$NON-NLS-1$
		"\"Real\"",//$NON-NLS-1$
		"\"Boolean\"",//$NON-NLS-1$
		"\"OclAny\"",//$NON-NLS-1$
		"\"OclVoid\"",//$NON-NLS-1$
		"\"Set\"",//$NON-NLS-1$
		"\"Bag\"",//$NON-NLS-1$
		"\"Sequence\"",//$NON-NLS-1$
		"\"Collection\"",//$NON-NLS-1$
		"\"OrderedSet\"",//$NON-NLS-1$
		"\"Tuple\"",//$NON-NLS-1$
		"\"in\"",//$NON-NLS-1$
		"NUMBER_LITERAL",//$NON-NLS-1$
		"REAL_LITERAL",//$NON-NLS-1$
		"\"true\"",//$NON-NLS-1$
		"\"false\"",//$NON-NLS-1$
		"STRING_LITERAL",//$NON-NLS-1$
		"LBRACE",//$NON-NLS-1$
		"RBRACE",//$NON-NLS-1$
		"DOTDOT",//$NON-NLS-1$
		"\"forAll\"",//$NON-NLS-1$
		"\"exists\"",//$NON-NLS-1$
		"\"isUnique\"",//$NON-NLS-1$
		"\"any\"",//$NON-NLS-1$
		"\"one\"",//$NON-NLS-1$
		"\"collect\"",//$NON-NLS-1$
		"\"select\"",//$NON-NLS-1$
		"\"reject\"",//$NON-NLS-1$
		"\"collectNested\"",//$NON-NLS-1$
		"\"sortedBy\"",//$NON-NLS-1$
		"BAR",//$NON-NLS-1$
		"\"iterate\"",//$NON-NLS-1$
		"SEMICOLON",//$NON-NLS-1$
		"\"oclAsType\"",//$NON-NLS-1$
		"\"oclIsKindOf\"",//$NON-NLS-1$
		"\"oclIsTypeOf\"",//$NON-NLS-1$
		"\"closure\"",//$NON-NLS-1$
		"\"closureAll\"",//$NON-NLS-1$
		"OPERATION_EXPR",//$NON-NLS-1$
		"WS",//$NON-NLS-1$
		"SL_COMMENT",//$NON-NLS-1$
		"DOUBLECOLON",//$NON-NLS-1$
		"EXPONENT",//$NON-NLS-1$
		"NUMERIC_URL",//$NON-NLS-1$
		"NUMBER_OR_REAL_OR_RANGE_OR_OPERATION",//$NON-NLS-1$
		"DIGIT",//$NON-NLS-1$
		"ESC",//$NON-NLS-1$
		"HEX_DIGIT",//$NON-NLS-1$
		"NONQUOTED_NAME",//$NON-NLS-1$
		"QUOTED_NAME",//$NON-NLS-1$
		"NAMEORDOTTEDNAME",//$NON-NLS-1$
		"NAME_OR_PATHNAME"//$NON-NLS-1$
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2269809891726067904L, 516096L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 2269809891457632448L, 516096L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 128L, 516096L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 554153860399232L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { -4575652892349828574L, 5120L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 554153860399232L, 519167L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 554153860399232L, 516096L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 3848290699264L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 4575657217650075840L, 516096L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 4203520L, 1024L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 4575655018626816192L, 516096L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 36020000925944256L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 2269809891726072000L, 516096L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	
	}
