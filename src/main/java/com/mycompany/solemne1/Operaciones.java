package com.mycompany.solemne1;

import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;


@Path("/")
public class Operaciones {
    
    @GET
    @Path("/Operadores")
    public String getOperacion(@QueryParam("numeros") String numeros){
        String Numeros[] = numeros.split(",");
        double suma, resta, multiplicacion, division;
        suma = Double.parseDouble(Numeros[0]) + Double.parseDouble(Numeros[1]);
        resta = Double.parseDouble(Numeros[0]) - Double.parseDouble(Numeros[1]);
        multiplicacion = Double.parseDouble(Numeros[0]) * Double.parseDouble(Numeros[1]);
        division = Double.parseDouble(Numeros[0]) / Double.parseDouble(Numeros[1]);
        return "Suma: " + suma + " Resta: " + resta + " Multiplicacion: " + multiplicacion + " Division: " + division;
    }
    
    @GET
    @Path("/TextoInvertido")
    public String getTextInvertido(@QueryParam("cadena") String texto){
        String textoInvertido = "";
        String textoInvertido2 = "";
        for (int x=texto.length()-1;x>=0;x--){
		textoInvertido = textoInvertido + texto.toUpperCase().charAt(x);
                textoInvertido2 = textoInvertido2 + texto.toLowerCase().charAt(x);
        }
        return "Minuscula: " + textoInvertido2 + "      Mayuscula: " + textoInvertido;
    }
    
    @GET
    @Path("/random")
    public String getRandomQuery(@QueryParam("numeros") String numeros) {
        String ListaNumeros[] = numeros.split(",");
          
        if(Integer.parseInt(ListaNumeros[0])<Integer.parseInt(ListaNumeros[1])){
            Random generadorAleatorios = new Random();
        
            int numeroAleatorio = Integer.parseInt(ListaNumeros[0])+generadorAleatorios.nextInt(Integer.parseInt(ListaNumeros[1])-Integer.parseInt(ListaNumeros[0]));
       
            return "Numero aleatorio entre: " +ListaNumeros[0]+ " y "+ ListaNumeros[1]+" : "+ numeroAleatorio;
        }
        else return "Primer numero debe ser mayor que el segundo";
    }

}
