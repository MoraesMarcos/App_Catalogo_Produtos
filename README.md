# 📱 App Catálogo de Produtos  
Aplicativo Android desenvolvido em Kotlin utilizando **Jetpack Compose**, **MVVM**, **Retrofit** e **Room**.  
O objetivo é exibir um catálogo de produtos com lista, detalhes, favoritos e funcionamento offline.

---

## 🚀 Tecnologias Utilizadas

### **Frontend (UI)**
- Jetpack Compose
- Material Design 3
- Navegação com Navigation Compose

### **Arquitetura**
- MVVM (Model–View–ViewModel)
- Repository Pattern
- Clean Architecture (camadas: data, domain, ui)

### **Backend / Dados**
- Retrofit + Gson
- Room Database
- DTO → Model mappers
- FakeStore API (ou API real configurada pelo grupo)

---

## 👥 Equipe e Divisão de Tarefas

### **Flávio — UI/UX + Compose**
- Criar telas principais (lista, detalhes, favoritos)  
- Criar componentes reutilizáveis  
- Definir tema, cores e tipografia  
- Garantir responsividade  

### **Lucas — Banco de Dados (Room)**
- Criar `ProductEntity`  
- Criar DAO (CRUD)  
- Configurar `AppDatabase`  
- Implementar parte local do Repository  

### **Marcos — API + Networking**
- Configurar Retrofit  
- Criar DTOs  
- Criar endpoints e service  
- Implementar Repository remoto  
- Testar API (já funcionando ✅)

### **Marcos— MVVM + Navegação**
- Criar ViewModels e estados com `sealed class`  
- Criar NavHost e rotas  
- Integrar Repository com UI  
- Gerenciar estados de loading e erro  

---

## 🧱 Funcionalidades do App

- Listagem de produtos
- Tela de detalhes
- Busca por nome ou categoria
- Favoritos usando Room
- Modo offline (cache local)
- Tema personalizado
- Navegação fluida entre telas

---

## ▶️ Como Rodar o Projeto

1. Clone o repositório:

git clone https://github.com/MoraesMarcos/App_Catalogo_Produtos.git


2. Abra no Android Studio

3. Sincronize o Gradle

4. Rode no emulador ou dispositivo físico

---

## 🌐 API Configurada

Base URL utilizada:

https://fakestoreapi.com/
