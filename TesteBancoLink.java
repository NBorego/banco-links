import java.util.List;
import java.util.Scanner;

public class TesteBancoLink {
    public static void main(String[] args) {
        BancoLink banco = new BancoLink();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar link");
            System.out.println("2. Listar links");
            System.out.println("3. Editar link");
            System.out.println("4. Deletar link");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite o assunto: ");
                    String assunto = scanner.nextLine();

                    System.out.print("Digite o URL: ");
                    String url = scanner.nextLine();

                    banco.adicionarLink(assunto, url);
                    System.out.println("Link adicionado com sucesso!");
                    break;

                case 2:
                    List<String> links = banco.listarLinks();

                    System.out.println("====================================================================");

                    for (String link : links) {
                        System.out.println(link);
                    }

                    System.out.println("====================================================================");

                    break;

                case 3:
                    System.out.print("Digite o ID: ");
                    int idEditar = Integer.parseInt(scanner.nextLine());

                    System.out.print("Digite o novo assunto: ");
                    String novoAssunto = scanner.nextLine();

                    System.out.print("Digite o novo URL: ");
                    String novaUrl = scanner.nextLine();

                    banco.editarLink(idEditar, novoAssunto, novaUrl);
                    System.out.println("Link editado com sucesso!");

                    break;

                case 4:
                    System.out.print("Digite o ID para deletar: ");
                    int idDeletar = Integer.parseInt(scanner.nextLine());

                    banco.deletarLink(idDeletar);
                    System.out.println("Link deletado com sucesso!");
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
