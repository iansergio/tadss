package exercises.ex06;

/**
 * Algoritmo Produtor-Consumidor
 */

public class Cozinha {
    private static PilhaPratos sujos;
    private static PilhaPratos escorredor;
    private static PilhaPratos limpos;

    public static void main(String[] args) throws Exception {
        // criando os pratos pra lavar
        sujos = new PilhaPratos(100);
        escorredor = new PilhaPratos(10);
        limpos = new PilhaPratos(100);
        for (int i = 1; i <= 100; i++) {
            sujos.adicionaPrato(new Prato(i, Estado.Sujo));
        }
        System.out.println(sujos);
        System.out.println(limpos);
        Lavador lavador = new Lavador(sujos, escorredor);
        Enxugador enxugador = new Enxugador(limpos, escorredor, sujos);
        Enxugador enxugador2 = new Enxugador(limpos, escorredor, sujos);

        Thread l1 = Thread.ofPlatform().name("Lavador").start(lavador);
        Thread e1 = Thread.ofPlatform().name("Enxugador").start(enxugador);
        Thread e2 = Thread.ofPlatform().name("Enxugador 2").start(enxugador2);

        l1.join();
        e1.join();
        e2.join();
        System.out.println(sujos);
        System.out.println(limpos);
    }
}
