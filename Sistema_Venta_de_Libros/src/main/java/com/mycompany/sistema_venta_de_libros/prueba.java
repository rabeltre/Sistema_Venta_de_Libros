package com.mycompany.sistema_venta_de_libros;

import liquibase.exception.DatabaseException;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by root on 08/05/16.
 */
public class prueba {

    public static void main (String [ ] args) {
        Date data = new Date();
        Calendar calendar = Calendar.getInstance();
        int  dia = calendar.MONTH;

        System.out.println (data);

    } //
}
