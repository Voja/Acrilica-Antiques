/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Racun;
import domain.StavkaRacuna;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vojislav
 */
public class TableModelStavkeRacuna extends AbstractTableModel {

    private ArrayList<StavkaRacuna> lista;
    private String[] kolone = {"Rb", "Naziv umetnickog dela", "Kolicina", "Cena"};
    int rb = 0;

    public TableModelStavkeRacuna() {
        lista = new ArrayList<>();
    }
    
    public TableModelStavkeRacuna(Racun r) {
        try {
            lista = ClientController.getInstance().getAllStavkaRacuna(r);
        } catch (Exception ex) {
            Logger.getLogger(TableModelStavkeRacuna.class.getName()).log(Level.SEVERE, null, ex);
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
        StavkaRacuna sr = lista.get(row);

        switch (column) {
            case 0:
                return sr.getRbStavke();
            case 1:
                return sr.getUmetnickoDelo().getNaziv();
            case 2: 
                return sr.getKolicina();
            case 3:
                return sr.getCenaStavke();

            default:
                return null;
        }
    }

    public void dodajStavku(StavkaRacuna sr) {
        
        for (StavkaRacuna stavkaRacuna : lista) {
            if(stavkaRacuna.getUmetnickoDelo().getUmetnickoDeloID()
                    .equals(sr.getUmetnickoDelo().getUmetnickoDeloID())){
                stavkaRacuna.setKolicina(stavkaRacuna.getKolicina() + sr.getKolicina());
                stavkaRacuna.setCenaStavke(stavkaRacuna.getCenaStavke() + sr.getCenaStavke());
                fireTableDataChanged();
                return;
            }
        }
        
        rb = 0;
        for (StavkaRacuna stavkaRacuna : lista) {
            stavkaRacuna.setRbStavke(++rb);
        }
        
        sr.setRbStavke(++rb);
        lista.add(sr);
        fireTableDataChanged();
    }

    public void obrisiStavku(int row) {
        
        lista.remove(row);
        
        rb = 0;
        for (StavkaRacuna stavkaRacuna : lista) {
            stavkaRacuna.setRbStavke(++rb);
        }
        
        fireTableDataChanged();
        
    }

    public ArrayList<StavkaRacuna> getLista() {
        return lista;
    }

    public StavkaRacuna vratiStavku(int row) {
        return lista.get(row);
    }

  

}
