package Minerals;

public class Loose extends Mineral{

    public Loose() {
        super("Какая-то порода, выглядит хрупкой", "Loose");
    }

    public Loose(String name, String description, String type, boolean isObserve) {
        super(name, description, type, isObserve);
    }

    @Override
    public void changeDescription() {
        System.out.println("Рассыпалось...");
        Storage.removeMineral(this);
    }

    @Override
    public Mineral getNewMineral() {
        return new Loose();
    }
}
