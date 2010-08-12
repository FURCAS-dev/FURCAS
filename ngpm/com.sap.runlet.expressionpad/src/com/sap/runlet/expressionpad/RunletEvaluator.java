package com.sap.runlet.expressionpad;

import generated.ClassLexer;
import generated.ClassParser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenRewriteStream;
import org.omg.ocl.expressions.VariableDeclaration;

import behavioral.actions.Block;
import behavioral.actions.Statement;

import com.sap.ap.cts.monet.parser.ClassParserFactory;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.runlet.abstractexpressionpad.Evaluator;
import com.sap.runlet.abstractinterpreter.StackFrame;
import com.sap.runlet.abstractinterpreter.repository.Repository;
import com.sap.runlet.interpreter.Activator;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.repository.simpleimpl.RunletInMemoryRepository;
import com.sap.tc.moin.repository.Connection;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

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
 */
public class RunletEvaluator 
extends Evaluator<
        	SapClass, 
        	TypeDefinition, 
        	ClassTypeDefinition, 
        	Association, 
        	AssociationEnd, 
        	Statement, 
        	Expression, 
        	SignatureImplementation, 
        	RunletStackFrame, 
        	NativeImpl, 
        	RunletInterpreter, 
        	Block> {
    
    public RunletEvaluator(String projectName) {
	super(projectName);
    }
    
    public RunletEvaluator(String projectName, Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> repository) {
	super(projectName, repository);
    }
    
    public RunletEvaluator(Connection connection, Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> repository) {
	super(connection, repository);
    }

    @Override
    protected Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> createRepository() {
	return new RunletInMemoryRepository(Activator.getDefault().getModelAdapter());
    }
    
    @Override
    protected ObservableInjectingParser createParser(String statementString) {
	ClassParserFactory factory = new ClassParserFactory();
	ClassLexer lexer = factory.createLexer(new ANTLRStringStream(statementString));
	return factory.createParser(new TokenRewriteStream(lexer), getConnection());
    }
    
    @Override
    protected void initLocalFields(Connection connection, Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> repository) {
	setStackFrame(new RunletStackFrame());
	Block contextBlock = connection.createElement(Block.CLASS_DESCRIPTOR);
	contextBlock.assign___PartitionIncludingChildren(connection.getOrCreateTransientPartition("RunletConsoleObjects"));
	setContextBlock(contextBlock);
	setInterpreter(new RunletInterpreter(connection, repository));
    }
    
    @Override
    protected void addToBlock(Statement statement, Block contextBlock) {
	contextBlock.getStatements().add(statement);
	
    }

    @Override
    protected int getStatementSeperatorBit() {
	return ClassParser.SEMICOLON;
    }

    @Override
    protected Expression parseExpression(ObservableInjectingParser parser) throws RecognitionException {
	return (Expression) ((ClassParser) parser).dataaccess_expressions_expression();
    }

    @Override
    protected Statement parseStatement(ObservableInjectingParser parser) throws RecognitionException {
	return (Statement) ((ClassParser)parser).behavioral_actions_statement();
    }


}
