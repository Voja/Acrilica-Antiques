/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Vojislav
 */
public class Racun extends AbstractDomainObject implements Serializable {
    
    private Long racunID;
    private Date datumVreme;
    private double cenaBezPopusta;
    private double popust;
    private double cenaSaPopustom;
    private Klijent klijent;
    private Zaposleni zaposleni;
    private ArrayList<StavkaRacuna> stavkeRacuna;

    public Racun(Long racunID, Date datumVreme, double cenaBezPopusta, double popust, double cenaSaPopustom, Klijent klijent, Zaposleni zaposleni, ArrayList<StavkaRacuna> stavkeRacuna) {
        this.racunID = racunID;
        this.datumVreme = datumVreme;
        this.cenaBezPopusta = cenaBezPopusta;
        this.popust = popust;
        this.cenaSaPopustom = cenaSaPopustom;
        this.klijent = klijent;
        this.zaposleni = zaposleni;
        this.stavkeRacuna = stavkeRacuna;
    }

    public Racun() {
    }
    
    @Override
    public String nazivTabele() {
        return " racun ";
    }

    @Override
    public String alijas() {
        return " r ";
    }

    @Override
    public String join() {
        return " JOIN klijent k ON (k.klijentid = r.klijentid) "
                + "JOIN zaposleni z ON (z.zaposleniid = r.zaposleniid) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            
            Zaposleni z = new Zaposleni(rs.getLong("ZaposleniID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));
            
            Klijent k = new Klijent(rs.getLong("KlijentID"),
                    rs.getString("JMBG"), rs.getString("ImeKlijenta"),
                    rs.getString("PrezimeKlijenta"), rs.getString("Status"), rs.getString("BrojTelefona"));
            
            Racun r = new Racun(rs.getLong("RacunID"), rs.getTimestamp("DatumVreme"),
                    rs.getDouble("CenaBezPopusta"), rs.getDouble("Popust"), 
                    rs.getDouble("CenaSaPopustom"), k, z, null);

            lista.add(r);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (DatumVreme, CenaBezPopusta, Popust, CenaSaPopustom, KlijentID, ZaposleniID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " RacunID = " + racunID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new Timestamp(datumVreme.getTime()) + "', " + cenaBezPopusta + ", "
                + popust + ", " + cenaSaPopustom + ", " + klijent.getKlijentID() 
                + ", " + zaposleni.getZaposleniID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getRacunID() {
        return racunID;
    }

    public void setRacunID(Long racunID) {
        this.racunID = racunID;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public double getCenaBezPopusta() {
        return cenaBezPopusta;
    }

    public void setCenaBezPopusta(double cenaBezPopusta) {
        this.cenaBezPopusta = cenaBezPopusta;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    public double getCenaSaPopustom() {
        return cenaSaPopustom;
    }

    public void setCenaSaPopustom(double cenaSaPopustom) {
        this.cenaSaPopustom = cenaSaPopustom;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public ArrayList<StavkaRacuna> getStavkeRacuna() {
        return stavkeRacuna;
    }

    public void setStavkeRacuna(ArrayList<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
    }
    
}
