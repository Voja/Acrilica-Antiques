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
public class UmetnickoDelo extends AbstractDomainObject implements Serializable {

    private Long umetnickoDeloID;
    private String naziv;
    private double cena;
    private String opis;
    private boolean unikat;
    private TipDela tipDela;
    private ArrayList<Materijal> materijali;

    @Override
    public String toString() {
        return naziv + " ( " + cena + "$ )";
    }

    public UmetnickoDelo() {
    }

    public UmetnickoDelo(Long umetnickoDeloID, String naziv, double cena, String opis, boolean unikat, TipDela tipDela, ArrayList<Materijal> materijali) {
        this.umetnickoDeloID = umetnickoDeloID;
        this.naziv = naziv;
        this.cena = cena;
        this.opis = opis;
        this.unikat = unikat;
        this.tipDela = tipDela;
        this.materijali = materijali;
    }

   
    @Override
    public String nazivTabele() {
        return " umetnickoDelo ";
    }

    @Override
    public String alijas() {
        return " ud ";
    }

    @Override
    public String join() {
        return " JOIN tipDela td ON (ud.tipdelaid = td.tipdelaid) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            TipDela td = new TipDela(rs.getLong("TipDelaID"),
                    rs.getString("NazivTipaDela"));

            UmetnickoDelo ud = new UmetnickoDelo(rs.getLong("UmetnickoDeloID"),
                    rs.getString("Naziv"), rs.getDouble("Cena"),
                    rs.getString("Opis"),rs.getBoolean("Unikat"), td, null);

            lista.add(ud);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Naziv, Cena, Opis, Unikat, TipDelaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " UmetnickoDeloID = " + umetnickoDeloID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + naziv + "', " + cena + ", "
                + "'" + opis + "', " + unikat + ", " + tipDela.getTipDelaID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return " Cena = " + cena + ", Opis = '" + opis + "'";
    }

    @Override
    public String uslov() {
        if (tipDela == null) {
            return "";
        }
        return " WHERE td.tipdelaid = " + tipDela.getTipDelaID();
    }

    public Long getUmetnickoDeloID() {
        return umetnickoDeloID;
    }

    public void setUmetnickoDeloID(Long umetnickoDeloID) {
        this.umetnickoDeloID = umetnickoDeloID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public TipDela getTipDela() {
        return tipDela;
    }

    public void setTipDela(TipDela tipDela) {
        this.tipDela = tipDela;
    }

    public ArrayList<Materijal> getMaterijali() {
        return materijali;
    }

    public void setMaterijali(ArrayList<Materijal> materijali) {
        this.materijali = materijali;
    }

    public boolean isUnikat() {
        return unikat;
    }

    public void setUnikat(boolean unikat) {
        this.unikat = unikat;
    }
}
