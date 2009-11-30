/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package xmlresultprocessor.impl;

import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import de.hpi.sam.bp2009.benchframework.BenchMarker;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.impl.ResultProcessorImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import xmlresultprocessor.XMLResultProcessor;
import xmlresultprocessor.XmlresultprocessorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XML Result Processor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class XMLResultProcessorImpl extends ResultProcessorImpl implements XMLResultProcessor {
	private static final String RUNID="run";
	private static final String BENCHMARKERID="benchmarker";
	private static final String NAMEID="name";
	private static final String OPTIONID="option";
	private static final String RESULTID="results";
	private static final String RESULTELEMENTID="result";
	private static final String GENERATOROPTIONID="generatorOptions";
	private static final String OPERATOROPTIONID="operatorOptions";
	Document document=null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLResultProcessorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmlresultprocessorPackage.Literals.XML_RESULT_PROCESSOR;
	}
	@Override
	public boolean addRun(Resource resource, OptionObject generatorOption,
			OptionObject operatorOption, BenchMarker benchmarker) {
		
		try {
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(document == null)
			return false;
		
		Element em = document.createElement(RUNID);
		em.appendChild(generatePropertyMap(GENERATOROPTIONID,OPTIONID, generatorOption.getPropertyMap()));
		em.appendChild(generatePropertyMap(OPERATOROPTIONID,OPTIONID, operatorOption.getPropertyMap()));
		em.appendChild(generatePropertyMap(RESULTID,RESULTELEMENTID, benchmarker.getResult().getPropertyMap()));
		Element benchmarkerelement = document.createElement(BENCHMARKERID);
		benchmarkerelement.setAttribute(NAMEID, benchmarker.getClass().getName());
		em.appendChild(benchmarkerelement);
		
		
		
		document.appendChild(em);
		return true;
	}

	private Element generatePropertyMap(String parentName, String childName, Map<?, ?> map) {
		Element genOptElement=document.createElement(parentName);
		for(Entry<?, ?> entry:map.entrySet()){
			Element entryElement= document.createElement(childName);
			/*
			 * TODO check if this really works!!
			 */
			entryElement.setAttribute(entry.getKey()+"", entry.getValue()+"");
		}
		return genOptElement;
	}
	@Override
	public void streamTo(OutputStream out) {
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result =  new StreamResult(out);
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
		} catch (TransformerFactoryConfigurationError e) {
		} catch (TransformerException e) {
		}
	}

} //XMLResultProcessorImpl
