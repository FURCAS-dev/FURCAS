package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.omg.ocl.attaching.OperationBodyDefinition;
import org.omg.ocl.attaching.__impl.OperationBodyDefinitionImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EClassifierImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.NavigationCallExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.impl.OperationCallExpImpl;
import org.eclipse.ocl.ecore.impl.TypeExpImpl;
import org.eclipse.ocl.ecore.internal.OCLFactoryImpl;
import org.eclipse.ocl.ecore.internal.UMLReflectionImpl;
import org.eclipse.ocl.expressions.operations.OCLExpressionOperations;
import org.eclipse.ocl.parser.OCLLexer;
import org.eclipse.ocl.parser.OCLLexerprs;
import org.eclipse.ocl.parser.OCLParser;
import org.eclipse.ocl.parser.OCLParserprs;
import org.eclipse.ocl.parser.OCLParsersym;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.utilities.OCLFactory;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.OperationCallExpImpl;
import org.omg.ocl.expressions.__impl.OperationCallExpInternal;
import org.omg.ocl.expressions.__impl.TypeExpInternal;

import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.treewalker.TreeWalker;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * A tree walker that finds and remembers all expressions of type {@link AttributeCallExp} and
 * {@link AssociationEndCallExp}. Those are the ones for which later we must be able to find them quickly based on the
 * association/attribute and model element for which a corresponding change event was sent.<p>
 * 
 * TODO Turn this into a cache where a client can free the results of walking a top-level expression after using it
 * 
 * @author Axel Uhl D043530
 * 
 */
public class AssociationEndAndAttributeCallFinder extends TreeWalker {
	private Map<EAttribute, Set<PropertyCallExp>> attributeCallExpressions = new HashMap<EAttribute, Set<PropertyCallExp>>();
	private Map<EReference, Set<NavigationCallExp>> associationEndCallExpressions = new HashMap<EReference, Set<NavigationCallExp>>();
	private Set<OCLExpression> visitedExpressions = new HashSet<OCLExpression>();
	private Map<EClassifier, Set<OperationCallExp>> allInstancesCalls = new HashMap<EClassifier, Set<OperationCallExp>>();

	public AssociationEndAndAttributeCallFinder() {
		super();
	}

	protected void upAttributeCallExp(PropertyCallExp ace) {
		Set<PropertyCallExp> set = attributeCallExpressions.get(ace.getReferredProperty());
		if (set==null) {
			set = new HashSet<PropertyCallExp>();
			attributeCallExpressions.put((EAttribute) ace.getReferredProperty(), set);
		}
		set.add(ace);
	}

	protected void upAssociationEndCallExp(NavigationCallExp ace) {
		Set<NavigationCallExp> set = associationEndCallExpressions.get((EReference) ace.getNavigationSource());
		if (set==null) {
			set = new HashSet<NavigationCallExp>();
			associationEndCallExpressions.put((EReference) ace.getNavigationSource(), set);
		}
		set.add(ace);
	}

	/**
	 * If an operation is defined by an OCL body, walk that body too and collect all attribute
	 * and association end calls from it recursively.
	 */
	protected void upOperationCallExp(OperationCallExp oce) {
		EOperation referredOperation = ((OperationCallExpImpl) oce).getReferredOperation();
		
//		OperationBodyDefinitionImpl assoc = (OperationBodyDefinitionImpl) connection
//		.getAssociation(OperationBodyDefinition.ASSOCIATION_DESCRIPTOR);
		//FIXME: don't know how to get the operation definition to walk it recursively
		OCLExpression bodyExpr = null;
		if (bodyExpr != null) {
			walk(bodyExpr);
		} else if (referredOperation.getName().equals(OCLParsersym.orderedTerminalSymbols[OCLParsersym.TK_allInstances])) {
//			EClassifier classifier = ((TypeExpImpl) ((OperationCallExpImpl) oce).getSource()).getReferredType();
			EClassifier classifier = ((TypeExp)oce.getSource()).getReferredType();
			for (EClassifierImpl specialization : getAllSpecializationsIncludingSelf((EClassifierImpl) classifier)) {
				Set<OperationCallExp> set = allInstancesCalls.get(specialization);
				if (set == null) {
					set = new HashSet<OperationCallExp>();
					allInstancesCalls.put(specialization, set);
				}
				set.add(oce);
			}
		}
	}

	private Set<EClassifierImpl> getAllSpecializationsIncludingSelf(EClassifierImpl classifier) {
		Set<EClassifierImpl> result = new HashSet<EClassifierImpl>();
		if (classifier instanceof EClass){
			EClass cls = (EClass) classifier;
			for (EClassifier anotherCls : cls.getEPackage().getEClassifiers()){
				//FIXME: if the class hierarchy spans over more than one Package this won't work
				if (anotherCls instanceof EClass && cls.isSuperTypeOf((EClass) anotherCls)){
					result.add((EClassifierImpl)anotherCls);
				}
			}
			result.add(classifier);
		} else {
			// classifier is a datatype
			result.add((EClassifierImpl)classifier);
		}
		return result;
	}

	/**
	 * Always returns a non-<tt>null</tt> set
	 */
	public Set<PropertyCallExp> getAttributeCallExpressions(EAttribute a) {
		Set<PropertyCallExp> result;
		Set<PropertyCallExp> lookup = attributeCallExpressions.get(a);
		if (lookup == null) {
			result = Collections.emptySet();
		} else {
			result = Collections.unmodifiableSet(attributeCallExpressions.get(a));
		}
		return result;
	}

	/**
	 * Always returns a non-<tt>null</tt> set
	 */
	public Set<NavigationCallExp> getAssociationEndCallExpressions(EReference a) {
		Set<NavigationCallExp> result;
		Set<NavigationCallExp> lookup = associationEndCallExpressions.get(a);
		if (lookup == null) {
			result = Collections.emptySet();
		} else {
			result = Collections.unmodifiableSet(associationEndCallExpressions.get(a));
		}
		return result;
	}

	/**
	 * Always returns a non-<tt>null</tt> set. Finds all occurrences of an <tt>allInstances</tt> call on a type
	 * expression for the classifier <tt>c</tt> or its generalizations in the expression analyzed by this visitor.
	 */
	public Set<OperationCallExp> getAllInstancesCallsFor(EClassifier c) {
		Set<OperationCallExp> result = allInstancesCalls.get(c);
		if (result == null) {
			result = Collections.emptySet();
		}
		return result;
	}

	public void walk(OCLExpression expression) {
//		if (!connection.isAlive()) {
//			throw new RuntimeException("Can't walk OCL expression with dead connection "+connection);
//		}
		if (!visitedExpressions.contains(expression)) {
			visitedExpressions.add(expression);
			super.walk(expression);
		}
	}
}
