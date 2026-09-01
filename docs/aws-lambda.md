# AWS Lambda

Projeto Java simples para executar uma AWS Lambda localmente utilizando Maven, AWS CLI e LocalStack.

## Criar Projeto

O projeto foi criado utilizando o padrão Maven.

AWS Lambda não precisa de uma classe Main neste modelo. O ponto de entrada da aplicação será o método handleRequest da classe configurada como Handler.

A classe App criada pelo Maven pode ser removida.

## Criar Método

Criar a classe HomeLambda:

	package com.pro.aws.lambda;
	import java.util.Map;
	import com.amazonaws.services.lambda.runtime.Context;
	import com.amazonaws.services.lambda.runtime.RequestHandler;
	
	public class HomeLambda implements RequestHandler<Map<String, Object>, String> {
	    @Override
	    public String handleRequest(Map<String, Object> input, Context context) {
	        return "----- Java AWS Lambda | Home | handleRequest -----";
	    }
	}

O Handler da Lambda será:

	com.pro.aws.lambda.HomeLambda::handleRequest

## POM

Adicionar a dependência aws-lambda-java-core e o Maven Shade Plugin.

	<dependency>
	    <groupId>com.amazonaws</groupId>
	    <artifactId>aws-lambda-java-core</artifactId>
	    <version>1.2.3</version>
	</dependency>

	<plugin>
	    <groupId>org.apache.maven.plugins</groupId>
	    <artifactId>maven-shade-plugin</artifactId>
	    <version>3.6.0</version>
	    <executions>
	        <execution>
	            <phase>package</phase>
	            <goals>
	                <goal>shade</goal>
	            </goals>
	        </execution>
	    </executions>
	</plugin>

Compilar

	mvn clean package

O Maven irá gerar:

	target/java-lambda.jar

O Shade Plugin coloca no JAR tanto a aplicação quanto suas dependências.

## Empacotar Lambda

A Lambda precisa receber um ZIP com as classes e dependências disponíveis na raiz do pacote.

Criar o diretório:

	mkdir lambda-package

Extrair o JAR:

	jar xf target/java-lambda.jar -C lambda-package

Criar o ZIP:

	cd lambda-package && zip -r ../lambda.zip . && cd ..

O resultado será:

	lambda.zip
	├── com/
	│   └── pro/
	│       └── aws/
	│           └── lambda/
	│               └── HomeLambda.class
	└── com/
	    └── amazonaws/
	        └── services/
	            └── lambda/
	                └── runtime/

## LocalStack

Iniciar:

	lstk start

Verificar:

	lstk status

Para parar:

	lstk stop

## Criar AWS Lambda

Para criar a Lambda pela primeira vez:

	aws --endpoint-url=http://localhost.localstack.cloud:4566 lambda create-function \
	    --function-name java-lambda-home \
	    --runtime java21 \
	    --role arn:aws:iam::000000000000:role/lambda-role \
	    --handler com.pro.aws.lambda.HomeLambda::handleRequest \
	    --zip-file fileb://lambda.zip

O role acima é um ARN utilizado pelo ambiente LocalStack.

## Atualizar AWS Lambda

Depois de alterar o código e gerar um novo lambda.zip:

	aws --endpoint-url=http://localhost.localstack.cloud:4566 lambda update-function-code \
	    --function-name java-lambda-home \
	    --zip-file fileb://lambda.zip

Invocar AWS Lambda

	aws --endpoint-url=http://localhost.localstack.cloud:4566 lambda invoke \
	    --function-name java-lambda-home \
	    --payload '{}' \
	    response.json

Resultado:

{
    "StatusCode": 200,
    "ExecutedVersion": "$LATEST"
}

Ler Resposta

	cat response.json

Resultado:

	"----- Java AWS Lambda | Home | handleRequest -----"

Fluxo

	Java
	  ↓
	Maven
	  ↓
	JAR com dependências
	  ↓
	ZIP
	  ↓
	LocalStack
	  ↓
	AWS Lambda
	  ↓
	HomeLambda.handleRequest()
	  ↓
	Resposta