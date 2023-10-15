# Hash

Uma tabela hash é uma estrutura de dados usada para armazenar pares de chaves/valores. Ele usa uma função hash para calcular um índice em um array no qual um elemento será inserido ou pesquisado. Ao usar uma boa função hash, o hash pode funcionar bem.

<p align="center" width="100%">
  <img width="50%" src="https://cdn.discordapp.com/attachments/1145368578737057802/1163130118139555860/hash-table.png?ex=653e7456&is=652bff56&hm=0db60b5be63b109bc054c778c91d86503dd2cf8b89a274e5968a8e59f91f0b24&">
  
</p>


# Funcionalidades do Projeto


**1. Aceita de forma genérica o tipo da chave tanto como string como inteiro:** Isso significa que a tabela hash é flexível o suficiente para aceitar chaves tanto no formato de strings como de inteiros.

**2. Inserir uma chave, onde você define a chave com seu valor:** Essa operação permite que você adicione uma nova chave à tabela, junto com o seu valor correspondente.
 
**3. Remover chaves, onde removo a chave e seu valor:** Permite a remoção de uma chave específica, juntamente com o seu valor associado.

**4. Buscas de chaves, onde você busca por uma chave e ele te retorna um valor:** Isso significa que você pode procurar por uma chave na tabela e obter o valor correspondente associado a ela.

**5. Apresentam 2 tipos de tratamentos de colisão implementados:** Existem diferentes maneiras de lidar com colisões em tabelas hash (quando duas chaves diferentes resultam no mesmo índice). Esta implementação oferece duas estratégias diferentes para lidar com esse cenário.

**6. Apresenta um teste de eficiência na busca em tempo:** Isso indica que há um procedimento ou código disponível para testar e avaliar o desempenho da busca na tabela hash em relação ao tempo.

**7. Apresenta o fator carga que ao atingir a capacidade máxima ele dobra o tamanho da array de armazenamento utilizado na tabela hash:** O fator de carga é um indicador de quão "cheia" está a tabela hash. Quando atinge uma capacidade máxima predefinida, a tabela hash expande sua capacidade (geralmente duplicando o tamanho da array de armazenamento) para manter uma boa eficiência.
