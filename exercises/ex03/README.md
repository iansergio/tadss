1. Faça um programa que gere um array de 1 bilhão de números inteiros aleatórios e faça as seguintes tarefas:

    1. Some todos os valores de forma sequencial e meça o tempo de execução;
        - **Resultado: Tempo de execução (ms): 557. Tempo de execução (s): 0.5577247**

    2. Some todos os valores de forma concorrente com 10 threads e meça o tempo de execução;
        - **Resultado: Tempo de execução (ms): 125. Tempo de execução (s): 0.1157504**

    3. Some todos os valores de forma concorrente com 100 threads e meça o tempo de execução.
        - **Resultado: Tempo de execução (ms): 143. Tempo de execução (s): 0.1439627**

    4. Responda as seguintes perguntas:
        1. Qual foi o speedup obtido?
           - **Resposta: 10 threads: 247ms dividido por 115ms = 2.15 mais rápido. 100 threads: 247ms dividido por 126ms = 1.96 mais rápido**

        2. Teve algum caso que o speedup foi negativo?
           - **Resposta: Não houve speedup negativo em relação à execução sequencial. As duas versões concorrentes foram mais rápidas. Porém, com 100 threads foi mais lento do que com 10 threads (126ms vs 115ms). Isso ocorre porque a tarefa é limitada pela memória RAM. Adicionar mais threads só aumenta a troca de contexto e não traz desempenho.**

    5. Repita os testes acima usando Threads virtuais.
        - **Tempo de execução com 10 threads virtuais (ms): 133. Tempo de execução (s): 0.1337623**
        - **Tempo de execução com 100 threads virtuais (ms): 141. Tempo de execução (s): 0.1412159** 

        1. Houve diferenças entre Threads de plataforma e Threads virtuais? Se houve, quais foram e explique o porquê das diferenças.
            - **Resposta: Não houve diferenças significativas entre as threads de plataforma e as threads virtuais. Threads virtuais são úteis quando a tarefa fica parada esperando algo (rede, banco, arquivo). Nesse caso, as threads nunca ficam paradas, elas só calculam o tempo todo. Por isso as threads virtuais e as de plataforma tiveram o mesmo desempenho.**