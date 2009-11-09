package test2.handlers;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
//import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
		//Element element=usecasediagram.getElements().get(0);//save content of first element in list Element
		OCL ocl=OCL.newInstance();//starte OCL
		Helper oclhelper=ocl.createOCLHelper();//starte OCL helper um Ausdrücke auswerten zu können
		oclhelper.setContext(UsecasePackage.Literals.ACTOR);//um self zuordnen zu können
		
		for(Element ele:usecasediagram.getElements()){
			if(ele instanceof Actor){
				Actor actor=(Actor)ele;	
				String string ="self.outgoing->notEmpty()";
				try {
					OCLExpression oclexpression=oclhelper.createQuery(string);//erstellt aus dem string ein ocl constraint
					System.out.println(ocl.evaluate(actor, oclexpression));//evaluate wertet constraint aus, ausgabe
				} catch (ParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
		return null;
		
	}

}
