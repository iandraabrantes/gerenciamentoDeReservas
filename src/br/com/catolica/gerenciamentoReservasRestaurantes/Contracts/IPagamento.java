package br.com.catolica.gerenciamentoReservasRestaurantes.Contracts;
import br.com.catolica.gerenciamentoReservasRestaurantes.Enums.EnumTipoPagamento;

public interface IPagamento {

    void pagarReserva(double valor, EnumTipoPagamento tipoPagamento);
}
