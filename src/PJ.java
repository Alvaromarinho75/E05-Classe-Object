import java.util.Date;

public class PJ extends Cliente{
    private String cnpj;
    private int numFuncionarios;
    private String setor;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getNumFuncionarios() {
        return numFuncionarios;
    }

    public void setNumFuncionarios(int numFuncionarios) {
        this.numFuncionarios = numFuncionarios;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Cliente criarCliente(String nome, String cnpj, String endereco, int numFuncionarios, String setor) {
            this.setNome(nome);
            this.setEndereco(endereco);
            this.setNumFuncionarios(numFuncionarios);
            this.setSetor(setor);
            this.setCnpj(cnpj);
            this.data = new Date();

            return this;
    }

    public String toString(){
        String PJStr = "Nome: " + this.nome +
                "\nSetor: " + this.setor +
                "\nNum de funcionarios: " + this.numFuncionarios +
                "\nEndereco: " + this.endereco +
                "\nData da criacao: " + this.data +
                "\nCNPJ: " + this.cnpj;

        return PJStr;
    }

    public boolean equals(PJ Object){
        if(this.cnpj == Object.cnpj) return true;
        return false;
    }

}
