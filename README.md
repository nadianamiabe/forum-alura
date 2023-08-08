### Como rodar local 
 1 - Buildar a imagem do docker com o seguinte comando:

 docker build -t alura-forum
 
 2 - Rodar o conteiner:

 docker run -p 3080:8080 alura-forum

A url da aplicação será http://localhost:3080