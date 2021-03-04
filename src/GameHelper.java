import  java.io.*;
//вспомогательный класс для получения пользовательского ввода
public class GameHelper {
    public String getUserInput(String prompt){
        String inputLine = null;
        System.out.println(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader((System.in)));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return  null;

        } catch (IOException e) {
            System.out.println("IOException: "+ e);
        }
        return inputLine;
    }

}
