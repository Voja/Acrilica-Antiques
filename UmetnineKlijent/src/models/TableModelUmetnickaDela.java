/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.TipDela;
import domain.UmetnickoDelo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vojislav
 */
public class TableModelUmetnickaDela extends AbstractTableModel implements Runnable {

    private ArrayList<UmetnickoDelo> lista;
    private String[] kolone = {"ID", "Naziv", "Cena", "Tip dela"};
    private String parametar = "";
    private TipDela tipDela = null;

    public TableModelUmetnickaDela() {
        try {
            lista = ClientController.getInstance().getAllUmetnickoDelo(null);
        } catch (Exception ex) {
            Logger.getLogger(TableModelUmetnickaDela.class.getName()).log(Level.SEVERE, null, ex);
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

    public ArrayList<UmetnickoDelo> getLista() {
        return lista;
    }

    @Override
    public Object getValueAt(int row, int column) {
        UmetnickoDelo ud = lista.get(row);

        switch (column) {
            case 0:
                return ud.getUmetnickoDeloID();
            case 1:
                return ud.getNaziv();
            case 2:
                return ud.getCena();
            case 3:
                return ud.getTipDela();

            default:
                return null;
        }
    }

    public UmetnickoDelo getSelectedUmetnickoDelo(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(5000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelUmetnickaDela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void setTipDela(TipDela tipDela) {
        this.tipDela = tipDela;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllUmetnickoDelo(null);
            if (!parametar.equals("") && tipDela == null) {
                ArrayList<UmetnickoDelo> novaLista = new ArrayList<>();
                for (UmetnickoDelo ud : lista) {
                    if (ud.getNaziv().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(ud);
                    }
                }
                lista = novaLista;
                fireTableDataChanged();
                return;
            }
            if (parametar.equals("") && tipDela != null) {
                ArrayList<UmetnickoDelo> novaLista = new ArrayList<>();
                for (UmetnickoDelo ud : lista) {
                    if (ud.getTipDela().getTipDelaID() == tipDela.getTipDelaID()) {
                        novaLista.add(ud);
                    }
                }
                lista = novaLista;
                fireTableDataChanged();
                return;
            }
            if (!parametar.equals("") && tipDela != null) {
                ArrayList<UmetnickoDelo> novaLista = new ArrayList<>();
                for (UmetnickoDelo ud : lista) {
                    if (ud.getNaziv().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(ud);
                    }
                }
                lista = novaLista;
                 ArrayList<UmetnickoDelo> pom = new ArrayList<>();
                for (UmetnickoDelo ud : lista) {
                    if (ud.getTipDela().getTipDelaID() == tipDela.getTipDelaID()) {
                        pom.add(ud);
                    }
                }
                lista = pom;
                fireTableDataChanged();
                return;
                
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
