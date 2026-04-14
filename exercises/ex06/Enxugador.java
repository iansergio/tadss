package exercises.ex06;

public class Enxugador implements Runnable {
    private PilhaPratos escorredor;
    private PilhaPratos limpos;
    private PilhaPratos sujos;

    public Enxugador(PilhaPratos limpos, PilhaPratos escorredor, PilhaPratos sujos) {
        this.escorredor = escorredor;
        this.limpos = limpos;
        this.sujos = sujos;
    }
    
    @Override
    public void run() {
        while (limpos.temEspaco() && sujos.temPrato()) {
            Prato prato = escorredor.retiraPrato();
            System.out.println("Enxugando prato " + prato);
            prato.setEstado(Estado.Seco);
            limpos.adicionaPrato(prato);
        }
    }
}
