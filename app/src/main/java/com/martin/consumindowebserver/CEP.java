package com.martin.consumindowebserver;

/**
 * Created by 978907 on 26/10/2016.
 */
public class CEP {

    private String gia;
    private String bairro;
    private String complemento;
    private String cep;
    private String ibge;
    private String uf;
    private String localidade;
    private String logradouro;
    private String unidade;
    private boolean erro;

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
                ", erro=" + erro +
                '}';
    }
}
