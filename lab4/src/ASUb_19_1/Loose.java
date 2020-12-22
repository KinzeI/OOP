package ASUb_19_1;

public class Loose extends Mineral{

    public Loose(){ description = "Какая-то порода, выглядит хрупкой"; }


    @Override
    public void observe() {
        System.out.println("Рассыпалось...");
        Storage.removeMineral(this);
    }

    @Override
    public Mineral getNewMineral() { return new Loose();
    }
}
