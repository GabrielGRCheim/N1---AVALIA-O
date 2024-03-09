/*
 * Copyright (C) 2024 Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package avaliacao.n1;

/**
 *
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 08/03/2024
 * @brief Class Prova1
 */
import java.util.Scanner;

public class Prova1 {

    public static void main(String[] args) {

        int opcao = 0, qde_expresso = 0, qde_capuccino = 0,
                qde_leite_com_cafe = 0, qde_pao_de_queijo = 0, qde_de_bolinho = 0, qde_cafes_vendidos, qde_de_pecas;
        double valor_expresso, valor_capuccino, valor_pao_de_queijo, valor_bolinho,
                valor_leite_com_cafe, valor_cafes_vendidos, valor_pecas, valor_total_da_compra;

        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("Forneça uma opção: \n"
                    + "1 ­ café expresso; \n"
                    + "2 ­ café capuccino; \n"
                    + "3 ­ leite com café; \n"
                    + "4  pão de queio; \n"
                    + "5  bolinho; \n"
                    + "6  Remover um item do carrinho;\n"
                    + "7 ­ totalizar vendas;");

            opcao = sc.nextInt();

            if (opcao == 1) {
                qde_expresso++;
            } else if (opcao == 2) {
                qde_capuccino++;
            } else if (opcao == 3) {
                qde_leite_com_cafe++;
            } else if (opcao == 4) {
                qde_pao_de_queijo++;
            } else if (opcao == 5) {
                qde_de_bolinho++;
            } else if (opcao == 6) {
                while (true) {
                    System.out.println("Qual item deseja remover?\n"
                            + "1 ­ café expresso; \n"
                            + "2 ­ café capuccino; \n"
                            + "3 ­ leite com café; \n"
                            + "4  pão de queio; \n"
                            + "5  bolinho;\n"
                            + "6  Cancelar;");

                    opcao = sc.nextInt();

                    if (opcao == 1 && qde_expresso > 0) {
                        qde_expresso--;
                        break;
                    } else if (opcao == 2 && qde_capuccino > 0) {
                        qde_capuccino--;
                        break;
                    } else if (opcao == 3 && qde_leite_com_cafe > 0) {
                        qde_leite_com_cafe--;
                        break;
                    } else if (opcao == 4 && qde_pao_de_queijo > 0) {
                        qde_pao_de_queijo--;
                        break;
                    } else if (opcao == 5 && qde_de_bolinho > 0) {
                        qde_de_bolinho--;
                        break;
                    } else if (opcao == 6) {
                        break;
                    } else if (opcao != 6) {
                        System.out.println("O item selecionado não existe ou você não possui esse item em seu carrinho!!");
                        System.out.println("Tente novamente!");
                    }
                }
            } else if (opcao != 7) {
                System.out.println("Opção inválida");
            }

        } while (opcao != 7);

        valor_expresso = qde_expresso * 0.75;
        valor_capuccino = qde_capuccino;
        valor_leite_com_cafe = qde_leite_com_cafe * 1.25;
        valor_pao_de_queijo = qde_pao_de_queijo * 1.50;
        valor_bolinho = qde_de_bolinho;
        qde_de_pecas = qde_pao_de_queijo + qde_de_bolinho;
        valor_pecas = valor_pao_de_queijo + valor_bolinho;
        qde_cafes_vendidos = qde_expresso + qde_capuccino + qde_leite_com_cafe;
        valor_cafes_vendidos = valor_expresso + valor_capuccino + valor_leite_com_cafe;
        valor_total_da_compra = valor_cafes_vendidos + valor_pecas;

        System.out.println("Qde café expresso: " + qde_expresso + " ­ valor: " + valor_expresso);
        System.out.println("Qde café capuccino: " + qde_capuccino + " ­ valor: " + valor_capuccino);
        System.out.println("Qde leite com café: " + qde_leite_com_cafe + " ­ valor: " + valor_leite_com_cafe);
        System.out.println("Qde de pão de queijo: " + qde_pao_de_queijo + " ­ valor: " + valor_pao_de_queijo);
        System.out.println("Qde de bolinho: " + qde_de_bolinho + " ­ valor: " + valor_bolinho);
        System.out.println("Qde de Peças: " + qde_de_pecas + " ­ valor: " + valor_pecas);
        System.out.println("Qde cafés vendidos: " + qde_cafes_vendidos + " ­ valor cafés vendidos: " + valor_cafes_vendidos);
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Valor total da compra: " + " Valor: " + valor_total_da_compra);
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
        opcao = 0;
        while (true) {
            System.out.println("Como deseja pagar a conta?\n"
                    + "1  pagar valor total da compra;\n"
                    + "2  pagar um valor parcial da compra;\n"
                    + "3  Sair;");

            opcao = sc.nextInt();

            if (opcao == 1) {
                break;
            } else if (opcao == 2) {
                System.out.println("Digite o valor que deseja pagar:");

                double valor_pagamento = sc.nextDouble();

                valor_total_da_compra = valor_total_da_compra - valor_pagamento;
            } else if (opcao == 3 && valor_total_da_compra == 0) {
                break;
            } else if (opcao != 4) {
                System.out.println("Não é possivel sair ate que o valor da compra seja totalmente pago!");
                System.out.println("Você ainda tem que pagar: " + valor_total_da_compra);
            }
        }
        System.out.println("Conta totalmente paga!\n" + "Fim");
    }

}
