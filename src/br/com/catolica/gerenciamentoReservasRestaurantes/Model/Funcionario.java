package br.com.catolica.gerenciamentoReservasRestaurantes.Model;

public class Funcionario extends Pessoa {

    private String cargo;

    public Funcionario(String nome, String cpf, String telefone, String cargo){
        super(nome, cpf, telefone);
        this.cargo = cargo;}

    public String getCargo(){
        return cargo;}
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void fazerAcao(){
        System.out.println("Funcionário administrando reservas...");}

    @Override
    public void mostrarDados(){
        super.mostrarDados();
        System.out.println("Cargo:" + cargo);}


}
