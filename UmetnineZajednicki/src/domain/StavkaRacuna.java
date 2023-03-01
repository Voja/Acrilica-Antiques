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
public class StavkaRacuna extends AbstractDomainObject implements Serializable {

    private Racun racun;
    private int rbStavke;
    private int kolicina;
    private double cenaStavke;
    private UmetnickoDelo umetnickoDelo;

    public StavkaRacuna(Racun racun, int rbStavke, int kolicina, double cenaStavke, UmetnickoDelo umetnickoDelo) {
        this.racun = racun;
        this.rbStavke = rbStavke;
        this.kolicina = kolicina;
        this.cenaStavke = cenaStavke;
        this.umetnickoDelo = umetnickoDelo;
    }

    public StavkaRacuna() {
    }

    @Override
    public String nazivTabele() {
        return " stavkaRacuna ";
    }

    @Override
    public String alijas() {
        return " sr ";
    }

    @Override
    public String join() {
        return " JOIN racun r ON (r.racunid = sr.racunid) "
                + "JOIN klijent k ON (k.klijentid = r.klijentid) "
                + "JOIN zaposleni z ON (z.zaposleniid = r.zaposleniid) "
                + "JOIN umetnickoDelo ud ON (ud.umetnickodeloid = sr.umetnickodeloid) "
                + "JOIN tipdela td ON (td.tipdelaid = ud.tipdelaid) ";
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

            Zaposleni z = new Zaposleni(rs.getLong("ZaposleniID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            Klijent k = new Klijent(rs.getLong("KlijentID"),
                    rs.getString("JMBG"), rs.getString("ImeKlijenta"),
                    rs.getString("PrezimeKlijenta"), rs.getString("Status"), rs.getString("BrojTelefona"));

            Racun r = new Racun(rs.getLong("RacunID"), rs.getTimestamp("DatumVreme"),
                    rs.getDouble("CenaBezPopusta"), rs.getDouble("Popust"),
                    rs.getDouble("CenaSaPopustom"), k, z, null);

            StavkaRacuna sr = new StavkaRacuna(r,
                    rs.getInt("RbStavke"), rs.getInt("Kolicina"), rs.getDouble("CenaStavke"), ud);

            lista.add(sr);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (RacunID, RbStavke, Kolicina, CenaStavke, UmetnickoDeloID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " RacunID = " + racun.getRacunID();
    }

    @Override
    public String vrednostiZaInsert() {
        return racun.getRacunID() + ", " + rbStavke + ", "
                + kolicina + ", " + cenaStavke + ", " + umetnickoDelo.getUmetnickoDeloID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return " WHERE r.racunid = " + racun.getRacunID();
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public int getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCenaStavke() {
        return cenaStavke;
    }

    public void setCenaStavke(double cenaStavke) {
        this.cenaStavke = cenaStavke;
    }

    public UmetnickoDelo getUmetnickoDelo() {
        return umetnickoDelo;
    }

    public void setUmetnickoDelo(UmetnickoDelo umetnickoDelo) {
        this.umetnickoDelo = umetnickoDelo;
    }
}
