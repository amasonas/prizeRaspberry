## Raspberry API

Esta aplicação tem por objetivo listar, entre os ganhadores do prêmio, aquele que recebeu seus prêmios e maior e menor intervalo de tempo.

#### Requisitos

A aplicação precisa que o ambiente tenha o Java na versão 21 instalado.

#### Carga de dados inicial

Para configurar um arquivo csv para carga de dados inicial, basta acessar o arquivo `application.propperties` e alterar na linha **17** o valor da variável `data.load-csv`.

**Não remover o arquivo `movielist.csv` do projeto** 

~~Não deu tempo de configurar o teste~~ 

#### Compilação

Para compilar o projeto e efetuar os testes integrados basta executar o seguinte comando no diretório do projeto:

```
`mvn clean install`
```



#### Execução

O projeto pode ser executado via IDE ou via linha de comando executando o seguinte comando no diretório da aplicação:

```
mvn spring-boot:run
```

#### **Utilização**

Para testar a aplicação, é possível acessar via swagger após a inicialização do sistema:

`

```
http://localhost:8080/swagger-ui/index.html`
```

O endereço do recurso para ser acessado e efetuar a consulta é o exibido abaixo:


```
http://localhost:8080/api/prize-intervals
```