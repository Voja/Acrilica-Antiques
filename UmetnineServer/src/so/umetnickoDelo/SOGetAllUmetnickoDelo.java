/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.umetnickoDelo;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.UmetnickoDelo;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Vojislav
 */
public class SOGetAllUmetnickoDelo extends AbstractSO {

    private ArrayList<UmetnickoDelo> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof UmetnickoDelo)) {
            throw new Exception("Prosledjeni objekat nije instanca klase UmetnickoDelo!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> umetnickaDela = DBBroker.getInstance().select(ado);
        lista = (ArrayList<UmetnickoDelo>)(ArrayList<?>) umetnickaDela;
    }

    public ArrayList<UmetnickoDelo> getLista() {
        return lista;
    }

}
