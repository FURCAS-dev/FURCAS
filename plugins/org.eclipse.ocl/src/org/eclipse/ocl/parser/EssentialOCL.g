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
-- * $Id: EssentialOCL.g,v 1.15 2009/10/15 19:43:12 ewillink Exp $
-- */
--
-- The EssentialOCL Parser
--


$Define

	-- Definition of macros used in the parser template
	--
	$prs_stream_class /.AbstractOCLParser./
	$prs_parser_class /.DeterministicParser./
	$prs_parser_exception /.NotDeterministicParseTableException./
	$prs_parser_throw /.throw new RuntimeException("****Error: Regenerate $prs_type.java with -NOBACKTRACK option")./
	$prs_parse_args /../
	$lex_stream_class /.AbstractLexer./
	$action_class /.$file_prefix./
	$copyright_contributions /.*./

	-- package namespace of the LPG Runtime API
	$lpg_ns /.lpg.lpgjavaruntime./

	$NewCase
	/. $Header
				case $rule_number:./

	-- From bt/dtParserTemplateD.g
	------------------------------------------------------
	$Header
	/.
				//
				// Rule $rule_number:  $rule_text
				//./

	$BeginAction
	/. $Header
				case $rule_number: {./

	$EndAction
	/.		  break;
				}./

	$BeginJava
	/.$BeginAction
					$symbol_declarations./

	$EndJava /.$EndAction./

	$NoAction
	/. $Header
				case $rule_number:
					break;./

	$NullAction
	/. $Header
				case $rule_number:
					$setResult(null);
					break;./

	$EmptyListAction
	/. $Header
				case $rule_number:
					$setResult(new BasicEList());
					break;./
	
	$BeginActions
	/.
		@SuppressWarnings("unchecked")
		public void ruleAction(int ruleNumber)
		{
			switch (ruleNumber) {
			./

	$EndActions
	/.
				default:
					break;
			}
			return;
		}./

	$additional_interfaces /../
	$action_class /.$file_prefix./
	$setSym1 /.dtParser.setSym1./
	$setResult /.dtParser.setSym1./
	$getSym /.dtParser.getSym./
	$getToken /.dtParser.getToken./
	$getIToken /.getIToken./
	$getLeftSpan /.dtParser.getFirstToken./
	$getRightSpan /.dtParser.getLastToken./
	$prs_stream /.prsStream./
	
	-- modified to include throwing exceptions
	$parserCore
	/.
	public class $action_class extends $prs_stream_class implements RuleAction$additional_interfaces
	{
		protected static ParseTable prs = new $prs_type();
		private $prs_parser_class dtParser;

		public $action_class($lex_stream_class lexer) {
			super(lexer);
		}

		public int getEOFTokenKind() { return $prs_type.EOFT_SYMBOL; }
	
		public $environment_class getOCLEnvironment() {
			return getLexer().getOCLEnvironment();
		}
		
		@Override 
		public $lex_stream_class getLexer() {
			return ($lex_stream_class)super.getLexer();
		}

		public String getTokenKindName(int kind) { return $sym_type.orderedTerminalSymbols[kind]; }			

		@Override
		public String[] orderedTerminalSymbols() { return $sym_type.orderedTerminalSymbols; }
			
		@SuppressWarnings("nls")
		@Override
		public $ast_type parseTokensToCST(Monitor monitor, int error_repair_count) {
			ParseTable prsTable = new $prs_type();

			try {
				dtParser = new $prs_parser_class(monitor, this, prsTable, this);
			}
			catch ($prs_parser_exception e) {
                $prs_parser_throw;
			}
			catch (BadParseSymFileException e) {
				throw new RuntimeException("****Error: Bad Parser Symbol File -- $sym_type.java. Regenerate $prs_type.java");
			}

			try {
				return ($ast_type) dtParser.parse($prs_parse_args);
			}
			catch (BadParseException e) {
				reset(e.error_token); // point to error token

				DiagnoseParser diagnoseParser = new DiagnoseParser(this, prsTable);
				diagnoseParser.diagnose(e.error_token);
			}

			return null;
		}
	
        /**
         * Initializes a concrete-syntax node's start and end offsets from the
         * current token in the parser stream.
         * 
         * @param cstNode a concrete-syntax node
         * 
         * @since 1.2
         */
		protected void setOffsets(CSTNode cstNode) {
			IToken firstToken = getIToken($getToken(1));
			cstNode.setStartToken(firstToken);
			cstNode.setEndToken(firstToken);
			cstNode.setStartOffset(firstToken.getStartOffset());
			cstNode.setEndOffset(firstToken.getEndOffset()-1);
		}
	./
$End

$Notice
	/./**
 * Essential OCL Grammar
 * <copyright>
 *
 * Copyright (c) 2005, 2009 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Elimination of some shift-reduce conflicts
 *   E.D.Willink - Remove unnecessary warning suppression
 *   E.D.Willink - Bugs 184048, 225493, 243976, 259818, 282882, 287993, 288040, 292112
 *   Borland - Bug 242880
$copyright_contributions
 * </copyright>
 *
 * $Id: EssentialOCL.g,v 1.15 2009/10/15 19:43:12 ewillink Exp $
 */
	./
$End

$Globals
	/.import org.eclipse.emf.common.util.BasicEList;
	import org.eclipse.emf.common.util.EList;
	import org.eclipse.ocl.cst.CSTNode;
	import org.eclipse.ocl.cst.CallExpCS;
	import org.eclipse.ocl.cst.CollectionTypeCS;
	import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
	import org.eclipse.ocl.cst.IsMarkedPreCS;
	import org.eclipse.ocl.cst.OCLExpressionCS;
	import org.eclipse.ocl.cst.OperationCallExpCS;
	import org.eclipse.ocl.cst.PathNameCS;
	import org.eclipse.ocl.cst.SimpleNameCS;
	import org.eclipse.ocl.cst.SimpleTypeEnum;
	import org.eclipse.ocl.cst.StringLiteralExpCS;
	import org.eclipse.ocl.cst.TypeCS;
	import org.eclipse.ocl.cst.VariableCS;
	
	import $lpg_ns.BadParseException;
	import $lpg_ns.BadParseSymFileException;
	import $lpg_ns.$prs_parser_class;
	import $lpg_ns.DiagnoseParser;
	import $lpg_ns.IToken;
	import $lpg_ns.Monitor;
	import $lpg_ns.$prs_parser_exception;
	import $lpg_ns.ParseTable;
	import $lpg_ns.RuleAction;
	./
$End

$KeyWords
	-- EssentialOCL keywords
	and
	else
	endif
	if
	implies
	in
	let
	not
	or
	then
	xor

	--
	-- the following appear to have been omitted from the list of
	-- OCL reserved words in Section 7.4.9.  They will be treated 
	-- as unreserved for compliance
	--
	false
	null
	invalid
	self
	true

	Set
	Bag
	Sequence
	Collection
	OrderedSet

	String
	Integer
	UnlimitedNatural
	Real
	Boolean
	Tuple
	OclAny
	OclVoid
	OclInvalid

	--
	-- the remainder of the LPG keywords are defined as such for the
	-- purpose of constructing the CST grammar.  They are not OCL
	-- reserved words
	--		
	iterate
	forAll
	exists
	isUnique
	any
	one

	collect
	select
	reject
	collectNested
	sortedBy

	closure
$End

$Identifier
	IDENTIFIER
$End

$Terminals
	
	STRING_LITERAL
	INTEGER_LITERAL
	REAL_LITERAL
	
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
$End

$EOF
    EOF_TOKEN
$End

$ERROR
    ERROR_TOKEN
$End

--$EOL
--	SEMICOLON
--$End

--$Start
--    goal
--$End

$Headers
	/.$parserCore

	./
$End

$Rules
	/.$BeginActions./

-----------------------------------------------------------------------
--	Names
-----------------------------------------------------------------------
	binaryKeyword -> and
	binaryKeyword -> implies
	binaryKeyword -> or
	binaryKeyword -> xor
	
	binaryPunctuation -> EQUAL
	binaryPunctuation -> NOT_EQUAL
	binaryPunctuation -> PLUS
	binaryPunctuation -> MULTIPLY
	binaryPunctuation -> DIVIDE
	binaryPunctuation -> GREATER
	binaryPunctuation -> LESS
	binaryPunctuation -> GREATER_EQUAL
	binaryPunctuation -> LESS_EQUAL

	unaryKeyword -> not
	unaryPunctuation -> MINUS

	iterateIdentifier -> iterate
	
	iteratorIdentifier -> forAll
	iteratorIdentifier -> exists
	iteratorIdentifier -> isUnique
	iteratorIdentifier -> any
	iteratorIdentifier -> one
	iteratorIdentifier -> collect
	iteratorIdentifier -> select
	iteratorIdentifier -> reject
	iteratorIdentifier -> collectNested
	iteratorIdentifier -> sortedBy
	iteratorIdentifier -> closure
	
	otherIdentifier -> IDENTIFIER

	otherKeyword -> else
	otherKeyword -> endif
	otherKeyword -> if
	otherKeyword -> in
	otherKeyword -> let
	otherKeyword -> then

	reservedPunctuation -> binaryPunctuation
	reservedPunctuation -> unaryPunctuation

	binaryKeywordCS ::= binaryKeyword
		/.$NewCase./
	otherKeywordCS ::= otherKeyword
		/.$NewCase./
	unaryKeywordCS ::= unaryKeyword
		/.$NewCase./
	reservedPunctuationCS ::= reservedPunctuation
		/.$BeginJava
					SimpleNameCS result = createSimpleNameCS(
								SimpleTypeEnum.KEYWORD_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	reservedKeywordCS -> binaryKeywordCS
	reservedKeywordCS -> unaryKeywordCS
	reservedKeywordCS -> otherKeywordCS
		
	iterateNameCS ::= iterateIdentifier
		/.$NewCase./
	iteratorNameCS ::= iteratorIdentifier
		/.$NewCase./
	simpleIdentifierCS ::= otherIdentifier
		/.$BeginJava
					CSTNode result = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText($getToken(1))
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	simpleIdentifierCS -> primitiveTypeCS
	simpleIdentifierCS ::= self
		/.$BeginJava
					CSTNode result = createSimpleNameCS(
							SimpleTypeEnum.SELF_LITERAL,
							getTokenText($getToken(1))
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	literalSimpleNameCS -> BooleanLiteralExpCS
	literalSimpleNameCS -> InvalidLiteralExpCS
	literalSimpleNameCS -> NullLiteralExpCS
		
	notIteratorNorReservedSimpleNameCS -> CollectionTypeIdentifierCS
--	notIteratorNorReservedSimpleNameCS -> iterateNameCS
--	notIteratorNorReservedSimpleNameCS -> iteratorNameCS
	notIteratorNorReservedSimpleNameCS -> literalSimpleNameCS
--	notIteratorNorReservedSimpleNameCS -> reservedKeywordCS
	notIteratorNorReservedSimpleNameCS -> simpleIdentifierCS

	notLiteralNorReservedSimpleNameCS -> CollectionTypeIdentifierCS
	notLiteralNorReservedSimpleNameCS -> iterateNameCS
	notLiteralNorReservedSimpleNameCS -> iteratorNameCS
--	notLiteralNorReservedSimpleNameCS -> literalSimpleNameCS
--	notLiteralNorReservedSimpleNameCS -> reservedKeywordCS
	notLiteralNorReservedSimpleNameCS -> simpleIdentifierCS	-- IDENTIFIER, self, primitiveTypeCS

	notReservedSimpleNameCS -> notLiteralNorReservedSimpleNameCS
	notReservedSimpleNameCS -> literalSimpleNameCS

	pathNameCS ::= notReservedSimpleNameCS
		/.$BeginJava
					SimpleNameCS simpleName = (SimpleNameCS)$getSym(1);
					PathNameCS result = createPathNameCS(simpleName);
					setOffsets(result, simpleName);
					$setResult(result);
		  $EndJava
		./
	pathNameCS -> qualifiedPathNameCS

	qualifiedPathNameCS ::= pathNameCS '::' notReservedSimpleNameCS
		/.$BeginJava
					PathNameCS result = (PathNameCS)$getSym(1);
					SimpleNameCS simpleName = (SimpleNameCS)$getSym(3);
					result = extendPathNameCS(result, simpleName);
					setOffsets(result, result, simpleName);
					$setResult(result);
		  $EndJava
		./

-----------------------------------------------------------------------
--	Types
-----------------------------------------------------------------------
	primitiveTypeCS ::= Boolean
		/.$BeginJava
					CSTNode result = createPrimitiveTypeCS(
							SimpleTypeEnum.BOOLEAN_LITERAL,
							getTokenText($getToken(1))
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	primitiveTypeCS ::= Integer
		/.$BeginJava
					CSTNode result = createPrimitiveTypeCS(
							SimpleTypeEnum.INTEGER_LITERAL,
							getTokenText($getToken(1))
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	primitiveTypeCS ::= Real
		/.$BeginJava
					CSTNode result = createPrimitiveTypeCS(
							SimpleTypeEnum.REAL_LITERAL,
							getTokenText($getToken(1))
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	primitiveTypeCS ::= String
		/.$BeginJava
					CSTNode result = createPrimitiveTypeCS(
							SimpleTypeEnum.STRING_LITERAL,
							getTokenText($getToken(1))
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	primitiveTypeCS ::= UnlimitedNatural
		/.$BeginJava
					CSTNode result = createPrimitiveTypeCS(
							SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
							getTokenText($getToken(1))
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	primitiveTypeCS ::= OclAny
		/.$BeginJava
					CSTNode result = createPrimitiveTypeCS(
							SimpleTypeEnum.OCL_ANY_LITERAL,
							getTokenText($getToken(1))
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	primitiveTypeCS ::= OclInvalid
		/.$BeginJava
					CSTNode result = createPrimitiveTypeCS(
							SimpleTypeEnum.OCL_INVALID_LITERAL,
							getTokenText($getToken(1))
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	primitiveTypeCS ::= OclVoid
		/.$BeginJava
					CSTNode result = createPrimitiveTypeCS(
							SimpleTypeEnum.OCL_VOID_LITERAL,
							getTokenText($getToken(1))
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
		
	CollectionTypeIdentifierCS ::= Bag
		/.$BeginJava
					SimpleNameCS result = createCollectionTypeCS(
								CollectionTypeIdentifierEnum.BAG_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	CollectionTypeIdentifierCS ::= Collection
		/.$BeginJava
					SimpleNameCS result = createCollectionTypeCS(
								CollectionTypeIdentifierEnum.COLLECTION_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	CollectionTypeIdentifierCS ::= OrderedSet
		/.$BeginJava
					SimpleNameCS result = createCollectionTypeCS(
								CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	CollectionTypeIdentifierCS ::= Sequence
		/.$BeginJava
					SimpleNameCS result = createCollectionTypeCS(
								CollectionTypeIdentifierEnum.SEQUENCE_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	CollectionTypeIdentifierCS ::= Set
		/.$BeginJava
					SimpleNameCS result = createCollectionTypeCS(
								CollectionTypeIdentifierEnum.SET_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	collectionTypeCS ::= CollectionTypeIdentifierCS '(' typeCS ')'
		/.$BeginJava
					CollectionTypeCS result = (CollectionTypeCS)$getSym(1);
					result.setTypeCS((TypeCS)$getSym(3));
					setOffsets(result, result, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	tupleTypeCS ::= Tuple '(' variableDeclarationListCSopt ')'
		/.$BeginJava
					CSTNode result = createTupleTypeCS((EList)$getSym(3));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	typeCS ::= notReservedSimpleNameCS				-- covers primitiveTypeCS
		/.$BeginJava
					CSTNode result = (CSTNode)$getSym(1);
					if (!(result instanceof TypeCS)) {
						PathNameCS pathNameCS = createPathNameCS((SimpleNameCS)result);
						setOffsets(pathNameCS, result);
						result = pathNameCS;
					}
					$setResult(result);
		  $EndJava
		./
	typeCS -> qualifiedPathNameCS
	typeCS -> collectionTypeCS
	typeCS -> tupleTypeCS

-----------------------------------------------------------------------
--	Declarations
-----------------------------------------------------------------------
	-- notReservedSimpleNameCS is expanded to avoid a shift-reduce conflict between
	-- and VariableDeclarationCS and OclExpressionCS as an iteratorName argument
	variableNameCS -> BooleanLiteralExpCS
	variableNameCS -> InvalidLiteralExpCS
	variableNameCS -> NullLiteralExpCS
	variableNameCS -> notLiteralNorReservedSimpleNameCS
	
	-- variableNameCS is expanded to avoid a shift-reduce conflict between
	-- and QVTr's templateCS and OclExpressionCS
	typedVariableCS ::= BooleanLiteralExpCS ':' typeCS
		/.$NewCase./
	typedVariableCS ::= InvalidLiteralExpCS ':' typeCS
		/.$NewCase./
	typedVariableCS ::= NullLiteralExpCS ':' typeCS
		/.$NewCase./
	typedVariableCS ::= notLiteralNorReservedSimpleNameCS ':' typeCS
		/.$BeginJava
					SimpleNameCS name = (SimpleNameCS)$getSym(1);
					TypeCS type = (TypeCS)$getSym(3);
					VariableCS result = createVariableCS(name, type, null);
					setOffsets(result, name, type);
					$setResult(result);
		  $EndJava
		./
		
	VariableDeclarationCS ::= variableNameCS
		/.$BeginJava
					SimpleNameCS name = (SimpleNameCS)$getSym(1);
					CSTNode result = createVariableCS(name, null, null);
					setOffsets(result, name);
					$setResult(result);
		  $EndJava
		./
	VariableDeclarationCS -> typedVariableCS
	VariableDeclarationCS ::= typedVariableCS '=' OclExpressionCS
		/.$BeginJava
					VariableCS result = (VariableCS)$getSym(1);
					OCLExpressionCS initExpression = (OCLExpressionCS)$getSym(3);
					result.setInitExpression(initExpression);
					setOffsets(result, result, initExpression);
					$setResult(result);
		  $EndJava
		./
	
	variableDeclarationListCS ::= VariableDeclarationCS 
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	variableDeclarationListCS ::= variableDeclarationListCS ',' VariableDeclarationCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./

	variableDeclarationListCSopt ::= $empty
		/.$EmptyListAction./
	variableDeclarationListCSopt -> variableDeclarationListCS

-----------------------------------------------------------------------
--	Literals
-----------------------------------------------------------------------
	BooleanLiteralExpCS ::= false
		/.$BeginJava
					CSTNode result = createBooleanLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	BooleanLiteralExpCS ::= true
		/.$BeginJava
					CSTNode result = createBooleanLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	IntegerLiteralExpCS ::= INTEGER_LITERAL
		/.$BeginJava
					CSTNode result = createIntegerLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	InvalidLiteralExpCS ::= invalid
		/.$BeginJava
					CSTNode result = createInvalidLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	NullLiteralExpCS ::= null
		/.$BeginJava
					CSTNode result = createNullLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	RealLiteralExpCS ::= REAL_LITERAL
		/.$BeginJava
					CSTNode result = createRealLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	StringLiteralExpCS ::= STRING_LITERAL
		/.$BeginJava
					IToken literalToken = getIToken($getToken(1));
					StringLiteralExpCS result = createStringLiteralExpCS(literalToken.toString());
					result.setUnescapedStringSymbol(unescape(literalToken));
					setOffsets(result, literalToken);
					$setResult(result);
		  $EndJava
		./

	UnlimitedNaturalLiteralExpCS ::= '*'
		/.$BeginJava
					CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	PrimitiveLiteralExpCS -> BooleanLiteralExpCS
	PrimitiveLiteralExpCS -> IntegerLiteralExpCS
	PrimitiveLiteralExpCS -> RealLiteralExpCS
	PrimitiveLiteralExpCS -> StringLiteralExpCS
	PrimitiveLiteralExpCS -> UnlimitedNaturalLiteralExpCS

	CollectionLiteralExpCS ::= CollectionTypeIdentifierCS '{' CollectionLiteralPartsCSopt '}'
		/.$BeginJava
					CollectionTypeCS typeCS = (CollectionTypeCS)$getSym(1);
					CSTNode result = createCollectionLiteralExpCS(
							typeCS,
							(EList)$getSym(3)
						);
					setOffsets(result, typeCS, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	CollectionRangeCS ::= OclExpressionCS '..' OclExpressionCS
		/.$BeginJava
					CSTNode result = createCollectionRangeCS(
							(OCLExpressionCS)$getSym(1),
							(OCLExpressionCS)$getSym(3)
						);
					setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./

	CollectionLiteralPartCS -> CollectionRangeCS
	CollectionLiteralPartCS ::= OclExpressionCS
		/.$BeginJava
					CSTNode result = createCollectionLiteralPartCS(
							(OCLExpressionCS)$getSym(1)
						);
					setOffsets(result, (CSTNode)$getSym(1));
					$setResult(result);
		  $EndJava
		./

	CollectionLiteralPartsCS ::= CollectionLiteralPartCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	CollectionLiteralPartsCS ::= CollectionLiteralPartsCS ',' CollectionLiteralPartCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./

	CollectionLiteralPartsCSopt ::= $empty
		/.$EmptyListAction./
	CollectionLiteralPartsCSopt -> CollectionLiteralPartsCS

	TupleLiteralExpCS ::= Tuple '{' TupleLiteralPartsCS '}'
		/.$BeginJava
					CSTNode result = createTupleLiteralExpCS((EList)$getSym(3));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	TupleLiteralPartCS ::= variableNameCS '=' OclExpressionCS
		/.$BeginJava
					SimpleNameCS name = (SimpleNameCS)$getSym(1);
					OCLExpressionCS initExpression = (OCLExpressionCS)$getSym(3);
					VariableCS result = createVariableCS(name, null, initExpression);
					setOffsets(result, name, initExpression);
					$setResult(result);
		  $EndJava
		./
	TupleLiteralPartCS ::= typedVariableCS '=' OclExpressionCS
		/.$BeginJava
					VariableCS result = (VariableCS)$getSym(1);
					OCLExpressionCS initExpression = (OCLExpressionCS)$getSym(3);
					result.setInitExpression(initExpression);
					setOffsets(result, result, initExpression);
					$setResult(result);
		  $EndJava
		./

	TupleLiteralPartsCS ::= TupleLiteralPartCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	TupleLiteralPartsCS ::= TupleLiteralPartsCS ',' TupleLiteralPartCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./

	LiteralExpCS -> CollectionLiteralExpCS
-- EnumLiteralExpCS is parsed as a PropertyCallExpCS[C]
--	LiteralExpCS -> EnumLiteralExpCS
	LiteralExpCS -> InvalidLiteralExpCS
	LiteralExpCS -> NullLiteralExpCS
	LiteralExpCS -> PrimitiveLiteralExpCS
	LiteralExpCS -> TupleLiteralExpCS

-----------------------------------------------------------------------
--	Calls
-----------------------------------------------------------------------
	OperationCallExpCS ::= primaryExpCS '->' notIteratorNorReservedSimpleNameCS isMarkedPreCSopt '(' argumentsCSopt ')'
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					CSTNode result = createArrowOperationCallExpCS(
							source,
							(SimpleNameCS)$getSym(3),
							(IsMarkedPreCS)$getSym(4),
							(EList)$getSym(6)
						);
					setOffsets(result, source, getIToken($getToken(7)));
					$setResult(result);
		  $EndJava
		./
	OperationCallExpCS ::= primaryExpCS '.' binaryKeywordCS isMarkedPreCSopt '(' argumentsCSopt ')'
		/.$NewCase./
	OperationCallExpCS ::= primaryExpCS '.' unaryKeywordCS isMarkedPreCSopt '(' argumentsCSopt ')'
		/.$NewCase./
	OperationCallExpCS ::= primaryExpCS '.' reservedPunctuationCS isMarkedPreCSopt '(' argumentsCSopt ')'
		/.$NewCase./
	OperationCallExpCS ::= primaryExpCS '.' notReservedSimpleNameCS isMarkedPreCSopt '(' argumentsCSopt ')'
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					CSTNode result = createDotOperationCallExpCS(
							source,
							null,
							(SimpleNameCS)$getSym(3),
							(IsMarkedPreCS)$getSym(4),
							(EList)$getSym(6)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
					$setResult(result);
		  $EndJava
		./
	OperationCallExpCS ::= literalSimpleNameCS isMarkedPreCSopt '(' argumentsCSopt ')'
		/.$NewCase./
	OperationCallExpCS ::= notLiteralNorReservedSimpleNameCS isMarkedPreCSopt '(' argumentsCSopt ')'
		/.$BeginJava
					CSTNode result = createDotOperationCallExpCS(
							null,
							null,
							(SimpleNameCS)$getSym(1),
							(IsMarkedPreCS)$getSym(2),
							(EList)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	OperationCallExpCS ::= qualifiedPathNameCS '(' argumentsCSopt ')'
		/.$BeginJava
					PathNameCS pathNameCS = (PathNameCS)$getSym(1);
					SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
					OperationCallExpCS result = createDotOperationCallExpCS(
							null,
							pathNameCS,
							simpleNameCS,
							null,
							(EList)$getSym(3)
						);
					setOffsets(result, pathNameCS, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	OperationCallExpCS ::= primaryExpCS '.' qualifiedPathNameCS isMarkedPreCSopt '(' argumentsCSopt ')'
		/.$BeginJava
					PathNameCS pathNameCS = (PathNameCS)$getSym(3);
					SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					CallExpCS result = createDotOperationCallExpCS(
							source,
							pathNameCS,
							simpleNameCS,
							(IsMarkedPreCS)$getSym(4),
							(EList)$getSym(6)
						);
					setOffsets(result, source, getIToken($getToken(7)));
					$setResult(result);
		  $EndJava
		./	

	argumentsCS ::= OclExpressionCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	argumentsCS ::= argumentsCS ',' OclExpressionCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./

	argumentsCSopt ::= $empty
		/.$EmptyListAction./
	argumentsCSopt -> argumentsCS

	isMarkedPreCSopt ::= $empty
		/.$BeginJava
					$setResult(null);
		  $EndJava
		./

	PropertyCallExpCS ::= primaryExpCS '.' notReservedSimpleNameCS isMarkedPreCSopt
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(3);
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)$getSym(4);
					CSTNode result = createFeatureCallExpCS(
							source,
							null,
							simpleNameCS,
							new BasicEList(),
							isMarkedPreCS
						);
					if (isMarkedPreCS != null) {
						setOffsets(result, source, isMarkedPreCS);
					} else {
						setOffsets(result, source, simpleNameCS);
					}
					$setResult(result);
		  $EndJava
		./
	PropertyCallExpCS ::= primaryExpCS '.' qualifiedPathNameCS isMarkedPreCSopt
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					PathNameCS pathNameCS = (PathNameCS)$getSym(3);
					SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)$getSym(4);
					CSTNode result = createFeatureCallExpCS(
							source,
							pathNameCS,
							simpleNameCS,
							new BasicEList(),
							isMarkedPreCS
						);
					if (isMarkedPreCS != null) {
						setOffsets(result, source, isMarkedPreCS);
					} else {
						setOffsets(result, source, simpleNameCS);
					}
					$setResult(result);
		  $EndJava
		./
	PropertyCallExpCS ::= primaryExpCS '.' pathNameCS '[' argumentsCS ']' isMarkedPreCSopt
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					PathNameCS pathNameCS = (PathNameCS)$getSym(3);
					SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)$getSym(7);
					CSTNode result = createFeatureCallExpCS(
							source,
							pathNameCS,
							simpleNameCS,
							(EList)$getSym(5),
							isMarkedPreCS
						);
					if (isMarkedPreCS != null) {
						setOffsets(result, source, isMarkedPreCS);
					} else {
						setOffsets(result, source, getIToken($getToken(6)));
					}
					$setResult(result);
		  $EndJava
		./
-- A PropertyCallExpCS[B] is parsed as an AssociationClassCallExpCS
--	PropertyCallExpCS ::= notReservedSimpleNameCS isMarkedPreCSopt
	PropertyCallExpCS ::= qualifiedPathNameCS isMarkedPreCSopt
		/.$BeginJava
					PathNameCS pathNameCS = (PathNameCS)$getSym(1);
					SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)$getSym(2);
					CSTNode result = createFeatureCallExpCS(
							null,
							pathNameCS,
							simpleNameCS,
							new BasicEList(),
							isMarkedPreCS
						);
					if (isMarkedPreCS != null) {
						setOffsets(result, pathNameCS, isMarkedPreCS);
					} else {
						setOffsets(result, pathNameCS, simpleNameCS);
					}
					$setResult(result);
		  $EndJava
		./

	AssociationClassCallExpCS ::= notLiteralNorReservedSimpleNameCS isMarkedPreCSopt
		/.$BeginJava
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)$getSym(2);
					CSTNode result = createVariableExpCS(
							(SimpleNameCS)$getSym(1),
							new BasicEList(),
							isMarkedPreCS
						);
					if (isMarkedPreCS != null) {
						setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(2));
					} else {
						setOffsets(result, (CSTNode)$getSym(1));
					}
					$setResult(result);
		  $EndJava
		./
	AssociationClassCallExpCS ::= notReservedSimpleNameCS '[' argumentsCS ']' isMarkedPreCSopt
		/.$BeginJava
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)$getSym(5);
					CSTNode result = createVariableExpCS(
							(SimpleNameCS)$getSym(1),
							(EList)$getSym(3),
							isMarkedPreCS
						);
					if (isMarkedPreCS != null) {
						setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(5));
					} else {
						setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(4)));
					}
					$setResult(result);
		  $EndJava
		./
			
	FeatureCallExpCS -> OperationCallExpCS
	FeatureCallExpCS -> PropertyCallExpCS
	FeatureCallExpCS -> AssociationClassCallExpCS

	IterateExpCS ::= primaryExpCS '->' iterateNameCS '(' VariableDeclarationCS '|' OclExpressionCS ')'
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(3);
					CSTNode result = createIterateExpCS(
							source,
							simpleNameCS,
							(VariableCS)$getSym(5),
							null,
							(OCLExpressionCS)$getSym(7)
						);
					setOffsets(result, source, getIToken($getToken(8)));
					$setResult(result);
		  $EndJava
		./
	IterateExpCS ::= primaryExpCS '->' iterateNameCS '(' VariableDeclarationCS ';' VariableDeclarationCS '|' OclExpressionCS ')'
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(3);
					CSTNode result = createIterateExpCS(
							source,
							simpleNameCS,
							(VariableCS)$getSym(5),
							(VariableCS)$getSym(7),
							(OCLExpressionCS)$getSym(9)
						);
					setOffsets(result, source, getIToken($getToken(10)));
					$setResult(result);
		  $EndJava
		./

	IteratorExpCS ::= primaryExpCS '->' iteratorNameCS '(' OclExpressionCS ')'
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(3);
					CSTNode result = createIteratorExpCS(
							source,
							simpleNameCS,
							null,
							null,
							(OCLExpressionCS)$getSym(5)
						);
					setOffsets(result, source, getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./
	IteratorExpCS ::= primaryExpCS '->' iteratorNameCS '(' VariableDeclarationCS '|' OclExpressionCS ')'
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(3);
					CSTNode result = createIteratorExpCS(
							source,
							simpleNameCS,
							(VariableCS)$getSym(5),
							null,
							(OCLExpressionCS)$getSym(7)
						);
					setOffsets(result, source, getIToken($getToken(8)));
					$setResult(result);
		  $EndJava
		./
	IteratorExpCS ::= primaryExpCS '->' iteratorNameCS '(' VariableDeclarationCS ',' VariableDeclarationCS '|' OclExpressionCS ')'
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(3);
					CSTNode result = createIteratorExpCS(
							source,
							simpleNameCS,
							(VariableCS)$getSym(5),
							(VariableCS)$getSym(7),
							(OCLExpressionCS)$getSym(9)
						);
					setOffsets(result, source, getIToken($getToken(10)));
					$setResult(result);
		  $EndJava
		./

	LoopExpCS -> IterateExpCS
	LoopExpCS -> IteratorExpCS
	
	CallExpCS -> FeatureCallExpCS
	CallExpCS -> LoopExpCS

-----------------------------------------------------------------------
--	Expressions
-----------------------------------------------------------------------
	IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS endif
		/.$BeginJava
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							(OCLExpressionCS)$getSym(4),
							(OCLExpressionCS)$getSym(6)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
					$setResult(result);
		  $EndJava
		./

	LetExpCS ::= let variableDeclarationListCS in OclExpressionCS
		/.$BeginJava
					OCLExpressionCS expr = (OCLExpressionCS)$getSym(4);
					CSTNode result = createLetExpCS(
							(EList)$getSym(2),
							expr
						);
					setOffsets(result, getIToken($getToken(1)), expr);
					$setResult(result);
		  $EndJava
		./

	OclExpressionCS -> impliesExpCS
	OclExpressionCS -> impliesLetCS
	
	impliesExpCS -> xorExpCS
	impliesLetCS -> xorLetCS
	impliesExpCS ::= impliesExpCS implies xorExpCS
		/.$NewCase./
	impliesLetCS ::= impliesExpCS implies xorLetCS
		/.$NewCase./

	xorExpCS -> orExpCS
	xorLetCS -> orLetCS
	xorExpCS ::= xorExpCS xor orExpCS
		/.$NewCase./
	xorLetCS ::= xorExpCS xor orLetCS
		/.$NewCase./

	orExpCS -> andExpCS
	orLetCS -> andLetCS
	orExpCS ::= orExpCS or andExpCS
		/.$NewCase./
	orLetCS ::= orExpCS or andLetCS
		/.$NewCase./

	andExpCS -> equalityExpCS
	andLetCS -> equalityLetCS
	andExpCS ::= andExpCS and equalityExpCS
		/.$NewCase./
	andLetCS ::= andExpCS and equalityLetCS
		/.$NewCase./

	equalityExpCS -> relationalExpCS
	equalityLetCS -> relationalLetCS
	equalityExpCS ::= equalityExpCS '=' relationalExpCS
		/.$NewCase./
	equalityLetCS ::= equalityExpCS '=' relationalLetCS
		/.$NewCase./
	equalityExpCS ::= equalityExpCS '<>' relationalExpCS
		/.$NewCase./
	equalityLetCS ::= equalityExpCS '<>' relationalLetCS
		/.$NewCase./
	
	relationalExpCS -> additiveExpCS
	relationalLetCS -> additiveLetCS
	relationalExpCS ::= relationalExpCS '>' additiveExpCS
		/.$NewCase./
	relationalLetCS ::= relationalExpCS '>' additiveLetCS
		/.$NewCase./
	relationalExpCS ::= relationalExpCS '<' additiveExpCS
		/.$NewCase./
	relationalLetCS ::= relationalExpCS '<' additiveLetCS
		/.$NewCase./
	relationalExpCS ::= relationalExpCS '>=' additiveExpCS
		/.$NewCase./
	relationalLetCS ::= relationalExpCS '>=' additiveLetCS
		/.$NewCase./
	relationalExpCS ::= relationalExpCS '<=' additiveExpCS
		/.$NewCase./
	relationalLetCS ::= relationalExpCS '<=' additiveLetCS
		/.$NewCase./

	additiveExpCS -> multiplicativeExpCS
	additiveLetCS -> multiplicativeLetCS
	additiveExpCS ::= additiveExpCS '+' multiplicativeExpCS
		/.$NewCase./
	additiveLetCS ::= additiveExpCS '+' multiplicativeLetCS
		/.$NewCase./
	additiveExpCS ::= additiveExpCS '-' multiplicativeExpCS
		/.$NewCase./
	additiveLetCS ::= additiveExpCS '-' multiplicativeLetCS
		/.$NewCase./
	
	multiplicativeExpCS -> unaryExpCS
	multiplicativeLetCS -> unaryLetCS
	multiplicativeExpCS ::= multiplicativeExpCS '*' unaryExpCS
		/.$NewCase./
	multiplicativeLetCS ::= multiplicativeExpCS '*' unaryLetCS
		/.$NewCase./
	multiplicativeExpCS ::= multiplicativeExpCS '/' unaryExpCS
		/.$NewCase./
	multiplicativeLetCS ::= multiplicativeExpCS '/' unaryLetCS
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.STRING_LITERAL,
								getTokenText($getToken(2))
							);
					setOffsets(simpleNameCS, getIToken($getToken(2)));
					OCLExpressionCS left = (OCLExpressionCS)$getSym(1);
					OCLExpressionCS right = (OCLExpressionCS)$getSym(3);
					EList args = new BasicEList();
					args.add(right);
					CSTNode result = createOperationCallExpCS(
							left,
							simpleNameCS,
							args
						);
					setOffsets(result, left, right);
					$setResult(result);
		  $EndJava
		./
	
	unaryExpCS -> primaryExpCS
	unaryLetCS -> LetExpCS
	unaryExpCS ::= '-' unaryExpCS
		/.$NewCase./
	unaryLetCS ::= '-' unaryLetCS
		/.$NewCase./
	unaryExpCS ::= not unaryExpCS
		/.$NewCase./
	unaryLetCS ::= not unaryLetCS
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.STRING_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));
					OCLExpressionCS expr = (OCLExpressionCS)$getSym(2);
					CSTNode result = createOperationCallExpCS(
							expr,
							simpleNameCS,
							new BasicEList()
						);
					setOffsets(result, simpleNameCS, expr);
					$setResult(result);
		  $EndJava
		./

	primaryExpCS -> CallExpCS
	primaryExpCS -> IfExpCS
	primaryExpCS -> LiteralExpCS
	primaryExpCS ::= '(' OclExpressionCS ')'
		/.$BeginJava
					CSTNode result = (CSTNode)$getSym(2);
					if (result instanceof OperationCallExpCS) {
						((OperationCallExpCS)result).setIsAtomic(true);
					}
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
$End

$Trailers
	/.
		$EndActions
	}
	./
$End
