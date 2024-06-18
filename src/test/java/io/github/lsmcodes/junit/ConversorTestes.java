package io.github.lsmcodes.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class ConversorTestes {

        private Conversor conversor;

        @BeforeAll
        void configurarConversor() {
                this.conversor = new Conversor();
        }

        @BeforeEach
        void configurarValor() {
                this.conversor.setValorAtual(99.5);
        }

        @AfterEach
        void limparValor() {
                this.conversor.limparValorAtual();
        }

        @AfterAll
        void limparConversor() {
                this.conversor = null;
        }

        @Test
        @DisplayName("A")
        void converterCelsiusParaFahrenheit_DeveConverterCorretamente_QuandoReceberValorValido() {
                // Arrange
                double fahrenheit = 211.1;

                // Act
                double celsiusParaFahrenheit = this.conversor.converterCelsiusParaFahrenheit();

                // Assert
                assertEquals(fahrenheit, celsiusParaFahrenheit);
        }

        @Test
        @DisplayName("B")
        void converterFahrenheitParaCelsius_DeveConverterCorretamente_QuandoReceberValorValido() {
                // Arrange
                double celsius = 37.5;

                // Act
                double fahrenheitParaCelsius = this.conversor.converterFahrenheitParaCelsius();

                // Assert
                assertEquals(celsius, fahrenheitParaCelsius);
        }

        @Test
        @DisplayName("C")
        void converterCelsiusParaFahrenheit_DeveLancarExcecao_QuandoReceberValorNull() {
                // Arrange
                this.conversor.setValorAtual(null);

                // Assert
                assertThrows(IllegalArgumentException.class, () -> this.conversor.converterCelsiusParaFahrenheit());
        }

        @Test
        @DisplayName("D")
        void converterFahrenheitParaCelsius_DeveLancarExcecao_QuantoRececerValorNull() {
                // Arrange
                this.conversor.setValorAtual(null);

                // Assert
                assertThrows(IllegalArgumentException.class, () -> this.conversor.converterFahrenheitParaCelsius());
        }

        @Test
        @DisplayName("E")
        @EnabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_22) // List.of foi inserido no Java 9
        void historicoDoConversor_DeveCorresponderAsConversoesFeitas() {
                // Arrange
                this.conversor.limparHistorico();
                List<Double> historicoEsperado = List.of(78.8, 11.667, 87.8);

                // Act
                this.conversor.setValorAtual(26.0);
                this.conversor.converterCelsiusParaFahrenheit();

                this.conversor.setValorAtual(53.0);
                this.conversor.converterFahrenheitParaCelsius();

                this.conversor.setValorAtual(31.0);
                this.conversor.converterCelsiusParaFahrenheit();

                // Assert
                assertEquals(historicoEsperado, this.conversor.getHistorico());
        }

        @Test
        @DisplayName("F")
        void historicoDoConversor_DeveConterAQuantidadeDeConversoesFeitas() {
                // Arrange
                assumeFalse(this.conversor.getHistorico().isEmpty()); // O teste sera realizado se o historico nao estiver vazio
                int quantidadeDeConversoesFeitas = 5;

                // Act
                this.conversor.setValorAtual(26.0);
                this.conversor.converterCelsiusParaFahrenheit();

                this.conversor.setValorAtual(53.0);
                this.conversor.converterFahrenheitParaCelsius(); // Mais duas conversoes sao feitas, sendo 5 no total

                // Assert
                assertEquals(quantidadeDeConversoesFeitas, this.conversor.getHistorico().size());
        }

}