package Minerals;

public class Stone extends Mineral {

    public Stone(){
        super("Это камень... Просто камень...","Stone");
    }

    public Stone(String name, String description, String type, boolean isObserve) {
        super(name, description, type, isObserve);
    }

    @Override
    public void changeDescription() {
        nameMineral = "Камень";
        description = "Это всё ещё камень...";
        System.out.println(description);
    }

    @Override
    public Mineral getNewMineral() {
        return new Stone();
    }
}
