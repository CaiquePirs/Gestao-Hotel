# Sistema de Gestão de Hotel

Este é um sistema simples de gestão de hotel que permite realizar as seguintes operações:

- Adicionar novos quartos ao hotel
- Listar quartos disponíveis
- Realizar reservas de quartos
- Sair do sistema

## Estrutura do Projeto

O projeto é composto por quatro classes principais:

1. **Main**: Classe principal onde o menu interativo é executado, permitindo ao usuário realizar operações de gestão de quartos e reservas.
2. **Reserva**: Classe responsável por armazenar os dados da reserva (ID, nome do cliente, data de check-in e check-out) e associar um quarto reservado.
3. **Room**: Representa um quarto do hotel, armazenando informações como ID, tipo, capacidade, preço e status (disponível ou reservado).
4. **Hotel**: Gerencia a lista de quartos e reservas, proporcionando funções para adicionar quartos e registrar reservas.

## Como Usar

### 1. **Adicionar Quarto**

Ao escolher a opção `(1) - Adicionar quarto` no menu, o sistema solicitará que você informe as seguintes informações:

- **ID do quarto**: Um número único para identificar o quarto.
- **Tipo de quarto**: O tipo de quarto (exemplo: "Duplo", "Single", etc.).
- **Capacidade**: A capacidade máxima de pessoas que o quarto pode acomodar.
- **Preço**: O valor da diária do quarto.

Após a inserção desses dados, o quarto será adicionado à lista de quartos do hotel.

### 2. **Listar Quartos**

Ao escolher a opção `(2) - Lista de quartos`, o sistema exibirá todos os quartos cadastrados no hotel. Caso não haja quartos cadastrados, o sistema informará que não há quartos disponíveis.

### 3. **Realizar Reserva**

Ao escolher a opção `(3) - Realizar reserva`, o sistema exibirá uma lista dos quartos disponíveis. Você deverá escolher o quarto através de seu índice e fornecer as informações necessárias para a reserva:

- **ID da reserva**: Um número único para identificar a reserva.
- **Nome do cliente**: Nome do cliente que está realizando a reserva.
- **Data de check-in**: A data de entrada (formato dd/MM/yyyy).
- **Data de check-out**: A data de saída (formato dd/MM/yyyy).

Após a reserva, o quarto será marcado como reservado, e a informação será registrada no sistema.

### 4. **Sair do Sistema**

Ao escolher a opção `(4) - Sair do sistema`, o programa será encerrado e o processo de gestão de hotel será finalizado.

