# 🐳 Curso de Docker – Guia Rápido

Este repositório contém um resumo dos comandos e práticas mais utilizados durante o curso de Docker, incluindo containers de PostgreSQL, pgAdmin, rede Docker, e deploy de aplicações Java (Spring Boot) com Docker.

---

## ✅ Iniciando com Docker Desktop no Windows

- É **obrigatório iniciar o Docker Desktop** para que os comandos funcionem no terminal.
- Se o Docker não estiver aberto, comandos como `docker ps` ou `docker restart` retornarão erro de conexão.

> 💡 **Dica:**  
> Se você usa Docker com frequência, ative a opção  
> **"Start Docker Desktop when you log in"** em:  
> `Docker Desktop → Settings → General`.

---

## 🔧 Comandos Essenciais

### 🔍 Verificar containers

```bash
docker ps            # Lista containers em execução
docker ps -a         # Lista todos os containers (inclusive os parados)
```

### ⏹️ Parar, iniciar e reiniciar containers

```bash
docker stop nome_container        # Para o container
docker start nome_container       # Inicia um container parado
docker restart nome_container     # Reinicia o container
```

### 🗑️ Remover container

```bash
docker container rm nome_container
```

### 📦 Verificar imagens disponíveis

```bash
docker images
```

---

## 🌐 Trabalhando com Redes Docker

### 🔗 Criar uma rede personalizada

```bash
docker network create nome_da_network
```

- Redes personalizadas permitem que múltiplos containers se comuniquem entre si usando seus nomes.

---

## 🐘 Containers: PostgreSQL + pgAdmin4

### 1️⃣ Criar uma rede compartilhada

```bash
docker network create library-network
```

### 2️⃣ Container PostgreSQL

```bash
docker run --name librarydb \
  -p 5432:5432 \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_DB=library \
  -d \
  --network library-network \
  postgres:17.5
```

### 3️⃣ Container pgAdmin4

```bash
docker run --name pgadmin4 \
  -p 15432:80 \
  -e PGADMIN_DEFAULT_EMAIL=saintlouisashlhey998@gmail.com \
  -e PGADMIN_DEFAULT_PASSWORD=admin \
  -d \
  --network library-network \
  dpage/pgadmin4
```

---

## 📶 Verificar portas em uso (Windows)

```cmd
netstat -aon | findstr :PORTA
```

Use para descobrir se uma porta está ocupada por outro processo.

---

## ☕ Deploy de Aplicações Java (Spring Boot)

### 🧪 Gerar `.jar` com Maven (sem testes)

```bash
./mvnw clean package -DskipTests
```

- O arquivo `.jar` será salvo na pasta `./target`.

### ▶️ Rodar localmente o `.jar`

```bash
java -jar ./target/convidados-0.0.1-SNAPSHOT.jar
```

---

## 📄 Criando Dockerfile

Crie um arquivo `Dockerfile` na raiz do projeto:

```Dockerfile
FROM openjdk:17
WORKDIR /app
COPY ./target/convidados-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## 🔨 Build da Imagem Docker

```bash
docker build --tag cursodocker/springapp .
```

- `--tag` ou `-t`: define o nome da imagem.
- `.`: indica que o `Dockerfile` está no diretório atual.

---

## 🚀 Executar container da imagem criada

```bash
docker run --name springapp1 -p 8080:8080 cursodocker/springapp
```

---

## 📚 Resumo Rápido

| Comando | Descrição |
|--------|-----------|
| `docker ps` | Lista containers ativos |
| `docker ps -a` | Lista todos os containers |
| `docker images` | Lista imagens disponíveis |
| `docker stop/start/restart` | Gerenciar containers |
| `docker container rm` | Remover container |
| `docker network create` | Criar rede personalizada |
| `docker build` | Construir imagem a partir de `Dockerfile` |
| `docker run` | Rodar container baseado em imagem |

---

## 📌 Autor

> Documentação criada por Ashley ✨  
> Atualizado e revisado com ❤️ usando ChatGPT
