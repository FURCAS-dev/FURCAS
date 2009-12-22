/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: PrettyPrinter.java,v 1.7 2008/07/02 18:33:39 fjouault Exp $
 */
package com.sap.ide.cts.editor.prettyprint.imported;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import tcs.Alternative;
import tcs.AsParg;
import tcs.BooleanPropertyExp;
import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import tcs.EnumLiteralMapping;
import tcs.EnumerationTemplate;
import tcs.EqualsExp;
import tcs.FilterParg;
import tcs.ForcedLowerParg;
import tcs.ForcedUpperParg;
import tcs.InjectorAction;
import tcs.InjectorActionsBlock;
import tcs.InstanceOfExp;
import tcs.IsDefinedExp;
import tcs.Keyword;
import tcs.LiteralRef;
import tcs.LookupPropertyInit;
import tcs.ModeParg;
import tcs.OneExp;
import tcs.Operator;
import tcs.OperatorTemplate;
import tcs.PartialParg;
import tcs.PrimitivePropertyInit;
import tcs.PrimitiveTemplate;
import tcs.Priority;
import tcs.Property;
import tcs.PropertyInit;
import tcs.RefersToParg;
import tcs.Sequence;
import tcs.SequenceElement;
import tcs.SequenceInAlternative;
import tcs.SpaceKind;
import tcs.Symbol;
import tcs.Template;
import tcs.Token;

import com.sap.ide.cts.editor.prettyprint.MOINImportedModelAdapter;
import com.sap.ide.cts.editor.prettyprint.PrettyPrintContext;
import com.sap.ide.cts.editor.prettyprint.SyntaxAndModelMismatchException;
import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.textual.moinadapter.adapter.AdapterJMIHelper;

/**
 * @author Fr�d�ric Jouault
 * @author Mika�l Barbero
 * 
 *         modified by Philipp Meier in 2009
 * 
 */
public class PrettyPrinter {

	abstract class SyntaxMismatchException extends Exception {

		private PrettyPrintContext context;

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SyntaxMismatchException(PrettyPrintContext context) {
			this.context = context.duplicate();
		}

		@Override
		public String getMessage() {
			ClassTemplate ct = context.getClassTemplates().peek();
			String error = "Mismatch in PropertyInit of ClassTemplate ";
			error += TcsUtil.joinNameList(ct.getMetaReference()
					.getQualifiedName());
			if (ct.getMode() != null)
				error += " #" + ct.getMode();

			error += ". ";

			error += getMismatchError();

			return error;
		}

		protected abstract String getMismatchError();

		protected PrettyPrintContext getContext() {
			return context;
		}

	}

	class ForcedBoundsException extends SyntaxMismatchException {

		RefObject element;
		Property p;
		String propertyName;
		ForcedLowerParg lowerArg;
		ForcedUpperParg upperArg;

		public ForcedBoundsException(RefObject element, Property p,
				ForcedLowerParg lowerArg, ForcedUpperParg upperArg,
				PrettyPrintContext context) {
			super(context);
			this.element = element;
			this.p = p;
			this.propertyName = TcsUtil.getPropertyName(p
					.getPropertyReference());
			this.lowerArg = lowerArg;
			this.upperArg = upperArg;
		}

		@Override
		protected String getMismatchError() {

			Object propValue = TcsUtil.getPropertyValue(element, p
					.getPropertyReference());

			Integer propValueSize = 0;
			if (!(propValue == null)) {
				propValueSize = 1;
			}

			if (propValue instanceof Collection) {
				Collection<?> c = (Collection<?>) propValue;

				propValueSize = c.size();

			}

			String error = "ForcedBoundsError: ";
			error += "property " + propertyName;
			error += " has " + propValueSize + " elements with";

			if (lowerArg != null) {
				error += " forced lower " + lowerArg.getValue();
			}

			if (upperArg != null) {
				error += " forced upper " + upperArg.getValue();
			}

			return error;
		}

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	}

	class PropertyInitException extends SyntaxMismatchException {

		RefObject element;
		PropertyInit propertyInit;
		String propertyName;

		private static final long serialVersionUID = 1L;

		public PropertyInitException(RefObject element,
				PropertyInit propertyInit, PrettyPrintContext context) {
			super(context);
			this.element = element;
			this.propertyInit = propertyInit;
			this.propertyName = TcsUtil.getPropertyName(propertyInit
					.getPropertyReference());
		}

		@Override
		protected String getMismatchError() {
			if (propertyInit instanceof PrimitivePropertyInit) {
				return getPrimitivePropertyInitError((PrimitivePropertyInit) propertyInit);
			}

			if (propertyInit instanceof LookupPropertyInit) {
				return getLookupPropertyInitError((LookupPropertyInit) propertyInit);
			}

			return "unknown property init type";
		}

		private String getPrimitivePropertyInitError(PrimitivePropertyInit p) {
			String error = "PrimitivePropertyInit: ";
			error += "property " + propertyName;
			error += " is " + element.refGetValue(propertyName);
			error += " instead of the expected " + p.getValue();

			return error;
		}

		private String getLookupPropertyInitError(LookupPropertyInit p) {
			return "LookupPropertyInit: property " + propertyName
					+ " does not match OCL query " + p.getValue();
		}

	}
	
	class NoTemplateMatchFoundException extends SyntaxMismatchException {

		RefObject element;
		String mode;
		String typeName;

		private static final long serialVersionUID = 1L;

		public NoTemplateMatchFoundException(PrettyPrintContext context, RefObject element,
				String typeName, String mode) {
			super(context);
			this.element = element;
			this.typeName = typeName;
			this.mode = mode;
		}

		@Override
		protected String getMismatchError() {
			return "Did not find templat for type: " + typeName + " with mode: " + mode;
		}

	}


	private Map<Integer, PrettyPrintContext> backup = new HashMap<Integer, PrettyPrintContext>();

	/**
	 * contains a mapping of qualifiedName + Mode to ClassTemplate of all
	 * ClassTemplates contained in the ConcreteSyntax passed to the constructor
	 */
	Map<List<String>, Map<String, ClassTemplate>> classTemplateMap;

	private Map<String, Object> templates = new HashMap<String, Object>();
	private Map<String, PrimitiveTemplate> primitiveTemplates = new HashMap<String, PrimitiveTemplate>();
	private Map<String, Token> tokens = new HashMap<String, Token>();
	private Set<String> keywords = new HashSet<String>();
	private boolean kwCheckIgnoreCase = false;
	private String identEscStart = "\"";
	private String identEscEnd = "\"";
	private String stringDelim = "\"";
	private boolean serializeComments = false;
	private static DecimalFormatSymbols dfs = new DecimalFormatSymbols();
	private DecimalFormat df = new DecimalFormat("0.##############", dfs);

	private String standardSeparator = " ";
	private String indentString = "  ";
	private String lineFeed = "\n";

	private AdapterJMIHelper oclHelper = null;

	private TCSExtractorStream out;
	private PrettyPrintContext context = new PrettyPrintContext();

	// debug structure
	private boolean debug = false;
	// debug whitespace
	private boolean debugws = false;
	// print output stream to console
	private static boolean debugPrintOutput = false;
	// print caught property init exceptions
	private static boolean printPropertyInitExceptions = false;

	@SuppressWarnings("unchecked")
	public void prettyPrint(RefObject source, ConcreteSyntax syntax,
			TCSExtractorStream target) throws SyntaxAndModelMismatchException {
		assert (source != null);
		assert (syntax != null);
		assert (target != null);

		Connection con = TcsUtil.getConnectionFromRefObject(source);
		oclHelper = new AdapterJMIHelper(source.refOutermostPackage(), con, con
				.getJmiHelper(), null, null);

		if (debugPrintOutput) {
			out = new DebugPrintTCSExtractorStream(target);
		} else {
			out = target;
		}

		classTemplateMap = TcsUtil.createClassTemplateMap(syntax);

		for (Template t : syntax.getTemplates()) {
			List<String> name = TcsUtil.getQualifiedName(t);
			if (t instanceof EnumerationTemplate) {
				EnumerationTemplate et = (EnumerationTemplate) t;
				Map<String, SequenceElement> mappings = new HashMap<String, SequenceElement>();
				for (EnumLiteralMapping mapping : et.getMappings()) {
					mappings.put(mapping.getLiteral().getName(), mapping
							.getElement());
				}
				templates.put(TcsUtil.joinNameList(name), mappings);
			} else if (t instanceof PrimitiveTemplate) {
				PrimitiveTemplate pt = (PrimitiveTemplate) t;
				primitiveTemplates.put(pt.getTemplateName(), pt);
				Collection c = (Collection) templates.get(TcsUtil
						.joinNameList(name));
				if (c == null) {
					c = new ArrayList<Object>();
					templates.put(TcsUtil.joinNameList(name), c);
				}
				c.add(pt);
			} else {
				// ClassTemplate handled by classTemplateMap instead
				if (!(t instanceof ClassTemplate)) {
					templates.put(TcsUtil.joinNameList(name), t);
				}
			}
		}
		for (Keyword k : syntax.getKeywords()) {
			String value = k.getValue();
			if (kwCheckIgnoreCase)
				value = value.toUpperCase();
			keywords.add(value);
		}
		for (Token tok : syntax.getTokens()) {
			String value = tok.getName();
			tokens.put(value, tok);
		}

		for (Symbol s : syntax.getSymbols()) {
			String value = s.getValue();
			debug("Symbol: " + value);
			int type = TYPE_SYMBOL;
			for (SpaceKind spaceKind : s.getSpaces()) {
				// TODO debug and check if toString is right here
				String l = spaceKind.toString();
				debug("\tLiteral: " + l);
				if (l.equals("leftSpace"))
					type += SYMBOL_LS;
				else if (l.equals("leftNone"))
					type += SYMBOL_LN;
				if (l.equals("rightSpace"))
					type += SYMBOL_RS;
				else if (l.equals("rightNone"))
					type += SYMBOL_RN;
			}
			symbols.put(value, new Integer(type));
		}

		context.getPriorities().push(new Integer(Integer.MAX_VALUE));
		int handle = createSafePoint();
		try {
			String mainTemplateMode = TcsUtil.getMainClassTemplate(syntax)
					.getMode();
			serialize(source, mainTemplateMode);
		} catch (SyntaxMismatchException e) {
			resetToSafePoint(handle);
			throw new SyntaxAndModelMismatchException(e);
		}
		out.close();
	}

	private void pushSep(String sep) {
		context.getCurrentSeparator().push(sep);
		debug("PUSHING SEPARATOR: \"" + sep + "\"");
	}

	private void popSep() {
		String old = context.getCurrentSeparator().pop();
		debug("POPING SEPARATOR: \"" + old + "\"");
	}

	private static ClassTemplate findSupertypeTemplate(RefObject r,
			String mode,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap) {
		return findSupertypeTemplate((MofClass) r.refMetaObject(), mode,
				classTemplateMap);
	}

	private static ClassTemplate findSupertypeTemplate(GeneralizableElement g,
			String mode,
			Map<List<String>, Map<String, ClassTemplate>> classTemplateMap) {
		ClassTemplate template = null;
		for (GeneralizableElement supertype : g.getSupertypes()) {
			if (supertype instanceof Classifier) {
				Classifier c = (Classifier) supertype;
				template = TcsUtil.resolveClassTemplate(c.getQualifiedName(),
						mode, classTemplateMap);
				if (template != null && !template.isAbstract()) {
					return template;
				}
			}
		}

		for (GeneralizableElement supertype : g.getSupertypes()) {
			template = findSupertypeTemplate(supertype, mode, classTemplateMap);
			if (template != null && !template.isAbstract()) {
				return template;
			}
		}

		return null;
	}

	private static boolean isInstanceOf(RefObject element, List<String> type) {
		MofClass m = (MofClass) element.refMetaObject();

		List<GeneralizableElement> typesToCheck = new ArrayList<GeneralizableElement>(
				m.allSupertypes());
		// also add element type itself
		typesToCheck.add(m);

		for (GeneralizableElement g : typesToCheck)

		{
			List<String> qName = g.getQualifiedName();
			// maybe type is not fully qualified, compare each part
			if (isTypeMatch(qName, type)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * compares the types from the end backwards (in case the
	 * partiallyQulifiedTypeName is not fully qualified)
	 * 
	 * Example: ConcreteSyntax instead of TCS::ConcreteSyntax
	 * 
	 * @param fullyQualifiedTypeName
	 * @param partiallyQualifiedTypeName
	 * 
	 * @return
	 */
	private static boolean isTypeMatch(List<String> fullyQualifiedTypeName,
			List<String> partiallyQualifiedTypeName) {
		boolean allPartsMatch = true;
		if (fullyQualifiedTypeName.size() >= partiallyQualifiedTypeName.size()) {
			for (int i = 1; i <= partiallyQualifiedTypeName.size(); i++) {
				if (!fullyQualifiedTypeName.get(
						fullyQualifiedTypeName.size() - i).equals(
						partiallyQualifiedTypeName
								.get(partiallyQualifiedTypeName.size() - i))) {
					allPartsMatch = false;
				}
			}
		}

		return allPartsMatch;
	}

	private void serialize(RefObject ame) throws SyntaxMismatchException {
		serialize(ame, null);
	}

	private void serialize(RefObject ame, String mode)
			throws SyntaxMismatchException {

		if (context.getVisitedModelElements().contains(ame)) {
			// don't visit model elements recursively
			return;
		} else {
			// add the model element to the visited list.
			// it is removed again at the end of this method
			context.getVisitedModelElements().add(ame);
		}

		pushSep(standardSeparator);

		String typeName = MOINImportedModelAdapter.getTypeName(ame);
		debug("processing " + typeName);

		Object template = null;

		ClassTemplate ct = TcsUtil.resolveClassTemplate(
				MOINImportedModelAdapter.getQualifiedName(ame), mode,
				classTemplateMap);
		if (ct != null && !ct.isAbstract()) {
			template = ct;
		}

		if (template == null) {

			// look for non-abstract template for supertype
			template = findSupertypeTemplate(ame, mode, classTemplateMap);
		}

		if (template == null) {

			// look for non-class templates
			template = templates.get(typeName);
		}

		if (template == null) {
			if (mode != null) {
				error("unknown template for " + typeName + " #" + mode);
			} else {
				error("unknown template for " + typeName);
			}
			throw new NoTemplateMatchFoundException(context, ame, typeName, mode);
			//return;
		}

		String templateTypeName = MOINImportedModelAdapter
				.getTypeName((RefObject) template);
		debug("Applying template type " + templateTypeName);

		if (template instanceof ClassTemplate) {
			debug("with mode: " + ((ClassTemplate) template).getMode());
		}

		if (serializeComments) {
			try {
				boolean first = true;
				boolean nl = false;
				for (Iterator<?> i = MOINImportedModelAdapter.getCol(ame,
						"commentsBefore"); i.hasNext();) {
					String c = MOINImportedModelAdapter.nextString(i);
					if (c.equals("\n")) {
						nl = true;
					} else {
						debug("printing comment: \"" + c + "\"");
						if (first && !nl) {
							printComment(c);
							// out.print("SHOULD-BE-NONL");
						} else {
							printComment(c);
						}
						printWS(lineFeed + context.getCurIndent());
						first = false;
					}
				}
			} catch (Exception e) {
				System.out.println("Warning: could not get comments of " + ame
						+ ", disabling further comments serialization");
				serializeComments = false;
			}
		}
		if (templateTypeName.equals("TCS::ClassTemplate")) {

			context.getPriorities().push(new Integer(Integer.MAX_VALUE));
			context.getClassTemplates().push((ClassTemplate) template);
			context.getParentRefObjects().push(ame);
			int handle = out.startClassTemplateForObject(ame,
					(Template) template);
			
			serializeSeq(ame, MOINImportedModelAdapter.getME((RefObject) template, "templateSequence"));

			out.endClassTemplate(handle);
			context.getParentRefObjects().pop();
			context.getClassTemplates().pop();
			context.getPriorities().pop();
		} else if (templateTypeName.equals("TCS::OperatorTemplate")) {
			int handle = out.startClassTemplateForObject(ame,
					(Template) template);
			OperatorTemplate ot = (OperatorTemplate) template;
			String sourcePropName = TcsUtil.getPropertyName(ot
					.getStoreLeftSideTo());
			String opPropName = TcsUtil
					.getPropertyName(ot.getStoreOperatorTo());
			String rightPropName = TcsUtil.getPropertyName(ot
					.getStoreRightSideTo());
			debug("OperatorTemplate: left = " + sourcePropName
					+ " ; operator = " + opPropName + " ; right = "
					+ rightPropName);

			Object r = null;
			boolean isPostfix = false; // only valid for unary operators
			boolean isUnary = false;
			if (rightPropName != null) {
				r = MOINImportedModelAdapter.get(ame, rightPropName);
				if (r instanceof Collection) {
					isUnary = (((Collection<?>) r).size() == 0);
				} else {
					isUnary = r == null;
				}
			} else {
				isUnary = true;
			}
			debug("rightPropName = " + rightPropName + " ; isUnary = "
					+ isUnary);

			Object operator = null;
			if (opPropName != null) {
				String op = MOINImportedModelAdapter.getString(ame, opPropName);
				if (op == null) {
					throw new RuntimeException("Property " + opPropName
							+ " has not been set in " + ame + " ("
							+ MOINImportedModelAdapter.getMetaobject(ame) + ")");
				}
				for (Iterator<?> i = MOINImportedModelAdapter.getCol(
						(RefObject) template, "operators"); i.hasNext()
						&& (operator == null);) {
					Object opme = i.next();
					Object literal = MOINImportedModelAdapter.getME(
							(RefObject) opme, "literal");
					String opmes = null;
					if (literal == null)
						opmes = "";
					else
						opmes = MOINImportedModelAdapter.getString(
								(RefObject) literal, "value");
					int arity = MOINImportedModelAdapter.getInt(
							(RefObject) opme, "arity");
					if (op.equals(opmes)) {
						if (rightPropName != null) {
							if ((isUnary && (arity == 1))
									|| ((!isUnary) && (arity == 2))) {
								operator = opme;
							}
						} else {
							operator = opme;
							isPostfix = MOINImportedModelAdapter.getBool(
									(RefObject) opme, "isPostfix");
						}
					}
				}
				if (operator == null) {
					System.err.println("Error: could not find operator \"" + op
							+ "\"");
				}
			} else {
				operator = MOINImportedModelAdapter.getCol(
						(RefObject) template, "operators").next();
				isUnary = MOINImportedModelAdapter.getInt((RefObject) operator,
						"arity") == 1;
				if (isUnary) {
					isPostfix = MOINImportedModelAdapter.getBool(
							(RefObject) operator, "isPostfix");
				}
			}
			int curPrio = context.getPriorities().peek().intValue();
			Operator op = (Operator) operator;
			int priority = ((Priority) op.refImmediateComposite()).getValue();
			boolean paren = priority > curPrio;
			context.getPriorities().push(new Integer(priority));
			RefObject literal = MOINImportedModelAdapter.getME(
					(RefObject) operator, "literal");
			debug("PRIORITY = "
					+ priority
					+ " ; CURPRIO = "
					+ curPrio
					+ " ; OPERATOR = "
					+ ((literal != null) ? MOINImportedModelAdapter.getString(
							literal, "value") : "") + " ; paren = " + paren);

			if (paren)
				printSymbol("(");

			RefObject source = MOINImportedModelAdapter.getME(ame,
					sourcePropName);
			if (isUnary) {
				if (isPostfix) {
					serialize(source);

					if (literal != null)
						printLiteral(literal);
				} else {
					if (literal != null)
						printLiteral(literal);

					serialize(source);
				}
			} else {
				serialize(source);

				if (literal != null)
					printLiteral(literal);
			}

			RefObject seq = MOINImportedModelAdapter.getME(
					(RefObject) template, "otSequence");
			if (rightPropName == null) {
				context.getPriorities().push(new Integer(Integer.MAX_VALUE));
				serializeSeq(ame, seq);
				context.getPriorities().pop();
			} else {
				if (seq != null)
					serializeSeq(ame, seq);
				if (r instanceof Collection) {
					for (Iterator<?> i = ((Collection<?>) r).iterator(); i
							.hasNext();) {
						serialize((RefObject) i.next());
					}
				} else {
					if (!isUnary)
						serialize((RefObject) r);
				}
			}
			context.getPriorities().pop();
			if (paren)
				printSymbol(")");

			out.endClassTemplate(handle);
		} else {
			error("unsupported template type: " + templateTypeName);
		}
		if (serializeComments) {
			try {
				for (Iterator<?> i = MOINImportedModelAdapter.getCol(ame,
						"commentsAfter"); i.hasNext();) {
					String c = MOINImportedModelAdapter.nextString(i);
					if (c.equals("\n")) {

					} else {
						printComment(c);
						printWS(lineFeed + context.getCurIndent());
					}
				}
			} catch (Exception e) {
				System.out.println("Warning: could not get comments of " + ame
						+ ", disabling further comments serialization");
				serializeComments = false;
			}
		}
		popSep();

		// remove element so it can be prettyprinted in other places
		context.getVisitedModelElements().remove(ame);
	}

	private void serializeSeq(RefObject ame, RefObject seq)
			throws SyntaxMismatchException {
		if (seq != null) {
			for (Iterator<?> i = MOINImportedModelAdapter.getCol(seq,
					"elements"); i.hasNext();) {
				Object e = i.next();
				serializeSeqElem(ame, (SequenceElement) e);
			}
		}
	}

	private String getLineFeeds(int n) {
		String ret = "";

		for (int i = 0; i < n; i++) {
			ret += lineFeed;
		}

		return ret;
	}

	/**
	 * 
	 * @param element
	 *            Context model element of which to serialize a part (from
	 *            source model).
	 * @param seqElem
	 *            SequenceElement specifying a part of element to serialize.
	 */
	private void serializeSeqElem(RefObject element, SequenceElement seqElem)
			throws SyntaxMismatchException {

		out.enterSequenceElement(seqElem);

		String tn = MOINImportedModelAdapter.getTypeName(seqElem);
		debug("serializing seq elem " + tn);
		if (tn.equals("TCS::LiteralRef")) {
			LiteralRef litRef = (LiteralRef) seqElem;
			printLiteral(litRef.getReferredLiteral());
		} else if (tn.equals("TCS::CustomSeparator")) {
			String name = MOINImportedModelAdapter.getString(seqElem, "name");
			if (name.equals("no_space")) {
				context.setTypeLast(TYPE_SYMBOL + SYMBOL_RN);
			} else if (name.equals("space")) {
				printWS(" ");
			} else if (name.equals("newline")) {
				printWS(lineFeed);
			} else if (name.equals("tab")) {
				printWS("\t");
			}
		} else if (tn.equals("TCS::Property")) {
			Property prop = (Property) seqElem;
			Object v = TcsUtil.getPropertyValue(element, prop
					.getPropertyReference());

			// also check for partial property arg
			serializePropertyCheckingPartial(element, v, prop);

		} else if (tn.equals("TCS::Block")) {
			if (debugws)
				out.debug("<block>");
			Object nbNLBArg = getBArg(seqElem, "NbNL");
			Object startNbNLBArg = getBArg(seqElem, "StartNbNL");
			Object indentIncrBArg = getBArg(seqElem, "IndentIncr");
			Object startNLBArg = getBArg(seqElem, "StartNL");
			Object endNLBArg = getBArg(seqElem, "EndNL");
			int indentIncr = 1;
			int nbNL = 1;
			boolean startNL = true;
			boolean endNL = true;

			if (nbNLBArg != null) {
				nbNL = MOINImportedModelAdapter.getInt((RefObject) nbNLBArg,
						"value");
			}
			int startNbNL = nbNL; // by default, startNbNL = nbNL
			if (startNbNLBArg != null) {
				startNbNL = MOINImportedModelAdapter.getInt(
						(RefObject) startNbNLBArg, "value");
			}
			if (indentIncrBArg != null) {
				indentIncr = MOINImportedModelAdapter.getInt(
						(RefObject) indentIncrBArg, "value");
			}
			if (startNLBArg != null) {
				startNL = MOINImportedModelAdapter.getBool(
						(RefObject) startNLBArg, "value");
			}
			if (endNLBArg != null) {
				endNL = MOINImportedModelAdapter.getBool((RefObject) endNLBArg,
						"value");
			}
			debug("nbNL = " + nbNL + " ; indentIncr = " + indentIncr);
			context.incIndentLevel(indentIncr);

			for (int i = 0; i < indentIncr; i++) {
				context.addToCurIndent(indentString);
			}
			String nls = getLineFeeds(nbNL);

			pushSep(nls
					+ ((nbNL == 0) ? standardSeparator : context.getCurIndent()));
			if (debugws)
				out.debug("<BeforeFirstWS/>");
			if (startNL) {
				if (startNbNL == 0) {
					printWS("");
				} else if (nbNL == startNbNL) {
					printWS();
				} else {
					printWS(getLineFeeds(startNbNL) + context.getCurIndent());
				}
			} else {
				if (debugws)
					out.debug("<BeforeNonStartNLWS/>");
				printWS(""); // to make sure the last item was a
				// TYPE_SPACE
				if (debugws)
					out.debug("<AfterNonStartNLWS/>");
			}
			if (debugws)
				out.debug("<blockContent>");
			serializeSeq(element, MOINImportedModelAdapter.getME(seqElem,
					"blockSequence"));
			if (debugws)
				out.debug("</blockContent>");

			context.decIndentLevel(indentIncr);
			context.removeFromCurIndent(indentString.length() * indentIncr);
			if (endNL) {
				printWS(lineFeed + context.getCurIndent());
			}
			popSep();
			if (debugws)
				out.debug("</block>");
		} else if (tn.equals("TCS::FunctionCall")) {
			serializeSeq(element, MOINImportedModelAdapter.getME(
					MOINImportedModelAdapter.getME(seqElem, "calledFunction"),
					"functionSequence"));
		} else if (tn.equals("TCS::ConditionalElement")) {
			RefObject condition = MOINImportedModelAdapter.getME(seqElem,
					"condition");
			if (eval(element, condition)) {
				RefObject tseq = MOINImportedModelAdapter.getME(seqElem,
						"thenSequence");
				if (tseq != null)
					printWSBlockNoDup();
				serializeSeq(element, tseq);
			} else {
				RefObject eseq = MOINImportedModelAdapter.getME(seqElem,
						"elseSequence");
				debug("ELSE SEQ = " + eseq);
				if (eseq != null)
					printWSBlockNoDup();
				serializeSeq(element, eseq);
			}
		} else if (tn.equals("TCS::Alternative")) {
			Alternative alt = (Alternative) seqElem;

			printWSBlockNoDup();

			// TODO maybe writing highest priority alternatives first the best
			// solution?
			// TODO does this suffice or is a more detailed priority method
			// needed?
			List<Sequence> sequences = sortedByNumberOfSequenceElements(alt
					.getSequences());

			// try each sequence and backtrack on InjectorActionError

			for (int i = 0; i < sequences.size(); i++) {
				int handle = 0;
				try {
					handle = createSafePoint();
					serializeSeq(element, sequences.get(i));
					// successful print, don't print other alternatives
					break;
				} catch (SyntaxMismatchException e) {
					if (printPropertyInitExceptions) {
						System.out.println(e.getMessage());
					}

					// unsuccessful print, try other alternatives
					resetToSafePoint(handle);

					// if this is the last possible alternative and the
					// alternative is not multi (with *), re-throw
					// exception
					if (i == sequences.size() - 1 && !alt.isMulti()) {
						throw (e);
					}
				}
			}
		} else if (tn.equals("TCS::InjectorActionsBlock")) {
			InjectorActionsBlock iab = (InjectorActionsBlock) seqElem;

			// check all contained property inits
			for (InjectorAction action : iab.getInjectorActions()) {
				if (action instanceof PrimitivePropertyInit) {
					validatePrimitivePropertyInit(element,
							(PrimitivePropertyInit) action);
				}

				if (action instanceof LookupPropertyInit) {
					validateLookupPropertyInit(element,
							(LookupPropertyInit) action);
				}
			}

		} else {
			error("unsupported: " + tn);
		}

		out.exitSequenceElement();
	}

	/**
	 * largest first
	 * 
	 * @return
	 */
	private List<Sequence> sortedByNumberOfSequenceElements(
			Collection<SequenceInAlternative> collection) {

		List<Sequence> result = new ArrayList<Sequence>(collection);

		Collections.sort(result, new Comparator<Sequence>() {

			@Override
			public int compare(Sequence a, Sequence b) {

				// swap a and b to have largest sequence first
				return new Integer(b.getElements().size()).compareTo(a
						.getElements().size());
			}

		});

		return result;
	}

	private void validatePrimitivePropertyInit(RefObject element,
			PrimitivePropertyInit p) throws PropertyInitException {

		if (element != null && p != null) {

			// only validate PropertyInit, if it is mandatory and not just a
			// default for the parser
			if (p.isDefault()) {
				return;
			}

			Object prop = TcsUtil.getPropertyValue(element, p
					.getPropertyReference());

			String propValue = "";
			if (prop != null) {
				if (prop instanceof RefEnum) {
					propValue = prop.getClass().getName() + "."
							+ prop.toString().toUpperCase();
				} else {
					propValue = prop.toString();
				}
			}

			String expectedValue = p.getValue();

			// TODO this is a HACK until no more java code allowed in
			// primitive
			// property inits
			if (expectedValue != null) {
				if (expectedValue.startsWith("\"")) {
					expectedValue = expectedValue.substring(1, expectedValue
							.length() - 1);
				}
			}

			if (!propValue.equals(expectedValue)) {
				throw new PropertyInitException(element, p, context);
			}
		}
	}

	private RefObject computeContextObject(String oclQuery) {

		String tag = TcsUtil.getContextTag(oclQuery);

		return PrettyPrintContext.getContextElement(context, tag);
	}

	private void validateLookupPropertyInit(RefObject element,
			LookupPropertyInit p) throws PropertyInitException {

		if (element != null && p != null) {

			// only validate PropertyInit, if it is mandatory and not just a
			// default for the parser
			if (p.isDefault()) {
				return;
			}

			Object prop = TcsUtil.getPropertyValue(element, p
					.getPropertyReference());

			String oclQuery = p.getValue();
			RefObject contextObject = computeContextObject(oclQuery);

			Object expectedValue = null;
			try {
				// keyValue is always null for LookUpPropertyInits
				// in QueryPArg it denotes the RefersToParg propertyValue
				expectedValue = TcsUtil.executeOclQuery(element, oclQuery,
						contextObject, null);
			} catch (ModelAdapterException e) {
				throw new PropertyInitException(element, p, context);
			}

			// oclHelper.findElementWithOCLQuery returns null for empty
			// collections
			if (!TcsUtil.isPropValueAndOclResultEqual(prop, expectedValue)) {
				throw new PropertyInitException(element, p, context);
			}

		}
	}

	@SuppressWarnings("unchecked")
	private boolean eval(RefObject context, RefObject condition) {
		boolean ret = true;

		String ctn = MOINImportedModelAdapter.getTypeName(condition);
		if (ctn.equals("TCS::AndExp")) {
			ret = true;
			for (Iterator<?> i = MOINImportedModelAdapter.getCol(condition,
					"expressions"); i.hasNext();) {
				ret &= eval(context, (RefObject) i.next());
			}
		} else if (ctn.equals("TCS::BooleanPropertyExp")) {
			BooleanPropertyExp booleanPropertyExp = (BooleanPropertyExp) condition;
			String propName = TcsUtil.getPropertyName(booleanPropertyExp
					.getPropertyReference());
			ret = MOINImportedModelAdapter.getBool(context, propName);
		} else if (ctn.equals("TCS::IsDefinedExp")) {
			IsDefinedExp isDefinedExp = (IsDefinedExp) condition;
			String propName = TcsUtil.getPropertyName(isDefinedExp
					.getPropertyReference());
			Object val = MOINImportedModelAdapter.get(context, propName);
			if (val == null) {
				ret = false;
			} else if (val instanceof Collection) {
				ret = (((Collection<?>) val).size() > 0);
			} else {
				ret = true;
			}

		} else if (ctn.equals("TCS::OneExp")) {
			OneExp oneExp = (OneExp) condition;
			String propName = TcsUtil.getPropertyName(oneExp
					.getPropertyReference());
			Object val = MOINImportedModelAdapter.get(context, propName);
			if (val == null) {
				ret = false;
			} else if (val instanceof Collection) {
				ret = (((Collection<?>) val).size() == 1);
			} else {
				ret = true;
			}
		} else if (ctn.equals("TCS::InstanceOfExp")) {
			InstanceOfExp ioExp = (InstanceOfExp) condition;

			Object referredObject = TcsUtil.getPropertyValue(context, ioExp
					.getPropertyReference());

			if (referredObject instanceof RefObject) {

				if (isInstanceOf((RefObject) referredObject, ioExp
						.getSupertype())) {
					ret = true;
				} else {
					ret = false;
				}
			} else {
				// TODO handle primitive types as well?
				System.out.println("TODO NEED HANDLING IN PP");
			}
		} else if (ctn.equals("TCS::EqualsExp")) {
			EqualsExp equalsExp = (EqualsExp) condition;
			String propName = TcsUtil.getPropertyName(equalsExp
					.getPropertyReference());
			RefObject value = MOINImportedModelAdapter
					.getME(condition, "value");
			String vtn = MOINImportedModelAdapter.getTypeName(value);
			if (vtn.equals("TCS::IntegerVal")) {
				int lv = MOINImportedModelAdapter.getInt(value, "symbol");
				int pv = MOINImportedModelAdapter.getInt(context, propName);
				ret = (lv == pv);
			} else if (vtn.equals("TCS::NegativeIntegerVal")) {
				int lv = -MOINImportedModelAdapter.getInt(value, "symbol");
				int pv = MOINImportedModelAdapter.getInt(context, propName);
				ret = (lv == pv);
			} else if (vtn.equals("TCS::StringVal")) {
				String lv = MOINImportedModelAdapter.getString(value, "symbol");
				List<String> pv = (List<String>) MOINImportedModelAdapter.get(
						context, propName);
				ret = (lv.equals(TcsUtil.joinNameList(pv)));
			} else if (vtn.equals("TCS::EnumLiteralVal")) {
				String lv = MOINImportedModelAdapter.getString(value, "name");
				RefEnum pv = (RefEnum) MOINImportedModelAdapter.get(context,
						propName);
				ret = (lv.equals(pv.toString()));
			} else {
				error(vtn + " unsupported.");
			}
		} else {
			error(ctn + " unsupported.");
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	private void serializeProperty(RefObject element, Object value,
			Property property) throws SyntaxMismatchException {

		validateBounds(element, property, value);

		RefersToParg refersToParg = (RefersToParg) getPArg(property, "RefersTo");
		AsParg asParg = (AsParg) getPArg(property, "As");
		RefObject query = getPArg(property, "Query");
		String primitiveTemplateName = null;

		if (asParg != null) {
			Template asTemplate = asParg.getTemplate();
			if (asTemplate instanceof PrimitiveTemplate) {
				PrimitiveTemplate prim = (PrimitiveTemplate) asTemplate;
				primitiveTemplateName = prim.getTemplateName();
			}
		}

		if (value == null)
			return;
		if (value instanceof Collection) {
			RefObject sep = getPArg(property, "Separator");
			if (sep != null)
				sep = MOINImportedModelAdapter.getME(sep, "separatorSequence");
			boolean first = true;
			for (Iterator<?> i = ((Collection<?>) value).iterator(); i
					.hasNext();) {
				if (first) {
					printWSBlockNoDup();
					first = false;
				} else {
					if (context.getTypeLast() != TYPE_SPACE)
						printWS();
				}

				Object currentPropValue = i.next();

				// ignore PropertyInitExceptions on a per entry basis of the
				// collection
				// if partial is set
				serializePropertyCheckingPartial(element, currentPropValue,
						property);

				if (i.hasNext()) {
					if (sep != null) {
						serializeSeq(null, sep);
					}
				}
			}
		} else if (value instanceof RefEnum) {
			RefEnum e = (RefEnum) value;
			String enumName = TcsUtil.joinNameList(e.refTypeName());
			Map<String, SequenceElement> mappings = (Map<String, SequenceElement>) templates
					.get(enumName);
			SequenceElement seqElem = mappings.get(MOINImportedModelAdapter
					.getEnumLiteralName(e));
			serializeSeqElem(element, seqElem);
		} else if (value instanceof RefObject) {
			RefObject valueME = (RefObject) value;
			printWSBlockNoDup();

			if (asParg != null && query != null) {
				FilterParg filter = (FilterParg) getPArg(property, "Filter");
				String invertQuery = filter.getInvert();
				try {
					String refValue = (String) oclHelper
							.findElementWithOCLQuery(
									valueME,
									null,
									null,
									invertQuery,
									null,
									valueME
											.get___Connection()
											.getJmiHelper()
											.getRefClassForMofClass(
													(MofClass) property
															.getPropertyReference()
															.getStrucfeature()
															.getType()));

					this.serializePrimitive(refValue, primitiveTemplateName);
				} catch (Exception e) {
					String defaultName = (String) valueME.refGetValue("name");
					this.serializePrimitive(defaultName, primitiveTemplateName);
				}
			} else if (refersToParg == null) {
				ModeParg modeArg = (ModeParg) getPArg(property, "Mode");
				String mode = null;
				if (modeArg != null) {
					mode = modeArg.getMode();
				}

				serialize(valueME, mode);
			} else {
				// TODO hack to add autocreated instances of TCS::Keyword to
				// the
				// keywords list
				if (valueME instanceof Keyword) {
					keywords.add(((Keyword) value).getValue());
				}

				Object v = MOINImportedModelAdapter.get(valueME,
						MOINImportedModelAdapter.getString(refersToParg,
								"propertyName"));

				serializePrimitive(v, primitiveTemplateName);
			}
		} else if (MOINImportedModelAdapter.isPrimitive(value)) {
			printWSBlockNoDup();
			serializePrimitive(value, primitiveTemplateName);
		} else {
			error("unsupported " + value.getClass());
		}

	}

	private void serializePropertyCheckingPartial(RefObject element,
			Object currentPropValue, Property property)
			throws SyntaxMismatchException {
		// partial properties emit nothing on model validation errors
		// instead of
		// throwing an exception

		int handle = 0;

		PartialParg partialArg = (PartialParg) getPArg(property, "Partial");
		if (partialArg != null) {
			handle = createSafePoint();
		}

		try {
			serializeProperty(element, currentPropValue, property);
		} catch (SyntaxMismatchException e) {

			if (printPropertyInitExceptions) {
				System.out.println(e.getMessage());
			}

			if (partialArg != null) {
				if (printPropertyInitExceptions) {
					System.out.println("is ignored due to partial property");
				}
				// remove partial output of this property and remove the
				// exception
				resetToSafePoint(handle);
			} else {
				// re-throw exception, this property has to be printed
				// without
				// errors
				throw (e);
			}
		}
	}

	private void validateBounds(RefObject element, Property p, Object propValue)
			throws ForcedBoundsException {

		// check for forced upper and forced lower validity of model element
		ForcedLowerParg lowerArg = (ForcedLowerParg) getPArg(p, "ForcedLower");
		ForcedUpperParg upperArg = (ForcedUpperParg) getPArg(p, "ForcedUpper");

		try {

			if (lowerArg != null) {

				int lowerBound = lowerArg.getValue();

				if (propValue == null) {
					if (lowerBound != 0) {
						throw new Exception();
					}
				}

				if (propValue instanceof Collection) {
					Collection<?> c = (Collection<?>) propValue;
					if (lowerBound > c.size()) {
						throw new Exception();
					}
				} else {
					if (lowerBound > 1) {
						throw new Exception();
					}
				}
			}

			if (upperArg != null) {
				int upperBound = upperArg.getValue();

				if (propValue instanceof Collection) {
					Collection<?> c = (Collection<?>) propValue;
					if (upperBound < c.size()) {
						// TODO find out what should happen. not possible to
						// identify element or should throw exception?
						// throw new Exception();
					}
				}
			}

		} catch (Exception e) {
			throw new ForcedBoundsException(element, p, lowerArg, upperArg,
					context);
		}
	}

	private void serializePrimitive(Object value, String as) {
		if (value instanceof String) {

			// TODO what about serializer attribute?
		        RefObject template = primitiveTemplates.get(as);
		        if(template != null && template instanceof PrimitiveTemplate &&
		                ((PrimitiveTemplate)template).getSerializer() != null &&
		                !((PrimitiveTemplate)template).getSerializer().equals("")) {
		            PrimitiveTemplate primTemplate = (PrimitiveTemplate)template;
                            if (primTemplate.getSerializer().contains("%value%")) {
                                printCustomStringLiteral(primTemplate.getSerializer().replaceAll(
                                        "%value%", (String) value), "");
                            }
		        }
			// TODO what about tokens and token attribute?
		        else if ("stringSymbol".equals(as)) {
				printStringLiteral((String) value);
			} else {
				boolean orKeyword = false;
				if (template != null)
					orKeyword = MOINImportedModelAdapter
							.getBoolUndefinedIsFalse(template, "orKeyword");
				printIdentifier((String) value, orKeyword);
			}
		} else if (value instanceof Integer) {
			printIntegerLiteral(((Integer) value).intValue());
		} else if (value instanceof Double) {
			printRealLiteral(((Double) value).doubleValue());
		} else if (value instanceof Boolean) {
			printBooleanLiteral(((Boolean) value).booleanValue());
		}
	}

	// Low-level serialization

	private final static int TYPE_KEYWORD = 1;
	private final static int TYPE_SYMBOL = 2;
	private final static int TYPE_IDENT = 3;
	private final static int TYPE_BOOL = 4;
	private final static int TYPE_INT = 5;
	private final static int TYPE_REAL = 6;
	private final static int TYPE_STRING = 7;
	private final static int TYPE_SPACE = 8;
	private final static int TYPE_COMMENT = 9;

	private final static int SYMBOL_LS = 16; // symbol with a space before
	// (on the Left)
	private final static int SYMBOL_RS = 32; // symbol with a space after (on
	// the Right)
	private final static int SYMBOL_BS = SYMBOL_LS + SYMBOL_RS; // symbol with
	// spaces Both
	// before and
	// after
	private final static int SYMBOL_LN = 64; // symbol with no space before
	// (even if preceding symbol is
	// RS or BS)
	private final static int SYMBOL_RN = 128; // symbol with no space after

	// (even if following symbol is
	// LS or BS)

	private void printLiteral(RefObject literal) {
		String s = MOINImportedModelAdapter.getString(literal, "value");
		String ltn = MOINImportedModelAdapter.getTypeName(literal);
		if (ltn != null) {
			if (ltn.equals("TCS::Keyword")) {
				printKeyword(s);
			} else {
				printSymbol(s);
			}
		}
	}

	private void printWS(String ws) {
		debug("printing WS = \"" + ws + "\"");
		out.printWhiteSpace(ws);
		context.setTypeLast(TYPE_SPACE);
	}

	private void printWS() {
		printWS(context.getCurrentSeparator().peek());
	}

	private boolean isSymbol(int type, int test) {
		test += TYPE_SYMBOL;
		return (type & test) == test;
	}

	private void printDisambiguationWS() {
		if ((context.getTypeLast() == TYPE_KEYWORD)
				|| (context.getTypeLast() == TYPE_IDENT)
				|| (context.getTypeLast() == TYPE_INT)
				|| (context.getTypeLast() == TYPE_REAL)
				|| (context.getTypeLast() == TYPE_STRING)
				|| (context.getTypeLast() == TYPE_BOOL)
				|| (isSymbol(context.getTypeLast(), SYMBOL_BS))
				|| (isSymbol(context.getTypeLast(), SYMBOL_RS))) {
			printWS();
		}
	}

	private void printWSBlockNoDup() {
		if (context.getTypeLast() != TYPE_SPACE)
			if (!context.getCurrentSeparator().peek().equals(" "))
				printWS();
	}

	private void printWSNoDup() {
		if (context.getTypeLast() != TYPE_SPACE)
			printWS();
	}

	private void printKeyword(String keyword) {
		printDisambiguationWS();
		out.printKeyword(keyword);
		context.setTypeLast(TYPE_KEYWORD);
	}

	private Map<String, Integer> symbols = new HashMap<String, Integer>();

	private void printSymbol(String symbol) {
		Integer type = symbols.get(symbol);
		int typeCurrent = -1;
		if (type == null) {
			typeCurrent = TYPE_SYMBOL;
		} else {
			typeCurrent = type.intValue();
		}
		if (((isSymbol(typeCurrent, SYMBOL_LS) || isSymbol(typeCurrent,
				SYMBOL_BS)) && !isSymbol(context.getTypeLast(), SYMBOL_RN))
				|| ((isSymbol(context.getTypeLast(), SYMBOL_RS) || isSymbol(
						context.getTypeLast(), SYMBOL_BS)) && !isSymbol(
						typeCurrent, SYMBOL_LN))) {

			printWSNoDup();
		}
		out.printSymbol(symbol);
		context.setTypeLast(typeCurrent);
	}

	private void printIdentifier(String ident, boolean orKeyword) {
		printDisambiguationWS();
		boolean simpleIdent = ident.matches("[_a-zA-Z][_a-zA-Z0-9]*");
		if (simpleIdent && !orKeyword)
			simpleIdent = !keywords.contains(ident);
		if ((!orKeyword) && kwCheckIgnoreCase
				&& keywords.contains(ident.toUpperCase())) {
			simpleIdent = false;
		}
		if (simpleIdent) {
			out.printIdentifier(ident);
		} else {
			out.printEscapedIdentifier(identEscStart, ident, identEscEnd);
		}
		context.setTypeLast(TYPE_IDENT);
	}

	private void printBooleanLiteral(boolean v) {
		printDisambiguationWS();
		out.printBoolean(v);
		context.setTypeLast(TYPE_BOOL);
	}

	private void printIntegerLiteral(int v) {
		printDisambiguationWS();
		out.printInteger(v);
		context.setTypeLast(TYPE_INT);
	}

	static {
		dfs.setDecimalSeparator('.');
	}

	private void printRealLiteral(double v) {
		printDisambiguationWS();
		out.printReal(df.format(v)); // TODO: format properly
		context.setTypeLast(TYPE_REAL);
	}

	private void printStringLiteral(String v) {
		printDisambiguationWS();
		out.printString(stringDelim, v.replaceAll("\\\\", "\\\\\\\\")
				.replaceAll("\"", "\\\\\""));
		context.setTypeLast(TYPE_STRING);
	}
	
	private void printCustomStringLiteral(String v, String surroundings) {
            printDisambiguationWS();
            out.printString(surroundings, v);
            context.setTypeLast(TYPE_STRING);
        }

	private void printComment(String c) {
		printDisambiguationWS();
		out.printComment(c);
		context.setTypeLast(TYPE_COMMENT);
	}

	// Source model navigation helpers.

	private static RefObject getPArg(RefObject ame, String name) {
		RefObject ret = null;

		for (Iterator<?> i = MOINImportedModelAdapter.getCol(ame,
				"propertyArgs"); i.hasNext() && (ret == null);) {
			Object arg = i.next();
			if (MOINImportedModelAdapter.getTypeName((RefObject) arg).equals(
					"TCS::" + name + "PArg"))
				ret = (RefObject) arg;
		}

		return ret;
	}

	private static RefObject getBArg(RefObject ame, String name) {
		RefObject ret = null;

		for (Iterator<?> i = MOINImportedModelAdapter.getCol(ame, "blockArgs"); i
				.hasNext()
				&& (ret == null);) {
			Object arg = i.next();
			if (MOINImportedModelAdapter.getTypeName((RefObject) arg).equals(
					"TCS::" + name + "BArg"))
				ret = (RefObject) arg;
		}

		return ret;
	}

	private void debug(String msg) {
		if (debug)
			System.out.println(msg);
	}

	private void error(String msg) {
		System.out.println("ERROR: " + msg + " at "
				+ Arrays.toString(new RuntimeException().getStackTrace()));
	}

	private int createSafePoint() {

		int handle = out.createSafePoint();
		backup.put(handle, context.duplicate());
		return handle;
	}

	private void resetToSafePoint(int handle) {
		context = backup.get(new Integer(handle));
		out.resetToSafePoint(handle);
	}
}
