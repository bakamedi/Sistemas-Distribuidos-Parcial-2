/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aqpsoftteam.porter;

/**
 *
 * @author stalyn
 */
public class Raiz {
    
    private String palabra;
    private int cant;

    public Raiz(String palabra) {
        this.palabra = palabra;
        this.cant = 1;
    }

    public String getPalabra() {
        return palabra;
    }

    public int getCant() {
        return cant;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
    public void incrementar(Raiz raiz){
        raiz.cant = raiz.cant + 1;
    }

    @Override
    public String toString() {
        return palabra + " ==> " + cant;
    }

    
   
    
}
