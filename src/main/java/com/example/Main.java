package com.example;

import com.example.internacao.SistemaDeInternacao;

public class Main {
    public static void main(String[] args) {
        SistemaDeInternacao hospital = new SistemaDeInternacao();

        hospital.internar("111.111.111-11", "João da Silva",
            "dor no peito, suspeita de infarto", "UNIMED");

        hospital.internar("222.222.222-22", "Maria Oliveira",
            "fratura no braço após queda", "BRADESCO_SAUDE");

        hospital.internar("333.333.333-33", "Carlos Pereira",
            "consulta pré-operatória eletiva", "HAPVIDA");

        hospital.darAlta("111.111.111-11");
    }
}
