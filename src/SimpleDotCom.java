public class SimpleDotCom {
    //массив для хранения адреса ячеек
    int[] locationCells;
    //число попаданий
    int numOfHits = 0;

    // сеттер принимает массив который хранит адрес 3х ячеек
    void setLocationCells(int locs[]) {
        locationCells = locs;

    }

    //метод принимает ход юзера, проверяет его и возвращает рез-т Попал/Мимо/Потопил
    String checkYourself(String stringGuess) {
        //преобразуем ход в число
        int guess = Integer.parseInt(stringGuess);

        //Переменная для хранения рез-та, который будем возвращать
        // по умолчанию промах
        String result = "Мимо";

        //цикл foreach пробегаемся по всему массиву и проверяем попадание
        for (int cell: locationCells) {
            //проверяем равен ли ход юзера значению ячейки
            if (guess == cell){
                //если да меняем результат на Попал
                result = "Попал";
                //засчитываем попадание (инкрементируем число попаданий)
                //постинкрементный оператор
                // оператор ++ добавляет единицу к значение переменной те это инкремент
                numOfHits++;
                //завершаем преждевременно цикл, тк дальше пробегаться смысла нет
                break;
            }
        }

        //проверяем число попаданий
        // если число равно длине массива то считаем что потопили
        if (numOfHits == locationCells.length) {
            result = "Потопил";
        }

        System.out.println(result);
        return result;
    }


}