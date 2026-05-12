package com.example.internacao;

import com.example.subsistema.*;

/**
 * Fachada — o balcão de recepção hospitalar aciona todos os subsistemas
 * com uma única chamada, sem expor a complexidade interna.
 */
public class SistemaDeInternacao {

    private final CadastroPaciente cadastro;
    private final Triagem triagem;
    private final PlanoSaude plano;
    private final AlocacaoLeito alocacao;

    public SistemaDeInternacao() {
        this(new CadastroPaciente(), new Triagem(), new PlanoSaude(), new AlocacaoLeito());
    }

    public SistemaDeInternacao(CadastroPaciente cadastro, Triagem triagem,
                                PlanoSaude plano, AlocacaoLeito alocacao) {
        this.cadastro  = cadastro;
        this.triagem   = triagem;
        this.plano     = plano;
        this.alocacao  = alocacao;
    }

    public ResultadoInternacao internar(String cpf, String nome, String sintomas, String operadora) {
        System.out.println("\n=== Iniciando internação: " + nome + " ===");
        boolean cadastrado = cadastro.registrar(cpf, nome);
        if (!cadastrado) return new ResultadoInternacao(false, null, "CPF ou nome inválido", null);

        Triagem.Prioridade prioridade = triagem.classificar(sintomas);
        boolean planoOk = plano.validar(operadora);
        String leito = alocacao.alocar(cpf, prioridade);

        String msg = "Internação efetuada. Leito: " + leito
            + " | Prioridade: " + prioridade
            + " | Plano: " + (planoOk ? operadora : "Particular");
        System.out.println("[Sistema] " + msg);
        return new ResultadoInternacao(true, leito, msg, prioridade);
    }

    public boolean darAlta(String cpf) {
        System.out.println("\n=== Alta médica: CPF " + cpf + " ===");
        return alocacao.liberar(cpf);
    }

    // Acesso aos subsistemas para testes
    public CadastroPaciente getCadastro()  { return cadastro;  }
    public Triagem getTriagem()            { return triagem;   }
    public PlanoSaude getPlano()           { return plano;     }
    public AlocacaoLeito getAlocacao()     { return alocacao;  }
}
