package ru.vsu.cs.course1;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Task {
//. Прайс-лист содержит следующую информацию о планшетах: название модели, объем
//    памяти, рейтинг модели среди пользователей (цифра от 1 до 5), стоимость. У вас есть N
//    денег, вам необходимо купить самый хороший планшет, на который вам хватит денег.
//    Для вас приоритетным является объем памяти, в случае одинакового объема – рейтинг
//    модели. Если подходящих моделей будет несколько, вы выберете Samsung или Asus
//            (присутствует в названии модели), а затем все остальные. Если по этим критериям вам
//    подходят несколько моделей – выбирайте любой.

//            22. Входные данные соответствуют предыдущей задачи, однако теперь вам надо купить K
//    различных самых дешевых планшета с объемом памяти не ниже M и рейтингом не ниже
//    R (призы победителям олимпиады). Какие планшет вы выберете и сколько денег вы
//    потратите?

    public static List<Planshet> planshetSelection(int minRating, int minMemory, int money, List<Planshet> planshets) {
        List<Planshet> selected = new ArrayList<>();
        planshets.sort(Comparator.comparing(Planshet::getPrice));
        int amount = 0;

        for (Planshet planshet : planshets) {
            if (planshet.getMemory() >= minMemory && planshet.getRating() >= minRating && amount < money) {
                amount += planshet.getPrice();
                if(amount > money){
                    break;
                }
                else {
                    selected.add(planshet);
                }
            }
        }
        return selected;
    }


    public static List<Planshet> arrToList(Planshet[] arr){
        return new ArrayList<>(Arrays.asList(arr));
    }



//     public static ArrayList<Object> createNewList(ArrayList<Object> list, int k, int m, int r) {
//         ArrayList<Integer> result = new ArrayList<>();
//
//     }

    public static int amount(int minRating, int minMemory, int money, ArrayList<Planshet> planshets){
        List<Planshet> selected = new ArrayList<>();
        planshets.sort(Comparator.comparing(Planshet::getPrice));
        int amount = 0;

        for (Planshet planshet : planshets) {
            if (planshet.getMemory() >= minMemory && planshet.getRating() >= minRating && amount < money) {
                amount += planshet.getPrice();
                if(amount > money){
                    amount -= planshet.getPrice();
                    break;
                }
                else {
                    selected.add(planshet);
                }
            }
        }
        return amount;
    }

     public static ArrayList<Integer> arrToList(int[] arr){
         ArrayList<Integer> list = new ArrayList<>();
         for (int cur : arr){
            list.add(cur);
        }
        return list;
    }
    public static int[] listToArr(ArrayList<Integer> list){
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
