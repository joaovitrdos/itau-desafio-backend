<h1 align="center">
  API de Transações com Estatísticas
</h1>

<p align="center">
  API RESTful desenvolvida em Java com Spring Boot para registrar transações e calcular estatísticas em tempo real, mantendo os dados em memória.
</p>

---

## 🚀 Tecnologias Utilizadas

- [Java 17+](https://www.oracle.com/java/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Web (MVC)](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [SpringDoc OpenAPI 3](https://springdoc.org/)
- [Lombok](https://projectlombok.org/) *(opcional)*
- [JUnit 5](https://junit.org/junit5/) & [Mockito](https://site.mockito.org/) – para testes automatizados

---

## 💡 Funcionalidades

A API permite:

- ✅ Registrar novas transações
- ✅ Excluir todas as transações
- ✅ Calcular estatísticas baseadas nas transações dos **últimos 60 segundos**
- ✅ Documentação interativa da API com Swagger (OpenAPI 3)
- ✅ Validação de dados e tratamento de erros

---

## 📦 Como Executar o Projeto

### 🔧 Pré-requisitos

- Java 17 ou superior
- Maven

### 🧪 Build e execução local

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/api-transacoes-estatisticas.git
cd api-transacoes-estatisticas

# Compile o projeto
./mvnw clean package

# Rode a aplicação
java -jar target/api-transacoes-0.0.1-SNAPSHOT.jar
````

---

## 📌 Endpoints principais

### ▶️ Criar uma transação

```http
POST /transacao
Content-Type: application/json

{
  "valor": 123.45,
  "dataHora": "2025-09-02T10:00:00-03:00"
}
```

* **201 Created**: Transação registrada com sucesso
* **422 Unprocessable Entity**: Dados inválidos (ex: valor negativo)
* **400 Bad Request**: Erro de sintaxe no JSON

---

### 🧹 Remover todas as transações

```http
DELETE /transacao
```

* **200 OK**: Todas as transações foram apagadas

---

### 📊 Obter estatísticas das transações dos últimos 60 segundos

```http
GET /estatistica
```

**Resposta esperada:**

```json
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 123.56
}
```

---

## 🧪 Testes

```bash
./mvnw test
```

Os testes unitários cobrem os principais fluxos da aplicação, incluindo os casos de erro.

---

## 🔍 Swagger / OpenAPI

A documentação interativa da API estará disponível em:

* [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🛠️ Boas Práticas Aplicadas

* Princípios **SOLID**
* Código limpo e reutilizável (**DRY**, **KISS**)
* Injeção de dependência com Spring
* Validações com Bean Validation
* API RESTful seguindo boas práticas de design
* Tratamento de erros com `@ControllerAdvice`
* Dados mantidos **100% em memória** (sem banco de dados)


