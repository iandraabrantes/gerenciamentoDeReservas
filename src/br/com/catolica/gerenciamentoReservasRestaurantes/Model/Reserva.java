package br.com.catolica.gerenciamentoReservasRestaurantes.Model;

import br.com.catolica.gerenciamentoReservasRestaurantes.Enums.EnumStatusReserva;
import br.com.catolica.gerenciamentoReservasRestaurantes.Enums.EnumTipoPagamento;

public abstract class Reserva {

    private int numeroReserva;
    private EnumStatusReserva status;
    private int dia;
    private int mes;
    private int ano;
    private int hora;
    private Cliente cliente;

    public Reserva(int numeroReserva,
                   EnumStatusReserva status,
                   int dia,
                   int mes,
                   int ano,
                   int hora,
                   Cliente cliente){

        this.numeroReserva = numeroReserva;
        this.status = status;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;}
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;}


    public int getHora() {
        return hora;}
    public void setHora(int hora) {
        this.hora = hora;}

    public int getAno() {
        return ano;}
    public void setAno(int ano) {
        this.ano = ano;}

    public int getMes() {
        return mes;}
    public void setMes(int mes) {
        this.mes = mes;}

    public int getDia() {
        return dia;}
    public void setDia(int dia) {
        this.dia = dia;}

    public int getNumeroReserva() {
        return numeroReserva;}
    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;}


    public void exibirInformacoesReservas(){
        System.out.printf("Número da reserva: %d%n", numeroReserva);
        System.out.printf("Cliente: %s%n", cliente.getNome());
        System.out.printf("Data: %02d/%02d/%04d | Hora: %02d%n", dia, mes, ano, hora);
    }

    public abstract double valorConta();

}
