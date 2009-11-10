package test2.handlers;

import java.io.IOException;
import java.util.Collections;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectInstanceCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferenceValueCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferencerCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OCL.Helper;

import usecase.Actor;
//import usecase.Association;
import usecase.Element;
//import usecase.Usecase;
import usecase.UsecaseDiagram;
import usecase.UsecasePackage;

public class SampleHandler2 extends AbstractHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// create Resource My.usecase in Resourceset 
		ResourceSet resourceset=new ResourceSetImpl();
		Resource resource = resourceset.createResource(URI.createPlatformResourceURI("/test/My.usecase", true));
		try {
			resource.load(Collections.emptyMap());//load platform of My.usecase, exception in case of empty map
		} catch (IOException e) {
			e.printStackTrace();
		}
		UsecaseDiagram usecasediagram=(UsecaseDiagram) resource.getContents().get(0);//save content of first element in list UsecaseDiagram  
		OCL ocl=OCL.newInstance();//start OCL
		Helper oclhelper=ocl.createOCLHelper();//start OCL helper to interpret constraints
		oclhelper.setContext(UsecasePackage.Literals.ACTOR);//to assign "self"
		
		for(Element ele:usecasediagram.getElements()){
			if(ele instanceof Actor){
				Actor actor=(Actor)ele;	
				String string ="self.outgoing->notEmpty()";
				try {
					OCLExpression oclexpression=oclhelper.createQuery(string);//create ocl constraint out of string 
					System.out.println(ocl.evaluate(actor, oclexpression));//evaluate constraint, then  
				} catch (ParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//IEStructuralFeatureValueGetter getter = EStructuralFeatureValueGetter.getInstance();
		
		EObjectCondition condition = new EObjectReferenceValueCondition( new EObjectTypeRelationCondition(UsecasePackage.Literals.USECASE), UsecasePackage.Literals.ELEMENT__DIAGRAM ,  new EObjectTypeRelationCondition(UsecasePackage.Literals.USECASE_DIAGRAM));
		SELECT select= new SELECT(new FROM(usecasediagram) ,new WHERE(condition) );//emf query ähnlich sql anfrage, condition im wurzelelement prüfen
		System.out.println(select.execute().size());//ausgabe auf der console
		return null;
		
	}

}
