import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        HashMapList<String, Integer> HML1 = new HashMapList<>();
        HashMapList<Integer, String> HML2 = new HashMapList<>();

        HashMapEA<String, Integer> HME1 = new HashMapEA<>();
        HashMapEA<Integer, String> HME2 = new HashMapEA<>();

        System.out.println("HashMapList:");

        example.simpleTest(HML1, HML2);

        System.out.println(" ");
        System.out.println("HashMapLinst: ");
        HML1.debugPrint();

        System.out.println(" ");

        System.out.println("HashMapEA:");

        example.simpleTest(HME1, HME2);
        System.out.println(" ");
        System.out.println("HashMapEA: ");
        HME1.debugPrint();

        final int qtdElementos = 999999;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" ");

            System.out.println("Teste de performance");
            System.out.println("0 - Colisão por Lista encadeada ||| 1- Colisão por Encadeamento Aberto");
            System.out.println("ESCOLHA entre 0 e 1 ou 2 para finalizar: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    example.performanceTestSearch(new HashMapEA<String, Integer>(), qtdElementos);
                    break;
                case 0:
                    example.performanceTestSearch(new HashMapList<String, Integer>(), qtdElementos);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha entre 0 e 2.");

            }
        }
    }
}
