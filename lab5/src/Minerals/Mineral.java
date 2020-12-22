package Minerals;

public abstract class Mineral {
    public String description;
    public String nameMineral = "Неизвестная порода";
    public boolean isObserved = false;
    public String type;


    public Mineral(String description, String type){
        this.description = description;
        this.type = type;
    }

    public Mineral(String nameMineral, String description, String type, boolean isObserved){
        this(description,type);
        this.nameMineral = nameMineral;
        this.isObserved = isObserved;
    }

    protected Mineral() {
    }

    public void setDescription(String description){this.description = description;}
    public String getDescription(){return description;}

    public void observe() {
        this.isObserved = true;
        this.changeDescription();
    }

    public abstract void changeDescription();
    public abstract Mineral getNewMineral();
}
