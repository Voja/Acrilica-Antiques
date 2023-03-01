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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Vojislav
 */
public class ClientController {

    private static ClientController instance;

    public ClientController() {
    }
    
    public static ClientController getInstance() {
        if(instance == null){
            instance = new ClientController();
        }
        return instance;
    }
   
    public Zaposleni login(Zaposleni zaposleni) throws Exception {
        return (Zaposleni) sendRequest(Operation.LOGIN, zaposleni);
    }

    public void addKlijent(Klijent klijent) throws Exception {
        sendRequest(Operation.ADD_KLIJENT, klijent);
    }
    
    public void addRacun(Racun racun) throws Exception {
        sendRequest(Operation.ADD_RACUN, racun);
    }
    
    public void addUmetnickoDelo(UmetnickoDelo umetnickoDelo) throws Exception {
        sendRequest(Operation.ADD_UMETNICKO_DELO, umetnickoDelo);
    }

    public void deleteKlijent(Klijent klijent) throws Exception {
        sendRequest(Operation.DELETE_KLIJENT, klijent);
    }
    
    public void deleteUmetnickoDelo(UmetnickoDelo umetnickoDelo) throws Exception {
        sendRequest(Operation.DELETE_UMETNICKO_DELO, umetnickoDelo);
    }

    public void updateKlijent(Klijent klijent) throws Exception {
        sendRequest(Operation.UPDATE_KLIJENT, klijent);
    }
    
    public void updateUmetnickoDelo(UmetnickoDelo umetnickoDelo) throws Exception {
        sendRequest(Operation.UPDATE_UMETNICKO_DELO, umetnickoDelo);
    }

    public ArrayList<Klijent> getAllKlijent() throws Exception {
        return (ArrayList<Klijent>) sendRequest(Operation.GET_ALL_KLIJENT, null);
    }
    
    public ArrayList<Materijal> getAllMaterijal(UmetnickoDelo ud) throws Exception {
        return (ArrayList<Materijal>) sendRequest(Operation.GET_ALL_MATERIJAL, ud);
    }
    
    public ArrayList<Racun> getAllRacun() throws Exception {
        return (ArrayList<Racun>) sendRequest(Operation.GET_ALL_RACUN, null);
    }
    
    public ArrayList<StavkaRacuna> getAllStavkaRacuna(Racun r) throws Exception {
        return (ArrayList<StavkaRacuna>) sendRequest(Operation.GET_ALL_STAVKA_RACUNA, r);
    }
    
    public ArrayList<TipDela> getAllTipDela() throws Exception {
        return (ArrayList<TipDela>) sendRequest(Operation.GET_ALL_TIP_DELA, null);
    }
    
    public ArrayList<UmetnickoDelo> getAllUmetnickoDelo(TipDela td) throws Exception {
        return (ArrayList<UmetnickoDelo>) sendRequest(Operation.GET_ALL_UMETNICKO_DELO, td);
    }
    
    public ArrayList<Zaposleni> getAllZaposleni() throws Exception {
        return (ArrayList<Zaposleni>) sendRequest(Operation.GET_ALL_ZAPOSLENI, null);
    }

    private Object sendRequest(int operation, Object data) throws Exception {
        Request req = new Request(operation, data);
        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(req);
        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response res = (Response) in.readObject();
        if (res.getResponseStatus().equals(ResponseStatus.Error)) {
            throw res.getError();
        } else {
            return res.getData();
        }
    }
}
