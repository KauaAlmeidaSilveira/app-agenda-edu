# AgendaEdu

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Angular](https://img.shields.io/badge/-Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white)

### Descrição Geral

O "AgendaEdu" é um sistema de agendamento de salas para instituições educacionais, permitindo que professores e outros funcionários reservem espaços como salas de aula, laboratórios, teatro e auditórios. O sistema terá dois tipos de usuários: funcionários (professores, coordenadores, diretores, etc.) e administradores.

### Usuários e Autenticação

- **Tipos de Usuários**: Funcionário e Administrador.
- **Sistema de Autenticação**: Login/Logout com dois níveis de acesso (usuário comum e administrador).
- **Recuperação de Senha e Autenticação de Dois Fatores**: Inicialmente, não será necessário.
- **Telas de Cadastro e Login**: Interfaces simples e intuitivas para registro e autenticação de usuários. A funcionalidade de recuperação de senha será desativada inicialmente.

### Salas e Recursos

- **Tipos de Salas**: Salas de aula, laboratórios, teatro, auditório, etc.
- **Gerenciamento de Salas**: Lista fixa de salas e recursos; mudanças serão feitas manualmente.

### Calendário e Agendamento

- **Interface do Calendário**: Mensal, permitindo aos usuários selecionar um dia específico.
- **Reservas Recorrentes**: Necessidade de reservar manualmente cada ocorrência.
- **Conflito de Agendamentos**: Usuários não poderão visualizar períodos já reservados, evitando assim conflitos.
- **Tela de Agendamento**: Interface clara para inserir detalhes do agendamento, como local, data, horários de entrada e saída, nome do professor e turmas. A seleção de data é feita através de um input de calendário, garantindo uma experiência de usuário eficiente.

### Menu Principal

- **Tela de Menu**: Permite aos usuários criar novos agendamentos e visualizar seus agendamentos existentes. A interface é direta e fácil de navegar.

### Notificações e Lembretes

- **Notificações**: Inicialmente, o sistema não enviará notificações de confirmação, lembretes ou alterações nos agendamentos.

### Relatórios e Histórico

- **Relatórios**: Inicialmente, não haverá geração de relatórios de uso das salas.
- **Histórico**: Haverá um histórico de agendamentos que os usuários poderão consultar, com todas as informações dadas no agendamento (data, hora, usuário, motivo, etc.).

### Administração do Sistema

- **Funções do Administrador**: Ver, modificar e cancelar agendamentos de outros usuários.
- **Gerenciamento de Disponibilidade**: Inicialmente, não haverá funções para bloquear horários para manutenção.

### Interface do Usuário

- **Preferências Específicas**: Inicialmente, não há preocupações específicas com design.
- **Suporte a Múltiplos Idiomas**: Não será necessário.

### Acessibilidade e Escalabilidade

- **Acessibilidade**: Inicialmente, não haverá considerações específicas para acessibilidade.
- **Escalabilidade**: Inicialmente, o sistema não precisa ser escalável para suportar um aumento no número de usuários ou salas.

### Backup e Segurança

- **Backup e Segurança**: Inicialmente, não haverá implementação de backups automáticos e medidas de segurança adicionais para proteger os dados.
