package br.com.catolica.gerenciamentoReservasRestaurantes.Model;

import br.com.catolica.gerenciamentoReservasRestaurantes.Contracts.ICancelamento;
import br.com.catolica.gerenciamentoReservasRestaurantes.Contracts.INotificacao;
import br.com.catolica.gerenciamentoReservasRestaurantes.Contracts.IPagamento;
import br.com.catolica.gerenciamentoReservasRestaurantes.Enums.EnumStatusReserva;
import br.com.catolica.gerenciamentoReservasRestaurantes.Enums.EnumTipoNotificacao;
import br.com.catolica.gerenciamentoReservasRestaurantes.Enums.EnumTipoPagamento;

public class ReservaExclusiva extends Reserva implements ICancelamento, INotificacao, IPagamento {

    private static final double valorExclusiva = 250.0;
    private String beneficiosExclusiva;

    public ReservaExclusiva (int numeroReserva, EnumStatusReserva status, int dia, int mes, int ano, int hora, Cliente cliente, String beneficiosExclusiva){
        super(numeroReserva, status,  dia, mes, ano, hora, cliente);
        this.beneficiosExclusiva = beneficiosExclusiva;
    }

    public String getBeneficiosExclusiva() {
        return beneficiosExclusiva;
    }
    public void setBeneficiosExclusiva(String beneficiosExclusiva) {
        this.beneficiosExclusiva = beneficiosExclusiva;
    }

    @Override
    public double valorConta(){
        return valorExclusiva;
    }

    @Override
    public void pagarReserva(double valor, EnumTipoPagamento tipo){
        System.out.printf("Pagamento via %s concluído para reserva exclusiva.", tipo);
    }

    @Override
    public void cancelarReserva(){
        System.out.println("Reserva exclusiva cancelada.");
    }

    @Override
    public void enviarNotificacao(EnumTipoNotificacao tipo){
        System.out.printf("Notificação via %s enviada com sucesso.", tipo);
    }
}
