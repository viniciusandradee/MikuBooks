# MikuBooks
Software de gerenciamento de livros.

## Requisitos

- [ ] CRUD Usuário
- [ ] CRUD Livro


## Endpoints

### Usuario

GET /usuario

Lista todos os usuarios cadastradas no sistema.

*Códigos de status*

200 sucesso

---

GET /usuario/{id}

Retorna os detalhes de um usuario com o `id` informado.

*Códigos de status*

200 Sucesso

404 Id não encontrado

---

POST /usuario

Cadastrar um novo usuario.

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|----------
| username | String | ✅ | Username para logar e exibição no site |
| email | String | ✅ | Email para logar no site |
| password | String | ✅ | Senha para logar no site |
| telefone | String | ❌ | Número de telefone do usuário |
| dataNascimento | LocalDate | ✅ | Data de aniversário do usuário |

*Códigos de status*

201 Criado com sucesso

400 Validação falhou

---

DELETE /usuario/{id}

Apaga o usuario com o `id` informado, recebendo como situação "Desativado".

*Códigos de status*

204 Apagado com sucesso

404 id não encontrado

---

PUT /usuario/{id}

Altera o usuario com o id informado.

| campo | tipo | Alterável | descrição 
|-------|------|:-------------:|----------
| username | String | ✅ | Username para logar e exibição no site |
| email | String | ✅ | Email para logar no site |
| password | String | ✅ | Senha para logar no site |
| dataNascimento | LocalDate | ✅ | Data de aniversário do usuário |
| situacao | ENUM | ✅ | Situação do usuário, Ativo ou Desativado |
| livros | List | ❌ | Livros que o usuário salvou na conta |
| id | Long | ❌ | Número | Id do usuário para identificação |

*Códigos de status*

200 Sucesso

404 id não encontrado

400 Validação falhou

---

*Schema* 
```
{
  "id": 1,
  "username": "Vinicius_S15",
  "email":"vinicius@gmail.com",
  "password": "Senha123#",
  "dataNascimento": "2004-11-29",
  "situação": "ATIVO",
  "telefone": "11997831738"
}
```
---

### Livro

GET /livro

Lista todos os livros cadastradas no sistema.

*Códigos de status*

200 sucesso

---

GET /livro/{id}

Retorna os detalhes de um livro com o `id` informado.

*Códigos de status*

200 Sucesso

404 Id não encontrado

---

POST /livro

Cadastrar um novo livro.

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|----------
| avaliação | float | ✅ | Nota média que o livro possui |
| review | String | ❌ | Opinião que o usuário desejar exibir sobre o livro |
| situação | String | ✅ | Mostra se o livro ja foi lido, está sendo lido ou ainda irá ler |
| favorito | Boolean | ❌ | Adiciona o livro aos favoritos caso seja selecionado (valor inicial: false) |


*Códigos de status*

201 Criado com sucesso

400 Validação falhou

---

DELETE /livro/{id}

Apaga o livro com o `id` informado.

*Códigos de status*

204 Apagado com sucesso

404 id não encontrado

---

PUT /livro/{id}

Altera o livro com o id informado.

| campo | tipo | Alterável | descrição 
|-------|------|:-------------:|----------
| titulo | String | ❌ | Título do livro para busca |
| idLivro | String | ❌ | Título do livro para busca |
| categoria | String | ❌ | Categoria em que o livro se encaixa |
| paginas | Long | ❌ | Quantidade de páginas no livro |
| avaliação | float | ✅ | Nota média que o livro possui |
| autor | String | ❌ | Autor do livro |
| situação | String | ✅ | Mostra se o livro ja foi lido, está sendo lido ou ainda irá ler |
| favorito | Boolean | ✅ | Adiciona o livro aos favoritos caso seja selecionado (valor inicial: false) |

*Códigos de status*

200 Sucesso

404 id não encontrado

400 Validação falhou

---

*Schema* 
```
{
  "id": 1,
  "titulo": "The Disappearance of Hatsune Miku",
  "categoria":"Ficção juvenil, Literatura fantástica",
  "paginas": "248#",
  "avaliacao": 4.5,
  "autor": "Muya Agami",
  "situacao": "Lido",
  "favorito": false
}
```
---