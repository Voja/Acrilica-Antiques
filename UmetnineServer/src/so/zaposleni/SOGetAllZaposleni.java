/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zaposleni;

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
public class SOGetAllZaposleni extends AbstractSO {

    private ArrayList<Zaposleni> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Zaposleni)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Zaposleni!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> listaZaposlenih = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Zaposleni>)(ArrayList<?>) listaZaposlenih;
    }

    public ArrayList<Zaposleni> getLista() {
        return lista;
    }

}
