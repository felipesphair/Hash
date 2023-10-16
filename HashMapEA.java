public class HashMapEA<K, V> implements HashMap<K, V> {
    private final int Tamanho_Inicial = 16;
    private final double Limite = 0.75;

    private int size;
    private int colisions;
    private int tamanho_maximo;
    private ObjetoEA<K, V>[] table;

    public HashMapEA() {
        this.tamanho_maximo = Tamanho_Inicial;
        this.size = 0;
        this.table = new ObjetoEA[tamanho_maximo];
    }

    private int IndexFromHash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % tamanho_maximo;
    }

    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("A chave não pode ser Nula.");
        if (value == null) throw new IllegalArgumentException("O valor não pode ser Nulo.");
    
        if (size >= Limite * tamanho_maximo) resize();
        
        int index = IndexFromHash(key);
        int initialIndex = index;
        while (table[index] != null) {                                                  
            if (!table[index].deleted && table[index].key.equals(key)) {                    
                table[index].value = value;
                return;
            }
            index = (index + 1) % tamanho_maximo;                                           
            colisions++;
        }
        table[index] = new ObjetoEA<>(key, value);                                            
        size++;                                                                             
    }
    
    public V get(K key) {
        if (key == null) return null;
    
        try {
            int index = IndexFromHash(key);
            int initialIndex = index;
            while (table[index] != null) {                                                    
                if (!table[index].deleted && table[index].key.equals(key)) {                  
                    return table[index].value;                                                
                }
                index = (index + 1) % tamanho_maximo;                                         
                if (index == initialIndex) break;                                             
            }
    
            throw new IllegalArgumentException("A chave especificada não foi encontrada no HashMap.");
        } catch (IllegalArgumentException e) {
            System.out.println("Aviso: Chave não encontrada");
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
        ObjetoEA<K, V>[] newTable = new ObjetoEA[tamanho_maximo];              
        for (int i = 0; i < table.length; i++) {                            
            if (table[i] != null && !table[i].deleted) {
                int index = IndexFromHash(table[i].key);                    
                while (newTable[index] != null) {                           
                    index = (index + 1) % tamanho_maximo;                   
                }
                newTable[index] = table[i];                                 
            }
        }
        table = newTable;                                                   
    }

    public int size() {
        return size;
    }
    
    public int colisions(){
        return colisions;
    }

    public void debugPrint() {
        for (int i = 0; i < tamanho_maximo; i++) {
            if (table[i] != null) {
                System.out.println("Índice " + i + ": (" + table[i].key + ", " + table[i].value + ")");
            }
        }
    }
    
}
