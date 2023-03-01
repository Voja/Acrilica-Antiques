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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author Vojislav
 */
public class SOAddUmetnickoDelo extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof UmetnickoDelo)) {
            throw new Exception("Prosledjeni objekat nije instanca klase UmetnickoDelo!");
        }
        
        UmetnickoDelo ud = (UmetnickoDelo) ado;
        
        if(ud.getMaterijali().isEmpty()){
            throw new Exception("Sistem ne moze da kreira umetnicko delo.\n(Morate uneti bar jedan materijal za umetnicko delo!)");
        }
        
        if(ud.getCena() > 999999999){
            throw new Exception("Cena mora biti manja od 999999999!");
        }
        
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        PreparedStatement ps = DBBroker.getInstance().insert(ado);
        
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long umetnickoDeloID = tableKeys.getLong(1);
        
        UmetnickoDelo ud = (UmetnickoDelo) ado;
        ud.setUmetnickoDeloID(umetnickoDeloID);

        for (Materijal materijal : ud.getMaterijali()) {
            materijal.setUmetnickoDelo(ud);
            DBBroker.getInstance().insert(materijal);
        }
        
    }

}
