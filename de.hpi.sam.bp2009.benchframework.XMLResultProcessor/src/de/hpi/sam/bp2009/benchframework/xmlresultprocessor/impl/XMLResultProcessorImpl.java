/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.xmlresultprocessor.impl;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.jface.wizard.WizardPage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import de.hpi.sam.bp2009.benchframework.TestRun;
import de.hpi.sam.bp2009.benchframework.xmlresultprocessor.XMLResultProcessor;
import de.hpi.sam.bp2009.benchframework.xmlresultprocessor.XmlresultprocessorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XML Result Processor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.xmlresultprocessor.impl.XMLResultProcessorImpl#getResultPage <em>Result Page</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.xmlresultprocessor.impl.XMLResultProcessorImpl#getTestrun <em>Testrun</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMLResultProcessorImpl extends EObjectImpl implements XMLResultProcessor {
	/**
	 * The default value of the '{@link #getResultPage() <em>Result Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultPage()
	 * @generated
	 * @ordered
	 */
	protected static final WizardPage RESULT_PAGE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getResultPage() <em>Result Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultPage()
	 * @generated
	 * @ordered
	 */
	protected WizardPage resultPage = RESULT_PAGE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getTestrun() <em>Testrun</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestrun()
	 * @generated
	 * @ordered
	 */
	protected TestRun testrun;
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
	protected XMLResultProcessorImpl() {
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
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WizardPage getResultPage() {
		return resultPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultPage(WizardPage newResultPage) {
		WizardPage oldResultPage = resultPage;
		resultPage = newResultPage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmlresultprocessorPackage.XML_RESULT_PROCESSOR__RESULT_PAGE, oldResultPage, resultPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestRun getTestrun() {
		if (testrun != null && testrun.eIsProxy()) {
			InternalEObject oldTestrun = (InternalEObject)testrun;
			testrun = (TestRun)eResolveProxy(oldTestrun);
			if (testrun != oldTestrun) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XmlresultprocessorPackage.XML_RESULT_PROCESSOR__TESTRUN, oldTestrun, testrun));
			}
		}
		return testrun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestRun basicGetTestrun() {
		return testrun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestrun(TestRun newTestrun) {
		TestRun oldTestrun = testrun;
		testrun = newTestrun;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmlresultprocessorPackage.XML_RESULT_PROCESSOR__TESTRUN, oldTestrun, testrun));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XmlresultprocessorPackage.XML_RESULT_PROCESSOR__RESULT_PAGE:
				return getResultPage();
			case XmlresultprocessorPackage.XML_RESULT_PROCESSOR__TESTRUN:
				if (resolve) return getTestrun();
				return basicGetTestrun();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XmlresultprocessorPackage.XML_RESULT_PROCESSOR__RESULT_PAGE:
				setResultPage((WizardPage)newValue);
				return;
			case XmlresultprocessorPackage.XML_RESULT_PROCESSOR__TESTRUN:
				setTestrun((TestRun)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case XmlresultprocessorPackage.XML_RESULT_PROCESSOR__RESULT_PAGE:
				setResultPage(RESULT_PAGE_EDEFAULT);
				return;
			case XmlresultprocessorPackage.XML_RESULT_PROCESSOR__TESTRUN:
				setTestrun((TestRun)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case XmlresultprocessorPackage.XML_RESULT_PROCESSOR__RESULT_PAGE:
				return RESULT_PAGE_EDEFAULT == null ? resultPage != null : !RESULT_PAGE_EDEFAULT.equals(resultPage);
			case XmlresultprocessorPackage.XML_RESULT_PROCESSOR__TESTRUN:
				return testrun != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (resultPage: ");
		result.append(resultPage);
		result.append(')');
		return result.toString();
	}

//	public boolean addRun(Resource resource, OptionObject generatorOption,
//			OptionObject operatorOption) {
//		
//		try {
//			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
//		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
//		}
//		if(document == null)
//			return false;
//		
//		Element em = document.createElement(RUNID);
//		em.appendChild(generatePropertyMap(GENERATOROPTIONID,OPTIONID, generatorOption.getOptionMap()));
//		em.appendChild(generatePropertyMap(OPERATOROPTIONID,OPTIONID, operatorOption.getOptionMap()));
//		em.appendChild(generatePropertyMap(RESULTID,RESULTELEMENTID, benchmarker.getResult().getPropertyMap()));
//		Element benchmarkerelement = document.createElement(BENCHMARKERID);
//		benchmarkerelement.setAttribute(NAMEID, benchmarker.getClass().getName());
//		em.appendChild(benchmarkerelement);
//		
//		
//		
//		document.appendChild(em);
//		return true;
//	}
	
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

} //XMLResultProcessorImpl
