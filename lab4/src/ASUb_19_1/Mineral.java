package ASUb_19_1;

public abstract class Mineral {
    protected String description;
    protected String nameMineral = "Неизвестная порода";


    public Mineral(String description){
        this.description = description;
    }

    protected Mineral() {
    }

    public void setDescription(String description){this.description = description;}
    public String getDescription(){return description;}

    public abstract void observe();
    public abstract Mineral getNewMineral();
}
