/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;


public class EAnnotationOCLParserImpl implements EAnnotationOCLParser {
	private List<Exception> exceptions;
	public List<Exception> getExceptions(){
		return exceptions;
	}
	public static void main(String[] args) {
		String uri="file://c:/eclipse/workspace/de.hpi.sam.petriNet/model/petriNet.ecore";

		if(args.length>1)
			uri=args[1];
        ResourceSet load_resourceSet = new ResourceSetImpl();

        /*
         * Register XML Factory implementation using DEFAULT_EXTENSION
         */
        load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new EcoreResourceFactoryImpl());
        /*
         * Load the resource using the URI
         */
        Resource r = load_resourceSet.getResource(URI.createURI(uri), true);
        try {
			r.load(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(r.getContents().get(0));
		new EAnnotationOCLParserImpl().traversalConvertOclAnnotations((EPackage) r.getContents().get(0));
		try {
			r.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	public void convertOclAnnotation(EModelElement modelElement) {
		EAnnotation a = modelElement.getEAnnotation(ANNOTATION_SOURCE);
		if(a==null)
			return;
		for( Entry<String, String> detail: a.getDetails()){
			String e = detail.getValue();
			if(e ==null)
				return;
			OCL ocl = org.eclipse.ocl.ecore.OCL.newInstance();
			Helper helper = ocl.createOCLHelper();

			switch (modelElement.eClass().getClassifierID()){
			case EcorePackage.ECLASSIFIER:
			case EcorePackage.ECLASS:
			case EcorePackage.EDATA_TYPE:
				helper.setContext((EClassifier)modelElement);
				break;
			case EcorePackage.EATTRIBUTE:
				helper.setAttributeContext(((EAttribute)modelElement).getEContainingClass(), (EAttribute)modelElement);
				break;
			case EcorePackage.EOPERATION:
				helper.setOperationContext(((EOperation)modelElement).getEContainingClass(), (EOperation)modelElement);
				break;
			default:
				helper.setInstanceContext(modelElement);
				break;
			}
		
			OCLExpression expr=null;
			try {
				expr = helper.createQuery(e);
			} catch (ParserException e1) {
				exceptions.add(e1);
			}

			if(expr==null)
				return;

			a.getContents().add(expr);

		}		
	}
	public OCLExpression getExpressionFromAnnotationsOf(ENamedElement element,
			String constraintName) {
		OCLExpression query = null;
		EAnnotation anno=element.getEAnnotation(EAnnotationOCLParser.ANNOTATION_SOURCE);
		if(anno==null)
			return null;
		int pos=-1;
		int count=0;
		for(String constraint1:anno.getDetails().values()){
			if(constraint1.equals(constraintName)){
				pos=count;
				break;
			}
			count++;
		}
		if(pos!=-1)
			if(anno.eContents().size()>pos)
				query= (OCLExpression)anno.eContents().get(pos);

		return query;
	}
	@Override
	public void traversalConvertOclAnnotations(EPackage pkg) {
		exceptions = new ArrayList<Exception>();
		
		for(EClassifier cls:pkg.getEClassifiers()){
			convertOclAnnotation(cls);
			if(cls instanceof EClass){
				for(EOperation op:((EClass)cls).getEOperations())
					convertOclAnnotation(op);
				for(EAttribute at: ((EClass)cls).getEAttributes())
					convertOclAnnotation(at);
			}
		}
		
		for(EPackage p:pkg.getESubpackages())
			traversalConvertOclAnnotations(p);
	
	}

} //EAnnotationOCLParserImpl
