/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.materijal;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Materijal;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Vojislav
 */
public class SOGetAllMaterijal extends AbstractSO {

    private ArrayList<Materijal> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Materijal)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Materijal!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> materijali = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Materijal>)(ArrayList<?>) materijali;
    }

    public ArrayList<Materijal> getLista() {
        return lista;
    }

}
