//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from ShowJoinIndex_Result.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowJoinIndex_Result extends Result
{
    private String                         itsDescription;
    private String                         itsDateCreated;
    private String                         itsDateModified;
    private ArrayList <JoinCondition>      itsJoinConditions;
    private ArrayList <JoinPhysicalIndex>  itsJoinIndexes;
    private ArrayList <KeyFigure>          itsKeyFigures;
    private ArrayList <ViewAttribute>      itsViewAttributes;
    private ArrayList <UnitConversion>     itsUnitConversions;
    private ArrayList <String>             itsConstraints;
    private int                            itsIndexFlags;
    private ArrayList <ViewAttributeGroup> itsViewAttributeGroups;

    public ShowJoinIndex_Result ()
    {
        itsDescription = "";
        itsDateCreated = "";
        itsDateModified = "";
        itsJoinConditions = new ArrayList <JoinCondition> ();
        itsJoinIndexes = new ArrayList <JoinPhysicalIndex> ();
        itsKeyFigures = new ArrayList <KeyFigure> ();
        itsViewAttributes = new ArrayList <ViewAttribute> ();
        itsUnitConversions = new ArrayList <UnitConversion> ();
        itsConstraints = new ArrayList <String> ();
        itsIndexFlags = 0;
        itsViewAttributeGroups = new ArrayList <ViewAttributeGroup> ();
    }

    public void clear()
    {
        super.clear();
        itsDescription = "";
        itsDateCreated = "";
        itsDateModified = "";
        itsJoinConditions.clear();
        itsJoinIndexes.clear();
        itsKeyFigures.clear();
        itsViewAttributes.clear();
        itsUnitConversions.clear();
        itsConstraints.clear();
        itsIndexFlags = 0;
        itsViewAttributeGroups.clear();
    }

    public void read(InputStream theStream) throws IOException, TrexException
    {
        int i,j;
        super.read(theStream);
        itsDescription = theStream.readString();
        itsDateCreated = theStream.readString();
        itsDateModified = theStream.readString();
        j = theStream.readVectorSize();
        itsJoinConditions.ensureCapacity(j);
        while(itsJoinConditions.size()<j)
            itsJoinConditions.add(new JoinCondition());
        while(itsJoinConditions.size()>j)
            itsJoinConditions.remove(itsJoinConditions.size()-1);
        for(i=0; i<j; i++)
            itsJoinConditions.get(i).read(theStream);
        j = theStream.readVectorSize();
        itsJoinIndexes.ensureCapacity(j);
        while(itsJoinIndexes.size()<j)
            itsJoinIndexes.add(new JoinPhysicalIndex());
        while(itsJoinIndexes.size()>j)
            itsJoinIndexes.remove(itsJoinIndexes.size()-1);
        for(i=0; i<j; i++)
            itsJoinIndexes.get(i).read(theStream);
        j = theStream.readVectorSize();
        itsKeyFigures.ensureCapacity(j);
        while(itsKeyFigures.size()<j)
            itsKeyFigures.add(new KeyFigure());
        while(itsKeyFigures.size()>j)
            itsKeyFigures.remove(itsKeyFigures.size()-1);
        for(i=0; i<j; i++)
            itsKeyFigures.get(i).read(theStream);
        j = theStream.readVectorSize();
        itsViewAttributes.ensureCapacity(j);
        while(itsViewAttributes.size()<j)
            itsViewAttributes.add(new ViewAttribute());
        while(itsViewAttributes.size()>j)
            itsViewAttributes.remove(itsViewAttributes.size()-1);
        for(i=0; i<j; i++)
            itsViewAttributes.get(i).read(theStream);
        j = theStream.readVectorSize();
        itsUnitConversions.ensureCapacity(j);
        while(itsUnitConversions.size()<j)
            itsUnitConversions.add(new UnitConversion());
        while(itsUnitConversions.size()>j)
            itsUnitConversions.remove(itsUnitConversions.size()-1);
        for(i=0; i<j; i++)
            itsUnitConversions.get(i).read(theStream);
        j = theStream.readVectorSize();
        itsConstraints.ensureCapacity(j);
        while(itsConstraints.size()<j)
            itsConstraints.add(new String());
        while(itsConstraints.size()>j)
            itsConstraints.remove(itsConstraints.size()-1);
        for(i=0; i<j; i++)
            itsConstraints.set(i,theStream.readString());
        itsIndexFlags = theStream.readInt();
        j = theStream.readVectorSize();
        itsViewAttributeGroups.ensureCapacity(j);
        while(itsViewAttributeGroups.size()<j)
            itsViewAttributeGroups.add(new ViewAttributeGroup());
        while(itsViewAttributeGroups.size()>j)
            itsViewAttributeGroups.remove(itsViewAttributeGroups.size()-1);
        for(i=0; i<j; i++)
            itsViewAttributeGroups.get(i).read(theStream);
    }

    public void write(OutputStream theStream) throws IOException, TrexException
    {
        throw new TrexException(Error.TDBC_READ_ONLY,"ShowJoinIndex_Result");
    }

    /**
     * \class ShowJoinIndex_Result
     *
     * \var description          -
     * \var dateCreated          -
     * \var dateModified         -
     * \var joinConditions       -
     * \var joinIndexes          -
     * \var keyFigures           -
     * \var viewAttributes       -
     * \var unitConversions      -
     * \var constraints          -
     * \var indexFlags           -
     * \var viewAttributeGroups  -
     */

    public String getDescription() 
    {
        return itsDescription;
    }

    public void setDescription(String theDescription)
    {
        itsDescription = theDescription; 
    }


    public String getDateCreated() 
    {
        return itsDateCreated;
    }

    public void setDateCreated(String theDateCreated)
    {
        itsDateCreated = theDateCreated; 
    }


    public String getDateModified() 
    {
        return itsDateModified;
    }

    public void setDateModified(String theDateModified)
    {
        itsDateModified = theDateModified; 
    }


    public ArrayList <JoinCondition> getJoinConditions() 
    {
        return itsJoinConditions;
    }

    public void setJoinConditions(ArrayList <JoinCondition> theJoinConditions)
    {
        itsJoinConditions = theJoinConditions; 
    }

    public void addJoinCondition(JoinCondition theJoinConditions)
    {
        itsJoinConditions.add(theJoinConditions); 
    }


    public ArrayList <JoinPhysicalIndex> getJoinIndexes() 
    {
        return itsJoinIndexes;
    }

    public void setJoinIndexes(ArrayList <JoinPhysicalIndex> theJoinIndexes)
    {
        itsJoinIndexes = theJoinIndexes; 
    }

    public void addJoinIndexe(JoinPhysicalIndex theJoinIndexes)
    {
        itsJoinIndexes.add(theJoinIndexes); 
    }


    public ArrayList <KeyFigure> getKeyFigures() 
    {
        return itsKeyFigures;
    }

    public void setKeyFigures(ArrayList <KeyFigure> theKeyFigures)
    {
        itsKeyFigures = theKeyFigures; 
    }

    public void addKeyFigure(KeyFigure theKeyFigures)
    {
        itsKeyFigures.add(theKeyFigures); 
    }


    public ArrayList <ViewAttribute> getViewAttributes() 
    {
        return itsViewAttributes;
    }

    public void setViewAttributes(ArrayList <ViewAttribute> theViewAttributes)
    {
        itsViewAttributes = theViewAttributes; 
    }

    public void addViewAttribute(ViewAttribute theViewAttributes)
    {
        itsViewAttributes.add(theViewAttributes); 
    }


    public ArrayList <UnitConversion> getUnitConversions() 
    {
        return itsUnitConversions;
    }

    public void setUnitConversions(ArrayList <UnitConversion> theUnitConversions)
    {
        itsUnitConversions = theUnitConversions; 
    }

    public void addUnitConversion(UnitConversion theUnitConversions)
    {
        itsUnitConversions.add(theUnitConversions); 
    }


    public ArrayList <String> getConstraints() 
    {
        return itsConstraints;
    }

    public void setConstraints(ArrayList <String> theConstraints)
    {
        itsConstraints = theConstraints; 
    }

    public void addConstraint(String theConstraints)
    {
        itsConstraints.add(theConstraints); 
    }


    public int getIndexFlags() 
    {
        return itsIndexFlags;
    }

    public void setIndexFlags(int theIndexFlags)
    {
        itsIndexFlags = theIndexFlags; 
    }


    public ArrayList <ViewAttributeGroup> getViewAttributeGroups() 
    {
        return itsViewAttributeGroups;
    }

    public void setViewAttributeGroups(ArrayList <ViewAttributeGroup> theViewAttributeGroups)
    {
        itsViewAttributeGroups = theViewAttributeGroups; 
    }

    public void addViewAttributeGroup(ViewAttributeGroup theViewAttributeGroups)
    {
        itsViewAttributeGroups.add(theViewAttributeGroups); 
    }

}