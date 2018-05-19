# javafx-app

Desenvolvimento de um sistema de controlo de acessos a áreas restritas utilizando a linguagem Java e a framework de interface gráfica JavaFX, implementando o padrão de design MVC.

## **Estrutura do Projecto**

```
main
├─── java
│    ├─── controllers
│    ├─── exceptions
│    ├─── models
│    ├─── utils
│    └─── App.java
└─── resources
     ├─── database
     │    ├─── serialized
     │    ├─── text
     │    └─── logs.txt
     ├─── img
     │    ├─── screenshots
     │    └─── modelo-dominio.jpg
     ├─── styles
     └─── views
```

A aplicação inicia no App.java e este inicializa 2 componentes, o Menu e o Pane. O Menu é re-utilizado em todas as views, sendo trocado apenas o Pane quando se muda de página.

A aplicação começa por inserir no Pane a página Dashboard, sendo esta a página inicial.

## **Menu**

| Screenshots | Descrição |
| ----------- | --------- |
| ![menu-1](./src/main/resources/img/screenshots/menu-1.png) | Secção geral do menu, permite ir para o Dashboard, Logger ou sair da aplicação. |
| ![menu-2](./src/main/resources/img/screenshots/menu-2.png) | Secção de registos do menu, permite navegar para as páginas onde se consegue efectuar os registos. |
| ![menu-3](./src/main/resources/img/screenshots/menu-3.png) | Secção de acções do menu, permite navegar para as páginas onde se consegue registar um novo perfil de acesso ou aceder a uma área restrita. |

## **Dashboard**

| Screenshots | Descrição |
| ----------- | --------- |
| ![serialize-1](./src/main/resources/img/screenshots/serialize-1.png) | Permite fazer load a um estado previo da aplicação que foram serializados em ficheiro binário. |
| ![serialize-2](./src/main/resources/img/screenshots/menu-2.png) | Permite gravar o estado da aplicação num ficheiro binário através de serialização. Quando se faz uma gravação do estado o ficheiro serializado vai ter um nome com o seguinte formato “AAAA-MM-DD-HH-MM-SS.bin” para fácil reconhecimento para o utilizador. |
| ![text-files-1](./src/main/resources/img/screenshots/text-files-1.png) | Permite fazer load de dados em formato de ficheiro de texto. Pode fazer load de apenas os models que o utilizador desejar, mas também permite fazer load de todos os ficheiros de uma só vez. |
| ![text-files-2](./src/main/resources/img/screenshots/text-files-2.png) | |

## **Logger**

| Screenshots | Descrição |
| ----------- | --------- |
| ![logger-1](./src/main/resources/img/screenshots/logger-1.png) | A aplicação contém um built-in logger para que recorda todas as ações do utilizados e possíveis erros da aplicação. É um recurso muito útil não só para quem desenvolve a aplicação, mas também para o possível administrador. |

## **Áreas Restritas**

| Screenshots | Descrição |
| ----------- | --------- |
| ![areas-restritas-1](./src/main/resources/img/screenshots/areas-restritas-1.png) | No registo de áreas restritas é possível visualizar todos as áreas restritas instanciadas no estado corrente da aplicação. Também é possível adicionar novas áreas ou eliminar áreas existentes. |

## **Cartões**

| Screenshots | Descrição |
| ----------- | --------- |
| ![cartoes-1](./src/main/resources/img/screenshots/cartoes-1.png) | No registo de cartões é possível visualizar todos os cartões instanciados no estado corrente da aplicação. Também é possível adicionar novos cartões ou eliminar cartões existentes. |

## **Colaboradores**

| Screenshots | Descrição |
| ----------- | --------- |
| ![colaboradores-1](./src/main/resources/img/screenshots/colaboradores-1.png) | No registo de colaboradores é possível visualizar todos os colaboradores instanciados no estado corrente da aplicação. Também é possível adicionar novos colaboradores ou eliminar colaboradores existentes. |

## **Equipamentos**

| Screenshots | Descrição |
| ----------- | --------- |
| ![equipamentos-1](./src/main/resources/img/screenshots/equipamentos-1.png) | No registo de equipamentos é possível visualizar todos os equipamentos instanciados no estado corrente da aplicação. Também é possível adicionar novos equipamentos ou eliminar equipamentos existentes. |

## **Períodos de Autorização**

| Screenshots | Descrição |
| ----------- | --------- |
| ![periodos-autorizacao-1](./src/main/resources/img/screenshots/periodos-autorizacao-1.png) | No registo de períodos de autorização é possível visualizar todos os períodos instanciados no estado corrente da aplicação. Também é possível adicionar novos períodos ou eliminar períodos existentes. |

## **Registar Perfil**

| Screenshots | Descrição |
| ----------- | --------- |
| ![registar-perfil-1](./src/main/resources/img/screenshots/registar-perfil-1.png) | Na página de registar perfil é possível visualizar todos os perfis de acesso instanciados no estado corrente da aplicação e criar um novo perfil de acesso com base no registo de períodos de autorização existente em memória no estado da aplicação. |

## **Aceder a Área Restrita**

| Screenshots | Descrição |
| ----------- | --------- |
| ![aceder-area-restrita-1](./src/main/resources/img/screenshots/aceder-area-restrita-1.png) | Na página aceder a área restrita é possível selecionar um cartão, um equipamento, um dia da semana e uma hora de acesso e verificar se esse determinado cartão (que pertence a um colaborador) tem acesso à área restrita onde o equipamento se situa. |
| ![aceder-area-restrita-2](./src/main/resources/img/screenshots/aceder-area-restrita-2.png) | Primeiro seleciona-se um cartão do da choice box, onde constam todas as instâncias de cartões em memória na aplicação. |
| ![aceder-area-restrita-3](./src/main/resources/img/screenshots/aceder-area-restrita-3.png) | Segundo seleciona-se um equipamento da choice box, onde constam todas as instâncias de equipamentos em memória na aplicação. |
| ![aceder-area-restrita-4](./src/main/resources/img/screenshots/aceder-area-restrita-4.png) | Depois seleciona-se um dia da semana da choice box. |
| ![aceder-area-restrita-5](./src/main/resources/img/screenshots/aceder-area-restrita-5.png) | E por fim seleciona-se uma hora de acesso. |
| ![aceder-area-restrita-6](./src/main/resources/img/screenshots/aceder-area-restrita-6.png) | No final, é possível clicar no botão e verificar qual o colaborador que tem o cartão, qual o perfil de acesso registado nesse mesmo colaborador e qual a àrea restrita em que o equipamento está presente. Após isso, verifica-se se o perfil do colaborador contém um período de autorização para aquele equipamento dentro do dia da semana e hora de acesso selecionados. Caso sim, o acesso é garantido, caso não o acesso não é garantido. |

## **Estrutura MVC**

Todos os models conhecem a classe Empresa. Todos os controllers são sub-classes do BaseController e este mantém uma instância única (singleton) da classe Empresa. Cada view conhece apenas o controller correspondente.

## **Modelo de Domínio**

![modelo-dominio](./src/main/resources/img/modelo-dominio.jpg)
