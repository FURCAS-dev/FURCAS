package de.hpi.sam.bp2009.solution.oclToMqlMapping.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
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
    public boolean wasErrorful(){
        return error;
    }


    @Override
    public Object visitIterateExp(IterateExp<C, PM> ie) {
        error = true;
        return "#error#";

    }


    @Override
    public Object visitIteratorExp(IteratorExp<C, PM> ie) {
        C sourceType = ie.getSource().getType();
        OCLExpression<C> source = ie.getSource();
        OCLExpression<C> body = ie.getBody();
        if (sourceType instanceof PredefinedType<?>) {

            switch (OCLStandardLibraryUtil.getOperationCode(ie.getName())) {
            case PredefinedType.EXISTS:
                return source.accept(this)+"exists"+ body.accept(this);
            case PredefinedType.FOR_ALL:
                return source.accept(this)+"forAll"+ body.accept(this);
            case PredefinedType.SELECT:
                return source.accept(this)+"select"+ body.accept(this);
            case PredefinedType.REJECT:
                return source.accept(this)+"reject"+ body.accept(this);
            case PredefinedType.COLLECT:
                return source.accept(this)+"collect"+ body.accept(this);
            case PredefinedType.COLLECT_NESTED:
                return source.accept(this)+"collectNested"+ body.accept(this);
            case PredefinedType.ONE:
                return source.accept(this)+"one"+ body.accept(this);
            case PredefinedType.ANY:
                return source.accept(this)+"any"+ body.accept(this);
            case PredefinedType.SORTED_BY:
                return source.accept(this)+"sortedBy"+ body.accept(this);
            case PredefinedType.IS_UNIQUE:
                return source.accept(this)+"isUnique"+ body.accept(this);
            case PredefinedType.CLOSURE:
                return source.accept(this)+"closure"+ body.accept(this);
            default: {
                error = true;
                return "#error#";
            }} 
        }
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
        String referEnd="undefinded";
        if(property instanceof EStructuralFeature){
            name = ((EStructuralFeature) property).getName();
//            if (property instanceof EReference){
//                referEnd = ((EReference) property).getEReferenceType().getName();
//                return referEnd;
//                }
        }
        if (source instanceof PropertyCallExp<?, ?>){
            Object refProp = ((PropertyCallExp) source).getReferredProperty();
            if(refProp instanceof EReference){
                Object navigation = source.accept(this);
                 return navigation+"***"+name;    
            }else{
                return source.accept(this)+"."+name;
            }
            }
        else{
        return source.accept(this)+"."+name;}
    }

    @Override
    public Object visitOppositePropertyCallExp(OppositePropertyCallExp<C, P> pc) {
        P property = pc.getReferredOppositeProperty();
        OCLExpression<C> source = pc.getSource();
        String name = "#error#";
        if(property instanceof EStructuralFeature){
            name = ((EStructuralFeature) property).getName();
        }
        return source.accept(this)+"."+name;
    }

    @Override
    public Object visitAssociationClassCallExp(AssociationClassCallExp<C, P> ae) {
    	OCLExpression<C> source = ae.getSource();
    	 String refAssoc = ae.getReferredAssociationClass().toString();
        P navSource = ae.getNavigationSource();
        //TODO return statement need some more/some other information, possible it's wrong
        return refAssoc+","+source.accept(this)+ ","+navSource;
       
    }

    @Override
    public Object visitVariable(Variable<C, PM> vd) {
    	String varName = vd.getName();
        return varName;
    }

    @Override
    public Object visitIfExp(IfExp<C> ie) {
        // TODO check if it is right that a map isn't possible
    	 error = true;
         return "#error#";
    }

    @Override
    public Object visitTypeExp(TypeExp<C> t) {
    	// TODO check if it is possible to map
//    	String refType = t.getReferredType().toString();
//        return refType;
        error = true;
        return "#error#";
    }

    @Override
    public Object visitStateExp(StateExp<C, S> s) {
    	// TODO check if it is possible to map
//    	String refState = s.getReferredState().toString();
//        return refState;
    	error = true;
        return "#error#";
    }

    @Override
    public Object visitMessageExp(MessageExp<C, COA, SSA> m) {
    	error = true;
        return "#error#";
    }

    @Override
    public Object visitUnspecifiedValueExp(UnspecifiedValueExp<C> uv) {
        error = true;
        return "#error#";
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
    	error = true;
        return "#error#";
    }

    @Override
    public Object visitNullLiteralExp(NullLiteralExp<C> il) {
    	error = true;
        return "#error#";
    }

    @Override
    public Object visitLetExp(LetExp<C, PM> l) {
    	Variable<C, PM> vd = l.getVariable();
        String name = (String) vd.accept(getVisitor());
        OCLExpression<C> inExp = l.getIn();
        // TODO check if it is correct or mapping allowed        
        return inExp.accept(this)+name;
       
    }

    @Override
    public Object visitCollectionLiteralExp(CollectionLiteralExp<C> cl) {
        // TODO Auto-generated method stub
//        return super.visitCollectionLiteralExp(cl);
    	error = true;
        return "#error#";
    }

    @Override
    public Object visitTupleLiteralExp(TupleLiteralExp<C, P> tl) {
        // TODO Auto-generated method stub
//        return super.visitTupleLiteralExp(tl);
    	error = true;
        return "#error#";
    }

    @Override
    public Object visitTupleLiteralPart(TupleLiteralPart<C, P> tp) {
        // TODO Auto-generated method stub
//        return super.visitTupleLiteralPart(tp);
    	error = true;
        return "#error#";
    }

    public MqlMapperToString(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
            EvaluationEnvironment<C, O, P, CLS, E> evalEnv, Map<? extends CLS, ? extends Set<? extends E>> extentMap) {
        super(env, evalEnv, extentMap);
    }


}
