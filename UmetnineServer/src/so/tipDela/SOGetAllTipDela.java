/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tipDela;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.TipDela;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Vojislav
 */
public class SOGetAllTipDela extends AbstractSO {

    private ArrayList<TipDela> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof TipDela)) {
            throw new Exception("Prosledjeni objekat nije instanca klase TipDela!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> tipoviDela = DBBroker.getInstance().select(ado);
        lista = (ArrayList<TipDela>)(ArrayList<?>) tipoviDela;
    }

    public ArrayList<TipDela> getLista() {
        return lista;
    }

}
