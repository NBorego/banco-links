import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import interfaces.IBancoLink;

public class BancoLink implements IBancoLink {
    // Esse é o arquivo onde vai ficar os links, o final faz com que o valor dele
    // nunca mude
    private static final String NOME_ARQUIVO = "links.txt";
    private int ultimoId = 0;

    // Executa o método obterUltimoId ao iniciar
    public BancoLink() {
        this.ultimoId = obterUltimoId();
    }

    // Metodo feito para obter o ultimo id do arquivo 'links.txt' para evitar contar
    // os ids denovo
    private int obterUltimoId() {
        int id = 0;
        try {
            // Pega as linhas presentes no arquivo 'links.txt'
            List<String> linhas = Files.readAllLines(Paths.get(NOME_ARQUIVO));

            // Se não estiver vazia faz essa condição
            if (!linhas.isEmpty()) {
                // Pega a ultima linha
                String ultimaLinha = linhas.get(linhas.size() - 1);
                int espacoIndex = ultimaLinha.indexOf(' ');

                if (espacoIndex != -1) {
                    id = Integer.parseInt(ultimaLinha.substring(0, espacoIndex));
                }
            }
        } catch (IOException | NumberFormatException e) {
            // Mostra isso caso ocorra algum erro ao encontrar o id
            System.out.println("Erro ao obter último ID: " + e.getMessage());
        }

        return id;
    }

    @Override
    public void adicionarLink(String assunto, String url) {
        // Cria o id para esse link
        int id = ++this.ultimoId;

        // Criando uma exception caso ocorra algum erro ao criar o encritor de arquivos
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
            // Escreve no links.txt o assunto + a url passada por parâmetro
            writer.write(id + " | " + assunto + " | " + url);
            writer.newLine();
        } catch (IOException e) {
            // Caso ocorra qualquer erro ele mostra essa mensagem
            System.out.println("Erro ao adicionar link: " + e.getMessage());
        }
    }

    @Override
    public List<String> listarLinks() {
        // Criando uma lista de links
        List<String> links = new ArrayList<>();

        // Criando uma exception caso ocorra algum erro ao criar o encritor de arquivos
        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;

            // Adiciona linha a variável 'links' até que reader.readLine() seja diferente de
            // nulo
            while ((linha = reader.readLine()) != null) {
                links.add(linha);
            }
        } catch (IOException e) {
            // Retorna isso caso dê erro
            System.out.println("Erro ao listar links: " + e.getMessage());
        }
        return links;
    }

    @Override
    public void editarLink(int id, String novoAssunto, String novaUrl) {
        // Criando uma lista de links usando o metodo listarLinks
        List<String> links = listarLinks();

        // Criando uma exception caso ocorra algum erro ao criar o encritor de arquivos
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            // Faz um for percorrendo todas as linhas
            for (String link : links) {
                // Caso encontre um link com o id digitado vai escrever uma fazer a edição
                if (link.contains(Integer.toString(id))) {
                    writer.write(id + " | " + novoAssunto + " | " + novaUrl);
                } else {
                    writer.write(link);
                }

                writer.newLine();
            }
        } catch (IOException e) {
            // Retorna isso caso ocorra um erro
            System.out.println("Erro ao editar link: " + e.getMessage());
        }
    }

    @Override
    public void deletarLink(int id) {
        // Criando uma lista de links usando o metodo listarLinks
        List<String> links = listarLinks();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            // Faz um for percorrendo todas as linhas
            for (String link : links) {
                // Caso encontre um link com o id digitado vai remover a linha
                if (!link.contains(Integer.toString(id))) {
                    writer.write(link);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            // Retorna isso caso ocorra um erro
            System.out.println("Erro ao deletar link: " + e.getMessage());
        }
    }
}
