package org.oslo.ocl20;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.management.Query;

import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.semantics.bridge.Namespace;
import org.oslo.ocl20.semantics.model.contexts.Constraint;
import org.oslo.ocl20.semantics.model.contexts.ConstraintKind;
import org.oslo.ocl20.semantics.model.contexts.ContextDeclaration;
import org.oslo.ocl20.standard.lib.OclAny;
import org.oslo.ocl20.syntax.ast.contexts.PackageDeclarationAS;
import org.oslo.ocl20.synthesis.RuntimeEnvironment;
import org.oslo.ocl20.synthesis.RuntimeEnvironmentImpl;

import uk.ac.kent.cs.kmf.util.ILog;

/**
 * 
 * @author Octavian Patrascoiu
 * 
 */

abstract public class OclProcessorImpl implements OclProcessor {

	/**
	 * Line information of parsed QVT/OCL code is offset by this value
	 */
	static public int lineDelta = 0;

	/*
	 * add by Heini
	 */
	public RuntimeEnvironment renv_ = null;

	public OclProcessorImpl(ILog log) {
		this.log = log;
	}

	protected Boolean debug = Boolean.FALSE;

	public void setDebug(Boolean d) {
		debug = d;
	}

	public Boolean getDebug() {
		return debug;
	}

	protected ILog log = null;

	public ILog getLog() {
		return log;
	}

	public void setLog(ILog l) {
		log = l;
	}

	// Can't make impl of TypeFactory, Evaluator, Generator etc common
	// as they all use (directly or indirectly) the BridgeFactory which
	// is bridge specific !

	/**
	 * List of a collection of models (for QVT: each collection corresponds to a transformation direction).
	 */
	protected java.util.List models = new ArrayList();

	/**
	 * Set of all models
	 */
	protected List modelSet = new ArrayList();

	public List getModels() {
		return Collections.unmodifiableList(modelSet);
	}

	/**
	 * Validates the given model. If the model cannot be validated as acceptable model for the given repository
	 * technology, <code>null</code> shall be returned, otherwise, the model itself or a another representation of the
	 * model more suitable for the actual repository technology shall be returned.
	 * 
	 * @param mdl
	 * @return
	 */
	abstract protected Object validateModel(Object mdl);

	/**
	 * Sets the models to be operated on by an OCL or QVT processor. An item of <code>models</code> represents either
	 * a model which can be validated and/or adapted by {@link #validateModel(Object)} or is a collection of such
	 * models, which forms a "model space" for the <code>i</code>-th QVT direction, where <code>i</code> is the
	 * index of this collection in <code>models</code>.
	 * 
	 * @param models
	 */
	public void setModels(Collection models) {

		this.modelSet = new ArrayList();
		this.models = new ArrayList();
		for (Iterator iter = models.iterator(); iter.hasNext();) {
			Object element = (Object) iter.next();
			List nestedModels = new ArrayList();
			if (element instanceof Collection) {
				Collection modelCollection = (Collection) element;
				for (Iterator iter2 = modelCollection.iterator(); iter2.hasNext();) {
					Object nestedElement = (Object) iter2.next();
					Object mdl = validateModel(nestedElement);
					if (mdl != null) {
						nestedModels.add(mdl);
						if (!modelSet.contains(mdl)) {
							modelSet.add(mdl);
						}
					}
				}
			} else {
				Object mdl = validateModel(element);
				if (mdl != null) {
					nestedModels.add(mdl);
					if (!modelSet.contains(mdl)) {
						modelSet.add(mdl);
					}
				}
			}
			this.models.add(nestedModels);
		}
	}

	/**
	 * Parse the passed string as a package declaration.
	 * 
	 * A null valued result implies a successful (error free) parse.
	 * 
	 */
	public PackageDeclarationAS parse(String str) {
		// if (!str.startsWith("context")) str = "context OclVoid inv: "+str;
		return parse(str, getLog());
	}

	/**
	 * Parse the passed string as a package declaration with output going to the passed log object.
	 * 
	 * A null valued result implies a successful (error free) parse.
	 * 
	 */
	public PackageDeclarationAS parse(String str, ILog log) {
		// if (!str.startsWith("context")) str = "context OclVoid inv: "+str;
		log.resetErrors();
		PackageDeclarationAS pd = getParser().parse(new StringReader(str), log, false);
		if (log.hasErrors())
			return null;
		return pd;
	}

	public PackageDeclarationAS parse(String str, ILog log, boolean debug) {
		// if (!str.startsWith("context")) str = "context OclVoid inv: "+str;
		PackageDeclarationAS pd = this.getParser().parse(new StringReader(str), log, debug);
		if (log.hasErrors())
			return null;
		return pd;
	}

	/**
	 * Parse the passed file as a package declaration.
	 * 
	 * A null valued result implies a successful (error free) parse.
	 * 
	 */
	public PackageDeclarationAS parse(Reader input) {
		return parse(input, getLog());
	}

	/**
	 * Parse the passed string as an OCL expression with output going to the passed log object.
	 * 
	 * A null valued result implies a successful (error free) parse.
	 * 
	 */
	public PackageDeclarationAS parse(Reader input, ILog log) {
		PackageDeclarationAS pd = this.getParser().parse(input, log, this.getDebug().booleanValue());
		return pd;
	}

	/**
	 * Semantic analysis of the passed package declaration from ast with output going to the System.out.
	 * 
	 * The result contains a list of ContextDeclaration.
	 */
	public List analyse(PackageDeclarationAS pd) {
		return analyse(pd, getLog());
	}

	public List analyse(PackageDeclarationAS pd, ILog log) {
		// --- Create an environment ---
		Environment env = this.environment();
		return analyse(pd, env, log);
	}

	public List analyse(PackageDeclarationAS pd, Environment env, ILog log) {
		if (pd == null) {
			return null;
		}
		if (env == null) {
			env = this.environment();
		}
		List contextDecls = getAnalyser().analyse(pd, env, log, getDebug().booleanValue());
		return contextDecls;
	}

	/**
	 * Semantic analysis of the passed string which contains a package declaration with output going to the passed log
	 * object.
	 * 
	 * The string may be a number of contexts. The result contains a list of ContextDeclaration.
	 */
	public List analyse(String str) {
		return analyse(str, getLog());
	}

	/**
	 * Semantic analysis of the passed string which contains a package declaration with output going to the passed log
	 * object.
	 * 
	 * The string may be a number of contexts. The result contains a list of ContextDeclaration.
	 */
	public List analyse(String str, ILog log) {
		// --- Parse the input ---
		PackageDeclarationAS pd = parse(str, log);
		return analyse(pd, log);
	}

	/**
	 * Semantic analysis of the passed string which contains a package declaration with output going to the passed log
	 * object.
	 * 
	 * The string may be a number of contexts. The result contains a list of ContextDeclaration.
	 */
	public List analyse(Reader reader) {
		return analyse(reader, getLog());
	}

	/**
	 * Semantic analysis of the passed string which contains a package declaration with output going to the passed log
	 * object.
	 * 
	 * The string may be a number of contexts. The result contains a list of the values of the evaluated expression.
	 * 
	 */
	public List analyse(Reader reader, ILog log) {
		// --- Parse the input ---
		PackageDeclarationAS pd = parse(reader, log);
		return analyse(pd, log);
	}

	public List analyse(String str, Environment env, ILog log) {
		PackageDeclarationAS pd = parse(str, log);
		return analyse(pd, env, log);
	}

	public List analyse(Reader reader, Environment env, ILog log) {
		PackageDeclarationAS pd = parse(reader, log);
		return analyse(pd, env, log);
	}

	/**
	 * Evaluate the passed string as an ocl expression. (Assumes a single context)
	 * 
	 * If the expression does not start with the string 'context' it is assumed that no context has been provided and a
	 * default 'context OclVoid inv:' is added to the front of the passed expression, the type 'OclVoid' is added the
	 * the type environment, and the OCL value 'Undefined' is added as 'self'.
	 * 
	 * The result contains the value of the evaluated expression.
	 * 
	 */
	public List evaluate(String str) {
		ILog log = getLog();
		if (!str.startsWith("context") && !str.contains("context OclVoid inv:"))
			str = "context OclVoid inv: " + str;
		List cs = analyse(str);
		if (cs == null)
			return null;
		List result = new Vector();
		Iterator i = cs.iterator();
		while (i.hasNext()) {
			ContextDeclaration decl = (ContextDeclaration) i.next();
			Map declRes = this.getEvaluator().evaluate(decl, renv_ = runtimeEnvironment("self", this.getStdLibAdapter().Undefined()), log);
			result.addAll(declRes.values());
		}
		return result;
	}

	/**
	 * Evaluation of the passed string which contains a package declaration in the context of self with output going to
	 * System.out.
	 * 
	 * The string may be a number of contexts which will be evaluated using same runtime environment. The result
	 * contains a list of the values of the evaluated expressions.
	 * 
	 */
	public List evaluate(String str, Object self) {
		ILog log = getLog();
		return evaluate(str, self, log);
	}

	/**
	 * Semantic analysis of the passed string which contains a package declaration in the context of self with output
	 * going to the passed log object.
	 * 
	 * The string may be a number of contexts which will be evaluated using same runtime environment. The result
	 * contains a list of the values of the evaluated expressions.
	 * 
	 */
	public List evaluate(String str, Object self, ILog log) {
		List cs = analyse(str, log);
		if (cs == null)
			return null;
		List result = new Vector();
		Iterator i = cs.iterator();
		while (i.hasNext()) {
			ContextDeclaration decl = (ContextDeclaration) i.next();
			Map declRes = this.getEvaluator().evaluate(decl, renv_ = runtimeEnvironment("self", self), log);
			result.addAll(declRes.values());
		}
		return result;
	}

	/**
	 * Evaluates the ASTs in <code>cs</code>
	 * 
	 * @param cs
	 * @param renv
	 * @param log
	 * @return
	 */
	public List evaluate(List cs, RuntimeEnvironment renv, ILog log) {
		if (cs == null)
			return null;
		List result = new Vector();
		Iterator i = cs.iterator();
		while (i.hasNext()) {
			ContextDeclaration decl = (ContextDeclaration) i.next();
			Map declRes = this.getEvaluator().evaluate(decl, renv, log);
			result.addAll(declRes.values());
		}
		return result;
	}

	/**
	 * Semantic analysis of the passed file which contains a package declaration in the context of self with output
	 * going to the passed log object.
	 * 
	 * The string may be a number of contexts which will be evaluated using same runtime environment. The result
	 * contains a list of the values of the evaluated expressions.
	 * 
	 */
	public List evaluate(Reader reader, Object self, ILog log) {
		List cs = analyse(reader, log);
		if (cs == null)
			return null;
		List result = new Vector();
		Iterator i = cs.iterator();
		while (i.hasNext()) {
			ContextDeclaration decl = (ContextDeclaration) i.next();
			Map declRes = this.getEvaluator().evaluate(decl, renv_ = runtimeEnvironment("self", self), log);
			result.addAll(declRes.values());
		}
		return result;
	}

	public Map evaluateAll(Reader reader, Object self, ILog log) {
		List cs = analyse(reader, log);
		if (cs == null)
			return null;
		Map result = new HashMap();
		Iterator i = cs.iterator();
		while (i.hasNext()) {
			ContextDeclaration decl = (ContextDeclaration) i.next();
			Map declRes = this.getEvaluator().evaluate(decl, renv_ = runtimeEnvironment("self", self), log);
			result.putAll(declRes);
		}
		return result;
	}

	/**
	 * Semantic analysis of the passed file which contains a package declaration in the context of self with output
	 * going to System.out.
	 * 
	 * The string may be a number of contexts which will be evaluated using same runtime environment. The result
	 * contains a list of the values of the evaluated expressions.
	 * 
	 */
	public List evaluate(Reader reader, Object self) {
		ILog log = getLog();
		return evaluate(reader, log);
	}

	public List evaluate(String str, Environment env, RuntimeEnvironment renv, ILog log) {
		/*
		 * add by Heini
		 */
		renv_ = renv;

		List cs = analyse(str, env, log);
		if (cs == null)
			return null;
		List result = new Vector();
		Iterator i = cs.iterator();
		while (i.hasNext()) {
			ContextDeclaration decl = (ContextDeclaration) i.next();
			Map declRes = this.getEvaluator().evaluate(decl, renv, log);
			result.addAll(declRes.values());
		}
		return result;
	}

	public List evaluate_2(String str, Environment env, RuntimeEnvironment renv, ILog log) {
		/*
		 * returns null the corresponding result provides evaluate_2 in EmfOclProcessorImpl
		 */
		return null;
	}

	public List evaluate(Reader reader, Environment env, RuntimeEnvironment renv, ILog log) {

		/*
		 * add by Heini
		 */
		renv_ = renv;

		List cs = analyse(reader, env, log);
		if (cs == null)
			return null;
		List result = new Vector();
		Iterator i = cs.iterator();
		while (i.hasNext()) {
			ContextDeclaration decl = (ContextDeclaration) i.next();
			Map declRes = this.getEvaluator().evaluate(decl, renv, log);
			result.addAll(declRes.values());
		}
		return result;
	}

	public OclAny evaluateAsOCL(String str, Environment env, RuntimeEnvironment renv, ILog log) {
		List cs = analyse(str, env, log);
		if (cs == null)
			return null;
		OclAny result = null;
		List results = new Vector();
		Iterator i = cs.iterator();
		while (i.hasNext()) {
			ContextDeclaration decl = (ContextDeclaration) i.next();
			Iterator ci = decl.getConstraint().iterator();
			while (ci.hasNext()) {
				Constraint constraint = (Constraint) ci.next();
				if (!ConstraintKind.DEF_LITERAL.equals(constraint.getKind())) {
					OclAny x = this.getEvaluator().evaluateAsOCL(decl, renv, log);
					results.add(x);
				}
			}
		}
		return (OclAny) results.get(0);
	}

	/**
	 * Generate code for an input passed as a string with provided indentation
	 * 
	 * The result contains the list of Pairs.
	 * 
	 */
	public List generate(String str, String indent) {
		ILog log = getLog();
		List cs = analyse(str);
		if (cs == null)
			return null;
		List result = new Vector();
		Iterator i = cs.iterator();
		while (i.hasNext()) {
			ContextDeclaration decl = (ContextDeclaration) i.next();
			List declRes = this.getGenerator().generate(decl, indent, this);
			result.addAll(declRes);
		}
		return result;
	}

	/**
	 * Generate code for an input passed as a string with provided indentation
	 * 
	 * The result contains the list of Pairs.
	 * 
	 */
	public List generate(String str, String indent, ILog log) {
		List cs = analyse(str, log);
		if (cs == null)
			return null;
		List result = new Vector();
		Iterator i = cs.iterator();
		while (i.hasNext()) {
			ContextDeclaration decl = (ContextDeclaration) i.next();
			List declRes = this.getGenerator().generate(decl, indent, this);
			result.addAll(declRes);
		}
		return result;
	}

	/**
	 * Generate code for constraints passed as a file with provided indentation and provided log
	 * 
	 * The result contains the name of the variable that contains the value.
	 * 
	 */
	public List generate(Reader reader, String indent) {
		ILog log = getLog();
		List cs = analyse(reader, log);
		if (cs == null)
			return null;
		List result = new Vector();
		Iterator i = cs.iterator();
		while (i.hasNext()) {
			ContextDeclaration decl = (ContextDeclaration) i.next();
			List declRes = this.getGenerator().generate(decl, indent, this);
			result.addAll(declRes);
		}
		return result;
	}

	/**
	 * Generate code for constraints passed as a file with provided indentation and provided log
	 * 
	 * The result contains the name of the variable that contains the value.
	 * 
	 */
	public List generate(Reader reader, String indent, ILog log) {
		List cs = analyse(reader, log);
		if (cs == null)
			return null;
		List result = new Vector();
		Iterator i = cs.iterator();
		while (i.hasNext()) {
			ContextDeclaration decl = (ContextDeclaration) i.next();
			List declRes = this.getGenerator().generate(decl, indent, this);
			result.addAll(declRes);
		}
		return result;
	}

	public List generate(String str, String indent, Environment env, ILog log) {
		List cs = analyse(str, env, log);
		if (cs == null)
			return null;
		List result = new Vector();
		Iterator i = cs.iterator();
		while (i.hasNext()) {
			ContextDeclaration decl = (ContextDeclaration) i.next();
			List declRes = this.getGenerator().generate(decl, indent, this);
			result.addAll(declRes);
		}
		return result;
	}

	public List generate(Reader reader, String indent, Environment env, ILog log) {
		List cs = analyse(reader, env, log);
		if (cs == null)
			return null;
		List result = new Vector();
		Iterator i = cs.iterator();
		while (i.hasNext()) {
			ContextDeclaration decl = (ContextDeclaration) i.next();
			List declRes = this.getGenerator().generate(decl, indent, this);
			result.addAll(declRes);
		}
		return result;
	}

	/**
	 * Generate code for the constraints stored into the input file into the output file and given package using the
	 * provided log and a given layout
	 * 
	 */
	/*
	 * public void generate(Reader input, PrintWriter output, String pkgName, String outClassName, ILog log) { try {
	 * OclToStringVisitorImpl toStringVisitor = new OclToStringVisitorImpl(); //--- Print class header ---
	 * output.println("package " + pkgName + ";"); output.println(); output.println("public class " + outClassName + "
	 * {"); output.println(defsMethod()); int invCount = 0; String tab = "\t"; try { // Analyse input List cs =
	 * this.analyse(input, log); if (cs != null) { // Group all context declarations according to context name Map
	 * contexts = new HashMap(); Map defs = new HashMap(); Iterator i = cs.iterator(); // For each context declaration
	 * while (i.hasNext()) { // Generate code ContextDeclaration decl = (ContextDeclaration) i.next(); // For each
	 * context at class level if (decl != null && decl instanceof ClassifierContextDecl) { OclModelElementType selfType =
	 * (OclModelElementType) decl.getReferredNamespace(); if (contexts.get(selfType) == null) contexts.put(selfType, new
	 * Vector()); ((List) contexts.get(selfType)).add(decl); //add Defined properties and Operations Iterator ic =
	 * decl.getConstraint().iterator(); while (ic.hasNext()) { Constraint cons = (Constraint) ic.next(); if
	 * (cons.getKind() == ConstraintKind.DEF_LITERAL) { if (defs.get(selfType) == null) defs.put(selfType, new
	 * Vector()); ((List) defs.get(selfType)).add(cons); } } } } // Generate code for defs Iterator id =
	 * defs.keySet().iterator(); while (id.hasNext()) { OclModelElementType selfType = (OclModelElementType) id.next();
	 * List l = (List) defs.get(selfType); Iterator ic = l.iterator(); while (ic.hasNext()) { Constraint cons =
	 * (Constraint) ic.next(); if (cons.getDefProperty() != null) { String defName = cons.getDefProperty().getName();
	 * Class retType = (Class) cons.getDefProperty().getType().getDelegate(); Class selfCls = (Class)
	 * selfType.getDelegate(); OclAnyImpl result = (OclAnyImpl) this.getGenerator().generate(cons, tab + tab + tab +
	 * tab, this); output.println(tab + "public static " + retType.getName() + " " + defName + "(" + selfCls.getName() + "
	 * self) {"); output.println(tab + tab + "/*\n " + cons.accept(toStringVisitor, new HashMap()) + "\n
	 *//*
		 * "); output.print(result.getInitialisation()); output.println(tab + tab + "return " + result.asJavaObject() +
		 * ";"); output.println(tab + "}"); } else if (cons.getDefOperation() != null) { String defName =
		 * cons.getDefOperation().getName(); Class retType = (Class)
		 * cons.getDefOperation().getReturnType().getDelegate(); Class selfCls = (Class) selfType.getDelegate();
		 * OclAnyImpl result = (OclAnyImpl) this.getGenerator().generate(cons, tab + tab + tab + tab, this);
		 * output.println(tab + "public static " + retType.getName() + " " + defName + "(" + selfCls.getName() + "
		 * self"); for(int pi = 0; pi < cons.getDefOperation().getParameterNames().size(); pi++) { String pName =
		 * (String)cons.getDefOperation().getParameterNames().get(pi); Classifier pType =
		 * (Classifier)cons.getDefOperation().getParameterTypes().get(pi); Class pClass = (Class) pType.getDelegate();
		 * output.println(", "+pClass.getName()+" "+pName); } output.println(") {"); output.println(tab + tab + "/*\n " +
		 * cons.accept(toStringVisitor, new HashMap()) + "\n
		 *//*
		 * "); output.print(result.getInitialisation()); output.println(tab + tab + "return " + result.asJavaObject() +
		 * ";"); output.println(tab + "}"); } } } output.println(); // Generate code for invariants i =
		 * contexts.keySet().iterator(); while (i.hasNext()) { OclModelElementType selfType = (OclModelElementType)
		 * i.next(); // Compute class name String selfTypeImplName = ((Class) selfType.getDelegate()).getName(); //
		 * Store the name of all invariants List invNames = new Vector(); // Generate class container String clsName =
		 * selfTypeImplName.substring(selfTypeImplName.lastIndexOf(".") + 1); output.println(tab + "public static class " +
		 * clsName + " {"); // For each classifier context declaration List list = (List) contexts.get(selfType);
		 * Iterator j = list.iterator(); while (j.hasNext()) { ContextDeclaration decl = (ContextDeclaration) j.next(); //
		 * For each invariant List cons = decl.getConstraint(); Iterator k = cons.iterator(); while (k.hasNext()) { //
		 * Compute code and result Constraint con = (Constraint) k.next(); if (con.getKind() ==
		 * ConstraintKind.INV_LITERAL) { String invName = con.getName(); // Compute invariant name if (invName == null ||
		 * invName.length() == 0) invName = "inv$" + invCount++; // Store name con.setName(invName);
		 * invNames.add(invName); OclAnyImpl result = (OclAnyImpl) this.getGenerator().generate(con, tab + tab + tab +
		 * tab, this); Class resType = (Class) con.getBodyExpression().getType().getDelegate(); // outputput the
		 * corresponding method output.println(tab + tab + "public static " + resType.getName() + " " + invName + "(" +
		 * selfTypeImplName + " self) {"); output.println(tab + tab + tab + "/*\n " + con.accept(toStringVisitor, new
		 * HashMap()) + "\n
		 *//*
		 * "); output.println(tab + tab + tab + "try {"); output.print(result.getInitialisation()); output.println(tab +
		 * tab + tab + tab + "return " + result.asJavaObject() + ";"); output.println(tab + tab + tab + "} catch
		 * (Exception e) {"); output.println(tab + tab + tab + tab + "return null;"); output.println(tab + tab + tab +
		 * "}"); output.println(tab + tab + "}"); } } } // Output the evaluate all method output.println(tab + tab +
		 * "public static java.util.Map evaluateAll(" + selfTypeImplName + " self) {"); output.println(tab + tab + tab +
		 * "java.util.Map result = new java.util.HashMap();"); j = invNames.iterator(); while (j.hasNext()) { String
		 * invName = (String) j.next(); output.println(tab + tab + tab + "result.put(\"" + invName + "\"," + invName +
		 * "(self));"); } output.println(tab + tab + tab + "return result;"); output.println(tab + tab + "}"); // Close
		 * class output.println(tab + "}"); } } } catch (Exception e) { e.printStackTrace(); } //--- Close class ---
		 * output.println("}"); } catch (Exception e) { e.printStackTrace(); } }
		 */

	String defsMethod() {
		String s = "static public Object def(String propertyName, Object[] args) {\n" + "java.lang.reflect.Method m = null;\n" + "Object res = null;\n"
				+ "Class[] types = uk.ac.kent.cs.kmf.util.reflection.BetterMethodFinder.getParameterTypesFrom(args);\n" + "try {\n"
				+ "	m = new uk.ac.kent.cs.kmf.util.reflection.BetterMethodFinder(Invariants.class).findMethod(propertyName, types);\n" + "} catch (NoSuchMethodException e) {\n"
				+ "	//e.printStackTrace();\n" + "	System.err.println(\"Error: No property \"+propertyName+\" defined for \"+args[0].getClass());\n" + "}\n" + "if (m != null) {\n" + "	try {\n"
				+ "		res = m.invoke(null, args);\n" + "	} catch (IllegalArgumentException e1) {\n" + "		//e1.printStackTrace();\n" + "	} catch (IllegalAccessException e1) {\n"
				+ "		//e1.printStackTrace();\n" + "	} catch (java.lang.reflect.InvocationTargetException e1) {\n" + "		//e1.printStackTrace();\n" + "	}\n" + "}\n" + "return res;\n" + "}\n";
		return s;
	}

	/**
	 * Create a type environment that includes the passed EObject as the passed name. ( additional objects can be added
	 * using 'setValue("name", object)' )
	 */
	public Environment environment(String name, Object obj) {
		Classifier type = getBridgeFactory().buildClassifier(obj);
		Environment env = this.environment();
		return env.addVariableDeclaration(name, type, Boolean.TRUE);
	}

	public Environment environment() {
		Environment env = getBridgeFactory().buildEnvironment();
		// Add basicTypes;
		env = env.addElement("OclType", getTypeFactory().buildTypeType(null), Boolean.FALSE);
		env = env.addElement("OclAny", getTypeFactory().buildOclAnyType(), Boolean.FALSE);
		env = env.addElement("OclVoid", getTypeFactory().buildVoidType(), Boolean.FALSE);
		env = env.addElement("Real", getTypeFactory().buildRealType(), Boolean.FALSE);
		env = env.addElement("Integer", getTypeFactory().buildIntegerType(), Boolean.FALSE);
		env = env.addElement("String", getTypeFactory().buildStringType(), Boolean.FALSE);
		env = env.addElement("Boolean", getTypeFactory().buildBooleanType(), Boolean.FALSE);
		Iterator i = getMetaModels().iterator();
		while (i.hasNext()) {
			Namespace ns = getBridgeFactory().buildNamespace(i.next());
			env = env.addNamespace(ns);
		}
		return env;
	}

	/**
	 * Create a runtime environment that includes the passed EObject as the passed name. ( additional objects can be
	 * added using 'setValue("name", object)' )
	 * 
	 */
	public RuntimeEnvironment runtimeEnvironment(String name, Object eobj) {
		RuntimeEnvironment renv = new RuntimeEnvironmentImpl();
		renv.setValue(name, eobj);
		return renv;
	}

	public RuntimeEnvironment runtimeEnvironment() {
		RuntimeEnvironment renv = new RuntimeEnvironmentImpl();
		return renv;
	}

	/*
	 * add by Heini
	 */
	public RuntimeEnvironment getRuntimeEnvironment() {
		return renv_;
	}

	/**
	 * "allInstances()" shall be executed on the range of all available models by default
	 */
	public Collection getModelsForAllInstances() {
		return modelSet;
	}

	/**
	 * @see #lineDelta
	 * @param value
	 */
	public void setLineDelta(int value) {
		lineDelta = value;
	}

}
