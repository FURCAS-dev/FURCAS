%options escape=$
%options la=1
%options table=java
%options fp=OclParserGen,prefix=TK_
%options error-maps
%options scopes
%options margin=4
%options noserialize
%options backtrack
%options template=btParserTemplateD.g
%options package=com.sap.tc.moin.ocl.parser.gen
%options automatic_ast=toplevel,var=nt,ast_directory=./oclAst,visitor=default,visitor-type=OclAstVisitor,
%options ast-type=Node
%options programming_language=java
%options ParseTable=lpg.lpgjavaruntime.ParseTable
%options verbose
%options import-terminals=OclLexer.g

$Import
	MoinParserTemplate.g
	$DropSymbols
	variableDeclarationM
	variableDeclarationN
	identifierM
	identifierN
	typePathNameOpt
$End

$Terminals

	INTEGER_RANGE_START

	PLUS     ::= '+'
	MINUS    ::= '-'
	MULTIPLY ::= '*'
	DIVIDE   ::= '/'

	ARROW      ::= '->'
	DOTDOT     ::= '..'
	
	BAR        ::= '|'

$End

$Rules
    --------------------------
    -- Context Declarations --
    --------------------------
    
    -- ocl file
    oclFile -> packageDeclarationN
    oclFile -> contextDeclarationN
    oclFile $ContextBodyOclFile ::= contextBody
    oclFile $OclFileOclExpression ::= oclExpression
    oclFile ::= $empty
    
    -- context bodies
    contextBody -> initOrDerValue
    contextBody -> invOrDef
    contextBody -> prePostOrBodyDecl
    
    -- 1 or more packageDeclarations
    packageDeclarationN -> packageDeclaration 
    packageDeclarationN $PackageDeclarations ::= packageDeclarationN packageDeclaration
    
    -- package declaration
    packageDeclaration $PackageDeclaration ::= package sPathName contextDeclarationM endpackage
    
    -- 0 or more contextDeclaration
    contextDeclarationM ::= $empty
    contextDeclarationM -> contextDeclarationN 
    contextDeclarationN -> contextDeclaration
    contextDeclarationN $ContextDeclarations ::= contextDeclarationN contextDeclaration 
    
    -- context declaration is one of the following three
    contextDeclaration -> attrOrAssocContext
    contextDeclaration -> classifierContextDecl
    contextDeclaration -> operationContextDecl
    
    -- attr or assoc context
    attrOrAssocContext $AttrOrAssocContextDecl ::= context sPathName withTypeExpression initOrDerValueN
    
    -- init or derived value
    initOrDerValueN -> initOrDerValue
    initOrDerValueN $InitOrDerValueN ::= initOrDerValueN initOrDerValue
    
    initOrDerValue $InitValue ::= init ':' oclExpression
    initOrDerValue $DeriveValue ::= derive ':' oclExpression
    
    -- classifier context declarations
    classifierContextDecl $ClassifierContextDecl ::= context sPathName invOrDefN

	-- invariants or definitions
	invOrDefN -> invOrDef
	invOrDefN $InvOrDefs ::= invOrDefN invOrDef

	invOrDef $InvDeclaration ::= inv identifierOpt ':' oclExpression
	invOrDef $DefDeclaration ::= def identifierOpt ':' defExpression
	invOrDef $ExpDeclaration ::= exp identifierOpt ':' oclExpression
	
	-- definition expressions
	defExpression -> variableAssignmentWithType
	defExpression $OperationDefExpression ::= operation '=' oclExpression

	-- operation context declaration
	operationContextDecl $OperationContextDecl ::= context operation prePostOrBodyDeclN

	-- 1 or more PrePostOrBodyDecl
    prePostOrBodyDeclN -> prePostOrBodyDecl
    prePostOrBodyDeclN $PrePostOrBodyDecls ::= prePostOrBodyDeclN prePostOrBodyDecl
	
	prePostOrBodyDecl $PreConditionDecl ::= pre identifierOpt ':' oclExpression
	prePostOrBodyDecl $PostConditionDecl ::= post identifierOpt ':' oclExpression
	prePostOrBodyDecl $BodyDecl ::= body identifierOpt ':' oclExpression

    -- operation
    operation $OperationDecl ::= sPathName '(' variableDeclarationWithTypeM ')' withTypeExpression
    
	-----------------------
    -- Basic Expressions --
    -----------------------
 
 	-- an ocl expression is either a let expression or a logical expression
 	oclExpression -> letExpression
 	oclExpression -> logicalExpression

	-- let expression
 	letExpression $LetExpression ::= let variableAssignmentN in oclExpression

	variableAssignmentM ::= $empty
	variableAssignmentM -> variableAssignmentN
	variableAssignmentN -> variableAssignment
	variableAssignmentN $VariableAssignmentN ::= variableAssignment ',' variableAssignmentN

	-- a variable assignment implies the assignment of an identifier, optionally with a type constraint
	variableAssignment $VariableAssignment ::= identifier withTypeExpressionOpt '=' oclExpression

	-- a variable assignment with type requires the type constraint
	variableAssignmentWithType $VariableAssignmentWithType ::= identifier withTypeExpression '=' oclExpression
  	
  	-- a var path is either self, a type literal or a path name
  	varPathName $Self ::= self
  	
  	varPathName $TypeLiteral ::= typeLiteral
  	varPathName $Variable ::= pathName timeExpressionOpt associationQualifierOpt
  	
  	----------------------
    -- Infix Operations --
    ----------------------
 
 	-- this obeys the precedence order
 
 	-- logical expressions
 	logicalExpression -> booleanExpression
  	logicalExpression $LogicalExpression ::= logicalExpression implies booleanExpression
  	
  	-- boolean expressions
  	booleanExpression -> relationalExpression
  	booleanExpression $AndBooleanExpression ::= booleanExpression and relationalExpression
  	booleanExpression $OrBooleanExpression ::= booleanExpression or relationalExpression
  	booleanExpression $XorBooleanExpression ::= booleanExpression xor relationalExpression
  	
  	-- relational expressions
 	relationalExpression -> compareableExpression
 	relationalExpression $EqualRelationalExpression ::= relationalExpression '=' compareableExpression
 	relationalExpression $NotEqualRelationalExpression ::= relationalExpression '<>' compareableExpression
 	relationalExpression $GreaterRelationalExpression ::= relationalExpression '>' compareableExpression
 	relationalExpression $LessRelationalExpression ::= relationalExpression '<' compareableExpression
 	relationalExpression $GreaterEqualRelationalExpression ::= relationalExpression '>=' compareableExpression
 	relationalExpression $LessEqualRelationalExpression ::= relationalExpression '<=' compareableExpression
 	
  	compareableExpression -> additiveExpression
  	compareableExpression -> ifExpression
  	
  	-- if expression
	ifExpression $IfExpression ::= if oclExpression then oclExpression else oclExpression endif

	-- additive expressions
  	additiveExpression -> multiplicativeExpression
  	additiveExpression $PlusAdditiveExpression ::= additiveExpression '+' multiplicativeExpression
  	additiveExpression $MinusAdditiveExpression ::= additiveExpression '-' multiplicativeExpression
  	
  	-- multiplicative expressions
   	multiplicativeExpression -> unaryExpression
  	multiplicativeExpression $MultMultiplicativeExpression ::= multiplicativeExpression '*' unaryExpression
  	multiplicativeExpression $DivideMultiplicativeExpression ::= multiplicativeExpression '/' unaryExpression
  	
  	-- unary expressions
  	unaryExpression -> postfixExpression
  	unaryExpression $MinusUnaryExpression ::= '-' unaryExpression
  	unaryExpression $NotUnaryExpression ::= not unaryExpression

   	-----------------------------------------
    -- Access to properties and operations --
    -----------------------------------------

	-- postfix expressions are either primary, or a property invocation on a post fix expressions
	postfixExpression -> primaryExpression 
	postfixExpression $PostfixExpression ::= postfixExpression propertyInvocation

	-- the most primary expression is either a literal (non-enum) or ab enum or variable reference
	-- or an operation call. Recursively, one can nest arbitrary expressions in parentheses
  	primaryExpression -> nonEnumLiteral
    primaryExpression -> operationCall
    
    -- this includes label literals for enumeration types!
    primaryExpression -> varPathName
    
	primaryExpression $ParenthesizedPrimaryExpression ::= '(' oclExpression ')'

	-- property invocation happens on collections or objects or is a loop expressions
 	propertyInvocation $ObjectPropertyInvocation ::= '.' propertyCall
 	propertyInvocation $CollectionPropertyInvocation ::= '->' propertyCall
	propertyInvocation $LoopPropertyInvocation ::= '->' loopExp

	-- property calls either handle an operation or navigate an attribute or association
	propertyCall -> operationCall
	propertyCall -> attrOrNavCall	

	-- this operation call is the most general
	operationCall $OperationCall ::= pathName timeExpressionOpt arguments
	
	-- these are built-ins
	operationCall $CallOclIsUndefined ::= oclIsUndefined timeExpressionOpt arguments 
	operationCall $CallOclIsInvalid ::= oclIsInvalid timeExpressionOpt arguments 
	operationCall $CallAllInstances ::= allInstances timeExpressionOpt arguments 
	operationCall $CallOclAsType ::= oclAsType timeExpressionOpt arguments 
	operationCall $CallOclIsKindOf ::= oclIsKindOf timeExpressionOpt arguments
	operationCall $CallOclIsTypeOf ::= oclIsTypeOf timeExpressionOpt arguments 
	
	-- in OCL, these infix primitives can be called like "normal" operations
	operationCall $CallEqual ::= '=' timeExpressionOpt arguments
	operationCall $CallNotEqual ::= '<>' timeExpressionOpt arguments
	operationCall $CallPlus ::= '+' timeExpressionOpt arguments
	operationCall $CallMult ::= '*' timeExpressionOpt arguments
	operationCall $CallDivide ::= '/' timeExpressionOpt arguments
	operationCall $CallGreater ::= '>' timeExpressionOpt arguments
	operationCall $CallLess ::= '<' timeExpressionOpt arguments
	operationCall $CallGreaterEqual ::= '>=' timeExpressionOpt arguments
	operationCall $CallLessEqual ::= '<=' timeExpressionOpt arguments
	operationCall $CallAnd ::= and timeExpressionOpt arguments
	operationCall $CallOr ::= or timeExpressionOpt arguments
	operationCall $CallXor ::= xor timeExpressionOpt arguments

	-- arguments
	arguments $NoArguments ::= '(' ')'
	arguments $MultipleArguments ::= '(' argumentN ')'

	-- an attribute or navigation call refers to a feature, optionally qualified with an assoc qualifier
	attrOrNavCall $AttrOrNavCall ::= pathName timeExpressionOpt associationQualifierOpt

	-- an association qualifier can optionally be provided
	associationQualifierOpt ::= $empty
	associationQualifierOpt -> associationQualifier
	associationQualifier $AssociationQualifier ::= '[' pathName ']'

	-- we have two types of loop expressions: iterate and the "iterators"
	loopExp -> iteratorExp
	loopExp -> iterateExp

	-- these are the built-in iterators
	iteratorExp $IteratorForAll ::= forAll '(' iterContents ')'
	iteratorExp $IteratorExists ::= exists '(' iterContents ')'
	iteratorExp $IteratorIsUnique ::= isUnique '(' iterContents ')'
	iteratorExp $IteratorOne ::= one '(' iterContents ')'
	iteratorExp $IteratorAny ::= any '(' iterContents ')'
	iteratorExp $IteratorCollect ::= collect '(' iterContents ')'
	iteratorExp $IteratorSelect ::= select '(' iterContents ')'
	iteratorExp $IteratorReject ::= reject '(' iterContents ')'
	iteratorExp $IteratorCollectNested ::= collectNested '(' iterContents ')'
	iteratorExp $IteratorSortedBy ::= sortedBy '(' iterContents ')'

	-- iterators may simply contain an expression, one var decl, or two
	iterContents -> oclExpression	
	iterContents $IteratorOneVarDecl ::= variableDeclaration '|' oclExpression
	iterContents $IteratorTwoVarDecl ::= variableDeclaration ',' variableDeclaration '|' oclExpression

	-- the iterate expression is special and allways contains an initial accumulator
	iterateExp $IterateVarDecl ::= iterate '(' variableAssignment '|' oclExpression ')'

	-- this allows the referal to preconditions
	timeExpressionOpt $TimeExpressionOpt ::= $empty

	--------------
    -- Literals --
    --------------

	-- all "normal" literals (enumeration labels are like variables because they are used defined
	-- they have a path of at least two identifiers)
	nonEnumLiteral -> primitiveLiteral
	nonEnumLiteral -> collectionLiteral
	nonEnumLiteral -> tupleLiteral
	nonEnumLiteral -> nullLiteral
	nonEnumLiteral -> invalidLiteral

	-- collection literal
	collectionLiteral $CollectionLiteral ::= collectionKind '{' collectionLiteralPartM '}'

	-- 0 or more collection literals
	collectionLiteralPartM ::= $empty
	collectionLiteralPartM -> collectionLiteralPartN
	collectionLiteralPartN -> collectionLiteralPart
	collectionLiteralPartN $CollectionLiteralParts ::= collectionLiteralPartN ',' collectionLiteralPart

	-- can be either a range or an expression
	collectionLiteralPart $CollectionLiteralExpression ::= oclExpression collectionRangeOpt
	-- special range required for bizarre OCL syntax: e.g. 1..someExp
	collectionLiteralPart $CollectionLiteralIntegerRange ::= minusOpt integerLiteralRange oclExpression
	
	integerLiteralRange $IntegerLiteralRange ::= INTEGER_RANGE_START
	
	minusOpt ::= $empty
	minusOpt $Minus ::= '-'

	-- collection ranges
	collectionRangeOpt ::= $empty
	collectionRangeOpt $CollectionRange ::= '..' oclExpression

	-- the primitive literals
	primitiveLiteral -> integerLiteral
	primitiveLiteral -> realLiteral
	primitiveLiteral -> stringLiteral
	primitiveLiteral -> booleanLiteral

	integerLiteral $IntegerLiteral ::= INTEGER_LITERAL	
	realLiteral $RealLiteral ::= REAL_LITERAL
	stringLiteral $StringLiteral ::= STRING_LITERAL	
	booleanLiteral $BooleanLiteralTrue ::= true		
	booleanLiteral $BooleanLiteralFalse ::= false	
	nullLiteral $NullLiteral ::= null
	invalidLiteral $InvalidLiteral ::= invalid

	-- tuple literals
	tupleLiteral $TupleLiteral ::= Tuple '{' variableAssignmentM '}'

$End

$Trailers
	/. 
	./
$End
