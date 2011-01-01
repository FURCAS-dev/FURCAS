package com.sap.ide.cts.editor.prettyprint.imported;

import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintHelper.isInstanceOf;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.BooleanPropertyExp;
import com.sap.furcas.metamodel.FURCAS.TCS.EqualsExp;
import com.sap.furcas.metamodel.FURCAS.TCS.InstanceOfExp;
import com.sap.furcas.metamodel.FURCAS.TCS.IsDefinedExp;
import com.sap.furcas.metamodel.FURCAS.TCS.OneExp;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.ide.cts.editor.prettyprint.MOINImportedModelAdapter;

public class TCSConditionEvaluator {

    @SuppressWarnings("unchecked")
    public static boolean eval(Object context, EObject condition) {
	boolean ret = true;

	String ctn = MOINImportedModelAdapter.getTypeName(condition);
	if (ctn.equals("FURCAS::TCS::AndExp")) {
	    ret = true;
	    for (Iterator<?> i = MOINImportedModelAdapter.getCol(condition, "expressions"); i.hasNext();) {
		ret &= eval(context, (EObject) i.next());
	    }
	} else if (ctn.equals("FURCAS::TCS::BooleanPropertyExp")) {
	    BooleanPropertyExp booleanPropertyExp = (BooleanPropertyExp) condition;
	    String propName = TcsUtil.getPropertyName(booleanPropertyExp.getPropertyReference());
// FIXME: Structure types not yet supported
//	    if (context instanceof RefStruct) {
//		ret = MOINImportedModelAdapter.getBool((RefStruct) context, propName);
//	    } else if (context instanceof EObject) {
		ret = MOINImportedModelAdapter.getBool((EObject) context, propName);
//	    }
	} else if (ctn.equals("FURCAS::TCS::IsDefinedExp")) {
	    IsDefinedExp isDefinedExp = (IsDefinedExp) condition;
	    String propName = TcsUtil.getPropertyName(isDefinedExp.getPropertyReference());
	    Object val = null;
//	    if (context instanceof RefStruct) {
//		val = MOINImportedModelAdapter.get((RefStruct) context, propName);
//	    } else if (context instanceof EObject) {
		val = MOINImportedModelAdapter.get((EObject) context, propName);
//	    }
	    if (val == null) {
		ret = false;
	    } else if (val instanceof Collection) {
		ret = (((Collection<?>) val).size() > 0);
	    } else {
		ret = true;
	    }

	} else if (ctn.equals("FURCAS::TCS::OneExp")) {
	    OneExp oneExp = (OneExp) condition;
	    String propName = TcsUtil.getPropertyName(oneExp.getPropertyReference());

	    Object val = null;
// FIXME: Structure types not yet supported
//	    if (context instanceof RefStruct) {
//		val = MOINImportedModelAdapter.get((RefStruct) context, propName);
//	    } else if (context instanceof EObject) {
		val = MOINImportedModelAdapter.get((EObject) context, propName);
//	    }
	    if (val == null) {
		ret = false;
	    } else if (val instanceof Collection) {
		ret = (((Collection<?>) val).size() == 1);
	    } else {
		ret = true;
	    }
	} else if (ctn.equals("FURCAS::TCS::InstanceOfExp")) {
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
	} else if (ctn.equals("FURCAS::TCS::EqualsExp")) {
	    EqualsExp equalsExp = (EqualsExp) condition;
	    String propName = TcsUtil.getPropertyName(equalsExp.getPropertyReference());
	    EObject value = MOINImportedModelAdapter.getME(condition, "value");
	    String vtn = MOINImportedModelAdapter.getTypeName(value);
	    if (vtn.equals("FURCAS::TCS::IntegerVal")) {
		int lv = MOINImportedModelAdapter.getInt(value, "symbol");
		int pv = 0;
// FIXME: Structure types not yet supported
//		if (context instanceof RefStruct) {
//		    pv = MOINImportedModelAdapter.getInt((RefStruct) context, propName);
//		} else if (context instanceof EObject) {
		    pv = MOINImportedModelAdapter.getInt((EObject) context, propName);
//		}
		ret = (lv == pv);
	    } else if (vtn.equals("FURCAS::TCS::NegativeIntegerVal")) {
		int lv = -MOINImportedModelAdapter.getInt(value, "symbol");
		int pv = 0;
// FIXME: Structure types not yet supported
//		if (context instanceof RefStruct) {
//		    pv = MOINImportedModelAdapter.getInt((RefStruct) context, propName);
//		} else if (context instanceof EObject) {
		    pv = MOINImportedModelAdapter.getInt((EObject) context, propName);
//		}
		ret = (lv == pv);
	    } else if (vtn.equals("FURCAS::TCS::StringVal")) {
		String lv = MOINImportedModelAdapter.getString(value, "symbol");
		List<String> pv = null;
// FIXME: Structure types not yet supported
//		if (context instanceof RefStruct) {
//		    pv = (List<String>) MOINImportedModelAdapter.get((RefStruct) context, propName);
//		} else if (context instanceof EObject) {
		    pv = (List<String>) MOINImportedModelAdapter.get((EObject) context, propName);
//		}
		ret = (lv.equals(TcsUtil.joinNameList(pv)));
	    } else if (vtn.equals("FURCAS::TCS::EnumLiteralVal")) {
		String lv = MOINImportedModelAdapter.getString(value, "name");

		EEnumLiteral pv = null;
// FIXME: Structure types not yet supported
//		if (context instanceof RefStruct) {
//		    pv = (RefEnum) MOINImportedModelAdapter.get((RefStruct) context, propName);
//		} else if (context instanceof EObject) {
		    pv = (EEnumLiteral) MOINImportedModelAdapter.get((EObject) context, propName);
//		}
		ret = (lv.equals(pv.toString()));
	    } else {
		throw new IllegalArgumentException(vtn + " unsupported.");
	    }
	} else {
	    throw new IllegalArgumentException(ctn + " unsupported.");
	}
	return ret;
    }
}
