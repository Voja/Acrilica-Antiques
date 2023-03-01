/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Klijent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vojislav
 */
public class TableModelKlijenti extends AbstractTableModel implements Runnable {

    private ArrayList<Klijent> lista;
    private String[] kolone = {"JMBG", "Ime", "Prezime", "Broj telefona", "Status"};
    private String parametar = "";
    private String status = "";

    public TableModelKlijenti() {
        try {
            lista = ClientController.getInstance().getAllKlijent();
        } catch (Exception ex) {
            Logger.getLogger(TableModelKlijenti.class.getName()).log(Level.SEVERE, null, ex);
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
        Klijent k = lista.get(row);

        switch (column) {
            case 0:
                return k.getJMBG();
            case 1:
                return k.getImeKlijenta();
            case 2:
                return k.getPrezimeKlijenta();
            case 3:
                return k.getBrojTelefona();
            case 4:
                return k.getStatus();

            default:
                return null;
        }
    }

    public Klijent getSelectedKlijent(int row) {
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
            Logger.getLogger(TableModelKlijenti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public ArrayList<Klijent> getLista() {
        return lista;
    }

    public void setStatus(String status) {
        this.status = status;
        refreshTable();
    }

    public void refreshTable() {
        String imePrezime = "";
        try {
            lista = ClientController.getInstance().getAllKlijent();
            if (!status.equals("") && !parametar.equals("")) {
                ArrayList<Klijent> novaLista = new ArrayList<>();
                for (Klijent k : lista) {
                    if (k.getStatus().toLowerCase().equals(status.toLowerCase())) {
                        novaLista.add(k);
                    }
                }
                lista = novaLista;
                ArrayList<Klijent> pom = new ArrayList<>();
                for (Klijent k : lista) {
                    imePrezime = k.getImeKlijenta() + " " + k.getPrezimeKlijenta();
                    if (k.getImeKlijenta().toLowerCase().startsWith(parametar.toLowerCase())
                            || k.getPrezimeKlijenta().toLowerCase().startsWith(parametar.toLowerCase())
                            || imePrezime.toLowerCase().startsWith(parametar.toLowerCase())) {
                        pom.add(k);
                    }
                }
                lista = pom;
                fireTableDataChanged();
                return;
            }
            if (status.equals("") && !parametar.equals("")) {
                ArrayList<Klijent> novaLista = new ArrayList<>();
                for (Klijent k : lista) {
                    imePrezime = k.getImeKlijenta() + " " + k.getPrezimeKlijenta();
                    if (k.getImeKlijenta().toLowerCase().startsWith(parametar.toLowerCase())
                            || k.getPrezimeKlijenta().toLowerCase().startsWith(parametar.toLowerCase())
                            || imePrezime.toLowerCase().startsWith(parametar.toLowerCase())) {
                        novaLista.add(k);
                    }
                }
                lista = novaLista;
                fireTableDataChanged();
                return;
            }
            if (!status.equals("") && parametar.equals("")) {
                ArrayList<Klijent> novaLista = new ArrayList<>();
                for (Klijent k : lista) {
                    if (k.getStatus().toLowerCase().equals(status.toLowerCase())) {
                        novaLista.add(k);
                    }
                }
                lista = novaLista;
                fireTableDataChanged();
                return;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
