package appestacionamento;

import javax.swing.JOptionPane;

/*          -Classe Main contendo a interação com o Usuário-

 */
public class AppEstacionamento {

    public static void main(String[] args) {

        int opcao;

        int vagasTotal = Integer.parseInt(JOptionPane.showInputDialog("======APP Estacionamento======\n\n"
                + "Informe o Número de Vagas do Estacionamento:"));

        Vagas vagas = new Vagas(vagasTotal);

        Carros novoCarro = new Carros();

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("======APP Estacionamento======\n\n"
                    + "1 - Cadastrar o Número da Placa do Carro. \n"
                    + "2 - Estacionar o Carro em uma Vaga. \n"
                    + "3 - Retirar o Carro da Vaga. \n"
                    + "4 - Buscar o Carro por Número de Placa.\n"
                    + "5 - Extrato dos Carros Estacionados. \n"
                    + "6 - Extrato da Fila de Carros. \n"
                    + "7 - Sair. \n"));

            switch (opcao) {
                case 1:
                    String placa = JOptionPane.showInputDialog("Informe o Número da Placa do Carro:");

                    JOptionPane.showMessageDialog(null, novoCarro.enqueue(placa));

                    break;
                case 2:
                    if (vagas.isFull()) {
                        JOptionPane.showMessageDialog(null, "Estacionamento Cheio!");

                    } else if (novoCarro.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não há Carros na Fila de Espera!");

                    } else if (vagas.verificaIgualdade(novoCarro.front())) {
                        JOptionPane.showMessageDialog(null, "O Carro já Consta Estacionado!");

                        novoCarro.dequeue();

                        JOptionPane.showMessageDialog(null, "Carro Removido da Fila!");

                    } else {
                        String placaTemp = novoCarro.front();

                        vagas.add(novoCarro.dequeue());

                        vagasTotal--;

                        JOptionPane.showMessageDialog(null, "====Extrato do Estacionamento====\n"
                                + "Placa do Carro[  " + placaTemp + "  ] \n"
                                + "Número da Vaga Ocupada[  " + vagas.buscaCarro(placaTemp) + "  ] \n"
                                + "Vagas Disponíveis[  " + vagasTotal + "  ]");

                    }
                    break;
                case 3:
                    if (vagas.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Vagas do Estacionamento Vazias!");

                    } else {
                        int numVaga = Integer.parseInt(JOptionPane.showInputDialog("Informe o Número da Vaga do Carro a Ser Retirado:"));

                        String temp = vagas.remove(numVaga);

                        if (temp == null) {
                            JOptionPane.showMessageDialog(null, "Número de Vaga Inválido!");

                        } else {

                            vagasTotal++;

                            JOptionPane.showMessageDialog(null, "Carro Retirado Com Sucesso!");

                            JOptionPane.showMessageDialog(null, "====Extrato do Carro====\n"
                                    + "Placa do Carro[  " + temp + "  ] \n"
                                    + "Número da Vaga Desocupada[  " + numVaga + "  ] \n"
                                    + "Vagas Disponíveis[ " + vagasTotal + "  ]");

                        }
                    }
                    break;
                case 4:
                    if (vagas.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Vagas do Estacionamento Vazias!");

                    } else {
                        String numPlaca = JOptionPane.showInputDialog("Informe o Número da Placa do Carro:");

                        JOptionPane.showMessageDialog(null, "O Carro Está Estacionado na VAGA [  " + vagas.buscaCarro(numPlaca.toUpperCase()) + "  ]");
                    }
                    break;
                case 5:
                    if (vagas.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Vagas do Estacionamento Vazias!");

                    } else {
                        JOptionPane.showMessageDialog(null, "====Extrato dos Carros Estacionados====\n"
                                + vagas.imprimir() + "\n");
                    }
                    break;
                case 6:
                    if (novoCarro.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não há Carros na Fila de Espera!");

                    } else {
                        JOptionPane.showMessageDialog(null, "====Extrato da Fila de Carros====\n"
                                + novoCarro.imprimir() + "\n");
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
            }

        } while (opcao != 7);
    }

}
