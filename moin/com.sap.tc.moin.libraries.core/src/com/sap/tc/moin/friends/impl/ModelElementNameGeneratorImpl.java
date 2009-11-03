package com.sap.tc.moin.friends.impl;

import java.util.List;

import com.sap.tc.moin.friends.ModelElementNameGenerator;
import com.sap.tc.moin.repository.core.checks.ModelElementNameGeneratorCore;

public class ModelElementNameGeneratorImpl implements ModelElementNameGenerator {

    public String buildMoinCompliantModelElementName( List<String> words, String prefix ) {

        return ModelElementNameGeneratorCore.buildMoinCompliantModelElementName( words, prefix );
    }

}
