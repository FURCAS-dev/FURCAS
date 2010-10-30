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
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.utilities.UMLReflection;

import com.sap.emf.ocl.hiddenopposites.EcoreEnvironmentFactoryWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.ErrorMessage;
import de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl.ProjectDependencyQueryContextProvider;
import de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl;

/**
 * The {@link OCL} object created and used by this annotations parser is constructed with an {@link OclAstEcoreEnvironmentFactory}
 * as environment factory, using a {@link ProjectDependencyQueryContextProvider} as query context provider.
 */
public class EAnnotationOCLParserImpl implements EAnnotationOCLParser {
    private ResourceChanger rc= new ResourceChanger();

    private List<ErrorMessage> messages = new ArrayList<ErrorMessage>();
    private ResourceSet resourceSet = new ResourceSetImpl();
    private EPackage.Registry registry = EPackage.Registry.INSTANCE;

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

    /* (non-Javadoc)
     * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#convertOclAnnotation(org.eclipse.emf.ecore.EModelElement)
     */
    public void convertOclAnnotation(EModelElement modelElement) {
//      // to convert generated annotations with 'old' uri into annotations with standard uri
//      EAnnotation anno = modelElement.getEAnnotation("http://de.hpi.sam.bp2009.OCL");
//      if (anno != null){
//          anno.setSource(OCLDelegateDomain.OCL_DELEGATE_URI);
//          anno.getContents().clear();
//      }
//
        EAnnotation textAnno = modelElement.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
        if (textAnno == null)
            return;
        EAnnotation astAnno = modelElement.getEAnnotation(Environment.OCL_NAMESPACE_URI);
        if (astAnno == null){
            astAnno = EcoreFactory.eINSTANCE.createEAnnotation();
            astAnno.setSource(Environment.OCL_NAMESPACE_URI);
            modelElement.getEAnnotations().add(astAnno);
        }      
        else{ 
            //remove old ast           
            astAnno.getContents().clear();          
//          EcoreUtil.remove(astAnno);
//            return;
        }
        for (Entry<String, String> detail : textAnno.getDetails()) {
            String e = detail.getValue();
            if (e == null)
                return;
            // TODO can the following lines be pulled out of the loop? This may speed things up a little
            OCL ocl = OCLWithHiddenOpposites.newInstance(new EcoreEnvironmentFactoryWithHiddenOpposites(this.getRegistry(),
                    new Query2OppositeEndFinder(new ProjectDependencyQueryContextProvider())));
            Helper helper = ocl.createOCLHelper();
            EOperation op = null;
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
                EAttribute at = (EAttribute) modelElement;
                helper.setAttributeContext(at.getEContainingClass(), at);      
                break;
            case EcorePackage.EOPERATION:
                op = (EOperation)modelElement;
                helper.setOperationContext(op.getEContainingClass(), op);  
                break;
            default:
                helper.setInstanceContext(modelElement);
                break;
            }
            Constraint expr = null;
            try { 
                String typ = detail.getKey();
                if(UMLReflection.DERIVATION.equals(typ)){
                    expr = helper.createDerivedValueExpression(e);
                }else if (UMLReflection.INITIAL.equals(typ)){
                    expr = helper.createInitialValueExpression(e);
                }else if (UMLReflection.BODY.equals(typ)){
                    //necessary because of class cast exceptions while validating hidden opposites
                    helper.setValidating(false);
                    expr = helper.createConstraint(ConstraintKind.BODYCONDITION, e);
                    if (op != null){
                        helper.getEnvironment().setBodyCondition(op, expr);
                    }
                }else if (UMLReflection.POSTCONDITION.equals(typ)){
                    expr = helper.createPostcondition(e);
                }else if (UMLReflection.PRECONDITION.equals(typ)){
                    expr = helper.createPrecondition(e);            
                }else if (UMLReflection.DEFINITION.equals(typ)){
                    expr = helper.createConstraint(ConstraintKind.DEFINITION, e);
                }else /*as default value, an invariant is expected*/{                    
                    expr = helper.createInvariant(e);
                    expr.setName(typ);
                }
            } catch (ParserException e1) {
                // TODO use Eclipse logging!
                parserExceptionHandling(modelElement, e, e1);
            }

            if (expr == null)
                return;

            astAnno.getContents().add(expr);

            /*
             * Iterate the AST, search for OCL specific types, and add them to the resource of the EAnnotation
             */
            expr.getSpecification().getBodyExpression().accept(rc);
            EPackage p = getRootPackage(modelElement);
            if(p != null){
                addOclTypesAnnotationToPackage(rc.getSet(), p);                         
            }else{
                getAllOccurredErrorMessages().add(new ErrorMessageImpl(new IllegalArgumentException(), "No Package as root element available", modelElement));
            }
        }
    }

    private void parserExceptionHandling(EModelElement modelElement, String e, ParserException e1) {
        System.err.println("On element "+getQualifiedName(modelElement)+" "+modelElement+":\n" + e + "\n" + e1.getMessage());
        if (e1.getDiagnostic() != null) {
            for (Diagnostic c : e1.getDiagnostic().getChildren()) {
                System.err.println(c.getMessage());
            }
        }
        getAllOccurredErrorMessages().add(new ErrorMessageImpl(e1, "Error during Query parsing", e));
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
     * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#traversalConvertOclAnnotations(org.eclipse.emf.ecore.EPackage)
     */
    @Override
    public void traversalConvertOclAnnotations(EPackage pkg) {
//      // to convert annotations with 'old' uri into annotations with new uri
//      EAnnotation anno = pkg.getEAnnotation("http://www.eclipse.org/emf/2002/Ecore");
//      if (anno != null){
//          for (Entry<String, String>  entry: anno.getDetails()){
//              entry.setValue(OCLDelegateDomain.OCL_DELEGATE_URI);
//          }
//      }
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
//          EcoreUtil.remove(annotation);
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
