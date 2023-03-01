/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Vojislav
 */
public class Klijent extends AbstractDomainObject implements Serializable {
    
    private Long klijentID;
    private String JMBG;
    private String imeKlijenta;
    private String prezimeKlijenta;
    private String status;
    private String brojTelefona;

    public Klijent() {
    }

    public Klijent(Long klijentID, String JMBG, String imeKlijenta, String prezimeKlijenta, String status, String brojTelefon) {
        this.klijentID = klijentID;
        this.JMBG = JMBG;
        this.imeKlijenta = imeKlijenta;
        this.prezimeKlijenta = prezimeKlijenta;
        this.status = status;
        this.brojTelefona = brojTelefon;
    }
    
    
    @Override
    public String nazivTabele() {
        return " klijent ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String toString() {
        return imeKlijenta + " " + prezimeKlijenta + " [ " + status + " ]";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Klijent k = new Klijent(rs.getLong("KlijentID"),
                    rs.getString("JMBG"), rs.getString("ImeKlijenta"),
                    rs.getString("PrezimeKlijenta"), rs.getString("Status"), rs.getString("BrojTelefona"));

            lista.add(k);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (JMBG, ImeKlijenta, PrezimeKlijenta, Status, BrojTelefona) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " KlijentID = " + klijentID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + JMBG + "', '" + imeKlijenta + "', "
                + "'" + prezimeKlijenta + "', '" + status + "', '" + brojTelefona + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "Status = '" + status + "', BrojTelefona = '" + brojTelefona + "' ";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(Long klijentID) {
        this.klijentID = klijentID;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getImeKlijenta() {
        return imeKlijenta;
    }

    public void setImeKlijenta(String imeKlijenta) {
        this.imeKlijenta = imeKlijenta;
    }

    public String getPrezimeKlijenta() {
        return prezimeKlijenta;
    }

    public void setPrezimeKlijenta(String prezimeKlijenta) {
        this.prezimeKlijenta = prezimeKlijenta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }
}
