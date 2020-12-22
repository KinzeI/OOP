package lab3;

public class Arrays{

    private String[] arrayString;


    public String getArrayString(){
        StringBuilder builder = new StringBuilder();
        for (String elemArrayString : arrayString) {
            builder.append(elemArrayString).append(' ');
        }
        return builder.toString();
    }

    public void setArrayString(String inputString){
        String[] array;
        array = inputString.split(" ");
        arrayString = array;
    }



    public void compareArray(String[] arrayString, int num){
        num = num>0 ? num : 1;
        for(int i=0; i<arrayString.length-1; i++){
            for(int j=i+1;j<arrayString.length;j++) {

                char a = Strings.searchChar(arrayString[i], num);

                char b = Strings.searchChar(arrayString[j], num);
                if (a > b) {
                    String temp = arrayString[i];
                    arrayString[i] = arrayString[j];
                    arrayString[j] = temp;
                }
            }
        }
        this.arrayString = arrayString;
    }

    public String deleteArray(int numElement){
        numElement = numElement>0 ? numElement : arrayString.length+1;
        StringBuilder builder = new StringBuilder();
        for (int i=0; i< arrayString.length; i++){
            if ((i+1)%numElement!=0){
                builder.append(arrayString[i]).append(" ");
            }
        }
        return builder.toString();
    }
}
