package br.com.catolica.gerenciamentoReservasRestaurantes.Contracts;
import br.com.catolica.gerenciamentoReservasRestaurantes.Enums.EnumTipoNotificacao;

public interface INotificacao {

    void enviarNotificacao(EnumTipoNotificacao tipoNotificacao);
}
