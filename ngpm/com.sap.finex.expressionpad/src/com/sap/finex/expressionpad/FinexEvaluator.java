package com.sap.finex.expressionpad;

import generated.FinexClassLexer;
import generated.FinexClassParser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenRewriteStream;
import org.omg.ocl.expressions.VariableDeclaration;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Block;
import behavior.actions.Statement;
import behavior.expressions.Expression;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.editor.FinexClassParserFactory;
import com.sap.finex.interpreter.FinexInMemoryRepository;
import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.runlet.abstractexpressionpad.Evaluator;
import com.sap.runlet.abstractinterpreter.StackFrame;
import com.sap.runlet.abstractinterpreter.repository.Repository;
import com.sap.tc.moin.repository.Connection;

/**
 * Evaluator for Runlet Programming Language.
 * 
 * Takes an expression or a statement in a concrete textual syntax as specified by Expressions.tcs
 * and parses it into a transient set of model elements. If parsing went through correctly, the
 * resulting {@link Expression} or {@link Statement} is handed to the
 * {@link RunletInterpreter interpreter} for evaluation. The results are then displayed.
 * <p>
 * 
 * For statement execution, an instance of this class maintains a {@link StackFrame} to which
 * variables can be added, e.g., by a {@link VariableDeclaration} statement.
 * 
 * @author Jan Karstens (D046040)
 * @author Axel Uhl (D043530)
 */
public class FinexEvaluator 
extends Evaluator<
        	FinexClass, 
        	Type, 
        	FinexClass, 
        	Association, 
        	Field, 
        	Statement, 
        	Expression, 
        	SignatureImplementation, 
        	FinexStackFrame, 
        	NativeImpl,
        	FinexInterpreter, 
        	Block> {
    
    public FinexEvaluator(String projectName) {
	super(projectName);
    }
    
    public FinexEvaluator(String projectName, Repository<Association, Field, FinexClass, Type, FinexClass> repository) {
	super(projectName, repository);
    }
    
    public FinexEvaluator(Connection connection, Repository<Association, Field, FinexClass, Type, FinexClass> repository) {
	super(connection, repository);
    }

    @Override
    protected Repository<Association, Field, FinexClass, Type, FinexClass> createRepository() {
	return new FinexInMemoryRepository(com.sap.finex.interpreter.Activator.getDefault().getModelAdapter());
    }
    
    @Override
    protected ObservableInjectingParser createParser(String statementString) {
	FinexClassParserFactory factory = new FinexClassParserFactory();
	FinexClassLexer lexer;
	if (statementString.endsWith(";")) {
	    lexer = factory.createLexer(new ANTLRStringStream(statementString));
	} else {
	    lexer = factory.createLexer(new ANTLRStringStream(statementString+";"));
	}
	return factory.createParser(new TokenRewriteStream(lexer), getConnection());
    }
    
    @Override
    protected void initLocalFields(Connection connection, Repository<Association, Field, FinexClass, Type, FinexClass> repository) {
	setStackFrame(new FinexStackFrame());
	Block contextBlock = connection.createElement(Block.CLASS_DESCRIPTOR);
	contextBlock.assign___PartitionIncludingChildren(connection.getOrCreateTransientPartition("FinexConsoleObjects"));
	setContextBlock(contextBlock);
	setInterpreter(new FinexInterpreter(connection, repository));
    }
    
    @Override
    protected void addToBlock(Statement statement, Block contextBlock) {
	statement.setBlock(contextBlock);
    }

    @Override
    protected int getStatementSeperatorBit() {
	return FinexClassParser.SEMICOLON;
    }

    @Override
    protected Expression parseExpression(ObservableInjectingParser parser) throws RecognitionException {
	return (Expression) ((FinexClassParser) parser).behavior_expressions_expression();
    }

    @Override
    protected Statement parseStatement(ObservableInjectingParser parser) throws RecognitionException {
	return (Statement) ((FinexClassParser)parser).behavior_actions_statement();
    }


}
