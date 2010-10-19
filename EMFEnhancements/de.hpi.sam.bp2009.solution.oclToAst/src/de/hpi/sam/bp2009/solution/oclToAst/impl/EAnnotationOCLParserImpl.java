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
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.Diagnostic;
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
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.ErrorMessage;
import de.hpi.sam.bp2009.solution.oclToAst.delegate.OclAstEcoreEnvironmentFactory;
import de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl.ProjectDependencyQueryContextProvider;
import de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl;

/**
 * The {@link OCL} object created and used by this annotations parser is constructed with an {@link OclAstEcoreEnvironmentFactory}
 * as environment factory, using a {@link ProjectDependencyQueryContextProvider} as query context provider.
 */
public class EAnnotationOCLParserImpl implements EAnnotationOCLParser {
    ResourceChanger rc= new ResourceChanger();

    /**
     * Data container for all informations around an exception
     * @author Philipp
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
    private ResourceSet resourceSet = new ResourceSetImpl();
    private EPackage.Registry registry = EPackage.Registry.INSTANCE;

    public static void main(String[] args) {
        String uri = "file://c:/Documents%20and%20Settings/D043530/emfmdrs-workspace/com.sap.mdrs.ecore/model/mdrs.ecore";

        if (args.length > 1)
            uri = args[1];
        EAnnotationOCLParser parser = new EAnnotationOCLParserImpl();
        parser.convertAnnotations(URI.createURI(uri));

    }


    /**
     * Loads the resource specified by the given uri with the default {@link EcoreResourceFactoryImpl}, parse all matching EAnnotations and saves the resource
     * It will be created only one resource set for all loaded resources
     * @param fileUri
     */
    @Override
    public  void convertAnnotations(URI fileUri) {
        /*
         * Load the resource using the URI
         * Factory get inferred by the ResourceFactoryRegistry
         */
        Resource r =null;
        try {
            r = resourceSet.getResource(fileUri, true);
            EcoreHelper.getInstance().addResourceToDefaultIndex(IndexFactory.getInstance(), r);
            r.load(null);
        } catch (Exception e) {
            e.printStackTrace();
            getAllOccurredErrorMessages().add(new ErrorMessageImpl(e, "Error during Resource load."+fileUri, r));
            return;
        }
        Collection<EPackage> saltPackages = new HashSet<EPackage>();
        /*
         * collect all EPackages inScope
         */
        ProjectBasedScopeProviderImpl scopi = new ProjectBasedScopeProviderImpl(r);
        for(EObject o: scopi.getForwardScopeAsEObjects()){
            if(o instanceof EPackage){
                saltPackages.add((EPackage) o);
                }
        }
        for(EObject o: scopi.getBackwardScopeAsEObjects()){
            if(o instanceof EPackage){
                saltPackages.add((EPackage) o);
                }
        }
        this.setRegistry(new OclAstRegistry(EPackage.Registry.INSTANCE, saltPackages ));
        /*
         * enable lookups from the resource set
         */
        resourceSet.setPackageRegistry(this.getRegistry());
        
        for(EObject sPkg: r.getContents()){
          if (sPkg instanceof EPackage) {
            handlePackage(fileUri, (EPackage) sPkg);
          }
        }
    }


//    private void lookupPackageInRegistryAndHandleOrRecurse(URI fileUri, EPackage sPkg)
//    {
//          if(EPackage.Registry.INSTANCE.containsKey(sPkg.getNsURI())){
//               handlePackage(fileUri, sPkg);
//          } else {
//            System.err.println("Couldn't find package "+((EPackage) sPkg).getName()+" with nsURI "+((EPackage) sPkg).getNsURI()+
//              " in registry. Maybe empty top-level package?");
//            recursivelySearchForSubpackagesInRegistry(fileUri, sPkg);
//          }
//    }


    private void handlePackage(URI fileUri, EObject sPkg)
    {       /*
        * change the current resource to the ecore from the loaded packages
        */
       Resource rs = sPkg.eResource();
       if(((EPackage)sPkg).getEAnnotation(OCL_TYPES)!=null){
         ((EPackage)sPkg).getEAnnotation(OCL_TYPES).getContents().clear();
       }
       System.out.println("Converting package "+((EPackage) sPkg).getName()+" with nsURI "+((EPackage) sPkg).getNsURI());
       traversalConvertOclAnnotations((EPackage)sPkg);
       try {
           rs.save(null);
       } catch (IOException e) {
         getAllOccurredErrorMessages().add(new ErrorMessageImpl(e, "Error during Resource save.", sPkg));
       }
    }

//    private void recursivelySearchForSubpackagesInRegistry(URI fileUri, EObject sPkg)
//    {
//      for (EObject content : sPkg.eContents()) {
//        if (content instanceof EPackage) {
//          lookupPackageInRegistryAndHandleOrRecurse(fileUri, (EPackage) content);
//        }
//      }
//    }


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
            // TODO can the following lines be pulled out of the loop? This may speed things up a little
            OCL ocl = OCLWithHiddenOpposites.newInstance(new OclAstEcoreEnvironmentFactory(this.getRegistry(),
                    new Query2OppositeEndFinder(new de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl.ProjectDependencyQueryContextProvider())));
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
                // TODO use Eclipse logging!
              System.err.println("On element "+getQualifiedName(modelElement)+" "+modelElement+":\n" + e + "\n" + e1.getMessage());
              if (e1.getDiagnostic() != null) {
                for (Diagnostic c : e1.getDiagnostic().getChildren()) {
                  System.err.println(c.getMessage());
                }
              }
              getAllOccurredErrorMessages().add(new ErrorMessageImpl(e1, "Error during Query parsing", e));
            }

            if (expr == null)
                return;
                
            a.getContents().add(expr);
            
            /*
             * Iterate the AST, search for OCL specific types, and add them to the resource of the EAnnotation
             */
            expr.accept(rc);
            EPackage p = getRootPackage(modelElement);
            if(p != null){
                addOclTypesAnnotationToPackage(rc.getSet(), p);       			
            }else{
                getAllOccurredErrorMessages().add(new ErrorMessageImpl(new IllegalArgumentException(), "No Package as root element available", modelElement));
            }


        }
    }

    private String getQualifiedName(EObject modelElement) {
        StringBuilder result = new StringBuilder();
        if (modelElement instanceof ENamedElement) {
          result.append(((ENamedElement) modelElement).getName());
          if (modelElement.eContainer() != null) {
            result.insert(0, '.');
            result.insert(0, getQualifiedName(modelElement.eContainer()));
          }
        }
        return result.toString();
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
        EAnnotation annoTest = element.getEAnnotation(EAnnotationOCLParser.ANNOTATION_SOURCE);
        if (annoTest == null) {
            return null;
        }
        
        query = getExpressionFromAnnotation(element, constraintName);
        if (query == null) {
            // we know the annotation exists, but it seems the OCLExpression is not present in the contents:
            convertOclAnnotation(element);
            query = getExpressionFromAnnotation(element, constraintName); // try again
        }
        return query;
    }


	private OCLExpression getExpressionFromAnnotation(ENamedElement element,
			String constraintName) {
		OCLExpression query = null;
		EAnnotation anno = element.getEAnnotation(EAnnotationOCLParser.ANNOTATION_SOURCE);

        int pos = -1;
        int count = 0;
        for (Map.Entry<String, String> constraint1 : anno.getDetails()) {
            if (constraint1.getKey().equals(constraintName)) {
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
		return query;
	}

    /* (non-Javadoc)
     * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#traversalConvertOclAnnotations(org.eclipse.emf.ecore.EPackage)
     */
    @Override
    public void traversalConvertOclAnnotations(EPackage pkg) {

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
     * Adds all given oclTypes to the oclTypes annotation of the given package
     * @param collection all types to add
     * @param p the package to get the annotation
     */
    private void addOclTypesAnnotationToPackage(Collection<EObject> col, EPackage p) {
        Collection<EObject> collection = new HashSet<EObject>(col);
        EAnnotation annotation = p.getEAnnotation(OCL_TYPES);
        if(annotation ==null){
            annotation = EcoreFactory.eINSTANCE.createEAnnotation();
            annotation.setSource(OCL_TYPES);
        }else{
            collection.addAll(annotation.getContents());
            annotation.getContents().clear();
        }
        annotation.getContents().addAll(collection);

        p.getEAnnotations().add(annotation);
        /*
         * after resolving, all names of BagTypes are set
         * due to a bug in the BagTypeImpl this is necessary
         */
        for(EObject o: collection){
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


    private void setRegistry(EPackage.Registry registry) {
        this.registry = registry;
    }


    private EPackage.Registry getRegistry() {
        return registry;
    }
} // EAnnotationOCLParserImpl
