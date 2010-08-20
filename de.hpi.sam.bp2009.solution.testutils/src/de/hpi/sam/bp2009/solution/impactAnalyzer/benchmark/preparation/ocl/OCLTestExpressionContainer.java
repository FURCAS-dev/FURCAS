package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EPackage;

/**
 * The {@link OCLTestExpressionContainer} contains a bunch of OCL expressions in textual form
 * which were manually extracted out of the FURCAS/MOIN Class.tcs file.
 *
 * @author Manuel Holzleitner (D049667)
 */
public class OCLTestExpressionContainer {
    //template TypeAdapter #implements
    private final ArrayList<OclExpressionWithPackage> EXPRESSION_LIST = new ArrayList<OclExpressionWithPackage>();

    public static ArrayList<OclExpressionWithPackage> getExpressionList(){
	return (new OCLTestExpressionContainer()).EXPRESSION_LIST;
    }

    public OCLTestExpressionContainer() {

	EXPRESSION_LIST.add(new OclExpressionWithPackage("context TypeAdapter inv: SapClass.allInstances()->select(c | c.name = 'xxx')", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage("context data::classes::TypeAdapter inv: 'From_'.concat(self.adapted.name).concat('_to_').concat(self.to.name)", data.classes.ClassesPackage.eINSTANCE));

                //template MethodSignature(disambiguateV3 = "data_classes_methodsignature") context

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::classes::MethodSignature inv: self.owner", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #converter context

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::classes::ClassTypeDefinition inv: self.signaturesWithOutput->asSequence()->first().input", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::classes::ClassTypeDefinition inv: self.ownedObjectParameters", data.classes.ClassesPackage.eINSTANCE));

                //template ActualObjectParameter #converter

        //FIXME: foreach unklarheit
        //EXPRESSION_LIST.add(new OclExpressionWithPackage( "context Parameter inv: let sig:MethodSignature = self.ownerSignature.oclAsType(MethodSignature) in sig.owner.oclAsType(SapClass).formalObjectParameters->at(sig.input->indexOf(#foreach(Parameter)))", data.classes.ClassesPackage.eINSTANCE));

                //operatorTemplate FunctionCallExpression(operators = lparen, source = 'calledBlock')

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::FunctionCallExpression inv: self.getSignature().output", dataaccess.expressions.ExpressionsPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::FunctionCallExpression inv: self.getSignature().output.isMany() and self.calledBlock.getType().isMany()", dataaccess.expressions.ExpressionsPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::FunctionCallExpression inv: self.getSignature().output.oclIsKindOf(data::classes::ClassTypeDefinition)", dataaccess.expressions.ExpressionsPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::FunctionCallExpression inv: self.getSignature().output.oclIsKindOf(data::classes::FunctionSignatureTypeDefinition)", dataaccess.expressions.ExpressionsPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::FunctionCallExpression inv: self.getSignature().output.oclIsKindOf(data::classes::NestedTypeDefinition)", dataaccess.expressions.ExpressionsPackage.eINSTANCE));

                //template ClassTypeDefinition #functionCallExpression (disambiguateV3="'___1000___'")

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output.oclAsType(ClassTypeDefinition).clazz", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output.oclAsType(ClassTypeDefinition).objectParameters", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output.lowerMultiplicity * self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).calledBlock.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: if self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output.isMany() or self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).calledBlock.getType().isMany() then -1 else self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output.upperMultiplicity * self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).calledBlock.getType().upperMultiplicity endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output.ordered or self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).calledBlock.getType().ordered", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output.unique and not self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).calledBlock.getType().isMany()", data.classes.ClassesPackage.eINSTANCE));

                //template FunctionSignatureTypeDefinition #functionCallExpression (disambiguateV3="'___2000___'")

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output.oclAsType(FunctionSignatureTypeDefinition).signature", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output.lowerMultiplicity * self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).calledBlock.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: if self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output.isMany() or self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).calledBlock.getType().isMany() then -1 else self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output.upperMultiplicity * self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).calledBlock.getType().upperMultiplicity endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output.ordered or self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).calledBlock.getType().ordered", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output.unique and not self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).calledBlock.getType().isMany()", data.classes.ClassesPackage.eINSTANCE));

                //template NestedTypeDefinition #functionCallExpression (disambiguateV3="'___3000___'")

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).calledBlock.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).calledBlock.getType().upperMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).calledBlock.getType().ordered", data.classes.ClassesPackage.eINSTANCE));

                //template NestedTypeDefinition #functionCallExpressionNoFurtherNesting (disambiguateV3="'___4000___'")

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output.oclAsType(NestedTypeDefinition).type", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output.lowerMultiplicity * self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).calledBlock.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).calledBlock.getType().upperMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output.ordered or self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).calledBlock.getType().ordered", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).getSignature().output.unique and not self.ownerTypedElement.oclAsType(dataaccess::expressions::FunctionCallExpression).calledBlock.getType().isMany()", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.getNamedValuesInScope()", data.classes.ClassesPackage.eINSTANCE));

                //template AddLink

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context AddLink inv: self.objects->at(1).getType().oclAsType(data::classes::ClassTypeDefinition).clazz.getAssociationEnds()", behavioral.actions.ActionsPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context AddLink inv: self.objects->at(1).getType().oclAsType(data::classes::ClassTypeDefinition).clazz.getAssociationEnds()", behavioral.actions.ActionsPackage.eINSTANCE));

                //template ClassTypeDefinition #property context

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.associationEnd.otherEnd().type.unique", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.oclAsType(data::classes::SapClass).formalObjectParameters", data.classes.ClassesPackage.eINSTANCE));

                //template data::classes::Association #property

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::classes::Association inv: self.oclAsType(data::classes::SapClass).package_", data.classes.ClassesPackage.eINSTANCE));

                //template MethodSignature #propertyGetter
        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context MethodSignature inv: '.'.concat(self.oclAsType(data::classes::AssociationEnd).name)", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context MethodSignature inv: self.oclAsType(data::classes::AssociationEnd).type", data.classes.ClassesPackage.eINSTANCE));

                //template MethodSignature #propertySetter

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context MethodSignature inv: self.oclAsType(data::classes::AssociationEnd).name.concat('=')", data.classes.ClassesPackage.eINSTANCE));

                //template MethodSignature #propertyAdder

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context MethodSignature inv: self.oclAsType(data::classes::AssociationEnd).name.concat('+=')", data.classes.ClassesPackage.eINSTANCE));

                //template MethodSignature #propertyRemover

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context MethodSignature inv: self.oclAsType(data::classes::AssociationEnd).name.concat('-=')", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #objectCount

       EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: data::classes::SapClass.allInstances()->select(c | c.name = 'Number')", data.classes.ClassesPackage.eINSTANCE));

        // Begin of OBJECT BASED EXPRESSIONS
                //operatorTemplate MethodCallExpression(operators = dotOp, source='object',

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::MethodCallExpression inv: self.object.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.allSignatures()", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::MethodCallExpression inv: self.object.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.allSignatures()->select(s | s.name = 'xxx'.concat('=')) ", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::MethodCallExpression inv: self.object.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.allSignatures()->select(s | s.name = 'xxx'.concat('+='))", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::MethodCallExpression inv: self.object.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.allSignatures()->select(s | s.name = 'xxx'.concat('-='))", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::MethodCallExpression inv: self.object.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.allSignatures()->select(s | s.name = '.'.concat('xxx'))", data.classes.ClassesPackage.eINSTANCE));


        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::MethodCallExpression inv: methodSignature.output", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::MethodCallExpression inv: methodSignature.output.isMany() and self.object.getType().isMany()", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::MethodCallExpression inv: methodSignature.output.oclIsKindOf(ClassTypeDefinition)", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::MethodCallExpression inv: methodSignature.output.oclIsKindOf(FunctionSignatureTypeDefinition)", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::MethodCallExpression inv: methodSignature.output.oclIsKindOf(NestedTypeDefinition)", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #methodCallExpression (disambiguateV3="'___1000___'")

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.oclAsType(ClassTypeDefinition).clazz", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.oclAsType(ClassTypeDefinition).objectParameters", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.lowerMultiplicity * self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: if self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.isMany() or self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().isMany() then -1 else self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.upperMultiplicity * self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().upperMultiplicity endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.ordered or self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().ordered", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.unique and not self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().isMany()", data.classes.ClassesPackage.eINSTANCE));

                //template FunctionSignatureTypeDefinition #methodCallExpression (disambiguateV3="'___2000___'")

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.oclAsType(FunctionSignatureTypeDefinition).signature", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.lowerMultiplicity * self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: if self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.isMany() or self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().isMany() then -1 else self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.upperMultiplicity * self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().upperMultiplicity endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.ordered or self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().ordered", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.unique and not self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().isMany()", data.classes.ClassesPackage.eINSTANCE));

                //template NestedTypeDefinition #methodCallExpression (disambiguateV3="'___3000___'")

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().upperMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().ordered", data.classes.ClassesPackage.eINSTANCE));

                //template NestedTypeDefinition #methodCallExpressionNoFurtherNesting (disambiguateV3="'___4000___'")

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.oclAsType(NestedTypeDefinition).type", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.lowerMultiplicity * self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().upperMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.ordered or self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().ordered", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).methodSignature.output.unique and not self.ownerTypedElement.oclAsType(dataaccess::expressions::MethodCallExpression).object.getType().isMany()", data.classes.ClassesPackage.eINSTANCE));

        // Outcommented in tcs:
        //EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.object.type.oclAsType(data::classes::ClassTypeDefinition).clazz.associationEnds->select(e | e.name = 'xxx')", data.classes.ClassesPackage.eINSTANCE));

        // End of OBJECT BASED EXPRESSIONS

                //template VariableExpression

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::VariableExpression inv: self.getNamedValuesInScope()->select(nv | nv.name= 'xxx')", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::classes::FunctionSignature inv: self.implementation.oclAsType(CellSet).aggregationFunction.output", dataaccess.analytics.AnalyticsPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::classes::FunctionSignature inv: self.implementation.isSideEffectFree()", data.classes.ClassesPackage.eINSTANCE));

                //operatorTemplate fp::FunctionFromMethodExpr(operators = dcolonOp, source='object') context
        //FIXME: Operator template
       // EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::fp::FunctionFromMethodExpr self.object.getType().oclAsType(ClassTypeDefinition).clazz.allSignatures()->select(s | s.name = 'xxx')", data.classes.ClassesPackage.eINSTANCE));

                //template FunctionSignatureTypeDefinition #functionFromMethodExpr

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.oclAsType(dataaccess::expressions::fp::FunctionFromMethodExpr).method", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.oclAsType(dataaccess::expressions::fp::FunctionFromMethodExpr).object.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.oclAsType(dataaccess::expressions::fp::FunctionFromMethodExpr).object.getType().upperMultiplicity", data.classes.ClassesPackage.eINSTANCE));

                //template ObjectCreationExpression context

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::ObjectCreationExpression inv: data::classes::SapClass.allInstances()->select(c | c.name = 'xxx')", data.classes.ClassesPackage.eINSTANCE));

                //template ParameterizedClassInstantiation #objectCreationExpression

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ParameterizedClassInstantiation inv: data::classes::SapClass.allInstances()->select(c |c.isParameterizedClassDefinition())->select(c | c.name = 'xxx')", data.generics.GenericsPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ParameterizedClassInstantiation inv: self.oclAsType(data::classes::SapClass).package_", data.generics.GenericsPackage.eINSTANCE));

                //template MethodCallExpression #objectCreationExpression

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::MethodCallExpression inv: self.object.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.allSignatures()->select(s | s.name = 'xxx'.concat('='))", data.classes.ClassesPackage.eINSTANCE));

            //template ActualTypeParameter

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::generics::ActualTypeParameter inv: data::classes::SapClass.allInstances()->select(c | c.name = 'xxx')", data.classes.ClassesPackage.eINSTANCE));

        //TODO: correct
    /* "Sequence{ 1..self.parameterizedClassInstantiation.parameterizedClass.parameterization.formalTypeParameters->size()}
                                                                                        ->select( i | self.parameterizedClassInstantiation.actualTypeParametersForInstantiation->asSequence()->at(i) = self)
                                                                                        ->collect( j | self.parameterizedClassInstantiation.parameterizedClass.parameterization.formalTypeParameters->at(j))") }}", data.classes.ClassesPackage.eINSTANCE));
    */
                //template ClassTypeDefinition #objectCreationExpression

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownedObjectParameters", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::ObjectCreationExpression).classToInstantiate", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #thisInObjectCreationExpression

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.oclAsType(dataaccess::expressions::ObjectCreationExpression).classToInstantiate", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.oclAsType(dataaccess::expressions::ObjectCreationExpression).classToInstantiate.formalObjectParameters", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownedObjectParameters", data.classes.ClassesPackage.eINSTANCE));

                //template ActualObjectParameter

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ActualObjectParameter inv: self.owningClassTypeDefinition.clazz.formalObjectParameters->at(self.owningClassTypeDefinition.objectParameters->indexOf(self))", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #this

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.oclAsType(data::classes::SapClass).formalObjectParameters", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownedObjectParameters", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #commit

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: data::classes::SapClass.allInstances()->select(c | c.name = 'Snapshot')", data.classes.ClassesPackage.eINSTANCE));

                //template All context(allQuery)

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context All inv: data::classes::SapClass.allInstances()->select(c | c.name = 'xxx')", persistence.expressions.ExpressionsPackage.eINSTANCE));

                //template ClassTypeDefinition #allQuery

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.oclAsType(persistence::expressions::All).ofClass", data.classes.ClassesPackage.eINSTANCE));

        // Begin of COLLECTION EXPRESSIONS

                //operatorTemplate Including (operators = arrowOp, source = 'source')
        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::collectionexpressions::Including inv: self.source.getType()", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::collectionexpressions::IncludingAt inv: self.source.getType()", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::collectionexpressions::IncludingAt inv: self.source.getType().getNestingLevel() < self.argument.getType().getNestingLevel()", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::collectionexpressions::IncludingAt inv: self.source.getType().oclIsKindOf(ClassTypeDefinition)", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::collectionexpressions::IncludingAt inv: self.source.getType().oclIsKindOf(FunctionSignatureTypeDefinition)", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::collectionexpressions::IncludingAt inv: self.source.getType().oclIsKindOf(NestedTypeDefinition)", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #includingExpression (disambiguateV3="'___1002___'")

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().oclAsType(ClassTypeDefinition).clazz", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().oclAsType(ClassTypeDefinition).objectParameters", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: if (self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().upperMultiplicity < 0)  or (self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).argument.getType().upperMultiplicity < 0) then \n"+
                                                          "-1 \n"+
                                                        "else \n"+
                                                          "self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().upperMultiplicity + self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).argument.getType().upperMultiplicity\n"+
                                                        "endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().ordered", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().unique", data.classes.ClassesPackage.eINSTANCE));

                //template FunctionSignatureTypeDefinition #includingExpression (disambiguateV3="'___2002___'")

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().oclAsType(FunctionSignatureTypeDefinition).signature", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: if (self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().upperMultiplicity < 0)  or (self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).argument.getType().upperMultiplicity < 0) then\n"+
                                                          "-1\n"+
                                                        "else\n"+
                                                          "self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::CollectionExpression).source.getType().upperMultiplicity + self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).argument.getType().upperMultiplicity\n"+
                                                        "endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::CollectionExpression).source.getType().ordered", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::CollectionExpression).source.getType().unique", data.classes.ClassesPackage.eINSTANCE));

                //template NestedTypeDefinition #includingExpression (disambiguateV3="'___3002___'")

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().oclAsType(NestedTypeDefinition).type", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv:  if (self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().upperMultiplicity < 0)  or (self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).argument.getType().upperMultiplicity < 0) then \n"+
                                                          "-1 \n"+
                                                        "else \n"+
                                                          "self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().upperMultiplicity + self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).argument.getType().upperMultiplicity \n"+
                                                        "endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().ordered", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().unique", data.classes.ClassesPackage.eINSTANCE));

                //template NestedTypeDefinition #includingExpressionNewNestedType (disambiguateV3="'___4002___'")

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).argument.getType().oclAsType(NestedTypeDefinition).type", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: if (self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().upperMultiplicity < 0)  or (self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).argument.getType().upperMultiplicity < 0) then \n"+
                                                          "-1 \n"+
                                                        "else \n"+
                                                          "self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).source.getType().upperMultiplicity + self.ownerTypedElement.oclAsType(dataaccess::expressions::collectionexpressions::Including).argument.getType().upperMultiplicity \n"+
                                                        "endif", data.classes.ClassesPackage.eINSTANCE));

                //template Iterator context(behavioral::actions::Iterator)

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context Iterator inv: self.iterate.source.getType()->select(td | td.isMany() and not td.oclIsKindOf(data::classes::NestedTypeDefinition))", behavioral.actions.ActionsPackage.eINSTANCE));

                //template Iterator #selection context

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context Iterator inv: self.selection.object.getType()->select(td | td.isMany() and not td.oclIsKindOf(data::classes::NestedTypeDefinition))", behavioral.actions.ActionsPackage.eINSTANCE));

                //template ClassTypeDefinition #singleFromMany

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.clazz", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.objectParameters", data.classes.ClassesPackage.eINSTANCE));

                //template FunctionSignatureTypeDefinition #singleFromMany

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.signature", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #manyFromSingle

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.clazz", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.objectParameters", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ordered", data.classes.ClassesPackage.eINSTANCE));

                //template FunctionSignatureTypeDefinition #manyFromSingle

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.signature", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.ordered", data.classes.ClassesPackage.eINSTANCE));

                //template NestedTypeDefinition #manyFromSingle

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: TypeDefinition", data.classes.ClassesPackage.eINSTANCE));

                //template OqlQuery context(oqlQuery)

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context OqlQuery inv: self.fromClause.fromClauseOfOqlQuery.fromClauses.alias->select(i|i.name='xxx')", dataaccess.query.QueryPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context OqlQuery inv: self.fromClauses.alias", dataaccess.query.QueryPackage.eINSTANCE));

                //template behavioral::actions::Iterator #fromClause context(behavioral::actions::IteratorFromClause)

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context behavioral::actions::Iterator inv: if self.fromClause.fromExpression.getType().oclIsKindOf(data::classes::NestedTypeDefinition) then self.fromClause.fromExpression.getType().oclAsType(data::classes::NestedTypeDefinition).type \n"+
                                                                                                "else \n"+
                                                                                                      "  self.fromClause.fromExpression.getType() \n"+
                                                                                                "endif", behavioral.actions.ActionsPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: if self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                                                          "self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::NestedTypeDefinition).type.oclAsType(data::classes::ClassTypeDefinition).clazz \n"+
                                                                  "else \n"+
                                                                      "self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::ClassTypeDefinition).clazz \n"+
                                                                  "endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: if self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                                                        "  self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::NestedTypeDefinition).type.oclAsType(data::classes::ClassTypeDefinition).objectParameters \n"+
                                                                  "else \n"+
                                                                      "self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::ClassTypeDefinition).objectParameters \n"+
                                                                  "endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: if self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                                                   "       self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::NestedTypeDefinition).type.lowerMultiplicity \n"+
                                                                  "else \n"+
                                                                  "    1 \n"+
                                                                  "endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: if self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                                                          "self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::NestedTypeDefinition).type.oclAsType(data::classes::ClassTypeDefinition).upperMultiplicity \n"+
                                                                  "else \n"+
                                                                      "1 \n"+
                                                                  "endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: if self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                                                          "self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::NestedTypeDefinition).type.ordered \n"+
                                                                  "else \n"+
                                                                      "false \n"+
                                                                  "endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: if self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                                                          "self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::NestedTypeDefinition).type.unique \n"+
                                                                  "else \n"+
                                                                      "false \n"+
                                                                  "endif", data.classes.ClassesPackage.eINSTANCE));

                //template FunctionSignatureTypeDefinition #iteratorFromClause

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: if self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                                                          "self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::NestedTypeDefinition).type.oclAsType(FunctionSignatureTypeDefinition).signature \n"+
                                                                  "else \n"+
                                                                      "self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(FunctionSignatureTypeDefinition).signature \n"+
                                                                  "endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: if self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                                                          "self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::NestedTypeDefinition).type.lowerMultiplicity \n"+
                                                                  "else \n"+
                                                                      "1 \n"+
                                                                  "endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: if self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                                                          "self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::NestedTypeDefinition).type.upperMultiplicity \n"+
                                                                  "else \n"+
                                                                  "    1 \n"+
                                                                  "endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: if self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                                                         " self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::NestedTypeDefinition).type.ordered \n"+
                                                                  "else \n"+
                                                                     " false \n"+
                                                                  "endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: if self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                                                       "   self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::NestedTypeDefinition).type.unique \n"+
                                                                  "else \n"+
                                                                    "  false \n"+
                                                                  "endif", data.classes.ClassesPackage.eINSTANCE));

                //template NestedTypeDefinition #iteratorFromClause

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::NestedTypeDefinition).type", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::NestedTypeDefinition).type.lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::NestedTypeDefinition).type.upperMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::NestedTypeDefinition).type.ordered", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(behavioral::actions::Iterator).fromClause.fromExpression.getType().oclAsType(data::classes::NestedTypeDefinition).type.unique", data.classes.ClassesPackage.eINSTANCE));

                //template SapClass #oqlQueryResult context

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context OqlQuery inv: self.oclAsType(OqlQuery).selected", dataaccess.query.QueryPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context SapClass inv: self.elementsOfType.ownerTypedElement.oclAsType(dataaccess::query::OqlQuery).fromClauses.alias->iterate(i; acc:String='QueryResult' | acc.concat('_').concat(i.name))", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context SapClass inv: self.oclAsType(SapClass).package_", data.classes.ClassesPackage.eINSTANCE));

                //template data::classes::AssociationEnd #oqlQueryResultProperties

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::classes::AssociationEnd inv: 'opposite_of_'.concat(self.oclAsType(behavioral::actions::Iterator).name)", data.classes.ClassesPackage.eINSTANCE));

                //template data::classes::Association #oqlQueryResultProperties

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::classes::Association inv: 'Query_to_'.concat(self.ends->first().name)", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::classes::Association inv: self.oclAsType(SapClass).package_", data.classes.ClassesPackage.eINSTANCE));

                //template data::classes::AssociationEnd #oqlQueryResultPropertiesOtherEnd

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::classes::AssociationEnd inv: self.oclAsType(behavioral::actions::Iterator).name", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::classes::AssociationEnd inv: self.oclAsType(behavioral::actions::Iterator).getType()", data.classes.ClassesPackage.eINSTANCE));

                //template MethodSignature #oqlQueryResultProperties

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context MethodSignature inv: '.'.concat(self.oclAsType(behavioral::actions::Iterator).name)", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context MethodSignature inv: self.oclAsType(behavioral::actions::Iterator).fromClause.fromClauseOfOqlQuery.getType().oclAsType(data::classes::ClassTypeDefinition).clazz", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context MethodSignature inv: self.implementation.oclAsType(LinkTraversal).end.type", data.classes.ClassesPackage.eINSTANCE));

                //template TypeDefinition #oqlQueryResultAssociationEndType abstract;
                //template ClassTypeDefinition #oqlQueryResultAssociationEndType

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.oclAsType(behavioral::actions::Iterator).getType().oclAsType(data::classes::ClassTypeDefinition).clazz", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.oclAsType(behavioral::actions::Iterator).getType().oclAsType(data::classes::ClassTypeDefinition).objectParameters", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.oclAsType(behavioral::actions::Iterator).getType().oclAsType(data::classes::ClassTypeDefinition).lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.oclAsType(behavioral::actions::Iterator).getType().oclAsType(data::classes::ClassTypeDefinition).upperMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.oclAsType(behavioral::actions::Iterator).getType().oclAsType(data::classes::ClassTypeDefinition).ordered", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.oclAsType(behavioral::actions::Iterator).getType().oclAsType(data::classes::ClassTypeDefinition).unique", data.classes.ClassesPackage.eINSTANCE));

        // Begin of COLLECTION EXPRESSIONS
                //template ClassTypeDefinition #Snapshot

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.oclAsType(persistence::expressions::Snapshot).object.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.oclAsType(persistence::expressions::Snapshot).object.getType().upperMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.oclAsType(persistence::expressions::Snapshot).object.getType().ordered", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: data::classes::SapClass.allInstances()->select(c | c.name = 'Snapshot')", data.classes.ClassesPackage.eINSTANCE));

                //template NavigationStep

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::NavigationStep inv: let i : Integer = self.replace.steps->indexOf(self) in \n"+
                                      "   let t : ClassTypeDefinition =  \n"+
                                               " if i=1 then  \n"+
                                              "          self.replace.object.getType().oclAsType(data::classes::ClassTypeDefinition)  \n"+
                                              "  else  \n"+
                                              "          self.replace.steps->at(-1 + i).to.type \n"+
                                              "  endif in \n"+
                                              "          t.clazz.getConformingClasses().getAssociationEnds().otherEnd()", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::Map inv: self.argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::Map inv: self.argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.isMany() and self.object.getType().isMany()", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::Map inv: self.argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.oclIsKindOf(data::classes::ClassTypeDefinition)", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::Map inv: self.argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.oclIsKindOf(FunctionSignatureTypeDefinition)", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::Map inv: self.argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.oclIsKindOf(data::classes::NestedTypeDefinition)", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #map (disambiguateV3="'___1000___'")

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.oclAsType(data::classes::ClassTypeDefinition).clazz", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.oclAsType(data::classes::ClassTypeDefinition).objectParameters", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.lowerMultiplicity * self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).object.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: if self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.isMany() or self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).object.getType().isMany() then -1 else self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.upperMultiplicity * self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).object.getType().upperMultiplicity endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.ordered or self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).object.getType().ordered", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.unique and not self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).object.getType().isMany()", data.classes.ClassesPackage.eINSTANCE));

                //template FunctionSignatureTypeDefinition #map (disambiguateV3="'___2000___'")

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.oclAsType(FunctionSignatureTypeDefinition).signature", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.lowerMultiplicity * self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).object.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: if self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.isMany() or self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).object.getType().isMany() then -1 else self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.upperMultiplicity * self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).object.getType().upperMultiplicity endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.ordered or self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).object.getType().ordered", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignatureTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.unique and not self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).object.getType().isMany()", data.classes.ClassesPackage.eINSTANCE));

                //template NestedTypeDefinition #map (disambiguateV3="'___3000___'")

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).object.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).object.getType().upperMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).object.getType().ordered", data.classes.ClassesPackage.eINSTANCE));

                //template NestedTypeDefinition #mapNoFurtherNesting (disambiguateV3="'___4000___'")

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.oclAsType(data::classes::NestedTypeDefinition).type", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.lowerMultiplicity * self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).object.getType().lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).object.getType().upperMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.ordered or self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).object.getType().ordered", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context NestedTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.output.unique and not self.ownerTypedElement.oclAsType(dataaccess::expressions::Map).object.getType().isMany()", data.classes.ClassesPackage.eINSTANCE));

        //Begin of ANALYTICS EXPRESSIONS

            //template dataaccess::analytics::GroupBy context(dataaccess::analytics::GroupBy)

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::analytics::GroupBy inv: self.mapExpression.getType()", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::analytics::GroupBy inv: not self.mapExpression.getType().isMany() and self.mapExpression.getType().oclIsKindOf(data::classes::ClassTypeDefinition)", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::analytics::GroupBy inv: not self.mapExpression.getType().isMany() and self.mapExpression.getType().oclIsKindOf(FunctionSignatureTypeDefinition)", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::analytics::GroupBy inv: self.object.getType()", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::analytics::GroupBy inv: not self.object.getType().isMany() and self.object.getType().oclIsKindOf(data::classes::ClassTypeDefinition)", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::analytics::GroupBy inv: not self.object.getType().isMany() and self.object.getType().oclIsKindOf(FunctionSignatureTypeDefinition)", data.classes.ClassesPackage.eINSTANCE));

            //template behavioral::actions::Iterator #groupByFactIterator context

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context behavioral::actions::Iterator inv: self.factOfGroupBy.object.getType()->select(td | td.isMany() and not td.oclIsKindOf(data::classes::NestedTypeDefinition))", data.classes.ClassesPackage.eINSTANCE));

            //template behavioral::actions::Iterator #groupByGroupedFactsIterator

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context behavioral::actions::Iterator inv: self.groupedFactsOfGroupBy.object.getType()", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context behavioral::actions::Iterator inv: not self.groupedFactsOfGroupBy.object.getType().isMany() and self.groupedFactsOfGroupBy.object.getType().oclIsKindOf(data::classes::ClassTypeDefinition)", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context behavioral::actions::Iterator inv: not self.groupedFactsOfGroupBy.object.getType().isMany() and self.groupedFactsOfGroupBy.object.getType().oclIsKindOf(FunctionSignatureTypeDefinition)", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #groupByMapResult

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownerTypedElement.oclAsType(dataaccess::expressions::literals::ObjectLiteral).valueClass", data.classes.ClassesPackage.eINSTANCE));

                //template data::classes::Association #groupByMapResultProperties

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::classes::Association inv: 'Query_to_'.concat(self.ends->last().name)", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::classes::Association inv: self.ends->select(e | e.type.oclAsType(data::classes::ClassTypeDefinition).clazz.objectLiteral->notEmpty()).type.oclAsType(data::classes::ClassTypeDefinition).clazz.package_", data.classes.ClassesPackage.eINSTANCE));

                //template data::classes::AssociationEnd #groupByMapResultPropertiesLocalEnd

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::classes::AssociationEnd inv: if self.name->notEmpty() then if self.name.substring(1,12) = 'opposite_of_' then \n"+
                                             "     self.name \n"+
                                    "            else \n"+
                                    "             'opposite_of_'.concat(self.otherEnd().name) \n"+
                                    "            endif \n"+
                                    "  else \n"+
                                    "            'opposite_of_'.concat(self.otherEnd().name) \n"+
                                    "  endif", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #groupByMapResultPropertiesLocalEnd context

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.associationEnd.otherEnd().type.unique", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.associationEnd.otherEnd().valueInit->any(true).objectLiteral.valueClass", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.clazz.formalObjectParameters", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownedObjectParameters", data.classes.ClassesPackage.eINSTANCE));

                //template MethodSignature #groupByMapResultProperties

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context MethodSignature inv: '.'.concat(self.implementation.oclAsType(AssociationEndSignatureImplementation).end.name)", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context MethodSignature inv: self.implementation.oclAsType(AssociationEndSignatureImplementation).end.otherEnd().type.clazz", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context MethodSignature inv: self.implementation.oclAsType(LinkTraversal).end.type", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #groupByMapResultAssociationEndType
        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.associationEnd.valueInit->any(true).value.getType().oclAsType(data::classes::ClassTypeDefinition).clazz", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.associationEnd.valueInit->any(true).value.getType().oclAsType(data::classes::ClassTypeDefinition).objectParameters", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.associationEnd.valueInit->any(true).value.getType().oclAsType(data::classes::ClassTypeDefinition).lowerMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.associationEnd.valueInit->any(true).value.getType().oclAsType(data::classes::ClassTypeDefinition).upperMultiplicity", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.associationEnd.valueInit->any(true).value.getType().oclAsType(data::classes::ClassTypeDefinition).ordered", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.associationEnd.valueInit->any(true).value.getType().oclAsType(data::classes::ClassTypeDefinition).unique", data.classes.ClassesPackage.eINSTANCE));

                //template SapClass #groupByMapResult

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context SapClass inv: self.objectLiteral.propertyValues.forEnd->iterate(i; acc:String='GroupByMapResult' | acc.concat('_').concat(i.name))", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context SapClass inv: self.objectLiteral.getOwningClass().package_", data.classes.ClassesPackage.eINSTANCE));

        // End of Group by

                //template FunctionSignature #dimension context

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignature inv: self.implementation.isSideEffectFree()", data.classes.ClassesPackage.eINSTANCE));

                //template data::classes::Parameter #dimension

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::classes::Parameter inv: let f:FunctionSignature=self.oclAsType(data::classes::FunctionSignature) in \n"+
                                               "                 let ft:TypeDefinition=if f.dimension->notEmpty() then \n"+
                                               "                           f.dimension.cellSet.factsType \n"+
                                               "                         else \n"+
                                               "                           f.cellSetForValueFunction.factsType \n"+
                                               "                         endif in \n"+
                                               "                                                  if ft.oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                               "                                                 ft.oclAsType(data::classes::NestedTypeDefinition).type \n"+
                                               "                                          else \n"+
                                               "                                                 ft \n"+
                                               "                                          endif", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #dimension

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: let f:FunctionSignature=self.oclAsType(data::classes::FunctionSignature) in \n"+
                                               "                  let ft:TypeDefinition=if f.dimension->notEmpty() then \n"+
                                               "                           f.dimension.cellSet.factsType \n"+
                                               "                         else \n"+
                                               "                           f.cellSetForValueFunction.factsType \n"+
                                               "                         endif in \n"+
                                               "   if ft.oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                               "                           ft.oclAsType(data::classes::NestedTypeDefinition).type.oclAsType(data::classes::ClassTypeDefinition).clazz \n"+
                                               "                   else \n"+
                                               "                       ft.oclAsType(data::classes::ClassTypeDefinition).clazz \n"+
                                               "                   endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: let f:FunctionSignature=self.oclAsType(data::classes::FunctionSignature) in \n"+
                                               "                  let ft:TypeDefinition=if f.dimension->notEmpty() then \n"+
                                               "                           f.dimension.cellSet.factsType \n"+
                                               "                         else \n"+
                                               "                           f.cellSetForValueFunction.factsType \n"+
                                               "                         endif in \n"+
                                               "   if ft.oclIsKindOf(data::classes::NestedTypeDefinition).oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                               "                           ft.oclAsType(data::classes::NestedTypeDefinition).oclAsType(data::classes::NestedTypeDefinition).type.oclAsType(data::classes::ClassTypeDefinition).objectParameters \n"+
                                               "                   else \n"+
                                               "                       ft.oclAsType(data::classes::ClassTypeDefinition).objectParameters \n"+
                                               "                   endif", data.classes.ClassesPackage.eINSTANCE));


        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: let f:FunctionSignature=self.oclAsType(data::classes::FunctionSignature) in \n"+
                                               "                  let ft:TypeDefinition=if f.dimension->notEmpty() then \n"+
                                               "                           f.dimension.cellSet.factsType \n"+
                                               "                         else \n"+
                                               "                           f.cellSetForValueFunction.factsType \n"+
                                               "                         endif in \n"+
                                               "   if ft.oclIsKindOf(data::classes::NestedTypeDefinition).oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                               "                           ft.oclAsType(data::classes::NestedTypeDefinition).oclAsType(data::classes::NestedTypeDefinition).type.lowerMultiplicity \n"+
                                               "                   else \n"+
                                               "                       1 \n"+
                                               "                   endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: let f:FunctionSignature=self.oclAsType(data::classes::FunctionSignature) in \n"+
                                               "                  let ft:TypeDefinition=if f.dimension->notEmpty() then \n"+
                                               "                           f.dimension.cellSet.factsType \n"+
                                               "                         else \n"+
                                               "                           f.cellSetForValueFunction.factsType \n"+
                                               "                         endif in \n"+
                                               "   if ft.oclIsKindOf(data::classes::NestedTypeDefinition).oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                               "                           ft.oclAsType(data::classes::NestedTypeDefinition).oclAsType(data::classes::NestedTypeDefinition).type.oclAsType(data::classes::ClassTypeDefinition).upperMultiplicity \n"+
                                               "                   else \n"+
                                               "                       1 \n"+
                                               "                   endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: let f:FunctionSignature=self.oclAsType(data::classes::FunctionSignature) in \n"+
                                               "                  let ft:TypeDefinition=if f.dimension->notEmpty() then \n"+
                                               "                           f.dimension.cellSet.factsType \n"+
                                               "                         else \n"+
                                               "                           f.cellSetForValueFunction.factsType \n"+
                                               "                         endif in \n"+
                                               "   if ft.oclIsKindOf(data::classes::NestedTypeDefinition).oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                               "                           ft.oclAsType(data::classes::NestedTypeDefinition).oclAsType(data::classes::NestedTypeDefinition).type.ordered \n"+
                                               "                   else \n"+
                                               "                       true \n"+
                                               "                   endif", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: let f:FunctionSignature=self.oclAsType(data::classes::FunctionSignature) in \n"+
                                               "                  let ft:TypeDefinition=if f.dimension->notEmpty() then \n"+
                                               "                           f.dimension.cellSet.factsType \n"+
                                               "                         else \n"+
                                               "                           f.cellSetForValueFunction.factsType \n"+
                                               "                         endif in \n"+
                                               "   if ft.oclIsKindOf(data::classes::NestedTypeDefinition).oclIsKindOf(data::classes::NestedTypeDefinition) then \n"+
                                               "                           ft.oclAsType(data::classes::NestedTypeDefinition).oclAsType(data::classes::NestedTypeDefinition).type.unique \n"+
                                               "                   else \n"+
                                               "                       true \n"+
                                               "                   endif", data.classes.ClassesPackage.eINSTANCE));

                //template FunctionSignature #aggregationFunction context

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context FunctionSignature inv: self.implementation.isSideEffectFree()", data.classes.ClassesPackage.eINSTANCE));

        // End of Analytics

        // Begin of literal expressions

                //template ClassTypeDefinition #BinaryLiteral

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: data::classes::SapClass.allInstances()->select(c | c.name = 'Binary')", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #StringLiteral

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: data::classes::SapClass.allInstances()->select(c | c.name = 'String')", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #NumberLiteral

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: data::classes::SapClass.allInstances()->select(c | c.name = 'Number')", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #TimePointLiteral

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: data::classes::SapClass.allInstances()->select(c | c.name = 'TimePoint')", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #BooleanLiteral

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: data::classes::SapClass.allInstances()->select(c | c.name = 'Boolean')", data.classes.ClassesPackage.eINSTANCE));

                //template ObjectLiteral context(objectLiteral)

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::literals::ObjectLiteral inv: data::classes::SapClass.allInstances()->select(c | c.name = 'xxx')", data.classes.ClassesPackage.eINSTANCE));

                //template ValueInit

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context dataaccess::expressions::literals::ValueInit inv: ClassTypeDefinition.oclAsType(dataaccess::expressions::literals::ObjectLiteral).valueClass.getAssociationEnds().otherEnd()->select(ae|ae.name='xxx')", data.classes.ClassesPackage.eINSTANCE));

                //template ClassTypeDefinition #objectLiteral

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: self.ownedObjectParameters", data.classes.ClassesPackage.eINSTANCE));

            //End of literal expressions
        // End of expressions

        // Begin of classes
                //template ClassTypeDefinition

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context ClassTypeDefinition inv: data::classes::SapClass.allInstances()->select(c | c.name = 'xxx')", data.classes.ClassesPackage.eINSTANCE));

                //template ParameterizedClassInstantiation #typeDefinition

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::generics::ParameterizedClassInstantiation inv: data::classes::SapClass.allInstances()->select(c | c.isParameterizedClassDefinition())->select(c | c.name = 'xxx')", data.classes.ClassesPackage.eINSTANCE));

        EXPRESSION_LIST.add(new OclExpressionWithPackage( "context data::generics::ParameterizedClassInstantiation inv: self.oclAsType(data::classes::SapClass).package_", data.classes.ClassesPackage.eINSTANCE));
        //End of classes
}

    public class OclExpressionWithPackage{
	private final String ocl;
	private final EPackage pack;

	public OclExpressionWithPackage(String ocl, EPackage pack){
	    this.ocl = ocl;
	    this.pack = pack;
	}

	public String getOcl() {
	    return ocl;
	}

	public EPackage getPackage() {
	    return pack;
	}
    }

}
