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
-- * $Id: EssentialOCL.gi,v 1.2 2011/01/24 21:31:48 ewillink Exp $
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
 * $Id: EssentialOCL.gi,v 1.2 2011/01/24 21:31:48 ewillink Exp $
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
    reservedKeywordCS ::= reservedKeyword
    restrictedKeywordCS -> CollectionTypeIdentifier
--  restrictedKeywordCS -> BooleanLiteralExpCS
--  restrictedKeywordCS -> InvalidLiteralExpCS
--  restrictedKeywordCS -> NullLiteralExpCS
--  restrictedKeywordCS -> selfKeywordCS
    restrictedKeywordCS -> PrimitiveTypeIdentifier
    restrictedKeywordCS -> tupleKeywordCS
        
    SimpleName ::= IDENTIFIER
    SimpleName -> QuotedSimpleNameCS
    QuotedSimpleNameCS ::= QUOTED_IDENTIFIER
    QuotedSimpleNameCS ::= QuotedSimpleNameCS STRING_LITERAL

    unreservedSimpleNameCS -> SimpleName
    unreservedSimpleNameCS -> restrictedKeywordCS

	InfixOperator -> '*'
	InfixOperator -> '/'
	InfixOperator -> '+'
	InfixOperator -> '-'
	InfixOperator -> '>'
	InfixOperator -> '<'
	InfixOperator -> '>='
	InfixOperator -> '<='
	InfixOperator -> '='
	InfixOperator -> '<>'
	InfixOperator -> 'and'
	InfixOperator -> 'or'
	InfixOperator -> 'xor'
	InfixOperator -> 'implies'
	InfixOperator -> '.'
	InfixOperator -> '->'
 
	PrefixOperator -> '-'
	PrefixOperator -> 'not'
        
-----------------------------------------------------------------------
--  Types
-----------------------------------------------------------------------
    PrimitiveTypeIdentifier ::= Boolean
    PrimitiveTypeIdentifier ::= Integer
    PrimitiveTypeIdentifier ::= Real
    PrimitiveTypeIdentifier ::= String
    PrimitiveTypeIdentifier ::= UnlimitedNatural
    PrimitiveTypeIdentifier ::= OclAny
    PrimitiveTypeIdentifier ::= OclInvalid
    PrimitiveTypeIdentifier ::= OclVoid
        
    PrimitiveTypeCS ::= PrimitiveTypeIdentifier
    
    CollectionTypeIdentifier ::= Set
    CollectionTypeIdentifier ::= Bag
    CollectionTypeIdentifier ::= Sequence
    CollectionTypeIdentifier ::= Collection
    CollectionTypeIdentifier ::= OrderedSet

    CollectionTypeCS ::= CollectionTypeIdentifier
    CollectionTypeCS ::= CollectionTypeIdentifier '(' TypeExpCS ')'

    TupleTypeCS ::= Tuple
    TupleTypeCS ::= Tuple '(' tupleTypePartCSlistopt ')'

    tupleTypePartCSlistopt ::= %empty
    tupleTypePartCSlistopt -> tupleTypePartCSlist

    tupleTypePartCSlist ::= tuplePartCS
    tupleTypePartCSlist ::= tupleTypePartCSlist ',' tuplePartCS

    tuplePartCS ::= SimpleName ':' TypeExpCS

-----------------------------------------------------------------------
--  Declarations
-----------------------------------------------------------------------     
    VariableDeclarationCS -> SimpleName
    VariableDeclarationCS -> SimpleName '=' OclExpressionCS
    VariableDeclarationCS -> SimpleName ':' TypeExpCS
    VariableDeclarationCS -> SimpleName ':' TypeExpCS '=' OclExpressionCS

-----------------------------------------------------------------------
--  Literals
-----------------------------------------------------------------------
--    LiteralExpCS -> CollectionLiteralExpCS
--    LiteralExpCS -> TupleLiteralExpCS
--    LiteralExpCS -> PrimitiveLiteralExpCS
--    LiteralExpCS -> TypeLiteralExpCS

    CollectionLiteralExpCS ::= CollectionTypeCS '{' CollectionLiteralPartCSlistopt '}'

    CollectionLiteralPartCSlistopt ::= %empty
    CollectionLiteralPartCSlistopt -> CollectionLiteralPartCSlist

    CollectionLiteralPartCSlist ::= CollectionLiteralPartCS
    CollectionLiteralPartCSlist ::= CollectionLiteralPartCSlist ',' CollectionLiteralPartCS

    CollectionLiteralPartCS ::= OclExpressionCS
    CollectionLiteralPartCS ::= OclExpressionCS '..' OclExpressionCS

    PrimitiveLiteralExpCS -> NumberLiteralExpCS
    PrimitiveLiteralExpCS -> StringLiteralExpCS
    PrimitiveLiteralExpCS -> BooleanLiteralExpCS
    PrimitiveLiteralExpCS -> UnlimitedNaturalLiteralExpCS
    PrimitiveLiteralExpCS -> InvalidLiteralExpCS
    PrimitiveLiteralExpCS -> NullLiteralExpCS

    TupleLiteralExpCS ::= Tuple '{' TupleLiteralPartCSlist '}'

    TupleLiteralPartCSlist ::= TupleLiteralPartCS
    TupleLiteralPartCSlist ::= TupleLiteralPartCSlist ',' TupleLiteralPartCS

    TupleLiteralPartCS -> SimpleName '=' OclExpressionCS
    TupleLiteralPartCS -> SimpleName ':' TypeExpCS '=' OclExpressionCS

    NumberLiteralExpCS ::= INTEGER_LITERAL
    NumberLiteralExpCS ::= REAL_LITERAL

    StringLiteralExpCS ::= STRING_LITERAL
    StringLiteralExpCS ::= StringLiteralExpCS STRING_LITERAL

    BooleanLiteralExpCS ::= true
    BooleanLiteralExpCS ::= false

    UnlimitedNaturalLiteralExpCS ::= '*'

    InvalidLiteralExpCS ::= invalid

    NullLiteralExpCS ::= null
        
    TypeLiteralExpCS ::= PrimitiveTypeCS
    TypeLiteralExpCS ::= CollectionTypeCS
    TypeLiteralExpCS ::= TupleTypeCS

    TypeNameExpCS -> SimpleName
    TypeNameExpCS ::= SimpleName '(' ')'
    TypeNameExpCS ::= SimpleName '(' UntypedExpressionCSlist ')'
    TypeNameExpCS ::= TypeNameExpCS '::' unreservedSimpleNameCS

    TypeExpCS -> TypeNameExpCS
    TypeExpCS -> TypeLiteralExpCS

-----------------------------------------------------------------------
--  Expressions
-----------------------------------------------------------------------
    OclExpressionCS -> InfixedExpCS
    OclExpressionCS -> InfixedLetExpCS

	InfixedExpCS -> PrefixedExpCS
	InfixedExpCS ::= InfixedExpCS InfixOperator PrefixedExpCS

	InfixedLetExpCS -> PrefixedLetExpCS
	InfixedLetExpCS ::= InfixedExpCS InfixOperator PrefixedLetExpCS

	PrefixedExpCS -> PrimaryExpCS
	PrefixedExpCS ::= PrefixOperator PrefixedExpCS

	PrefixedLetExpCS ::= LetExpCS
	PrefixedLetExpCS ::= PrefixOperator PrefixedLetExpCS

	PrimaryExpCS -> NavigatingExpCS
	PrimaryExpCS -> SelfExpCS
	PrimaryExpCS -> PrimitiveLiteralExpCS
	PrimaryExpCS -> TupleLiteralExpCS
	PrimaryExpCS -> CollectionLiteralExpCS
--	PrimaryExpCS -> TypeExpCS
--    PrimaryExpCS -> NameExpCS
    PrimaryExpCS -> TypeLiteralExpCS
	PrimaryExpCS -> IfExpCS
	PrimaryExpCS -> NestedExpCS

    NameExpCS -> SimpleName
    NameExpCS ::= NameExpCS '::' unreservedSimpleNameCS

	IndexExpCS -> NameExpCS
	IndexExpCS ::= NameExpCS '[' ExpCSlist ']'
	IndexExpCS ::= NameExpCS '[' ExpCSlist ']' '[' ExpCSlist ']'
	
	ExpCSlist ::= OclExpressionCS
	ExpCSlist ::= ExpCSlist ',' OclExpressionCS

	NavigatingExpCSbase -> IndexExpCS

	NavigatingExpCS -> NavigatingExpCSbase
	NavigatingExpCS ::= NavigatingExpCSbase '(' ')'
	NavigatingExpCS ::= NavigatingExpCSbase '(' TypedExpressionCS ')'
	NavigatingExpCS ::= NavigatingExpCSbase '(' TypedExpressionCS ',' UntypedExpressionCSlist ')'
	NavigatingExpCS ::= NavigatingExpCSbase '(' TypedExpressionCS '|' UntypedExpressionCSlist ')'
	NavigatingExpCS ::= NavigatingExpCSbase '(' TypedExpressionCS ',' TypedExpressionCS '|' UntypedExpressionCSlist ')'
	NavigatingExpCS ::= NavigatingExpCSbase '(' TypedExpressionCS ';' iteratorAccumulatorCS '|' UntypedExpressionCSlist ')'

    UntypedExpressionCSlist ::= UntypedExpressionCS
    UntypedExpressionCSlist ::= UntypedExpressionCSlist ',' UntypedExpressionCS

	UntypedExpressionCS -> OclExpressionCS

	TypedExpressionCS ::= OclExpressionCS
	TypedExpressionCS ::= OclExpressionCS ':' TypeExpCS

	iteratorAccumulatorCS ::= SimpleName ':' TypeExpCS '=' OclExpressionCS

    IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS endif

    LetExpCS ::= let LetVariableCSlist in OclExpressionCS
    
    LetVariableCSlist ::= LetVariableCS 
    LetVariableCSlist ::= LetVariableCSlist ',' LetVariableCS

    LetVariableCS ::= SimpleName '=' OclExpressionCS 
    LetVariableCS ::= SimpleName ':' TypeExpCS '=' OclExpressionCS 

	NestedExpCS  ::= '(' OclExpressionCS ')'
        
    SelfExpCS ::= self
%End
