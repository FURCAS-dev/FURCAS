package com.sap.mi.fwk.ui.test.unit.databinding;

import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.demo.mi.testmetamodel.databinding.AttributeEnumeration;
import com.sap.demo.mi.testmetamodel.databinding.SecondTargetObject;
import com.sap.demo.mi.testmetamodel.databinding.TargetObject;
import com.sap.ide.junit.extensions.ExtendedTestCase;
import com.sap.mi.fwk.ui.internal.databinding.TracingSupport;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObjectAdapter;

public class TracingSupportTest extends ExtendedTestCase {

	public TracingSupportTest() {
		super();
	}

	public void testGetName() {
		NameMock nameMock = new NameMock();
		assertEquals("Invalid name returned for name test", "TestName", TracingSupport.getName(nameMock));

		IdMock idMock = new IdMock();
		assertEquals("Invalid name returned for id test", "TestId", TracingSupport.getName(idMock));
	}

	private class NameMock extends IdMock {

		@Override
		public Object refGetValue(String featureName) {
			if ("name".equals(featureName)) {
				return getName();
			}
			return super.refGetValue(featureName);
		}

		public void setName(String name) {

		}

		public String getName() {
			return "TestName";
		}

	}

	private class IdMock extends RefBaseObjectAdapter implements TargetObject {

		public double getDoubleAttr() throws JmiException {
			// Auto-generated method stub
			return 0;
		}

		public AttributeEnumeration getEnumerationAttr() throws JmiException {
			// Auto-generated method stub
			return null;
		}

		public float getFloatAttr() throws JmiException {
			// Auto-generated method stub
			return 0;
		}

		public String getId() throws JmiException {
			return "TestId";
		}

		public int getIntegerAttr() throws JmiException {
			// Auto-generated method stub
			return 0;
		}

		public long getLongAttr() throws JmiException {
			// Auto-generated method stub
			return 0;
		}

		public SecondTargetObject getObjectAttr() throws JmiException {
			// Auto-generated method stub
			return null;
		}

		public String getStringAttr() throws JmiException {
			// Auto-generated method stub
			return null;
		}

		public boolean isBooleanAttr() throws JmiException {
			// Auto-generated method stub
			return false;
		}

		public void setBooleanAttr(boolean newValue) throws JmiException {
			// Auto-generated method stub

		}

		public void setDoubleAttr(double newValue) throws JmiException {
			// Auto-generated method stub

		}

		public void setEnumerationAttr(AttributeEnumeration newValue) throws JmiException {
			// Auto-generated method stub

		}

		public void setFloatAttr(float newValue) throws JmiException {
			// Auto-generated method stub

		}

		public void setId(String newValue) throws JmiException {
			// Auto-generated method stub

		}

		public void setIntegerAttr(int newValue) throws JmiException {
			// Auto-generated method stub

		}

		public void setLongAttr(long newValue) throws JmiException {
			// Auto-generated method stub

		}

		public void setObjectAttr(SecondTargetObject newValue) throws JmiException {
			// Auto-generated method stub

		}

		public void setStringAttr(String newValue) throws JmiException {
			// Auto-generated method stub

		}

		public RefClass refClass() {
			// Auto-generated method stub
			return null;
		}

		public void refDelete() {
			// Auto-generated method stub

		}

		public RefFeatured refImmediateComposite() {
			// Auto-generated method stub
			return null;
		}

		public boolean refIsInstanceOf(RefObject objType, boolean considerSubtypes) {
			// Auto-generated method stub
			return false;
		}

		public RefFeatured refOutermostComposite() {
			// Auto-generated method stub
			return null;
		}

		public Object refGetValue(RefObject feature) {
			// Auto-generated method stub
			return null;
		}

		public Object refGetValue(String featureName) {
			if ("id".equals(featureName)) {
				return getId();
			}
			return null;
		}

		public Object refInvokeOperation(RefObject requestedOperation, List<? extends Object> args) throws RefException {
			// Auto-generated method stub
			return null;
		}

		public Object refInvokeOperation(String requestedOperation, List<? extends Object> args) throws RefException {
			// Auto-generated method stub
			return null;
		}

		public void refSetValue(RefObject feature, Object value) {
			// Auto-generated method stub

		}

		public void refSetValue(String featureName, Object value) {
			// Auto-generated method stub

		}
	}
}
