package com.sanderpiva.appmatematico;

public class ProcessaProporcao {

    private double resN, resM, resN1;

    public ProcessaProporcao(String resN, String resM, String resN1) {

        this.resN=Double.parseDouble(resN);
        this.resM=Double.parseDouble(resM);
        this.resN1=Double.parseDouble(resN1);

    }

    public double calculaProporcao(){

        double numerador = this.resN1 * this.resM;
        double denominador = this.resN;

        if((numerador / denominador)<0){
            return 0;
        }
        return numerador / denominador;

    }
}
