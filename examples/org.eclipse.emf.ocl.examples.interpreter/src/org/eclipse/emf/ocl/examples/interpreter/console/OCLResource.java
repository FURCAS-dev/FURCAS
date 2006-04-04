/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id: OCLResource.java,v 1.4 2006/04/04 17:52:14 cdamus Exp $
 */

package org.eclipse.emf.ocl.examples.interpreter.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ocl.expressions.AssociationClassCallExp;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionItem;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.CollectionLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionLiteralPart;
import org.eclipse.emf.ocl.expressions.CollectionRange;
import org.eclipse.emf.ocl.expressions.EnumLiteralExp;
import org.eclipse.emf.ocl.expressions.FeatureCallExp;
import org.eclipse.emf.ocl.expressions.IfExp;
import org.eclipse.emf.ocl.expressions.IntegerLiteralExp;
import org.eclipse.emf.ocl.expressions.InvalidLiteralExp;
import org.eclipse.emf.ocl.expressions.IterateExp;
import org.eclipse.emf.ocl.expressions.IteratorExp;
import org.eclipse.emf.ocl.expressions.LetExp;
import org.eclipse.emf.ocl.expressions.MessageExp;
import org.eclipse.emf.ocl.expressions.NullLiteralExp;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.RealLiteralExp;
import org.eclipse.emf.ocl.expressions.StateExp;
import org.eclipse.emf.ocl.expressions.StringLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralPart;
import org.eclipse.emf.ocl.expressions.TypeExp;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.expressions.VariableExp;
import org.eclipse.emf.ocl.expressions.Visitor;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;
import org.eclipse.emf.ocl.helper.OCLParsingException;
import org.eclipse.emf.ocl.parser.EcoreEnvironmentFactory;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.uml.Constraint;


/**
 * A resource for loading and saving OCL expressions.
 */
public class OCLResource
	extends XMIResourceImpl {

	/**
	 * Initializes me with my URI.
	 * 
	 * @param uri my URI
	 */
	public OCLResource(URI uri) {
		super(uri);
	}
	
	/**
	 * Loads an OCL expression from the specified <code>path</code>.  The
	 * OCL expression is converted to a string using a custom AST visitor that
	 * renders the string representation.
	 * 
	 * @param path the absolute path of the XMI file to load
	 * @return the string representation of the OCL expression, if found
	 * @throws IOException if anything goes wrong in loading the XMI file
	 */
	public static String load(String path) throws IOException {
		String result = null;
		
		// create and load the resource
		OCLResource res = new OCLResource(URI.createFileURI(path));
		res.load(Collections.EMPTY_MAP);
		
		OCLExpression expr = res.getOCLExpression();
		if (expr != null) {
			result = (String) expr.accept(new ToStringVisitor());
		}
		
		return result;
	}
	
	/**
	 * Saves the specified OCL expression to an XMI file.
	 * 
	 * @param path the fully-qualified path of the XMI file to save
	 * @param context the OCL context object
	 * @param expr the OCL expression to save
	 * 
	 * @throws RuntimeException if anything goes wrong in parsing
	 * @throws IOException if anything goes wrong in saving
	 * @throws OCLParsingException if anything goes wrong in parsing
	 */
	public static void save(String path, EObject context, String expr)
			throws IOException, OCLParsingException {
		// create an OCL helper to do our parsing.  Use the current resource
		//    set's package registry to resolve OCL namespaces
		IOCLHelper helper = HelperUtil.createOCLHelper(
			new EcoreEnvironmentFactory(
				context.eResource().getResourceSet().getPackageRegistry()));
		
		// use an OCL helper to parse the OCL expression and extract
		//    the AST from it
		helper.setContext(context);
		
		OCLExpression parsed = helper.createQuery(expr);
		
		// create a resource, add the AST to it, and save it
		OCLResource res = new OCLResource(URI.createFileURI(path));
		res.setOCLExpression(parsed);
		
		res.save(Collections.EMPTY_MAP);
	}
	
	/**
	 * Sets my contents to the specified OCL expression.
	 * 
	 * @param expr an OCL expression
	 */
	public void setOCLExpression(OCLExpression expr) {
		getContents().clear();  // clear any previous contents
		getContents().add(expr);
		
		addAllDetachedObjects();
	}
	
	/**
	 * Obtains the OCL expression that I store.
	 * 
	 * @return my OCL expression
	 */
	public OCLExpression getOCLExpression() {
		OCLExpression result = null;
		
		if (!getContents().isEmpty()) {
			result = (OCLExpression) getContents().get(0);
		}
		
		return result;
	}

	/**
	 * Searches the OCL expression tree for any references to
	 * objects that are not in any resource and adds them to me so that they
	 * may be saved.
	 */
	private void addAllDetachedObjects() {
		List toProcess = Collections.singletonList(getOCLExpression());
		
		while (!toProcess.isEmpty()) {
			List detachedFound = new ArrayList();
			
			for (Iterator tree = EcoreUtil.getAllContents(toProcess); tree.hasNext();) {
				EObject next = (EObject) tree.next();
				
				for (Iterator xrefs = next.eCrossReferences().iterator(); xrefs.hasNext();) {
					EObject xref = (EObject) xrefs.next();
					
					if (xref.eResource() == null) {
						// get the root container so that we may attach the entire
						//    contents of this detached tree
						xref = EcoreUtil.getRootContainer(xref);
						
						detachedFound.add(xref);
						
						// attach it to me
						getContents().add(xref);
					}
				}
			}
			
			toProcess = detachedFound;
		}
	}
	
	/**
	 * AST visitor for OCL expressions that converts them to a string.
	 */
	static class ToStringVisitor implements Visitor {

		public Object visitOperationCallExp(OperationCallExp oc) {

			OCLExpression source = oc.getSource();
			EClassifier sourceType = source.getType();
			EOperation oper = oc.getReferredOperation();
			EList args = oc.getArgument();
			int numArgs = args.size();

			String result = source.accept(this)
				+ (sourceType instanceof CollectionType ? "->" : ".") + oper.getName() + "(";//$NON-NLS-3$//$NON-NLS-2$//$NON-NLS-1$
			Iterator iter = args.iterator();
			for (int i = 0; i < numArgs; i++) {
				OCLExpression arg = (OCLExpression) iter.next();
				result += (String) arg.accept(this);
				if (i < numArgs - 1)
					result += ", ";//$NON-NLS-1$
			}
			result += ")";//$NON-NLS-1$
			
			return maybeAtPre(oc, result);
		}

		public Object visitEnumLiteralExp(EnumLiteralExp el) {
			EEnumLiteral l = el.getReferredEnumLiteral();
			return l.toString();
		}

		public Object visitVariableExp(VariableExp v) {

			// get the referred variable name
			Variable vd = v.getReferredVariable();
			String varName = vd.getName();
			return varName;
		}

		/**
		 * Callback for a PropertyCallExp visit. 
		 * 
		 * @param pc the property call expression
		 * 
		 * @return string source.property
		 */
		public Object visitPropertyCallExp(PropertyCallExp pc) {

			EStructuralFeature property = pc.getReferredProperty();
			StringBuffer result = new StringBuffer(
				maybeAtPre(pc, (String) pc.getSource().accept(this) + "." + property.getName()));//$NON-NLS-1$
			
			if (!pc.getQualifier().isEmpty()) {
				result.append('[');
				
				for (Iterator iter = pc.getQualifier().iterator(); iter.hasNext();) {
					OCLExpression next = (OCLExpression) iter.next();
					
					result.append(next.accept(this));
					
					if (iter.hasNext()) {
						result.append(", "); //$NON-NLS-1$
					}
				}
				
				result.append(']');
			}
			
			return result.toString();
		}

		/**
		 * Callback for an AssociationClassCallExp visit. 
		 * @param ac the association class expression
		 * @return string source.ref
		 */
		public Object visitAssociationClassCallExp(AssociationClassCallExp ac) {

			EClass ref = ac.getReferredAssociationClass();
			StringBuffer result = new StringBuffer(
				maybeAtPre(ac, (String) ac.getSource().accept(this) + "." + ref.getName()));//$NON-NLS-1$
			
			if (ac.getNavigationSource() != null) {
				result.append('[');
				result.append(ac.getNavigationSource().getName());
				result.append(']');
			}
			
			return result.toString();
		}

		public Object visitVariable(Variable vd) {
			String varName = vd.getName();
			EClassifier type = vd.getType();
			OCLExpression init = vd.getInitExpression();
			String result = varName;

			if (type != null)
				result += " : " + type.getName();//$NON-NLS-1$
			if (init != null)
				result += " = " + init.accept(this);//$NON-NLS-1$
			return result;
		}

		public Object visitIfExp(IfExp i) {
			OCLExpression cond = i.getCondition();
			OCLExpression thenexp = i.getThenExpression();
			OCLExpression elseexp = i.getElseExpression();
			return "if " + (String) cond.accept(this) + " then " + //$NON-NLS-2$//$NON-NLS-1$
				(String) thenexp.accept(this) + " else " + //$NON-NLS-1$
				(String) elseexp.accept(this);
		}

		public Object visitTypeExp(TypeExp t) {
			return getQualifiedName(t.getReferredType());
		}
		
		public Object visitStateExp(StateExp s) {
			return s == null? "" : s.getName(); //$NON-NLS-1$
		}
		
		public Object visitMessageExp(MessageExp m) {
			StringBuffer result = new StringBuffer();
			
			result.append(m.getTarget().accept(this));
			
			result.append((m.getType() == Types.OCL_BOOLEAN)? "^" : "^^");  //$NON-NLS-1$//$NON-NLS-2$
		
			if (m.getCalledOperation() != null) {
				result.append(m.getCalledOperation().getOperation().getName());
			} else if (m.getSentSignal() != null) {
				result.append(m.getSentSignal().getSignal().getName());
			}
			
			result.append('(');
			
			for (Iterator iter = m.getArgument().iterator(); iter.hasNext();) {
				result.append(((OCLExpression) iter.next()).accept(this));
				
				if (iter.hasNext()) {
					result.append(", ");  //$NON-NLS-1$
				}
			}
			
			result.append(')');
			
			return result.toString();
		}

		public Object visitUnspecifiedValueExp(UnspecifiedValueExp uv) {
			StringBuffer result = new StringBuffer();
			result.append("?"); //$NON-NLS-1$
			if (uv.getType() != null && uv.getType() != Types.OCL_VOID) {
				result.append(" : "); //$NON-NLS-1$
				result.append(uv.getType().getName());
			}
			
			return result.toString();
		}
		
		private String getQualifiedName(EClassifier type) {
			StringBuffer result = new StringBuffer();
			
			appendQualifiedName(type, result);
			
			return result.toString();
		}
		
		private void appendQualifiedName(EClassifier type, StringBuffer buf) {
			if (type.getEPackage() != null) {
				appendQualifiedName(type.getEPackage(), buf);
				buf.append("::"); //$NON-NLS-1$
			}
			
			buf.append(type.getName());
		}

		private void appendQualifiedName(EPackage pkg, StringBuffer buf) {
			if (pkg.getESuperPackage() != null) {
				appendQualifiedName(pkg.getESuperPackage(), buf);
				buf.append("::"); //$NON-NLS-1$
			}
			
			buf.append(pkg.getNsPrefix());
		}

		public Object visitIntegerLiteralExp(IntegerLiteralExp il) {
			return il.getIntegerSymbol().toString();
		}

		public Object visitRealLiteralExp(RealLiteralExp rl) {
			return rl.getRealSymbol().toString();
		}

		public Object visitStringLiteralExp(StringLiteralExp sl) {
			return "'" + sl.getStringSymbol() + "'";//$NON-NLS-2$//$NON-NLS-1$
		}

		public Object visitBooleanLiteralExp(BooleanLiteralExp bl) {
			return bl.getBooleanSymbol().toString();
		}

		public Object visitLetExp(LetExp l) {
			String result = "let " + l.getVariable().accept(this) + " in " + //$NON-NLS-2$//$NON-NLS-1$
				l.getIn().accept(this);
			return result;

		}

		public Object visitIterateExp(IterateExp ie) {
			// get the variable declaration for the result
			Variable vd = ie.getResult();
			//		String resultName = vd.getName();

			// get the list of ocl iterators
			EList iterators = ie.getIterator();
			int numIters = iterators.size();

			// evaluate the source collection
			String result = (String) ie.getSource().accept(this)
				+ "->" + "iterate(";//$NON-NLS-2$//$NON-NLS-1$

			for (int i = 0; i < numIters; i++) {
				Variable iter = (Variable) iterators.get(i);
				result += (String) iter.accept(this);
				if (i < iterators.size() - 1)
					result += ", ";//$NON-NLS-1$
			}
			result += "; " + (String) vd.accept(this) + "| ";//$NON-NLS-2$//$NON-NLS-1$

			OCLExpression body = ie.getBody();
			result += (String) body.accept(this) + ")";//$NON-NLS-1$

			return result;
		}

		public Object visitIteratorExp(IteratorExp ie) {

			// get the list of ocl iterators
			EList iterators = ie.getIterator();
			int numIters = iterators.size();

			// evaluate the source collection
			String result = (String) ie.getSource().accept(this) + "->"//$NON-NLS-1$
				+ ie.getName() + "(";//$NON-NLS-1$
			for (int i = 0; i < numIters; i++) {
				Variable iter = (Variable) iterators.get(i);
				result += (String) iter.accept(this);
				if (i < iterators.size() - 1)
					result += ", ";//$NON-NLS-1$
			}
			result += " | ";//$NON-NLS-1$

			OCLExpression body = ie.getBody();
			result += (String) body.accept(this) + ")";//$NON-NLS-1$

			return result;
		}

		public Object visitCollectionLiteralExp(CollectionLiteralExp cl) {
			// construct the appropriate collection from the parts
			// based on the collection kind.
			CollectionKind kind = cl.getKind();

			List parts = cl.getPart();
			String result;
			if (kind == CollectionKind.SET_LITERAL)
				result = "Set {";//$NON-NLS-1$
			else if (kind == CollectionKind.ORDERED_SET_LITERAL)
				result = "OrderedSet {";//$NON-NLS-1$
			else if (kind == CollectionKind.BAG_LITERAL)
				result = "Bag {";//$NON-NLS-1$
			else
				result = "Sequence {";//$NON-NLS-1$

			for (Iterator it = parts.iterator(); it.hasNext();) {
				CollectionLiteralPart part = (CollectionLiteralPart) it.next();
				if (part instanceof CollectionItem) {
					// CollectionItem part
					CollectionItem item = (CollectionItem) part;
					OCLExpression itemExp = item.getItem();
					result += (String) itemExp.accept(this);
				} else { // must be a CollectionRange
					CollectionRange item = (CollectionRange) part;
					result += (String) item.getFirst().accept(this) + ".." + //$NON-NLS-1$
						(String) item.getLast().accept(this);
				}
				if (it.hasNext())
					result += ", "; //$NON-NLS-1$
			}
			return result + "}"; //$NON-NLS-1$
		}

		public Object visitTupleLiteralExp(TupleLiteralExp tl) {
			// construct the appropriate collection from the parts
			// based on the collection kind.
			String result = "Tuple{";//$NON-NLS-1$
			EList tuplePart = tl.getPart();
			Iterator iter = tuplePart.iterator();
			while (iter.hasNext()) {
				TupleLiteralPart tp = (TupleLiteralPart) iter.next();
				result += (String) tp.accept(this);
				if (iter.hasNext())
					result += ", ";//$NON-NLS-1$
			}
			return result + "}";//$NON-NLS-1$
		}
		
		public Object visitTupleLiteralPart(TupleLiteralPart tp) {
			String varName = tp.getName();
			EClassifier type = tp.getType();
			OCLExpression init = tp.getValue();
			String result = varName;

			if (type != null) {
				result += " : " + type.getName();//$NON-NLS-1$
			}
			
			if (init != null) {
				result += " = " + init.accept(this);//$NON-NLS-1$
			}
			
			return result;
		}

		/**
		 * Renders a constraint with its context and expression.
		 */
		public Object visitConstraint(Constraint constraint) {
			StringBuffer result = new StringBuffer();
			
			List constrained = constraint.getConstrainedElement();
			
			if (!constrained.isEmpty()) {
				EObject elem = (EObject) constrained.get(0);
				
				result.append("context "); //$NON-NLS-1$
				if (elem instanceof EClassifier) {
					result.append(((EClassifier) elem).getName());
				} else {
					appendOperationSignature(result, (EOperation) elem);
				}
				
				result.append(' ');
			}
			
			String stereo = constraint.getStereotype();
			if (Constraint.PRECONDITION.equals(stereo)) {
				result.append("pre: "); //$NON-NLS-1$
			} else if (Constraint.POSTCONDITION.equals(stereo)) {
				result.append("post: "); //$NON-NLS-1$
			} else if (Constraint.BODY.equals(stereo)) {
				result.append("body: "); //$NON-NLS-1$
			} else {
				result.append("inv: "); //$NON-NLS-1$
			}
			
			result.append(constraint.getBody().accept(this));
			
			return result.toString();
		}
		
		private void appendOperationSignature(StringBuffer buf, EOperation operation) {
			buf.append(operation.getName()).append('(');
			
			boolean comma = false;
			for (Iterator iter = operation.getEParameters().iterator(); iter.hasNext();) {
				EParameter parm = (EParameter) iter.next();
				
				if (comma) {
					buf.append(", "); //$NON-NLS-1$
				} else {
					comma = true;
				}
				
				buf.append(parm.getName()).append(" : "); //$NON-NLS-1$
				
				if (parm.getEType() != null) {
					buf.append(parm.getEType().getName());
				} else {
					buf.append(Types.OCL_VOID.getName());
				}
			}
			
			buf.append(") :"); //$NON-NLS-1$
			if (operation.getEType() != null) {
				buf.append(' ').append(operation.getEType().getName());
			}
		}

		private String maybeAtPre(FeatureCallExp mpc, String base) {
			return mpc.isMarkedPre() ? base + "@pre" : base; //$NON-NLS-1$
		}

		public Object visitInvalidLiteralExp(InvalidLiteralExp il) {
			return "OclInvalid"; //$NON-NLS-1$
		}

		public Object visitNullLiteralExp(NullLiteralExp il) {
			return "null"; //$NON-NLS-1$
		}
	}
}
