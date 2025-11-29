# 📱 App Catálogo de Produtos  
Aplicativo Android desenvolvido por uma equipe de 4 integrantes, utilizando **Jetpack Compose**, **MVVM**, **Retrofit**, **Room**, **Coroutines**, **Navigation Compose** e boas práticas de acessibilidade.  
O app exibe uma lista de produtos, permite navegação entre telas, visualização de detalhes e funcionamento offline com banco local.

---

## 👥 Integrantes da Equipe
- Marcos Vinícius – API, Networking, Repository Remoto, MVVM, ViewModels, Navegação e Estados  
- Flávio Wallefy – UI/UX, Compose, Tema e Componentes  
- Lucas Rafael – Room Database e Repository Local

> Todos participaram ativamente do desenvolvimento, com histórico de commits, branches e pull requests revisados.

---

# 🎯 Problema e Solução Proposta

Lojas, mercados e pequenos comércios frequentemente precisam de um catálogo organizado de produtos que possa ser atualizado rapidamente.  
Catálogos físicos são difíceis de manter, e sistemas tradicionais nem sempre são acessíveis no celular.

**Solução:**  
Criar um **aplicativo Android moderno**, totalmente responsivo, capaz de:

- Exibir produtos consumidos de uma API REST  
- Navegar entre lista, detalhes e favoritos  
- Garantir acessibilidade para leitores de tela  
- Manter dados offline usando Room  
- Adotar arquitetura MVVM com camadas bem definidas  
- Usar boas práticas profissionais de desenvolvimento mobile  

---

# 🧪 Funcionalidades

- 📌 Lista de produtos usando LazyColumn (Compose)  
- 📌 Tela de detalhes do produto  
- 📌 Favoritar / desfavoritar produtos  
- 📌 Busca por nome ou categoria  
- 📌 Cores e tipografia personalizadas  
- 📌 Navegação entre telas com Navigation Compose  
- 📌 Acessibilidade: labels, contrastes e descrição em imagens  
- 📌 Funcionamento offline com Room Database  
- 📌 Consumo de API com Retrofit + Coroutines  
- 📌 Estados de carregamento, erro e sucesso (StateFlow)  
- 📌 One-shot events com SharedFlow/Channel  

---

# 🏗 Arquitetura e Tecnologias Utilizadas

### 🔹 **Arquitetura MVVM**
Com separação entre:
- **Model (Domain)** → regras de negócio e modelos de dados  
- **View (Compose UI)** → telas e componentes  
- **ViewModel** → estado, lógica e comunicação  

### 🔹 **Jetpack Compose**
- Material Design 3  
- Componentes customizados  
- Responsividade com modifiers  
- Imagens acessíveis (`contentDescription`)  
- Navegação com `NavHost` e rotas  

### 🔹 **Coroutines + Flow**
- `viewModelScope.launch`  
- `suspend functions`  
- `MutableStateFlow` + `StateFlow`  
- One-shot events com `Channel` e `receiveAsFlow()`  

### 🔹 **Retrofit + Gson**
- Consumo da API FakeStore  
- DTOs separados  
- Tratamento de erros com try/catch  
- Repositório remoto  

### 🔹 **Room Database**
- Entity `ProductEntity`  
- DAO com CRUD completo  
- `AppDatabase` com Singleton  
- Repository local + cache offline  

---

## ▶️ Como Rodar o Projeto

1. Clone o repositório:

> git clone https://github.com/MoraesMarcos/App_Catalogo_Produtos

2. Abra no Android Studio

3. Sincronize o Gradle

4. Rode no emulador ou dispositivo físico

---

## 🌐 API Configurada

Base URL utilizada:

> https://fakestoreapi.com/
