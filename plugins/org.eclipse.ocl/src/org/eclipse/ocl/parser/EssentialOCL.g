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
-- * $Id: EssentialOCL.g,v 1.14 2009/10/10 11:47:00 ewillink Exp $
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
 *   E.D.Willink - Bugs 184048, 225493, 243976, 259818, 282882, 287993, 288040
 *   Borland - Bug 242880
$copyright_contributions
 * </copyright>
 *
 * $Id: EssentialOCL.g,v 1.14 2009/10/10 11:47:00 ewillink Exp $
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
	import org.eclipse.ocl.cst.MessageExpCS;
	import org.eclipse.ocl.cst.OCLExpressionCS;
	import org.eclipse.ocl.cst.OCLMessageArgCS;
	import org.eclipse.ocl.cst.OperationCallExpCS;
	import org.eclipse.ocl.cst.PathNameCS;
	import org.eclipse.ocl.cst.SimpleNameCS;
	import org.eclipse.ocl.cst.SimpleTypeEnum;
	import org.eclipse.ocl.cst.StringLiteralExpCS;
	import org.eclipse.ocl.cst.TypeCS;
	import org.eclipse.ocl.cst.VariableCS;
	import org.eclipse.ocl.util.OCLStandardLibraryUtil;
	import org.eclipse.ocl.utilities.PredefinedType;
	
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
	
	-- CompleteOCL keywords
	body
	context
	def
	derive
	endpackage
	init
	inv
	package
	post
	pre
	static

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
	OclMessage

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
	ATPRE      ::= '@pre'

	CARET        ::= '^'
	CARETCARET   ::= '^^'
	QUESTIONMARK ::= '?'

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

	-- opt = optional
	-- m = multiple

	--
	-- Define a group of names that we define as keywords for the purpose
	-- of constructing an LPG grammar, but that are not reserved by OCL
	-- and are commonly used in models such as the UML metamodel, itself
	--
	
	binaryKeyword -> and
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

	reservedKeyword -> binaryKeyword
	reservedKeyword -> unaryKeyword
	-- Eliminate these for EssentialOCL
	reservedKeyword -> body
	reservedKeyword -> context
	reservedKeyword -> def
	reservedKeyword -> derive
	reservedKeyword -> endpackage
	reservedKeyword -> init
	reservedKeyword -> inv
	reservedKeyword -> package
	reservedKeyword -> post
	reservedKeyword -> pre
	reservedKeyword -> static

	reservedPunctuation -> binaryPunctuation
	reservedPunctuation -> unaryPunctuation

	iterateNameCS ::= iterateIdentifier
		/.$NewCase./
	iteratorNameCS ::= iteratorIdentifier
		/.$NewCase./
	reservedKeywordCS ::= reservedKeyword
		/.$NewCase./
	reservedPunctuationCS ::= reservedPunctuation
		/.$BeginJava
					SimpleNameCS result = createSimpleNameCS(
								SimpleTypeEnum.IDENTIFIER_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	literalSimpleNameCS -> booleanLiteralExpCS
	literalSimpleNameCS -> invalidLiteralExpCS
	literalSimpleNameCS -> nullLiteralExpCS
		
	notIteratorNorReservedSimpleNameCS -> collectionTypeIdentifierCS
--	notIteratorNorReservedSimpleNameCS -> iterateNameCS
--	notIteratorNorReservedSimpleNameCS -> iteratorNameCS
	notIteratorNorReservedSimpleNameCS -> literalSimpleNameCS
--	notIteratorNorReservedSimpleNameCS -> reservedKeywordCS
	notIteratorNorReservedSimpleNameCS -> simpleIdentifierCS

	notLiteralNorReservedSimpleNameCS -> collectionTypeIdentifierCS
	notLiteralNorReservedSimpleNameCS -> iterateNameCS
	notLiteralNorReservedSimpleNameCS -> iteratorNameCS
--	notLiteralNorReservedSimpleNameCS -> literalSimpleNameCS
--	notLiteralNorReservedSimpleNameCS -> reservedKeywordCS
	notLiteralNorReservedSimpleNameCS -> simpleIdentifierCS	-- IDENTIFIER, self, primitiveTypeCS

	notReservedSimpleNameCS -> notLiteralNorReservedSimpleNameCS
	notReservedSimpleNameCS -> literalSimpleNameCS

	simpleNameCS -> notReservedSimpleNameCS
	simpleNameCS -> reservedKeywordCS
	
	operationOrNotReservedSimpleNameCS -> notReservedSimpleNameCS
	operationOrNotReservedSimpleNameCS -> reservedKeywordCS
	operationOrNotReservedSimpleNameCS -> reservedPunctuationCS

	--
	-- the 'operationCS' non-terminal is not referenced in this grammar
	--
	operationCS -> operationCS1
	operationCS -> operationCS2
	operationCS1 ::= notReservedSimpleNameCS '(' variableListCSopt ')' ':' typeCSopt
		/.$BeginJava
					CSTNode result = createOperationCS(
							getTokenText($getToken(1)),
							(EList)$getSym(3),
							(TypeCS)$getSym(6)
						);
					if ($getSym(6) != null) {
						setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(6));
					} else {
						setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					}
					$setResult(result);
		  $EndJava
		./
	operationCS2 ::= qualifiedPathNameCS '(' variableListCSopt ')' ':' typeCSopt
		/.$BeginJava
					PathNameCS pathNameCS = (PathNameCS)$getSym(1);
					TypeCS typeCS = (TypeCS)$getSym(6);
					CSTNode result = createOperationCS(
							pathNameCS,
							removeLastSimpleNameCS(pathNameCS),
							(EList)$getSym(3),
							typeCS
						);
					if (typeCS != null) {
						setOffsets(result, pathNameCS, typeCS);
					} else {
						setOffsets(result, pathNameCS, getIToken($getToken(5)));
					}
					$setResult(result);
		  $EndJava
		./

	simpleNameCSopt ::= $empty
		/.$NullAction./
	simpleNameCSopt -> simpleNameCS	

	oclExpressionCS -> impliesExpCS
	oclExpressionCS -> impliesWithLet
	
	impliesExpCS -> xorExpCS
	impliesWithLet -> xorWithLet
	impliesExpCS ::= impliesExpCS implies xorExpCS
		/.$NewCase./
	impliesWithLet ::= impliesExpCS implies xorWithLet
		/.$NewCase./

	xorExpCS -> orExpCS
	xorWithLet -> orWithLet
	xorExpCS ::= xorExpCS xor orExpCS
		/.$NewCase./
	xorWithLet ::= xorExpCS xor orWithLet
		/.$NewCase./

	orExpCS -> andExpCS
	orWithLet -> andWithLet
	orExpCS ::= orExpCS or andExpCS
		/.$NewCase./
	orWithLet ::= orExpCS or andWithLet
		/.$NewCase./

	andExpCS -> equalityExpCS
	andWithLet -> equalityWithLet
	andExpCS ::= andExpCS and equalityExpCS
		/.$NewCase./
	andWithLet ::= andExpCS and equalityWithLet
		/.$NewCase./

	equalityExpCS -> relationalExpCS
	equalityWithLet -> relationalWithLet
	equalityExpCS ::= equalityExpCS '=' relationalExpCS
		/.$NewCase./
	equalityWithLet ::= equalityExpCS '=' relationalWithLet
		/.$NewCase./
	equalityExpCS ::= equalityExpCS '<>' relationalExpCS
		/.$NewCase./
	equalityWithLet ::= equalityExpCS '<>' relationalWithLet
		/.$NewCase./
	
	relationalExpCS -> additiveExpCS
	relationalWithLet -> additiveWithLet
	relationalExpCS ::= relationalExpCS '>' additiveExpCS
		/.$NewCase./
	relationalWithLet ::= relationalExpCS '>' additiveWithLet
		/.$NewCase./
	relationalExpCS ::= relationalExpCS '<' additiveExpCS
		/.$NewCase./
	relationalWithLet ::= relationalExpCS '<' additiveWithLet
		/.$NewCase./
	relationalExpCS ::= relationalExpCS '>=' additiveExpCS
		/.$NewCase./
	relationalWithLet ::= relationalExpCS '>=' additiveWithLet
		/.$NewCase./
	relationalExpCS ::= relationalExpCS '<=' additiveExpCS
		/.$NewCase./
	relationalWithLet ::= relationalExpCS '<=' additiveWithLet
		/.$NewCase./

	additiveExpCS -> multiplicativeExpCS
	additiveWithLet -> multiplicativeWithLet
	additiveExpCS ::= additiveExpCS '+' multiplicativeExpCS
		/.$NewCase./
	additiveWithLet ::= additiveExpCS '+' multiplicativeWithLet
		/.$NewCase./
	additiveExpCS ::= additiveExpCS '-' multiplicativeExpCS
		/.$NewCase./
	additiveWithLet ::= additiveExpCS '-' multiplicativeWithLet
		/.$NewCase./
	
	multiplicativeExpCS -> unaryExpCS
	multiplicativeWithLet -> unaryWithLet
	multiplicativeExpCS ::= multiplicativeExpCS '*' unaryExpCS
		/.$NewCase./
	multiplicativeWithLet ::= multiplicativeExpCS '*' unaryWithLet
		/.$NewCase./
	multiplicativeExpCS ::= multiplicativeExpCS '/' unaryExpCS
		/.$NewCase./
	multiplicativeWithLet ::= multiplicativeExpCS '/' unaryWithLet
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.STRING_LITERAL,
								getTokenText($getToken(2))
							);
					setOffsets(simpleNameCS, getIToken($getToken(2)));
					EList args = new BasicEList();
					args.add($getSym(3));
					CSTNode result = createOperationCallExpCS(
							(OCLExpressionCS)$getSym(1),
							simpleNameCS,
							args
						);
					setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./
	
	unaryExpCS -> dotArrowExpCS
	unaryWithLet -> letExpCS
	unaryExpCS ::= '-' unaryExpCS
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.STRING_LITERAL,
								OCLStandardLibraryUtil.getOperationName(PredefinedType.MINUS)
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));
					CSTNode result = createOperationCallExpCS(
							(OCLExpressionCS)$getSym(2),
							simpleNameCS,
							new BasicEList()
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(2));
					$setResult(result);
		  $EndJava
		./
	unaryExpCS ::= not unaryExpCS
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.STRING_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));
					CSTNode result = createOperationCallExpCS(
							(OCLExpressionCS)$getSym(2),
							simpleNameCS,
							new BasicEList()
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(2));
					$setResult(result);
		  $EndJava
		./

	dotArrowExpCS -> oclExpCS
	dotArrowExpCS -> callExpCS
	dotArrowExpCS -> oclMessageExpCS

	oclExpCS -> ifExpCS
	oclExpCS -> associationClassCallExpCS
	oclExpCS -> literalExpCS
	oclExpCS -> operationCallExpCS_DF
	oclExpCS -> operationCallExpCS_G

	oclExpCS ::= '(' oclExpressionCS ')'
		/.$BeginJava
					CSTNode result = (CSTNode)$getSym(2);
					if (result instanceof OperationCallExpCS) {
						((OperationCallExpCS)result).setIsAtomic(true);
					}
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./

	associationClassCallExpCS ::= notLiteralNorReservedSimpleNameCS isMarkedPreCSopt
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
	associationClassCallExpCS ::= notReservedSimpleNameCS '[' argumentsCS ']' isMarkedPreCSopt
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
	simpleIdentifierCS ::= IDENTIFIER
		/.$BeginJava
					CSTNode result = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
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
	primitiveTypeCS ::= OclMessage
		/.$BeginJava
					CSTNode result = createPrimitiveTypeCS(
							SimpleTypeEnum.OCL_MESSAGE_LITERAL,
							getTokenText($getToken(1))
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	pathNameCS ::= notReservedSimpleNameCS
		/.$BeginJava
					SimpleNameCS simpleName = (SimpleNameCS)$getSym(1);
					PathNameCS result = createPathNameCS(simpleName);
					setOffsets(result, simpleName);
					$setResult(result);
		  $EndJava
		./
	qualifiedPathNameCS ::= pathNameCS '::' notReservedSimpleNameCS
		/.$BeginJava
					PathNameCS result = (PathNameCS)$getSym(1);
					SimpleNameCS simpleName = (SimpleNameCS)$getSym(3);
					result = extendPathNameCS(result, simpleName);
					setOffsets(result, result, simpleName);
					$setResult(result);
		  $EndJava
		./
	pathNameCS -> qualifiedPathNameCS

	literalExpCS -> enumLiteralExpCS
	literalExpCS -> collectionLiteralExpCS
	literalExpCS -> tupleLiteralExpCS
	literalExpCS -> primitiveLiteralExpCS
	literalExpCS -> nullLiteralExpCS
	literalExpCS -> invalidLiteralExpCS

    -- also covers the case of static attribute call, in which
    --    case @pre is not allowed anyway
	enumLiteralExpCS ::= qualifiedPathNameCS
		/.$BeginJava
					PathNameCS pathNameCS = (PathNameCS)$getSym(1);
					SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
					CSTNode result = createEnumLiteralExpCS(
							pathNameCS,
							simpleNameCS
						);
					setOffsets(result, pathNameCS, simpleNameCS);
					$setResult(result);
		  $EndJava
		./

	collectionLiteralExpCS ::= collectionTypeIdentifierCS '{' collectionLiteralPartsCSopt '}'
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

	collectionTypeIdentifierCS ::= Set
		/.$BeginJava
					SimpleNameCS result = createCollectionTypeCS(
								CollectionTypeIdentifierEnum.SET_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	collectionTypeIdentifierCS ::= Bag
		/.$BeginJava
					SimpleNameCS result = createCollectionTypeCS(
								CollectionTypeIdentifierEnum.BAG_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	collectionTypeIdentifierCS ::= Sequence
		/.$BeginJava
					SimpleNameCS result = createCollectionTypeCS(
								CollectionTypeIdentifierEnum.SEQUENCE_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	collectionTypeIdentifierCS ::= Collection
		/.$BeginJava
					SimpleNameCS result = createCollectionTypeCS(
								CollectionTypeIdentifierEnum.COLLECTION_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	collectionTypeIdentifierCS ::= OrderedSet
		/.$BeginJava
					SimpleNameCS result = createCollectionTypeCS(
								CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	collectionLiteralPartsCSopt ::= $empty
		/.$EmptyListAction./
	collectionLiteralPartsCSopt -> collectionLiteralPartsCS

	collectionLiteralPartsCS ::= collectionLiteralPartCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	collectionLiteralPartsCS ::= collectionLiteralPartsCS ',' collectionLiteralPartCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./

	collectionLiteralPartCS -> collectionRangeCS
	collectionLiteralPartCS ::= oclExpressionCS
		/.$BeginJava
					CSTNode result = createCollectionLiteralPartCS(
							(OCLExpressionCS)$getSym(1)
						);
					setOffsets(result, (CSTNode)$getSym(1));
					$setResult(result);
		  $EndJava
		./

	collectionRangeCS ::= oclExpressionCS '..' oclExpressionCS
		/.$BeginJava
					CSTNode result = createCollectionRangeCS(
							(OCLExpressionCS)$getSym(1),
							(OCLExpressionCS)$getSym(3)
						);
					setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./

	primitiveLiteralExpCS -> integerLiteralExpCS
	primitiveLiteralExpCS -> unlimitedNaturalLiteralExpCS
	primitiveLiteralExpCS -> realLiteralExpCS
	primitiveLiteralExpCS -> stringLiteralExpCS
	primitiveLiteralExpCS -> booleanLiteralExpCS

	tupleLiteralExpCS ::= Tuple '{' variableListCS2 '}'
		/.$BeginJava
					CSTNode result = createTupleLiteralExpCS((EList)$getSym(3));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	integerLiteralExpCS ::= INTEGER_LITERAL
		/.$BeginJava
					CSTNode result = createIntegerLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	unlimitedNaturalLiteralExpCS ::= '*'
		/.$BeginJava
					CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	realLiteralExpCS ::= REAL_LITERAL
		/.$BeginJava
					CSTNode result = createRealLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	stringLiteralExpCS ::= STRING_LITERAL
		/.$BeginJava
					IToken literalToken = getIToken($getToken(1));
					StringLiteralExpCS result = createStringLiteralExpCS(literalToken.toString());
					result.setUnescapedStringSymbol(unescape(literalToken));
					setOffsets(result, literalToken);
					$setResult(result);
		  $EndJava
		./
	booleanLiteralExpCS ::= true
		/.$BeginJava
					CSTNode result = createBooleanLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	booleanLiteralExpCS ::= false
		/.$BeginJava
					CSTNode result = createBooleanLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	nullLiteralExpCS ::= null
		/.$BeginJava
					CSTNode result = createNullLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	invalidLiteralExpCS ::= invalid
		/.$BeginJava
					CSTNode result = createInvalidLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	callExpCS -> loopExpCS
	callExpCS -> propertyCallExpCS
	callExpCS -> operationCallExpCS_B
	callExpCS -> operationCallExpCS_CE
	callExpCS -> operationCallExpCS_IJ

	loopExpCS -> iteratorExpCS
	loopExpCS -> iterateExpCS

	iteratorExpCS ::= dotArrowExpCS '->' iteratorNameCS '(' oclExpressionCS ')'
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
	iteratorExpCS ::= dotArrowExpCS '->' iteratorNameCS '(' variableCS '|' oclExpressionCS ')'
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
	iteratorExpCS ::= dotArrowExpCS '->' iteratorNameCS '(' variableCS ',' variableCS '|' oclExpressionCS ')'
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

	iterateExpCS ::= dotArrowExpCS '->' iterateNameCS '(' variableCS '|' oclExpressionCS ')'
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
	iterateExpCS ::= dotArrowExpCS '->' iterateNameCS '(' variableCS ';' variableCS '|' oclExpressionCS ')'
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
	
	-- Merging these as notReservedSimpleNameCS gives conflicts; why? LPG bug ??
	variableNameCS ::= booleanLiteralExpCS
		/.$NewCase./
	variableNameCS ::= invalidLiteralExpCS
		/.$NewCase./
	variableNameCS ::= nullLiteralExpCS
		/.$NewCase./
	variableNameCS ::= notLiteralNorReservedSimpleNameCS
		/.$BeginJava
					SimpleNameCS name = (SimpleNameCS)$getSym(1);
					CSTNode result = createVariableCS(name.getValue());
					setOffsets(result, name);
					$setResult(result);
		  $EndJava
		./
	typedVariableCS ::= variableNameCS ':' typeCS
		/.$BeginJava
					VariableCS result = (VariableCS)$getSym(1);
					TypeCS type = (TypeCS)$getSym(3);
					result.setTypeCS(type);
					setOffsets(result, result, type);
					$setResult(result);
		  $EndJava
		./
	variableCS -> variableNameCS
	variableCS -> typedVariableCS
	variableCS2 -> variableCS
	-- this form of variable declaration is only used in tuple literals
	variableCS2 ::= variableNameCS '=' oclExpressionCS
		/.$NewCase./
	variableCS ::= typedVariableCS '=' oclExpressionCS
		/.$BeginJava
					VariableCS result = (VariableCS)$getSym(1);
					OCLExpressionCS initExpression = (OCLExpressionCS)$getSym(3);
					result.setInitExpression(initExpression);
					setOffsets(result, result, initExpression);
					$setResult(result);
		  $EndJava
		./

	typeCSopt ::= $empty
		/.$NullAction./
	typeCSopt -> typeCS

	typeCS -> tupleTypeCS
	typeCS -> collectionTypeCS
	typeCS -> qualifiedPathNameCS
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

	collectionTypeCS ::= collectionTypeIdentifierCS '(' typeCS ')'
		/.$BeginJava
					CollectionTypeCS result = (CollectionTypeCS)$getSym(1);
					result.setTypeCS((TypeCS)$getSym(3));
					setOffsets(result, result, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	tupleTypeCS ::= Tuple '(' variableListCSopt ')'
		/.$BeginJava
					CSTNode result = createTupleTypeCS((EList)$getSym(3));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	
	variableListCSopt ::= $empty
		/.$EmptyListAction./
	variableListCSopt -> variableListCS
	variableListCS2 ::= variableCS2
		/.$NewCase./
	variableListCS ::= variableCS 
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	variableListCS2 ::= variableListCS2 ',' variableCS2
		/.$NewCase./
	variableListCS ::= variableListCS ',' variableCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
	
	operationCallExpCS_B ::= dotArrowExpCS '->' notIteratorNorReservedSimpleNameCS isMarkedPreCSopt '(' argumentsCSopt ')'
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
	operationCallExpCS_CE ::= dotArrowExpCS '.' operationOrNotReservedSimpleNameCS isMarkedPreCSopt '(' argumentsCSopt ')'
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
	operationCallExpCS_DF ::= notReservedSimpleNameCS isMarkedPreCSopt '(' argumentsCSopt ')'
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
	operationCallExpCS_G ::=  qualifiedPathNameCS '(' argumentsCSopt ')'
		/.$BeginJava
					PathNameCS pathNameCS = (PathNameCS)$getSym(1);
					OperationCallExpCS result = createDotOperationCallExpCS(
							null,
							pathNameCS,
							removeLastSimpleNameCS(pathNameCS),
							null,
							(EList)$getSym(3)
						);
					setOffsets(result, pathNameCS, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	operationCallExpCS_IJ ::= dotArrowExpCS '.' qualifiedPathNameCS isMarkedPreCSopt '(' argumentsCSopt ')'
		/.$BeginJava
					PathNameCS pathNameCS = (PathNameCS)$getSym(3);
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					CallExpCS result = createDotOperationCallExpCS(
							source,
							pathNameCS,
							removeLastSimpleNameCS(pathNameCS),
							(IsMarkedPreCS)$getSym(4),
							(EList)$getSym(6)
						);
					setOffsets(result, source, getIToken($getToken(7)));
					$setResult(result);
		  $EndJava
		./		

	propertyCallExpCS ::= dotArrowExpCS '.' notReservedSimpleNameCS isMarkedPreCSopt
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)$getSym(4);
					CSTNode result = createFeatureCallExpCS(
							source,
							(SimpleNameCS)$getSym(3),
							new BasicEList(),
							isMarkedPreCS
						);
					if (isMarkedPreCS != null) {
						setOffsets(result, source, isMarkedPreCS);
					} else {
						setOffsets(result, source, (SimpleNameCS)$getSym(3));
					}
					$setResult(result);
		  $EndJava
		./
	propertyCallExpCS ::= dotArrowExpCS '.' notReservedSimpleNameCS '[' argumentsCS ']' isMarkedPreCSopt
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)$getSym(7);
					CSTNode result = createFeatureCallExpCS(
							source,
							(SimpleNameCS)$getSym(3),
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

	isMarkedPreCSopt ::= $empty
		/.$BeginJava
					$setResult(null);
		  $EndJava
		./
	isMarkedPreCSopt ::= '@pre'
		/.$BeginJava
					CSTNode result = createIsMarkedPreCS();
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	argumentsCSopt ::= $empty
		/.$EmptyListAction./
	argumentsCSopt -> argumentsCS

	argumentsCS ::= oclExpressionCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	argumentsCS ::= argumentsCS ',' oclExpressionCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./

	letExpCS ::= let variableListCS in oclExpressionCS
		/.$BeginJava
					CSTNode result = createLetExpCS(
							(EList)$getSym(2),
							(OCLExpressionCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndJava
		./

	ifExpCS ::= if oclExpressionCS then oclExpressionCS else oclExpressionCS endif
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

	oclMessageExpCS ::= dotArrowExpCS '^' simpleNameCS '(' oclMessageArgumentsCSopt ')'
		/.$NewCase./
	oclMessageExpCS ::= dotArrowExpCS '^^' simpleNameCS '(' oclMessageArgumentsCSopt ')'
		/.$BeginJava
					OCLExpressionCS target = (OCLExpressionCS)$getSym(1);
					MessageExpCS result = createMessageExpCS(
							target,
							getIToken($getToken(2)).getKind() == $sym_type.TK_CARET,
							(SimpleNameCS)$getSym(3),
							(EList<OCLMessageArgCS>)$getSym(5)
						);
					setOffsets(result, target, getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./

	oclMessageArgumentsCSopt ::= $empty
		/.$EmptyListAction./
	oclMessageArgumentsCSopt -> oclMessageArgumentsCS

	oclMessageArgumentsCS ::= oclMessageArgCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	oclMessageArgumentsCS ::= oclMessageArgumentsCS ',' oclMessageArgCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./

	oclMessageArgCS ::= oclExpressionCS
		/.$BeginJava
					CSTNode result = createOCLMessageArgCS(
							null,
							(OCLExpressionCS)$getSym(1)
						);
					setOffsets(result, (CSTNode)$getSym(1));
					$setResult(result);
		  $EndJava
		./
	oclMessageArgCS ::= '?'
		/.$BeginJava
					CSTNode result = createOCLMessageArgCS(
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	oclMessageArgCS ::= '?' ':' typeCS
		/.$BeginJava
					CSTNode result = createOCLMessageArgCS(
							(TypeCS)$getSym(3),
							null
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
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
