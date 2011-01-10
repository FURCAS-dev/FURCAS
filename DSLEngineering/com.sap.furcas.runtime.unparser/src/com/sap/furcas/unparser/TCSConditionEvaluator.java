/*******************************************************************************
 * Copyright (c) 2007-2011 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *     SAP AG - API and implementation enhancements
 ******************************************************************************/
package com.sap.furcas.unparser;

import static com.sap.furcas.unparser.PrettyPrintHelper.isInstanceOf;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.AndExp;
import com.sap.furcas.metamodel.FURCAS.TCS.AtomExp;
import com.sap.furcas.metamodel.FURCAS.TCS.BooleanPropertyExp;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralVal;
import com.sap.furcas.metamodel.FURCAS.TCS.EqualsExp;
import com.sap.furcas.metamodel.FURCAS.TCS.InstanceOfExp;
import com.sap.furcas.metamodel.FURCAS.TCS.IntegerVal;
import com.sap.furcas.metamodel.FURCAS.TCS.IsDefinedExp;
import com.sap.furcas.metamodel.FURCAS.TCS.NegativeIntegerVal;
import com.sap.furcas.metamodel.FURCAS.TCS.OneExp;
import com.sap.furcas.metamodel.FURCAS.TCS.StringVal;
import com.sap.furcas.metamodel.FURCAS.TCS.Value;
import com.sap.furcas.runtime.tcs.TcsUtil;

public class TCSConditionEvaluator {

    @SuppressWarnings("unchecked")
    public static boolean eval(Object context, EObject condition) {
	boolean ret = true;

	if (condition instanceof AndExp) {
	    ret = true;
	    for (AtomExp exp : ((AndExp) condition).getExpressions()) {
		ret &= eval(context, exp);
	    }
	} else if (condition instanceof BooleanPropertyExp) {
	    BooleanPropertyExp booleanPropertyExp = (BooleanPropertyExp) condition;
	    String propName = TcsUtil.getPropertyName(booleanPropertyExp.getPropertyReference());
// FIXME: Structure types not yet supported
//	    if (context instanceof RefStruct) {
//		ret = MOINImportedModelAdapter.getBool((RefStruct) context, propName);
//	    } else if (context instanceof EObject) {
		ret = EMFModelInspector.getBool((EObject) context, propName);
//	    }
	} else if (condition instanceof IsDefinedExp) {
	    IsDefinedExp isDefinedExp = (IsDefinedExp) condition;
	    String propName = TcsUtil.getPropertyName(isDefinedExp.getPropertyReference());
	    Object val = null;
//	    if (context instanceof RefStruct) {
//		val = MOINImportedModelAdapter.get((RefStruct) context, propName);
//	    } else if (context instanceof EObject) {
		val = EMFModelInspector.get((EObject) context, propName);
//	    }
	    if (val == null) {
		ret = false;
	    } else if (val instanceof Collection) {
		ret = (((Collection<?>) val).size() > 0);
	    } else {
		ret = true;
	    }

	} else if (condition instanceof OneExp) {
	    OneExp oneExp = (OneExp) condition;
	    String propName = TcsUtil.getPropertyName(oneExp.getPropertyReference());

	    Object val = null;
// FIXME: Structure types not yet supported
//	    if (context instanceof RefStruct) {
//		val = MOINImportedModelAdapter.get((RefStruct) context, propName);
//	    } else if (context instanceof EObject) {
		val = EMFModelInspector.get((EObject) context, propName);
//	    }
	    if (val == null) {
		ret = false;
	    } else if (val instanceof Collection) {
		ret = (((Collection<?>) val).size() == 1);
	    } else {
		ret = true;
	    }
	} else if (condition instanceof InstanceOfExp) {
	    InstanceOfExp ioExp = (InstanceOfExp) condition;

	    Object referredObject = null;
// FIXME: Structure types not yet supported
//	    if (context instanceof RefStruct) {
//		referredObject = TcsUtil.getPropertyValue((RefStruct) context, ioExp.getPropertyReference());
//	    } else if (context instanceof EObject) {
		referredObject = TcsUtil.getPropertyValue((EObject) context, ioExp.getPropertyReference());
//	    }

	    if (referredObject instanceof EObject) {
		if (isInstanceOf((EObject) referredObject, ioExp.getSupertype())) {
		    ret = true;
		} else {
		    ret = false;
		}
	    } else {
		// TODO handle primitive types as well?
		System.out.println("TODO NEED HANDLING IN PP");
	    }
	} else if (condition instanceof EqualsExp) {
	    EqualsExp equalsExp = (EqualsExp) condition;
	    String propName = TcsUtil.getPropertyName(equalsExp.getPropertyReference());
	    Value value = equalsExp.getValue();
	    if (value instanceof IntegerVal) {
		int lv = ((IntegerVal) value).getSymbol();
		int pv = 0;
// FIXME: Structure types not yet supported
//		if (context instanceof RefStruct) {
//		    pv = MOINImportedModelAdapter.getInt((RefStruct) context, propName);
//		} else if (context instanceof EObject) {
		    pv = EMFModelInspector.getInteger((EObject) context, propName);
//		}
		ret = (lv == pv);
	    } else if (value instanceof NegativeIntegerVal) {
		int lv = - ((NegativeIntegerVal) value).getSymbol();
		int pv = 0;
// FIXME: Structure types not yet supported
//		if (context instanceof RefStruct) {
//		    pv = MOINImportedModelAdapter.getInt((RefStruct) context, propName);
//		} else if (context instanceof EObject) {
                    pv = EMFModelInspector.getInteger((EObject) context, propName);
//		}
		ret = (lv == pv);
	    } else if (value instanceof StringVal) {
		String lv = ((StringVal) value).getSymbol();
		List<String> pv = null;
// FIXME: Structure types not yet supported
//		if (context instanceof RefStruct) {
//		    pv = (List<String>) MOINImportedModelAdapter.get((RefStruct) context, propName);
//		} else if (context instanceof EObject) {
		    pv = (List<String>) EMFModelInspector.get((EObject) context, propName);
//		}
		ret = (lv.equals(TcsUtil.joinNameList(pv)));
	    } else if (value instanceof EnumLiteralVal) {
		String lv = value.getName();

		Enum<?> pv = null;
// FIXME: Structure types not yet supported
//		if (context instanceof RefStruct) {
//		    pv = (RefEnum) MOINImportedModelAdapter.get((RefStruct) context, propName);
//		} else if (context instanceof EObject) {
		    pv = (Enum<?>) EMFModelInspector.get((EObject) context, propName);
//		}
		ret = (lv.equals(pv.toString()));
	    } else {
		throw new IllegalArgumentException(EMFModelInspector.getTypeName(value) + " unsupported.");
	    }
	} else {
	    throw new IllegalArgumentException(EMFModelInspector.getTypeName(condition) + " unsupported.");
	}
	return ret;
    }
}
