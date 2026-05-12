package com.example.internacao;

import com.example.subsistema.Triagem;

public class ResultadoInternacao {
    private final boolean sucesso;
    private final String leito;
    private final String mensagem;
    private final Triagem.Prioridade prioridade;

    public ResultadoInternacao(boolean sucesso, String leito, String mensagem, Triagem.Prioridade prioridade) {
        this.sucesso    = sucesso;
        this.leito      = leito;
        this.mensagem   = mensagem;
        this.prioridade = prioridade;
    }

    public boolean isSucesso()              { return sucesso; }
    public String getLeito()                { return leito; }
    public String getMensagem()             { return mensagem; }
    public Triagem.Prioridade getPrioridade() { return prioridade; }
}
