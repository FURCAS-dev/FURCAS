package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.AbstractEvaluationVisitor;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationHaltedException;
import org.eclipse.ocl.EvaluationVisitorImpl;
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.OppositePropertyCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.VariableExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerPlugin;

/**
 * When a {@link ValueNotFoundException} occurs during evaluating an expression, it is not caught, logged ans
 * swallowed but forwarded to the caller.<p>
 * 
 * All <tt>visit...</tt> operations check if the expression to evaluate is the {@link #sourceExpression} passed
 * to the constructor. If so, instead of actually evaluating the expression, the {@link #valueOfSourceExpression}
 * object is returned which was also passed to the constructor. This allows for partial evaluation of any
 * {@link CallExp} with a given value for the source expression.
 * 
 * @author Axel Uhl
 *
 */
public class PartialEvaluationVisitorImpl
        extends
        EvaluationVisitorImpl<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> {
    private org.eclipse.ocl.ecore.OCLExpression sourceExpression;
    private Object valueOfSourceExpression;

    public PartialEvaluationVisitorImpl(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
            Map<? extends EClass, ? extends Set<? extends EObject>> extentMap, org.eclipse.ocl.ecore.OCLExpression sourceExpression,
            Object valueOfSourceExpression) {
        super(env, evalEnv, extentMap);
        this.sourceExpression = sourceExpression;
        this.valueOfSourceExpression = valueOfSourceExpression;
    }

    @Override
    public Object visitOperationCallExp(OperationCallExp<EClassifier, EOperation> oc) {
        if (oc == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitOperationCallExp(oc);
    }

    @Override
    public Object visitIterateExp(IterateExp<EClassifier, EParameter> ie) {
        if (ie == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitIterateExp(ie);
    }

    @Override
    public Object visitIteratorExp(IteratorExp<EClassifier, EParameter> ie) {
        if (ie == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitIteratorExp(ie);
    }

    @Override
    public Object visitEnumLiteralExp(EnumLiteralExp<EClassifier, EEnumLiteral> el) {
        if (el == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitEnumLiteralExp(el);
    }

    @Override
    public Object visitVariableExp(VariableExp<EClassifier, EParameter> v) {
        if (v == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitVariableExp(v);
    }

    @Override
    public Object visitPropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> pc) {
        if (pc == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitPropertyCallExp(pc);
    }

    @Override
    public Object visitOppositePropertyCallExp(OppositePropertyCallExp<EClassifier, EStructuralFeature> pc) {
        if (pc == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitOppositePropertyCallExp(pc);
    }

    @Override
    public Object visitAssociationClassCallExp(AssociationClassCallExp<EClassifier, EStructuralFeature> ae) {
        if (ae == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitAssociationClassCallExp(ae);
    }

    @Override
    public Object visitIfExp(IfExp<EClassifier> ie) {
        if (ie == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitIfExp(ie);
    }

    @Override
    public Object visitTypeExp(TypeExp<EClassifier> t) {
        if (t == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitTypeExp(t);
    }

    @Override
    public Object visitStateExp(StateExp<EClassifier, EObject> s) {
        if (s == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitStateExp(s);
    }

    @Override
    public Object visitMessageExp(MessageExp<EClassifier, CallOperationAction, SendSignalAction> m) {
        if (m == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitMessageExp(m);
    }

    @Override
    public Object visitUnspecifiedValueExp(UnspecifiedValueExp<EClassifier> uv) {
        if (uv == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitUnspecifiedValueExp(uv);
    }

    @Override
    public Object visitIntegerLiteralExp(IntegerLiteralExp<EClassifier> il) {
        if (il == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitIntegerLiteralExp(il);
    }

    @Override
    public Object visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<EClassifier> literalExp) {
        if (literalExp == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitUnlimitedNaturalLiteralExp(literalExp);
    }

    @Override
    public Object visitRealLiteralExp(RealLiteralExp<EClassifier> rl) {
        if (rl == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitRealLiteralExp(rl);
    }

    @Override
    public Object visitStringLiteralExp(StringLiteralExp<EClassifier> sl) {
        if (sl == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitStringLiteralExp(sl);
    }

    @Override
    public Object visitBooleanLiteralExp(BooleanLiteralExp<EClassifier> bl) {
        if (bl == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitBooleanLiteralExp(bl);
    }

    @Override
    public Object visitInvalidLiteralExp(InvalidLiteralExp<EClassifier> il) {
        if (il == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitInvalidLiteralExp(il);
    }

    @Override
    public Object visitNullLiteralExp(NullLiteralExp<EClassifier> il) {
        if (il == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitNullLiteralExp(il);
    }

    @Override
    public Object visitLetExp(LetExp<EClassifier, EParameter> l) {
        if (l == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitLetExp(l);
    }

    @Override
    public Object visitCollectionLiteralExp(CollectionLiteralExp<EClassifier> cl) {
        if (cl == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitCollectionLiteralExp(cl);
    }

    @Override
    public Object visitTupleLiteralExp(TupleLiteralExp<EClassifier, EStructuralFeature> tl) {
        if (tl == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitTupleLiteralExp(tl);
    }

    /**
     * Does the same as the {@link AbstractEvaluationVisitor} implementation but additionally catches the
     * {@link ValueNotFoundException} and in that case passes on the exception instead of turning it into an <tt>OclInvalid</tt>
     * value.
     * 
     * @param expression
     *            an OCL expression to evaluate
     * 
     * @return the result of the evaluation
     */
    @Override
    public Object visitExpression(OCLExpression<EClassifier> expression) {
        try {
            return expression.accept(getVisitor());
        } catch (EvaluationHaltedException e) {
            // evaluation stopped on demand, propagate further
            throw e;
        } catch (ValueNotFoundException e) {
            throw e;
        } catch (RuntimeException e) {
            String msg = e.getLocalizedMessage();
            if (msg == null) {
                msg = "(no message)";
            }
            ImpactAnalyzerPlugin.log(Diagnostic.ERROR, ImpactAnalyzerPlugin.IGNORED_EXCEPTION_WARNING,
                    "Evaluation failed with an exception: " + msg, e);

            // failure to evaluate results in invalid
            return getInvalid();
        }
    }

}
