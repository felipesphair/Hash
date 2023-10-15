# Hash Table: 

Uma tabela hash é uma estrutura de dados usada para armazenar pares de chaves/valores. Ele usa uma função hash para calcular um índice em um array no qual um elemento será inserido ou pesquisado. Ao usar uma boa função hash, o hash pode funcionar bem.

<p align="center" width="100%">
  <img width="50%" src="https://cdn.discordapp.com/attachments/1145368578737057802/1163130118139555860/hash-table.png?ex=653e7456&is=652bff56&hm=0db60b5be63b109bc054c778c91d86503dd2cf8b89a274e5968a8e59f91f0b24&">
  
</p>


# Funcionalidades do Projeto: 


**1. Aceita de forma genérica o tipo da chave tanto como string como inteiro:** Isso significa que a tabela hash é flexível o suficiente para aceitar chaves tanto no formato de strings como de inteiros.

**2. Inserir uma chave, onde você define a chave com seu valor:** Essa operação permite que você adicione uma nova chave à tabela, junto com o seu valor correspondente.
 
**3. Remover chaves, onde removo a chave e seu valor:** Permite a remoção de uma chave específica, juntamente com o seu valor associado.

**4. Buscas de chaves, onde você busca por uma chave e ele te retorna um valor:** Isso significa que você pode procurar por uma chave na tabela e obter o valor correspondente associado a ela.

**5. Apresentam 2 tipos de tratamentos de colisão implementados:** Existem diferentes maneiras de lidar com colisões em tabelas hash (quando duas chaves diferentes resultam no mesmo índice). Esta implementação oferece duas estratégias diferentes para lidar com esse cenário.

**6. Apresenta um teste de eficiência na busca em tempo:** Isso indica que há um procedimento ou código disponível para testar e avaliar o desempenho da busca na tabela hash em relação ao tempo.

**7. Apresenta o fator carga que ao atingir a capacidade máxima ele dobra o tamanho da array de armazenamento utilizado na tabela hash:** O fator de carga é um indicador de quão "cheia" está a tabela hash. Quando atinge uma capacidade máxima predefinida, a tabela hash expande sua capacidade (geralmente duplicando o tamanho da array de armazenamento) para manter uma boa eficiência.

# Como Funciona o Código: 

**EXAMPLE.JAVA**:

Demonstra o uso de HashMaps e avalia o desempenho de duas implementações diferentes: uma usando encadeamento por lista e outra usando encadeamento aberto.

O método simpleTest:
Insere uma série de elementos em dois HashMaps (HM1 e HM2) e imprime valores associados a chaves específicas.
Exibe o tamanho dos HashMaps.
Remove os elementos e novamente exibe os tamanhos.

O método performanceTest:
Insere uma quantidade especificada de elementos em um HashMap e mede o tempo total para inserção e remoção.
Também exibe a quantidade de colisões simuladas.

No main:
Cria instâncias de quatro tipos diferentes de HashMaps (HML1, HML2, HME1, HME2) e executa os testes com o método simpleTest para cada par.
Permite ao usuário escolher entre realizar testes de desempenho usando encadeamento por lista ou encadeamento aberto até que o usuário opte por encerrar o programa.

<hr> 

**HashMapList.JAVA**:

O arquivo contém uma interface chamada HashMap que define um conjunto de operações comuns para um mapa (ou tabela de dispersão) em Java. Essas operações incluem a recuperação de valores por meio de chaves, inserção de pares chave-valor, remoção de entradas, obtenção do número total de entradas e a contagem de colisões (específico para a implementação do HashMap).

Essa interface serve como um contrato para qualquer classe que deseje implementar um HashMap em Java. Ela estabelece as operações básicas que devem estar disponíveis em qualquer implementação funcional de um mapa. Cada uma dessas operações é definida por uma assinatura de método, indicando o nome, os tipos de parâmetros e o tipo de retorno esperado.

Cabe à classe que implementa essa interface fornecer as implementações específicas para cada um desses métodos, de acordo com a lógica desejada para a estrutura de dados do HashMap. Por exemplo, como as colisões são tratadas ou como a busca por uma chave é realizada pode variar de uma implementação para outra.

Portanto, esse arquivo fornece uma estrutura genérica para a criação de classes que representem HashMaps em Java, permitindo uma maior flexibilidade e reutilização de código em diferentes contextos.

<hr> 

**HashMapEA.JAVA**:

Atributos:

Tamanho_Inicial: Define o tamanho inicial da tabela (16 por padrão).
Limite: Define o limite de ocupação da tabela (0.75 por padrão).
size: Armazena o número de elementos na tabela.
colisions: Conta o número de colisões ocorridas durante operações.
tamanho_maximo: Armazena o tamanho máximo atual da tabela.
table: É um array de objetos Objeto que representa a tabela de dispersão.
Classe Interna Objeto:

É uma classe que representa um par chave-valor, junto com um indicador de exclusão (deleted). Isso permite marcar elementos como "removidos" sem removê-los fisicamente, o que é útil para operações de remoção em uma tabela de dispersão.

IndexFromHash(K key):
Método privado que calcula o índice de dispersão para uma dada chave key.

put(K key, V value):
Adiciona um par chave-valor na tabela. Se a chave já existir, o valor é atualizado.
Se o fator de carga (número de elementos / tamanho da tabela) exceder o limite, a tabela é redimensionada antes da inserção.

get(K key):
Retorna o valor associado a uma chave dada. Se a chave não for encontrada, retorna null.

remove(K key):
Remove um elemento da tabela com a chave dada. O elemento não é removido fisicamente, mas marcado como excluído.

resize():
Redimensiona a tabela quando o fator de carga excede o limite. Isso envolve criar uma nova tabela com o dobro do tamanho e reorganizar os elementos.

size():
Retorna o número de elementos na tabela.

colisions():
Retorna o número de colisões que ocorreram durante as operações.

Quando duas chaves diferentes resultam no mesmo índice de dispersão (devido a colisões), o código verifica se a posição está ocupada. Se estiver, ele procura a próxima posição disponível (usando uma técnica chamada "linear probing"). Isso é feito até que uma posição vazia seja encontrada.

<hr>


**HashMap.JAVA**:

Atributos:

Tamanho_Inicial: Define o tamanho inicial da tabela de hash (neste caso, 16).
Limite: Define o limite de carga (load factor) para redimensionamento da tabela.
size: Armazena o número de elementos atualmente no mapa.
colisions: Conta o número de colisões que ocorrem durante a inserção.
tamanho_maximo: Armazena o tamanho máximo da tabela de hash.
table: É um array de listas ligadas (LinkedList) onde os elementos são armazenados.
Método Construtor:

Inicializa os atributos, cria a tabela com listas ligadas e a preenche com listas vazias.
Classe Objeto (Classe Aninhada Privada):
É uma classe que representa um par de chave-valor.

Método IndexFromHash:
Calcula o índice da tabela de hash para uma chave.

Método BucketFromKey:=
Dada uma chave, retorna a lista ligada (bucket) associada a essa chave.

Método put:
Insere um par chave-valor no mapa. Se a chave já existe, o valor é atualizado. Caso contrário, um novo par é adicionado.

Método get:
Obtém o valor associado a uma chave específica.

Método remove:
Remove o par chave-valor associado a uma chave específica.

Método resize:
Redimensiona a tabela de hash quando o limite de carga é atingido. Isso envolve a criação de uma nova tabela com o dobro do tamanho e a redistribuição dos elementos existentes.

Métodos size e colisions:
Retornam o número de elementos no mapa e o número de colisões, respectivamente.
Em resumo, esta implementação de HashMap resolve colisões mantendo uma lista ligada em cada posição da tabela. Isso permite que várias entradas com o mesmo valor de dispersão (hash) coexistam no mesmo índice.

