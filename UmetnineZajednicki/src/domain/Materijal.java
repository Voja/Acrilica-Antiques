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
public class Materijal extends AbstractDomainObject implements Serializable {

    private UmetnickoDelo umetnickoDelo;
    private int rbMaterijala;
    private String nazivMaterijala;

    public Materijal(UmetnickoDelo umetnickoDelo, int rbMaterijala, String nazivMaterijala) {
        this.umetnickoDelo = umetnickoDelo;
        this.rbMaterijala = rbMaterijala;
        this.nazivMaterijala = nazivMaterijala;
    }

    public Materijal() {
    }

    @Override
    public String nazivTabele() {
        return " materijal ";
    }

    @Override
    public String alijas() {
        return " m ";
    }

    @Override
    public String join() {
        return " JOIN umetnickoDelo ud ON (ud.umetnickodeloid = m.umetnickodeloid) "
                + "JOIN tipDela td ON (ud.tipdelaid = td.tipdelaid) ";
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

            Materijal m = new Materijal(ud,
                    rs.getInt("RbMaterijala"), rs.getString("NazivMaterijala"));

            lista.add(m);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (UmetnickoDeloID, RbMaterijala, NazivMaterijala) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " UmetnickoDeloID = " + umetnickoDelo.getUmetnickoDeloID();
    }

    @Override
    public String vrednostiZaInsert() {
        return umetnickoDelo.getUmetnickoDeloID() + ", " + rbMaterijala + ", "
                + "'" + nazivMaterijala + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return " WHERE UD.UMETNICKODELOID = " + umetnickoDelo.getUmetnickoDeloID();
    }

    public UmetnickoDelo getUmetnickoDelo() {
        return umetnickoDelo;
    }

    public void setUmetnickoDelo(UmetnickoDelo umetnickoDelo) {
        this.umetnickoDelo = umetnickoDelo;
    }

    public int getRbMaterijala() {
        return rbMaterijala;
    }

    public void setRbMaterijala(int rbMaterijala) {
        this.rbMaterijala = rbMaterijala;
    }

    public String getNazivMaterijala() {
        return nazivMaterijala;
    }

    public void setNazivMaterijala(String nazivMaterijala) {
        this.nazivMaterijala = nazivMaterijala;
    }
}
