import java.util.Date;

public class OperacaoDeposito extends Operacao {
    OperacaoDeposito(double valor){
        this.setTipo('d');
        this.setValor(valor);
        this.data = new Date();

        totalOperacoes++;
    }
}
