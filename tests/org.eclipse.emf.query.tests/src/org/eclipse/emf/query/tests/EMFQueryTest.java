/**
 * <copyright>
 *
 * Copyright (c) 2002-2005 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.query.tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import org.eclipse.emf.examples.extlibrary.Book;
import org.eclipse.emf.examples.extlibrary.EXTLibraryFactory;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.Not;
import org.eclipse.emf.query.conditions.ObjectInstanceCondition;
import org.eclipse.emf.query.conditions.booleans.BooleanCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectSource;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.TypeRelation;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferenceValueCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EStructuralFeatureValueGetter;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.IEStructuralFeatureValueGetter;
import org.eclipse.emf.query.conditions.strings.StringValue;
import org.eclipse.emf.query.internal.statements.QueryStatement;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.IteratorKind;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author Yasser Lulu 
 */
public class EMFQueryTest
	extends TestCase {

	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	public static Test suite() {
		return new TestSuite(EMFQueryTest.class);
	}

	private Collection modelElements;

	private Model model;

	private org.eclipse.uml2.uml.Class instance_Class1;

	private Resource resource;

	protected IEStructuralFeatureValueGetter eStructuralFeatureValueGetter;

	//    private EClass namedElement_EClass;
	private EClass class_EClass;

	//    private EClass classifier_EClass;
	//    private EClass association_EClass;
	//    private EClass generalization_EClass;
	private EClass parameter_EClass;

	private EAttribute name_EAttribute;

	private EReference operation_EReference;

	//    private EReference relationship_EReference;    
	//    private EReference property_associationEnd_EReference;
	//    private EReference simplerelationship_nonOwningEnd_EReference;

	public EMFQueryTest(String name) {
		super(name);

	}

	public EObject findElementWithFullyQualifiedName(EObject inputModel,
		String fullyQualifiedName) {

		QueryStatement query = new SELECT(1, new FROM(inputModel), new WHERE(
			new EObjectTypeRelationCondition(UMLPackage.eINSTANCE
				.getNamedElement(), TypeRelation.SAMETYPE_OR_SUBTYPE_LITERAL)
				.AND(new EObjectAttributeValueCondition(UMLPackage.eINSTANCE
					.getNamedElement_QualifiedName(), new StringValue(
					fullyQualifiedName), EStructuralFeatureValueGetter.getInstance()))));

		IQueryResult resultSet = query.execute();

		//return the EObject found -if any
		Iterator it = resultSet.iterator();
		return (it.hasNext()) ? (EObject) it.next() : null;

	}

	//	Optimized version; first its gets the namespace whose fully qualified name is a prefix for the one we're looking for, then looks for 
	//	the one we are looking for in the direct contents of this name space using the simple name. None namespaces are pruned out completely from the search
	//	and then only namesaces are asked for their fully qualified name -which a costly operation- and then the first one matches will have its children asked for their simple
	//	name
	public EObject findElementWithFullyQualifiedName(EObject inputModel,
		String containingFullyQualifiedName, String simpleName) {
		QueryStatement query = new SELECT(1, new FROM(new SELECT(1, new FROM(
			inputModel, new EObjectTypeRelationCondition(UMLPackage.eINSTANCE
				.getNamespace(), TypeRelation.SAMETYPE_OR_SUBTYPE_LITERAL)),
			new WHERE(new EObjectAttributeValueCondition(UMLPackage.eINSTANCE
				.getNamedElement_QualifiedName(), new StringValue(
				containingFullyQualifiedName),
				EStructuralFeatureValueGetter.getInstance()))),
			IteratorKind.FLAT_LITERAL), new WHERE(
			new EObjectTypeRelationCondition(UMLPackage.eINSTANCE
				.getNamedElement(), TypeRelation.SAMETYPE_OR_SUBTYPE_LITERAL)
				.AND(new EObjectAttributeValueCondition(UMLPackage.eINSTANCE
					.getNamedElement_Name(), new StringValue(simpleName),
					EStructuralFeatureValueGetter.getInstance()))));

		IQueryResult resultSet = query.execute();

		//return the EObject found -if any
		Iterator it = resultSet.iterator();
		return (it.hasNext()) ? (EObject) it.next() : null;
	}

	protected IEStructuralFeatureValueGetter getEStructuralFeatureValueGetter() {
		if (eStructuralFeatureValueGetter == null) {
			eStructuralFeatureValueGetter = EStructuralFeatureValueGetter.getInstance();
		}
		return eStructuralFeatureValueGetter;
	}

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		modelElements = new ArrayList();
		modelElements.add(getModel());

		//        namedElement_EClass = UML2Package.eINSTANCE.getNamedElement();
		class_EClass = UMLPackage.eINSTANCE.getClass_();
		//        classifier_EClass = UML2Package.eINSTANCE.getClassifier();
		//        generalization_EClass = UML2Package.eINSTANCE.getGeneralization();
		//        association_EClass = UML2Package.eINSTANCE.getAssociation();
		parameter_EClass = UMLPackage.eINSTANCE.getParameter();
		name_EAttribute = UMLPackage.eINSTANCE.getNamedElement_Name();
		operation_EReference = UMLPackage.eINSTANCE.getClass_OwnedOperation();

		////        relationship_EReference = 
		////        //CorePackage.eINSTANCE.getNamedModelElement_Relationship();
		////
		////        property_associationEnd_EReference 
		////        //CorePackage.eINSTANCE.getAssociation_End();
		////
		////        simplerelationship_nonOwningEnd_EReference = 
		////        //        RelationshipsPackage.eINSTANCE.getSimpleRelationship_NonOwningEnd()

	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		resource = null;
		super.tearDown();
	}

	private void logicalOperatorsTesting() {
		Condition FALSE = new BooleanCondition(false) {

			public boolean isSatisfied(Object object) {
				return false;
			}
		};
		Condition TRUE = new BooleanCondition(true) {

			public boolean isSatisfied(Object object) {
				return true;
			}
		};

		boolean res_1 = (False() && False() || TRUE());
		boolean res_2 = (FALSE.AND(FALSE).OR(TRUE)).isSatisfied(null);
		assertEquals(res_1, res_2);
		assertTrue(res_1);

		res_1 = (False() && (False() || TRUE()));
		res_2 = (FALSE.AND((FALSE).OR(TRUE))).isSatisfied(null);
		assertEquals(res_1, res_2);
		assertFalse(res_1);
	}

	private boolean False() {
		return false;
	}

	private boolean TRUE() {
		return true;
	}

	public void test_EMFQuery() {
		logicalOperatorsTesting();

		IQueryResult resultSet = getClassInstances_NamedQuery(1, "Class1")//$NON-NLS-1$
			.execute();
		assertTrue(resultSet.size() == 1);
		instance_Class1 = (org.eclipse.uml2.uml.Class) resultSet.toArray()[0];
		org.eclipse.uml2.uml.Class ccc = getClassNamed_InstanceBruteForce("Class1"); //$NON-NLS-1$
		assertTrue(ccc.equals(instance_Class1));

		resultSet = getAllParamsQuery().execute();
		assertTrue(resultSet.size() == 2);

		resultSet = getAllClassesQuery().execute();
		assertTrue(resultSet.size() == 6);

		resultSet = getClassInstances_NOT_NamedQuery("Class2").execute(); //$NON-NLS-1$
		assertTrue(resultSet.size() == 5);

		resultSet = getClassInstances_NamedQuery(1, "ClassFoo").execute(); //$NON-NLS-1$
		assertTrue(resultSet.size() == 1);

		resultSet = getParamInstances_NamedQuery("Parameter2").execute(); //$NON-NLS-1$
		assertTrue(resultSet.size() == 1);

		resultSet = getClassesWithFunctionNamedQuery("foo").execute(); //$NON-NLS-1$
		assertTrue(resultSet.getException() == null);
		assertTrue(resultSet.size() == 0);

		resultSet = getClassesWithFunctionNamedQuery("Operation1").execute(); //$NON-NLS-1$
		assertTrue(resultSet.size() == 1);

		resultSet = getElementNamedQuery("Operation22").execute(); //$NON-NLS-1$
		assertTrue(resultSet.size() == 1);

		//        resultSet = getDirectSubClassesQuery_Refined(instance_Class1).execute();
		//        QueryResultSet resultSet_2 =
		//            getDirectSubClassesQuery(instance_Class1).execute();
		//        assertTrue(resultSet.getEObjects().equals(resultSet_2.getEObjects()));
		//        assertTrue(resultSet.size() == 1);
		//
		//        resultSet = getAllSubClassesQuery(instance_Class1).execute();
		//        assertTrue(resultSet.size() == 2);
		//
		//        resultSet =
		//            getAssociatedClassesQuery_Refined(instance_Class1).execute();
		//        resultSet_2 = getAssociatedClassesQuery(instance_Class1).execute();
		//        assertTrue(resultSet.getEObjects().equals(resultSet_2.getEObjects()));
		//        assertTrue(resultSet.size() == 1);

		//TODO: temporarily disabled until we start using jdk 1.4 whihc is needed by the
		//ocl.jar we use

		////        resultSet = getOCLQuery("Blank Model", namedElement_EClass).execute(); //$NON-NLS-1$
		////        assertTrue(resultSet.getEObjects().toArray()[0].equals(getModel()));
		////
		////        resultSet = getOCLQuery("contextFree", null).execute(); //$NON-NLS-1$
		////        assertTrue(resultSet.size() == 3);
		////
		////        resultSet = getOCLQuery("0123456789", null).execute(); //$NON-NLS-1$
		////        assertTrue(
		////            (resultSet.getException() == null) && (resultSet.size() == 0));

	}

	//	private QueryStatement getOCLQuery(String name, EClass eClass) {
	//		String oclQueryString = "name = '" + name + "'"; //$NON-NLS-2$//$NON-NLS-1$
	//		return new SELECT(new FROM(getQueryObjects()), new WHERE(
	//			new OclConstraintCondition(oclQueryString, eClass,
	//				getEStructuralFeatureValueGetter())));
	//	}

	//    private QueryStatement getAssociatedClassesQuery(Class clazz) {
	//        return new SELECT(
	//            new FROM(
	//                new SELECT(
	//                    new FROM(getQueryObjects()),
	//                    new WHERE(
	//                        new EObjectTypeRelationCondition(
	//                            class_EClass,
	//                            new TypeContainmentPruneHandler(
	//                                classifier_EClass)).AND(
	//                            new ENot(new EObjectInstanceCondition(clazz)))))),
	//            new WHERE(
	//                new EObjectReferenceValueCondition(
	//                    CorePackage.eINSTANCE.getNamedModelElement_Relationship(),
	//                    new EObjectTypeRelationCondition(
	//                        association_EClass).AND(
	//                        new EObjectReferenceValueCondition(
	//                            CorePackage.eINSTANCE.getAssociation_End(),
	//                            new EObjectReferenceValueCondition(
	//                                RelationshipsPackage
	//                                    .eINSTANCE
	//                                    .getSimpleRelationship_NonOwningEnd(),
	//                                new EObjectInstanceCondition(clazz),
	//                                getEStructuralFeatureValueGetter()),
	//                            getEStructuralFeatureValueGetter())),
	//                    getEStructuralFeatureValueGetter())));
	//    }
	//
	//    private QueryStatement getAssociatedClassesQuery_Refined(Class clazz) {
	//        return new SELECT(
	//            new FROM(getQueryObjects()),
	//            new WHERE(
	//                new EObjectReferenceValueCondition(
	//                    new EObjectTypeRelationCondition(
	//                        class_EClass,
	//                        new TypeContainmentPruneHandler(
	//                            classifier_EClass)).AND(
	//                        new ENot(new EObjectInstanceCondition(clazz))),
	//                    CorePackage.eINSTANCE.getNamedModelElement_Relationship(),
	//                    new EObjectTypeRelationCondition(
	//                        association_EClass).AND(
	//                        new EObjectReferenceValueCondition(
	//                            CorePackage.eINSTANCE.getAssociation_End(),
	//                            new EObjectReferenceValueCondition(
	//                                RelationshipsPackage
	//                                    .eINSTANCE
	//                                    .getSimpleRelationship_NonOwningEnd(),
	//                                new EObjectInstanceCondition(clazz),
	//                                getEStructuralFeatureValueGetter()),
	//                            getEStructuralFeatureValueGetter())),
	//                    getEStructuralFeatureValueGetter())));
	//    }
	//
	//    private QueryStatement getAllSubClassesQuery(final Class clazz) {
	//        return new QueryStatement(false, new NullProgressMonitor()) {
	//            protected void doExecute() {
	//                QueryResultSet recursiveResultSet = new QueryResultSet();
	//                QueryResultSet resultSet =
	//                    getDirectSubClassesQuery_Refined(clazz).execute();
	//                recursiveResultSet.addAll(resultSet);
	//                Iterator it = resultSet.iterator();
	//                while (it.hasNext() && (resultSet.getException() == null)) {
	//                    resultSet =
	//                        getAllSubClassesQuery((Class)it.next()).execute();
	//                    recursiveResultSet.addAll(resultSet);
	//                }
	//                Exception exeption = resultSet.getException();
	//                if (exeption != null) {
	//                    //preserve exceptions to caller...
	//                    recursiveResultSet =
	//                        new QueryResultSet(new HashSet(), exeption);
	//                }
	//                setResultSet(recursiveResultSet);
	//            }
	//            public boolean canBeResumed() {
	//                return false;
	//            }
	//            protected void doResume() {}
	//        };
	//    }
	//
	//    private QueryStatement getDirectSubClassesQuery(Class clazz) {
	//        return new SELECT(
	//            new FROM(
	//                new SELECT(
	//                    new FROM(getQueryObjects()),
	//                    new WHERE(
	//                        new EObjectTypeRelationCondition(
	//                            class_EClass,
	//                            new TypeContainmentPruneHandler(
	//                                classifier_EClass))))),
	//            new WHERE(
	//                new EObjectReferenceValueCondition(
	//                    CorePackage.eINSTANCE.getNamedModelElement_Relationship(),
	//                    new EObjectTypeRelationCondition(
	//                        generalization_EClass).AND(
	//                        new EObjectReferenceValueCondition(
	//                            RelationshipsPackage
	//                                .eINSTANCE
	//                                .getSimpleRelationship_NonOwningEnd(),
	//                            new EObjectInstanceCondition(clazz),
	//                            getEStructuralFeatureValueGetter())),
	//                    getEStructuralFeatureValueGetter())));
	//    }
	//
	//    private QueryStatement getDirectSubClassesQuery_Refined(Class clazz) {
	//        return new SELECT(
	//            new FROM(getQueryObjects()),
	//            new WHERE(
	//                new EObjectReferenceValueCondition(
	//                    new EObjectTypeRelationCondition(
	//                        class_EClass,
	//                        new TypeContainmentPruneHandler(
	//                            classifier_EClass)),
	//                    CorePackage.eINSTANCE.getNamedModelElement_Relationship(),
	//                    new EObjectTypeRelationCondition(
	//                        generalization_EClass).AND(
	//                        new EObjectReferenceValueCondition(
	//                            RelationshipsPackage
	//                                .eINSTANCE
	//                                .getSimpleRelationship_NonOwningEnd(),
	//                            new EObjectInstanceCondition(clazz),
	//                            getEStructuralFeatureValueGetter())),
	//                    getEStructuralFeatureValueGetter())));
	//    }

	public void test_QueryStatementExceptionHandling() {
		final RuntimeException exception = new RuntimeException();
		
		QueryStatement statement = new QueryStatement(false, new NullProgressMonitor()) {
			public boolean canBeResumed() {
				return false;
			}

			protected void doExecute() {
				throw exception;
			}

			protected void doResume() {
				doExecute();
			}
		};
		
		final boolean[] addedLogEntry = new boolean[1];
		addedLogEntry[0] = false;
		
		ILogListener logListener = new ILogListener() {
			public void logging(IStatus status, String plugin) {
				if (status.getException() == exception) {
					addedLogEntry[0] = true;
				}
			}
		};
		
		Platform.addLogListener(logListener);
		assertEquals(statement.execute().getException(),exception);
		Platform.removeLogListener(logListener);
		assertTrue(addedLogEntry[0]);
	}
	
	public void test_EAttributeDefaultHandling_RATLC00536311() {
		Book b = EXTLibraryFactory.eINSTANCE.createBook();
		
		EAttribute categoryAttribute = EXTLibraryPackage.eINSTANCE.getBook_Category();
		
		SELECT s = new SELECT(
				new FROM(new EObjectSource(b)),
				new WHERE(new EObjectAttributeValueCondition(categoryAttribute,
							new ObjectInstanceCondition(categoryAttribute.getDefaultValue()),
							EStructuralFeatureValueGetter.getInstance())));
		
		IQueryResult result = s.execute();
		
		assertNull(result.getException());
		assertEquals(1,result.getEObjects().size());
	}
	
	private QueryStatement getClassesWithFunctionNamedQuery(String functionName) {
		return new SELECT(new FROM(getQueryObjects()), new WHERE(
			new EObjectTypeRelationCondition(class_EClass)
				.AND(new EObjectReferenceValueCondition(operation_EReference,
					new EObjectAttributeValueCondition(name_EAttribute,
						new StringValue(functionName),
						getEStructuralFeatureValueGetter()),
					getEStructuralFeatureValueGetter()))));
	}

	private QueryStatement getClassInstances_NamedQuery(int maxCount,
		String className) {
		return new SELECT(maxCount, new FROM(getQueryObjects()), new WHERE(
			new EObjectTypeRelationCondition(class_EClass)
				.AND(new EObjectAttributeValueCondition(name_EAttribute,
					new StringValue(className),
					getEStructuralFeatureValueGetter()))));
	}

	private QueryStatement getParamInstances_NamedQuery(String parameterName) {
		return new SELECT(new FROM(getQueryObjects()), new WHERE(
			new EObjectAttributeValueCondition(
				new EObjectTypeRelationCondition(parameter_EClass),
				name_EAttribute, new StringValue(parameterName),
				getEStructuralFeatureValueGetter())));
	}

	private QueryStatement getAllClassesQuery() {
		return new SELECT(new FROM(getQueryObjects()), new WHERE(
			new EObjectTypeRelationCondition(class_EClass)));
	}

	private QueryStatement getAllParamsQuery() {
		return new SELECT(new FROM(getQueryObjects()), new WHERE(
			new EObjectTypeRelationCondition(parameter_EClass)));
	}

	private QueryStatement getClassInstances_NOT_NamedQuery(String className) {
		return new SELECT(new FROM(getQueryObjects()), new WHERE(
			new EObjectAttributeValueCondition(
				new EObjectTypeRelationCondition(class_EClass),
				name_EAttribute, new Not(new StringValue(className)),
				getEStructuralFeatureValueGetter())));
	}

	private org.eclipse.uml2.uml.Class getClassNamed_InstanceBruteForce(
		final String name) {
		QueryStatement statement = new SELECT(new FROM(getQueryObjects()),
			new WHERE(new EObjectCondition() {

				private boolean shouldPrune;

				public boolean shouldPrune(EObject object) {
					return shouldPrune;
				}

				public boolean isSatisfied(EObject element) {
					if (element.eClass() == class_EClass) {
						if (((NamedElement) element).getName().equals(name)) {
							shouldPrune = true;
							return true;
						}
					}
					return false;
				}
			}));
		Collection resultSet = statement.execute();
		instance_Class1 = (org.eclipse.uml2.uml.Class) ((resultSet.isEmpty()) ? null
			: (EObject) resultSet.toArray()[0]);
		return instance_Class1;
	}

	private QueryStatement getElementNamedQuery(final String elementName) {
		return new SELECT(new FROM(getQueryObjects()), new WHERE(
			new EObjectCondition() {

				public boolean isSatisfied(EObject element) {
					if (element instanceof NamedElement) {
						if (elementName.equals(((NamedElement) element)
							.getName())) {
							return true;
						}
					}
					return false;
				}

				public boolean shouldPrune(EObject element) {
					return false;
				}
			}));
	}

	private Resource getResource() {
		if (resource == null) {
			resource = new ResourceImpl(URI.createURI("foo:///foo.xml")); //$NON-NLS-1$
			
			List contents = resource.getContents();
			
			Model m = UMLFactory.eINSTANCE.createModel();
			m.setName("Blank Model"); //$NON-NLS-1$
			contents.add(m);
			
			org.eclipse.uml2.uml.Package pkg = UMLFactory.eINSTANCE.createPackage();
			pkg.setName("contextFree"); //$NON-NLS-1$
			m.getPackagedElements().add(pkg);
			
			for (int i=0; i<5; i++) {
				org.eclipse.uml2.uml.Class cls = UMLFactory.eINSTANCE.createClass();
				cls.setName("Class"+(i+1)); //$NON-NLS-1$
				m.getPackagedElements().add(cls);
			}
			
			org.eclipse.uml2.uml.Class cls = UMLFactory.eINSTANCE.createClass();
			cls.setName("ClassFoo"); //$NON-NLS-1$
			Operation op = cls.createOwnedOperation("Operation1",null,null); //$NON-NLS-1$
			op.setIsUnique(true);
			Parameter p = op.createOwnedParameter("Parameter1",null); //$NON-NLS-1$
			p = op.createOwnedParameter("Parameter2",null); //$NON-NLS-1$
			op = cls.createOwnedOperation("Operation22",null,null); //$NON-NLS-1$
			m.getPackagedElements().add(cls);
			
			org.eclipse.uml2.uml.Interface i = UMLFactory.eINSTANCE.createInterface();
			i.setName("contextFree"); //$NON-NLS-1$
			Property prop = i.createOwnedAttribute("contextFree",null); //$NON-NLS-1$
			prop.setIsUnique(true);
			m.getPackagedElements().add(i);

		}
		return resource;
	}

	private Model getModel() {
		if (model == null) {
			model = (Model) (getResource().getContents().get(0));
		}
		return model;
	}

	private Collection getQueryObjects() {
		return modelElements;
	}
}