/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Klijent;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Vojislav
 */
public class SOAddKlijent extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Klijent)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Klijent!");
        }

        Klijent k = (Klijent) ado;

        if (k.getJMBG().length() != 13) {
            throw new Exception("Sistem ne moze da kreira klijenta.");
        }

        if (k.getJMBG().matches(".*[a-z].*")) {
            throw new Exception("JMBG moze imati samo cifre!");
        }
        
        if (k.getBrojTelefona().matches(".*[a-z].*")) {
            throw new Exception("Broj telefona moze imati samo cifre!");
        }
        
        ArrayList<Klijent> klijenti = (ArrayList<Klijent>)(ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Klijent klijent : klijenti) {
            if(klijent.getJMBG().equals(k.getJMBG())){
                throw new Exception("Vec postoji klijent s tim JMBG-om!");
            }
            if(klijent.getBrojTelefona().equals(k.getBrojTelefona())){
                throw new Exception("Vec postoji klijent s tim brojem telefona!");
            }
        }
        
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().insert(ado);
    }
    
    
}
