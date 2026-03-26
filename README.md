# Tópicos Avançados em Desenvolvimento de Software e Sistemas

## Programação Concorrente

### Conceitos Fundamentais

**O que é um processo (task)?**  
É um programa em execução.

**O que é um sistema operacional multitarefa?**  
É um sistema operacional que permite a execução de mais de um processo simultaneamente.

**O que é uma thread?**  
É uma linha de execução dentro de um processo.

**O que é um sistema operacional multithread?**  
É um sistema operacional que permite múltiplas threads por processo.

**O que é um processo multithread?**  
É um processo que utiliza várias linhas de execução para realizar suas tarefas.

**O que é latência?**  
É o tempo que uma requisição leva desde o envio até a resposta.

**O que é throughput?**  
É a quantidade de operações que um sistema consegue processar em um determinado intervalo de tempo.

---

### Threads e Execução

**O que é uma thread daemon?**  
É uma thread de baixa prioridade que executa em segundo plano. Um exemplo é o garbage collector. Threads daemon são finalizadas automaticamente quando não há mais threads de usuário em execução.

**O que é um sistema operacional preemptivo?**  
É um sistema que interrompe processos para redistribuir o uso da CPU entre eles.

**O que é um sistema operacional cooperativo?**  
É um sistema onde os próprios processos cedem voluntariamente o uso da CPU.

**O que é uma blocked thread?**  
É uma thread que está temporariamente parada aguardando um recurso.

---

### Sincronização

**O que é um semáforo?**  
É uma estrutura de controle usada para gerenciar o acesso concorrente a recursos compartilhados.

**Qual a diferença entre mutex e semáforo?**  
Um mutex é um tipo especial de semáforo com valor binário (0 ou 1), utilizado para exclusão mútua.
