# Comandos que eu mais usei no Heroku

O deploy da aplicação foi feito no Heroku. 
Os comandos abaixo são os que eu mais usei para fazer o deploy e configurar o ambiente.

## Instalar o heroku e logar
brew tap heroku/brew && brew install heroku
heroku login

## Criar um app no heroku
heroku create // cria um app no heroku
heroku git:remote -a nome_do_app // cria um remote no git
git remote -v // mostra os remotes
heroku info // mostra informações do app
heroku apps:destroy nome-do-seu-app --confirm nome-do-seu-app // deleta o app

## Deploy no heroku
git push heroku main // faz o deploy no heroku    
heroku open // abre o app no navegador
heroku restart // reinicia a aplicação

## Visualizar logs
heroku logs --tail // visualiza os logs
heroku logs --tail | grep ERROR // visualiza os logs de erro



## Configurar variáveis de ambiente no heroku
heroku config:set DATABASE_URL=your_database_url
heroku config:set DATABASE_PASSWORD=your_password
heroku config:set DATABASE_USER=your_user
heroku config:set DATABASE_NAME=your_database_name
heroku config:set DATABASE_HOST=your_database_host
heroku config:set DATABASE_PORT=your_database_port
heroku config:set DATABASE_SSLMODE=REQUIRED

