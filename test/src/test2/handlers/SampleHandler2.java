package test2.handlers;

import java.io.IOException;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferenceValueCondition;
import org.eclipse.emf.query.internal.statements.QueryClause;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OCL.Helper;

import usecase.Actor;
import usecase.Element;
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
		/*UsecaseDiagram usecasediagram=(UsecaseDiagram) resource.getContents().get(0);//save content of first element in list UsecaseDiagram  
		OCL ocl=OCL.newInstance();//start OCL
		Helper oclhelper=ocl.createOCLHelper();//start OCL helper to interpret constraints
		oclhelper.setContext(UsecasePackage.Literals.ACTOR);
		oclhelper.setContext(UsecasePackage.Literals.ACTOR);
		
		for(Element ele:usecasediagram.getElements()){
			if(ele instanceof Actor){
				Actor actor=(Actor)ele;	
				String string ="self.outgoing->notEmpty()";
				try {
					OCLExpression oclexpression=oclhelper.createQuery(string);//create ocl constraint out of string 
					System.out.println("OCL : "+ocl.evaluate(actor, oclexpression));//evaluate constraint, then  
				} catch (ParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}*/
		
		try{
		String completeQuery=		"context UsecaseDiagram inv: self.elements->size()=2"; //leerzeichen vor UsecaseDiagram fixen, element nicht korrekt?
		String regex="context([\\w\\W]*)? inv";//try for match: use the beginning-of-input and end-of-input anchors: ^ and $. 
		Pattern pattern=Pattern.compile(regex);
		Matcher match=pattern.matcher(completeQuery);
		String queryContext="";
		if(match.find()){
			queryContext=match.group(1);
		}
		queryContext=queryContext.trim();
		String queryInvariant=completeQuery.substring(completeQuery.indexOf("inv:")+4);
		queryInvariant=queryInvariant.trim();
		IQueryResult results=null;
		EClassifier context=UsecasePackage.eINSTANCE.getEClassifier(queryContext);
		try {
			results = validateOclQuery(context.eClass(), queryInvariant, resource);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("oclEMFResult : "+results.size());
		}catch(Exception e){
			e.printStackTrace();
		}
			
		/*EObjectCondition condition1 = new EObjectReferenceValueCondition( new EObjectTypeRelationCondition(UsecasePackage.Literals.USECASE), UsecasePackage.Literals.ELEMENT__DIAGRAM ,  new EObjectTypeRelationCondition(UsecasePackage.Literals.USECASE_DIAGRAM));
		SELECT select= new SELECT(new FROM(usecasediagram) ,new WHERE(condition1) );//emf query ähnlich sql anfrage, condition im wurzelelement prüfen
		System.out.println("PUREEMF : "+select.execute().size());//ausgabe auf der console*/
		return null;
		
	}
	public IQueryResult validateOclQuery(EClass context, String query, Resource resource) throws ParserException{
		OCL ocl=OCL.newInstance();
		Condition condition=null;
			condition = new org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition<EClassifier, EClass, EObject>(
				    ocl.getEnvironment(),
				    query,
				    context);
		SELECT statement = new SELECT(SELECT.UNBOUNDED, false,
				new FROM(resource.getContents()), new WHERE((EObjectCondition) condition));

		return statement.execute();
	}

}
