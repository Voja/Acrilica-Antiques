/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import domain.Klijent;
import domain.Materijal;
import domain.Racun;
import domain.StavkaRacuna;
import domain.TipDela;
import domain.UmetnickoDelo;
import domain.Zaposleni;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Vojislav
 */
public class ThreadClient extends Thread {

    private Socket socket;

    ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request req = (Request) in.readObject();
                Response res = handleRequest(req);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request req) {
        Response res = new Response(null, null, ResponseStatus.Success);
        try {
            switch (req.getOperation()) {
                case Operation.ADD_KLIJENT:
                    ServerController.getInstance().addKlijent((Klijent) req.getData());
                    break;
                case Operation.ADD_RACUN:
                    ServerController.getInstance().addRacun((Racun) req.getData());
                    break;
                case Operation.ADD_UMETNICKO_DELO:
                    ServerController.getInstance().addUmetnickoDelo((UmetnickoDelo) req.getData());
                    break;
                case Operation.DELETE_KLIJENT:
                    ServerController.getInstance().deleteKlijent((Klijent) req.getData());
                    break;
                case Operation.DELETE_UMETNICKO_DELO:
                    ServerController.getInstance().deleteUmetnickoDelo((UmetnickoDelo) req.getData());
                    break;
                case Operation.UPDATE_KLIJENT:
                    ServerController.getInstance().updateKlijent((Klijent) req.getData());
                    break;
                case Operation.UPDATE_UMETNICKO_DELO:
                    ServerController.getInstance().updateUmetnickoDelo((UmetnickoDelo) req.getData());
                    break;
                case Operation.GET_ALL_KLIJENT:
                    res.setData(ServerController.getInstance().getAllKlijent());
                    break;
                case Operation.GET_ALL_MATERIJAL:
                    res.setData(ServerController.getInstance().getAllMaterijal((UmetnickoDelo)req.getData()));
                    break;
                case Operation.GET_ALL_RACUN:
                    res.setData(ServerController.getInstance().getAllRacun());
                    break;
                case Operation.GET_ALL_STAVKA_RACUNA:
                    res.setData(ServerController.getInstance().getAllStavkaRacuna((Racun)req.getData()));
                    break;
                case Operation.GET_ALL_UMETNICKO_DELO:
                    res.setData(ServerController.getInstance().getAllUmetnickoDelo((TipDela)req.getData()));
                    break;
                case Operation.GET_ALL_ZAPOSLENI:
                    res.setData(ServerController.getInstance().getAllZaposleni());
                    break;
                case Operation.GET_ALL_TIP_DELA:
                    res.setData(ServerController.getInstance().getAllTipDela());
                    break;
                case Operation.LOGIN:
                    Zaposleni z = (Zaposleni) req.getData();
                    Zaposleni ulogovani = ServerController.getInstance().login(z);
                    res.setData(ulogovani);
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            res.setError(e);
            res.setResponseStatus(ResponseStatus.Error);
        }
        return res;
    }

}
