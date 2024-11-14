package br.com.catolica.gerenciamentoReservasRestaurantes.Model;

public abstract class Pessoa {

    private String nome;
    private String cpf;
    private String telefone;

    Pessoa(String nome, String cpf, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;}

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void mostrarDados(){
        System.out.println("Nome:" + nome);
        System.out.println("Telefone:" + telefone);}

    public abstract void fazerAcao();


}
