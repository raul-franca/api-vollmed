
# Comandos mais usados no Heroku

O deploy da aplicação foi feito no Heroku. Os comandos abaixo foram os mais utilizados para realizar o deploy e configurar o ambiente.

## Instalar o Heroku e realizar login
```bash
brew tap heroku/brew && brew install heroku   # Instala o Heroku CLI via Homebrew
heroku login                                  # Realiza o login na sua conta Heroku
```

## Criar um aplicativo no Heroku
```bash
heroku create                                 # Cria um novo app no Heroku
heroku git:remote -a nome_do_app              # Configura um remote para o Git vinculado ao app
git remote -v                                 # Mostra os remotes do Git configurados
heroku info                                   # Exibe informações sobre o aplicativo no Heroku
heroku apps:destroy nome_do_app --confirm nome_do_app  # Deleta o app no Heroku
```

## Deploy da aplicação no Heroku
```bash
git push heroku main                          # Realiza o deploy da branch 'main' no Heroku
heroku open                                   # Abre o aplicativo no navegador
heroku restart                                # Reinicia a aplicação no Heroku
```

## Visualizar logs da aplicação
```bash
heroku logs --tail                            # Exibe os logs da aplicação em tempo real
heroku logs --tail | grep ERROR               # Filtra e exibe apenas os logs de erro
```

## Configurar variáveis de ambiente no Heroku
```bash
heroku config:set DATABASE_URL=your_database_url        # Configura a URL do banco de dados
heroku config:set DATABASE_PASSWORD=your_password       # Define a senha do banco de dados
heroku config:set DATABASE_USER=your_user               # Define o usuário do banco de dados
heroku config:set DATABASE_NAME=your_database_name      # Define o nome do banco de dados
heroku config:set DATABASE_HOST=your_database_host      # Define o host do banco de dados
heroku config:set DATABASE_PORT=your_database_port      # Define a porta do banco de dados
heroku config:set DATABASE_SSLMODE=REQUIRED             # Configura SSL para conexão segura
```

---""


# Tabela com os comandos mais usados no Heroku

| Comando                     | Descrição                                                                 |
|-----------------------------|---------------------------------------------------------------------------|
| `heroku login`              | Efetua login na sua conta Heroku.                                         |
| `heroku create`             | Cria uma nova aplicação no Heroku.                                        |
| `git push heroku main`      | Faz o deploy do código da branch `main` para o Heroku.                    |
| `heroku ps:scale web=1`     | Escala o número de dynos web para 1.                                      |
| `heroku open`               | Abre a aplicação no navegador padrão.                                     |
| `heroku logs --tail`        | Exibe os logs em tempo real da aplicação.                                 |
| `heroku config:set VAR=val` | Define uma variável de ambiente `VAR` com o valor `val`.                  |
| `heroku config`             | Lista todas as variáveis de ambiente da aplicação.                        |
| `heroku addons:create`      | Adiciona um add-on à aplicação.                                           |
| `heroku run COMMAND`        | Executa o comando especificado no ambiente da aplicação no Heroku.        |