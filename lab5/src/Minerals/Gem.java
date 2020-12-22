package Minerals;

public class Gem extends Mineral {

    private int num;

    public Gem(){
        super("Блестит... Блестящий камень...", "Gem");
        num = (int) (Math.random()*(6));
    }

    public Gem(String name, String description, String type, boolean isObserve) {
        super(name, description, type, isObserve);
    }


    @Override
    public void changeDescription() {
        switch (num){
            case 0:
                nameMineral = "Топаз";
                description = "Видимо это... Топаз";
                break;
            case 1:
                nameMineral = "Изумруд";
                description = "Видимо это... Изумруд";
                break;
            case 2:
                nameMineral = "Рубин";
                description = "Видимо это... Рубин";
                break;
            case 3:
                nameMineral = "Аметист";
                description = "Видимо это... Аметист";
                break;
            case 4:
                nameMineral = "Опал";
                description = "Видимо это... Опал";
                break;
            case 5:
                nameMineral = "Алмаз";
                description = "Видимо это... Алмаз";
                break;
            default:
                System.out.println("Тут ничего нет");
                break;
        }
        System.out.println(description);
    }

    @Override
    public Mineral getNewMineral() {
        return new Gem();
    }
}
