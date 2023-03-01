/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.util;

/**
 *
 * @author Vojislav
 */
public interface Operation {

    public static final int LOGIN = 0;

    public static final int GET_ALL_ZAPOSLENI = 1;

    public static final int ADD_KLIJENT = 2;
    public static final int DELETE_KLIJENT = 3;
    public static final int UPDATE_KLIJENT = 4;
    public static final int GET_ALL_KLIJENT = 5;

    public static final int ADD_UMETNICKO_DELO = 6;
    public static final int DELETE_UMETNICKO_DELO = 7;
    public static final int UPDATE_UMETNICKO_DELO = 8;
    public static final int GET_ALL_UMETNICKO_DELO = 9;
    
    public static final int GET_ALL_TIP_DELA = 10;

    public static final int GET_ALL_MATERIJAL = 11;

    public static final int ADD_RACUN = 12;
    public static final int GET_ALL_RACUN = 13;
    
    public static final int GET_ALL_STAVKA_RACUNA = 14;

}
