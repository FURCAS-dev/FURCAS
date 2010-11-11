package com.sap.ide.cts.editor.prettyprint.imported;

import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintHelper.isInstanceOf;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import tcs.BooleanPropertyExp;
import tcs.EqualsExp;
import tcs.InstanceOfExp;
import tcs.IsDefinedExp;
import tcs.OneExp;

import com.sap.ide.cts.editor.prettyprint.MOINImportedModelAdapter;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

public class TCSConditionEvaluator {

    @SuppressWarnings("unchecked")
    public static boolean eval(Object context, RefObject condition) {
	boolean ret = true;

	String ctn = MOINImportedModelAdapter.getTypeName(condition);
	if (ctn.equals("TCS::AndExp")) {
	    ret = true;
	    for (Iterator<?> i = MOINImportedModelAdapter.getCol(condition, "expressions"); i.hasNext();) {
		ret &= eval(context, (RefObject) i.next());
	    }
	} else if (ctn.equals("TCS::BooleanPropertyExp")) {
	    BooleanPropertyExp booleanPropertyExp = (BooleanPropertyExp) condition;
	    String propName = TcsUtil.getPropertyName(booleanPropertyExp.getPropertyReference());
	    if (context instanceof RefStruct) {
		ret = MOINImportedModelAdapter.getBool((RefStruct) context, propName);
	    } else if (context instanceof RefObject) {
		ret = MOINImportedModelAdapter.getBool((RefObject) context, propName);
	    }
	} else if (ctn.equals("TCS::IsDefinedExp")) {
	    IsDefinedExp isDefinedExp = (IsDefinedExp) condition;
	    String propName = TcsUtil.getPropertyName(isDefinedExp.getPropertyReference());
	    Object val = null;
	    if (context instanceof RefStruct) {
		val = MOINImportedModelAdapter.get((RefStruct) context, propName);
	    } else if (context instanceof RefObject) {
		val = MOINImportedModelAdapter.get((RefObject) context, propName);
	    }
	    if (val == null) {
		ret = false;
	    } else if (val instanceof Collection) {
		ret = (((Collection<?>) val).size() > 0);
	    } else {
		ret = true;
	    }

	} else if (ctn.equals("TCS::OneExp")) {
	    OneExp oneExp = (OneExp) condition;
	    String propName = TcsUtil.getPropertyName(oneExp.getPropertyReference());

	    Object val = null;
	    if (context instanceof RefStruct) {
		val = MOINImportedModelAdapter.get((RefStruct) context, propName);
	    } else if (context instanceof RefObject) {
		val = MOINImportedModelAdapter.get((RefObject) context, propName);
	    }
	    if (val == null) {
		ret = false;
	    } else if (val instanceof Collection) {
		ret = (((Collection<?>) val).size() == 1);
	    } else {
		ret = true;
	    }
	} else if (ctn.equals("TCS::InstanceOfExp")) {
	    InstanceOfExp ioExp = (InstanceOfExp) condition;

	    Object referredObject = null;
	    if (context instanceof RefStruct) {
		referredObject = TcsUtil.getPropertyValue((RefStruct) context, ioExp.getPropertyReference());
	    } else if (context instanceof RefObject) {
		referredObject = TcsUtil.getPropertyValue((RefObject) context, ioExp.getPropertyReference());
	    }

	    if (referredObject instanceof RefObject) {
		if (isInstanceOf((RefObject) referredObject, ioExp.getSupertype())) {
		    ret = true;
		} else {
		    ret = false;
		}
	    } else {
		// TODO handle primitive types as well?
		System.out.println("TODO NEED HANDLING IN PP");
	    }
	} else if (ctn.equals("TCS::EqualsExp")) {
	    EqualsExp equalsExp = (EqualsExp) condition;
	    String propName = TcsUtil.getPropertyName(equalsExp.getPropertyReference());
	    RefObject value = MOINImportedModelAdapter.getME(condition, "value");
	    String vtn = MOINImportedModelAdapter.getTypeName(value);
	    if (vtn.equals("TCS::IntegerVal")) {
		int lv = MOINImportedModelAdapter.getInt(value, "symbol");
		int pv = 0;
		if (context instanceof RefStruct) {
		    pv = MOINImportedModelAdapter.getInt((RefStruct) context, propName);
		} else if (context instanceof RefObject) {
		    pv = MOINImportedModelAdapter.getInt((RefObject) context, propName);
		}
		ret = (lv == pv);
	    } else if (vtn.equals("TCS::NegativeIntegerVal")) {
		int lv = -MOINImportedModelAdapter.getInt(value, "symbol");
		int pv = 0;
		if (context instanceof RefStruct) {
		    pv = MOINImportedModelAdapter.getInt((RefStruct) context, propName);
		} else if (context instanceof RefObject) {
		    pv = MOINImportedModelAdapter.getInt((RefObject) context, propName);
		}
		ret = (lv == pv);
	    } else if (vtn.equals("TCS::StringVal")) {
		String lv = MOINImportedModelAdapter.getString(value, "symbol");
		List<String> pv = null;
		if (context instanceof RefStruct) {
		    pv = (List<String>) MOINImportedModelAdapter.get((RefStruct) context, propName);
		} else if (context instanceof RefObject) {
		    pv = (List<String>) MOINImportedModelAdapter.get((RefObject) context, propName);
		}
		ret = (lv.equals(TcsUtil.joinNameList(pv)));
	    } else if (vtn.equals("TCS::EnumLiteralVal")) {
		String lv = MOINImportedModelAdapter.getString(value, "name");

		RefEnum pv = null;
		if (context instanceof RefStruct) {
		    pv = (RefEnum) MOINImportedModelAdapter.get((RefStruct) context, propName);
		} else if (context instanceof RefObject) {
		    pv = (RefEnum) MOINImportedModelAdapter.get((RefObject) context, propName);
		}
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
