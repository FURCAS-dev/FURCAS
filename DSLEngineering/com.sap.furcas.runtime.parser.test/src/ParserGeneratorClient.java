import static org.junit.Assert.*;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.junit.Test;

import com.sap.furcas.runtime.common.interfaces.TCSParserGenerator;


public class ParserGeneratorClient {
    
    private String extensionPointId = "com.sap.furcas.parsergenerator.tcsparsergenerator";
    
    @Test
    public void testFu() throws CoreException{
        IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPointId);
        
        assertEquals(1, configurationElements.length);
        
        String msg;
        
        for (IConfigurationElement configElement : configurationElements) {
            Object o = configElement.createExecutableExtension("class");
            if (o instanceof TCSParserGenerator) {
                msg = ((TCSParserGenerator) o).extTest();
                assertEquals("fu",msg);
                return;
            }
        }
        fail("fail");
    }
}
                         
                                   


