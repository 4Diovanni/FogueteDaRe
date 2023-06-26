import java.util.Scanner;

public class Elevador {

    private String nome;
    private Scanner prompt;
    private String andarAtual;
    private int totalAndares;
    private String[] andaresAtendidos;
    private int capacidadeMaxima;
    private int pessoasPresentes;

    public Elevador(String nome, int totalAndares) {
        this.nome = nome;
        this.andarAtual = andarAtual;
        this.totalAndares = totalAndares;
        this.andaresAtendidos = new String[]{"ss", "t", "1", "2", "3", "5"};
        this.capacidadeMaxima = 30;
        this.pessoasPresentes = 0;
        this.prompt = new Scanner(System.in);
    }

    public void entra() {
        System.out.print("(Capacidade maxima é 30!) ");
        System.out.println("Digite o número de pessoas que deseja adicionar: ");
        this.pessoasPresentes = prompt.nextInt();

        if (pessoasPresentes == capacidadeMaxima) {
            System.out.println("Capacidade maxima atingida! ");

        }else if (pessoasPresentes > capacidadeMaxima || pessoasPresentes < 0){
            System.out.println("Limite de pessoas excedida ou numero de pessoas invalido! ");
            entra();
        }
        System.out.println("A quantidade de pessoas dentro é: " + pessoasPresentes);

    }

    public void sai() {
        System.out.println("A quantidade de pessoas presentes é " + pessoasPresentes + ", Digite o número de pessoas que deseja remover: ");
        int pessoasRemover = prompt.nextInt();

        if (pessoasRemover > pessoasPresentes || pessoasRemover < 0) {
            System.out.println("Número inválido. O número de pessoas a serem removidas é maior ou menor do que a quantidade presente.");
            sai();
        }else {
            pessoasPresentes -= pessoasRemover;
            System.out.println("A quantidade de pessoas dentro é: " + pessoasPresentes);
        }
    }


    public void sobe() {
        if (andarAtual.equals("5")) {
            System.out.println("Você já está no último andar. Não é possível subir mais.");
            return;
        }

        System.out.println("Digite o próximo andar para subir: ");
        String proximoAndar = prompt.next();

        while (!verificarAndarPermitido(proximoAndar) || proximoAndar.equals("ss")) {
            System.out.println("Andar inválido! Digite novamente.");
            System.out.println("Você está no andar " + andarAtual + ". Digite o próximo andar para subir: ");
            proximoAndar = prompt.next();
        }

        System.out.println("Subindo para o andar " + proximoAndar);
        andarAtual = proximoAndar;
    }

    public void desce() {
        if (andarAtual.equals("ss")) {
            System.out.println("Você já está no subsolo. Não é possível descer mais.");
            return;
        }

        System.out.println("Digite o próximo andar para descer: ");
        String proximoAndar = prompt.next();

        while (!verificarAndarPermitido(proximoAndar) || proximoAndar.equals("5")) {
            System.out.println("Andar inválido! Digite novamente.");
            System.out.println("Você está no andar " + andarAtual + ". Digite o próximo andar para descer: ");
            proximoAndar = prompt.next();
        }

        System.out.println("Descendo para o andar " + proximoAndar);
        andarAtual = proximoAndar;
    }

    private boolean verificarAndarPermitido(String andar) {
        for (String andarPermitido : andaresAtendidos) {
            if (andarPermitido.equalsIgnoreCase(andar)) {
                return true;
            }
        }
        return false;

    }

    public String getNome() {
        return nome;
    }
}
//    andarAtual: representa o andar em que o elevador está no momento (o térreo é representado pelo valor 0).
//    totalAndares: indica o número total de andares atendidos pelo elevador.
//    andaresAtendidos: contém os andares em que o elevador pode parar.
//    capacidadeMaxima: a capacidade máxima de pessoas que o elevador pode suportar.
//    pessoasPresentes: o número de pessoas atualmente presentes no elevador.

//    entra(): adiciona uma pessoa ao elevador, desde que haja espaço disponível.
//    sai(): remove uma pessoa do elevador, desde que haja alguém dentro dele.
//    sobe(): faz o elevador subir andares, caso não esteja no último andar atendido.
//    desce(): faz o elevador descer andares, caso não esteja no térreo ou subsolo.
