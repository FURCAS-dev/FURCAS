package org.oslo.ocl20;

import java.io.PrintWriter;
import java.io.Reader;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.oslo.ocl20.semantics.analyser.OclSemanticAnalyser;
import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.semantics.factories.BridgeFactory;
import org.oslo.ocl20.semantics.factories.TypeFactory;
import org.oslo.ocl20.standard.lib.OclAny;
import org.oslo.ocl20.standard.lib.StdLibAdapter;
import org.oslo.ocl20.syntax.ast.contexts.PackageDeclarationAS;
import org.oslo.ocl20.syntax.parser.OclParser;
import org.oslo.ocl20.synthesis.ModelEvaluationAdapter;
import org.oslo.ocl20.synthesis.ModelGenerationAdapter;
import org.oslo.ocl20.synthesis.OclCodeGenerator;
import org.oslo.ocl20.synthesis.OclEvaluator;
import org.oslo.ocl20.synthesis.RuntimeEnvironment;

import uk.ac.kent.cs.kmf.util.ILog;

/**
 * @author dha
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public interface OclProcessor {
	
	public static final boolean supportStringExtension = true; 
	
		/*
		 * add by Heini
		 */
		public RuntimeEnvironment renv_=null;
		public Boolean getDebug();
		public void setDebug(Boolean d);
		public ILog getLog();
		public void setLog(ILog log);
	
		public StdLibAdapter getStdLibAdapter();
		public StdLibAdapter getStdLibGenerationAdapter();		
		public String getStdLibAdapterName();

		public ModelGenerationAdapter getModelGenerationAdapter();
		public ModelEvaluationAdapter getModelEvaluationAdapter();
		public String getModelImplAdapterName();

		public BridgeFactory getBridgeFactory();
		public TypeFactory getTypeFactory();
	
		public OclParser getParser();
		public OclSemanticAnalyser getAnalyser();
		public OclEvaluator getEvaluator();
		public OclCodeGenerator getGenerator();

		public List getModels();
		public void setModels(Collection models);
		public Collection getMetaModels();
		public Collection getModelsForAllInstances();
	
		/**
		 * Parse the passed string as a package declaration.
		 * 
		 * A non null valued result implies a successful (error free) parse.
		 * 
		 */
		public PackageDeclarationAS parse(String str);
		public PackageDeclarationAS parse(String str, ILog log);
		public PackageDeclarationAS parse(String str, ILog log, boolean debug);
		public PackageDeclarationAS parse(Reader input);
		public PackageDeclarationAS parse(Reader input, ILog log);

		/**
		 * Semantic analysis of the passed package declaration from ast
		 * with output going to the System.out.
		 * 
		 * The result contains a list of ContextDeclaration.
		 */
		public List analyse(PackageDeclarationAS pd);
		public List analyse(PackageDeclarationAS pd, ILog log);
		public List analyse(PackageDeclarationAS pd, Environment env, ILog log);

		/**
		 * Semantic analysis of the passed string which contains a package declaration
		 * with output going to the passed log object.
		 * 
		 * The string may be a number of contexts.
		 * The result contains a list of ContextDeclaration.
		 */
		public List analyse(String str);
		public List analyse(String str, ILog log);
		public List analyse(String str, Environment env, ILog log);

		/**
		 * Semantic analysis of the passed string which contains a package declaration
		 * with output going to the passed log object.
		 * 
		 * The string may be a number of contexts.
		 * The result contains a list of ContextDeclaration.
		 */
		public List analyse(Reader reader);
		public List analyse(Reader reader, ILog log);
		public List analyse(Reader reader, Environment env, ILog log);

		/**
		 * Evaluate the passed string as an ocl expression.
		 * (Assumes a single context)
		 * 
		 * If the expression does not start with the string 'context'
		 * it is assumed that no context has been provided and a default
		 * 'context VoidType inv:' is added to the front of the passed expression,
		 * the type 'VoidType' is added the the type environment,
		 * and the OCL value 'Undefined' is added as 'self'.
		 * 
		 * The result contains the value of the evaluated expression.
		 * 
		 */
		public List evaluate(String str);
		public List evaluate(String str, Object self);
		public List evaluate(String str, Object self, ILog log);
		public List evaluate(String str, Environment env, RuntimeEnvironment renv, ILog log);
		public List evaluate_2(String str, Environment env, RuntimeEnvironment renv, ILog log);
		
		public List evaluate(Reader reader, Object self, ILog log);
		public List evaluate(Reader reader, Object self);
		public List evaluate(Reader reader, Environment env, RuntimeEnvironment renv, ILog log);

		/**
		 * The result is an Ocl Object as opposed to a Java Object as returned by the other evaluate
		 * methods.
		 */
        public OclAny evaluateAsOCL(String expr, Environment env, RuntimeEnvironment renv, ILog log);

        /* The result contains a Map of the inv names and values of the evaluated expressions.
		 * 
		 */

		public Map evaluateAll(Reader reader, Object self, ILog log);
		
		/**
		 * Generate code for an input passed as a string 
		 * with provided indentation
		 * 
		 * The result contains the list of Pairs.
		 * 
		 */
		public List generate(String str, String indent);
		public List generate(String str, String indent, ILog log);
		public List generate(String str, String indent, Environment env, ILog log);
		
		public List generate(Reader reader, String indent);
		public List generate(Reader reader, String indent, ILog log);
		public List generate(Reader reader, String indent, Environment env, ILog log);
		
		public void generate(Reader input, PrintWriter output, String pkgName, String className, ILog log);

		/**
		 * Create a type environment
		 * that includes the passed Object as the passed name.
		 * ( additional objects can be added using 'setValue("name", object)' )
		 */
		public Environment environment();
		public Environment environment(String name, Object obj);

		/**
		 * Create a runtime environment
		 * that includes the passed Object as the passed name.
		 * ( additional objects can be added using 'setValue("name", object)' )
		 * 
		 */
		public RuntimeEnvironment runtimeEnvironment();
		public RuntimeEnvironment runtimeEnvironment(String name, Object obj);

		/*
		 *  Get the current runtime environment
		 *  (needed for allInstances()
		 *  add by Heini
		 */
		public RuntimeEnvironment getRuntimeEnvironment();


}
