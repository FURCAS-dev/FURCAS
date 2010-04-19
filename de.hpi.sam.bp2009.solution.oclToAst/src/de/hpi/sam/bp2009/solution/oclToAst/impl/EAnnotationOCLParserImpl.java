/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcorePackage;
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
	public void convertOclAnnotation(EModelElement modelElement) {
		exceptions= new ArrayList<Exception>();
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

} //EAnnotationOCLParserImpl
