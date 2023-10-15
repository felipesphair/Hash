import java.util.Scanner;

public class example {

  public static void simpleTest(HashMap<String,Integer> HM1, HashMap<Integer, String> HM2 ){
      HM1.put("Henrycke", 100);
      HM1.put("Felipe", 200);
      HM1.put("João", 300);

      HM2.put(1, "João");
      HM2.put(2, "Felipe");
      HM2.put(3, "João");

      System.out.print(  "HashMap1 - Chave1: " + HM1.get("Henrycke") + " | ");
      System.out.println("HashMap2 - Chave1: " + HM2.get(1));

      System.out.print(  "HashMap1 - Chave2: " + HM1.get("Felipe") + " | ");
      System.out.println("HashMap2 - Chave2: " + HM2.get(2));

      System.out.print(  "HashMap1 - Chave3: " + HM1.get("João") + " | ");
      System.out.println("HashMap2 - Chave3: " + HM2.get(3));
      

      System.out.print(  "HashMap1 - Tamanho: " + HM1.size()  + " | ");
      System.out.println("HashMap2 - Tamanho: " + HM2.size());


      HM1.remove("Henrycke");
      HM2.remove(1);
      
      HM1.remove("Felipe");
      HM2.remove(2);

      HM1.remove("João");
      HM2.remove(3);

      System.out.print(  "HashMap1 - Tamanho: " + HM1.size()  + " | ");
      System.out.println("HashMap2 - Tamanho: " + HM2.size());
  }

  public static void performanceTest(HashMap<String, Integer> hashMap, int qtdElementos) {
    // Inserir elementos
    for (int i = 0; i < qtdElementos; i++) {
        hashMap.put("Valor " + i, i);
    }

    // Medir o tempo para buscar todos os elementos
    long startTime = System.currentTimeMillis();

    for (int i = 0; i < qtdElementos; i++) {
       hashMap.remove(String.format("Valor %d", i));
    }

    long endTime = System.currentTimeMillis();
    long totalTime = endTime - startTime;

    System.out.println("Tempo total para buscar " + qtdElementos + " elementos: " + totalTime + " ms");
    System.out.println("Colisoes: " + hashMap.colisions());
}

  public static void main(String[] args) {
    HashMapList<String, Integer> HML1 = new HashMapList<>();
    HashMapList<Integer, String> HML2 = new HashMapList<>();

    HashMapEA<String, Integer> HME1 = new HashMapEA<>();
    HashMapEA<Integer, String> HME2 = new HashMapEA<>();

    simpleTest(HML1, HML2);
    simpleTest(HME1, HME2);

    final int qtdElementos = 999999;

    Scanner scanner = new Scanner(System.in);
    System.out.println("Teste de performance");
    System.out.println("0 - Colisão por Lista encadeada ||| 1- Colisão por Encadeamento Aberto");
    int option = scanner.nextInt();

    switch (option) {
      case 1:
        performanceTest(new HashMapEA<String, Integer>(), qtdElementos);
        break;
      case 0:
        performanceTest(new HashMapList<String, Integer>(), qtdElementos);
        break;
    }
}

}