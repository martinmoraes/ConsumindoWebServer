package com.martin.consumindowebserver;

/**
 * Created by 978907 on 26/10/2016.
 */
public class CEP {

    String gia;
    String bairro;
    String complemento;
    String cep;
    String ibge;
    String uf;
    String localidade;
    String logradouro;
    String unidade;


    @Override
    public String toString() {
        return "CEP{" +
                "gia='" + gia + '\'' +
                ", bairro='" + bairro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cep='" + cep + '\'' +
                ", ibge='" + ibge + '\'' +
                ", uf='" + uf + '\'' +
                ", localidade='" + localidade + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", unidade='" + unidade + '\'' +
                '}';
    }
}
