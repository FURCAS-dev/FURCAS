package de.hpi.sam.bp2009.solution.oclToMqlMapping.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
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
import org.eclipse.ocl.utilities.PredefinedType;

public class MqlMapperToString<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
extends MappingEvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {




    private EvaluationEnvironment.Enumerations<EL> enumerations;
    private boolean error ;

    @Override
    public Object visitExpression(OCLExpression<C> expression) {
        return expression.accept(this);
    }
    @Override
    public Object visitOperationCallExp(OperationCallExp<C, O> oc) {
        OCLExpression<C> source = oc.getSource();
        int opCode = oc.getOperationCode();
        List<OCLExpression<C>> args = oc.getArgument();
        int numArgs = args.size();
        switch (opCode){
        case PredefinedType.EQUAL:{
            OCLExpression<C> arg = args.get(0);
            Object argVal = arg.accept(getVisitor());
            return source.accept(this) + "=" +argVal;
        }
        case PredefinedType.GREATER_THAN:{
            OCLExpression<C> arg = args.get(0);
            Object argVal = arg.accept(getVisitor());
            return source.accept(this) + ">" +argVal;
        }
        case PredefinedType.GREATER_THAN_EQUAL:{
            OCLExpression<C> arg = args.get(0);
            Object argVal = arg.accept(getVisitor());
            return source.accept(this) + ">=" +argVal;
        }
        case PredefinedType.LESS_THAN:{
            OCLExpression<C> arg = args.get(0);
            Object argVal = arg.accept(getVisitor());
            return source.accept(this) + "<" +argVal;
        }
        case PredefinedType.LESS_THAN_EQUAL:{
            OCLExpression<C> arg = args.get(0);
            Object argVal = arg.accept(getVisitor());
            return source.accept(this) + "<=" +argVal;
        }
        case PredefinedType.NOT_EQUAL:{
            OCLExpression<C> arg = args.get(0);
            Object argVal = arg.accept(getVisitor());
            return source.accept(this) + "!=" +argVal;
        }
        default: {
            error = true;
            return "#error#";
        }
        }

    }
    public boolean wasErrorful (){
        return error;
    }


    @Override
    public Object visitIterateExp(IterateExp<C, PM> ie) {
        error = true;
        return "#error#";
        
    }


    @Override
    public Object visitIteratorExp(IteratorExp<C, PM> ie) {
        error = true;
        return "#error#";

    }

    @Override
    public Object visitEnumLiteralExp(EnumLiteralExp<C, EL> el) {
       Object enumLit = (enumerations == null) ? el.getReferredEnumLiteral()
                : enumerations.getValue(el.getReferredEnumLiteral());
        return enumLit;
    }

    @Override
    public Object visitVariableExp(VariableExp<C, PM> v) {
           return v.getName();
        
    }

    @Override
    public Object visitPropertyCallExp(PropertyCallExp<C, P> pc) {
        P property = pc.getReferredProperty();
        OCLExpression<C> source = pc.getSource();
        String name = "undefined";
        if(property instanceof EStructuralFeature){
        	name = ((EStructuralFeature) property).getName();}
//        OCLExpression<C> derivation = getPropertyBody(property);
//        if(derivation != null){
//        	error = true;
//            return "#error#";
//        }else
        return source.accept(this)+"."+name;
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
        String number = il.getIntegerSymbol().toString();
        return number;
    }

    @Override
    public Object visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<C> literalExp) {
        String naturalLit = literalExp.getIntegerSymbol().toString();
        return naturalLit;
    }

    @Override
    public Object visitRealLiteralExp(RealLiteralExp<C> rl) {
        String realLit = rl.getRealSymbol().toString();
        return realLit;
    }

    @Override
    public Object visitStringLiteralExp(StringLiteralExp<C> sl) {
        String stringLit = sl.getStringSymbol();
        return stringLit;
    }

    @Override
    public Object visitBooleanLiteralExp(BooleanLiteralExp<C> bl) {
        String boolLit = bl.getBooleanSymbol().toString();
        return boolLit;
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

    public MqlMapperToString(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
            EvaluationEnvironment<C, O, P, CLS, E> evalEnv, Map<? extends CLS, ? extends Set<? extends E>> extentMap) {
        super(env, evalEnv, extentMap);
    }


}
