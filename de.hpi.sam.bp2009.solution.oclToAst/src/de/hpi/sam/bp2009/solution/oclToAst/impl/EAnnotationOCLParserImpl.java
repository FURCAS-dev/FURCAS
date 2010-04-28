/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.Visitable;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.scopeProvider.ProjectDependencyQueryContextProvider;

public class EAnnotationOCLParserImpl implements EAnnotationOCLParser {
    private List<Exception> exceptions;

    public List<Exception> getExceptions() {
        return exceptions;
    }

    public static void main(String[] args) {
        String uri = "file://c:/Documents%20and%20Settings/D043530/emfmdrs-workspace/com.sap.mdrs.ecore/model/mdrs.ecore";

        if (args.length > 1)
            uri = args[1];
        EAnnotationOCLParserImpl parser = new EAnnotationOCLParserImpl();
        parser.convertAnnotations(URI.createURI(uri));

    }

	/**
	 * Loads the resource specified by the given uri with the default {@link EcoreResourceFactoryImpl}, parse all matching EAnnotations and saves the resource
	 * @param fileUri
	 */
	@Override
	public  void convertAnnotations(URI fileUri) {
		ResourceSet load_resourceSet = new ResourceSetImpl();

        /*
         * Register XML Factory implementation using DEFAULT_EXTENSION
         */
        load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new EcoreResourceFactoryImpl());
        /*
         * Load the resource using the URI
         */
        Resource r = load_resourceSet.getResource(fileUri, true);
        EcoreHelper.getInstance().addResourceToDefaultIndex(r);
        try {
            r.load(null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(r.getContents().get(0));
        /*
         * by convention is the first content of an *.ecore file one package
         */
        traversalConvertOclAnnotations((EPackage) r.getContents().get(0));
        System.err.println(getExceptions());
        try {
            r.save(null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

    public void convertOclAnnotation(EModelElement modelElement) {
        EAnnotation a = modelElement.getEAnnotation(ANNOTATION_SOURCE);
        if (a == null)
            return;
        a.getContents().clear();
        for (Entry<String, String> detail : a.getDetails()) {
            String e = detail.getValue();
            if (e == null)
                return;
            OCL ocl = org.eclipse.ocl.ecore.OCL.newInstance();
            new ProjectDependencyQueryContextProvider().apply(ocl);
            Helper helper = ocl.createOCLHelper();

            switch (modelElement.eClass().getClassifierID()) {
            case EcorePackage.ECLASSIFIER:
            case EcorePackage.ECLASS:
            case EcorePackage.EDATA_TYPE:
                helper.setContext((EClassifier) modelElement);
                break;
            case EcorePackage.EATTRIBUTE:
                helper.setAttributeContext(((EAttribute) modelElement).getEContainingClass(), (EAttribute) modelElement);
                break;
            case EcorePackage.EOPERATION:
                helper.setOperationContext(((EOperation) modelElement).getEContainingClass(), (EOperation) modelElement);
                break;
            default:
                helper.setInstanceContext(modelElement);
                break;
            }

            OCLExpression expr = null;
            try {
                expr = helper.createQuery(e);
            } catch (ParserException e1) {
                exceptions.add(e1);
            }

            if (expr == null)
                return;
            /*
             * Iterate the AST, search for OCL specific types, and add them to the resource of the EAnnotation
             */
//            ResourceChanger rc= new ResourceChanger();
//            expr.accept(rc);
//            a.eResource().getContents().addAll(rc.getSet());
            
            a.getContents().add(expr);

        }
    }

    public OCLExpression getExpressionFromAnnotationsOf(ENamedElement element, String constraintName) {
        OCLExpression query = null;
        EAnnotation anno = element.getEAnnotation(EAnnotationOCLParser.ANNOTATION_SOURCE);
        if (anno == null) {
            return null;
        }
        int pos = -1;
        int count = 0;
        for (String constraint1 : anno.getDetails().keySet()) {
            if (constraint1.equals(constraintName)) {
                pos = count;
                break;
            }
            count++;
        }
        if (pos != -1) {
            if (anno.getContents().size() > pos) {
                query = (OCLExpression) anno.getContents().get(pos);
            }
        }
        if (query == null) {
        	// we know the annotation exists, but it seems the OCLExpression is not present in the contents:
        	convertOclAnnotation(element);
        	query = getExpressionFromAnnotationsOf(element, constraintName); // try again
        }
        return query;
    }

	@Override
    public void traversalConvertOclAnnotations(EPackage pkg) {
        exceptions = new ArrayList<Exception>();

        for (EClassifier cls : pkg.getEClassifiers()) {
            convertOclAnnotation(cls);
            if (cls instanceof EClass) {
                for (EOperation op : ((EClass) cls).getEOperations())
                    convertOclAnnotation(op);
                for (EAttribute at : ((EClass) cls).getEAttributes())
                    convertOclAnnotation(at);
            }
        }

        for (EPackage p : pkg.getESubpackages())
            traversalConvertOclAnnotations(p);

    }
    private class ResourceChanger extends AbstractVisitor<EPackage, EClassifier, EOperation, EStructuralFeature,
	EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> {
		/* (non-Javadoc)
		 * @see org.eclipse.ocl.utilities.AbstractVisitor#handleOperationCallExp(org.eclipse.ocl.expressions.OperationCallExp, java.lang.Object, java.util.List)
		 */
		@Override
		protected EPackage handleOperationCallExp(
				OperationCallExp<EClassifier, EOperation> callExp,
				EPackage sourceResult, List<EPackage> argumentResults) {
			EClassifier typ= callExp.getType();
			handle(typ);
			return super.handleOperationCallExp(callExp, sourceResult, argumentResults);
			
		}
		private void handle(EObject typ) {
			if(typ!=null && typ.eResource()!=null && typ.eResource().getURI()!=null){
				URI uri= typ.eResource().getURI();
				System.err.println(uri);
				System.err.println(typ.eResource().getContents());
				if( uri.equals(URI.createURI("ocl:///oclenv.ecore"))){
					set.add(typ);
				 System.out.println("Alert: " + typ);
				}
			}
		}
		/* (non-Javadoc)
		 * @see org.eclipse.ocl.utilities.AbstractVisitor#handlePropertyCallExp(org.eclipse.ocl.expressions.PropertyCallExp, java.lang.Object, java.util.List)
		 */
		@Override
		protected EPackage handlePropertyCallExp(
				PropertyCallExp<EClassifier, EStructuralFeature> callExp,
				EPackage sourceResult, List<EPackage> qualifierResults) {
			handle(callExp.getType());
			return super.handlePropertyCallExp(callExp, sourceResult, qualifierResults);
			
		}
		/* (non-Javadoc)
		 * @see org.eclipse.ocl.utilities.AbstractVisitor#handleAssociationClassCallExp(org.eclipse.ocl.expressions.AssociationClassCallExp, java.lang.Object, java.util.List)
		 */
		@Override
		protected EPackage handleAssociationClassCallExp(
				AssociationClassCallExp<EClassifier, EStructuralFeature> callExp,
				EPackage sourceResult, List<EPackage> qualifierResults) {
			handle(callExp.getType());
			return super.handleAssociationClassCallExp(callExp, sourceResult,
					qualifierResults);
			
		}
		/* (non-Javadoc)
		 * @see org.eclipse.ocl.utilities.AbstractVisitor#handleVariable(org.eclipse.ocl.expressions.Variable, java.lang.Object)
		 */
		@Override
		protected EPackage handleVariable(
				Variable<EClassifier, EParameter> variable, EPackage initResult) {
			handle(variable.getType());
			handle(variable);
			return super.handleVariable(variable, initResult);
			
		}
		@Override
		public EPackage visitVariableExp(VariableExp<EClassifier, EParameter> v) {
			System.out.println(v);
			v.getReferredVariable().accept(this);
			return super.visitVariableExp(v);
			
		}
		/* (non-Javadoc)
		 * @see org.eclipse.ocl.utilities.AbstractVisitor#handleIfExp(org.eclipse.ocl.expressions.IfExp, java.lang.Object, java.lang.Object, java.lang.Object)
		 */
		@Override
		protected EPackage handleIfExp(IfExp<EClassifier> ifExp,
				EPackage conditionResult, EPackage thenResult,
				EPackage elseResult) {
			handle(ifExp.getType());

			return super.handleIfExp(ifExp, conditionResult, thenResult, elseResult);
			
		}
		/* (non-Javadoc)
		 * @see org.eclipse.ocl.utilities.AbstractVisitor#handleMessageExp(org.eclipse.ocl.expressions.MessageExp, java.lang.Object, java.util.List)
		 */
		@Override
		protected EPackage handleMessageExp(
				MessageExp<EClassifier, CallOperationAction, SendSignalAction> messageExp,
				EPackage targetResult, List<EPackage> argumentResults) {
			handle(messageExp.getType());

			return super.handleMessageExp(messageExp, targetResult, argumentResults);
			
		}
		/* (non-Javadoc)
		 * @see org.eclipse.ocl.utilities.AbstractVisitor#handleTupleLiteralExp(org.eclipse.ocl.expressions.TupleLiteralExp, java.util.List)
		 */
		@Override
		protected EPackage handleTupleLiteralExp(
				TupleLiteralExp<EClassifier, EStructuralFeature> literalExp,
				List<EPackage> partResults) {
			handle(literalExp.getType());

			return super.handleTupleLiteralExp(literalExp, partResults);
			
		}
		/* (non-Javadoc)
		 * @see org.eclipse.ocl.utilities.AbstractVisitor#handleTupleLiteralPart(org.eclipse.ocl.expressions.TupleLiteralPart, java.lang.Object)
		 */
		@Override
		protected EPackage handleTupleLiteralPart(
				TupleLiteralPart<EClassifier, EStructuralFeature> part,
				EPackage valueResult) {
			handle(part.getType());

			return super.handleTupleLiteralPart(part, valueResult);
			
		}
		/* (non-Javadoc)
		 * @see org.eclipse.ocl.utilities.AbstractVisitor#handleLetExp(org.eclipse.ocl.expressions.LetExp, java.lang.Object, java.lang.Object)
		 */
		@Override
		protected EPackage handleLetExp(LetExp<EClassifier, EParameter> letExp,
				EPackage variableResult, EPackage inResult) {
			handle(letExp.getType());

			return super.handleLetExp(letExp, variableResult, inResult);
			
		}
		/* (non-Javadoc)
		 * @see org.eclipse.ocl.utilities.AbstractVisitor#handleCollectionLiteralExp(org.eclipse.ocl.expressions.CollectionLiteralExp, java.util.List)
		 */
		@Override
		protected EPackage handleCollectionLiteralExp(
				CollectionLiteralExp<EClassifier> literalExp,
				List<EPackage> partResults) {
			handle(literalExp.getType());

			return super.handleCollectionLiteralExp(literalExp, partResults);
			
		}
		/* (non-Javadoc)
		 * @see org.eclipse.ocl.utilities.AbstractVisitor#handleCollectionItem(org.eclipse.ocl.expressions.CollectionItem, java.lang.Object)
		 */
		@Override
		protected EPackage handleCollectionItem(
				CollectionItem<EClassifier> item, EPackage itemResult) {
			handle(item.getType());

			return super.handleCollectionItem(item, itemResult);
			
		}
		/* (non-Javadoc)
		 * @see org.eclipse.ocl.utilities.AbstractVisitor#handleCollectionRange(org.eclipse.ocl.expressions.CollectionRange, java.lang.Object, java.lang.Object)
		 */
		@Override
		protected EPackage handleCollectionRange(
				CollectionRange<EClassifier> range, EPackage firstResult,
				EPackage lastResult) {
			handle(range.getType());

			return super.handleCollectionRange(range, firstResult, lastResult);
			
		}
		/* (non-Javadoc)
		 * @see org.eclipse.ocl.utilities.AbstractVisitor#handleIteratorExp(org.eclipse.ocl.expressions.IteratorExp, java.lang.Object, java.util.List, java.lang.Object)
		 */
		@Override
		protected EPackage handleIteratorExp(
				IteratorExp<EClassifier, EParameter> callExp,
				EPackage sourceResult, List<EPackage> variableResults,
				EPackage bodyResult) {
			handle(callExp.getType());

			return super.handleIteratorExp(callExp, sourceResult, variableResults,
					bodyResult);
			
		}
		/* (non-Javadoc)
		 * @see org.eclipse.ocl.utilities.AbstractVisitor#handleIterateExp(org.eclipse.ocl.expressions.IterateExp, java.lang.Object, java.util.List, java.lang.Object, java.lang.Object)
		 */
		@Override
		protected EPackage handleIterateExp(
				IterateExp<EClassifier, EParameter> callExp,
				EPackage sourceResult, List<EPackage> variableResults,
				EPackage resultResult, EPackage bodyResult) {
			handle(callExp.getType());

			return super.handleIterateExp(callExp, sourceResult, variableResults,
					resultResult, bodyResult);
			
		}
		private HashSet<EObject> set;
		public ResourceChanger() {
			this.set = new HashSet<EObject>();
		}
		/* (non-Javadoc)
		 * @see org.eclipse.ocl.utilities.AbstractVisitor#safeVisit(org.eclipse.ocl.utilities.Visitable)
		 */
		@Override
		protected EPackage safeVisit(Visitable v) {
			return super.safeVisit(v);
		}
		public HashSet<EObject> getSet() {
			return set;
		}
    	
    }

} // EAnnotationOCLParserImpl
