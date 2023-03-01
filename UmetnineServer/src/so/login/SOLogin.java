/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.login;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Zaposleni;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Vojislav
 */
public class SOLogin extends AbstractSO {

    Zaposleni ulogovani;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Zaposleni)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Zaposleni!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        Zaposleni z = (Zaposleni) ado;

        ArrayList<Zaposleni> sviZaposleni 
                = (ArrayList<Zaposleni>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Zaposleni zaposleni : sviZaposleni) {
            if (zaposleni.getUsername().equals(z.getUsername())
                    && zaposleni.getPassword().equals(z.getPassword())) {
                ulogovani = zaposleni;
                return;
            }
        }
        
        throw new Exception("Ne postoji zaposleni sa tim kredencijalima!");

    }

    public Zaposleni getUlogovani() {
        return ulogovani;
    }

}
