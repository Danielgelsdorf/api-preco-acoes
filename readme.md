# api de ações 
essa api retorna o preço atual da ação, o maior preço e o menor preço do dia.
ela também retorna a tacha Selic.
##Como usar
primeiro clone o projeto em sua máquina usando:
`git clone https://github.com/Danielgelsdorf/api-preco-acoes.git`
Abra um CMD na pasta clonada
com o JRE ou JDK instalado só executar o comando 
`java -jar target/api-acoes-1.0.jar`
pronto, vai subir um terminal e a api ja vai ta no ar.
# uso
para usar pode bater pelo google mesmo, ou por um cliente que faça request. Exemplo a extenção do VS code: Thunder Client .
# Rotas
##ação:
`http://localhost:80/acao?cod=Codigo-da-acao`
##selic:
`http://localhost:80/selic`
## Docker
Pode subir api pelo Docker também
Só abrir um terminal dentro da pasta que clonou o projeto.
Para construir a imagem, use:
`Docker build . -t api`
Para rodar a imagem construída, use:
` docker run --name apir -d --rm -p 80:80 api `
Para parar a imagem e apagar a imagem use os dois comandos abaixo:
` docker kill apir`
` docker rmi api `