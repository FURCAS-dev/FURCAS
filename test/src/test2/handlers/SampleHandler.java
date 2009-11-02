package test2.handlers;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.numbers.NumberCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OCL.Helper;

import vortrag.Container;
import vortrag.Person;
import vortrag.VortragPackage;

public class SampleHandler extends AbstractHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// erstellt Resource My1.vortrag im Resourcenset 
		ResourceSet rs=new ResourceSetImpl();
		Resource r = rs.createResource(URI.createPlatformResourceURI("/test/My1.vortrag", true));
		try {
			r.load(Collections.emptyMap());//laden der Plattform von My1.vortrag, wenn Map leer -> exception
		} catch (IOException e) {
			e.printStackTrace();
		}
		Container container=(Container) r.getContents().get(0);//speicher Inhalt des ersten Elements der Liste Container 
		Person person=container.getPerson().get(0);//speichert Inhalt des ersten Elements der Liste Person
		OCL ocl=OCL.newInstance();//starte OCL
		Helper oclhelper=ocl.createOCLHelper();//starte OCL helper um Ausdrücke auswerten zu können
		oclhelper.setContext(VortragPackage.Literals.PERSON);//um self zuordnen zu können
		
		String string ="self.alter>=0"; //constraint
		try {
			OCLExpression oclexpression=oclhelper.createQuery(string);//erstellt aus dem string ein ocl constraint
			System.out.println(ocl.evaluate(person, oclexpression));//evaluate wertet constraint aus, ausgabe
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//emf query gibt anzahl der personen mit alter 1
		//bedingung für attributwert
		EObjectCondition condition=new EObjectAttributeValueCondition(VortragPackage.Literals.PERSON__ALTER, new NumberCondition<Integer>(1));
		SELECT select= new SELECT(new FROM(container) ,new WHERE(condition) );//emf query ähnlich sql anfrage, condition im wurzelelement prüfen
		System.out.println(select.execute().size());//ausgabe auf der console
		return null;
	}

}
