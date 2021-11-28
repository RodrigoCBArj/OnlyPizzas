package br.com.uninassau.OnlyPizzas.utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

    public static String pegarDataAtual() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date data = new Date();

        return formatador.format(data);
    }
}