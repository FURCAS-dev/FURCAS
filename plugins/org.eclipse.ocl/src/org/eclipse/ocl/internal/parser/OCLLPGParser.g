--/**
-- * <copyright>
-- *
-- * Copyright (c) 2005, 2007 IBM Corporation and others.
-- * All rights reserved.   This program and the accompanying materials
-- * are made available under the terms of the Eclipse Public License v1.0
-- * which accompanies this distribution, and is available at
-- * http://www.eclipse.org/legal/epl-v10.html
-- *
-- * Contributors:
-- *   IBM - Initial API and implementation
-- *   E.D. Willink - Elimination of some shift-reduce conflicts
-- *
-- * </copyright>
-- *
-- * $Id: OCLLPGParser.g,v 1.9 2007/04/19 22:07:29 cdamus Exp $
-- */
--
-- The OCL Parser
--

%options escape=$
%options la=2
%options table=java
%options fp=OCLLPGParser,prefix=TK_
%options error-maps
%options scopes
%options margin=4
%options noserialize
%options package=org.eclipse.ocl.internal.parser
--%options template=dtParserTemplateD.g
%options import_terminals=OCLLexer.g
%options ast_type=EObject
%options programming_language=java
%options action=("*.java", "/.", "./")
%options ParseTable=lpg.lpgjavaruntime.ParseTable

$Define

	-- Definition of macros used in the parser template
	--
	$prs_stream_class /.PrsStream./
	$action_class /.$file_prefix./

	-- package namespace of the LPG Runtime API
	$lpg_ns /.lpg.lpgjavaruntime./

	$NewCase
	/. $Header
				case $rule_number:./

	-- From dtParserTemplateD.g
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
	public class $action_class extends PrsStream implements RuleAction$additional_interfaces {
		protected static ParseTable prs = new $prs_type();
		private DeterministicParser dtParser;

		public $action_class(LexStream lexStream) {
			super(lexStream);

			try {
				super.remapTerminalSymbols(orderedTerminalSymbols(), $prs_type.EOFT_SYMBOL);
			}
			catch(NullExportedSymbolsException e) {
				throw new RuntimeException(e.getLocalizedMessage());
			}
			catch(NullTerminalSymbolsException e) {
				throw new RuntimeException(e.getLocalizedMessage());
			}
			catch(UnimplementedTerminalsException e) {
				java.util.ArrayList unimplemented_symbols = e.getSymbols();
				String error = "The Lexer will not scan the following token(s):";
				for (int i = 0; i < unimplemented_symbols.size(); i++) {
					Integer id = (Integer) unimplemented_symbols.get(i);
					error += "\t" + $sym_type.orderedTerminalSymbols[id.intValue()];			   
				}
				throw new RuntimeException(error + "\n");						
			}
			catch(UndefinedEofSymbolException e) {
				throw new RuntimeException("The Lexer does not implement the Eof symbol " +
					 $sym_type.orderedTerminalSymbols[$prs_type.EOFT_SYMBOL]);
			} 
		}
 
		public String[] orderedTerminalSymbols() { return $sym_type.orderedTerminalSymbols; }
		public String getTokenKindName(int kind) { return $sym_type.orderedTerminalSymbols[kind]; }			
		public int getEOFTokenKind() { return $prs_type.EOFT_SYMBOL; }
		public PrsStream getParseStream() { return this; }

		protected $ast_type parser() throws ParserException {
			return parser(null, 0);
		}
			
		protected $ast_type parser(Monitor monitor) throws ParserException {
			return parser(monitor, 0);
		}
			
		protected $ast_type parser(int error_repair_count) throws ParserException {
			return parser(null, error_repair_count);
		}
			
		protected $ast_type parser(Monitor monitor, int error_repair_count) throws ParserException {
			ParseTable prsTable = new $prs_type();

			try {
				dtParser = new DeterministicParser(monitor, this, prsTable, this);
			}
			catch (NotDeterministicParseTableException e) {
				throw new RuntimeException("****Error: Regenerate $prs_type.java with -NOBACKTRACK option");
			}
			catch (BadParseSymFileException e) {
				throw new RuntimeException("****Error: Bad Parser Symbol File -- $sym_type.java. Regenerate $prs_type.java");
			}

			try {
				return ($ast_type) dtParser.parse();
			}
			catch (BadParseException e) {
				reset(e.error_token); // point to error token

				DiagnoseParser diagnoseParser = new DiagnoseParser(this, prsTable);
				diagnoseParser.diagnose(e.error_token);
			}

			return null;
		}

	./
$End

$Notice
	/./**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: OCLLPGParser.g,v 1.9 2007/04/19 22:07:29 cdamus Exp $
 */
	./
$End

$Globals
	/.
	import org.eclipse.emf.common.util.BasicEList;
	import org.eclipse.emf.common.util.EList;
	import org.eclipse.emf.ecore.EObject;
	import org.eclipse.ocl.internal.cst.BooleanLiteralExpCS;
	import org.eclipse.ocl.internal.cst.CSTFactory;
	import org.eclipse.ocl.internal.cst.CSTNode;
	import org.eclipse.ocl.internal.cst.CallExpCS;
	import org.eclipse.ocl.internal.cst.ClassifierContextDeclCS;
	import org.eclipse.ocl.internal.cst.CollectionLiteralExpCS;
	import org.eclipse.ocl.internal.cst.CollectionLiteralPartCS;
	import org.eclipse.ocl.internal.cst.CollectionRangeCS;
	import org.eclipse.ocl.internal.cst.CollectionTypeCS;
	import org.eclipse.ocl.internal.cst.CollectionTypeIdentifierEnum;
	import org.eclipse.ocl.internal.cst.DefCS;
	import org.eclipse.ocl.internal.cst.DefExpressionCS;
	import org.eclipse.ocl.internal.cst.DerValueCS;
	import org.eclipse.ocl.internal.cst.DotOrArrowEnum;
	import org.eclipse.ocl.internal.cst.EnumLiteralExpCS;
	import org.eclipse.ocl.internal.cst.FeatureCallExpCS;
	import org.eclipse.ocl.internal.cst.IfExpCS;
	import org.eclipse.ocl.internal.cst.InitOrDerValueCS;
	import org.eclipse.ocl.internal.cst.InitValueCS;
	import org.eclipse.ocl.internal.cst.IntegerLiteralExpCS;
	import org.eclipse.ocl.internal.cst.InvCS;
	import org.eclipse.ocl.internal.cst.InvOrDefCS;
	import org.eclipse.ocl.internal.cst.InvalidLiteralExpCS;
	import org.eclipse.ocl.internal.cst.IsMarkedPreCS;
	import org.eclipse.ocl.internal.cst.IterateExpCS;
	import org.eclipse.ocl.internal.cst.IteratorExpCS;
	import org.eclipse.ocl.internal.cst.LetExpCS;
	import org.eclipse.ocl.internal.cst.MessageExpCS;
	import org.eclipse.ocl.internal.cst.MessageExpKind;
	import org.eclipse.ocl.internal.cst.NullLiteralExpCS;
	import org.eclipse.ocl.internal.cst.OCLExpressionCS;
	import org.eclipse.ocl.internal.cst.OCLMessageArgCS;
	import org.eclipse.ocl.internal.cst.OperationCS;
	import org.eclipse.ocl.internal.cst.OperationCallExpCS;
	import org.eclipse.ocl.internal.cst.OperationContextDeclCS;
	import org.eclipse.ocl.internal.cst.PackageDeclarationCS;
	import org.eclipse.ocl.internal.cst.PathNameCS;
	import org.eclipse.ocl.internal.cst.PrePostOrBodyDeclCS;
	import org.eclipse.ocl.internal.cst.PrePostOrBodyEnum;
	import org.eclipse.ocl.internal.cst.PrimitiveTypeCS;
	import org.eclipse.ocl.internal.cst.PropertyContextCS;
	import org.eclipse.ocl.internal.cst.RealLiteralExpCS;
	import org.eclipse.ocl.internal.cst.SimpleNameCS;
	import org.eclipse.ocl.internal.cst.SimpleTypeEnum;
	import org.eclipse.ocl.internal.cst.StateExpCS;
	import org.eclipse.ocl.internal.cst.StringLiteralExpCS;
	import org.eclipse.ocl.internal.cst.TupleLiteralExpCS;
	import org.eclipse.ocl.internal.cst.TupleTypeCS;
	import org.eclipse.ocl.internal.cst.TypeCS;
	import org.eclipse.ocl.internal.cst.UnlimitedNaturalLiteralExpCS;
	import org.eclipse.ocl.internal.cst.VariableCS;
	import org.eclipse.ocl.internal.cst.VariableExpCS;
	import org.eclipse.ocl.ParserException;
	import org.eclipse.ocl.util.OCLStandardLibraryUtil;
	import org.eclipse.ocl.utilities.PredefinedType;
	
	import $lpg_ns.BadParseException;
	import $lpg_ns.BadParseSymFileException;
	import $lpg_ns.DeterministicParser;
	import $lpg_ns.DiagnoseParser;
	import $lpg_ns.IToken;
	import $lpg_ns.LexStream;
	import $lpg_ns.Monitor;
	import $lpg_ns.NotDeterministicParseTableException;
	import $lpg_ns.NullExportedSymbolsException;
	import $lpg_ns.NullTerminalSymbolsException;
	import $lpg_ns.ParseTable;
	import $lpg_ns.PrsStream;
	import $lpg_ns.RuleAction;
	import $lpg_ns.UndefinedEofSymbolException;
	import $lpg_ns.UnimplementedTerminalsException;
	./
$End

$KeyWords
	self
	inv
	pre
	post
	body
	context
	package
	endpackage
	def
	derive
	init
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
	
	null
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

$Start
    goal
$End

$Headers
	/.$parserCore

		protected PackageDeclarationCS createPackageDeclarationCS(
				PathNameCS pathNameCS,
				EList contextDecls) {
			PackageDeclarationCS result = CSTFactory.eINSTANCE.createPackageDeclarationCS();
			result.setPathNameCS(pathNameCS);
			if (contextDecls != null && !contextDecls.isEmpty())
				result.getContextDecls().addAll(contextDecls);
			return result;
		}
		
		protected PropertyContextCS createPropertyContextCS(
				PathNameCS pathNameCS,
				SimpleNameCS simpleNameCS,
				TypeCS typeCS,
				InitOrDerValueCS initOrDerValueCS) {
			PropertyContextCS result = CSTFactory.eINSTANCE.createPropertyContextCS();
			result.setPathNameCS(pathNameCS);
			result.setSimpleNameCS(simpleNameCS);
			result.setTypeCS(typeCS);
			result.setInitOrDerValueCS(initOrDerValueCS);
			return result;
		}
		
		protected DerValueCS createDerValueCS(
				InitOrDerValueCS initOrDerValueCS,
				OCLExpressionCS oclExpressionCS) {
			DerValueCS result = CSTFactory.eINSTANCE.createDerValueCS();
			result.setInitOrDerValueCS(initOrDerValueCS);
			result.setExpressionCS(oclExpressionCS);
			return result;
		}
	
		protected InitValueCS createInitValueCS(
				InitOrDerValueCS initOrDerValueCS,
				OCLExpressionCS oclExpressionCS) {
			InitValueCS result = CSTFactory.eINSTANCE.createInitValueCS();
			result.setInitOrDerValueCS(initOrDerValueCS);
			result.setExpressionCS(oclExpressionCS);
			return result;
		}
		
		protected ClassifierContextDeclCS createClassifierContextDeclCS(
				PathNameCS pathNameCS,
				InvOrDefCS invOrDefCS) {
			ClassifierContextDeclCS result = CSTFactory.eINSTANCE.createClassifierContextDeclCS();
			result.setPathNameCS(pathNameCS);
			result.setInvOrDefCS(invOrDefCS);
			return result;
		}
		
		protected InvCS createInvCS(
				InvOrDefCS invOrDefCS,
				SimpleNameCS simpleNameCS,
				OCLExpressionCS oclExpressionCS) {
			InvCS result = CSTFactory.eINSTANCE.createInvCS();
			result.setSimpleNameCS(simpleNameCS);
			result.setExpressionCS(oclExpressionCS);
			result.setInvOrDefCS(invOrDefCS);
			return result;
		}
		
		protected DefCS createDefCS(
				InvOrDefCS invOrDefCS,
				SimpleNameCS simpleNameCS,
				DefExpressionCS defExpressionCS) {
			DefCS result = CSTFactory.eINSTANCE.createDefCS();
			result.setSimpleNameCS(simpleNameCS);
			result.setDefExpressionCS(defExpressionCS);
			result.setInvOrDefCS(invOrDefCS);
			return result;
		}
		
		protected DefExpressionCS createDefExpressionCS(
				VariableCS variableCS,
				OperationCS operationCS,
				OCLExpressionCS oclExpressionCS) {
			DefExpressionCS result = CSTFactory.eINSTANCE.createDefExpressionCS();
			result.setVariableCS(variableCS);
			result.setOperationCS(operationCS);
			result.setExpressionCS(oclExpressionCS);
			return result;
		}
	
		protected OperationContextDeclCS createOperationContextDeclCS(
				OperationCS operationCS,
				EList prePostOrBodyDecls) {
			OperationContextDeclCS result = CSTFactory.eINSTANCE.createOperationContextDeclCS();
			result.setOperationCS(operationCS);
			result.getPrePostOrBodyDecls().addAll(prePostOrBodyDecls);
			return result;
		}
	
		protected PrePostOrBodyDeclCS createPrePostOrBodyDeclCS(
				PrePostOrBodyEnum kind,
				SimpleNameCS simpleNameCS,
				OCLExpressionCS oclExpressionCS) {
			PrePostOrBodyDeclCS result = CSTFactory.eINSTANCE.createPrePostOrBodyDeclCS();
			result.setKind(kind);
			result.setSimpleNameCS(simpleNameCS);
			result.setExpressionCS(oclExpressionCS);
			return result;
		}
	
		protected OperationCS createOperationCS(
				PathNameCS pathNameCS,
				SimpleNameCS simpleNameCS,
				EList list,
				TypeCS typeCS) {
			OperationCS result = CSTFactory.eINSTANCE.createOperationCS();
			result.setPathNameCS(pathNameCS);
			result.setSimpleNameCS(simpleNameCS);
			result.getParameters().addAll(list);
			result.setTypeCS(typeCS);
			return result;
		}

		protected OperationCS createOperationCS(
				String simpleName,
				EList list,
				TypeCS typeCS) {
			return createOperationCS(
					null,
					createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, simpleName),
					list,
					typeCS);
		}
	
		protected OperationCallExpCS createOperationCallExpCS(
				OCLExpressionCS oclExpressionCS,
				SimpleNameCS simpleNameCS,
				IsMarkedPreCS isMarkedPreCS,
				EList arguments) {
			OperationCallExpCS result = CSTFactory.eINSTANCE.createOperationCallExpCS();
			result.setSource(oclExpressionCS);
			result.setSimpleNameCS(simpleNameCS);
			result.setIsMarkedPreCS(isMarkedPreCS);
			result.getArguments().addAll(arguments);
			return result;
		}
	
		protected OperationCallExpCS createOperationCallExpCS(
				OCLExpressionCS oclExpressionCS,
				SimpleNameCS simpleNameCS,
				EList arguments) {
			return createOperationCallExpCS(oclExpressionCS, simpleNameCS,
					createIsMarkedPreCS(false), arguments);
		}
	
		protected OperationCallExpCS createOperationCallExpCS(
				SimpleNameCS simpleNameCS,
				IsMarkedPreCS isMarkedPreCS,
				EList arguments) {
			return createOperationCallExpCS(null, simpleNameCS, isMarkedPreCS, arguments);
		}
	
		protected OperationCallExpCS createOperationCallExpCS(
				SimpleNameCS simpleNameCS,
				IsMarkedPreCS isMarkedPreCS,
				StateExpCS stateExpCS) {
			OperationCallExpCS result = CSTFactory.eINSTANCE.createOperationCallExpCS();
			result.setSimpleNameCS(simpleNameCS);
			result.setIsMarkedPreCS(isMarkedPreCS);
			result.getArguments().add(stateExpCS);
			return result;
		}
		
		private StateExpCS createStateExpCS(PathNameCS pathName) {
			StateExpCS result = CSTFactory.eINSTANCE.createStateExpCS();
			result.getSequenceOfNames().addAll(pathName.getSequenceOfNames());
			return result;
		}
	
		protected VariableExpCS createVariableExpCS(
				SimpleNameCS simpleNameCS,
				EList arguments,
				IsMarkedPreCS isMarkedPreCS) {
			VariableExpCS result = CSTFactory.eINSTANCE.createVariableExpCS();
			result.setSimpleNameCS(simpleNameCS);
			result.getArguments().addAll(arguments);
			result.setIsMarkedPreCS(isMarkedPreCS);
			return result;
		}
	
		protected SimpleNameCS createSimpleNameCS(
				SimpleTypeEnum type,
				String value) {
			SimpleNameCS result = CSTFactory.eINSTANCE.createSimpleNameCS();
			result.setType(type);
			result.setValue(unquote(value));
			return result;
		}
	
		protected PrimitiveTypeCS createPrimitiveTypeCS(
				SimpleTypeEnum type,
				String value) {
			PrimitiveTypeCS result = CSTFactory.eINSTANCE.createPrimitiveTypeCS();
			result.setType(type);
			result.setValue(value);
			return result;
		}

		/**
		 * Removes the "s surrounding a quoted string, if any.
		 * 
		 * @param quoted a possibly quoted string
		 * @return <code>quoted</code> without the surrounding quotes, or just
		 *	 <code>quoted</code> verbatim if there were none
		 */
		protected String unquote(String quoted) {
			String result = quoted;
		
			if ((result != null) && (result.length() > 1)) {
				int max = result.length() - 1;
		
				if ((result.charAt(0) == '"') && (quoted.charAt(max) == '"')) {
					result = result.substring(1, max);
				}
				
				// this is a regexp, so the backslash needs to be
				//   re-escaped, thus "\\" is rendered in a Java
				//   string literal as "\\\\"
				result = result.replaceAll("\\\\\"", "\"");  //$NON-NLS-2$//$NON-NLS-1$
			}
		
			return result;
		}
	
		private PathNameCS createPathNameCS(String pathName) {
			PathNameCS result = CSTFactory.eINSTANCE.createPathNameCS();
			result.getSequenceOfNames().add(unquote(pathName));
			return result;
		}
		
		private PathNameCS extendPathNameCS(PathNameCS path, String name) {
			path.getSequenceOfNames().add(unquote(name));
			return path;
		}
	
		private PathNameCS createPathNameCS() {
			return CSTFactory.eINSTANCE.createPathNameCS();
		}
	
		protected EnumLiteralExpCS createEnumLiteralExpCS(
				PathNameCS pathNameCS,
				SimpleNameCS simpleNameCS) {
			EnumLiteralExpCS result = CSTFactory.eINSTANCE.createEnumLiteralExpCS();
			result.setPathNameCS(pathNameCS);
			result.setSimpleNameCS(simpleNameCS);
			return result;
		}
	
		protected EnumLiteralExpCS createEnumLiteralExpCS(
				PathNameCS pathNameCS,
				String simpleName) {
			return createEnumLiteralExpCS(pathNameCS,
				createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, simpleName));
		}
	
		protected CollectionLiteralExpCS createCollectionLiteralExpCS(
				CollectionTypeIdentifierEnum type,
				EList collectionLiteralParts) {
			CollectionLiteralExpCS result = CSTFactory.eINSTANCE.createCollectionLiteralExpCS();
			result.setCollectionType(type);
			result.getCollectionLiteralParts().addAll(collectionLiteralParts);
			return result;
		}
	
		protected CollectionLiteralPartCS createCollectionLiteralPartCS(OCLExpressionCS oclExpressionCS) {
			CollectionLiteralPartCS result = CSTFactory.eINSTANCE.createCollectionLiteralPartCS();
			result.setExpressionCS(oclExpressionCS);
			return result;
		}
	
		protected CollectionRangeCS createCollectionRangeCS(
				OCLExpressionCS oclExpressionCS,
				OCLExpressionCS lastOCLExpressionCS) {
			CollectionRangeCS result = CSTFactory.eINSTANCE.createCollectionRangeCS();
			result.setExpressionCS(oclExpressionCS);
			result.setLastExpressionCS(lastOCLExpressionCS);
			return result;
		}
	
		protected IntegerLiteralExpCS createRangeStart(
				String integerDotDot,
				boolean isNegative) {
			String intToken = integerDotDot.substring(0, integerDotDot.indexOf('.'));
			int intValue = Integer.parseInt(intToken);
			if (isNegative) {
				intValue = -intValue;
			}
			
			IntegerLiteralExpCS result = CSTFactory.eINSTANCE.createIntegerLiteralExpCS();
			result.setIntegerSymbol(new Integer(intValue));
			result.setSymbol(Integer.toString(intValue));
			
			return result;
		}
	
		protected TupleLiteralExpCS createTupleLiteralExpCS(EList variables) {
			TupleLiteralExpCS result = CSTFactory.eINSTANCE.createTupleLiteralExpCS();
			result.getVariables().addAll(variables);
			return result;
		}
	
		protected IntegerLiteralExpCS createIntegerLiteralExpCS(String string) {
			IntegerLiteralExpCS result = CSTFactory.eINSTANCE.createIntegerLiteralExpCS();
			result.setSymbol(string);
			result.setIntegerSymbol(Integer.valueOf(string));
			return result;
		}
	
		protected UnlimitedNaturalLiteralExpCS createUnlimitedNaturalLiteralExpCS(String string) {
			UnlimitedNaturalLiteralExpCS result = CSTFactory.eINSTANCE.createUnlimitedNaturalLiteralExpCS();
			result.setSymbol(string);
			if ("*".equals(string)) {
				result.setIntegerSymbol(-1);
			} else {
				result.setIntegerSymbol(Integer.valueOf(string));
			}
			return result;
		}
	
		protected RealLiteralExpCS createRealLiteralExpCS(String string) {
			RealLiteralExpCS result = CSTFactory.eINSTANCE.createRealLiteralExpCS();
			result.setSymbol(string);
			result.setRealSymbol(Double.valueOf(string));
			return result;
		}
	
		protected StringLiteralExpCS createStringLiteralExpCS(String string) {
			StringLiteralExpCS result = CSTFactory.eINSTANCE.createStringLiteralExpCS();
			result.setSymbol(string);
			result.setStringSymbol(string);
			return result;
		}
	
		protected BooleanLiteralExpCS createBooleanLiteralExpCS(String string) {
			BooleanLiteralExpCS result = CSTFactory.eINSTANCE.createBooleanLiteralExpCS();
			result.setSymbol(string);
			result.setBooleanSymbol(Boolean.valueOf(string));
			return result;
		}
	
		protected NullLiteralExpCS createNullLiteralExpCS(String string) {
			NullLiteralExpCS result = CSTFactory.eINSTANCE.createNullLiteralExpCS();
			result.setSymbol(string);
			return result;
		}
	
		protected InvalidLiteralExpCS createInvalidLiteralExpCS(String string) {
			InvalidLiteralExpCS result = CSTFactory.eINSTANCE.createInvalidLiteralExpCS();
			result.setSymbol(string);
			return result;
		}
	
		protected IteratorExpCS createIteratorExpCS(
				SimpleNameCS simpleNameCS,
				VariableCS variable1,
				VariableCS variable2,
				OCLExpressionCS oclExpressionCS) {
			IteratorExpCS result = CSTFactory.eINSTANCE.createIteratorExpCS();
			result.setSimpleNameCS(simpleNameCS);
			result.setVariable1(variable1);
			result.setVariable2(variable2);
			result.setBody(oclExpressionCS);
			return result;
		}
	
		protected IterateExpCS createIterateExpCS(
				SimpleNameCS simpleNameCS,
				VariableCS variable1,
				VariableCS variable2,
				OCLExpressionCS oclExpressionCS) {
			IterateExpCS result = CSTFactory.eINSTANCE.createIterateExpCS();
			result.setSimpleNameCS(simpleNameCS);
			result.setVariable1(variable1);
			result.setVariable2(variable2);
			result.setBody(oclExpressionCS);
			return result;
		}
	
		protected VariableCS createVariableCS(
				String varName,
				TypeCS typeCS,
				OCLExpressionCS oclExpressionCS) {
			VariableCS result = CSTFactory.eINSTANCE.createVariableCS();
			result.setName(unquote(varName));
			result.setTypeCS(typeCS);
			result.setInitExpression(oclExpressionCS);
			return result;
		}
	
		protected CollectionTypeCS createCollectionTypeCS(
				CollectionTypeIdentifierEnum collectionType,
				TypeCS typeCS) {
			CollectionTypeCS result = CSTFactory.eINSTANCE.createCollectionTypeCS();
			result.setCollectionTypeIdentifier(collectionType);
			result.setTypeCS(typeCS);
			return result;
		}
	
		protected TupleTypeCS createTupleTypeCS(EList variables) {
			TupleTypeCS result = CSTFactory.eINSTANCE.createTupleTypeCS();
			result.getVariables().addAll(variables);
			return result;
		}
	
		protected FeatureCallExpCS createFeatureCallExpCS(
				SimpleNameCS simpleNameCS,
				EList arguments,
				IsMarkedPreCS isMarkedPreCS) {
			FeatureCallExpCS result = CSTFactory.eINSTANCE.createFeatureCallExpCS();
			result.setSimpleNameCS(simpleNameCS);
			result.getArguments().addAll(arguments);
			result.setIsMarkedPreCS(isMarkedPreCS);
			return result;
		}
	
		protected IsMarkedPreCS createIsMarkedPreCS(boolean isMarkedPre) {
			IsMarkedPreCS result = CSTFactory.eINSTANCE.createIsMarkedPreCS();
			result.setPre(isMarkedPre);
			return result;
		}
	
		protected LetExpCS createLetExpCS(
				EList variables,
				OCLExpressionCS oclExpressionCS) {
			LetExpCS result = CSTFactory.eINSTANCE.createLetExpCS();
			result.getVariables().addAll(variables);
			result.setInExpression(oclExpressionCS);
			return result;
		}
	
		protected IfExpCS createIfExpCS(
				OCLExpressionCS condition,
				OCLExpressionCS thenExpression,
				OCLExpressionCS elseExpression) {
			IfExpCS result = CSTFactory.eINSTANCE.createIfExpCS();
			result.setCondition(condition);
			result.setThenExpression(thenExpression);
			result.setElseExpression(elseExpression);
			return result;
		}
	
		protected MessageExpCS createMessageExpCS(
				int kind,
				SimpleNameCS simpleNameCS,
				EList oclMessageArgs) {
			MessageExpCS result = CSTFactory.eINSTANCE.createMessageExpCS();
			result.setKind((kind == OCLLPGParsersym.TK_CARET)?
					MessageExpKind.HAS_SENT_LITERAL : MessageExpKind.SENT_LITERAL);
			result.setSimpleNameCS(simpleNameCS);
			result.getArguments().addAll(oclMessageArgs);
			return result;
		}
	
		protected OCLMessageArgCS createOCLMessageArgCS(
				TypeCS typeCS,
				OCLExpressionCS oclExpressionCS) {
			OCLMessageArgCS result = CSTFactory.eINSTANCE.createOCLMessageArgCS();
			result.setTypeCS(typeCS);
			result.setExpression(oclExpressionCS);
			return result;
		}
		
		/**
		 * Sets the start and end offsets of the given <code>CSTNode</code>
		 * to the start and end offsets of the given <code>IToken</code>
		 *
		 * @param cstNode <code>CSTNode</code> to set offsets
		 * @param startEnd <code>IToken</code> to retrieve offsets from
		 */
		protected void setOffsets(CSTNode cstNode, IToken startEnd) {
			cstNode.setStartOffset(startEnd.getStartOffset());
			cstNode.setEndOffset(startEnd.getEndOffset());
		}

		/**
		 * Sets the start and end offsets of the given <code>CSTNode</code>
		 * to the start and end offsets of the 2nd given <code>CSTNode</code>
		 *
		 * @param cstNode <code>CSTNode</code> to set offsets
		 * @param startEnd <code>CSTNode</code> to retrieve offsets from
		 */
		protected void setOffsets(CSTNode cstNode, CSTNode startEnd) {
			cstNode.setStartOffset(startEnd.getStartOffset());
			cstNode.setEndOffset(startEnd.getEndOffset());
		}

		/**
		 * Sets the start and end offsets of the given <code>CSTNode</code>
		 * to the start offset of the 2nd given <code>CSTNode</code> and the
		 * end offset of the 3rd given <code>CSTNode</code>
		 *
		 * @param cstNode <code>CSTNode</code> to set offsets
		 * @param start <code>CSTNode</code> to retrieve start offset from
		 * @param end <code>CSTNode</code> to retrieve end offset from
		 */
		protected void setOffsets(CSTNode cstNode, CSTNode start, CSTNode end) {
			cstNode.setStartOffset(start.getStartOffset());
			cstNode.setEndOffset(end.getEndOffset());
		}

		/**
		 * Sets the start and end offsets of the given <code>CSTNode</code>
		 * to the start offset of the 2nd given <code>CSTNode</code> and the
		 * end offset of the given <code>IToken</code>
		 *
		 * @param cstNode <code>CSTNode</code> to set offsets
		 * @param start <code>CSTNode</code> to retrieve start offset from
		 * @param end <code>IToken</code> to retrieve end offset from
		 */
		protected void setOffsets(CSTNode cstNode, CSTNode start, IToken end) {
			cstNode.setStartOffset(start.getStartOffset());
			cstNode.setEndOffset(end.getEndOffset());
		}

		/**
		 * Sets the start and end offsets of the given <code>CSTNode</code>
		 * to the start offset of the given <code>IToken</code> and the
		 * end offset of the 2nd given <code>CSTNode</code>
		 *
		 * @param cstNode <code>CSTNode</code> to set offsets
		 * @param start <code>IToken</code> to retrieve start offset from
		 * @param end <code>CSTNode</code> to retrieve end offset from
		 */
		protected void setOffsets(CSTNode cstNode, IToken start, CSTNode end) {
			cstNode.setStartOffset(start.getStartOffset());
			cstNode.setEndOffset(end.getEndOffset());
		}

		/**
		 * Sets the start and end offsets of the given <code>CSTNode</code>
		 * to the start offset of the 1std given <code>IToken</code> and the
		 * end offset of the 2nd given <code>IToken</code>
		 *
		 * @param cstNode <code>CSTNode</code> to set offsets
		 * @param start <code>IToken</code> to retrieve start offset from
		 * @param end <code>IToken</code> to retrieve end offset from
		 */
		protected void setOffsets(CSTNode cstNode, IToken start, IToken end) {
			cstNode.setStartOffset(start.getStartOffset());
			cstNode.setEndOffset(end.getEndOffset());
		}
	./
$End

$Rules
	/.$BeginActions./

	-- opt = optional
	-- m = multiple
	
	goal -> packageDeclarationCS1
	goal -> packageDeclarationCSm
	goal -> invOrDefCS
	goal -> prePostOrBodyDeclCS
	goal -> initOrDerValueCS
	goal -> variableCS
	goal -> $empty

	--
	-- Define a group of names that we define as keywords for the purpose
	-- of constructing an LPG grammar, but that are not reserved by OCL
	-- and are commonly used in models such as the UML metamodel, itself
	--
	keywordAsIdentifier -> iterate
	keywordAsIdentifier -> forAll
	keywordAsIdentifier -> exists
	keywordAsIdentifier -> isUnique
	keywordAsIdentifier -> any
	keywordAsIdentifier -> one
	keywordAsIdentifier -> collect
	keywordAsIdentifier -> select
	keywordAsIdentifier -> reject
	keywordAsIdentifier -> collectNested
	keywordAsIdentifier -> sortedBy
	keywordAsIdentifier -> closure
	keywordAsIdentifier -> package
	keywordAsIdentifier -> context
	keywordAsIdentifier -> body
	keywordAsIdentifier -> derive
	keywordAsIdentifier -> init
	keywordAsIdentifier -> allInstances
	

	packageDeclarationCSm -> packageDeclarationCS
	packageDeclarationCSm ::= packageDeclarationCSm packageDeclarationCS
		/.$BeginJava
					PackageDeclarationCS result = (PackageDeclarationCS)$getSym(2);
					result.setPackageDeclarationCS((PackageDeclarationCS) $getSym(1));
					$setResult(result);
		  $EndJava
		./
	packageDeclarationCS ::= package pathNameCS contextDeclCSmopt endpackage
		/.$BeginJava
					CSTNode result = createPackageDeclarationCS(
							(PathNameCS)$getSym(2),
							(EList)$getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	
	packageDeclarationCS1 ::= contextDeclCSm
		/.$BeginJava
					EList contextDecls = (EList)$getSym(1);
					CSTNode result = createPackageDeclarationCS(null, contextDecls);
					if (!contextDecls.isEmpty()) {
						setOffsets(result, (CSTNode)contextDecls.get(0), (CSTNode)contextDecls.get(contextDecls.size()-1));
					}
					$setResult(result);
		  $EndJava
		./


	contextDeclCSmopt ::= $empty
		/.$EmptyListAction./
	contextDeclCSmopt -> contextDeclCSm

	contextDeclCSm ::= contextDeclCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	contextDeclCSm ::= contextDeclCSm contextDeclCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./

	contextDeclCS -> classifierContextDeclCS
	contextDeclCS -> operationContextDeclCS
	contextDeclCS -> propertyContextCS

	propertyContextCS ::= context pathNameCS '::' simpleNameCS ':' typeCS initOrDerValueCS
		/.$BeginJava
					CSTNode result = createPropertyContextCS(
							(PathNameCS)$getSym(2),
							(SimpleNameCS)$getSym(4),
							(TypeCS)$getSym(6),
							(InitOrDerValueCS)$getSym(7)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(7));
					$setResult(result);
		  $EndJava
		./

	initOrDerValueCS ::= initOrDerValueCSopt init ':' oclExpressionCS
		/.$BeginJava
					CSTNode result = createInitValueCS(
							(InitOrDerValueCS)$getSym(1),
							(OCLExpressionCS)$getSym(4)
						);
					if ($getSym(1) != null) {
						setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(4));
					} else {
						setOffsets(result, getIToken($getToken(2)), (CSTNode)$getSym(4));
					}
					$setResult(result);
		  $EndJava
		./

	initOrDerValueCS ::= initOrDerValueCSopt derive ':' oclExpressionCS
		/.$BeginJava
					CSTNode result = createDerValueCS(
							(InitOrDerValueCS)$getSym(1),
							(OCLExpressionCS)$getSym(4)
						);
					if ($getSym(1) != null) {
						setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(4));
					} else {
						setOffsets(result, getIToken($getToken(2)), (CSTNode)$getSym(4));
					}
					$setResult(result);
		  $EndJava
		./

	initOrDerValueCSopt ::= $empty
		/.$NullAction./
	initOrDerValueCSopt -> initOrDerValueCS

	classifierContextDeclCS ::= context pathNameCS invOrDefCS
		/.$BeginJava
					CSTNode result = createClassifierContextDeclCS(
							(PathNameCS)$getSym(2),
							(InvOrDefCS)$getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./

	invOrDefCSopt ::= $empty
		/.$NullAction./
	invOrDefCSopt -> invOrDefCS

	invOrDefCS ::= invOrDefCSopt inv simpleNameCSopt ':' oclExpressionCS
		/.$BeginJava
					CSTNode result = createInvCS(
							(InvOrDefCS)$getSym(1),
							(SimpleNameCS)$getSym(3),
							(OCLExpressionCS)$getSym(5)
						);
					if ($getSym(1) != null) {
						setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(5));
					} else {
						setOffsets(result, getIToken($getToken(2)), (CSTNode)$getSym(5));
					}
					$setResult(result);
		  $EndJava
		./
	
	invOrDefCS ::= invOrDefCSopt def simpleNameCSopt ':' defExpressionCS
		/.$BeginJava
					CSTNode result = createDefCS(
							(InvOrDefCS)$getSym(1),
							(SimpleNameCS)$getSym(3),
							(DefExpressionCS)$getSym(5)
						);
					if ($getSym(1) != null) {
						setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(5));
					} else {
						setOffsets(result, getIToken($getToken(2)), (CSTNode)$getSym(5));
					}
					$setResult(result);
		  $EndJava
		./

	defExpressionCS ::= IDENTIFIER ':' typeCS '=' oclExpressionCS
		/.$BeginJava
					VariableCS variableCS = createVariableCS(
								getTokenText($getToken(1)),
								(TypeCS)$getSym(3),
								null
							);
					setOffsets(variableCS, getIToken($getToken(1)), (CSTNode)$getSym(3));
					CSTNode result = createDefExpressionCS(
							variableCS,
							null,
							(OCLExpressionCS)$getSym(5)
						);
					setOffsets(result, variableCS, (CSTNode)$getSym(5));
					$setResult(result);
		  $EndJava
		./
	defExpressionCS ::= operationCS1 '=' oclExpressionCS
		/.$BeginJava
					CSTNode result = createDefExpressionCS(
							null,
							(OperationCS)$getSym(1),
							(OCLExpressionCS)$getSym(3)
						);
					setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./

	operationContextDeclCS ::= context operationCS2 prePostOrBodyDeclCSm
		/.$BeginJava
					EList prePostOrBodyDecls = (EList)$getSym(3);
					CSTNode result = createOperationContextDeclCS(
							(OperationCS)$getSym(2),
							prePostOrBodyDecls
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)prePostOrBodyDecls.get(prePostOrBodyDecls.size()-1));
					$setResult(result);
		  $EndJava
		./

	prePostOrBodyDeclCSm ::= prePostOrBodyDeclCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	prePostOrBodyDeclCSm ::= prePostOrBodyDeclCSm prePostOrBodyDeclCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./

	prePostOrBodyDeclCS ::= pre simpleNameCSopt ':' oclExpressionCS
		/.$BeginJava
					CSTNode result = createPrePostOrBodyDeclCS(
							PrePostOrBodyEnum.PRE_LITERAL,
							(SimpleNameCS)$getSym(2),
							(OCLExpressionCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndJava
		./
	prePostOrBodyDeclCS ::= post simpleNameCSopt ':' oclExpressionCS
		/.$BeginJava
					CSTNode result = createPrePostOrBodyDeclCS(
							PrePostOrBodyEnum.POST_LITERAL,
							(SimpleNameCS)$getSym(2),
							(OCLExpressionCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndJava
		./
	prePostOrBodyDeclCS ::= body simpleNameCSopt ':' oclExpressionCS
		/.$BeginJava
					CSTNode result = createPrePostOrBodyDeclCS(
							PrePostOrBodyEnum.BODY_LITERAL,
							(SimpleNameCS)$getSym(2),
							(OCLExpressionCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
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
					int startOffset = getIToken($getToken(1)).getStartOffset();
					int endOffset = startOffset + integer.length() - 1; // inclusive

					IntegerLiteralExpCS integerLiteralExpCS = createIntegerLiteralExpCS(integer);
					integerLiteralExpCS.setStartOffset(startOffset);
					integerLiteralExpCS.setEndOffset(endOffset);

					startOffset = endOffset + 2; // end of integerLiteral + 1('.') + 1(start of simpleName)
					endOffset = getIToken($getToken(1)).getEndOffset();

					// create the SimpleNameCS
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.IDENTIFIER_LITERAL,
								simpleName
							);
					simpleNameCS.setStartOffset(startOffset);
					simpleNameCS.setEndOffset(endOffset);

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
	variableExpCS ::= keywordAsIdentifier isMarkedPreCS
		/.$BeginJava
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)$getSym(2);
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.IDENTIFIER_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));
					CSTNode result = createVariableExpCS(
							simpleNameCS,
							new BasicEList(),
							isMarkedPreCS
						);
					if (isMarkedPreCS.isPre()) {
						setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(2));
					} else {
						setOffsets(result, getIToken($getToken(1)));
					}
					$setResult(result);
		  $EndJava
		./
	variableExpCS ::= simpleNameCS '[' argumentsCS ']' isMarkedPreCS
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
	enumLiteralExpCS ::= pathNameCS '::' Bag
		/.$NewCase./
	enumLiteralExpCS ::= pathNameCS '::' Collection
		/.$NewCase./
	enumLiteralExpCS ::= pathNameCS '::' OrderedSet
		/.$NewCase./
	enumLiteralExpCS ::= pathNameCS '::' Sequence
		/.$NewCase./
	enumLiteralExpCS ::= pathNameCS '::' Set
		/.$NewCase./
	enumLiteralExpCS ::= pathNameCS '::' package
		/.$BeginJava
					CSTNode result = createEnumLiteralExpCS(
							(PathNameCS)$getSym(1),
							getTokenText($getToken(3))
						);
					setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
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

	iteratorExpCS ::= forAll '(' iterContents ')'
		/.$NewCase./
	iteratorExpCS ::= exists '(' iterContents ')'
		/.$NewCase./
	iteratorExpCS ::= isUnique '(' iterContents ')'
		/.$NewCase./
	iteratorExpCS ::= one '(' iterContents ')'
		/.$NewCase./
	iteratorExpCS ::= any '(' iterContents ')'
		/.$NewCase./
	iteratorExpCS ::= collect '(' iterContents ')'
		/.$NewCase./
	iteratorExpCS ::= select '(' iterContents ')'
		/.$NewCase./
	iteratorExpCS ::= reject '(' iterContents ')'
		/.$NewCase./
	iteratorExpCS ::= collectNested '(' iterContents ')'
		/.$NewCase./
	iteratorExpCS ::= sortedBy '(' iterContents ')'
		/.$NewCase./
	iteratorExpCS ::= closure '(' iterContents ')'
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.KEYWORD_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));
					Object[] iterContents = (Object[])$getSym(3);
					CSTNode result = createIteratorExpCS(
							simpleNameCS,
							(VariableCS)iterContents[0],
							(VariableCS)iterContents[1],
							(OCLExpressionCS)iterContents[2]
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./


	iterContents ::= oclExpressionCS
		/.$BeginJava
					$setResult(new Object[] {
							null,
							null,
							$getSym(1)
						});
		  $EndJava
		./
	
	iterContents ::= variableCS '|' oclExpressionCS
		/.$BeginJava
					$setResult(new Object[] {
							$getSym(1),
							null,
							$getSym(3)
						});
		  $EndJava
		./
	iterContents ::= variableCS ',' variableCS '|' oclExpressionCS
		/.$BeginJava
					$setResult(new Object[] {
							$getSym(1),
							$getSym(3),
							$getSym(5)
						});
		  $EndJava
		./

	iterateExpCS ::= iterate '(' variableCS '|' oclExpressionCS ')'
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.KEYWORD_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));
					CSTNode result = createIterateExpCS(
							simpleNameCS,
							(VariableCS)$getSym(3),
							null,
							(OCLExpressionCS)$getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./
	iterateExpCS ::= iterate '(' variableCS ';' variableCS '|' oclExpressionCS ')'
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.KEYWORD_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));
					CSTNode result = createIterateExpCS(
							simpleNameCS,
							(VariableCS)$getSym(3),
							(VariableCS)$getSym(5),
							(OCLExpressionCS)$getSym(7)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(8)));
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
	variableCS ::= IDENTIFIER ':' typeCS
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
	featureCallExpCS ::= MINUS isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	featureCallExpCS ::= not isMarkedPreCS '(' argumentsCSopt ')'
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.IDENTIFIER_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));
					CSTNode result = createOperationCallExpCS(
							simpleNameCS,
							(IsMarkedPreCS)$getSym(2),
							(EList)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./

	operationCallExpCS ::=  simpleNameCS isMarkedPreCS '(' argumentsCSopt ')'
		/.$BeginJava
					CSTNode result = createOperationCallExpCS(
							(SimpleNameCS)$getSym(1),
							(IsMarkedPreCS)$getSym(2),
							(EList)$getSym(4)
						);
					setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./

	-- even though these operations do not use @pre or do not accept multiple arguments
	-- in order to get better error reporting, the rule signature must comply with
	-- the full rule of an operationCallExpCS
	-- the alternative would be to remove these as keywords, but then the parser
	-- would accept variable declarations where the var can be named "oclIsNew" for example
	operationCallExpCS ::= oclIsUndefined isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	operationCallExpCS ::= oclIsInvalid isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	operationCallExpCS ::= oclIsNew isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	operationCallExpCS ::= oclAsType isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	operationCallExpCS ::= oclIsKindOf isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	operationCallExpCS ::= oclIsTypeOf isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	operationCallExpCS ::= EQUAL isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	operationCallExpCS ::= NOT_EQUAL isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	operationCallExpCS ::= PLUS isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	operationCallExpCS ::= MULTIPLY isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	operationCallExpCS ::= DIVIDE isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	operationCallExpCS ::= GREATER isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	operationCallExpCS ::= LESS isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	operationCallExpCS ::= GREATER_EQUAL isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	operationCallExpCS ::= LESS_EQUAL isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	operationCallExpCS ::= and isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	operationCallExpCS ::= or isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	operationCallExpCS ::= xor isMarkedPreCS '(' argumentsCSopt ')'
		/.$NewCase./
	keywordOperationCallExpCS ::= keywordAsIdentifier isMarkedPreCS '(' argumentsCSopt ')'
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.IDENTIFIER_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));
					CSTNode result = createOperationCallExpCS(
							simpleNameCS,
							(IsMarkedPreCS)$getSym(2),
							(EList)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./

	operationCallExpCS ::= oclIsInState isMarkedPreCS '(' pathNameCSOpt ')'
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.KEYWORD_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));

					PathNameCS pathNameCS = (PathNameCS) dtParser.getSym(4);
					StateExpCS stateExpCS = createStateExpCS(pathNameCS);
					setOffsets(stateExpCS, pathNameCS);
				
					CSTNode result = createOperationCallExpCS(
							simpleNameCS,
							(IsMarkedPreCS)dtParser.getSym(2),
							stateExpCS
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./


	attrOrNavCallExpCS ::= simpleNameCS isMarkedPreCS
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
	attrOrNavCallExpCS ::= keywordAsIdentifier isMarkedPreCS
		/.$BeginJava
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)$getSym(2);
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.IDENTIFIER_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));
					CSTNode result = createFeatureCallExpCS(
							simpleNameCS,
							new BasicEList(),
							isMarkedPreCS
						);
					if (isMarkedPreCS.isPre()) {
						setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(2));
					} else {
						setOffsets(result, getIToken($getToken(1)));
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

	letExpCS ::= let variableCS letExpSubCSopt in oclExpressionCS
		/.$BeginJava
					EList variables = (EList)$getSym(3);
					variables.add(0, $getSym(2));
					CSTNode result = createLetExpCS(
							variables,
							(OCLExpressionCS)$getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(5));
					$setResult(result);
		  $EndJava
		./

	letExpSubCSopt ::= $empty
		/.$EmptyListAction./
	letExpSubCSopt -> letExpSubCS		


	letExpSubCS ::= ',' variableCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./

	letExpSubCS ::= letExpSubCS ',' variableCS 
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
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
							getIToken($getToken(1)).getKind(),
							(SimpleNameCS)$getSym(2),
							(EList)$getSym(4)
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
