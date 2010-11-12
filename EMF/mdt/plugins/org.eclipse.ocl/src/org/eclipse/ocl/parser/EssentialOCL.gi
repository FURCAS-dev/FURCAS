--/**
-- * <copyright>
-- *
-- * Copyright (c) 2005, 2009 IBM Corporation and others.
-- * All rights reserved.   This program and the accompanying materials
-- * are made available under the terms of the Eclipse Public License v1.0
-- * which accompanies this distribution, and is available at
-- * http://www.eclipse.org/legal/epl-v10.html
-- *
-- * Contributors:
-- *   See (or edit) Notice Declaration below
-- *
-- * </copyright>
-- *
-- * $Id: EssentialOCL.gi,v 1.8 2010/02/09 21:04:08 ewillink Exp $
-- */
--
-- The EssentialOCL Parser
--


%Define
    -- Redefinition of macros used in the parser template
    --
    $default_repair_count /.getDefaultRepairCount()./
	$super_parser_class /.AbstractOCLParser./
    $prs_stream_class /.DerivedPrsStream./

	-- Definition of new macros used by the grammar file
	-- which may be redefined by extended files.
    $copyright_contributions /.*./

	-- Definition of new macros used by the grammar file
	-- which are not intended to be extended.
	$lpg_ns /.lpg.runtime./ -- package namespace of the LPG Runtime API
	

	-- Some useful macros	
    $NewCase
    /. $Header
                case $rule_number:./


	
    $EmptyListAction -- Deprecated, code inline with correct generic parameter type
    /. $Header
                case $rule_number:
                    setResult(new BasicEList<Object>());
                    break;./
                    
    -- BeginJava and EndJava need to be reworked in order to be able to properly use $NewCase macro
    
    -- BeginJava does nothing
	-- block-actions should call BeginCode, instead
    $BeginJava /../
    
  	-- EndJava does nothing
	-- block-actions should call EndCode, instead
	$EndJava /../
	
	$BeginCode
	/.$BeginAction
					$symbol_declarations./

	$EndCode /.$EndAction./

%End

%Notice
    /./**
 * Essential OCL Grammar
 * <copyright>
 *
 * Copyright (c) 2005, 2010 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Elimination of some shift-reduce conflicts
 *   E.D.Willink - Remove unnecessary warning suppression
 *   E.D.Willink - Bugs 184048, 225493, 243976, 259818, 282882, 287993, 288040, 292112, 295166
 *   Borland - Bug 242880
 *   Adolfo Sanchez-Barbudo Herrera (Open Canarias):
 *        - 242153: LPG v 2.0.17 adoption.
 *        - 299396: Introducing new LPG templates
 *        - 300534: Removing the use of deprecated macros.
 * </copyright>
 *
 * $Id: EssentialOCL.gi,v 1.8 2010/02/09 21:04:08 ewillink Exp $
 */
    ./
%End

%Globals
    /.import org.eclipse.emf.common.util.BasicEList;
	import org.eclipse.emf.common.util.EList;
	import org.eclipse.ocl.cst.BooleanLiteralExpCS;
	import org.eclipse.ocl.cst.CSTNode;
	import org.eclipse.ocl.cst.CallExpCS;
	import org.eclipse.ocl.cst.CollectionLiteralExpCS;
	import org.eclipse.ocl.cst.CollectionLiteralPartCS;
	import org.eclipse.ocl.cst.CollectionTypeCS;
	import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
	import org.eclipse.ocl.cst.FeatureCallExpCS;
	import org.eclipse.ocl.cst.IfExpCS;
	import org.eclipse.ocl.cst.IntegerLiteralExpCS;
	import org.eclipse.ocl.cst.InvalidLiteralExpCS;
	import org.eclipse.ocl.cst.IsMarkedPreCS;
	import org.eclipse.ocl.cst.IterateExpCS;
	import org.eclipse.ocl.cst.IteratorExpCS;
	import org.eclipse.ocl.cst.LetExpCS;
	import org.eclipse.ocl.cst.NullLiteralExpCS;
	import org.eclipse.ocl.cst.OCLExpressionCS;
	import org.eclipse.ocl.cst.OperationCallExpCS;
	import org.eclipse.ocl.cst.PathNameCS;
	import org.eclipse.ocl.cst.PrimitiveTypeCS;
	import org.eclipse.ocl.cst.RealLiteralExpCS;
	import org.eclipse.ocl.cst.SimpleNameCS;
	import org.eclipse.ocl.cst.SimpleTypeEnum;
	import org.eclipse.ocl.cst.StringLiteralExpCS;
	import org.eclipse.ocl.cst.TupleLiteralExpCS;
	import org.eclipse.ocl.cst.TupleTypeCS;
	import org.eclipse.ocl.cst.TypeCS;
	import org.eclipse.ocl.cst.UnlimitedNaturalLiteralExpCS;
	import org.eclipse.ocl.cst.VariableCS;
	import org.eclipse.ocl.cst.VariableExpCS;	
	import org.eclipse.ocl.lpg.DerivedPrsStream;
	
	import $lpg_ns.BadParseException;
	import $lpg_ns.BadParseSymFileException;
	import $lpg_ns.DiagnoseParser;
	import $lpg_ns.ErrorToken;
	import $lpg_ns.IToken;
	import $lpg_ns.ILexStream;
	import $lpg_ns.Monitor;
	import $lpg_ns.NullExportedSymbolsException;
	import $lpg_ns.NullTerminalSymbolsException;
	import $lpg_ns.ParseTable;
	import $lpg_ns.RuleAction;
	import $lpg_ns.UndefinedEofSymbolException;
	import $lpg_ns.UnimplementedTerminalsException;	
    ./
%End

%KeyWords
-- Reserved keywords
    and implies not or xor  
    if then else endif  
    let in  
    false true
    null invalid
    self    

-- Restricted keywords
    Bag Collection OrderedSet Sequence Set  
    Tuple
    Boolean Integer Real String UnlimitedNatural
    OclAny OclInvalid OclVoid
%End

-- Terminals
%Identifier
    IDENTIFIER
%End

%Terminals
    
    QUOTED_IDENTIFIER INTEGER_LITERAL REAL_LITERAL STRING_LITERAL
    
    PLUS     ::= '+'
    MINUS    ::= '-'
    MULTIPLY ::= '*'
    DIVIDE   ::= '/'

    GREATER       ::= '>'
    LESS          ::= '<'
    EQUAL         ::= '='
    GREATER_EQUAL ::= '>='
    LESS_EQUAL    ::= '<='
    NOT_EQUAL     ::= '<>'

    LPAREN   ::= '('
    RPAREN   ::= ')'
    LBRACE   ::= '{'
    RBRACE   ::= '}'
    LBRACKET ::= '['
    RBRACKET ::= ']'

    ARROW      ::= '->'
    BAR        ::= '|'
    COMMA      ::= ','
    COLON      ::= ':'
    COLONCOLON ::= '::'
    SEMICOLON  ::= ';'
    DOT        ::= '.'
    DOTDOT     ::= '..'
%End

%Headers
	/.
	
	public $environment_class getOCLEnvironment() {
		return getLexer().getOCLEnvironment();
	}
		
	@Override
	public $super_lexer_class getLexer() {
		return ($super_lexer_class) super.getLexer();
	}
	
	
	
	// Some methods for backwards compatibility 
	/**
	* <p>
	* Before 3.0, this method was used with the now-deprecated  "dollar"getToken macro (which
	* provided token index in the prsStream) to obtain an IToken f a rule given the index of the
	* right hand side token in the said rule. In 3.0 a convenience method has been introduced
	* in order to directly return the IToken, given the index of the right hand side token in the rule.
	* </p> 
	*
	* <p>
	* In an action-block of a rule, instead of doing <code>getIToken("dollar"getToken(i))</code> 
	* you should do <code>getRhsTokenText(i)</code>
	* </p>
	* @param i the right hand side token index
	* @return the correspondent IToken.
	*
	* @since 3.0	
	*/
	@Deprecated
	protected IToken getIToken(int i) {
		return prsStream.getIToken(i);
	}
	
	/**
	* <p>
	* Before 3.0, this method was used with the now-deprecated "dollar"getToken macro (which
	* provided token index in the prsStream) to obtain an IToken f a rule given the index of the
	* right hand side token in the said rule. In 3.0 a convenience method has been introduced
	* in order to directly return the IToken, given the index of the right hand side token in the rule.
	* </p> 
	* 
	* <p>
	* In an action-block of a rule, instead of doing <code>getTokenText("dollar"getToken(i))</code> 
	* you should do <code>getRhsTokenText(i)</code>
	* </p>
	* @param i the right hand side token index
	* @result the text of the correspondent right hand side IToken.
	*/
	@Deprecated
	protected String getTokenText(int i) {
		return prsStream.getTokenText(i);
	}
	
	/**
	* A convenience method to obtain the text of a right hand side IToken.
	*  
	* @param i the right hand side token index
	* @result the text of the correspondent right hand side IToken.
	*
	* @since 3.0
	*/
	protected String getRhsTokenText(int i) { 
		return prsStream.getTokenText(getRhsTokenIndex(i));
	}
	./
%End

%Rules

-----------------------------------------------------------------------
--  Names
-----------------------------------------------------------------------
--  Temporary backward compatibility support for 7.4.8 conceptual usage 
    conceptualOperationName -> and
    conceptualOperationName -> implies
    conceptualOperationName -> not
    conceptualOperationName -> or
    conceptualOperationName -> xor
    conceptualOperationName -> '<'
    conceptualOperationName -> '<='
    conceptualOperationName -> '>='
    conceptualOperationName -> '>'
    conceptualOperationName -> '='
    conceptualOperationName -> '<>'
    conceptualOperationName -> '+'
    conceptualOperationName -> '-'
    conceptualOperationName -> '*'
    conceptualOperationName -> '/'
    conceptualOperationNameCS ::= conceptualOperationName
        /.$BeginCode
                    IToken iToken = getRhsIToken(1);
                    SimpleNameCS result = createConceptualOperationNameCS(iToken);
                    setOffsets(result, iToken);
                    setResult(result);
          $EndCode
        ./
    
    reservedKeyword -> and
    reservedKeyword -> else
    reservedKeyword -> endif
    reservedKeyword -> if
    reservedKeyword -> implies
    reservedKeyword -> in
    reservedKeyword -> let
    reservedKeyword -> not
    reservedKeyword -> or
    reservedKeyword -> then
    reservedKeyword -> xor

    tupleKeywordCS ::= Tuple
        /.$NewCase./
    reservedKeywordCS ::= reservedKeyword
        /.$BeginCode
                    IToken iToken = getRhsIToken(1);
                    SimpleNameCS result = createSimpleNameCS(
                                SimpleTypeEnum.KEYWORD_LITERAL,
                                iToken
                            );
                    setOffsets(result, iToken);
                    setResult(result);
          $EndCode
        ./
    restrictedKeywordCS -> CollectionTypeIdentifierCS
--  restrictedKeywordCS -> BooleanLiteralExpCS
--  restrictedKeywordCS -> InvalidLiteralExpCS
--  restrictedKeywordCS -> NullLiteralExpCS
--  restrictedKeywordCS -> selfKeywordCS
    restrictedKeywordCS -> primitiveTypeCS
    restrictedKeywordCS -> tupleKeywordCS
        
    selfKeywordCS ::= self
        /.$BeginCode
                    IToken iToken = getRhsIToken(1);
                    SimpleNameCS result = createSimpleNameCS(
                            SimpleTypeEnum.SELF_LITERAL,
                            iToken
                        );
                    setOffsets(result, iToken);
                    setResult(result);
          $EndCode
        ./
        
    simpleNameCS ::= IDENTIFIER
        /.$BeginCode
                    IToken iToken = getRhsIToken(1);
                    SimpleNameCS result = createSimpleNameCS(
                            SimpleTypeEnum.IDENTIFIER_LITERAL,
                            iToken
                        );
                    setOffsets(result, iToken);
                    setResult(result);
          $EndCode
        ./
    simpleNameCS -> QuotedSimpleNameCS
    QuotedSimpleNameCS ::= QUOTED_IDENTIFIER
        /.$BeginCode
                    IToken iToken = getRhsIToken(1);
                    SimpleNameCS result = createQuotedSimpleNameCS(
                            SimpleTypeEnum.IDENTIFIER_LITERAL,
                            iToken
                        );
                    setOffsets(result, iToken);
                    setResult(result);
          $EndCode
        ./
    QuotedSimpleNameCS ::= QuotedSimpleNameCS STRING_LITERAL
        /.$BeginCode
                    SimpleNameCS string = (SimpleNameCS)getRhsSym(1);
                    IToken literalToken = getRhsIToken(2);
                    SimpleNameCS result = extendQuotedSimpleNameCS(string, literalToken);
                    setOffsets(result, string, literalToken);
                    setResult(result);
          $EndCode
        ./

    unreservedSimpleNameCS -> simpleNameCS
    unreservedSimpleNameCS -> restrictedKeywordCS

    pathNameCS ::= simpleNameCS
        /.$BeginCode
                    SimpleNameCS simpleName = (SimpleNameCS)getRhsSym(1);
                    PathNameCS result = createPathNameCS(simpleName);
                    setOffsets(result, simpleName);
                    setResult(result);
          $EndCode
        ./
    pathNameCS ::= pathNameCS '::' unreservedSimpleNameCS
        /.$BeginCode
                    PathNameCS result = (PathNameCS)getRhsSym(1);
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                    result = extendPathNameCS(result, simpleNameCS);
                    setOffsets(result, result, simpleNameCS);
                    setResult(result);
          $EndCode
        ./
        
-----------------------------------------------------------------------
--  Types
-----------------------------------------------------------------------
    primitiveTypeCS ::= Boolean
        /.$BeginCode
                    PrimitiveTypeCS result = createPrimitiveTypeCS(
                            SimpleTypeEnum.BOOLEAN_LITERAL,
                            getRhsTokenText(1)
                        );
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./
    primitiveTypeCS ::= Integer
        /.$BeginCode
                    PrimitiveTypeCS result = createPrimitiveTypeCS(
                            SimpleTypeEnum.INTEGER_LITERAL,
                            getRhsTokenText(1)
                        );
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./
    primitiveTypeCS ::= Real
        /.$BeginCode
                    PrimitiveTypeCS result = createPrimitiveTypeCS(
                            SimpleTypeEnum.REAL_LITERAL,
                            getRhsTokenText(1)
                        );
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./
    primitiveTypeCS ::= String
        /.$BeginCode
                    PrimitiveTypeCS result = createPrimitiveTypeCS(
                            SimpleTypeEnum.STRING_LITERAL,
                            getRhsTokenText(1)
                        );
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./
    primitiveTypeCS ::= UnlimitedNatural
        /.$BeginCode
                    PrimitiveTypeCS result = createPrimitiveTypeCS(
                            SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
                            getRhsTokenText(1)
                        );
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./

    primitiveTypeCS ::= OclAny
        /.$BeginCode
                    PrimitiveTypeCS result = createPrimitiveTypeCS(
                            SimpleTypeEnum.OCL_ANY_LITERAL,
                            getRhsTokenText(1)
                        );
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./
    primitiveTypeCS ::= OclInvalid
        /.$BeginCode
                    PrimitiveTypeCS result = createPrimitiveTypeCS(
                            SimpleTypeEnum.OCL_INVALID_LITERAL,
                            getRhsTokenText(1)
                        );
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./
    primitiveTypeCS ::= OclVoid
        /.$BeginCode
                    PrimitiveTypeCS result = createPrimitiveTypeCS(
                            SimpleTypeEnum.OCL_VOID_LITERAL,
                            getRhsTokenText(1)
                        );
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./
        
    CollectionTypeIdentifierCS ::= Set
        /.$BeginCode
                    SimpleNameCS result = createCollectionTypeCS(
                                CollectionTypeIdentifierEnum.SET_LITERAL,
                                getRhsTokenText(1)
                            );
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./
    CollectionTypeIdentifierCS ::= Bag
        /.$BeginCode
                    SimpleNameCS result = createCollectionTypeCS(
                                CollectionTypeIdentifierEnum.BAG_LITERAL,
                                getRhsTokenText(1)
                            );
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./
    CollectionTypeIdentifierCS ::= Sequence
        /.$BeginCode
                    SimpleNameCS result = createCollectionTypeCS(
                                CollectionTypeIdentifierEnum.SEQUENCE_LITERAL,
                                getRhsTokenText(1)
                            );
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./
    CollectionTypeIdentifierCS ::= Collection
        /.$BeginCode
                    SimpleNameCS result = createCollectionTypeCS(
                                CollectionTypeIdentifierEnum.COLLECTION_LITERAL,
                                getRhsTokenText(1)
                            );
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./
    CollectionTypeIdentifierCS ::= OrderedSet
        /.$BeginCode
                    SimpleNameCS result = createCollectionTypeCS(
                                CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL,
                                getRhsTokenText(1)
                            );
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./

    typeCS -> primitiveTypeCS
    typeCS -> pathNameCS
    typeCS -> collectionTypeCS
    typeCS -> tupleTypeCS

    collectionTypeCS ::= CollectionTypeIdentifierCS '(' typeCS ')'
        /.$BeginCode
                    CollectionTypeCS result = (CollectionTypeCS)getRhsSym(1);
                    result.setTypeCS((TypeCS)getRhsSym(3));
                    setOffsets(result, result, getRhsIToken(4));
                    setResult(result);
          $EndCode
        ./

    tupleTypeCS ::= Tuple '(' tupleTypePartsCSopt ')'
        /.$BeginCode
                     TupleTypeCS result = createTupleTypeCS((EList<VariableCS>)getRhsSym(3));
                    setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                    setResult(result);
          $EndCode
        ./

    tupleTypePartsCSopt ::= %empty
        /.$BeginCode
                    setResult(new BasicEList<VariableCS>());
          $EndCode
        ./
    tupleTypePartsCSopt -> tupleTypePartsCS

    tupleTypePartsCS ::= typedUninitializedVariableCS
        /.$BeginCode
                    EList<VariableCS> result = new BasicEList<VariableCS>();
                    result.add((VariableCS)getRhsSym(1));
                    setResult(result);
          $EndCode
        ./
    tupleTypePartsCS ::= tupleTypePartsCS ',' typedUninitializedVariableCS
        /.$BeginCode
                    EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                    result.add((VariableCS)getRhsSym(3));
                    setResult(result);
          $EndCode
        ./

-----------------------------------------------------------------------
--  Declarations
-----------------------------------------------------------------------     
    untypedUninitializedVariableCS ::= simpleNameCS
        /.$BeginCode
                    SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                    VariableCS result = createVariableCS(name, null, null);
                    setOffsets(result, name);
                    setResult(result);
          $EndCode
        ./

    typedUninitializedVariableCS ::= simpleNameCS ':' typeCS
        /.$BeginCode
                    SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                    TypeCS type = (TypeCS)getRhsSym(3);
                    VariableCS result = createVariableCS(name, type, null);
                    setOffsets(result, name, type);
                    setResult(result);
          $EndCode
        ./
        
    untypedInitializedVariableCS ::= simpleNameCS '=' OclExpressionCS
        /.$BeginCode
                    SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                    OCLExpressionCS initExpression = (OCLExpressionCS)getRhsSym(3);
                    VariableCS result = createVariableCS(name, null, initExpression);
                    setOffsets(result, name, initExpression);
                    setResult(result);
          $EndCode
        ./
        
    typedInitializedVariableCS ::= simpleNameCS ':' typeCS '=' OclExpressionCS
        /.$BeginCode
                    SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                    TypeCS type = (TypeCS)getRhsSym(3);
                    OCLExpressionCS initExpression = (OCLExpressionCS)getRhsSym(5);
                    VariableCS result = createVariableCS(name, type, initExpression);
                    setOffsets(result, name, initExpression);
                    setResult(result);
          $EndCode
        ./

    initializedVariableCS -> untypedInitializedVariableCS
    initializedVariableCS -> typedInitializedVariableCS

    uninitializedVariableCS -> untypedUninitializedVariableCS
    uninitializedVariableCS -> typedUninitializedVariableCS

    VariableDeclarationCS -> untypedUninitializedVariableCS
    VariableDeclarationCS -> untypedInitializedVariableCS
    VariableDeclarationCS -> typedUninitializedVariableCS
    VariableDeclarationCS -> typedInitializedVariableCS

-----------------------------------------------------------------------
--  Literals
-----------------------------------------------------------------------
-- EnumLiteralExpCS is parsed as a PropertyCallExpCS[C]
--  LiteralExpCS -> EnumLiteralExpCS
    LiteralExpCS -> CollectionLiteralExpCS
    LiteralExpCS -> TupleLiteralExpCS
    LiteralExpCS -> PrimitiveLiteralExpCS
    LiteralExpCS -> TypeLiteralExpCS

    CollectionLiteralExpCS ::= CollectionTypeIdentifierCS
       '{' CollectionLiteralPartsCSopt '}'
        /.$BeginCode
                    CollectionTypeCS typeCS = (CollectionTypeCS)getRhsSym(1);
                    CollectionLiteralExpCS result = createCollectionLiteralExpCS(
                            typeCS,
                            (EList<CollectionLiteralPartCS>)getRhsSym(3)
                        );
                    setOffsets(result, typeCS, getRhsIToken(4));
                    setResult(result);
          $EndCode
        ./
    CollectionLiteralExpCS ::= collectionTypeCS '{' CollectionLiteralPartsCSopt '}'
        /.$BeginCode
                    CollectionTypeCS typeCS = (CollectionTypeCS)getRhsSym(1);
                    CollectionLiteralExpCS result = createCollectionLiteralExpCS(
                            typeCS,
                            (EList<CollectionLiteralPartCS>)getRhsSym(3)
                        );
                    setOffsets(result, typeCS, getRhsIToken(4));
                    setResult(result);
          $EndCode
        ./

    CollectionLiteralPartsCSopt ::= %empty
        /.$BeginCode
                    setResult(new BasicEList<CollectionLiteralPartCS>());
          $EndCode
        ./
    CollectionLiteralPartsCSopt -> CollectionLiteralPartsCS

    CollectionLiteralPartsCS ::= CollectionLiteralPartCS
        /.$BeginCode
                    EList<CollectionLiteralPartCS> result = new BasicEList<CollectionLiteralPartCS>();
                    result.add((CollectionLiteralPartCS)getRhsSym(1));
                    setResult(result);
          $EndCode
        ./
    CollectionLiteralPartsCS ::= CollectionLiteralPartsCS ',' CollectionLiteralPartCS
        /.$BeginCode
                    EList<CollectionLiteralPartCS> result = (EList<CollectionLiteralPartCS>)getRhsSym(1);
                    result.add((CollectionLiteralPartCS)getRhsSym(3));
                    setResult(result);
          $EndCode
        ./

    CollectionLiteralPartCS -> CollectionRangeCS
    CollectionLiteralPartCS ::= OclExpressionCS
        /.$BeginCode
                    CollectionLiteralPartCS result = createCollectionLiteralPartCS(
                            (OCLExpressionCS)getRhsSym(1)
                        );
                    setOffsets(result, (CSTNode)getRhsSym(1));
                    setResult(result);
          $EndCode
        ./

    CollectionRangeCS ::= OclExpressionCS '..' OclExpressionCS
        /.$BeginCode
                    CollectionLiteralPartCS result = createCollectionRangeCS(
                            (OCLExpressionCS)getRhsSym(1),
                            (OCLExpressionCS)getRhsSym(3)
                        );
                    setOffsets(result, (CSTNode)getRhsSym(1), (CSTNode)getRhsSym(3));
                    setResult(result);
          $EndCode
        ./

    PrimitiveLiteralExpCS -> IntegerLiteralExpCS
    PrimitiveLiteralExpCS -> RealLiteralExpCS
    PrimitiveLiteralExpCS -> StringLiteralExpCS
    PrimitiveLiteralExpCS -> BooleanLiteralExpCS
    PrimitiveLiteralExpCS -> UnlimitedNaturalLiteralExpCS
    PrimitiveLiteralExpCS -> InvalidLiteralExpCS
    PrimitiveLiteralExpCS -> NullLiteralExpCS

    TupleLiteralExpCS ::= Tuple '{' TupleLiteralPartsCS '}'
        /.$BeginCode
                    TupleLiteralExpCS result = createTupleLiteralExpCS((EList<VariableCS>)getRhsSym(3));
                    setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                    setResult(result);
          $EndCode
        ./

    TupleLiteralPartsCS ::= initializedVariableCS
        /.$BeginCode
                    EList<VariableCS> result = new BasicEList<VariableCS>();
                    result.add((VariableCS)getRhsSym(1));
                    setResult(result);
          $EndCode
        ./
    TupleLiteralPartsCS ::= TupleLiteralPartsCS ',' initializedVariableCS
        /.$BeginCode
                    EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                    result.add((VariableCS)getRhsSym(3));
                    setResult(result);
          $EndCode
        ./

    IntegerLiteralExpCS ::= INTEGER_LITERAL
        /.$BeginCode
                    IntegerLiteralExpCS result = createIntegerLiteralExpCS(getRhsTokenText(1));
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./

    RealLiteralExpCS ::= REAL_LITERAL
        /.$BeginCode
                    RealLiteralExpCS result = createRealLiteralExpCS(getRhsTokenText(1));
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./

    StringLiteralExpCS ::= STRING_LITERAL
        /.$BeginCode
                    IToken literalToken = getRhsIToken(1);
                    StringLiteralExpCS result = createStringLiteralExpCS(literalToken);
                    setOffsets(result, literalToken);
                    setResult(result);
          $EndCode
        ./
    StringLiteralExpCS ::= StringLiteralExpCS STRING_LITERAL
        /.$BeginCode
                    StringLiteralExpCS string = (StringLiteralExpCS)getRhsSym(1);
                    IToken literalToken = getRhsIToken(2);
                    StringLiteralExpCS result = extendStringLiteralExpCS(string, literalToken);
                    setOffsets(result, string, literalToken);
                    setResult(result);
          $EndCode
        ./

    BooleanLiteralExpCS ::= true
        /.$BeginCode
                    BooleanLiteralExpCS result = createBooleanLiteralExpCS(getRhsTokenText(1));
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./
    BooleanLiteralExpCS ::= false
        /.$BeginCode
                    BooleanLiteralExpCS result = createBooleanLiteralExpCS(getRhsTokenText(1));
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./

    UnlimitedNaturalLiteralExpCS ::= '*'
        /.$BeginCode
                    UnlimitedNaturalLiteralExpCS result = createUnlimitedNaturalLiteralExpCS(getRhsTokenText(1));
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./

    InvalidLiteralExpCS ::= invalid
        /.$BeginCode
                    InvalidLiteralExpCS result = createInvalidLiteralExpCS(getRhsTokenText(1));
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./

    NullLiteralExpCS ::= null
        /.$BeginCode
                    NullLiteralExpCS result = createNullLiteralExpCS(getRhsTokenText(1));
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
          $EndCode
        ./
        
    -- unqualified pathNameCS is parsed as SimpleNameExpCS
    -- qualified pathNameCS is parsed as PropertyCallExpCS[C]
    TypeLiteralExpCS ::= primitiveTypeCS
        /.$NewCase./
    TypeLiteralExpCS ::= collectionTypeCS
        /.$NewCase./
    TypeLiteralExpCS ::= tupleTypeCS
        /.$BeginCode
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                    VariableExpCS result = createVariableExpCS(
                            simpleNameCS,
                            new BasicEList<OCLExpressionCS>(),
                            null
                        );
                    setOffsets(result, simpleNameCS);
                    setResult(result);
          $EndCode
        ./

-----------------------------------------------------------------------
--  Calls
-----------------------------------------------------------------------         
    CallExpCS -> FeatureCallExpCS
    CallExpCS -> LoopExpCS

    LoopExpCS -> IteratorExpCS
    LoopExpCS -> IterateExpCS

--  IteratorExpCS[A.1] is parsed as OperationCallExpCS[B]
    IteratorExpCS ::=                          -- [A.2]
        primaryExpCS '->' simpleNameCS
        '(' uninitializedVariableCS '|' OclExpressionCS ')'
        /.$BeginCode
                    OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                    IteratorExpCS result = createIteratorExpCS(
                            source,
                            simpleNameCS,
                            (VariableCS)getRhsSym(5),
                            null,
                            (OCLExpressionCS)getRhsSym(7)
                        );
                    setOffsets(result, source, getRhsIToken(8));
                    setResult(result);
          $EndCode
        ./
    IteratorExpCS ::=                          -- [A.3.1]
        primaryExpCS '->' simpleNameCS
        '(' simpleNameCS ',' uninitializedVariableCS '|' OclExpressionCS ')'
        /.$BeginCode
                    SimpleNameCS name = (SimpleNameCS)getRhsSym(5);
                    VariableCS variableCS = createVariableCS(name, null, null);
                    setOffsets(variableCS, name);
                    OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                    IteratorExpCS result = createIteratorExpCS(
                            source,
                            simpleNameCS,
                            variableCS,
                            (VariableCS)getRhsSym(7),
                            (OCLExpressionCS)getRhsSym(9)
                        );
                    setOffsets(result, source, getRhsIToken(10));
                    setResult(result);
          $EndCode
        ./
    IteratorExpCS ::=                          -- [A.3.2]
        primaryExpCS '->' simpleNameCS '(' typedUninitializedVariableCS ','
        uninitializedVariableCS '|' OclExpressionCS ')'
        /.$BeginCode
                    OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                    IteratorExpCS result = createIteratorExpCS(
                            source,
                            simpleNameCS,
                            (VariableCS)getRhsSym(5),
                            (VariableCS)getRhsSym(7),
                            (OCLExpressionCS)getRhsSym(9)
                        );
                    setOffsets(result, source, getRhsIToken(10));
                    setResult(result);
          $EndCode
        ./
--  IteratorExpCS[B] is parsed as OperationCallExpCS[C]
--  IteratorExpCS[C] is parsed as AssociationClassCallExpCS[A.1]
--  IteratorExpCS[D] is parsed as AssociationClassCallExpCS[A]
--  IteratorExpCS[E] is parsed as AssociationClassCallExpCS[A]

    IterateExpCS ::= primaryExpCS '->' simpleNameCS
        '(' typedInitializedVariableCS '|' OclExpressionCS ')'
        /.$BeginCode
                    OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                    IterateExpCS result = createIterateExpCS(
                            source,
                            simpleNameCS,
                            (VariableCS)getRhsSym(5),
                            null,
                            (OCLExpressionCS)getRhsSym(7)
                        );
                    setOffsets(result, source, getRhsIToken(8));
                    setResult(result);
          $EndCode
        ./
    IterateExpCS ::= primaryExpCS '->' simpleNameCS
        '(' uninitializedVariableCS ';' typedInitializedVariableCS '|' OclExpressionCS ')'
        /.$BeginCode
                    OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                    IterateExpCS result = createIterateExpCS(
                            source,
                            simpleNameCS,
                            (VariableCS)getRhsSym(5),
                            (VariableCS)getRhsSym(7),
                            (OCLExpressionCS)getRhsSym(9)
                        );
                    setOffsets(result, source, getRhsIToken(10));
                    setResult(result);
          $EndCode
        ./

    FeatureCallExpCS -> OperationCallExpCS
    FeatureCallExpCS -> PropertyCallExpCS
    FeatureCallExpCS -> NavigationCallExpCS
    
--  OperationCallExpCS[A] is realized by the infix OclExpressionCS productions
    OperationCallExpCS ::= -- [B.1]
        primaryExpCS '->' simpleNameCS '(' ')'
        /.$BeginCode
                    OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                    OperationCallExpCS result = createArrowOperationCallExpCS(
                            source,
                            (SimpleNameCS)getRhsSym(3),
                            null,
                            new BasicEList<OCLExpressionCS>()
                        );
                    setOffsets(result, source, getRhsIToken(5));
                    setResult(result);
          $EndCode
        ./  
    OperationCallExpCS ::= -- [B.2],IteratorExpCS[A.1]
        primaryExpCS '->' simpleNameCS '(' OclExpressionCS ')'
        /.$BeginCode
                    OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                    OCLExpressionCS arg = (OCLExpressionCS)getRhsSym(5);
                    OCLExpressionCS result;
                    if (isIterator(simpleNameCS.getValue())) {
                        result = createIteratorExpCS(
                                source,
                                simpleNameCS,
                                null,
                                null,
                                arg
                            );
                    }
                    else {
                        EList<OCLExpressionCS> args = new BasicEList<OCLExpressionCS>();
                        args.add(arg);
                        result = createArrowOperationCallExpCS(
                                source,
                                simpleNameCS,
                                null,
                                args
                            );
                    }
                    setOffsets(result, source, getRhsIToken(6));
                    setResult(result);
          $EndCode
        ./  
    OperationCallExpCS ::= -- [B.3.1]
        primaryExpCS '->' simpleNameCS '(' notNameExpressionCS ',' argumentsCS ')'
        /.$BeginCode
                    EList<OCLExpressionCS> args = (EList<OCLExpressionCS>)getRhsSym(7);
                    args.add(0, (OCLExpressionCS)getRhsSym(5));
                    OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                    OperationCallExpCS result = createArrowOperationCallExpCS(
                            source,
                            (SimpleNameCS)getRhsSym(3),
                            null,
                            args
                        );
                    setOffsets(result, source, getRhsIToken(8));
                    setResult(result);
          $EndCode
        ./  
    OperationCallExpCS ::= -- [B.3.2]
        primaryExpCS '->' simpleNameCS '(' simpleNameCS ',' argumentsCS ')'
        /.$BeginCode
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(5);
                    OCLExpressionCS variableExpCS = createVariableExpCS(
                            simpleNameCS,
                            new BasicEList<OCLExpressionCS>(),
                            null
                        );
                    setOffsets(variableExpCS, simpleNameCS);
                    EList<OCLExpressionCS> args = (EList<OCLExpressionCS>)getRhsSym(7);
                    args.add(0, variableExpCS);
                    OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                    OperationCallExpCS result = createArrowOperationCallExpCS(
                            source,
                            (SimpleNameCS)getRhsSym(3),
                            null,
                            args
                        );
                    setOffsets(result, source, getRhsIToken(8));
                    setResult(result);
          $EndCode
        ./  
    OperationCallExpCS ::=
        primaryExpCS '.' conceptualOperationNameCS isMarkedPreCSopt '(' argumentsCSopt ')'
        /.$NewCase./
    OperationCallExpCS ::= -- [C],[E],IteratorExpCS[B]
        primaryExpCS '.' simpleNameCS isMarkedPreCSopt '(' argumentsCSopt ')'
        /.$BeginCode
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                    OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                    CallExpCS result = createDotOperationCallExpCS(
                            source,
                            null,
                            simpleNameCS,
                            (IsMarkedPreCS)getRhsSym(4),
                            (EList<OCLExpressionCS>)getRhsSym(6)
                        );
                    setOffsets(result, source, getRhsIToken(7));
                    setResult(result);
          $EndCode
        ./  
    OperationCallExpCS ::= -- [D],[F],[G.1]
        simpleNameCS isMarkedPreCSopt '(' argumentsCSopt ')'
        /.$BeginCode
                    OperationCallExpCS result = createDotOperationCallExpCS(
                            null,
                            null,
                            (SimpleNameCS)getRhsSym(1),
                            (IsMarkedPreCS)getRhsSym(2),
                            (EList<OCLExpressionCS>)getRhsSym(4)
                        );
                    setOffsets(result, getRhsIToken(1), getRhsIToken(5));
                    setResult(result);
          $EndCode
        ./
    OperationCallExpCS ::= -- [G.2]
        pathNameCS '::' unreservedSimpleNameCS '(' argumentsCSopt ')'
        /.$BeginCode
                    PathNameCS pathNameCS = (PathNameCS)getRhsSym(1);
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                    OperationCallExpCS result = createDotOperationCallExpCS(
                            null,
                            pathNameCS,
                            simpleNameCS,
                            null,
                            (EList<OCLExpressionCS>)getRhsSym(5)
                        );
                    setOffsets(result, pathNameCS, getRhsIToken(6));
                    setResult(result);
          $EndCode
        ./
--  OperationCallExpCS[H] is realized by the prefix OclExpressionCS productions
    OperationCallExpCS ::= -- [I],[J]   
        primaryExpCS '.' pathNameCS '::' unreservedSimpleNameCS isMarkedPreCSopt
        '(' argumentsCSopt ')'
        /.$BeginCode
                    PathNameCS pathNameCS = (PathNameCS)getRhsSym(3);
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(5);
                    OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                    CallExpCS result = createDotOperationCallExpCS(
                            source,
                            pathNameCS,
                            simpleNameCS,
                            (IsMarkedPreCS)getRhsSym(6),
                            (EList<OCLExpressionCS>)getRhsSym(8)
                        );
                    setOffsets(result, source, getRhsIToken(9));
                    setResult(result);
          $EndCode
        ./
            
--  NavigationCallExpCS -> PropertyCallExpCS -- parsed as FeatureCallExpCS
    NavigationCallExpCS -> AssociationClassCallExpCS
        
--  PropertyCallExpCS[A] is parsed as AssociationClassCallExpCS[A.1]
--  PropertyCallExpCS[B.1] is parsed as a SimpleNameExpCS
--  PropertyCallExpCS[B.2] is parsed as a AssociationClassCallExpCS[B.1]
    PropertyCallExpCS ::= -- [C] excluding [B]
        pathNameCS '::' unreservedSimpleNameCS isMarkedPreCSopt
        /.$BeginCode
                    PathNameCS pathNameCS = (PathNameCS)getRhsSym(1);
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                    IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(4);
                    FeatureCallExpCS result = createFeatureCallExpCS(
                            null,
                            pathNameCS,
                            simpleNameCS,
                            new BasicEList<OCLExpressionCS>(),
                            isMarkedPreCS
                        );
                    if (isMarkedPreCS != null) {
                        setOffsets(result, pathNameCS, isMarkedPreCS);
                    } else {
                        setOffsets(result, pathNameCS, simpleNameCS);
                    }
                    setResult(result);
          $EndCode
        ./
    PropertyCallExpCS ::= -- [D]
        primaryExpCS '.' pathNameCS '::' unreservedSimpleNameCS isMarkedPreCSopt
        /.$BeginCode
                    OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                    PathNameCS pathNameCS = (PathNameCS)getRhsSym(3);
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(5);
                    IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(6);
                    FeatureCallExpCS result = createFeatureCallExpCS(
                            source,
                            pathNameCS,
                            simpleNameCS,
                            new BasicEList<OCLExpressionCS>(),
                            isMarkedPreCS
                        );
                    if (isMarkedPreCS != null) {
                        setOffsets(result, source, isMarkedPreCS);
                    } else {
                        setOffsets(result, source, simpleNameCS);
                    }
                    setResult(result);
          $EndCode
        ./

    AssociationClassCallExpCS ::= -- [A.1],PropertyCallExpCS[A],IteratorExpCS[C,D,E]
        primaryExpCS '.' simpleNameCS isMarkedPreCSopt
        /.$BeginCode
                    OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                    IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(4);
                    FeatureCallExpCS result = createFeatureCallExpCS(
                            source,
                            null,
                            simpleNameCS,
                            new BasicEList<OCLExpressionCS>(),
                            isMarkedPreCS
                        );
                    if (isMarkedPreCS != null) {
                        setOffsets(result, source, isMarkedPreCS);
                    } else {
                        setOffsets(result, source, simpleNameCS);
                    }
                    setResult(result);
          $EndCode
        ./
    AssociationClassCallExpCS ::= -- [A.2],IteratorExpCS[D,E]
        primaryExpCS '.' simpleNameCS '[' argumentsCS ']' isMarkedPreCSopt
        /.$BeginCode
                    OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                    IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(7);
                    FeatureCallExpCS result = createFeatureCallExpCS(
                            source,
                            null,
                            simpleNameCS,
                            (EList<OCLExpressionCS>)getRhsSym(5),
                            isMarkedPreCS
                        );
                    if (isMarkedPreCS != null) {
                        setOffsets(result, source, isMarkedPreCS);
                    } else {
                        setOffsets(result, source, getRhsIToken(6));
                    }
                    setResult(result);
          $EndCode
        ./
--  AssociationClassCallExpCS[B.1.1] parsed as SimpleNameExpCS
--  AssociationClassCallExpCS[B.1.2] is added by Complete OCL
    AssociationClassCallExpCS ::=  -- [B.2]
        simpleNameCS '[' argumentsCS ']' isMarkedPreCSopt
        /.$BeginCode
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                    IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(5);
                    VariableExpCS result = createVariableExpCS(
                            simpleNameCS,
                            (EList<OCLExpressionCS>)getRhsSym(3),
                            isMarkedPreCS
                        );
                    if (isMarkedPreCS != null) {
                        setOffsets(result, simpleNameCS, isMarkedPreCS);
                    } else {
                        setOffsets(result, simpleNameCS, getRhsIToken(4));
                    }
                    setResult(result);
          $EndCode
        ./

    isMarkedPreCSopt ::= %empty
        /.$BeginCode
                    setResult(null);
          $EndCode
        ./

    argumentsCSopt ::= %empty
        /.$BeginCode
                    setResult(new BasicEList<OCLExpressionCS>());
          $EndCode
        ./
    argumentsCSopt -> argumentsCS

    argumentsCS ::= OclExpressionCS
        /.$BeginCode
                    EList<OCLExpressionCS> result = new BasicEList<OCLExpressionCS>();
                    result.add((OCLExpressionCS)getRhsSym(1));
                    setResult(result);
          $EndCode
        ./
    argumentsCS ::= argumentsCS ',' OclExpressionCS
        /.$BeginCode
                    EList<OCLExpressionCS> result = (EList<OCLExpressionCS>)getRhsSym(1);
                    result.add((OCLExpressionCS)getRhsSym(3));
                    setResult(result);
          $EndCode
        ./

-----------------------------------------------------------------------
--  Expressions
-----------------------------------------------------------------------
    -- An OclExpressionCS comprising just a SimpleNameCS is kept separate as
    --  SimpleNameExpCS to avoid ambiguity when parsing "a->b(c,d" until the next
    --  letter resolves the usage as a two iterator  or as a two or more argument
    --  OperationCallExpCS.
    -- An OclExpressionCS comprising one or more LetExpCS is kept separate to ensure
    --  that let is right associative, whereas infix operators are left associative.
    --   a = 64 / 16 / let b : Integer in 8 / let c : Integer in 4 
    -- is
    --   a = (64 / 16) / (let b : Integer in 8 / (let c : Integer in 4 ))
    OclExpressionCS -> notNameExpressionCS
    OclExpressionCS -> SimpleNameExpCS
        
--  VariableExpCS[.1] simpleNameCS parsed as SimpleNameExpCS
    VariableExpCS ::= -- [.2]
        selfKeywordCS
        /.$BeginCode
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                    VariableExpCS result = createVariableExpCS(
                            simpleNameCS,
                            new BasicEList<OCLExpressionCS>(),
                            null
                        );
                    setOffsets(result, simpleNameCS);
                    setResult(result);
          $EndCode
        ./
        
    SimpleNameExpCS ::= -- AssociationClassCallExpCS[B.1.1],
                        -- PropertyCallExpCS[B],VariableExpCS[.1]
        simpleNameCS
        /.$BeginCode
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                    VariableExpCS result = createVariableExpCS(
                            simpleNameCS,
                            new BasicEList<OCLExpressionCS>(),
                            null
                        );
                    setOffsets(result, simpleNameCS);
                    setResult(result);
          $EndCode
        ./

    notNameExpressionCS -> impliesNotNameNotLetCS
    notNameExpressionCS -> impliesWithLetCS
    
    impliesNotLetCS -> impliesNotNameNotLetCS
    impliesNotLetCS -> SimpleNameExpCS
    impliesNotNameNotLetCS -> xorNotNameNotLetCS
    impliesNotNameNotLetCS ::= impliesNotLetCS implies xorNotLetCS
        /.$NewCase./
    impliesWithLetCS -> xorWithLetCS
    impliesWithLetCS ::= impliesNotLetCS implies xorWithLetCS
        /.$NewCase./

    xorNotLetCS -> xorNotNameNotLetCS
    xorNotLetCS -> SimpleNameExpCS
    xorNotNameNotLetCS -> orNotNameNotLetCS
    xorNotNameNotLetCS ::= xorNotLetCS xor orNotLetCS
        /.$NewCase./
    xorWithLetCS -> orWithLetCS
    xorWithLetCS ::= xorNotLetCS xor orWithLetCS
        /.$NewCase./

    orNotLetCS -> orNotNameNotLetCS
    orNotLetCS -> SimpleNameExpCS
    orNotNameNotLetCS -> andNotNameNotLetCS
    orNotNameNotLetCS ::= orNotLetCS or andNotLetCS
        /.$NewCase./
    orWithLetCS -> andWithLetCS
    orWithLetCS ::= orNotLetCS or andWithLetCS
        /.$NewCase./

    andNotLetCS -> andNotNameNotLetCS
    andNotLetCS -> SimpleNameExpCS
    andNotNameNotLetCS -> equalityNotNameNotLetCS
    andNotNameNotLetCS ::= andNotLetCS and equalityNotLetCS
        /.$NewCase./
    andWithLetCS -> equalityWithLetCS
    andWithLetCS ::= andNotLetCS and equalityWithLetCS
        /.$NewCase./

    equalityNotLetCS -> equalityNotNameNotLetCS
    equalityNotLetCS -> SimpleNameExpCS
    equalityNotNameNotLetCS -> relationalNotNameNotLetCS
    equalityNotNameNotLetCS ::= equalityNotLetCS '=' relationalNotLetCS
        /.$NewCase./
    equalityNotNameNotLetCS ::= equalityNotLetCS '<>' relationalNotLetCS
        /.$NewCase./
    equalityWithLetCS -> relationalWithLetCS
    equalityWithLetCS ::= equalityNotLetCS '=' relationalWithLetCS
        /.$NewCase./
    equalityWithLetCS ::= equalityNotLetCS '<>' relationalWithLetCS
        /.$NewCase./
    
    relationalNotLetCS -> relationalNotNameNotLetCS
    relationalNotLetCS -> SimpleNameExpCS
    relationalNotNameNotLetCS -> additiveNotNameNotLetCS
    relationalNotNameNotLetCS ::= relationalNotLetCS '>' additiveNotLetCS
        /.$NewCase./
    relationalNotNameNotLetCS ::= relationalNotLetCS '<' additiveNotLetCS
        /.$NewCase./
    relationalNotNameNotLetCS ::= relationalNotLetCS '>=' additiveNotLetCS
        /.$NewCase./
    relationalNotNameNotLetCS ::= relationalNotLetCS '<=' additiveNotLetCS
        /.$NewCase./
    relationalWithLetCS -> additiveWithLetCS
    relationalWithLetCS ::= relationalNotLetCS '>' additiveWithLetCS
        /.$NewCase./
    relationalWithLetCS ::= relationalNotLetCS '<' additiveWithLetCS
        /.$NewCase./
    relationalWithLetCS ::= relationalNotLetCS '>=' additiveWithLetCS
        /.$NewCase./
    relationalWithLetCS ::= relationalNotLetCS '<=' additiveWithLetCS
        /.$NewCase./

    additiveNotLetCS -> additiveNotNameNotLetCS
    additiveNotLetCS -> SimpleNameExpCS
    additiveNotNameNotLetCS -> multiplicativeNotNameNotLetCS
    additiveNotNameNotLetCS ::= additiveNotLetCS '+' multiplicativeNotLetCS
        /.$NewCase./
    additiveNotNameNotLetCS ::= additiveNotLetCS '-' multiplicativeNotLetCS
        /.$NewCase./
    additiveWithLetCS -> multiplicativeWithLetCS
    additiveWithLetCS ::= additiveNotLetCS '+' multiplicativeWithLetCS
        /.$NewCase./
    additiveWithLetCS ::= additiveNotLetCS '-' multiplicativeWithLetCS
        /.$NewCase./
    
    multiplicativeNotLetCS -> multiplicativeNotNameNotLetCS
    multiplicativeNotLetCS -> SimpleNameExpCS
    multiplicativeNotNameNotLetCS -> unaryNotNameNotLetCS
    multiplicativeNotNameNotLetCS ::= multiplicativeNotLetCS '*' unaryNotLetCS
        /.$NewCase./
    multiplicativeNotNameNotLetCS ::= multiplicativeNotLetCS '/' unaryNotLetCS
        /.$NewCase./
    multiplicativeWithLetCS -> unaryWithLetCS
    multiplicativeWithLetCS ::= multiplicativeNotLetCS '*' unaryWithLetCS
        /.$NewCase./
    multiplicativeWithLetCS ::= multiplicativeNotLetCS '/' unaryWithLetCS
        /.$BeginCode
                    SimpleNameCS simpleNameCS = createSimpleNameCS(
                                SimpleTypeEnum.KEYWORD_LITERAL,
                                getRhsIToken(2)
                            );
                    setOffsets(simpleNameCS, getRhsIToken(2));
                    OCLExpressionCS left = (OCLExpressionCS)getRhsSym(1);
                    OCLExpressionCS right = (OCLExpressionCS)getRhsSym(3);
                    EList<OCLExpressionCS> args = new BasicEList<OCLExpressionCS>();
                    args.add(right);
                    OperationCallExpCS result = createOperationCallExpCS(
                            left,
                            simpleNameCS,
                            args
                        );
                    setOffsets(result, left, right);
                    setResult(result);
          $EndCode
        ./
    
    unaryNotLetCS -> unaryNotNameNotLetCS
    unaryNotLetCS -> SimpleNameExpCS
    unaryNotNameNotLetCS -> primaryNotNameCS
    unaryNotNameNotLetCS ::= '-' unaryNotLetCS
        /.$NewCase./
    unaryNotNameNotLetCS ::= not unaryNotLetCS
        /.$NewCase./
    unaryWithLetCS -> LetExpCS             -- OclExpressionCS[D]
    unaryWithLetCS ::= '-' unaryWithLetCS
        /.$NewCase./
    unaryWithLetCS ::= not unaryWithLetCS
        /.$BeginCode
                    SimpleNameCS simpleNameCS = createSimpleNameCS(
                                SimpleTypeEnum.KEYWORD_LITERAL,
                                getRhsIToken(1)
                            );
                    setOffsets(simpleNameCS, getRhsIToken(1));
                    OCLExpressionCS expr = (OCLExpressionCS)getRhsSym(2);
                    OperationCallExpCS result = createOperationCallExpCS(
                            expr,
                            simpleNameCS,
                            new BasicEList<OCLExpressionCS>()
                        );
                    setOffsets(result, simpleNameCS, expr);
                    setResult(result);
          $EndCode
        ./

    primaryExpCS -> primaryNotNameCS
    primaryExpCS -> SimpleNameExpCS
    
    primaryNotNameCS -> CallExpCS       -- OclExpressionCS[A]
    primaryNotNameCS -> VariableExpCS   -- OclExpressionCS[B]
    primaryNotNameCS -> LiteralExpCS    -- OclExpressionCS[C]
--  primaryNotNameCS -> OclMessageExpCS -- OclExpressionCS[E] is added by Complete OCL
    primaryNotNameCS -> IfExpCS         -- OclExpressionCS[F]
    primaryNotNameCS ::= '(' OclExpressionCS ')'
        /.$BeginCode
                    OCLExpressionCS result = (OCLExpressionCS)getRhsSym(2);
                    if (result instanceof OperationCallExpCS) {
                        ((OperationCallExpCS)result).setIsAtomic(true);
                    }
                    setOffsets(result, getRhsIToken(1), getRhsIToken(3));
                    setResult(result);
          $EndCode
        ./

    IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS endif
        /.$BeginCode
                    IfExpCS result = createIfExpCS(
                            (OCLExpressionCS)getRhsSym(2),
                            (OCLExpressionCS)getRhsSym(4),
                            (OCLExpressionCS)getRhsSym(6)
                        );
                    setOffsets(result, getRhsIToken(1), getRhsIToken(7));
                    setResult(result);
          $EndCode
        ./

    LetExpCS ::= let letVariablesCS in OclExpressionCS
        /.$BeginCode
                    OCLExpressionCS expr = (OCLExpressionCS)getRhsSym(4);
                    LetExpCS result = createLetExpCS(
                            (EList<VariableCS>)getRhsSym(2),
                            expr
                        );
                    setOffsets(result, getRhsIToken(1), expr);
                    setResult(result);
          $EndCode
        ./
    
    letVariablesCS ::= typedInitializedVariableCS 
        /.$BeginCode
                    EList<VariableCS> result = new BasicEList<VariableCS>();
                    result.add((VariableCS)getRhsSym(1));
                    setResult(result);
          $EndCode
        ./
    letVariablesCS ::= letVariablesCS ',' typedInitializedVariableCS
        /.$BeginCode
                    EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                    result.add((VariableCS)getRhsSym(3));
                    setResult(result);
          $EndCode
        ./
%End
