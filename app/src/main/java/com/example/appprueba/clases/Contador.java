package com.example.appprueba.clases;

public class Contador {
    private int contador = 0;

    public int getContador(){
        return this.contador;
    }

    public void sumarContador(){
        contador = contador + 1;
    }

    public void reiniciarContador(){
        this.contador = 0;
    }
}
