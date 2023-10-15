public class ObjetoEA<K, V> {
    K key;
    V value;
    boolean deleted;

    public ObjetoEA(K key, V value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }
}