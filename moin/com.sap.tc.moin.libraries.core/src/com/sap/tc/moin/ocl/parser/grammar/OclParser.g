%options escape=$
%options la=1
%options table=java
%options fp=OclParserGen,prefix=TK_
%options error-maps
%options scopes
%options margin=4
%options noserialize
--%options backtrack
--%options template=btParserTemplateD.g
%options template=dtParserTemplateD.g
%options package=com.sap.tc.moin.ocl.parser.gen
%options automatic_ast=toplevel,var=nt,ast_directory=./oclAst,visitor=default,visitor-type=OclAstVisitor,
%options ast-type=Node
%options programming_language=java
%options ParseTable=lpg.lpgjavaruntime.ParseTable
%options verbose
%options import-terminals=OclLexer.g

$Import
	OclParserBase.g
$End

$Notice
	/./**
	   * This file is generated for MOIN-OCL with LPG. 
       */
	./
$End

$Start
    ocl
$End

$Terminals
	ATPRE      ::= '@pre'
	SEMICOLON  ::= ';'
$End

$Headers
/.
      // special OCL constructor
      public OclParserGen(LexStream lexStream, ProcessReport _report)
        {
            super(lexStream);
            this.report = _report;
            parserGenStart(lexStream, OclParserGenprs.EOFT_SYMBOL, OclParserGensym.orderedTerminalSymbols);
        }
./
$End

$Rules
	ocl -> oclFile

	timeExpressionOpt $TimeExpressionOpt ::= ATPRE
	
	argumentN -> oclExpression 
	argumentN $Arguments ::= argumentN ',' oclExpression 
	
	-- operationCall $CallOclIsNew ::= oclIsNew timeExpressionOpt arguments 
	iterateExp $IterateVarDeclAndAcc ::= iterate '(' variableDeclaration ';' variableAssignment '|' oclExpression ')'
$End
