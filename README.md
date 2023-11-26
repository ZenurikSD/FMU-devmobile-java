# App controle de gastos - Java
> Implementação básica da funcionalidade do app usando apenas Java

Por enquanto estou usando um singleton na forma da classe `UserStorage` que armazena tudo (nome, saldo, listas de despesas e receitas etc.) mas isso vai ser substituído por DAOs para o banco assim que eu aprender como fazer isso.

## O que funciona?
1. **Receitas**     
    - [X] Listar (O ID não incrementa corretamente) 
    - [X] Adicionar
    - [X] Remover

2. **Despesas**     
    - [X] Listar (O ID não incrementa corretamente) 
    - [X] Adicionar
    - [X] Remover

3. **Usuário**
    - [X] Saldo atualiza após operações nas receitas e despesas

4. **Categorias** 
    - [ ] Lista de categorias