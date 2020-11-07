# SoMeSPC - A powerful tool for measurement

<img src="https://github.com/nemo-ufes/MedCEP/blob/master/SoMeSPC/web/naviox/images/logo.png" alt="Logo SoMeSPC" width="140px" height="120px"/> 
<img align="right" src="https://github.com/nemo-ufes/MedCEP/blob/master/SoMeSPC/web/naviox/images/nemo.jpg" alt="Logo NEMO" width="140px" height="120px"/> <img align="right" src="https://github.com/nemo-ufes/MedCEP/blob/master/SoMeSPC/web/naviox/images/ufes.png" alt="Logo UFES" width="140px" height="120px"/>

**Copyright &copy; 2013 Ciro Xavier Maretto** <br/>
**Copyright &copy; 2015 Henrique Néspoli Castro, Vinícius Soares Fonseca** 

Ferramenta para Medição de Software e Controle Estatístico de Processos. 
<br/>Baseada na arquitetura de referência de medição de software de MARETTO (2014).

## Configuração da SoMeSPC
### Requisitos
- Microsoft Windows 7 SP1 64 bits (ou outro sistema operacional com suporte à plataforma Java)
- Java 7 JDK (x64) - [Download] (http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk7-downloads-1880260.html)
- IDE Eclipse Luna for EE Developers (x64) SR2 - [Download] (https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/luna/SR2/eclipse-jee-luna-SR2-win32-x86_64.zip)
- MySQL 5.6.24 - [Download] (https://dev.mysql.com/get/Downloads/MySQLInstaller/mysql-installer-community-5.6.24.0.msi)
- Apache Tomcat 7.0.59 (x64) - [Download] (http://archive.apache.org/dist/tomcat/tomcat-7/v7.0.59/bin/apache-tomcat-7.0.59-windows-x64.zip)

### Instruções para configuração da SoMeSPC
1. Instalar o Java 7 JDK.
2. Instalar o MySQL.
3. Criar um esquema de banco de dados chamado **"somespc"**.
4. Criar um usuário e senha **"somespc"** com permissão total no esquema criado. 
5. Na utilização de outro usuário/senha, atualizar os arquivos abaixo após clonar o repositório do Github:
 1. SoMeSPC/Persistence/META-INF/persistence.xml
 2. SoMeSPC/Properties/quartz.properties
6. Executar o script SQL [tables_mysql.sql](https://github.com/nemo-ufes/MedCEP/blob/master/SoMeSPC/properties/quartz_tables_scripts/tables_mysql.sql)
7. Descompactar o Apache Tomcat em C:\apache-tomcat-7.0.59 (caminho padrão). Caso queira instalar o Apache Tomcat em outro diretório, atualizar a variável <b>tomcat.dir</b> do arquivo <b>SoMeSPCm/properties/openxava.properties</b> após clonar o repositório do Github. O arquivo apache-tomcat-7.0.59.zip se encontra no [Link](http://archive.apache.org/dist/tomcat/tomcat-7/v7.0.59/bin/).
8. Descompactar o IDE Eclipse Luna.
9. Executar o Eclipse.
10. Clonar o repositório SoMeSPC do GitHub.
11. Configurar o Apache Tomcat como servidor web no Eclipse (<b>Window -> Preferences -> Server -> Runtime Environments -> Add...</b>). Clicar no botao <b>Add</b>, escolher a opção <b>Apache Tomcat v7.0</b>, em seguida escolher o caminho, onde o Apache Tomcat foi descompactado anteriormente, clicando em <b>Browse</b> e por fim selecionar <b>jr7</b>.
12. Na aba Server (parte inferior do Eclipse), dar duplo clique em <b>Tomcat v7 Server</b>. No arquivo que abrir, selecionar a opção <b>"Use Tomcat Installation (takes control of Tomcat installation)"</b> na área Server Locations.
13. Iniciar o Apache Tomcat.
14. Clicar com o botão direito em Tomcat v7.0 Server e selecionar <b>Add and Remove</b>, escolher a ferramenta SoMeSPC e clicar em <b>Add</b>.
15. Abrir a pasta do projeto SoMeSPC no IDE Eclipse.
16. Procurar pelo arquivo <b>build.xml</b>.
17. Clicar com o botão direito do mouse, selecionar <b>"Run as"</b> e escolher a 3º opção <b>"Ant Build..."</b>.
18. Defina um nome, por exemplo <b>"SoMeSPC.Implantar"</b>, depois clique em <b>Apply</b>.
19. Clique em <b>Run</b>.
20. Executar a Ant Build <b>SoMeSPC.Implantar</b>.
21. Abrir a aplicação no browser pela URL: [http://localhost:8080/SoMeSPC](http://localhost:8080/SoMeSPC). Caso não tenha sido possível abrir a aplicação através da URL via browser, faça:
 1. Pare o Apache Tomcat.
 2. Inicie novamente o Apache Tomcat.
 3. Execute a Ant Build <b>SoMeSPC.Implantar</b>.
 4. Abra a aplicação no browser pela URL: [http://localhost:8080/SoMeSPC](http://localhost:8080/SoMeSPC).

<!---
## Configuração do Sonar
### Requisitos

- PostgreSQL 9.4.1 (x64) - [Download] (http://www.enterprisedb.com/products-services-training/pgdownload)
- SonarQube 4.5.1 - [Download](http://dist.sonar.codehaus.org/sonarqube-4.5.1.zip)

## Instruções para configuração do SonarQube

1. Descompactar o SonarQube em C:\sonarqube-4.5.1 (caminho padrão).
2. Criar um banco de dados no PostgreSQL chamado <b>"sonar"</b> e informar como dono o usuário <b>"postgres"</b>.
3. Abrir o arquivo **C:\sonarqube-4.5.1\conf\sonar.properties** e informar os parâmetros de conexão com o banco de dados conforme abaixo:

 ```
  sonar.jdbc.username=postgres
  sonar.jdbc.password=postgres
  sonar.jdbc.url=jdbc:postgresql://localhost/sonar
 ```
4. Abrir o diretório **bin/windows-x86-64** e executar o script **StartSonar.bat**.
5. Aguardar a inicialização do SonarQube (aparecerá no console a mensagem **"Process[web] is up"**).
5. Abrir o SonarQube no browser pela URL: [http://localhost:9000/](http://localhost:9000/)
6. Fazer login no SonarQube com usuário e senha **"admin"**.
7. Acessar o menu **"Settings -> Update Center"**.
8. Selecionar a aba **"Available Plugins"**, procurar e instalar o **"Portuguese Pack"**.
9. Reiniciar o SonarQube (fechar o console aberto e iniciar novamente o script **StartSonar.bat**).

## Configuração do Jenkins
### Requisitos

- Apache Tomcat 7.0.59 (x64) - [Download] (http://mirrors.koehn.com/apache/tomcat/tomcat-7/v7.0.59/bin/apache-tomcat-7.0.59-windows-x64.zip)
- Cliente Git 1.9.5 (Windows) - [Download](https://github.com/msysgit/msysgit/releases/download/Git-1.9.5-preview20150319/Git-1.9.5-preview20150319.exe)
- Jenkins CI 1.593 - [Download](http://mirrors.jenkins-ci.org/war/1.593/jenkins.war)

## Instruções para configuração do Jenkins

1. Baixar e instalar o cliente **Git** conforme a URL de download acima.
1. Baixar o <b>Jenkins</b> conforme a URL de download acima.
2. Colocar o arquivo <b>"jenkins.war"</b> no diretório <b>webapps</b> do Apache Tomcat (ex: C:\apache-tomcat-7.0.59\webapps).
3. Abrir o Jenkins no browser pela URL: [http://localhost:8080/jenkins/](http://localhost:8080/jenkins/). Pode demorar vários minutos no primeiro carregamento.
4. Acessar **Gerenciar Jenkins -> Gerenciar Plugins**.
5. Abrir a aba **Disponíveis**.
6. Filtrar por **"Github"**, selecionar **GitHub plugin** e clicar em **Instalar sem reiniciar**.
7. Filtrar por **"SonarQube"**, selecionar **SonarQube plugin** e clicar em **Instalar sem reiniciar**.
7. Voltar para o menu principal do **Jenkins**, acessar **Gerenciar Jenkins -> Configurar o sistema**.
8. Na seção **Git**, informar no campo 	***Path to Git executable*** o caminho de instalação do **cliente Git** (caminho padrão C:\Program Files (x86)\Git\bin\git.exe).
9. Na seção **SonarQube** (atenção: não é a mesma que a seção **SonarQube Runner**), clicar em **Avançado** e informar os parâmetros:

 ```
  Name: SonarQube 4.5.1
  Server URL: http://localhost:9000
  SonarQube account login: admin
  SonarQube account password: admin
  Database URL: jdbc:postgresql://localhost/sonar
  Database login: postgres
  Database password: postgres
 ```
10. Clicar em clicar em **Salvar**
7. Clicar em **Novo job**.
8. Selecionar **Construir um projeto de software free-style**, informar o nome **MedCEP** e clicar em OK.
9. No campo ***GitHub project***, informar a URL https://github.com/vinnysoft/MedCEP.
9. Na seção **Gerenciamento do código fonte**, selecionar **Git**.
10. No campo ***Repository URL***, informar a URL https://github.com/vinnysoft/MedCEP.git.
11. No campo ***Credentials***, clicar em ***Add*** e informar o usuário e senha do GitHub.
12. Na seção **Trigger de builds**, marcar **Construir periodicamente** informando o parâmetro `@hourly` (para verificar o repositório a cada hora). 
13. Na seção **Build**, clicar em **Adicionar passo no build -> Invoke Standalone SonarQube Analysis**.
14. No campo ***Analysis properties***, informar os parâmetros:

 ```
  sonar.projectKey=medcep
  sonar.projectName=MedCEP
  sonar.projectVersion=1.0
  sonar.sources=.
 ``` 
13. Clicar em **Salvar**.


## Configuração do Mantis Bug Tracking
### Requisitos
- Wamp Server 2.5 (Windows + Apache + MySQL + PHP server) (x64) - [Download](http://sourceforge.net/projects/wampserver/files/WampServer%202/Wampserver%202.5/wampserver2.5-Apache-2.4.9-Mysql-5.6.17-php5.5.12-64b.exe/download)
- Mantis Bug Tracking 1.2.19 - [Download] (http://sourceforge.net/projects/mantisbt/files/mantis-stable/1.2.19/mantisbt-1.2.19.zip/download)
 
### Instruções para configuração
1. Instalar o Wamp Server 2.5
2. Alterar o idioma para Português (clicar com botão direito do mouse no ícone do Wamp Server 2.5 na bandeja do Windows, depois em <b>"Language -> portuguese"</b>).
2. Abrir o phpMyAdmin (clicar no ícone do Wamp Server 2.5 na bandeja do Windows, depois em <b>"phpMyAdmin"</b>).
3. Clicar em <b>Utilizadores</b> no menu superior.
4. Clicar em <b>Alterar Privilégios</b> para o utilizador <b>root</b> na máquina <b>localhost</b>.
5. No grupo <b>Alterar a palavra-passe</b>, informar a senha root e clicar em <b>Executar</b>.
3. Clicar em <b>New</b> no menu lateral esquerdo, para criar o banco de dados para o Mantis Bug Tracking.
4. Informar o nome <b>"mantis"</b> e clicar em <b>Criar</b>.
5. O banco de dados <b>"mantis"</b> aparecerá na listagem logo abaixo (na mesma tela). Clicar em <b>Verificar Privilégios</b>.
6. Clicar em <b>Adicionar utilizador</b>.
7. Informar User name: mantis, Host: localhost, Palavra-passe: mantis, Re-type: mantis, clicar em <b>"Executar"</b>.
2. Abrir o diretório <b>"www"</b> (clicar no ícone do Wamp Server 2.5 na bandeja do Windows, depois em <b>"diretório www"</b>).
3. Descompactar o arquivo zip do Mantis Bug Tracking no <b>"diretório www"</b>.
4. Renomear a pasta do Mantis Bug Tracking de <b>"mantisbt-1.2.19"</b> para <b>"mantis"</b>.
5. Acessar a URL: [http://localhost/mantis/](http://localhost/mantis/)
6. Informar <b>Type of Database: MySQL (default), Hostname: localhost, Username: mantis, Password: mantis, Database name: mantis</b>, clicar em <b>"Install/Upgrade Database"</b>.
7. Após a instalação, acessar novamente a URL [http://localhost/mantis/](http://localhost/mantis/)
8. Informar o usuário <b>Administrator</b> e senha <b>root</b> para acessar o Mantis Bug Tracking.
-->

## IMPORTANTE
<b>Os passos informados nas instruções de configuração foram baseados em um ambiente de desenvolvimento. Para ambientes de produção, as variáveis como senha, URL e local de instalação deverão ser alteradas de acordo com cada necessidade.</b>

## Referência
C. X. MARETTO and M. P. BARCELLOS, <b>[Uma Arquitetura de Referência para Medição de Software](http://nemo.inf.ufes.br/wp-content/papercite-data/pdf/uma_arquitetura_de_referccncia_para_medicccco_de_software_2014.pdf)</b> in XIII Simpósio Brasileiro de Qualidade de Software (SBQS 2014), 2014.

## Licença
```
 SoMeSPC - A powerful tool for measurement
 
 Copyright 2013 Ciro Xavier Maretto
 Copyright 2015 Henrique Néspoli Castro, Vinícius Soares Fonseca                          

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU Lesser General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Lesser General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <https://www.gnu.org/licenses/lgpl.html>.
```

