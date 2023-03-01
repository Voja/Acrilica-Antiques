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
public class TipDela extends AbstractDomainObject implements Serializable {
    
    private Long tipDelaID;
    private String nazivTipaDela;

    public TipDela() {
    }

    public TipDela(Long tipDelaID, String nazivTipaDela) {
        this.tipDelaID = tipDelaID;
        this.nazivTipaDela = nazivTipaDela;
    }

    @Override
    public String toString() {
        return nazivTipaDela;
    }
    
    
    @Override
    public String nazivTabele() {
        return " tipDela ";
    }

    @Override
    public String alijas() {
        return " td ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            TipDela td = new TipDela(rs.getLong("TipDelaID"),
                    rs.getString("NazivTipaDela"));

            lista.add(td);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " TipDelaID = " + tipDelaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getTipDelaID() {
        return tipDelaID;
    }

    public void setTipDelaID(Long tipDelaID) {
        this.tipDelaID = tipDelaID;
    }

    public String getNazivTipaDela() {
        return nazivTipaDela;
    }

    public void setNazivTipaDela(String nazivTipaDela) {
        this.nazivTipaDela = nazivTipaDela;
    }
}
