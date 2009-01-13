--/**
-- * <copyright>
-- *
-- * Copyright (c) 2005, 2009 IBM Corporation, Zeligsoft Inc., and others.
-- * All rights reserved.   This program and the accompanying materials
-- * are made available under the terms of the Eclipse Public License v1.0
-- * which accompanies this distribution, and is available at
-- * http://www.eclipse.org/legal/epl-v10.html
-- *
-- * Contributors:
-- *   IBM - Initial API and implementation
-- *   E.D.Willink - Elimination of some shift-reduce conflicts
-- *   E.D.Willink - Remove unnecessary warning suppression
-- *   E.D.Willink - Bugs 225493, 243976, 259818
-- *   Zeligsoft - Bug 243976
-- *
-- * </copyright>
-- *
-- * $Id: EssentialOCL.g,v 1.5 2009/01/13 19:44:29 cdamus Exp $
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
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Elimination of some shift-reduce conflicts
 *   E.D.Willink - Remove unnecessary warning suppression
 *   E.D.Willink - Bugs 225493, 243976
 *   Zeligsoft - Bug 243976
$copyright_contributions
 * </copyright>
 *
 * $Id: EssentialOCL.g,v 1.5 2009/01/13 19:44:29 cdamus Exp $
 */
	./
$End

$Globals
	/.import org.eclipse.emf.common.util.BasicEList;
	import org.eclipse.emf.common.util.EList;
	import org.eclipse.ocl.cst.CSTNode;
	import org.eclipse.ocl.cst.CallExpCS;
	import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
	import org.eclipse.ocl.cst.DotOrArrowEnum;
	import org.eclipse.ocl.cst.IntegerLiteralExpCS;
	import org.eclipse.ocl.cst.IsMarkedPreCS;
	import org.eclipse.ocl.cst.MessageExpCS;
	import org.eclipse.ocl.cst.OCLExpressionCS;
	import org.eclipse.ocl.cst.OCLMessageArgCS;
	import org.eclipse.ocl.cst.OperationCallExpCS;
	import org.eclipse.ocl.cst.PathNameCS;
	import org.eclipse.ocl.cst.SimpleNameCS;
	import org.eclipse.ocl.cst.SimpleTypeEnum;
	import org.eclipse.ocl.cst.StateExpCS;
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
	self
	inv
	pre
	post
	endpackage
	def
	if
	then
	else
	endif
	and
	or
	xor
	not
	implies
	let
	in
	true
	false

	--
	-- the following appear to have been omitted from the list of
	-- OCL reserved words in Section 7.4.9.  They will be treated 
	-- as unreserved for compliance
	--
	body
	derive
	init
	null
--  return  -- don't need a keyword for LPG purposes

	--
	-- the remainder of the LPG keywords are defined as such for the
	-- purpose of constructing the CST grammar.  They are not OCL
	-- reserved words
	--		
	Set
	Bag
	Sequence
	Collection
	OrderedSet

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

	oclIsKindOf
	oclIsTypeOf
	oclAsType
	oclIsNew
	oclIsUndefined
	oclIsInvalid
	oclIsInState
	allInstances

	String
	Integer
	UnlimitedNatural
	Real
	Boolean
	Tuple
	OclAny
	OclVoid
	Invalid
	OclMessage
	
	OclInvalid
$End

$Identifier
	IDENTIFIER
$End

$Terminals
	
	NUMERIC_OPERATION

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
	
	binaryIdentifier -> oclIsUndefined
	binaryIdentifier -> oclIsInvalid
	binaryIdentifier -> oclIsNew
	binaryIdentifier -> oclAsType
	binaryIdentifier -> oclIsKindOf
	binaryIdentifier -> oclIsTypeOf
	binaryIdentifier -> EQUAL
	binaryIdentifier -> NOT_EQUAL
	binaryIdentifier -> PLUS
	binaryIdentifier -> MULTIPLY
	binaryIdentifier -> DIVIDE
	binaryIdentifier -> GREATER
	binaryIdentifier -> LESS
	binaryIdentifier -> GREATER_EQUAL
	binaryIdentifier -> LESS_EQUAL
	binaryIdentifier -> and
	binaryIdentifier -> or
	binaryIdentifier -> xor

	unaryIdentifier -> MINUS
	unaryIdentifier -> not

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

	keywordAsIdentifier1 -> iterate
	keywordAsIdentifier1 -> iteratorIdentifier
	keywordAsIdentifier1 -> allInstances
	keywordAsIdentifier1 -> body
	keywordAsIdentifier1 -> derive
	keywordAsIdentifier1 -> init
	keywordAsIdentifier1 -> Set
	keywordAsIdentifier1 -> Bag
	keywordAsIdentifier1 -> Sequence
	keywordAsIdentifier1 -> Collection
	keywordAsIdentifier1 -> OrderedSet
	--------
	keywordAsIdentifier -> keywordAsIdentifier1
	keywordAsIdentifier -> null

	binaryName -> simpleNameCS
	binaryName ::= binaryIdentifier
		/.$NewCase./
	keywordAsName ::= keywordAsIdentifier
		/.$NewCase./
	keywordAsName1 ::= keywordAsIdentifier1
		/.$NewCase./
	unaryName ::= unaryIdentifier
		/.$BeginJava
					SimpleNameCS result = createSimpleNameCS(
								SimpleTypeEnum.IDENTIFIER_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
		
	iterateName ::= iterate
		/.$NewCase./
	iteratorName ::= iteratorIdentifier
		/.$NewCase./
	oclIsInStateName ::= oclIsInState
		/.$BeginJava
					SimpleNameCS result = createSimpleNameCS(
								SimpleTypeEnum.KEYWORD_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	--
	-- the 'operationCS' non-terminal is not referenced in this grammar
	--
	operationCS -> operationCS1
	operationCS -> operationCS2
	operationCS1 ::= IDENTIFIER '(' parametersCSopt ')' ':' typeCSopt
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
	operationCS2 ::= pathNameCS '::' simpleNameCS '(' parametersCSopt ')' ':' typeCSopt
		/.$BeginJava
					CSTNode result = createOperationCS(
							(PathNameCS)$getSym(1),
							(SimpleNameCS)$getSym(3),
							(EList)$getSym(5),
							(TypeCS)$getSym(8)
						);
					if ($getSym(8) != null) {
						setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(8));
					} else {
						setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(7)));
					}
					$setResult(result);
		  $EndJava
		./


	parametersCSopt ::= $empty
		/.$EmptyListAction./
	parametersCSopt -> parametersCS
	parametersCS ::= variableCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	parametersCS ::= parametersCS ',' variableCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./

	simpleNameCSopt ::= $empty
		/.$NullAction./
	simpleNameCSopt -> simpleNameCS	

	oclExpressionCS -> impliesExpCS
	oclExpressionCS -> impliesWithLet
	
	impliesExpCS -> andOrXorExpCS
	impliesWithLet -> andOrXorWithLet
	impliesExpCS ::= impliesExpCS implies andOrXorExpCS
		/.$NewCase./
	impliesWithLet ::= impliesExpCS implies andOrXorWithLet
		/.$NewCase./

	andOrXorExpCS -> equalityExpCS
	andOrXorWithLet -> equalityWithLet
	andOrXorExpCS ::= andOrXorExpCS and equalityExpCS
		/.$NewCase./
	andOrXorExpCS ::= andOrXorExpCS or equalityExpCS
		/.$NewCase./
	andOrXorExpCS ::= andOrXorExpCS xor equalityExpCS
		/.$NewCase./
	andOrXorWithLet ::= andOrXorExpCS and equalityWithLet
		/.$NewCase./
	andOrXorWithLet ::= andOrXorExpCS or equalityWithLet
		/.$NewCase./
	andOrXorWithLet ::= andOrXorExpCS xor equalityWithLet
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

	equalityExpCS -> relationalExpCS
	equalityWithLet -> relationalWithLet
	equalityExpCS ::= equalityExpCS '=' relationalExpCS
		/.$NewCase./
	equalityWithLet ::= equalityExpCS '=' relationalWithLet
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.STRING_LITERAL,
								OCLStandardLibraryUtil.getOperationName(PredefinedType.EQUAL)
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
	equalityExpCS ::= equalityExpCS '<>' relationalExpCS
		/.$NewCase./
	equalityWithLet ::= equalityExpCS '<>' relationalWithLet
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.STRING_LITERAL,
								OCLStandardLibraryUtil.getOperationName(PredefinedType.NOT_EQUAL)
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
	
	relationalExpCS -> ifExpCSPrec
	-- Note that ifExp already embeds let, so we needn't deal with it here
	relationalWithLet -> additiveWithLet
	relationalExpCS ::= relationalExpCS '>' ifExpCSPrec
		/.$NewCase./
	relationalWithLet ::= relationalExpCS '>' additiveWithLet
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.STRING_LITERAL,
								OCLStandardLibraryUtil.getOperationName(PredefinedType.GREATER_THAN)
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
	relationalExpCS ::= relationalExpCS '<' ifExpCSPrec
		/.$NewCase./
	relationalWithLet ::= relationalExpCS '<' additiveWithLet
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.STRING_LITERAL,
								OCLStandardLibraryUtil.getOperationName(PredefinedType.LESS_THAN)
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
	relationalExpCS ::= relationalExpCS '>=' ifExpCSPrec
		/.$NewCase./
	relationalWithLet ::= relationalExpCS '>=' additiveWithLet
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.STRING_LITERAL,
								OCLStandardLibraryUtil.getOperationName(PredefinedType.GREATER_THAN_EQUAL)
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
	relationalExpCS ::= relationalExpCS '<=' ifExpCSPrec
		/.$NewCase./
	relationalWithLet ::= relationalExpCS '<=' additiveWithLet
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.STRING_LITERAL,
								OCLStandardLibraryUtil.getOperationName(PredefinedType.LESS_THAN_EQUAL)
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
	
	ifExpCSPrec -> additiveExpCS
	ifExpCSPrec -> ifExpCS

	additiveExpCS -> multiplicativeExpCS
	additiveWithLet -> multiplicativeWithLet
	additiveExpCS ::= additiveExpCS '+' multiplicativeExpCS
		/.$NewCase./
	additiveWithLet ::= additiveExpCS '+' multiplicativeWithLet
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.STRING_LITERAL,
								OCLStandardLibraryUtil.getOperationName(PredefinedType.PLUS)
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
	additiveExpCS ::= additiveExpCS '-' multiplicativeExpCS
		/.$NewCase./
	additiveWithLet ::= additiveExpCS '-' multiplicativeWithLet
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.STRING_LITERAL,
								OCLStandardLibraryUtil.getOperationName(PredefinedType.MINUS)
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
	
	multiplicativeExpCS -> unaryExpCS
	multiplicativeWithLet -> unaryWithLet
	multiplicativeExpCS ::= multiplicativeExpCS '*' unaryExpCS
		/.$NewCase./
	multiplicativeWithLet ::= multiplicativeExpCS '*' unaryWithLet
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.STRING_LITERAL,
								OCLStandardLibraryUtil.getOperationName(PredefinedType.TIMES)
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
	multiplicativeExpCS ::= multiplicativeExpCS '/' unaryExpCS
		/.$NewCase./
	multiplicativeWithLet ::= multiplicativeExpCS '/' unaryWithLet
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.STRING_LITERAL,
								OCLStandardLibraryUtil.getOperationName(PredefinedType.DIVIDE)
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
	dotArrowExpCS ::= dotArrowExpCS callExpCS
		/.$BeginJava
					CallExpCS result = (CallExpCS)$getSym(2);
					result.setSource((OCLExpressionCS)$getSym(1));
					setOffsets(result, (CSTNode)$getSym(1), result);
					$setResult(result);
		  $EndJava
		./
	dotArrowExpCS ::= dotArrowExpCS messageExpCS
		/.$BeginJava
					MessageExpCS result = (MessageExpCS)$getSym(2);
					result.setTarget((OCLExpressionCS)$getSym(1));
					setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(2));
					$setResult(result);
		  $EndJava
		./
	dotArrowExpCS ::= NUMERIC_OPERATION '(' argumentsCSopt ')'
		/.$BeginJava
					// NUMERIC_OPERATION -> Integer '.' Identifier
					String text = getTokenText(dtParser.getToken(1));
					int index = text.indexOf('.');
					String integer = text.substring(0, index);
					String simpleName = text.substring(index + 1);

					// create the IntegerLiteralExpCS
					IToken numericToken = getIToken($getToken(1));
					int startOffset = numericToken.getStartOffset();
					int endOffset = startOffset + integer.length() - 1; // inclusive

					IntegerLiteralExpCS integerLiteralExpCS = createIntegerLiteralExpCS(integer);
					integerLiteralExpCS.setStartOffset(startOffset);
					integerLiteralExpCS.setEndOffset(endOffset);
					integerLiteralExpCS.setStartToken(numericToken);
					integerLiteralExpCS.setEndToken(numericToken);

					startOffset = endOffset + 2; // end of integerLiteral + 1('.') + 1(start of simpleName)
					endOffset = getIToken($getToken(1)).getEndOffset();

					// create the SimpleNameCS
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.IDENTIFIER_LITERAL,
								simpleName
							);
					simpleNameCS.setStartOffset(startOffset);
					simpleNameCS.setEndOffset(endOffset);
					simpleNameCS.setStartToken(numericToken);
					simpleNameCS.setEndToken(numericToken);

					// create the OperationCallExpCS
					CSTNode result = createOperationCallExpCS(
							integerLiteralExpCS,
							simpleNameCS,
							(EList)$getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

    -- static operation call (@pre is not permitted in this context)
	dotArrowExpCS ::=  pathNameCS '::' simpleNameCS '(' argumentsCSopt ')'
		/.$BeginJava
					OperationCallExpCS result = createOperationCallExpCS(
							(PathNameCS)$getSym(1),
							(SimpleNameCS)$getSym(3),
							(EList)$getSym(5)
						);
					setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(6)));
					result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
					$setResult(result);
		  $EndJava
		./


	oclExpCS -> variableExpCS
	oclExpCS -> literalExpCS
	oclExpCS -> operationCallExpCS
	oclExpCS -> keywordOperationCallExpCS

	oclExpCS ::= '(' oclExpressionCS ')'
		/.$BeginJava
					CSTNode result = (CSTNode)$getSym(2);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./

	variableExpCS ::= simpleNameCS isMarkedPreCS
		/.$NewCase./
	variableExpCS ::= keywordAsName1 isMarkedPreCS
		/.$BeginJava
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)$getSym(2);
					CSTNode result = createVariableExpCS(
							(SimpleNameCS)$getSym(1),
							new BasicEList(),
							isMarkedPreCS
						);
					if (isMarkedPreCS.isPre()) {
						setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(2));
					} else {
						setOffsets(result, (CSTNode)$getSym(1));
					}
					$setResult(result);
		  $EndJava
		./
	variableExpCS ::= simpleNameCS '[' argumentsCS ']' isMarkedPreCS
		/.$NewCase./
	variableExpCS ::= keywordAsName1 '[' argumentsCS ']' isMarkedPreCS
		/.$BeginJava
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)$getSym(5);
					CSTNode result = createVariableExpCS(
							(SimpleNameCS)$getSym(1),
							(EList)$getSym(3),
							isMarkedPreCS
						);
					if (isMarkedPreCS.isPre()) {
						setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(5));
					} else {
						setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(4)));
					}
					$setResult(result);
		  $EndJava
		./


	simpleNameCS -> primitiveTypeCS
	simpleNameCS ::= self
		/.$BeginJava
					CSTNode result = createSimpleNameCS(
							SimpleTypeEnum.SELF_LITERAL,
							getTokenText($getToken(1))
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	simpleNameCS ::= IDENTIFIER
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
	primitiveTypeCS ::= Invalid
		/.$BeginJava
					CSTNode result = createPrimitiveTypeCS(
							SimpleTypeEnum.INVALID_LITERAL,
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

	pathNameCS ::= IDENTIFIER
		/.$BeginJava
					CSTNode result = createPathNameCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	pathNameCS ::= pathNameCS '::' simpleNameCS
		/.$BeginJava
					PathNameCS result = (PathNameCS)$getSym(1);
					result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
					setOffsets(result, result, (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./

	pathNameCSOpt ::= $empty
		/.$BeginJava
					CSTNode result = createPathNameCS();
					$setResult(result);
		  $EndJava
		./
	pathNameCSOpt -> pathNameCS

	literalExpCS -> enumLiteralExpCS
	literalExpCS -> collectionLiteralExpCS
	literalExpCS -> tupleLiteralExpCS
	literalExpCS -> primitiveLiteralExpCS
	literalExpCS -> nullLiteralExpCS
	literalExpCS -> invalidLiteralExpCS

    -- also covers the case of static attribute call, in which
    --    case @pre is not allowed anyway
	enumLiteralExpCS ::= pathNameCS '::' keywordAsName
		/.$NewCase./
	enumLiteralExpCS ::= pathNameCS '::' simpleNameCS
		/.$BeginJava
					CSTNode result = createEnumLiteralExpCS(
							(PathNameCS)$getSym(1),
							(SimpleNameCS)$getSym(3)
						);
					setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./

	collectionLiteralExpCS ::= collectionTypeIdentifierCS '{' collectionLiteralPartsCSopt '}'
		/.$BeginJava
					Object[] objs = (Object[])$getSym(1);
					CSTNode result = createCollectionLiteralExpCS(
							(CollectionTypeIdentifierEnum)objs[1],
							(EList)$getSym(3)
						);
					setOffsets(result, (IToken)objs[0], getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	collectionTypeIdentifierCS ::= Set
		/.$BeginJava
					$setResult(new Object[]{getIToken($getToken(1)), CollectionTypeIdentifierEnum.SET_LITERAL});
		  $EndJava
		./
	collectionTypeIdentifierCS ::= Bag
		/.$BeginJava
					$setResult(new Object[]{getIToken($getToken(1)), CollectionTypeIdentifierEnum.BAG_LITERAL});
		  $EndJava
		./
	collectionTypeIdentifierCS ::= Sequence
		/.$BeginJava
					$setResult(new Object[]{getIToken($getToken(1)), CollectionTypeIdentifierEnum.SEQUENCE_LITERAL});
		  $EndJava
		./
	collectionTypeIdentifierCS ::= Collection
		/.$BeginJava
					$setResult(new Object[]{getIToken($getToken(1)), CollectionTypeIdentifierEnum.COLLECTION_LITERAL});
		  $EndJava
		./
	collectionTypeIdentifierCS ::= OrderedSet
		/.$BeginJava
					$setResult(new Object[]{getIToken($getToken(1)), CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL});
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

	collectionRangeCS ::= '-' INTEGER_RANGE_START oclExpressionCS
		/.$BeginJava
					OCLExpressionCS rangeStart = createRangeStart(
							getTokenText($getToken(2)), true);
					CSTNode result = createCollectionRangeCS(
							rangeStart,
							(OCLExpressionCS)$getSym(3)
						);
					setOffsets(result, rangeStart, (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./
	collectionRangeCS ::= INTEGER_RANGE_START oclExpressionCS
		/.$BeginJava
					OCLExpressionCS rangeStart = createRangeStart(
							getTokenText($getToken(1)), false);
					CSTNode result = createCollectionRangeCS(
							rangeStart,
							(OCLExpressionCS)$getSym(2)
						);
					setOffsets(result, rangeStart, (CSTNode)$getSym(2));
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
					CSTNode result = createStringLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
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

	invalidLiteralExpCS ::= OclInvalid
		/.$BeginJava
					CSTNode result = createInvalidLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./


	callExpCS ::= '->' featureCallExpCS
		/.$NewCase./
	callExpCS ::= '->' loopExpCS
		/.$BeginJava
					CallExpCS result = (CallExpCS)$getSym(2);
					result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
					$setResult(result);
		  $EndJava
		./
	callExpCS ::= '.' keywordOperationCallExpCS
		/.$NewCase./
	callExpCS ::= '.' featureCallExpCS
		/.$BeginJava
					CallExpCS result = (CallExpCS)$getSym(2);
					result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
					$setResult(result);
		  $EndJava
		./

	loopExpCS -> iteratorExpCS
	loopExpCS -> iterateExpCS

	iteratorExpCS ::= iteratorName '(' oclExpressionCS ')'
		/.$BeginJava
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(1);
					CSTNode result = createIteratorExpCS(
							simpleNameCS,
							null,
							null,
							(OCLExpressionCS)$getSym(3)
						);
					setOffsets(result, simpleNameCS, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	iteratorExpCS ::= iteratorName '(' variableCS '|' oclExpressionCS ')'
		/.$BeginJava
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(1);
					CSTNode result = createIteratorExpCS(
							simpleNameCS,
							(VariableCS)$getSym(3),
							null,
							(OCLExpressionCS)$getSym(5)
						);
					setOffsets(result, simpleNameCS, getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./
	iteratorExpCS ::= iteratorName '(' variableCS ',' variableCS '|' oclExpressionCS ')'
		/.$BeginJava
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(1);
					CSTNode result = createIteratorExpCS(
							simpleNameCS,
							(VariableCS)$getSym(3),
							(VariableCS)$getSym(5),
							(OCLExpressionCS)$getSym(7)
						);
					setOffsets(result, simpleNameCS, getIToken($getToken(8)));
					$setResult(result);
		  $EndJava
		./

	iterateExpCS ::= iterateName '(' variableCS '|' oclExpressionCS ')'
		/.$BeginJava
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(1);
					CSTNode result = createIterateExpCS(
							simpleNameCS,
							(VariableCS)$getSym(3),
							null,
							(OCLExpressionCS)$getSym(5)
						);
					setOffsets(result, simpleNameCS, getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./
	iterateExpCS ::= iterateName '(' variableCS ';' variableCS '|' oclExpressionCS ')'
		/.$BeginJava
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(1);
					CSTNode result = createIterateExpCS(
							simpleNameCS,
							(VariableCS)$getSym(3),
							(VariableCS)$getSym(5),
							(OCLExpressionCS)$getSym(7)
						);
					setOffsets(result, simpleNameCS, getIToken($getToken(8)));
					$setResult(result);
		  $EndJava
		./

	variableCS ::= IDENTIFIER
		/.$BeginJava
					CSTNode result = createVariableCS(
							getTokenText($getToken(1)),
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	typedVariableCS ::= IDENTIFIER ':' typeCS
		/.$BeginJava
					CSTNode result = createVariableCS(
							getTokenText($getToken(1)),
							(TypeCS)$getSym(3),
							null
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./
	variableCS -> typedVariableCS
	variableCS ::= IDENTIFIER ':' typeCS '=' oclExpressionCS
		/.$BeginJava
					CSTNode result = createVariableCS(
							getTokenText($getToken(1)),
							(TypeCS)$getSym(3),
							(OCLExpressionCS)$getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(5));
					$setResult(result);
		  $EndJava
		./

	-- this form of variable declaration is only used in tuple literals
	variableCS2 ::= IDENTIFIER '=' oclExpressionCS
		/.$BeginJava
					CSTNode result = createVariableCS(
							getTokenText($getToken(1)),
							null,
							(OCLExpressionCS)$getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./

	typeCSopt ::= $empty
		/.$NullAction./
	typeCSopt -> typeCS

	-- the order of these rules is important!  Try to match primitives
	--   first, then tuples (more complex), and finally collections.
	--   Looking for type names in the Ecore model is a last resort
	typeCS -> primitiveTypeCS
	typeCS -> tupleTypeCS
	typeCS -> collectionTypeCS
	typeCS -> pathNameCS

	collectionTypeCS ::= collectionTypeIdentifierCS '(' typeCS ')'
		/.$BeginJava
					Object[] objs = (Object[])$getSym(1);
					CSTNode result = createCollectionTypeCS(
							(CollectionTypeIdentifierEnum)objs[1],
							(TypeCS)$getSym(3)
						);
					setOffsets(result, (IToken)objs[0], getIToken($getToken(4)));
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
	variableListCS ::= variableCS 
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	variableListCS ::= variableListCS ',' variableCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
	
	-- this form of variable declaration list is only used in tuple literals
	variableListCS2 ::= variableCS2
		/.$NewCase./
	variableListCS2 ::= variableCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	variableListCS2 ::= variableListCS2 ',' variableCS2
		/.$NewCase./
	variableListCS2 ::= variableListCS2 ',' variableCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
	
	-- covers attributeCallExpCS and navigationCallExpCS
	featureCallExpCS -> attrOrNavCallExpCS

	featureCallExpCS -> operationCallExpCS
	featureCallExpCS ::= unaryName isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	-- even though these operations do not use @pre or do not accept multiple arguments
	-- in order to get better error reporting, the rule signature must comply with
	-- the full rule of an operationCallExpCS
	-- the alternative would be to remove these as keywords, but then the parser
	-- would accept variable declarations where the var can be named "oclIsNew" for example
	operationCallExpCS ::= binaryName isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	keywordOperationCallExpCS ::= keywordAsName isMarkedPreCS '(' argumentsCSopt ')'
		/.$BeginJava
					CSTNode result = createOperationCallExpCS(
							(SimpleNameCS)$getSym(1),
							(IsMarkedPreCS)$getSym(2),
							(EList)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./

	stateExpCS ::= pathNameCSOpt
		/.$BeginJava
					PathNameCS pathNameCS = (PathNameCS)$getSym(1);
					StateExpCS result = createStateExpCS(pathNameCS);
					setOffsets(result, pathNameCS);
					$setResult(result);
		  $EndJava
		./
	-- FIXME StateExpCS creates a needless irregularity; unwrap its content as an argument list
	operationCallExpCS ::= oclIsInStateName isMarkedPreCS '(' stateExpCS ')'
		/.$BeginJava
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(1);
					CSTNode result = createOperationCallExpCS(
							simpleNameCS,
							(IsMarkedPreCS)$getSym(2),
							(StateExpCS)$getSym(4)
						);
					setOffsets(result, simpleNameCS, getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./

	attrOrNavCallExpCS ::= simpleNameCS isMarkedPreCS
		/.$NewCase./
	attrOrNavCallExpCS ::= keywordAsName isMarkedPreCS
		/.$BeginJava
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)$getSym(2);
					CSTNode result = createFeatureCallExpCS(
							(SimpleNameCS)$getSym(1),
							new BasicEList(),
							isMarkedPreCS
						);
					if (isMarkedPreCS.isPre()) {
						setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(2));
					} else {
						setOffsets(result, (CSTNode)$getSym(1));
					}
					$setResult(result);
		  $EndJava
		./
	attrOrNavCallExpCS ::= simpleNameCS '[' argumentsCS ']' isMarkedPreCS
		/.$BeginJava
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)$getSym(5);
					CSTNode result = createFeatureCallExpCS(
							(SimpleNameCS)$getSym(1),
							(EList)$getSym(3),
							isMarkedPreCS
						);
					if (isMarkedPreCS.isPre()) {
						setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(5));
					} else {
						setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(4)));
					}
					$setResult(result);
		  $EndJava
		./

	isMarkedPreCS ::= $empty
		/.$BeginJava
					CSTNode result = createIsMarkedPreCS(false);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	isMarkedPreCS ::= '@pre'
		/.$BeginJava
					CSTNode result = createIsMarkedPreCS(true);
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

	messageExpCS ::= '^' simpleNameCS '(' oclMessageArgumentsCSopt ')'
		/.$NewCase./
	messageExpCS ::= '^^' simpleNameCS '(' oclMessageArgumentsCSopt ')'
		/.$BeginJava
					CSTNode result = createMessageExpCS(
							getIToken($getToken(1)).getKind() == $sym_type.TK_CARET,
							(SimpleNameCS)$getSym(2),
							(EList<OCLMessageArgCS>)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
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
