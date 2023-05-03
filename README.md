# Teste Programador Backend Júnior/Trainee
## Descrição
Um cliente chamado Bruce Wayne nos contratou para fazer um sistema com o objetivo de catalogar os super-heróis existentes.
</br>
Parece uma missão difícil, mas, não se preocupe, o seu papel não será o de sair por aí procurando por heróis, vamos deixar isso para o Sr. Wayne...
</br>
Seu papel é desenvolver uma API com as operações básicas de cadastro de um herói e algum mago (coff, coff) do front-end fará as telas.
</br>

## Requisitos
- [x]  Criar endpoint de cadastro de heróis;
- [x] Criar endpoint de busca de heróis e seus atributos por ID. ***Caso não encontre o herói o sistema deve retornar um erro 404 (Not Found)***;
- [x] Criar endpoint de busca de heróis e seus atributos por filtro, nesse caso o filtro será apenas o nome. ***Caso não encontre nenhum herói o sistema deve retornar um sucesso 200 com o body vazio***;
- [x] Criar endpoint de atualização de heróis, todos os campos poderão ser atualizados. ***Caso não encontre o herói o sistema deve retornar um erro 404 (Not Found)***
- [x] Criar endpoint de exclusão de heróis. A exclusão será física, ok? (Física?! É, deleta o registro da base). ***Caso não encontre o herói o sistema deve retornar um erro 404 (Not Found)***.

## Considerações
Por motivos de falta de configuração (do lombok) acabei não o utilizando, utilizei Hibernate/JPA para persistencia dos dados e marcação das classes de dominio, todos os endpoints estão funcionando exatamente como o descrito pela descrição do problema, tirando os apesares, está tudo dentro dos conformes 
