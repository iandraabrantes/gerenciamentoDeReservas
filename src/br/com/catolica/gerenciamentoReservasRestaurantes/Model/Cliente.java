package br.com.catolica.gerenciamentoReservasRestaurantes.Model;

public class Cliente extends Pessoa {

    private String escolhas;

    public Cliente(String nome, String cpf, String telefone, String escolhas){
        super(nome, cpf, telefone);
        this.escolhas = escolhas;}

    public String getEscolhas(){
        return escolhas;}
    public void setEscolhas(String escolhas) {
        this.escolhas = escolhas;
    }

    @Override
    public void fazerAcao(){
        System.out.println("Cliente efetuou reserva.");}

    @Override
    public void mostrarDados(){
        super.mostrarDados();
        System.out.println("Escolhas:" + escolhas);}

    }

