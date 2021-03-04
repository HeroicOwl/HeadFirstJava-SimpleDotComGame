public class SimpleDotComGame {
    public static void main(String[] args) {
        //переменная для хранения числа ходов юзера
        int numOfGuesses = 0;

        //класс для приема пользовательского ввода
        GameHelper helper = new GameHelper();

        // создаем объект сайт
        SimpleDotCom theDotCom = new SimpleDotCom();

        //генерация случайного числа для 1ой ячейки
        // случайное число от 0 до 4
        // приводим к инту тк рандом возвращает дабл
        // рандом возвращает число от 0 до 1 (не включительно) так что формула Math.random() * 5 вернет 0 - 4.999
        int randomNum = (int)(Math.random() * 5);

        //формируем массив ячеек
        int[] locations = {randomNum, randomNum+1, randomNum+2};

         
        //передаем сайту местоположение его ячеек (массив)
        theDotCom.setLocationCells(locations);

        //Переменная для проверки в цикле не закончилась ли игра
        boolean isAlive = true;

        while (isAlive == true) {

            //получаем строку вводимую юзером
            String guess = helper.getUserInput("Введите число:");

            //Проверяем получанные данные
            String result = theDotCom.checkYourself(guess);

            //Инкрементируем число попыток
            numOfGuesses++;

            //если сайт потоплен
            if (result.equals("Потопил")){
                isAlive = false;
                System.out.println("Вам потребовалось " + numOfGuesses + " попыток(и)");
            }
        }
    }
}
