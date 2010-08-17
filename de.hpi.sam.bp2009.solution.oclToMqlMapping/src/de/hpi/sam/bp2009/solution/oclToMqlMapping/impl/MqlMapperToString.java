package de.hpi.sam.bp2009.solution.oclToMqlMapping.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
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

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;

// TODO refactor

public class MqlMapperToString extends MappingEvaluationVisitor {
    private EvaluationEnvironment.Enumerations<EEnumLiteral> enumerations;
    private boolean error ;

    @Override
    public Object visitExpression(OCLExpression<EClassifier> expression) {
        return expression.accept(this);
    }
    @Override
    public Object visitOperationCallExp(OperationCallExp<EClassifier, EOperation> oc) {
        OCLExpression<EClassifier> source = oc.getSource();
        int opCode = oc.getOperationCode();
        List<OCLExpression<EClassifier>> args = oc.getArgument();

        switch (opCode){
        case PredefinedType.EQUAL:{
            OCLExpression<EClassifier> arg = args.get(0);
            Object argVal = arg.accept(getVisitor());
            return source.accept(this) + "=" +argVal;
        }
        case PredefinedType.GREATER_THAN:{
            OCLExpression<EClassifier> arg = args.get(0);
            Object argVal = arg.accept(getVisitor());
            return source.accept(this) + ">" +argVal;
        }
        case PredefinedType.GREATER_THAN_EQUAL:{
            OCLExpression<EClassifier> arg = args.get(0);
            Object argVal = arg.accept(getVisitor());
            return source.accept(this) + ">=" +argVal;
        }
        case PredefinedType.LESS_THAN:{
            OCLExpression<EClassifier> arg = args.get(0);
            Object argVal = arg.accept(getVisitor());
            return source.accept(this) + "<" +argVal;
        }
        case PredefinedType.LESS_THAN_EQUAL:{
            OCLExpression<EClassifier> arg = args.get(0);
            Object argVal = arg.accept(getVisitor());
            return source.accept(this) + "<=" +argVal;
        }
        case PredefinedType.NOT_EQUAL:{
            OCLExpression<EClassifier> arg = args.get(0);
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
    public Object visitIterateExp(IterateExp<EClassifier, EParameter> ie) {
        error = true;
        return "#error#";
    }

    @Override
    public Object visitIteratorExp(IteratorExp<EClassifier, EParameter> ie) {
        EClassifier sourceType = ie.getSource().getType();
        OCLExpression<EClassifier> source = ie.getSource();
        OCLExpression<EClassifier> body = ie.getBody();
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
    public Object visitEnumLiteralExp(EnumLiteralExp<EClassifier, EEnumLiteral> el) {
        Object enumLit = (enumerations == null) ? el.getReferredEnumLiteral()
                : enumerations.getValue(el.getReferredEnumLiteral());
        return enumLit;
    }

    @Override
    public Object visitVariableExp(VariableExp<EClassifier, EParameter> v) {
        return v.getName();

    }

    @Override
    public Object visitPropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> pc) {
        EStructuralFeature property = pc.getReferredProperty();
        OCLExpression<EClassifier> source = pc.getSource();
        String name = "undefined";
        
        if(property instanceof EStructuralFeature){
            name = ((EStructuralFeature) property).getName();

        }
        if (source instanceof PropertyCallExp<?, ?>){
            Object refProp = ((PropertyCallExp<?, ?>) source).getReferredProperty();
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
    public Object visitOppositePropertyCallExp(OppositePropertyCallExp pc) {
        EStructuralFeature property = pc.getReferredOppositeProperty();
        OCLExpression<EClassifier> source = pc.getSource();
        String name = "#error#";
        if(property instanceof EStructuralFeature){
            name = ((EStructuralFeature) property).getName();
        }
        return source.accept(this)+"."+name;
    }

    @Override
    public Object visitAssociationClassCallExp(AssociationClassCallExp<EClassifier, EStructuralFeature> ae) {
    	OCLExpression<EClassifier> source = ae.getSource();
    	 String refAssoc = ae.getReferredAssociationClass().toString();
        EStructuralFeature navSource = ae.getNavigationSource();
        //TODO return statement need some more/some other information, possible it's wrong
        return refAssoc+","+source.accept(this)+ ","+navSource;
       
    }

    @Override
    public Object visitVariable(Variable<EClassifier, EParameter> vd) {
    	String varName = vd.getName();
        return varName;
    }

    @Override
    public Object visitIfExp(IfExp<EClassifier> ie) {
        // TODO check if it is right that a map isn't possible
    	 error = true;
         return "#error#";
    }

    @Override
    public Object visitTypeExp(TypeExp<EClassifier> t) {
    	// TODO check if it is possible to map
        error = true;
        return "#error#";
    }

    @Override
    public Object visitStateExp(StateExp<EClassifier, EObject> s) {
    	// TODO check if it is possible to map
    	error = true;
        return "#error#";
    }

    @Override
    public Object visitMessageExp(MessageExp<EClassifier, CallOperationAction, SendSignalAction> m) {
    	error = true;
        return "#error#";
    }

    @Override
    public Object visitUnspecifiedValueExp(UnspecifiedValueExp<EClassifier> uv) {
        error = true;
        return "#error#";
    }

    @Override
    public Object visitIntegerLiteralExp(IntegerLiteralExp<EClassifier> il) {
        String number = il.getIntegerSymbol().toString();
        return number;
    }

    @Override
    public Object visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<EClassifier> literalExp) {
        String naturalLit = literalExp.getIntegerSymbol().toString();
        return naturalLit;
    }

    @Override
    public Object visitRealLiteralExp(RealLiteralExp<EClassifier> rl) {
        String realLit = rl.getRealSymbol().toString();
        return realLit;
    }

    @Override
    public Object visitStringLiteralExp(StringLiteralExp<EClassifier> sl) {
        String stringLit = sl.getStringSymbol();
        return stringLit;
    }

    @Override
    public Object visitBooleanLiteralExp(BooleanLiteralExp<EClassifier> bl) {
        String boolLit = bl.getBooleanSymbol().toString();
        return boolLit;
    }

    @Override
    public Object visitInvalidLiteralExp(InvalidLiteralExp<EClassifier> il) {
    	error = true;
        return "#error#";
    }

    @Override
    public Object visitNullLiteralExp(NullLiteralExp<EClassifier> il) {
    	error = true;
        return "#error#";
    }

    @Override
    public Object visitLetExp(LetExp<EClassifier, EParameter> l) {
    	Variable<EClassifier, EParameter> vd = l.getVariable();
        String name = (String) vd.accept(getVisitor());
        OCLExpression<EClassifier> inExp = l.getIn();
        // TODO check if it is correct or mapping allowed        
        return inExp.accept(this)+name;
       
    }

    @Override
    public Object visitCollectionLiteralExp(CollectionLiteralExp<EClassifier> cl) {
    	error = true;
        return "#error#";
    }

    @Override
    public Object visitTupleLiteralExp(TupleLiteralExp<EClassifier, EStructuralFeature> tl) {
    	error = true;
        return "#error#";
    }

    @Override
    public Object visitTupleLiteralPart(TupleLiteralPart<EClassifier, EStructuralFeature> tp) {
    	error = true;
        return "#error#";
    }

    public MqlMapperToString(Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv, Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
        super(env, evalEnv, extentMap);
    }

}
