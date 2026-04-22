<!-- # Tópicos Avançados em Desenvolvimento de Software e Sistemas

## Programação Concorrente
#### Exercícios disponíveis [aqui](https://github.com/glaucioscheibel/exercicios?tab=readme-ov-file#programa%C3%A7%C3%A3o-concorrente)

### Conceitos

**O que é um processo?**  
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

**O que é uma thread daemon?**  
É uma thread de baixa prioridade que executa em segundo plano. Um exemplo é o garbage collector. Threads daemon são finalizadas automaticamente quando não há mais threads de usuário em execução.

**O que é um sistema operacional preemptivo?**  
É um sistema que interrompe processos para redistribuir o uso da CPU entre eles.

**O que é um sistema operacional cooperativo?**  
É um sistema onde os próprios processos cedem voluntariamente o uso da CPU.

**O que é uma blocked thread?**  
É uma thread que está temporariamente parada aguardando um recurso.

---

### Estados de uma Thread

**New (Novo)**  
Thread foi criada, mas ainda não está pronta para execução.

**Ready (Pronta)**  
Thread está pronta e aguardando ser escolhida pelo scheduler para execução.

**Running (Executando)**  
Thread está em execução e utilizando a CPU.

**Dead (Finalizada)**  
Thread já terminou sua execução e não pode ser iniciada novamente.

---

### Métodos 

**start()**  
Coloca a thread no estado *Ready*, ou seja, ela entra na fila de execução aguardando o scheduler.

**thread.sleep()**  
Faz a thread entrar em estado de espera (*waiting*) por pelo menos o tempo especificado, até poder voltar para execução.

---

### Sincronização

**O que é um semáforo?**  
É uma estrutura de controle usada para gerenciar o acesso concorrente a recursos compartilhados.

**Qual a diferença entre mutex e semáforo?**  
Um mutex é um tipo especial de semáforo com valor binário (0 ou 1), utilizado para exclusão mútua. -->