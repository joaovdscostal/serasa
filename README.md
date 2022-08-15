# Desafio Serasa Experian – Nível 3

Objetivo: Criar um serviço do tipo API RESTful, para cadastro de pessoas com score e suas regiões de afinidades

## Arquitetura Adotada
Para o projeto desenvolvido foi utilizado a arquitetura CleanArch.  Essa arquitetura, é uma arquitetura de software proposta por Robert Cecil Martin (ou Uncle Bob, como é mais conhecido) que tem por objetivo padronizar e organizar o código desenvolvido, favorecer a sua reusabilidade, assim como independência de tecnologia.

![Clean arch](docs/clean.png "Desenho de arquitetura")


## Swagger
Para acessar a documentação dos endpoints da aplicação basta acessar a url:

- localhost:8080/swagger


## Observações para o projeto:

- Banco de dados: Foi utilizado o banco h2.

- Para o projeto foi utilizada a biblioteca lombok, que é uma biblioteca Java focada em produtividade e redução de código boilerplate que, por meio de anotações adicionadas ao nosso código, ensinamos o compilador (maven ou gradle) durante o processo de compilação a criar código Java.

- Mapstructure: Biblioteca para mapeamento de objetos;