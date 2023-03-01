/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.umetnickoDelo;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Materijal;
import domain.UmetnickoDelo;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author Vojislav
 */
public class SOUpdateUmetnickoDelo extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof UmetnickoDelo)) {
            throw new Exception("Prosledjeni objekat nije instanca klase UmetnickoDelo!");
        }
        
        UmetnickoDelo ud = (UmetnickoDelo) ado;
        
        if(ud.getMaterijali().isEmpty()){
            throw new Exception("Sistem ne moze da izmeni umetnicko delo.\n(Morate uneti bar jedan materijal za umetnicko delo)");
        }
        
        if(ud.getCena() > 999999999){
            throw new Exception("Cena mora biti manja od 999999999!");
        }
        
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().update(ado);
        
        UmetnickoDelo ud = (UmetnickoDelo) ado;
        
        DBBroker.getInstance().delete(ud.getMaterijali().get(0));
        
        for (Materijal materijal : ud.getMaterijali()) {
            DBBroker.getInstance().insert(materijal);
        }
        
    }

}
