### Como rodar local 
 1 - Clonar esse repositório
 
 2 - Buildar a imagem do docker com o seguinte comando na raiz do projeto:

 docker build -t alura-forum -f Dockerfile.local .
 
 3 - Rodar o conteiner:

 docker run -p 3080:8080 alura-forum

A url da aplicação será http://localhost:3080
