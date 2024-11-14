package interfaces;

import java.util.List;

public interface IBancoLink {
    // Método para adicionar links
    public void adicionarLink(String assunto, String url);

    // Método para listar os links
    public List<String> listarLinks();

    // Método para editar links
    public void editarLink(int id, String novoAssunto, String novaUrl);

    // Método para remover links
    public void deletarLink(int id);
}
