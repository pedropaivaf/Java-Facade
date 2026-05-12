# Sistema de Internação Hospitalar

Projeto da faculdade sobre o padrão **Facade**. O cenário é uma recepção hospitalar: por baixo tem vários subsistemas independentes (cadastro de paciente, triagem, validação de plano de saúde, alocação de leito), mas quem atende o balcão chama só um método e o sistema resolve tudo.

O `SistemaDeInternacao` é a fachada — esconde toda essa complexidade e expõe apenas `internar()` e `darAlta()`.

## O que tem aqui

- `CadastroPaciente` — registra e valida CPF
- `Triagem` — classifica a prioridade: EMERGENCIA, URGENTE ou ELETIVO
- `PlanoSaude` — verifica convênio e calcula coparticipação
- `AlocacaoLeito` — aloca UTI, enfermaria ou apartamento conforme a prioridade
- `SistemaDeInternacao` — a fachada que orquestra tudo isso

## Como rodar

```bash
mvn test
```

21 testes, todos passando.
