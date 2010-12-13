package com.sap.ap.metamodel.utils;

import java.util.Iterator;

import data.classes.ActualObjectParameter;
import data.classes.ClassTypeDefinition;
import data.classes.FunctionSignatureTypeDefinition;
import data.classes.MethodSignature;
import data.classes.NestedTypeDefinition;
import data.classes.Parameter;
import data.classes.Signature;
import data.classes.TypeDefinition;
import dataaccess.expressions.literals.Literal;

/**
 * Can provide a text representation for different types of model elements
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class StringFormatter {

    public static String toString(TypeDefinition td) {
        StringBuilder sb = new StringBuilder();
        if (td instanceof ClassTypeDefinition) {
            if (((ClassTypeDefinition) td).getClazz() != null) {
                sb.append(((ClassTypeDefinition) td).getClazz().getName());
                if (((ClassTypeDefinition) td).getObjectParameters().size() > 0) {
                    sb.append('|');
                    boolean commaBefore = false;
                    for (ActualObjectParameter aop : ((ClassTypeDefinition) td).getObjectParameters()) {
                        if (commaBefore) {
                            sb.append(", ");
                        } else {
                            commaBefore = true;
                        }
                        if (aop.getValue() instanceof Literal) {
                            sb.append(((Literal) aop.getValue()).getLiteral());
                        } else {
                            sb.append(aop.getValue());
                        }
                    }
                    sb.append('|');
                }
            } else {
                sb.append("<null>");
            }
        } else if (td instanceof NestedTypeDefinition) {
            sb.append(toString(((NestedTypeDefinition) td).getType()));
        } else if (td instanceof FunctionSignatureTypeDefinition) {
            FunctionSignatureTypeDefinition fstd = (FunctionSignatureTypeDefinition) td;
            sb.append(toString(fstd.getSignature()));
        }
        sb.append('[');
        if (td != null) {
            sb.append(td.getLowerMultiplicity());
            sb.append("..");
            sb.append((td.getUpperMultiplicity() == -1) ? "*" : "" + td.getUpperMultiplicity());
            if (td.isOrdered()) {
                sb.append('o');
            }
            if (td.isUnique()) {
                sb.append('u');
            }
        } else {
            sb.append("<null>");
        }
        sb.append(']');
        return sb.toString();
    }

    public static String toString(Signature sig) {
        StringBuilder sb = new StringBuilder();
        if (sig instanceof MethodSignature) {
            MethodSignature ms = (MethodSignature) sig;
            if (ms.getOwner() != null) {
                sb.append(ms.getOwner().getName());
                sb.append("::");
            }
            sb.append(ms.getName());
        }
        sb.append('(');
        for (Iterator<Parameter> i = sig.getInput().iterator(); i.hasNext();) {
            sb.append(toString(i.next().getType()));
            if (i.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        sb.append(":");
        if (sig.getOutput() != null) {
            sb.append(toString(sig.getOutput()));
        } else {
            sb.append("void");
        }
        return sb.toString();
    }

}
