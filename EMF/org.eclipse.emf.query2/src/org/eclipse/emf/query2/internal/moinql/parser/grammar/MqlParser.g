-- ******************************************************************************
-- Copyright (c) 2006, 2009 SAP AG and others.
-- All rights reserved. This program and the accompanying materials
-- are made available under the terms of the Eclipse Public License v1.0
-- which accompanies this distribution, and is available at
-- http://www.eclipse.org/legal/epl-v10.html
--
-- Contributors:
--     SAP AG - initial API and implementation
-- *******************************************************************************
%options escape=$
%options la=1
%options table=java
%options fp=MqlParserGen,prefix=TK_
%options error-maps
%options scopes
%options margin=4
%options noserialize
--%options backtrack
--%options template=btParserTemplateD.g
%options template=dtParserTemplateD.g
%options package=org.eclipse.emf.query2.internal.moinql.parser.gen
%options automatic_ast=toplevel,var=nt,ast_directory=./mqlAst,visitor=default,visitor-type=MqlAstVisitor,
%options ast-type=Node
%options programming_language=java
%options ParseTable=lpg.lpgjavaruntime.ParseTable
%options verbose
%options import-terminals=MqlLexer.g

$Import
	MoinParserTemplate.g
	$DropRules
	typePathName -> typeLiteral
  	$DropSymbols 
  	typeLiteral
  	primitiveType
  	collectionType
  	tupleType
  	collectionKind
  	identifierOpt
  	typePathNameOpt
  	variableDeclaration
  	withTypeExpressionOpt
  	withTypeExpression
  	variableDeclarationWithType
  	variableDeclarationWithTypeM
  	variableDeclarationWithTypeN
  	variableDeclarationM
  	variableDeclarationN
$End

$Notice
	/./**
	   * This file is generated for MOIN-MQL with LPG. 
       */
	./
$End

$Start
    query 
$End

$Headers
/.
      // special MQL constructor
      public MqlParserGen(LexStream lexStream, ProcessReport _report)
        {
            super(lexStream);
            this.report = _report;
            parserGenStart(lexStream, MqlParserGenprs.EOFT_SYMBOL, MqlParserGensym.orderedTerminalSymbols);
        }
./
$End

$Rules
    -- reworked version
    -- N indicates + (1 or more)
    -- M indicates * (0 or more)
    -- Opt indicates ? (optional)

    -- query
   	query $MqlQuery ::= selectClause fromClause whereClauseM
   	query ::= $empty
   	
   	-- select clause
   	selectClause $SelectClause  ::= select selectEntryN
   	
   	selectEntryN $SelectEntryN ::= selectEntry ',' selectEntryN
   	selectEntryN -> selectEntry
   	
   	selectEntry $SelectAlias ::= identifier
   	selectEntry $SelectAttribute ::= identifier '.' identifier
   
    -- from clause
    fromClause $FromClause ::= from fromEntryN
    
    fromEntryN $FromEntryN ::= fromEntry ',' fromEntryN
    fromEntryN -> fromEntry
    
    fromEntry $FromEntry ::= typeClause as identifier scopeClauseOpt
    
    typeClause -> typeClauseQName
    -- typeClause -> typeClauseMri
    -- typeClause -> identifier (this case is covered by the typePathName, where we check if we have a MRI)
   
    typeClauseQName $TypeQName ::= fragmentaddress withoutsubtypesOpt
    -- typeClauseQName $TypeQName ::= typePathName withoutsubtypesOpt
    -- typeClauseMri $TypeMri     ::= type identifier withoutsubtypesOpt
    
    withoutsubtypesOpt ::= $empty
    withoutsubtypesOpt $Withoutsubtypes ::= withoutsubtypes typeSetClauseOpt
    
    typeSetClauseOpt ::= $empty
    typeSetClauseOpt $TypeSetClause ::= '{' typePathNameN '}'
    
    typePathNameM ::= $empty
    typePathNameM -> typePathNameN
    typePathNameN -> fragmentaddress
    -- typePathNameN -> typePathName
    typePathNameN $TypePathNameN ::= fragmentaddress ',' typePathNameN
    -- typePathNameN $TypePathNameN ::= typePathName ',' typePathNameN
  
    elementPathNameM ::= $empty
    elementPathNameM -> elementPathNameN
    elementPathNameN -> fragmentaddress
    elementPathNameN $ElementPathNameN ::= fragmentaddress ',' elementPathNameN
   
   	fragmentaddress $FragmentAddress ::= FRAGMENTADDRESS
   	
   	uriM ::= $empty
    uriM -> uriN
    uriN -> uri
    uriN $UriN ::= uri ',' uriN
   	uri $Uri ::= URI
   
    scopeClauseOpt ::= $empty
    scopeClauseOpt $ScopeClause ::= notOpt in scopeClause
    scopeClause $PartitionScope ::= resources '{' uriM '}'
    -- scopeClause $PartitionScope ::= partitions '{' identifierM '}'
    -- scopeClause $ContainerScope ::= containers '{' identifierM '}'
    scopeClause $InElements ::= elements '{' elementPathNameM '}'
 
   	-- where clauses
  	whereClauseM ::= $empty
  	whereClauseM -> whereClauseN
  	whereClauseN -> whereClause
  	whereClauseN $WhereClauseN ::= whereClause whereClauseN
  	
  	whereClause $WhereClause ::= where whereEntry
  	
  	whereEntry -> localWhereEntry
  	whereEntry -> joinWhereEntry
  	
  	-- local where entries
  	
  	localWhereEntry $LocalWhereEntry ::= for identifier '(' localWhereCondition ')'
  	
  	localWhereCondition -> negativeWhereCondition
  	localWhereCondition $AndWhereCondition ::= localWhereCondition and negativeWhereCondition
  	localWhereCondition $OrWhereCondition ::= localWhereCondition or negativeWhereCondition
  	
  	negativeWhereCondition $NotWhereCondition ::= not negativeWhereCondition
  	negativeWhereCondition -> operationCondition
  
  	operationCondition $OperationCondition ::= identifier operationPart
  	operationCondition $ParenthesizedLocalWhereCondition ::= '(' localWhereCondition ')'
  	
  	operationPart $OpSmaller ::= '<' literal
  	operationPart $OpGreater ::= '>' literal
  	operationPart $OpSmallerEqual ::= '<=' literal
 	operationPart $OpGreaterEqual ::= '>=' literal
 	operationPart $OpEqual ::= '=' literal
  	operationPart $OpNotEqual ::= '<>' literal
  	operationPart $OpLike ::= like literal
  	operationPart $NotLike ::= not like literal 
  	
  	literal $IntegerLiteral ::= INTEGER_LITERAL 
  	literal $RealLiteral ::= REAL_LITERAL
  	literal $StringLiteral ::= STRING_LITERAL
  	literal $TrueLiteral ::= true
  	literal $FalseLiteral ::= false
  	literal $NullLiteral ::= null
  	
  	-- joining where entries
   
	joinWhereEntry $JoinWhereEntry ::= identifier '.' navigationStep joinPart
	joinWhereEntry $AliasComparisonClause ::= identifier '=' identifier 
   	
   	navigationStep $NameBasedNavigation ::= identifier -- navigationDisambiguationOpt
	-- navigationStep $MriBasedNavigation ::= INTEGER_LITERAL '[' identifier ']' 
	-- navigationDisambiguationOpt ::= $empty
    -- navigationDisambiguationOpt $AssocNavigation ::= '[' pathName ']'
   	
   	joinPart -> nonLinkPredicate
   	joinPart $LinkPredicate ::= notOpt in '(' query ')'
   	
   	-- observe that navigation disambiguation does not make sense for comparison predicates!
   	-- this should be verified by the type checker
   	nonLinkPredicate $AssocOrComparisonPredicate ::= '=' comparisonPostElementEquals 
   	nonLinkPredicate $ComparisonSmallerPredicate ::= '<' comparisonPostElementOtherOperation 
   	nonLinkPredicate $ComparisonGreaterPredicate ::= '>' comparisonPostElementOtherOperation 
   	nonLinkPredicate $ComparisonSmallerEqualPredicate ::= '<=' comparisonPostElementOtherOperation 
   	nonLinkPredicate $ComparisonGreaterEqualPredicate ::= '>=' comparisonPostElementOtherOperation 
   	nonLinkPredicate $ComparisonNotEqualPredicate ::= '<>' comparisonPostElementOtherOperation 
   	nonLinkPredicate $ComparisonLikePredicate ::= like literal 
   	nonLinkPredicate $ComparisonNotLikePredicate ::= not like literal 
   	
   	comparisonPostElementEquals $LiteralEqualsComparisonInPredicate ::= literal
   	comparisonPostElementEquals $IdentifierEqualsComparisonInPredicate ::= identifier comparisonPostFix
   	
   	comparisonPostElementOtherOperation $LiteralComparisonInPredicate ::= literal
   	comparisonPostElementOtherOperation $IdentifierComparisonInPredicate ::= identifier . identifier
   	
   	comparisonPostFix ::= $empty
   	comparisonPostFix $ComparisonPredicate ::= '.' identifier
   
   	notOpt ::= $empty
	notOpt $Not ::= not
	
$End

$Trailers
	/. 
	./
$End
