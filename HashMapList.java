import java.util.LinkedList;

public class HashMapList<K, V> implements HashMap<K,V> {
    private final int Tamanho_Inicial = 16;
    private final double Limite = 0.75;

    private int size;
    private int colisions;
    private int tamanho_maximo;
    private LinkedList<Objeto<K, V>>[] table;

    public HashMapList() {
        this.tamanho_maximo = Tamanho_Inicial;

        this.table = new LinkedList[tamanho_maximo];                                                 // Cria uma lista de tamanho '16'
        
        for (int i = 0; i < tamanho_maximo; i++) {                                                   // Preenche essa lista com outras listas de tamanho 'n' para armazenar colisões
            table[i] = new LinkedList<>();
        }

    }

    private static class Objeto<K, V> {                                                             // Objeto geneérico para armazenar Vinculo de Chave <> Valor
        K key;
        V value;

        Objeto(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int IndexFromHash(K key) {                                                                                                                         // Calcula o hash da chave
        return (key.hashCode() & 0x7FFFFFFF) % tamanho_maximo;                                                // Calcula o index usando somente os valores positivos do hashCode e levando em consideração a tamanho da tabela.
    }

    private LinkedList<Objeto<K, V>> BucketFromKey(K key){
        int index = IndexFromHash(key);                                                             // Calcula o Index
        return table[index];                                                                        // Extrai a lista de colisões baseado no index calculado.
    }

    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("A chave não pode ser Nula.");

        if (size >= Limite * tamanho_maximo) resize();                                              // Se a lista estiver 75% cheia, aumenta o tamanho.

        LinkedList<Objeto<K, V>> espaco_de_colisoes = BucketFromKey(key);                           // Lista a ser utilziada
        for (Objeto<K, V> objeto : espaco_de_colisoes) {
            if (objeto.key.equals(key)) {
                objeto.value = value;                                                               // Se já existir uma chave identica, atualiza o valor.
                return;
            }
        }
        if (espaco_de_colisoes.size()>0) colisions++;
        espaco_de_colisoes.add(new Objeto<>(key, value));                                           // Caso contrario, adiciona um novo objeto e aumenta o tamnho.
        size++;                                         
    }

    public V get(K key) {
        if (key == null) return null;
        
        LinkedList<Objeto<K, V>> espaco_de_colisoes = BucketFromKey(key);                           // Lista a ser utilziada
        
        for (Objeto<K, V> objeto : espaco_de_colisoes) {
            if (objeto.key.equals(key)) {                                                           // Retorna o valor se chave for encontrada.
                return objeto.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        if (key == null) return;

        LinkedList<Objeto<K, V>> espaco_de_colisoes = BucketFromKey(key);                           // Lista a ser utilziada

        for (Objeto<K, V> objeto : espaco_de_colisoes) {
            if (objeto.key.equals(key)) {                                                           // Remove se encontrar
                espaco_de_colisoes.remove(objeto);                 
                size--;                                                                             // diminui o tamanho
                return;
            }
        }
    }


    private void resize() {
        tamanho_maximo *= 2;                                                                              // Cria uma nova tabela com o dobro do tamanho.
        LinkedList<Objeto<K, V>>[] newTable = new LinkedList[tamanho_maximo];

        for (int i = 0; i < tamanho_maximo; i++) {                                                        // preenche com listas vazias.
            newTable[i] = new LinkedList<>();
        }

        for (LinkedList<Objeto<K, V>> espaco_de_colisoes : table) {                                 // Atualiza as listas, recalculando os hash dos itens inseridos anteriormente na lista menor.
            for (Objeto<K, V> objeto : espaco_de_colisoes) {
                int index = IndexFromHash(objeto.key);
                newTable[index].add(objeto);
            }
        }

        table = newTable;                                                                           // Atualiza a referência da tabela antiga pra nova.
    }

    public int size() {
        return size;
    }

    public int colisions(){
        return colisions;
    }
}
