# tcd-amazon
Trabalho de conclusão de disciplina
* Pós-graduação Engenharia de Software (FIAP)

# Caso Amazon
Suponho que você seja contratado para desenvolver algunas funcionalidades do e-commerce da
Amazon, alguns desejos dos usuários são descritos abaixo e você deve desenhar e implementar uma
solução baseada em Microserviços.

* Possibilidade de visualizar os produtos de um determinado gênero;
* Possibilidade de visualizar os detalhes de cada produto;
* Possibilidade de adicionar itens na sua lista de desejo;
* Possibilidade de buscar um produto por palavra-chave;
* Possibilidade de exibir os produtos mais vistos por categorias;
* Possibilidade de abrir um chamado técnico de algum problema que está acontecendo;
* Possibilidade de acompanhar os dados do seu pedido;
* Possibilidade de calcular o frete de uma compra;

# Tools
* MySQLServer
* Docker
* MAVEN
* JAVA 8 ou superior
* Eclipse ou IDE de sua preferência
* Postman

# Crie os databases no MysqlServer
* db_customer
* db_help
* db_orderstatus
* db_product

# Rode imagem RabbitMQ
* docker run -d -p 5672:5672 -p 15672:15672 --name=rabbitmq rabbitmq:3.8.3-management

# Inicie os serviços e visualize
* eurekaserver  -- http://localhost:8761/
* products      -- http://localhost:8081/swagger-ui.html#/
* customers     -- http://localhost:8082/swagger-ui.html#/
* orderstatus   -- http://localhost:8083/swagger-ui.html#/
* help          -- http://localhost:8084/swagger-ui.html#/
* help-consumer -- http://localhost:8085/

# Importe a collection no Postman 

tcd-amazon.postman_collection.json

# Execute os endpoints e valide a solução

![Alt text](https://github.com/JeffMSantos/tcd-amazon/blob/master/image/collection.PNG)
