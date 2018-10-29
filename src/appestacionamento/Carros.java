package appestacionamento;

/*              -Fila dinâmica de Carros-
-Carros identificados pelo número da placa(String).
-Validação das Placas dos Carros, sem possibilidade de duplicidade.
-Validação na Fila de Carros, sem possibilidade de tentar estacionar sem ter o Carro na Fila.
-O Limite de Carros é o limite da memória do computador.
-Caso o Carro vá preencher a vaga disponível, será apresentado uma mensagem de qual vaga foi preenchida 
no momento da inserção. Exemplo: Vaga 07 - Carro - PLACA XXX-XXXX.
-Possibilidade de verificar qual é o primeiro Carro da Fila de Carros.
-Possibilidade de Imprimir todos os Carros na Fila de Carros.
 */
public class Carros {

    private No inicio;
    private No fim;
    private int qtd;

    public Carros() {
        inicio = fim = null;
        qtd = 0;
    }

    public String enqueue(String novoCarro) {
        No novoNo = new No(novoCarro);

        if (isEmpty()) {
            inicio = fim = novoNo;
            qtd++;
        } else {

            if (verificaIgualdade(novoCarro)) {
                return "O Carro Informado Já Consta na Fila.";
            } else {
                fim.prox = novoNo;
                fim = novoNo;
                qtd++;

            }
        }
        return "Carro Cadastrado com Sucesso!";

    }

    public boolean verificaIgualdade(String novoCarro) {
        boolean igual = false;
        No novoNo = new No(novoCarro);
        No temp = inicio;

        while (temp != null) {
            if (temp.dado.equals(novoNo.dado)) {
                igual = true;
            }
            temp = temp.prox;
        }
        return igual;
    }

    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        No temp = inicio;
        if (size() == 1) {
            inicio = fim = null;
        } else {
            inicio = inicio.prox;
        }
        qtd--;

        return temp.dado;
    }

    public String front() {
        if (isEmpty()) {
            return null;
        } else {
            return inicio.dado;
        }
    }

    public int size() {
        return qtd;
    }

    public boolean isEmpty() {
        return qtd == 0;
    }

    public String imprimir() {
        String saida = "";
        No atual = inicio;
        while (atual != null) {
            saida += "PLACA [" + atual.dado + "]\n";
            atual = atual.prox;
        }
        return saida;
    }

}
