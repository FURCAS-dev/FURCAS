package de.hpi.sam.bp2009.solution.oclToMqlMapping.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationHaltedException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
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
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;

import com.sap.emf.ocl.hiddenopposites.EvaluationVisitorWithHiddenOppositesImpl;
import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;

public class MappingEvaluationVisitor
extends EvaluationVisitorWithHiddenOppositesImpl {

    private boolean noMap=false; ;
    private Object query2Result;



    @Override
    public Object visitExpression(OCLExpression<EClassifier> expression) {

        try {

            if (wasNoMap()){
                return super.visitExpression(expression);
            }
            else{
                return expression.accept(getVisitor());
            }
        } catch (EvaluationHaltedException e) {
            // evaluation stopped on demand, propagate further
            throw e;
        } catch (RuntimeException e) {
            noMap=true;
            // failure to evaluate results in invalid

            return super.visitExpression(expression);

        }

        // TODO Check if expression has a self variable, if so there must be a context, this should be replaced by allInstances

    }

    public boolean wasNoMap() {

        return noMap;}

    @SuppressWarnings("unchecked")
    @Override
    public Object visitOperationCallExp(OperationCallExp<EClassifier, EOperation> oc) {
        if(wasNoMap()){
            return super.visitOperationCallExp(oc);
        }
        else{
            int opCode = oc.getOperationCode();
            if(opCode==PredefinedType.ALL_INSTANCES){
                Set<EObject> allO = new HashSet<EObject>();
                Object self = getEvaluationEnvironment().getValueOf(EcoreEnvironment.SELF_VARIABLE_NAME);
                if (self != null && self instanceof EObject) {
                    allO.add((EObject) self);
                } else {
                    throw new RuntimeException("Need a valid context element even for allInstances() because we need to derive a query scope");
                }
                OCLExpression<?> ocSource = oc.getSource();

                Object ocType=null;
                if (ocSource instanceof TypeExp<?>){
                    ocType = ((TypeExp<?>) ocSource).getReferredType();
                }
                /**
                 * the expression must have the form allInstances()->IteratorExp(body)
                 * otherwise traverse the AST from beginning
                 */
                if (oc.eContainer()instanceof IteratorExp<?, ?>){
                    IteratorExp<EClassifier, EParameter> ie = (IteratorExp<EClassifier, EParameter>) oc.eContainer();
                    OCLExpression<EClassifier> body = ie.getBody();
                    query2Result = Query2.buildMqlQuery(allO, ocType, body, ie, this); 
                    if (query2Result == null){
                        //if the query2 fail traverse the AST from beginning
                        noMap = true;
                        OCLExpression<EClassifier> oclExp = (OCLExpression<EClassifier>) oc.eContainer();
                        return visitExpression(oclExp);}
                    else
                        return query2Result;

                }else{
                    // if the expression has another form, traverse the AST from beginning
                    noMap=true;
                    OCLExpression<EClassifier> oclExp = (OCLExpression<EClassifier>) oc.eContainer();
                    return visitExpression(oclExp);
                }

            }else{
                //if there isn't any allInstances()
                noMap=true;
                OCLExpression<EClassifier> oclExp = (OCLExpression<EClassifier>) oc.eContainer();
                return visitExpression(oclExp);
            }
        }
    }

    @Override
    public Object visitIterateExp(IterateExp<EClassifier, EParameter> ie) {
        // TODO Auto-generated method stub
        return super.visitIterateExp(ie);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object visitIteratorExp(IteratorExp<EClassifier, EParameter> ie) {

        if(wasNoMap()){
            return super.visitIteratorExp(ie);
        }
        else{
            if (ie.getSource() instanceof OperationCallExp<?, ?>){
                switch (OCLStandardLibraryUtil.getOperationCode(ie.getName())) {
                case PredefinedType.EXISTS:
                    return visitOperationCallExp((OperationCallExp<EClassifier, EOperation>) ie.getSource());
                case PredefinedType.FOR_ALL:
                    return visitOperationCallExp((OperationCallExp<EClassifier, EOperation>) ie.getSource());
                case PredefinedType.SELECT:
                    return visitOperationCallExp((OperationCallExp<EClassifier, EOperation>) ie.getSource());
                    //            case PredefinedType.REJECT:
                    //                return visitOperationCallExp((OperationCallExp<C, O>) ie.getSource());
                case PredefinedType.COLLECT:
                    return visitOperationCallExp((OperationCallExp<EClassifier, EOperation>) ie.getSource());
                case PredefinedType.COLLECT_NESTED:
                    return visitOperationCallExp((OperationCallExp<EClassifier, EOperation>) ie.getSource());
                    //            case PredefinedType.ONE:
                    //                return visitOperationCallExp((OperationCallExp<C, O>) ie.getSource());
                case PredefinedType.ANY:
                    return visitOperationCallExp((OperationCallExp<EClassifier, EOperation>) ie.getSource());
                    //            case PredefinedType.SORTED_BY:
                    //                return visitOperationCallExp((OperationCallExp<C, O>) ie.getSource());
                    //            case PredefinedType.IS_UNIQUE:
                    //                return visitOperationCallExp((OperationCallExp<C, O>) ie.getSource());
                    //            case PredefinedType.CLOSURE:
                    //                return visitOperationCallExp((OperationCallExp<C, O>) ie.getSource());
                default: return super.visitIteratorExp(ie);
                }
            }

            else{

                return super.visitIteratorExp(ie);}

        }
    }

    @Override
    public Object visitEnumLiteralExp(EnumLiteralExp<EClassifier, EEnumLiteral> el) {
        // TODO Auto-generated method stub
        return super.visitEnumLiteralExp(el);
    }

    @Override
    public Object visitVariableExp(VariableExp<EClassifier, EParameter> v) {
        // TODO Auto-generated method stub
        return super.visitVariableExp(v);
    }

    @Override
    public Object visitPropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> pc) {
        // TODO Auto-generated method stub
        return super.visitPropertyCallExp(pc);
    }

    @Override
    public Object visitOppositePropertyCallExp(OppositePropertyCallExp pc) {
        // TODO Auto-generated method stub
        return super.visitOppositePropertyCallExp(pc);
    }

    @Override
    public Object visitAssociationClassCallExp(AssociationClassCallExp<EClassifier, EStructuralFeature> ae) {
        // TODO Auto-generated method stub
        return super.visitAssociationClassCallExp(ae);
    }

    @Override
    public Object visitVariable(Variable<EClassifier, EParameter> vd) {
        // TODO Auto-generated method stub
        return super.visitVariable(vd);
    }

    @Override
    public Object visitIfExp(IfExp<EClassifier> ie) {
        // TODO Auto-generated method stub
        return super.visitIfExp(ie);
    }

    @Override
    public Object visitTypeExp(TypeExp<EClassifier> t) {
        // TODO Auto-generated method stub
        return super.visitTypeExp(t);
    }

    @Override
    public Object visitStateExp(StateExp<EClassifier, EObject> s) {
        // TODO Auto-generated method stub
        return super.visitStateExp(s);
    }

    @Override
    public Object visitMessageExp(MessageExp<EClassifier, CallOperationAction, SendSignalAction> m) {
        // TODO Auto-generated method stub
        return super.visitMessageExp(m);
    }

    @Override
    public Object visitUnspecifiedValueExp(UnspecifiedValueExp<EClassifier> uv) {
        // TODO Auto-generated method stub
        return super.visitUnspecifiedValueExp(uv);
    }

    @Override
    public Object visitIntegerLiteralExp(IntegerLiteralExp<EClassifier> il) {
        // TODO Auto-generated method stub
        return super.visitIntegerLiteralExp(il);
    }

    @Override
    public Object visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<EClassifier> literalExp) {
        // TODO Auto-generated method stub
        return super.visitUnlimitedNaturalLiteralExp(literalExp);
    }

    @Override
    public Object visitRealLiteralExp(RealLiteralExp<EClassifier> rl) {
        // TODO Auto-generated method stub
        return super.visitRealLiteralExp(rl);
    }

    @Override
    public Object visitStringLiteralExp(StringLiteralExp<EClassifier> sl) {
        // TODO Auto-generated method stub
        return super.visitStringLiteralExp(sl);
    }

    @Override
    public Object visitBooleanLiteralExp(BooleanLiteralExp<EClassifier> bl) {
        // TODO Auto-generated method stub
        return super.visitBooleanLiteralExp(bl);
    }

    @Override
    public Object visitInvalidLiteralExp(InvalidLiteralExp<EClassifier> il) {
        // TODO Auto-generated method stub
        return super.visitInvalidLiteralExp(il);
    }

    @Override
    public Object visitNullLiteralExp(NullLiteralExp<EClassifier> il) {
        // TODO Auto-generated method stub
        return super.visitNullLiteralExp(il);
    }

    @Override
    public Object visitLetExp(LetExp<EClassifier, EParameter> l) {
        // TODO Auto-generated method stub
        return super.visitLetExp(l);
    }

    @Override
    public Object visitCollectionLiteralExp(CollectionLiteralExp<EClassifier> cl) {
        // TODO Auto-generated method stub
        return super.visitCollectionLiteralExp(cl);
    }

    @Override
    public Object visitTupleLiteralExp(TupleLiteralExp<EClassifier, EStructuralFeature> tl) {
        // TODO Auto-generated method stub
        return super.visitTupleLiteralExp(tl);
    }

    @Override
    public Object visitTupleLiteralPart(TupleLiteralPart<EClassifier, EStructuralFeature> tp) {
        // TODO Auto-generated method stub
        return super.visitTupleLiteralPart(tp);
    }

    public MappingEvaluationVisitor(Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv, Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
        super(env, evalEnv, extentMap);
    }


}
