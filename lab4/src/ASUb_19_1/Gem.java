package ASUb_19_1;

public class Gem extends Mineral{

    private int num;

    public Gem(){
        num = (int) (Math.random()*(6));
        description = "Блестит... Блестящий камень...";
    }

    @Override
    public void observe() {
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
