
# ZntCentral 

API que simula uma plataforma de fórum com posts e coméntarios, feita com Spring Boot, Spring Security, Spring Data JPA & PostgreSQL.

## Passo a passo para utilizar 

**1. Import Postman collection**

```bash
No ambiente Postman selecione Import e insira o link para importar: https://www.getpostman.com/collections/e6e19b9e27fcadc56da0
```

**2. Adicione o Environment**
```bash
Faça o download do arquivo Json do environment: shorturl.at/bikxZ 
Após isso importe o arquivo Json nos environments do Postman
```

## Explore a API

O Aplicativo tem os seguintes Endpoints

### Auth

| Método | Url | Decrição | 
| ------ | --- | ---------- |
| POST   | /oauth/token | Login | 

### Users

| Método | Url | Decrição |  Request Body Válido |
| ------ | --- | ----------- | ------------------------- |
| GET    | /users | Retorna o usuário logado ou todos os usuários caso seja admin | |
| GET    | /users/{id} | Retorna um usuário pelo seu Id(Caso seja admin)  | |
| POST   | /users | Adiciona um usuário (Apenas Admin) | [JSON](#usercreate) |
| PUT    | /users/{id} | Atualiza o usuário (Se o perfil pertencer ao usuário logado ou o usuário logado seja Admin) | [JSON](#userupdate) |
| DELETE | /users/{id} | Deleta um usuário (Apenas para Admin ou usuário logado) | |

### Posts

| Método | Url | Decrição | Request Body Válido |
| ------ | --- | ----------- | ------------------------- |
| GET    | /post | Retorna todos os posts do usuário logado | |
| GET    | /post/{id} | Retorna os posts por Id | |
| GET    | /post/{id}/replies | Retorna as respostas a um post de acordo com seu Id | |
| POST   | /post | Cria um novo post (Relacionado ao usuário logado) | [JSON](#postcreate) |
| PUT    | /post/{id} | Atualiza o post pelo Id (Se o post pertencer ao usuário logado ou usuário logado seja Admin) | [JSON](#postupdate) |
| DELETE | /post/{id} | Deleta um post (Se o post pertencer ao usuário logado ou usuário logado seja Admin) | |

### Replies

| Método | Url | Decrição | Request Body Válido |
| ------ | --- | ----------- | ------------------------- |
| POST   | /reply | Cria uma nova resposta a um post com Id = postId (Relacionado ao usuário logado) | [JSON](#commentcreate) |
| PUT    | /reply/{replyId} | Atualiza uma resposta a um post com Id = postId (Se a resposta pertencer ao usuário logado ou usuário logado seja Admin) | [JSON](#commentupdate) |


## JSON Request Bodys Válidos

##### <a id="usercreate">Criar novo Usuário -> /users</a>
```json
{
    "nickname": "Bruno Melado",
    "email": "brunomelado@gmail.com",
    "password": "123456",
    "roles": [
        {
            "id": 1
        },
        {
            "id": 2
        }
    ]

}
```

##### <a id="userupdate">Atualizar Usuário -> /users/{id}</a>
```json
{
    "nickname": "Bruno Melado",
    "email": "brunomelado@gmail.com",
    "password": "123456",
    "roles": [
        {
            "id": 1
        }
    ]

}
```

##### <a id="postcreate">Criar novo Post -> /post</a>
```json
{
    "text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse egestas lobortis tortor, in mollis enim. Aliquam erat volutpat. Aliquam erat volutpat.",
    "postDate": "2022-06-15T13:00:00Z",
    "userId": 1,
    "replies": [
        {
            "id": 1
        }
    ]
}
```

##### <a id="postupdate">Atualizar um Post -> /post/{postId}</a>
```json
{
    "text": "Let's go test this request",
    "postDate": "2022-06-15T13:00:00Z",
    "userId": 1,
    "replies": [
        {
            "id": 1
        }
    ]
}
```

##### <a id="commentcreate">Criar nova Resposta -> /reply</a>
```json
{
    "text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse egestas lobortis tortor, in mollis enim. Aliquam erat volutpat. Aliquam erat volutpat.",
    "postId": 1
}
```

##### <a id="commentupdate">Atualizar uma Resposta -> /reply/{replyId}</a>
```json
{
    "text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse egestas lobortis tortor, in mollis enim. Aliquam erat volutpat. Aliquam erat volutpat.",
    "postId": 2
}
```
