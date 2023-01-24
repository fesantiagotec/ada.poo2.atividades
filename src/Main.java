/*
Você quer vender um notebook e está aceitando pagamento no cartão,
porém existem algumas taxas da maquininha e
você quer saber quanto você irá receber vendendo seu notebook no débito,
no crédito à vista ou no crédito parcelado.
Para isso, crie uma interface:
• O nome da interface deverá ser TaxaMaquininha;
• Deverá ter um único método chamado getValorTaxa(),
que não recebe nada e devolve um double.
As taxas são a partir de 0,95% no débito; 0,99% no crédito à vista
e de 9,99% no parcelado.
Na classe Main deverá imprimir:
• "Valor cobrado pela venda do Notebook no 'opcaoDePagamentoAqui'
foi 'valorX' e você irá receber 'valorY'"
 */

import br.com.ada.polotech.atividade1.TaxaMaquininha;
import br.com.ada.polotech.atividade1.TaxaMaquininhaAVista;
import br.com.ada.polotech.atividade1.TaxaMaquininhaDebito;
import br.com.ada.polotech.atividade1.TaxaMaquininhaParcelado;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tipo;
        Double valorPagamento;
        OpcaoDePagamento opcaoDePagamentoAqui = OpcaoDePagamento.PAGAMENTO_AVISTA;

        //System.out.println("MENU");

        System.out.println("Informe o valor do notebook: ");
        valorPagamento = scanner.nextDouble();

        Double valorAReceber = null;

        switch (opcaoDePagamentoAqui) {
            case PAGAMENTO_DEBITO:
                valorAReceber = valorPagamento * (1 - new TaxaMaquininhaDebito().getValorTaxa()/100);
                break;
            case PAGAMENTO_AVISTA:
                valorAReceber = valorPagamento * (1 - new TaxaMaquininhaAVista().getValorTaxa()/100);
                break;
            case PAGAMENTO_PARCELADO:
                valorAReceber = valorPagamento * (1 - new TaxaMaquininhaParcelado().getValorTaxa()/100);
                break;
        }

        System.out.printf("O Valor cobrado da taxa da maquininha pela venda do Notebook no %s foi %.2f e você irá receber %.2f", opcaoDePagamentoAqui.toString(), valorPagamento, valorAReceber);
    }

    public enum OpcaoDePagamento {
        PAGAMENTO_DEBITO("Débito"),
        PAGAMENTO_AVISTA("Crédito a Vista"),
        PAGAMENTO_PARCELADO("Crédito Parcelado");

        private String valor;

        OpcaoDePagamento(String valor) {
            this.valor = valor;
        }

        @Override
        public String toString() {
            return this.valor;
        }
    }
}