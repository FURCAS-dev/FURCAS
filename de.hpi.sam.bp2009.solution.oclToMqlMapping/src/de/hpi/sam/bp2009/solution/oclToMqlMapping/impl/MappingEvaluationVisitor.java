package de.hpi.sam.bp2009.solution.oclToMqlMapping.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationHaltedException;
import org.eclipse.ocl.EvaluationVisitorImpl;
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
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;

public class MappingEvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
extends EvaluationVisitorImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {

    private boolean noMap=false; ;
    private Object query2Result;



    @Override
    public Object visitExpression(OCLExpression<C> expression) {

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
    public Object visitOperationCallExp(OperationCallExp<C, O> oc) {
        if(wasNoMap()){
            return super.visitOperationCallExp(oc);
        }
        else{
            int opCode = oc.getOperationCode();
            if(opCode==PredefinedType.ALL_INSTANCES){
                Set<EObject> allO = new HashSet<EObject>();

                if(!getExtentMap().values().isEmpty()){
                    /*
                     * TODO  why only take the first EClassifier as COntext
                     */
                    Iterator<? extends E> list = getExtentMap().values().iterator().next().iterator();
                    while(list.hasNext())
                        allO.add((EObject)list.next());
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
                    IteratorExp<C, PM> ie = (IteratorExp<C, PM>) oc.eContainer();
                    OCLExpression<C> body = ie.getBody();
                    query2Result = Query2.buildMqlQuery(allO, ocType, body, ie, this); 
                    if (query2Result == null){
                        //if the query2 fail traverse the AST from beginning
                        noMap = true;
                        OCLExpression<C> oclExp = (OCLExpression<C>) oc.eContainer();
                        return visitExpression(oclExp);}
                    else
                        return query2Result;

                }else{
                    // if the expression has another form, traverse the AST from beginning
                    noMap=true;
                    OCLExpression<C> oclExp = (OCLExpression<C>) oc.eContainer();
                    return visitExpression(oclExp);
                }

            }else{
                //if there isn't any allInstances()
                noMap=true;
                OCLExpression<C> oclExp = (OCLExpression<C>) oc.eContainer();
                return visitExpression(oclExp);
            }
        }
    }

    @Override
    public Object visitIterateExp(IterateExp<C, PM> ie) {
        // TODO Auto-generated method stub
        return super.visitIterateExp(ie);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object visitIteratorExp(IteratorExp<C, PM> ie) {

        if(wasNoMap()){
            return super.visitIteratorExp(ie);
        }
        else{
            if (ie.getSource() instanceof OperationCallExp<?, ?>){
                switch (OCLStandardLibraryUtil.getOperationCode(ie.getName())) {
                case PredefinedType.EXISTS:
                    return visitOperationCallExp((OperationCallExp<C, O>) ie.getSource());
                case PredefinedType.FOR_ALL:
                    return visitOperationCallExp((OperationCallExp<C, O>) ie.getSource());
                case PredefinedType.SELECT:
                    return visitOperationCallExp((OperationCallExp<C, O>) ie.getSource());
                    //            case PredefinedType.REJECT:
                    //                return visitOperationCallExp((OperationCallExp<C, O>) ie.getSource());
                case PredefinedType.COLLECT:
                    return visitOperationCallExp((OperationCallExp<C, O>) ie.getSource());
                case PredefinedType.COLLECT_NESTED:
                    return visitOperationCallExp((OperationCallExp<C, O>) ie.getSource());
                    //            case PredefinedType.ONE:
                    //                return visitOperationCallExp((OperationCallExp<C, O>) ie.getSource());
                case PredefinedType.ANY:
                    return visitOperationCallExp((OperationCallExp<C, O>) ie.getSource());
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
    public Object visitEnumLiteralExp(EnumLiteralExp<C, EL> el) {
        // TODO Auto-generated method stub
        return super.visitEnumLiteralExp(el);
    }

    @Override
    public Object visitVariableExp(VariableExp<C, PM> v) {
        // TODO Auto-generated method stub
        return super.visitVariableExp(v);
    }

    @Override
    public Object visitPropertyCallExp(PropertyCallExp<C, P> pc) {
        // TODO Auto-generated method stub
        return super.visitPropertyCallExp(pc);
    }

    @Override
    public Object visitOppositePropertyCallExp(OppositePropertyCallExp<C, P> pc) {
        // TODO Auto-generated method stub
        return super.visitOppositePropertyCallExp(pc);
    }

    @Override
    public Object visitAssociationClassCallExp(AssociationClassCallExp<C, P> ae) {
        // TODO Auto-generated method stub
        return super.visitAssociationClassCallExp(ae);
    }

    @Override
    public Object visitVariable(Variable<C, PM> vd) {
        // TODO Auto-generated method stub
        return super.visitVariable(vd);
    }

    @Override
    public Object visitIfExp(IfExp<C> ie) {
        // TODO Auto-generated method stub
        return super.visitIfExp(ie);
    }

    @Override
    public Object visitTypeExp(TypeExp<C> t) {
        // TODO Auto-generated method stub
        return super.visitTypeExp(t);
    }

    @Override
    public Object visitStateExp(StateExp<C, S> s) {
        // TODO Auto-generated method stub
        return super.visitStateExp(s);
    }

    @Override
    public Object visitMessageExp(MessageExp<C, COA, SSA> m) {
        // TODO Auto-generated method stub
        return super.visitMessageExp(m);
    }

    @Override
    public Object visitUnspecifiedValueExp(UnspecifiedValueExp<C> uv) {
        // TODO Auto-generated method stub
        return super.visitUnspecifiedValueExp(uv);
    }

    @Override
    public Object visitIntegerLiteralExp(IntegerLiteralExp<C> il) {
        // TODO Auto-generated method stub
        return super.visitIntegerLiteralExp(il);
    }

    @Override
    public Object visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<C> literalExp) {
        // TODO Auto-generated method stub
        return super.visitUnlimitedNaturalLiteralExp(literalExp);
    }

    @Override
    public Object visitRealLiteralExp(RealLiteralExp<C> rl) {
        // TODO Auto-generated method stub
        return super.visitRealLiteralExp(rl);
    }

    @Override
    public Object visitStringLiteralExp(StringLiteralExp<C> sl) {
        // TODO Auto-generated method stub
        return super.visitStringLiteralExp(sl);
    }

    @Override
    public Object visitBooleanLiteralExp(BooleanLiteralExp<C> bl) {
        // TODO Auto-generated method stub
        return super.visitBooleanLiteralExp(bl);
    }

    @Override
    public Object visitInvalidLiteralExp(InvalidLiteralExp<C> il) {
        // TODO Auto-generated method stub
        return super.visitInvalidLiteralExp(il);
    }

    @Override
    public Object visitNullLiteralExp(NullLiteralExp<C> il) {
        // TODO Auto-generated method stub
        return super.visitNullLiteralExp(il);
    }

    @Override
    public Object visitLetExp(LetExp<C, PM> l) {
        // TODO Auto-generated method stub
        return super.visitLetExp(l);
    }

    @Override
    public Object visitCollectionLiteralExp(CollectionLiteralExp<C> cl) {
        // TODO Auto-generated method stub
        return super.visitCollectionLiteralExp(cl);
    }

    @Override
    public Object visitTupleLiteralExp(TupleLiteralExp<C, P> tl) {
        // TODO Auto-generated method stub
        return super.visitTupleLiteralExp(tl);
    }

    @Override
    public Object visitTupleLiteralPart(TupleLiteralPart<C, P> tp) {
        // TODO Auto-generated method stub
        return super.visitTupleLiteralPart(tp);
    }

    public MappingEvaluationVisitor(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
            EvaluationEnvironment<C, O, P, CLS, E> evalEnv, Map<? extends CLS, ? extends Set<? extends E>> extentMap) {
        super(env, evalEnv, extentMap);
    }


}
