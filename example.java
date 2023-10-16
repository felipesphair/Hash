

public class example {

  public static void simpleTest(HashMap<String,Integer> HM1, HashMap<Integer, String> HM2 ){
      // Inserções para HM1
      HM1.put("Maria", 700);
      HM1.put("Carlos", 800);
      HM1.put("Ana", 900);
      HM1.put("Pedro", 1000);
      HM1.put("Luiza", 1100);
      HM1.put("Mariana", 1200);
      HM1.put("José", 1300);
      HM1.put("Rafael", 1400);
      HM1.put("Lara", 1500);
      HM1.put("Fernando", 1600);
      HM1.put("Eduarda", 1700);
      HM1.put("Vitor", 1800);
      HM1.put("Amanda", 1900);
      HM1.put("Lucas", 2000);
      HM1.put("Carolina", 2100);
      HM1.put("Ricardo", 2200);
      HM1.put("Camila", 2300);
      HM1.put("Rodrigo", 2400);
      HM1.put("Isabella", 2500);
      HM1.put("Daniel", 2600);
      HM1.put("Laura", 2700);
      HM1.put("Paulo", 2800);
      HM1.put("Letícia", 2900);
      HM1.put("Marcos", 3000);
      HM1.put("Julia", 3100);
      HM1.put("Thiago", 3200);
      HM1.put("Beatriz", 3300);
      HM1.put("Carlos", 3400);
      HM1.put("Mariana", 3500);
      HM1.put("José", 3600);
      HM1.put("Henrycke", 100);
      HM1.put("Felipe", 200);
      HM1.put("João", 300);
      HM1.put("Daneil", 2600);
      HM1.put("Dnaeil", 2600);


      HM2.put(1, "João");
      HM2.put(2, "Felipe");
      HM2.put(3, "João");
      HM2.put(7, "Maria");
      HM2.put(8, "Carlos");
      HM2.put(9, "Ana");
      HM2.put(10, "Pedro");
      HM2.put(11, "Luiza");
      HM2.put(12, "Mariana");
      HM2.put(13, "José");
      HM2.put(14, "Rafael");
      HM2.put(15, "Lara");
      HM2.put(16, "Fernando");
      HM2.put(17, "Eduarda");
      HM2.put(18, "Vitor");
      HM2.put(19, "Amanda");
      HM2.put(20, "Lucas");
      HM2.put(21, "Carolina");
      HM2.put(22, "Ricardo");
      HM2.put(23, "Camila");
      HM2.put(24, "Rodrigo");
      HM2.put(25, "Isabella");
      HM2.put(26, "Daniel");
      HM2.put(27, "Laura");
      HM2.put(28, "Paulo");
      HM2.put(29, "Letícia");
      HM2.put(30, "Marcos");
      HM2.put(31, "Julia");
      HM2.put(32, "Thiago");
      HM2.put(33, "Beatriz");
      HM2.put(34, "Carlos");
      HM2.put(35, "Mariana");
      HM2.put(36, "José");
      HM2.put(38, "José");
      HM2.put(39, "João");
      HM2.put(1, "João");
      HM2.put(17, "Eduarda");
      HM2.put(33, "Beatriz");

      System.out.print("HashMap1 - Chave1: Henrycke, Valor: " + HM1.get("Henrycke") + " | ");
      System.out.println("HashMap2 - Chave1: 1, Valor: " + HM2.get(1));

      System.out.print("HashMap1 - Chave2: Felipe, Valor: " + HM1.get("Felipe") + " | ");
      System.out.println("HashMap2 - Chave2: 2, Valor: " + HM2.get(2));

      System.out.print("HashMap1 - Chave3: João, Valor: " + HM1.get("João") + " | ");
      System.out.println("HashMap2 - Chave3: 3, Valor: " + HM2.get(3));


      


      System.out.print( "HashMap1 - Tamanho: " + HM1.size()  + " | ");
      System.out.println("HashMap2 - Tamanho: " + HM2.size());

      System.out.println("Removendo alguns itens: ");
      HM1.remove("Henrycke");
      HM2.remove(1);
      
      HM1.remove("Felipe");
      HM2.remove(2);

      HM1.remove("João");
      HM2.remove(3);

      System.out.print( "HashMap1 - Tamanho: " + HM1.size()  + " | ");
      System.out.println("HashMap2 - Tamanho: " + HM2.size());

      
  }

  public static void performanceTestSearch(HashMap<String, Integer> hashMap, int qtdElementos) {
    // Inserir elementos
    for (int i = 0; i < qtdElementos; i++) {
        hashMap.put("Valor " + i, i);
    }

    // Medir o tempo para buscar todos os elementos
    long startTime = System.currentTimeMillis();

    for (int i = 0; i < qtdElementos; i++) {
       Integer valor = hashMap.get("Valor " + i);
    }

    long endTime = System.currentTimeMillis();
    long totalTime = endTime - startTime;

    System.out.print("Tempo total para buscar " + qtdElementos + " elementos: " + totalTime + " ms; ");
    System.out.println("Colisoes: " + hashMap.colisions());
}

}