/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst.impl;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.helper.ConstraintKind;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;


public class EAnnotationOCLParserImpl implements EAnnotationOCLParser {


	public void convertOclAnnotation(EModelElement modelElement) {
		EAnnotation a = modelElement.getEAnnotation(ANNOTATION_SOURCE);
		if(a==null)
			return;
		for( Entry<String, String> detail: a.getDetails()){


			String e = detail.getValue();
			if(e ==null)
				return;
			ConstraintKind kind= null;
			OCL ocl = org.eclipse.ocl.ecore.OCL.newInstance();
			Helper helper = ocl.createOCLHelper();

			switch (modelElement.eClass().getClassifierID()){
			case EcorePackage.ECLASSIFIER:
			case EcorePackage.ECLASS:
			case EcorePackage.EDATA_TYPE:
				helper.setContext((EClassifier)modelElement);
				kind=ConstraintKind.INVARIANT;
				break;
			case EcorePackage.EATTRIBUTE:
				helper.setAttributeContext(((EAttribute)modelElement).getEContainingClass(), (EAttribute)modelElement);
				break;
			case EcorePackage.EOPERATION:
				kind=ConstraintKind.BODYCONDITION;
				helper.setOperationContext(((EOperation)modelElement).getEContainingClass(), (EOperation)modelElement);
				break;
			default:
				helper.setInstanceContext(modelElement);
				break;
			}
			Constraint c=null;
			try {
				c= helper.createConstraint(kind, e);
			} catch (ParserException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(c==null)
				return;

			a.getContents().add(c.getSpecification().getBodyExpression());

		}		
	}

} //EAnnotationOCLParserImpl
