# Comandos que eu mais usei no Heroku

O deploy da aplicação foi feito no Heroku. 
Os comandos abaixo são os que eu mais usei para fazer o deploy e configurar o ambiente.

## Instalar o heroku e logar
brew tap heroku/brew && brew install heroku
heroku login

## Criar um app no heroku
heroku create // cria um app no heroku
heroku git:remote -a nome_do_app
git remote -v // mostra os remotes

## Deploy no heroku
git push heroku main
heroku open

## Visualizar logs
heroku logs --tail

## Configurar variáveis de ambiente no heroku
heroku config:set DATABASE_URL=your_database_url
heroku config:set DATABASE_PASSWORD=your_password
heroku config:set DATABASE_USER=your_user
heroku config:set DATABASE_NAME=your_database_name
heroku config:set DATABASE_HOST=your_database_host
heroku config:set DATABASE_PORT=your_database_port
heroku config:set DATABASE_SSLMODE=REQUIRED

