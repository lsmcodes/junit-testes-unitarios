# DIO - Trilha Testes e Gerenciamento de Dependências Java
<div style="display:inline-block">
        <picture>
                <source media="(prefers-color-scheme: light)" srcset="https://img.shields.io/badge/Java-black?style=for-the-badge&logo=OpenJDK&logoColor=white">
                <img src="https://img.shields.io/badge/Java-white?style=for-the-badge&logo=OpenJDK&logoColor=black" />
        </picture>
        <picture>
                <source media="(prefers-color-scheme: light)" srcset="https://img.shields.io/badge/Maven-black?style=for-the-badge&logo=ApacheMaven&logoColor=white">
                <img src="https://img.shields.io/badge/Maven-white?style=for-the-badge&logo=ApacheMaven&logoColor=black" />
        </picture>
        <picture>
                <source media="(prefers-color-scheme: light)" srcset="https://img.shields.io/badge/Spring_Boot-black?style=for-the-badge&logo=SpringBoot&logoColor=white">
                <img src="https://img.shields.io/badge/Spring_Boot-white?style=for-the-badge&logo=SpringBoot&logoColor=black" />
        </picture>
        <picture>
                <source media="(prefers-color-scheme: light)" srcset="https://img.shields.io/badge/JUnit5-black?style=for-the-badge&logo=JUnit5&logoColor=white">
                <img src="https://img.shields.io/badge/JUnit5-white?style=for-the-badge&logo=JUnit5&logoColor=black" />
        </picture>
</div>

## Repositório Original do Curso
- [JUnit 5 Exemplos](https://github.com/willyancaetano/junit5-exemplos)

## JUnit 5
`JUnit 5` é a geração atual do framework de testes JUnit, que provê uma base moderna para `testes` do lado de desenvolvedor na JVM (Java Virtual Machine).

## Exercícios
Este repositório contém um exercício que exemplifica a utilização do JUnit 5 e que cobre os seguintes temas:
- Before e After
- Assumptions e testes condicionais
- Testando Exceptions
- Ordenação de testes

## Configurar JUnit 5
Para utilizar o JUnit, adicione a dependência JUnit Jupiter Engine ao arquivo `pom.xml` ou ao `build.gradle` do seu projeto.
### Maven
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>
```

### Gradle
```groovy
testImplementation group: 'org.junit.jupiter', name: 'junit-jupiter-engine', version: '5.10.2'
```

## Escrevendo Testes
No exemplo a seguir há uma visão geral dos requerimentos básicos para o desenvolvimento de um teste.
```java
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.lsmcodes.junit.Conversor;

import org.junit.jupiter.api.Test;

class ConversorTestes {
        @Test
        void converterCelsiusParaFahrenheit_DeveConverterCorretamente_QuandoReceberValorValido() {
                // Arrange (arranjar)
                Conversor conversor = new Conversor();
                double fahrenheit = 74.3;
                double celsius = 23.5;

                // Act (agir)
                double celsiusParaFahrenheit = conversor.converterCelsiusParaFahrenheit(celsius);

                // Assert (afirmar)
                assertEquals(fahrenheit, celsiusParaFahrenheit);
        }
}
```

## Anotações
A seguir estão as anotações utilizadas no exercício e suas respectivas descrições.

| Anotação           | Descrição                                                               |
|--------------------|-------------------------------------------------------------------------|
| `@Test`            | Denota que o método anotado é um método de teste                        |
| `@TestMethodOrder` | Define a ordem de execução dos métodos da classe anotada                |
| `@DisplayName`     | Declara um nome customizado para a classe ou o método de teste          |
| `@BeforeEach`      | O método anotado deve ser executado antes de cada @Test                 |
| `@AfterEach`       | O método anotado deve ser executado depois de cada @Test                |
| `@BeforeAll`       | O método anotado deve ser executado antes de todos os métodos de teste  |
| `@AfterAll`        | O método anotado deve ser executado depois de todos os métodos de teste |

## Boas Práticas
### Código-fonte
É uma boa prática manter as classes de teste separadas do código principal. Então os testes são desenvolvidos, executados e mantidos separadamente do código de produção. As implementações de testes são normalmente feitas em `src/test`.

### Convenções de Nomenclatura de Packages
O package da classe de teste deve ser o mesmo da classe original da qual as unidades estão sendo testadas. Por exemplo, no exercício contido no presente repositório há a classe `Conversor` no package `src/main/java/io/github/lsmcodes/junit`, a classe de teste que vai testar as unidades dessa classe deve estar no package `src/test/java/io/github/lsmcodes/junit`.

### Convenções de Nomenclatura de Casos de Testes
Os nomes dos casos de testes devem ser descritivos de forma que seja possível compreender qual é o comportamento do teste pelo seu nome. Por exemplo, se há um método `converterCelsiusParaFahrenheit(double celsius)` o caso de teste pode ter um nome como `converterCelsiusParaFahrenheit_DeveLancarExcecao_QuandoReceberValorInvalido()`.

### 80% de Cobertura de Testes
Quanto mais cobertura de testes para o código-fonte, melhor. Mas como regra geral o ideal é alcançar a cobertura de pelo menos `80% do código` com testes unitários. Adicionalmente, é possível utilizar ferramentas como `JaCoCo` e `Cobertura` junto com Maven ou Gradle para gerar relatórios de cobertura de código.

## Referências
- JUnit 5 - https://junit.org/junit5/
- JUnit 5 User Guide - https://junit.org/junit5/docs/current/user-guide/
- Best Practices for Unit Testing - https://www.baeldung.com/java-unit-testing-best-practices