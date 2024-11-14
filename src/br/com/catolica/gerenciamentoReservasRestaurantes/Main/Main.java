package br.com.catolica.gerenciamentoReservasRestaurantes.Main;

import br.com.catolica.gerenciamentoReservasRestaurantes.Contracts.ICancelamento;
import br.com.catolica.gerenciamentoReservasRestaurantes.Contracts.IPagamento;
import br.com.catolica.gerenciamentoReservasRestaurantes.Enums.EnumStatusReserva;
import br.com.catolica.gerenciamentoReservasRestaurantes.Enums.EnumTipoNotificacao;
import br.com.catolica.gerenciamentoReservasRestaurantes.Enums.EnumTipoPagamento;
import br.com.catolica.gerenciamentoReservasRestaurantes.Model.Cliente;
import br.com.catolica.gerenciamentoReservasRestaurantes.Model.Reserva;
import br.com.catolica.gerenciamentoReservasRestaurantes.Model.ReservaClassica;
import br.com.catolica.gerenciamentoReservasRestaurantes.Model.ReservaExclusiva;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        ArrayList<Reserva> reservas = new ArrayList<>();

        int opcao;

        do {
            System.out.println("Sejam bem-vindos ao sistema de reservas do restaurante!");
            System.out.println("--------------------------------------------------------");
            System.out.println("1. Marcar reserva.");
            System.out.println("2. Mostrar reservas");
            System.out.println("3. Cancelar reserva.");
            System.out.println("4. Enviar notificação (Apenas para reservas exclusivas).");
            System.out.println("0. Sair.");
            System.out.println("--------------------------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:

                    System.out.println("Escolha o tipo de reserva:");
                    System.out.println("1. Reserva Clássica");
                    System.out.println("2. Reserva Exclusiva");
                    System.out.print("Escolha a opção: ");
                    int tipoReserva = scanner.nextInt();

                    scanner.nextLine();
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    System.out.print("Digite o telefone do cliente: ");
                    String telefoneCliente = scanner.nextLine();

                    Cliente cliente = new Cliente(nomeCliente, cpfCliente, telefoneCliente, "Escolhas: Não especificadas");

                    System.out.print("Digite o número da reserva: ");
                    int numeroReserva = scanner.nextInt();
                    System.out.print("Digite o dia da reserva: ");
                    int dia = scanner.nextInt();
                    System.out.print("Digite o mês da reserva: ");
                    int mes = scanner.nextInt();
                    System.out.print("Digite o ano da reserva: ");
                    int ano = scanner.nextInt();
                    System.out.print("Digite a hora da reserva: ");
                    int hora = scanner.nextInt();


                    System.out.println("Escolha o tipo de pagamento:");
                    System.out.println("1. Dinheiro");
                    System.out.println("2. PIX");
                    System.out.println("3. Cartão");
                    System.out.print("Escolha a opção: ");
                    int tipoPagamento = scanner.nextInt();
                    EnumTipoPagamento tipoPagamentoEnum = EnumTipoPagamento.DINHEIRO;

                    switch (tipoPagamento) {
                        case 1:
                            tipoPagamentoEnum = EnumTipoPagamento.DINHEIRO;
                            break;
                        case 2:
                            tipoPagamentoEnum = EnumTipoPagamento.PIX;
                            break;
                        case 3:
                            tipoPagamentoEnum = EnumTipoPagamento.CARTAO;
                            break;
                        default:
                            System.out.println("Opção inválida. O pagamento será considerado como dinehiro.");
                            break;
                    }


                    if (tipoReserva == 1) {
                        ReservaClassica reservaClassica = new ReservaClassica(numeroReserva, EnumStatusReserva.ATIVA, dia, mes, ano, hora, cliente);
                        reservaClassica.pagarReserva(reservaClassica.valorConta(), tipoPagamentoEnum);
                        reservas.add(reservaClassica);
                        System.out.println("Reserva Clássica marcada e paga com sucesso!");
                    } else if (tipoReserva == 2) {
                        scanner.nextLine();
                        System.out.print("Digite os benefícios exclusivos da reserva: ");
                        String beneficios = scanner.nextLine();
                        ReservaExclusiva reservaExclusiva = new ReservaExclusiva(numeroReserva, EnumStatusReserva.ATIVA, dia, mes, ano, hora, cliente, beneficios);
                        reservaExclusiva.pagarReserva(reservaExclusiva.valorConta(), tipoPagamentoEnum);
                        reservas.add(reservaExclusiva);
                        System.out.println("Reserva Exclusiva marcada e paga com sucesso!");



                        reservaExclusiva.enviarNotificacao(EnumTipoNotificacao.EMAIL);
                        System.out.println("Notificação enviada com sucesso!");
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 2:
                    System.out.println("Reservas cadastradas:");
                    for (Reserva reserva : reservas) {
                        reserva.exibirInformacoesReservas();
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.print("Digite o número da reserva para cancelar: ");
                    int numeroCancelar = scanner.nextInt();
                    boolean encontradoParaCancelar = false;


                    for (Reserva reserva : reservas) {
                        if (reserva.getNumeroReserva() == numeroCancelar) {
                            if (reserva instanceof ICancelamento) {
                                ICancelamento reservaCancelamento = (ICancelamento) reserva;
                                reservaCancelamento.cancelarReserva();
                                reservas.remove(reserva);
                                encontradoParaCancelar = true;
                                break;
                            } else {
                                System.out.println("Essa reserva não pode ser cancelada.");
                            }
                        }
                    }

                    if (!encontradoParaCancelar) {
                        System.out.println("Reserva não encontrada.");
                    } else {
                        System.out.println("Reserva cancelada com sucesso.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o número da reserva para enviar notificação: ");
                    int numeroNotificacao = scanner.nextInt();
                    boolean notificacaoEncontrada = false;

                    for (Reserva reserva : reservas) {
                        if (reserva.getNumeroReserva() == numeroNotificacao && reserva instanceof ReservaExclusiva) {
                            ((ReservaExclusiva) reserva).enviarNotificacao(EnumTipoNotificacao.EMAIL);
                            notificacaoEncontrada = true;
                            break;
                        }
                    }

                    if (!notificacaoEncontrada) {
                        System.out.println("Reserva exclusiva não encontrada ou não é uma reserva exclusiva.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}
