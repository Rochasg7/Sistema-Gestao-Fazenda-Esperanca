# Sistema de Gestão - Fazenda Esperança

## Integrantes do Grupo

* Gabriel Rocha
* Fellipe Augusto Areas Vieira
* Jorge Ricardo Carvalho Simões
* Luiz Miguel

---

# Sobre o Projeto

O Sistema de Gestão - Fazenda Esperança foi desenvolvido como Trabalho de Conclusão de Módulo da disciplina de Desenvolvimento de Programas Estruturados e Modularização.

O objetivo do projeto é auxiliar no gerenciamento da produção agrícola da fazenda, permitindo o controle de:

* Funcionários
* Talhões
* Frota de tratores
* Registros de colheita
* Persistência de dados em arquivos CSV

O sistema foi desenvolvido utilizando apenas os conteúdos ensinados em sala, respeitando as limitações técnicas definidas pelo professor.

---

# Funcionalidades do Sistema

## Gestão de Funcionários

Permite:

* Cadastrar funcionários
* Listar funcionários
* Buscar funcionários pela matrícula
* Validar matrículas duplicadas

Dados armazenados:

* Nome
* Matrícula
* Tipo de contrato

---

## Gestão de Talhões

Permite:

* Cadastrar talhões
* Listar talhões
* Buscar talhões pelo código
* Validar códigos duplicados

Dados armazenados:

* Código
* Nome
* Variedade do café
* Estimativa de produção
* Produção atual

---

## Gestão da Frota

Permite:

* Cadastrar tratores
* Listar tratores
* Buscar tratores pela placa
* Validar placas duplicadas
* Validar capacidade máxima da carreta

Dados armazenados:

* Placa
* Capacidade máxima

---

## Registro de Colheita

Permite:

* Registrar colheitas
* Listar registros realizados
* Relacionar funcionários, talhões e tratores
* Validar dados cruzados

Dados armazenados:

* Data
* Matrícula do funcionário
* Código do talhão
* Placa do trator
* Quantidade de litros
* Destino da carga

---

# Regras de Negócio Implementadas

O sistema realiza validações importantes durante os lançamentos.

## Funcionários

* Não permite cadastrar matrículas duplicadas
* Não permite registrar colheita de funcionário inexistente

## Talhões

* Não permite cadastrar códigos duplicados
* Não permite registrar colheita em talhão inexistente

## Frota

* Não permite cadastrar placas duplicadas
* Não permite registrar colheita em trator inexistente
* Não permite exceder a capacidade máxima da carreta

---

# Persistência de Dados

Os dados do sistema são salvos em arquivos CSV dentro da pasta:

```txt
banco/
```

Arquivos utilizados:

```txt
banco/funcionarios.csv
banco/talhoes.csv
banco/frota.csv
banco/registros.csv
```

Ao iniciar o sistema, os dados são carregados automaticamente.

Ao cadastrar novos dados, o sistema salva automaticamente nos arquivos CSV.

---

# Estrutura do Projeto

```txt
src/
 ├── Equipe/
 ├── Frota/
 ├── Talhoes/
 ├── Registros/
 └── SistemaPrincipal.java

banco/
 ├── funcionarios.csv
 ├── talhoes.csv
 ├── frota.csv
 └── registros.csv
```

---

# Organização dos Módulos

Cada módulo foi separado em:

* Classe de cadastro
* Classe de menu
* Classe de persistência
* Classe modelo

Exemplo:

```txt
CadastroFrota.java
MenuFrota.java
PersistenciaFrota.java
Frota.java
```

Essa organização foi utilizada para melhorar:

* Leitura do código
* Organização
* Modularização
* Manutenção do sistema

---

# Tecnologias Utilizadas

* Java
* Programação Orientada a Objetos
* Vetores
* Modularização
* Arquivos CSV
* Git
* GitHub
* VSCode

---

# Limitações Técnicas Respeitadas

Conforme solicitado pelo professor, o sistema foi desenvolvido apenas com os conteúdos ensinados em sala.

Não foram utilizados:

* Banco de dados SQL
* ArrayList
* Frameworks
* Bibliotecas externas
* Streams
* Lambda
* Generics avançados
* Estruturas não ensinadas na disciplina

---

# Uso de IA no Projeto

A utilização de Inteligência Artificial foi usada como ferramenta de apoio durante o desenvolvimento.

O grupo teve o cuidado de revisar, adaptar e simplificar os códigos gerados para manter o padrão ensinado na disciplina.

---

# Diário da IA

## 1. Quais ferramentas e bibliotecas proibidas a IA tentou incluir?

Durante o desenvolvimento, a IA tentou utilizar algumas estruturas e bibliotecas que ainda não haviam sido ensinadas na disciplina.

Principais exemplos:

* ArrayList
* BufferedWriter
* BufferedReader
* try-with-resources
* Streams
* Collections
* Arquiteturas avançadas

O grupo precisou adaptar o código para o padrão exigido pelo professor.

---

## 2. Como foi o prompt usado para obrigar a IA a refatorar o código?

O grupo utilizou prompts solicitando:

* Uso apenas de conteúdos ensinados em sala
* Utilização de vetores ao invés de ArrayList
* Persistência simples em CSV
* Estrutura modular simples
* Código acadêmico e didático
* Comentários humanizados
* Evitar bibliotecas avançadas
* Evitar estruturas enterprise

Também foi solicitado:

* Padronização visual
* Organização dos menus
* Validações simples
* Código fácil de explicar na apresentação

---

## 3. Qual regra de negócio a IA falhou em fazer?

Em alguns momentos, a IA gerou persistência utilizando BufferedWriter e BufferedReader, estruturas que ainda não haviam sido ensinadas na disciplina.

O grupo precisou refatorar manualmente para utilizar apenas:

* File
* FileWriter
* Scanner

Também foi necessário corrigir:

* Organização de módulos
* Nomes inconsistentes
* Classes duplicadas
* Persistência cruzada
* Ajustes de validação

---

# Funcionalidade Extra

Como diferencial, o sistema possui mini listagens antes das buscas, facilitando a visualização dos dados cadastrados.

Exemplo:

* Lista de tratores antes da busca
* Lista de funcionários antes da busca
* Lista de talhões antes da busca

Essa funcionalidade melhora:

* Usabilidade
* Rapidez das consultas
* Experiência do usuário

---

# Como Executar o Projeto

1. Clone o repositório:

```bash
git clone [LINK DO REPOSITÓRIO]
```

2. Abra o projeto no VSCode

3. Execute o arquivo:

```txt
SistemaPrincipal.java
```

---

# Considerações Finais

O projeto foi desenvolvido com foco em:

* Organização
* Modularização
* Persistência de dados
* Validação de informações
* Trabalho em equipe
* Uso correto da lógica de programação

Além do funcionamento do sistema, o grupo buscou manter o código limpo, padronizado e fácil de compreender.

O desenvolvimento também contribuiu para o aprendizado de:

* Estruturação de projetos
* Versionamento com Git e GitHub
* Modularização
* Persistência em arquivos
* Validações cruzadas
* Trabalho colaborativo

---

# Repositório

Adicionar link do GitHub do projeto aqui.