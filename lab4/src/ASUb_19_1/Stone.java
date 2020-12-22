package ASUb_19_1;

public class Stone extends Mineral{

    public Stone(){
        description = "Это камень... Просто камень...";
    }

    @Override
    public void observe() {
        nameMineral = "Камень";
        description = "Это всё ещё камень...";
        System.out.println(description);
    }

    @Override
    public Mineral getNewMineral() {
        return new Stone();
    }
}
