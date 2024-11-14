package br.com.catolica.gerenciamentoReservasRestaurantes.Model;

import br.com.catolica.gerenciamentoReservasRestaurantes.Contracts.ICancelamento;
import br.com.catolica.gerenciamentoReservasRestaurantes.Contracts.IPagamento;
import br.com.catolica.gerenciamentoReservasRestaurantes.Enums.EnumStatusReserva;
import br.com.catolica.gerenciamentoReservasRestaurantes.Enums.EnumTipoPagamento;

public class ReservaClassica extends Reserva implements IPagamento, ICancelamento {

    private static final double valorClassica = 100.0;

    public ReservaClassica (int numeroReserva, EnumStatusReserva status, int dia, int mes, int ano, int hora, Cliente cliente){
        super(numeroReserva, status, dia, mes, ano, hora, cliente);
    }

    @Override
    public double valorConta(){
        return valorClassica;
    }

    @Override
    public void pagarReserva(double valorClassica, EnumTipoPagamento tipo){
        System.out.printf("Pagamento via %s concluído para reserva clássica.", tipo);
    }

    @Override
    public void cancelarReserva(){
        System.out.println("Reserva clássica cancelada.");
    }
}
