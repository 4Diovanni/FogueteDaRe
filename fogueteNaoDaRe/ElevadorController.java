import java.util.Scanner;

public class ElevadorController {
    private Scanner scanner;
    private Elevador elevador;

    public ElevadorController(String andarAtual, int totalAndares) {
        scanner = new Scanner(System.in);
        elevador = new Elevador(andarAtual, totalAndares);
    }

    public void iniciarControle() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Bem-vindo(a) ao elevador " + elevador.getNome());
            System.out.println("Escolha uma opção:");
            System.out.println("1. Entrar no elevador");
            System.out.println("2. Sair do elevador");
            System.out.println("3. Subir de andar");
            System.out.println("4. Descer de andar");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    elevador.entra();
                    break;
                case 2:
                    elevador.sai();
                    break;
                case 3:
                    elevador.sobe();
                    break;
                case 4:
                    elevador.desce();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente.");
                    break;
            }
        }
    }
}
