package com.sap.ide.moftool.editor.graphics.serviceLayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Operation;

public class ParserUtil {

    public static String getAttributeTypeFromValue(String value) {
        if (value != null) {
            int colIndex = value.lastIndexOf(':');

            if (colIndex != -1) {
                String type;
                int bracketIndex = value.indexOf('[');
                if (bracketIndex != -1)
                    type = value.substring(colIndex + 1, bracketIndex).trim();
                else
                    type = value.substring(colIndex + 1).trim();
                if (type != null && type.length() > 0) {
                    return type;
                }
            }
        }
        return null;
    }

    public static String getTypeFromValue(String value) {
        if (value != null) {
            int colIndex = value.lastIndexOf(':');
            if (colIndex != -1) {
                String type = value.substring(colIndex + 1).trim();
                if (type != null && type.length() > 0) {
                    return type;
                }
            }
        }
        return null;
    }

    public static String getNameFromValue(String value, char nameSeparator) {
        if (value != null) {
            int colIndex = value.indexOf(nameSeparator);
            if (colIndex != -1) {
                String name = value.substring(0, colIndex).trim();
                if (name != null && name.length() > 0) {
                    return name;
                }
            }
        }
        return null;
    }

    public static String getParametersFromValueAsString(String value) {
        int beginIndex = value.contains("(") ? value.indexOf('(') : -1; //$NON-NLS-1$
        int endIndex = value.contains(")") ? value.indexOf(')') : -1; //$NON-NLS-1$

        if (beginIndex < 0 || endIndex < 0)
            return null;
        else
            return value.substring(beginIndex + 1, endIndex);
    }

    public static LinkedHashMap<String, String> getParametersAsHash(String value) {
        LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();
        if (value != null) {
            // if parameters[0] == "", that means, there are no parameter
            String[] parameters = value.split(","); //$NON-NLS-1$
            if (parameters[0].equals("")) //$NON-NLS-1$
                return result;
            // add parameter with right syntax and type, otherwise inform the user about wrong things
            for (int i = 0; i < parameters.length; i++) {
                String name = ParserUtil.getNameFromValue(parameters[i], ':');
                String type = ParserUtil.getTypeFromValue(parameters[i]);
                result.put(name, type);
            }
        }
        return result;
    }
    
    public static List<String> getParametersAsList(String value) {
    	List<String> parList = new ArrayList<String>();
        if (value != null) {
            // if parameters[0] == "", that means, there are no parameter
            String[] parameters = value.split(","); //$NON-NLS-1$
            if (parameters[0].equals("")) //$NON-NLS-1$
                return parList;
            // add parameter with right syntax and type, otherwise inform the user about wrong things
            for (int i = 0; i < parameters.length; i++) {
                String name = ParserUtil.getNameFromValue(parameters[i], ':');                
                parList.add(name);
            }
        }
        return parList;
    	
    }


    public static String checkQualifiedTypeName(String type, List<String> allQualifiedClassifiers) {
    	if (type == null) {
    		return Messages.ParserUtil_0_xmsg;
    	} else if (!allQualifiedClassifiers.contains(type)) {
            return Messages.ParserUtil_1_xmsg;
        }
    	return null;
    }
    
    
    public static String checkUnqualifiedTypeName(String type, List<String> allClassifiers) {
    	if (type == null) {
    		return Messages.ParserUtil_2_xmsg;
    	}
    	Iterator<String> it = allClassifiers.iterator();
    	int occurences = 0;
    	while (it.hasNext()) {
    		String name = it.next();
    		if (name.equals(type)) {
    			occurences = occurences + 1;
    			if (occurences > 1) {
    				return Messages.ParserUtil_3_xmsg;
    			}
    		}
    	}
    	if (occurences == 0) {
    		return Messages.ParserUtil_4_xmsg;
    	}
    	return null;
    }

    public static String getOperationNameFromValue(String value) {
        return ParserUtil.getNameFromValue(value, '(');
    }

    public static String checkOperationParameters(String parameterValue, Operation op, List<String> allClassifiers, List<String> allQualifiedClassifiers) {
        String[] parameters = parameterValue.split(","); //$NON-NLS-1$
        List<String> parameterNames = new ArrayList<String>();

        if (parameters.length == 0) {
            return Messages.ParserUtil_5_xmsg;
        }
        // if parameters[0] = "", that means, there are no parameter
        if (parameters[0].equals("")) { //$NON-NLS-1$
            return null;
        }

        for (int i = 0; i < parameters.length; i++) {
            String name = ParserUtil.getNameFromValue(parameters[i], ':');
            String type = ParserUtil.getTypeFromValue(parameters[i]);
            
            if (name == null && parameters[i] != null && !parameters[i].equals(" ")) { //$NON-NLS-1$
                if (!parameters[i].matches("[A-Za-z0-9_]+")) //$NON-NLS-1$
                    return Messages.ParserUtil_6_xmsg;
                else
                    return Messages.ParserUtil_7_xmsg;
            }
            if (name == null)
                return Messages.ParserUtil_8_xmsg;
            if (name != null) {
                if (name.length() < 1 || name.equals(" ")) { //$NON-NLS-1$
                    return Messages.ParserUtil_9_xmsg;
                }
                // check by means of regular expression, whether the name has the right syntax
                if (!name.matches("[A-Za-z0-9_]+")) { //$NON-NLS-1$
                    return Messages.ParserUtil_10_xmsg;
                }
                // check for duplicate names
                if (parameterNames.contains(name)) {
                	return Messages.ParserUtil_11_xmsg;
                } else {
                	parameterNames.add(name);
                }

            }

			
			String isParameterTypeValid = null;
			if (type != null && type.lastIndexOf('.') != -1) {
				// type name is qualified:
				// check against qualified names (existence only)
				isParameterTypeValid = ParserUtil.checkQualifiedTypeName(type, allQualifiedClassifiers);
			} else {
				if (!allClassifiers.contains(type)) {
					isParameterTypeValid = Messages.ParserUtil_12_xmsg;
				}
			}
            
            if (isParameterTypeValid != null) {
                return isParameterTypeValid;
            }
        }
        return null;
    }

    public static String getfirstCharsOfType(String value, int caretPos) {
        String textBeforeCaret = value.substring(0, caretPos);
        int lastColonIndex = textBeforeCaret.lastIndexOf(':');
        return textBeforeCaret.substring(lastColonIndex + 1, caretPos);
    }

    public static boolean isTypeEntered(String value, int caretPos) {
        String textBeforeCaret = value.substring(0, caretPos);
        int lastColonIndex = textBeforeCaret.lastIndexOf(':');
        if (lastColonIndex != -1) {
            return true;
        }
        return false;
    }

    public static String getTextbeforeLastColon(String value) {
        int lastColonIndex = value.lastIndexOf(':');
        return value.substring(0, lastColonIndex);
    }
    


    public static String checkMultiplicity(String multiplicity) {
       String ret = null;
        if(multiplicity != null){
            if (!multiplicity.matches("([0-9]+)(\\.){2}([0-9]+|[*n])")){ //$NON-NLS-1$
                ret = Messages.ParserUtil_13_xmsg;
            }
          
            else{
                ret = checkMultiplicitySemantik(multiplicity);
            }
        }
        return ret;
    }

    public static String checkMultiplicitySemantik(String multiplicity) {
        int[] calculatedMultiplicity = calculateMultiplicityFromValue( multiplicity);
        int lower = calculatedMultiplicity[0];
        int upper = calculatedMultiplicity[1];
         
        if(upper != -1 && lower > upper ){
            return Messages.ParserUtil_14_xmsg ;
        }
        if(upper != -1 && upper < 1){
            return Messages.ParserUtil_15_xmsg ;
        }
        return null;
    }

    public static String getMultiplicityFromValue(String value) {
        StringBuffer ret = new StringBuffer();
        int openBracket = value.indexOf('[');
        int closeBracket = value.indexOf(']');
        
        if(openBracket != -1 && closeBracket != -1){
            ret.append(value.substring(openBracket +1,closeBracket));
            return ret.toString();
        }
        
        return null;
    }
    public static int[] calculateMultiplicityFromValue(String value) {
        int lower = 1;
        int upper = 1;

        if (value != null) {
            int firstDotIndex = value.indexOf('.');
            int secondDotIndex = value.lastIndexOf('.');
            String lowerBound = value.substring(0, firstDotIndex);
            String upperBound = value.substring(secondDotIndex + 1);
            lower = Integer.valueOf(lowerBound);
            if(upperBound.equals("*") || upperBound.equals("n")) //$NON-NLS-1$ //$NON-NLS-2$
               upper = -1;
            else                
                upper = Integer.valueOf(upperBound);   
            
        }
       
        return new int[] { lower, upper };
    }
}
