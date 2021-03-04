// класс для тестирования
public class SimpleDotComTestDrive {
    public static void main(String[] args) {
        // экземпляр класса SimpleDotCom
        SimpleDotCom dot = new SimpleDotCom();

        // массив для местоположения сайта, 3 последовательных числа из 7
        int[] location = {2,3,4};

        //вызываем сеттер
        dot.setLocationCells(location);

        //делаем ход от имени юзера
        String userGuess = "2";

        String result = dot.checkYourself(userGuess);

        String testResult = "Неудача";

        //если ход 2 вернет строку попал то все работает
        if (result.equals("Попал")) {
            testResult = "Пройден";
        }

        System.out.println(testResult);


    }

}
