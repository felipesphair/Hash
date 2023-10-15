import java.util.LinkedList;

public class HashMapList<K, V> implements HashMap<K, V> {
    private final int Tamanho_Inicial = 16;
    private final double Limite = 0.75;

    private int size;
    private int colisions;
    private int tamanho_maximo;
    private LinkedList<Objeto<K, V>>[] table;

    public HashMapList() {
        this.tamanho_maximo = Tamanho_Inicial;

        this.table = new LinkedList[tamanho_maximo];
        
        for (int i = 0; i < tamanho_maximo; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int IndexFromHash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % tamanho_maximo;
    }

    private LinkedList<Objeto<K, V>> BucketFromKey(K key){
        int index = IndexFromHash(key);
        return table[index];
    }

    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("A chave não pode ser Nula.");
        if (value == null) throw new IllegalArgumentException("O valor não pode ser Nulo.");
    
        if (size >= Limite * tamanho_maximo) resize();
        
        LinkedList<Objeto<K, V>> espaco_de_colisoes = BucketFromKey(key);
        for (Objeto<K, V> objeto : espaco_de_colisoes) {
            if (objeto.key.equals(key)) {
                objeto.value = value;
                return;
            }
        }
        if (espaco_de_colisoes.size() > 0) colisions++;
        espaco_de_colisoes.add(new Objeto<>(key, value));
        size++;                                         
    }
    
    public V get(K key) {
        if (key == null) return null;
    
        try {
            LinkedList<Objeto<K, V>> espaco_de_colisoes = BucketFromKey(key);
            for (Objeto<K, V> objeto : espaco_de_colisoes) {
                if (objeto.key.equals(key)) { 
                    return objeto.value;
                }
            }
    
            throw new IllegalArgumentException("A chave especificada não foi encontrada no HashMap.");
        } catch (IllegalArgumentException e) {
            System.out.println("Aviso: Chave não encontrada");
        }
    
        return null;
    }

    public void remove(K key) {
        if (key == null) return;

        LinkedList<Objeto<K, V>> espaco_de_colisoes = BucketFromKey(key);

        for (Objeto<K, V> objeto : espaco_de_colisoes) {
            if (objeto.key.equals(key)) {
                espaco_de_colisoes.remove(objeto);
                size--;
                return;
            }
        }
    }

    private void resize() {
        tamanho_maximo *= 2;
        LinkedList<Objeto<K, V>>[] newTable = new LinkedList[tamanho_maximo];

        for (int i = 0; i < tamanho_maximo; i++) {
            newTable[i] = new LinkedList<>();
        }

        for (LinkedList<Objeto<K, V>> espaco_de_colisoes : table) {
            for (Objeto<K, V> objeto : espaco_de_colisoes) {
                int index = IndexFromHash(objeto.key);
                newTable[index].add(objeto);
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
}
