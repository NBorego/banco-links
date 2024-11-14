# banco-links

# Interfaces

A interface `IBancoLink.java` possui 4 métodos:

- `adicionarLink`: para adicionar links passando o assunto e a url;
- `listarLinks`: para listar os links;
- `editarLink`: para editar um link passando o id, assunto e a url;
- `deletarLink`: para remover links passando o id.

# `links.txt`

O arquivo links.txt contém os links cadastrados no sistema, onde cada linha é separada por um | e armazena o ID, o assunto e a URL.

# `BancoLink`

O arquivo `BancoLink` contém as operações de CRUD (Criar, Ler, Atualizar e Deletar) do sistema, além de um método chamado `obterUltimoId`. Esse método é responsável por gerar o próximo ID de link com base no último ID utilizado, garantindo que a sequência de IDs seja mantida mesmo após o fechamento e reinício do programa.

# `TesteBancoLink`

Este arquivo contém o menu do sistema, onde ocorre a interação com o usuário. Nele, são apresentadas as seguintes opções para o usuário escolher:

- Adicionar link
- Listar links
- Editar link
- Deletar link
- Sair