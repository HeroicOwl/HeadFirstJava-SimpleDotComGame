//Игровой класс
//Создает объеткты DotCom
// получает пользовательский ввод
// играет пока все сайты не будут потоплены

// DotComBust создает и начинает игру -> DotCom
// DotComBust использует для ввода дааных т размещения сайтов -> GameHelper

import java.util.ArrayList;

public class DotComBust {

    //класс для приема пользовательского ввода
    private GameHelper helper = new GameHelper();

    //список оъектов дотком (изначально 3)
    private ArrayList<DotCom> dotComList = new ArrayList<>();

    //переменная для хранения числа ходов юзера
    private int numOfGuesses = 0;


    //метод предназначен для создания объектов дот ком и присврение им имен и адресов
    // + вывод юзеру кратких инструкций
    private void setUpGame() {

        //Создаем 3 объекта доком, даем им имена и добавляем в список
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("Ваша цель - потопить 3 'сайта'");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Попытайтесь их потопить за минимальное число ходов");


        //повторем с каждым объектом дот ком в списке
        for (DotCom dotComSet:dotComList) {
            //запрашиваем у вспомогательного объекта адрес сайта
            ArrayList<String> newLocation = helper.placeDotCom(3);
            //вызываем сеттер из объекта дот ком чтобы передать ему местоположение которое только что
            // получили от вспомогательного объекта
            dotComSet.setLocationCells(newLocation);

        }
    }

    //запрашивает у юзера ход и вызывает метод checkUserGuess() пока все объекты не выведены из игры
    private void startPlaying() {
        while (!dotComList.isEmpty()) {
            //получаем пользовательский ввод
            String userGuess = helper.getUserInput("Сделайте ход:");
            checkUserGuess(userGuess);
        }

        finishGame();
    }

    //метод просматривает все остальные объекты дотком и вызывает каждый объект дотком метода checkYourself
    private void checkUserGuess(String userGuess) {
        //инкрементируем число попыток которые сделал юзер
        numOfGuesses++;
        //По дефолту промах пока не получили обратное
        String result = "Мимо";

        for(DotCom dotComToTest:dotComList) {
            //проверяем ход юзера ищем попадание или потопление
            result = dotComToTest.checkYourself(userGuess);
            if(result.equals("Попал")) {
                // тк есть попадание выбираемся из цикла тк нет смысла проверять дальше
                break;
            }
            if (result.equals("Потопил")) {
                // тк потопили удаляем из списка и выходим из цикла
                dotComList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    //метод который выводит на экран сообщение об успехах юзера
    private void finishGame() {
        System.out.println("Все 'сайты' ушли ко дну!");
        if (numOfGuesses <= 18) {
            System.out.println("Это заняло у вас всего " + numOfGuesses + " попыток");

        }
        else {
            System.out.println("Это заняло у вас довольно много времени. " + numOfGuesses + " попыток");
        }
    }

    public static void main(String[] args) {
        //создаем игровой объект
        DotComBust game = new DotComBust();
        //подготоваливаем игру
        game.setUpGame();
        //начинаем главный игровой цикл
        game.startPlaying();

    }
}
