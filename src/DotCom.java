//Объекты DotCom
//Знают имена и местоположения сайтов
// проверяют пользовательский ход на попадание

import java.util.ArrayList;
public class DotCom {
    //список для хранения адреса ячеек
    private ArrayList<String> locationCells;
    // имя сайта
    private String name;
    //число попаданий
    //int numOfHits = 0;

    // сеттер принимает массив который хранит адрес 3х ячеек
    // обновляет местоположение сайта (случайный адрес предостовляемый методом placeDotCom() класса GameHelper)
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;

    }

    public void setName(String n){
        name = n;
    }
    //метод принимает ход юзера, проверяет его и возвращает рез-т Попал/Мимо/Потопил
    public String checkYourself(String userInput) {
        //преобразуем ход в число
        //int guess = Integer.parseInt(userInput);

        //Переменная для хранения рез-та, который будем возвращать
        // по умолчанию промах
        String result = "Мимо";

        //проверяем содержится ли переданная юзером ячейка в списке
        // если ее в списке нет вернется -1
        int index = locationCells.indexOf(userInput);

        //если индекс больше или равен 0 то загаданная ячейка есть в списке
        if (index >= 0) {
            //удаляем ячейку
            locationCells.remove(index);

            //если список пуст
            if (locationCells.isEmpty()) {
                // то считаем сайт потопленным
                result = "Потопил";
                System.out.println("Вы потопили " + name + " :(");
            }
            else {
                // если список еще не пуст засчитываем попадание
                result = "Попал";
            }
        }
        // System.out.println(result);
        return result;
    }


}
