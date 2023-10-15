public class HashMapEA<K, V> implements HashMap<K,V> {
    private final int Tamanho_Inicial = 16;
    private final double Limite = 0.75;

    private int size;
    private int colisions;
    private int tamanho_maximo;
    private Objeto<K, V>[] table;

    public HashMapEA() {
        this.tamanho_maximo = Tamanho_Inicial;
        this.size = 0;
        this.table = new Objeto[tamanho_maximo];
    }

    private static class Objeto<K, V> {
        K key;
        V value;
        boolean deleted;

        Objeto(K key, V value) {
            this.key = key;
            this.value = value;
            this.deleted = false;
        }
    }

    private int IndexFromHash(K key) {                                                                                                                         // Calcula o hash da chave
        return (key.hashCode() & 0x7FFFFFFF) % tamanho_maximo;                                                // Calcula o index usando somente os valores positivos do hashCode e levando em consideração a tamanho da tabela.
    }

    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("A chave não pode ser Nula.");

        if (size >= Limite * tamanho_maximo) resize();

        int index = IndexFromHash(key);
        int initialIndex = index;
        while (table[index] != null) {                                                      // Se já estiver usado
            if (!table[index].deleted && table[index].key.equals(key)) {                    // Não tiver sido removido, e foir igual a uma chave existe, atualiza.
                table[index].value = value;
                return;
            }
            index = (index + 1) % tamanho_maximo;                                           // for uma chave nova, calcula o proximo valor disponivel.
            colisions++;
        }
        table[index] = new Objeto<>(key, value);                                            // Adiciona o valor.
        size++;                                                                             // Aumenta o tamanho
    }

    public V get(K key) {
        if (key == null) return null;

        int index = IndexFromHash(key);
        int initialIndex = index;
        while (table[index] != null) {                                                    // Se tiver algo onde estou buscando
            if (!table[index].deleted && table[index].key.equals(key)) {                  // Caso não tenha sido removido, e a chave for a mesma
                return table[index].value;                                                // devolvo.
            }
            index = (index + 1) % tamanho_maximo;                                         // do contrario busco na proxima.
            if (index == initialIndex) break;                                             // paro se dei a volta
        }
        return null;                                                                      
    }

    public void remove(K key) {
        if (key == null) {
            return;
        }

        int index = IndexFromHash(key);
        int initialIndex = index;
        while (table[index] != null) {
            if (!table[index].deleted && table[index].key.equals(key)) {
                table[index].deleted = true;
                size--;
                return;
            }
            index = (index + 1) % tamanho_maximo;
            if (index == initialIndex) {
                break;
            }
        }
    }

    private void resize() {
        tamanho_maximo *= 2;
        Objeto<K, V>[] newTable = new Objeto[tamanho_maximo];               // cria uma nova tabela
        for (int i = 0; i < table.length; i++) {                            // pasa por todas as posições da antiga
            if (table[i] != null && !table[i].deleted) {
                int index = IndexFromHash(table[i].key);                    // calcula um novo indice pros valores relevantes (não deletados ou não nulos)
                while (newTable[index] != null) {                           // se já tiver algo nessa posição
                    index = (index + 1) % tamanho_maximo;                   // calcula a proxima valida
                }
                newTable[index] = table[i];                                 // joga o valor pra nova tabela
            }
        }
        table = newTable;                                                   // atualiza a referência da tabela anterior
    }

    public int size() {
        return size;
    }
    public int colisions(){
        return colisions;
    }
}
