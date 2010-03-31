package com.sap.tc.moin.repository.test.jmigenerator.tool;

import java.io.File;

import javax.swing.table.AbstractTableModel;

final class MetamodelTableModel extends AbstractTableModel {

    private static final long serialVersionUID = -3619894350219176184L;

    private String[] columnNames = { "", "Container name", "Generation path" };

    private String[][] metamodelInfos = null;

    private Boolean[] checkBoxes = null;

    public int getColumnCount( ) {

        return columnNames.length;
    }

    public int getRowCount( ) {

        if ( metamodelInfos != null ) {
            return metamodelInfos.length;
        }

        return 0;
    }

    @Override
    public String getColumnName( int col ) {

        return columnNames[col];
    }

    public Object getValueAt( int row, int col ) {

        String[] metamodelInfo = metamodelInfos[row];
        switch ( col ) {
            case 0:
                return checkBoxes[row];
            case 1:
                return metamodelInfo[0];
            case 2:
                return ( new File( metamodelInfo[1] ) ).getAbsolutePath( );
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass( int c ) {

        Object valueAt = getValueAt( 0, c );
        if ( valueAt != null ) {
            return valueAt.getClass( );
        }
        return String.class;
    }

    public void setMetamodelContainerNames( String[] metamodelContainerNames, String[] paths ) {

        this.metamodelInfos = new String[metamodelContainerNames.length][];
        int i = 0;
        for ( String containerName : metamodelContainerNames ) {
            this.metamodelInfos[i] = new String[] { containerName, paths[i] };
            i++;
        }
        this.checkBoxes = new Boolean[this.metamodelInfos.length];
        for ( i = 0; i < this.checkBoxes.length; i++ ) {
            this.checkBoxes[i] = Boolean.TRUE;
        }

    }

    /*
     * Don't need to implement this method unless your table's editable.
     */
    public boolean isCellEditable( int row, int col ) {

        if ( col == 0 ) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Don't need to implement this method unless your table's data can change.
     */
    public void setValueAt( Object value, int row, int col ) {

        this.checkBoxes[row] = (Boolean) value;
        fireTableCellUpdated( row, col );
    }

    public void selectAll( ) {

        for ( int i = 0; i < checkBoxes.length; i++ ) {
            checkBoxes[i] = Boolean.TRUE;
        }
        fireTableDataChanged( );
    }

    public void deselectAll( ) {

        for ( int i = 0; i < checkBoxes.length; i++ ) {
            checkBoxes[i] = Boolean.FALSE;
        }
        fireTableDataChanged( );
    }

    public String[] getMetamodelContainerNames( ) {

        String[] result = new String[metamodelInfos.length];
        for ( int i = 0; i < metamodelInfos.length; i++ ) {
            result[i] = metamodelInfos[i][0];
        }
        return result;
    }

    public void selectMetammodelContainerName( String[] containerNames ) {

        for ( String containerName : containerNames ) {
            for ( int i = 0; i < metamodelInfos.length; i++ ) {
                if ( metamodelInfos[i][0].equals( containerName ) ) {
                    this.checkBoxes[i] = Boolean.TRUE;
                }
            }
        }

        fireTableDataChanged( );
    }

    public String[] getSelectedMetamodelContainerName( ) {

        int numberOfCheckedRows = 0;
        for ( int i = 0; i < this.checkBoxes.length; i++ ) {
            if ( this.checkBoxes[i].equals( Boolean.TRUE ) ) {
                numberOfCheckedRows++;
            }
        }

        String[] result = new String[numberOfCheckedRows];

        for ( int i = 0, resultCounter = 0; i < this.checkBoxes.length; i++ ) {
            if ( this.checkBoxes[i].equals( Boolean.TRUE ) ) {
                result[resultCounter] = metamodelInfos[i][0];
                resultCounter++;
            }
        }

        return result;
    }

    public int getGenerationPathColumn( ) {

        return 2;
    }

}