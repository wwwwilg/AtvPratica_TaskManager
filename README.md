# AtvPratica_TaskManager
Atividade prática criando um sistema de gerenciamento de tarefas estilo Kanban.

Instruções:

Em todos usar "localhost:8080"
Exemplo: localhost:8080/auth/register


Register (localhost:8080/auth/register):
Body:
{
    "login": "micaela",
    "password": "1234",
    "role": "ADMIN"
}


Login (localhost:8080/auth/login):
{
    "login": "micaela",
    "password": "1234"
}


Create Task (localhost:8080/task/post):
{
    "title": "titulo",
    "description": "descricao",
    "dueDate": "datalimite"
}


Edit Task (localhost:8080/task/edit/{ID}):
{ID} refere-se ao ID da tarefa que deseja editar.
Além de title, para editar outras propriedades é só adicionar o que gostaria de mudar e para o que quer que mude.
{
    "title": "tijolo"
}


Delete Task (localhost:8080/task/delete/{ID})
{ID} refere-se ao ID da tarefa que deseja deletar.


Change Status (localhost:8080/task/status/{ID})
{ID} refere-se ao ID da tarefa que deseja mudar o status, o status segue em sequência: A FAZER -> EM PROGRESSO -> CONCLUIDA -> A FAZER, e assim sucessivamente.


Change Priority (localhost:8080/task/priority/{ID})
{ID} refere-se ao ID da tarefa que deseja mudar a prioridade, a prioridade segue em sequência: BAIXA -> MEDIA -> ALTA -> BAIXA, e assim sucessivamente.


Filter by Status (localhost:8080/task/get/filterstatus/{ID})
{ID} refere-se ao ID do status que deseja filtrar as tarefas, o status segue em sequência: A FAZER (1) -> EM PROGRESSO (2) -> CONCLUIDA (3)


Filter by Priority (localhost:8080/task/get/filterpriority/{ID})
{ID} refere-se ao ID da prioridade que deseja filtrar as tarefas, a prioridade segue em sequência: BAIXA (1) -> MEDIA (2) -> ALTA (3)
