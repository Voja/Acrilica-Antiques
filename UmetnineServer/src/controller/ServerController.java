/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Klijent;
import domain.Materijal;
import domain.Racun;
import domain.StavkaRacuna;
import domain.TipDela;
import domain.UmetnickoDelo;
import domain.Zaposleni;
import java.util.ArrayList;
import so.AbstractSO;
import so.klijent.SOAddKlijent;
import so.klijent.SODeleteKlijent;
import so.klijent.SOGetAllKlijent;
import so.klijent.SOUpdateKlijent;
import so.login.SOLogin;
import so.materijal.SOGetAllMaterijal;
import so.racun.SOAddRacun;
import so.racun.SOGetAllRacun;
import so.stavkaRacuna.SOGetAllStavkaRacuna;
import so.tipDela.SOGetAllTipDela;
import so.umetnickoDelo.SOAddUmetnickoDelo;
import so.umetnickoDelo.SODeleteUmetnickoDelo;
import so.umetnickoDelo.SOGetAllUmetnickoDelo;
import so.umetnickoDelo.SOUpdateUmetnickoDelo;
import so.zaposleni.SOGetAllZaposleni;

/**
 *
 * @author Vojislav
 */
public class ServerController {

    private static ServerController instance;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public void addKlijent(Klijent klijent) throws Exception {
        AbstractSO aso = new SOAddKlijent();
        aso.templateExecute(klijent);
    }

    public void addRacun(Racun racun) throws Exception {
        AbstractSO aso = new SOAddRacun();
        aso.templateExecute(racun);
    }

    public void addUmetnickoDelo(UmetnickoDelo umetnickoDelo) throws Exception {
        AbstractSO aso = new SOAddUmetnickoDelo();
        aso.templateExecute(umetnickoDelo);
    }

    public void deleteKlijent(Klijent klijent) throws Exception {
        AbstractSO aso = new SODeleteKlijent();
        aso.templateExecute(klijent);
    }

    public void deleteUmetnickoDelo(UmetnickoDelo umetnickoDelo) throws Exception {
        AbstractSO aso = new SODeleteUmetnickoDelo();
        aso.templateExecute(umetnickoDelo);
    }

    public void updateKlijent(Klijent klijent) throws Exception {
        AbstractSO aso = new SOUpdateKlijent();
        aso.templateExecute(klijent);
    }

    public void updateUmetnickoDelo(UmetnickoDelo umetnickoDelo) throws Exception {
        AbstractSO aso = new SOUpdateUmetnickoDelo();
        aso.templateExecute(umetnickoDelo);
    }

    public ArrayList<Klijent> getAllKlijent() throws Exception {
        SOGetAllKlijent so = new SOGetAllKlijent();
        so.templateExecute(new Klijent());
        return so.getLista();
    }

    public ArrayList<Materijal> getAllMaterijal(UmetnickoDelo ud) throws Exception {
        SOGetAllMaterijal so = new SOGetAllMaterijal();

        Materijal m = new Materijal();
        m.setUmetnickoDelo(ud);

        so.templateExecute(m);
        return so.getLista();
    }

    public ArrayList<Racun> getAllRacun() throws Exception {
        SOGetAllRacun so = new SOGetAllRacun();
        so.templateExecute(new Racun());
        return so.getLista();
    }

    public ArrayList<StavkaRacuna> getAllStavkaRacuna(Racun r) throws Exception {
        SOGetAllStavkaRacuna so = new SOGetAllStavkaRacuna();

        StavkaRacuna sr = new StavkaRacuna();
        sr.setRacun(r);

        so.templateExecute(sr);
        return so.getLista();
    }

    public ArrayList<TipDela> getAllTipDela() throws Exception {
        SOGetAllTipDela so = new SOGetAllTipDela();
        so.templateExecute(new TipDela());
        return so.getLista();
    }

    public ArrayList<UmetnickoDelo> getAllUmetnickoDelo(TipDela td) throws Exception {
        SOGetAllUmetnickoDelo so = new SOGetAllUmetnickoDelo();

        UmetnickoDelo ud = new UmetnickoDelo();
        ud.setTipDela(td);

        so.templateExecute(ud);
        return so.getLista();
    }

    public ArrayList<Zaposleni> getAllZaposleni() throws Exception {
        SOGetAllZaposleni so = new SOGetAllZaposleni();
        so.templateExecute(new Zaposleni());
        return so.getLista();
    }

    public Zaposleni login(Zaposleni z) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(z);
        return so.getUlogovani();
    }

}
