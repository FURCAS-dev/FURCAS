package com.sap.ide.cts.editor.contentassist;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import org.eclipse.emf.ecore.EClassifier;

import com.sap.furcas.metamodel.TCS.Alternative;
import com.sap.furcas.metamodel.TCS.AndExp;
import com.sap.furcas.metamodel.TCS.AtomExp;
import com.sap.furcas.metamodel.TCS.Block;
import com.sap.furcas.metamodel.TCS.BooleanPropertyExp;
import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.ConditionalElement;
import com.sap.furcas.metamodel.TCS.CustomSeparator;
import com.sap.furcas.metamodel.TCS.EqualsExp;
import com.sap.furcas.metamodel.TCS.Expression;
import com.sap.furcas.metamodel.TCS.FunctionCall;
import com.sap.furcas.metamodel.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.TCS.InstanceOfExp;
import com.sap.furcas.metamodel.TCS.IsDefinedExp;
import com.sap.furcas.metamodel.TCS.LiteralRef;
import com.sap.furcas.metamodel.TCS.OneExp;
import com.sap.furcas.metamodel.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.TCS.Property;
import com.sap.furcas.metamodel.TCS.SequenceElement;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.mi.textual.common.util.EcoreHelper;
=======
import tcs.Alternative;
import tcs.AndExp;
import tcs.AtomExp;
import tcs.Block;
import tcs.BooleanPropertyExp;
import tcs.ClassTemplate;
import tcs.ConditionalElement;
import tcs.CustomSeparator;
import tcs.EqualsExp;
import tcs.Expression;
import tcs.FunctionCall;
import tcs.InjectorActionsBlock;
import tcs.InstanceOfExp;
import tcs.IsDefinedExp;
import tcs.LiteralRef;
import tcs.OneExp;
import tcs.OperatorTemplate;
import tcs.Property;
import tcs.SequenceElement;
import tcs.Template;

import com.sap.furcas.textual.tcs.TcsUtil;
import com.sap.tc.moin.repository.mmi.model.Classifier;
>>>>>>> 339c4f6827f2205a0254bfb911d75ecfc4a51698

public class TcsDebugUtil {

	public static String prettyPrint(Template t) {
		if (t == null) {
			return "null";
		}

		if (t instanceof ClassTemplate) {
			ClassTemplate ct = (ClassTemplate) t;
			String typeName = "null";
			String mode = ct.getMode();
			EClassifier type = ct.getMetaReference();
			if (type != null) {
				typeName = TcsUtil.joinNameList(EcoreHelper.getQualifiedName(type));
			}
			if (ct.isIsMain()) {
				return "ClassTemplate (main) for type " + typeName
						+ " and mode " + mode;
			} else {
				return "ClassTemplate for type " + typeName + " and mode "
						+ mode;
			}
		}

		if (t instanceof OperatorTemplate) {
			return "OperatorTemplate";
		}

		return t.toString();
	}

	public static String prettyPrint(SequenceElement e) {
		if (e == null) {
			return "null";
		}

		if (e instanceof LiteralRef) {
			LiteralRef ref = (LiteralRef) e;
			if (ref.getReferredLiteral() != null) {
				return "LiteralRef " + ref.getReferredLiteral().getValue();
			} else {
				return "LiteralRef with null value";
			}
		}

		if (e instanceof Property) {
			Property prop = (Property) e;
			return "Property "
					+ TcsUtil.getPropertyName(prop.getPropertyReference());
		}

		if (e instanceof FunctionCall) {
			FunctionCall call = (FunctionCall) e;
			return "FunctionCall " + call.getCalledFunction().getFunctionName();
		}

		if (e instanceof ConditionalElement) {
			ConditionalElement cond = (ConditionalElement) e;
			return "ConditionalElement (" + prettyPrint(cond.getCondition())
					+ ")";
		}

		if (e instanceof Alternative) {
			// Alternative alt = (Alternative) e;
			return "Alternative";
		}

		if (e instanceof Block) {
			// Block block = (Block) e;
			return "Block";
		}

		if (e instanceof InjectorActionsBlock) {
			// InjectorActionsBlock block = (InjectorActionsBlock) e;
			return "InjectorActionsBlock";
		}

		if (e instanceof CustomSeparator) {
			// CustomSeparator cs = (CustomSeparator) e;
			return "CustomSeparator";
		}

		return e.toString();

	}

	public static String prettyPrint(Expression e) {
		if (e == null) {
			return "null";
		}

		if (e instanceof AndExp) {
			AndExp and = (AndExp) e;
			if (and.getExpressions() != null) {
				List<? extends AtomExp> expressions = new ArrayList<AtomExp>(
						and.getExpressions());
				String output = "";
				for (int i = 0; i < expressions.size() - 1; i++) {
					output += prettyPrint(expressions.get(i)) + " && ";
				}
				output += prettyPrint(expressions.get(expressions.size() - 1));
				return output;
			} else {
				return "[AndExp with null expressions]";
			}
		}

		return e.toString();
	}

	public static String prettyPrint(AtomExp e) {
		if (e == null) {
			return "null";
		}

		if (e instanceof BooleanPropertyExp) {
			BooleanPropertyExp exp = (BooleanPropertyExp) e;
			String output = TcsUtil.getPropertyName(exp.getPropertyReference());
			if (output != null) {
				return output;
			} else {
				return "[BooleanPropertyExp with null property ref]";
			}
		}

		if (e instanceof EqualsExp) {
			// EqualsExp exp = (EqualsExp) e;
			// TODO
			return "[EqualsExp]";
		}

		if (e instanceof InstanceOfExp) {
			// InstanceOfExp exp = (InstanceOfExp) e;
			// TODO
			return "[InstaceOfExp]";
		}

		if (e instanceof IsDefinedExp) {
			IsDefinedExp exp = (IsDefinedExp) e;
			String output = TcsUtil.getPropertyName(exp.getPropertyReference());
			if (output != null) {
				return "isDefined(" + output + ")";
			} else {
				return "[IsDefinedExp with null property ref]";
			}

		}

		if (e instanceof OneExp) {
			// OneExp exp = (OneExp) e;
			// TODO
			return "[OneExp]";
		}

		return e.toString();
	}

}