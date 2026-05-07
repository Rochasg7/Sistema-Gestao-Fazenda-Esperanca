# Sistema de Gestão - Fazenda Esperança

Projeto desenvolvido para a disciplina de Desenvolvimento de Programas Estruturados e Modularização.

Professor: Raffael Carvalho  
Entrega Final: 20/05/2026

---

# Sobre o Projeto

A Fazenda Esperança enfrenta dificuldades no controle manual da colheita de café.  
O sistema foi desenvolvido para substituir os registros em papel por uma solução computacional organizada, modular e persistente.

O objetivo principal é permitir o gerenciamento completo da operação da safra, incluindo:

- Controle de colaboradores
- Controle dos talhões
- Controle da frota de tratores
- Registro das cargas de café
- Validação automática das regras de negócio
- Geração de relatórios administrativos
- Salvamento permanente dos dados

---

# Objetivos do Sistema

O sistema deverá permitir:

## Gestão da Equipe
Cadastro de colaboradores contendo:
- Nome
- Matrícula
- Tipo de contrato
  - Diarista
  - Fixo

---

## Gestão dos Talhões
Cadastro das áreas produtivas da fazenda:
- Código
- Nome do talhão
- Variedade do café
- Estimativa de produção em litros

---

## Gestão da Frota
Cadastro dos tratores utilizados no transporte:
- Placa
- Capacidade máxima da carreta

---

## Registro de Colheita
Registro das entradas de café contendo:
- Data
- Matrícula do funcionário
- Código do talhão
- Placa do trator
- Quantidade de litros
- Destino da carga
  - Terreiro de cimento
  - Secador mecânico

---

# Regras de Negócio

O sistema deve validar automaticamente:

- Funcionário deve estar cadastrado
- Talhão deve existir
- Trator deve existir
- A carga não pode ultrapassar a capacidade do trator

O sistema não permitirá registros inválidos.

---

# Relatórios Obrigatórios

## Acerto da Quinzena
Relatório contendo:
- Total de litros colhidos por funcionário

Objetivo:
- Auxiliar no cálculo de pagamento dos colaboradores.

---

## Fechamento do Talhão
Relatório contendo:
- Produção total do talhão
- Estimativa cadastrada
- Situação da meta de produção

Objetivo:
- Acompanhar o desempenho da safra.

---

## Relatório de Secagem
Relatório contendo:
- Volume total enviado ao secador mecânico
- Volume total enviado ao terreiro

Objetivo:
- Controle da secagem do café.

---

# Funcionalidade Extra (Diferencial)

## Alerta de Excesso de Produção

Quando a produção de um talhão atingir ou ultrapassar sua estimativa inicial, o sistema exibirá:

```text
ATENÇÃO: Talhão ultrapassou a estimativa de produção!
```

Objetivo:
- Melhorar o acompanhamento agrícola
- Auxiliar a gestão da safra
- Identificar alta produtividade

---

# Estrutura do Projeto

```text
fazenda_esperanca/
│
├── main.c
├── modelos.h
│
├── equipe.c
├── equipe.h
│
├── talhoes.c
├── talhoes.h
│
├── frota.c
├── frota.h
│
├── registros.c
├── registros.h
│
├── persistencia.c
├── persistencia.h
│
├── relatorios.c
├── relatorios.h
│
├── dados/
│   ├── equipe.txt
│   ├── talhoes.txt
│   ├── frota.txt
│   └── registros.txt
│
└── README.md
```

---

# Estruturas Utilizadas

## Funcionário

```c
typedef struct {
    char nome[100];
    int matricula;
    char contrato[20];
} Funcionario;
```

---

## Talhão

```c
typedef struct {
    int codigo;
    char nome[50];
    char variedade[50];
    float estimativa;
} Talhao;
```

---

## Trator

```c
typedef struct {
    char placa[10];
    float capacidade;
} Trator;
```

---

## Registro de Colheita

```c
typedef struct {
    char data[20];
    int matricula;
    int codigoTalhao;
    char placa[10];
    float litros;
    char destino[30];
} Registro;
```

---

# Modularização

O projeto foi dividido em módulos independentes para:
- Melhor organização
- Facilidade de manutenção
- Trabalho em equipe
- Reaproveitamento de código

---

# Divisão da Equipe

## Pessoa 1 — Equipe + Menu Principal

Responsabilidades:
- Cadastro de colaboradores
- Busca por matrícula
- Menu principal
- Integração inicial

Arquivos:
- equipe.c
- equipe.h
- main.c

Funções:
```c
void cadastrarFuncionario();
void listarFuncionarios();
int buscarFuncionario(int matricula);
```

---

## Pessoa 2 — Talhões

Responsabilidades:
- Cadastro dos talhões
- Controle da estimativa
- Relatório de produção

Arquivos:
- talhoes.c
- talhoes.h

Funções:
```c
void cadastrarTalhao();
void listarTalhoes();
int buscarTalhao(int codigo);
void relatorioTalhao();
```

---

## Pessoa 3 — Frota + Validações

Responsabilidades:
- Cadastro de tratores
- Controle de capacidade
- Validação das cargas

Arquivos:
- frota.c
- frota.h

Funções:
```c
void cadastrarTrator();
void listarTratores();
int buscarTrator(char placa[]);
int validarCapacidade(char placa[], float litros);
```

---

## Pessoa 4 — Registros + Persistência + Relatórios

Responsabilidades:
- Registro de colheita
- Salvamento dos dados
- Carregamento dos dados
- Relatórios finais

Arquivos:
- registros.c
- registros.h
- persistencia.c
- persistencia.h
- relatorios.c
- relatorios.h

Funções:
```c
void registrarColheita();
void salvarDados();
void carregarDados();
void relatorioQuinzena();
void relatorioSecagem();
```

---

# Cronograma de Desenvolvimento

## Encontro 1 — Arquitetura e Cadastros Base

Objetivos:
- Planejamento do projeto no GitHub
- Criação das structs
- Criação dos menus
- Implementação dos cadastros:
  - Funcionários
  - Talhões
  - Frota

Entregas:
- Estrutura inicial funcionando
- Inserção de dados em memória

---

## Encontro 2 — Checkpoint 1

Objetivos:
- Desenvolver o registro de colheita
- Implementar validações cruzadas

Validações:
- Funcionário existente
- Talhão existente
- Trator existente
- Capacidade da carga

Entregas:
- Registro de colheita funcionando
- Sistema validando regras de negócio

---

## Encontro 3 — Checkpoint 2

Objetivos:
- Implementar persistência de dados
- Criar sistema de salvamento
- Carregar dados automaticamente

Arquivos:
- equipe.txt
- talhoes.txt
- frota.txt
- registros.txt

Entregas:
- Sistema mantendo dados após fechamento

---

## Encontro 4 — Finalização

Objetivos:
- Correção de bugs
- Ajustes finais
- Testes completos
- Implementação da funcionalidade extra
- Criação da documentação

Entregas:
- Sistema completo
- README final
- Projeto preparado para apresentação

---

# Estratégia de Trabalho

## Regra Principal

Todos os integrantes devem concordar primeiro com:
- structs
- nomes das funções
- organização dos arquivos

---

# Estratégia GitHub

Cada integrante deverá alterar apenas seus próprios arquivos.

Exemplo:
- Pessoa 1 → equipe.c
- Pessoa 2 → talhoes.c
- Pessoa 3 → frota.c
- Pessoa 4 → registros.c

Objetivo:
- Evitar conflitos
- Facilitar integração

---

# Persistência de Dados

O sistema utilizará arquivos `.txt` para armazenamento.

Arquivos:
- equipe.txt
- talhoes.txt
- frota.txt
- registros.txt

Funções utilizadas:
- fopen
- fprintf
- fscanf
- fclose

---

# Tecnologias Utilizadas

- Linguagem C
- Structs
- Vetores
- Modularização
- Arquivos texto
- Funções
- Menus com switch/case

---

# Restrições Técnicas

O projeto seguirá apenas os conteúdos ensinados na disciplina.

Não serão utilizados:
- malloc
- listas encadeadas
- ponteiros avançados
- bibliotecas externas
- arquivos binários

---

# Diário da IA

## Recursos que a IA tentou utilizar indevidamente

Durante o desenvolvimento, algumas sugestões continham:
- malloc
- ponteiros complexos
- listas dinâmicas
- estruturas não ensinadas

Esses recursos foram removidos para manter conformidade com a disciplina.

---

## Estratégia utilizada com IA

A IA foi orientada a:
- utilizar apenas programação estruturada
- trabalhar com vetores fixos
- utilizar arquivos texto
- evitar recursos avançados

---

## Problemas corrigidos manualmente

A equipe precisou ajustar:
- validações cruzadas
- integração entre módulos
- persistência dos dados
- controle da capacidade dos tratores

---

# Objetivos Acadêmicos

Este projeto busca aplicar:
- programação estruturada
- modularização
- persistência de dados
- validação de regras
- organização de código
- trabalho em equipe
- utilização de GitHub

---

# Compilação e Execução

## Compilar

```bash
gcc *.c -o sistema
```

## Executar Linux/Mac

```bash
./sistema
```

## Executar Windows

```bash
sistema.exe
```