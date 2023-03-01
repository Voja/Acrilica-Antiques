/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Materijal;
import domain.UmetnickoDelo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vojislav
 */
public class TableModelMaterijali extends AbstractTableModel {

    private ArrayList<Materijal> lista;
    private String[] kolone = {"Rb", "Naziv materijala"};
    int rb = 0;

    public TableModelMaterijali() {
        lista = new ArrayList<>();
    }
    
    public TableModelMaterijali(UmetnickoDelo ud) {
        try {
            lista = ClientController.getInstance().getAllMaterijal(ud);
        } catch (Exception ex) {
            Logger.getLogger(TableModelMaterijali.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Materijal m = lista.get(row);

        switch (column) {
            case 0:
                return m.getRbMaterijala();
            case 1:
                return m.getNazivMaterijala();

            default:
                return null;
        }
    }

    public void dodajMaterijal(Materijal m) {
        
        rb = 0;
        for (Materijal materijal : lista) {
            materijal.setRbMaterijala(++rb);
        }
        
        m.setRbMaterijala(++rb);
        lista.add(m);
        fireTableDataChanged();
    }

    public void obrisiMaterijal(int row) {
        
        lista.remove(row);
        
        rb = 0;
        for (Materijal materijal : lista) {
            materijal.setRbMaterijala(++rb);
        }
        
        fireTableDataChanged();
        
    }

    public ArrayList<Materijal> getLista() {
        return lista;
    }

    public boolean postojiMaterijal(String nazivMaterijala) {
        for (Materijal materijal : lista) {
            if(materijal.getNazivMaterijala().equals(nazivMaterijala)){
                return true;
            }
        }
        return false;
    }

}
