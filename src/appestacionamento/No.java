package appestacionamento;

/*         -Classe No-
-Classe que tem a possibilidade de estanciar um Objeto do tipo No.
-O dado(String), armazenará o número da Placa do Carro.
-O prox irá dar a possibilidade de guardar uma referência do próximo Objeto do tipo No.
 */
public class No {

    String dado;
    No prox;

    public No(String novoDado) {
        this.dado = novoDado.toUpperCase();
        this.prox = null;
    }

}
