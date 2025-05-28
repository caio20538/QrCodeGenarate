## 📦 Gerador de QR Code com Java, AWS S3 e Docker

Projeto Backend desenvolvido do zero com Java 21. A aplicação permite gerar QR Codes e armazená-los automaticamente em um bucket S3 da AWS. O projeto está containerizado com Docker para facilitar testes e deploys locais.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- AWS S3
- Docker
- REST API

## ⚙️ Pré-requisitos

- Java 21
- Docker instalado e funcionando
- Conta na AWS com permissões para criar buckets e gerar chaves de acesso

---

## 🔐 Configuração de Variáveis de Ambiente

Crie um arquivo `.env` na raiz do projeto com as seguintes variáveis:

```env
AWS_ACCESS_KEY_ID=SEU_ACCESS_KEY
AWS_SECRET_ACCESS_KEY=SUA_SECRET_KEY
````

### Como obter essas credenciais:

1. Acesse o [IAM da AWS](https://console.aws.amazon.com/iam)
2. Vá em **Users** e selecione seu usuário.
3. Aba **Security credentials** → clique em **Create access key**
4. Escolha **Use cases**: *Command Line Interface (CLI)* e confirme.
5. Baixe o CSV e **não perca esse arquivo**, a *Secret* só aparece uma vez.
6. Garanta que o usuário tenha a política `AmazonS3FullAccess`.

---

## ☁️ Configuração do Bucket S3

### 1. Crie um bucket na AWS S3 com nome disponível (ex: `qrcode-generatorz-storage`) na região desejada (ex: `us-east-1`).

### 2. Adicione a seguinte política ao bucket (ajuste o nome do bucket em `Resource`):

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "PublicRead",
      "Effect": "Allow",
      "Principal": "*",
      "Action": "s3:GetObject",
      "Resource": "arn:aws:s3:::qrcode-generatorz-storage/*"
    }
  ]
}
```

---

## 🐳 Docker

### 1. Ajuste o Dockerfile (em `./docker/Dockerfile`) com as seguintes variáveis:

```dockerfile
ENV AWS_REGION=us-east-1
ENV AWS_S3_BUCKET_NAME=qrcode-generatorz-storage
```

### 2. Build da imagem Docker:

```bash
docker build -t qrcode-generator:1.0 ./docker
```

### 3. Executar a imagem:

```bash
docker run --env-file .env -p 8080:8080 qrcode-generator:1.0
```

---

## 📬 API Endpoint (Exemplo)

**Gerar QR Code:**

```http
POST http://localhost:8080/qrcode
Content-Type: application/json

{
  "text": "https://meusite.com"
}
```


---

## 📝 Licença

Este projeto está sob a licença MIT. Sinta-se livre para usar e contribuir!

---

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se livre para abrir issues ou enviar PRs.

```
```
