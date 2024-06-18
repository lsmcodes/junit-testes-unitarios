package io.github.lsmcodes.junit;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Conversor {

        private Double valorAtual;
        private List<Double> historico;

        public Conversor() {
                this.historico = new ArrayList<>();
        }

        public Double getValorAtual() {
                return valorAtual;
        }

        public List<Double> getHistorico() {
                return historico;
        }

        public void setValorAtual(Double valorAtual) {
                this.valorAtual = valorAtual;
        }

        public double converterCelsiusParaFahrenheit() {
                Double celsius = getValorAtual();
                double fahrenheit = 0;

                if (celsius != null){
                        fahrenheit = celsius * 9 / 5 + 32;
                        fahrenheit = formatarDouble(fahrenheit);

                        setValorAtual(fahrenheit);
                        getHistorico().add(getValorAtual());
                } else {
                        throw new IllegalArgumentException();
                }

                return getValorAtual();
        }

        public double converterFahrenheitParaCelsius() {
                Double fahrenheit = getValorAtual();
                double celsius = 0;

                if (fahrenheit != null) {
                        celsius = (fahrenheit - 32) * 5 / 9;
                        celsius = formatarDouble(celsius);

                        setValorAtual(celsius);
                        getHistorico().add(getValorAtual());
                } else {
                        throw new IllegalArgumentException(); 
                }

                return getValorAtual();
        }

        public double formatarDouble(double valorDouble) {
                Locale locale = Locale.US;
                String stringFormatada = NumberFormat.getInstance(locale).format(valorDouble);
                double doubleFormatado = Double.parseDouble(stringFormatada);

                return doubleFormatado;
        }

        public void limparValorAtual() {
                this.valorAtual = null;
        }

        public void limparHistorico() {
                this.historico.clear();
        }

}