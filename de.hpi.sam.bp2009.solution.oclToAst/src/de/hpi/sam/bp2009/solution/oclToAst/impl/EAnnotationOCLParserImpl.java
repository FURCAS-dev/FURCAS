/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.ErrorMessage;
import de.hpi.sam.bp2009.solution.scopeProvider.ProjectDependencyQueryContextProvider;

public class EAnnotationOCLParserImpl implements EAnnotationOCLParser {
    /**
     * Data container for all informations around an exception
     * @author Philipp
     *
     */
    private class ErrorMessageImpl implements ErrorMessage{
        private Exception e;
        private String m;
        private Object o;

        public ErrorMessageImpl(Exception exception, String message, Object object) {
            this.e=exception;
            this.m=message;
            this.o=object;
        }
        @Override
        public Object getAffectedObject() {
            return o;
        }

        @Override
        public Exception getException() {
            return e;			
        }

        @Override
        public String getMessageString() {
            return m;
        }

    }
    private List<ErrorMessage> messages = new ArrayList<ErrorMessage>();

    public static void main(String[] args) {
        String uri = "file://c:/Documents%20and%20Settings/D043530/emfmdrs-workspace/com.sap.mdrs.ecore/model/mdrs.ecore";

        if (args.length > 1)
            uri = args[1];
        EAnnotationOCLParser parser = new EAnnotationOCLParserImpl();
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
        Resource r =null;
        try {
            r = load_resourceSet.getResource(fileUri, true);
            EcoreHelper.getInstance().addResourceToDefaultIndex(r);

            r.load(null);
        } catch (Exception e) {
            e.printStackTrace();
            getAllOccurredErrorMessages().add(new ErrorMessageImpl(e, "Error during Resource load."+fileUri, r));
            return;
        }


        for(EObject sPkg: r.getContents()){
            if(sPkg instanceof EPackage){
                if(((EPackage)sPkg).getEAnnotation(OCL_TYPES)!=null){
                    ((EPackage)sPkg).getEAnnotation(OCL_TYPES).getContents().clear();
                }
                traversalConvertOclAnnotations((EPackage)sPkg);
            }
        }
        try {
            r.save(null);
        } catch (IOException e) {
            getAllOccurredErrorMessages().add(new ErrorMessageImpl(e, "Error during Resource save.", r));
        }
    }

    /* (non-Javadoc)
     * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#convertOclAnnotation(org.eclipse.emf.ecore.EModelElement)
     */
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
            /*
             * set correct context
             */
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
                getAllOccurredErrorMessages().add(new ErrorMessageImpl(e1, "Error during Query parsing", e));
            }

            if (expr == null)
                return;
            /*
             * Iterate the AST, search for OCL specific types, and add them to the resource of the EAnnotation
             */
            ResourceChanger rc= new ResourceChanger();
            expr.accept(rc);
            EPackage p = getRootPackage(modelElement);
            if(p != null){
                addOclTypesAnnotationToPackage(rc.getSet(), p);       			
            }else{
                getAllOccurredErrorMessages().add(new ErrorMessageImpl(new IllegalArgumentException(), "No Package as root element available", modelElement));
            }

            a.getContents().add(expr);

        }
    }

    /* (non-Javadoc)
     * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getAllOccurredErrorMessages()
     */
    @Override
    public Collection<ErrorMessage> getAllOccurredErrorMessages() {
        return messages;

    }

    /* (non-Javadoc)
     * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getExpressionFromAnnotationsOf(org.eclipse.emf.ecore.ENamedElement, java.lang.String)
     */
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

    /* (non-Javadoc)
     * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#traversalConvertOclAnnotations(org.eclipse.emf.ecore.EPackage)
     */
    @Override
    public void traversalConvertOclAnnotations(EPackage pkg) {
        getAllOccurredErrorMessages().clear();

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

    /**
     * Adds all given oclTypes to the oclTypes annotation of the given pacakge
     * @param hashSet all types to add
     * @param p the package to get the annotation
     */
    private void addOclTypesAnnotationToPackage(HashSet<EObject> hashSet, EPackage p) {
        EAnnotation annotation = p.getEAnnotation(OCL_TYPES);
        if(annotation ==null){
            annotation = EcoreFactory.eINSTANCE.createEAnnotation();
            annotation.setSource(OCL_TYPES);
        }else{
            hashSet.addAll(annotation.getContents());
            annotation.getContents().clear();
        }
        annotation.getContents().addAll(hashSet);

        p.getEAnnotations().add(annotation);
        /*
         * after resolving all names of BagTypes are set
         * due to a bug in the BagTypeImpl this is neccessary
         */
        for(EObject o: hashSet){
            EcoreUtil.getURI(o);
        }
    }
    /**
     * Calculates the root pacakge for a given element
     * @param modelElement get the root pacakge for this
     * @return the root package
     */
    private EPackage getRootPackage(EModelElement modelElement) {
        EPackage p = null;
        EObject current = modelElement;
        while(current!=null){
            if(current instanceof EPackage){
                p=(EPackage) current;
                break;
            }
            current=current.eContainer();
        }
        return p;
    }
} // EAnnotationOCLParserImpl
