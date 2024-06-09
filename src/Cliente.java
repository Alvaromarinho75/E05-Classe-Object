import java.util.Date;

public class Cliente {

    protected String nome;

    protected String endereco;

    protected Date data;

    public void imprimir(){
        System.out.println("Cliente Invalido.");
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }



}





