package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.impl.ImpactAnalyzerWithHiddenOppositesFactoryImpl;

public interface ImpactAnalyzerWithHiddenOppositesFactory extends ImpactAnalyzerFactory {
    static final ImpactAnalyzerFactory INSTANCE = new ImpactAnalyzerWithHiddenOppositesFactoryImpl();
}
