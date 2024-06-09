import java.util.Date;

public class OperacaoSaque extends Operacao {
    OperacaoSaque(double valor){
        this.setTipo('s');
        this.setValor(valor);
        this.data = new Date();

        totalOperacoes++;
    }
}
