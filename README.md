# DemoBlazer Project  - Projeto de Automação de Testes

Este projeto tem como objetivo aplicar os conhecimentos adquiridos utilizando Selenium WebDriver em conjunto com Java e JUnit na criação de testes automatizados do site [DemoBlaze](https://www.demoblaze.com/). 
O objetivo deste projeto é testar funcionalidades principais como cadastro de usuário, login, adição de produtos ao carrinho garantindo a integridade do processo de compra e navegação.

Ao longo do desenvolvimento deste projeto, foi abordado diversos aspectos da automação, desde a interação com elementos na interface do usuário até a validação de comportamentos e mensagens de erro esperados. A escolha do DemoBlaze como aplicação alvo permite um estudo abrangente das diferentes funcionalidades que um usuário final utilizaria em uma plataforma de e-commerce.

![home pic](https://github.com/carolprotasio/demoBlazer-Project/blob/master/src/test/java/assets/homePic.png)

## ⚙️ Tecnologias Utilizadas

- **Java**: Linguagem de programação para o desenvolvimento dos testes.
- **Selenium WebDriver**: Ferramenta para automação de navegadores.
- **JUnit**: Framework para estruturação e execução dos testes.
- **Maven**: Gerenciamento de dependências e ciclo de vida do projeto.
- **Log4j**: Ferramenta para geração de logs.
- **Git**: Controle de versão.

## Como Executar o Projeto

### Pré-requisitos

- JDK 8+ instalado.
- Maven instalado.
- Navegador Google Chrome ou Firefox.

### Passos para Execução

1. Clone o repositório:

    ```bash
    git clone https://github.com/carolprotasio/demoBlazer-Project.git
    ```

2. Acesse o diretório do projeto:

    ```bash
    cd demoBlazer-Project
    ```

3. Execute os testes com Maven:

    ```bash
    mvn clean test
    ```
# Funcionalidades Testadas

## 🔎 Cenários de Teste e Critérios de Aceitação

## 🔒 Validate Sign Up Functionality

### CT-001: Sign Up successfully
- **Cenário:** Usuário realiza o cadastro com sucesso.
- **Critérios de Aceitação:** O usuário deve ser registrado com sucesso e uma mensagem de confirmação deve ser exibida.

### CT-002: Validate Sign Up with ALL fields empty - Validate Error Msg
- **Cenário:** Usuário tenta se cadastrar sem preencher nenhum campo.
- **Critérios de Aceitação:** Uma mensagem de erro apropriada deve ser exibida, indicando que todos os campos são obrigatórios.

### CT-003: Validate Sign Up with User Name field empty - Validate Error Msg
- **Cenário:** Usuário tenta se cadastrar sem preencher o campo "User Name".
- **Critérios de Aceitação:** Uma mensagem de erro deve ser exibida, indicando que o campo "User Name" é obrigatório.

### CT-004: Validate Sign Up with Password field empty - Validate Error Msg
- **Cenário:** Usuário tenta se cadastrar sem preencher o campo "Password".
- **Critérios de Aceitação:** Uma mensagem de erro deve ser exibida, indicando que o campo "Password" é obrigatório.

### CT-005: Close Window Button
- **Cenário:** Usuário fecha a janela de cadastro usando o botão de fechar.
- **Critérios de Aceitação:** A janela de cadastro deve ser fechada sem cadastrar o usuário.

![signup pic](https://github.com/carolprotasio/demoBlazer-Project/blob/master/src/test/java/assets/signup.png)

---

## 🔑 Validate Log In Functionality

### CT-001: Log In successfully
- **Cenário:** Usuário realiza login com sucesso.
- **Critérios de Aceitação:** O usuário deve ser autenticado e redirecionado para a página inicial.

### CT-002: Login with invalidated user name - Validate error msg
- **Cenário:** Usuário tenta realizar login com um nome de usuário inválido.
- **Critérios de Aceitação:** Uma mensagem de erro deve ser exibida, indicando que o nome de usuário é inválido.

### CT-003: Login with invalidated password - Validate error msg
- **Cenário:** Usuário tenta realizar login com uma senha inválida.
- **Critérios de Aceitação:** Uma mensagem de erro deve ser exibida, indicando que a senha é inválida.

### CT-004: Login with empty fields - Validate error msg
- **Cenário:** Usuário tenta realizar login sem preencher os campos obrigatórios.
- **Critérios de Aceitação:** Uma mensagem de erro deve ser exibida, indicando que todos os campos são obrigatórios.

![login pic](https://github.com/carolprotasio/demoBlazer-Project/blob/master/src/test/java/assets/login.png)

---

## 📦 Validate Product Functionality

### CT-001: Select & Add ONE Product to the cart successfully
- **Cenário:** Usuário seleciona e adiciona um produto ao carrinho com sucesso.
- **Critérios de Aceitação:** O produto deve ser adicionado ao carrinho, e o usuário deve poder visualizar o item no carrinho.

### CT-002: Select & Add FOUR Products to the cart successfully
- **Cenário:** Usuário seleciona e adiciona quatro produtos ao carrinho com sucesso.
- **Critérios de Aceitação:** Todos os produtos devem ser adicionados ao carrinho e listados corretamente.

### CT-003: From Phones Category Add ONE Product to the cart successfully
- **Cenário:** Usuário seleciona e adiciona um produto da categoria "Phones" ao carrinho com sucesso.
- **Critérios de Aceitação:** O produto da categoria "Phones" deve ser adicionado ao carrinho com sucesso.

### CT-004: From Laptops Category Add ONE Product to the cart successfully
- **Cenário:** Usuário seleciona e adiciona um produto da categoria "Laptops" ao carrinho com sucesso.
- **Critérios de Aceitação:** O produto da categoria "Laptops" deve ser adicionado ao carrinho com sucesso.

### CT-005: From Monitors Category Add ONE Product to the cart successfully
- **Cenário:** Usuário seleciona e adiciona um produto da categoria "Monitors" ao carrinho com sucesso.
- **Critérios de Aceitação:** O produto da categoria "Monitors" deve ser adicionado ao carrinho com sucesso.

### CT-006: Should get One product from each category to the cart successfully
- **Cenário:** Usuário seleciona e adiciona um produto de cada categoria ao carrinho com sucesso.
- **Critérios de Aceitação:** Os produtos de todas as categorias devem ser adicionados ao carrinho corretamente.

### CT-007: Navigate to Product Description successfully
- **Cenário:** Usuário navega para a descrição do produto selecionado.
- **Critérios de Aceitação:** A página de descrição do produto deve ser exibida corretamente.

![product pic](https://github.com/carolprotasio/demoBlazer-Project/blob/master/src/test/java/assets/product.png)
---

## 🛒 Validate Cart functionality

### CT-001: Purchase One Product successfully
- **Cenário:** Usuário adiciona um produto ao carrinho e realiza a compra com sucesso.
- **Critérios de Aceitação:** A compra deve ser concluída com sucesso, e uma confirmação da compra deve ser exibida.

### CT-002: Purchase FOUR Products successfully
- **Cenário:** Usuário adiciona quatro produtos ao carrinho e realiza a compra com sucesso.
- **Critérios de Aceitação:** A compra deve ser concluída com sucesso, e uma confirmação da compra deve ser exibida. 

### CT-003: Add One Products To Cart and Delete it
- **Cenário:** Usuário adiciona um produto ao carrinho e, em seguida, remove-o.
- **Critérios de Aceitação:** O produto deve ser removido do carrinho com sucesso, e o carrinho deve estar vazio.

![cart pic](https://github.com/carolprotasio/demoBlazer-Project/blob/master/src/test/java/assets/cart.png)

---

# Conclusão
O DemoBlazer Project ilustra como a automação de testes pode ser aplicada de maneira eficaz em um contexto de e-commerce, proporcionando uma cobertura de testes significativa para as funcionalidades do site. Através da automação, é possível identificar e corrigir potenciais falhas no fluxo de cadastro, login, e processo de compra, garantindo que a experiência do usuário final seja a melhor possível.

Por fim, a abordagem utilizada aqui pode ser expandida e adaptada para outras aplicações e funcionalidades, demonstrando a versatilidade e importância da automação no ciclo de desenvolvimento de software.


