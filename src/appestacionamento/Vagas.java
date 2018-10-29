package appestacionamento;

/*          -Lista Estática de Vagas-
-O estacionamento tera um número de Vagas Fixo.
-Possibilidade de determinar o número de Vagas que o estacionamento irá ter no Construtor.
-Vetor vagas[] contendo o número da placa(String) de cada carro estacionado.
-Variável qtd para contabilizar quantos Carros estão estacionados.

obs: A lista é preenchida seguidamente "0,1,2,3...".length ou seja sempre q um Carro chegar
ele ira estacionar na primeira vaga disponível e assim por diante.
 */
public class Vagas {

    private String vagas[];
    private int qtd;

    public Vagas(int numVagas) {
        vagas = new String[numVagas];
    }

    public void add(String novoCarro) {
        for (int i = 0; i < vagas.length; i++) {
            if (vagas[i] == null) {
                vagas[i] = novoCarro;
                qtd++;
                break;
            }
        }

    }

    public boolean verificaIgualdade(String novoCarro) {
        for (String vaga : vagas) {
            if (novoCarro.equals(vaga)) {
                return true;
            }
        }
        return false;

    }

    public int buscaCarro(String novoCarro) {
        for (int i = 0; i < vagas.length; i++) {
            if (vagas[i].equals(novoCarro)) {
                return i;
            }
        }
        return -1;
    }

    public String remove(int vaga) {
        if (vaga >= 0 && vaga < vagas.length) {
            String temp = vagas[vaga];
            vagas[vaga] = null;
            qtd--;
            return temp;
        } else {
            return null;

        }
    }

    public boolean isEmpty() {
        return qtd == 0;
    }

    public boolean isFull() {
        return qtd == vagas.length;
    }

    public String imprimir() {
        String saida = "";

        for (int i = 0; i < vagas.length; i++) {
            if (vagas[i] != null) {
                saida += "PLACA [" + vagas[i] + "]" + " - VAGA[" + (i) + "]\n";
            }
        }

        return saida;
    }

}
