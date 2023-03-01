/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Racun;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vojislav
 */
public class TableModelRacuni extends AbstractTableModel implements Runnable {

    private ArrayList<Racun> lista;
    private String[] kolone = {"ID", "Datum i vreme", "Klijent", "Cena bez popusta", "Popust %",
        "Cena sa popustom", "Zaposleni"};
    private String parametar = "";

    public TableModelRacuni() {
        try {
            lista = ClientController.getInstance().getAllRacun();
        } catch (Exception ex) {
            Logger.getLogger(TableModelRacuni.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Racun> getLista() {
        return lista;
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
        Racun r = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        switch (column) {
            case 0:
                return r.getRacunID();
            case 1:
                return sdf.format(r.getDatumVreme());
            case 2:
                return r.getKlijent().getImeKlijenta() + " " + r.getKlijent().getPrezimeKlijenta();
            case 3:
                return r.getCenaBezPopusta();
            case 4:
                return r.getPopust();
            case 5:
                return r.getCenaSaPopustom();
            case 6:
                return r.getZaposleni();

            default:
                return null;
        }
    }

    public Racun getSelectedRacun(int row) {
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
            Logger.getLogger(TableModelRacuni.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        String imePrezime = "";
        try {
            lista = ClientController.getInstance().getAllRacun();
            if (!parametar.equals("")) {
                ArrayList<Racun> novaLista = new ArrayList<>();
                for (Racun r : lista) {
                     imePrezime = r.getKlijent().getImeKlijenta() + " " + r.getKlijent().getPrezimeKlijenta();
                    if (r.getKlijent().getImeKlijenta().toLowerCase().startsWith(parametar.toLowerCase())
                            || r.getKlijent().getPrezimeKlijenta().toLowerCase().startsWith(parametar.toLowerCase())
                            || imePrezime.toLowerCase().startsWith(parametar.toLowerCase())) {
                        novaLista.add(r);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
