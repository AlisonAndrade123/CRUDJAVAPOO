package teste;

import Aluno.Aluno;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Aluno[] alunos = new Aluno[10];
        int tam = 0;

        String menu = """
        Sistema de cadastro de alunos
        --------------
        1 - Cadastrar
        2 - Remover
        3 - Alterar
        4 - Listar
        5 - Sair
        --------------
        Digite uma opção: """;

        String op;
        Scanner sc = new Scanner(System.in);
        boolean parar = false;

        while (!parar) {
            System.out.print(menu);
            op = sc.nextLine();
            switch (op) {
                case "1":
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Ano de nascimento: ");
                    int ano = sc.nextInt();
                    sc.nextLine();

                    alunos[tam] = new Aluno(nome, ano);
                    tam++;

                    break;

                case "2":
                    // Remoção
                    System.out.print("Digite o nome do aluno que deseja remover: ");
                    String nomeRemover = sc.nextLine();
                    boolean encontradoRemover = false;

                    for (int i = 0; i < tam; i++) {
                        if (alunos[i].nome.equalsIgnoreCase(nomeRemover)) {
                            // Move todos os alunos seguintes uma posição para trás
                            for (int j = i; j < tam - 1; j++) {
                                alunos[j] = alunos[j + 1];
                            }
                            alunos[tam - 1] = null;
                            tam--;
                            encontradoRemover = true;
                            System.out.println("Aluno removido com sucesso.");
                            break;
                        }
                    }

                    if (!encontradoRemover) {
                        System.out.println("Aluno não encontrado.");
                    }

                    break;

                case "3":
                    // Edição
                    System.out.print("Digite o nome do aluno que deseja alterar: ");
                    String nomeAlterar = sc.nextLine();
                    boolean encontradoAlterar = false;

                    for (int i = 0; i < tam; i++) {
                        if (alunos[i].nome.equalsIgnoreCase(nomeAlterar)) {
                            System.out.print("Novo nome: ");
                            String novoNome = sc.nextLine();
                            System.out.print("Novo ano de nascimento: ");
                            int novoAno = sc.nextInt();
                            sc.nextLine();

                            alunos[i].nome = novoNome;
                            alunos[i].anoDeNascimento = novoAno;
                            encontradoAlterar = true;
                            System.out.println("Aluno alterado com sucesso.");
                            break;
                        }
                    }

                    if (!encontradoAlterar) {
                        System.out.println("Aluno não encontrado.");
                    }

                    break;

                case "4":
                    for (int i = 0; i < tam; i++) {
                        Aluno a = alunos[i];

                        System.out.println(a.nome + " " + a.anoDeNascimento);
                    }
                    break;

                case "5":
                    // Sair
                    parar = true;
                    break;

                default:
                    System.out.println("\nDigite uma opção válida.\n");
                    break;
            }
        }
    }
}
