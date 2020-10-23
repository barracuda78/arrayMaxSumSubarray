package com.javarush.task.task28.task2808;


public class SubArray {
// Массив целых чисел, отрицательных и положительных, длинный.
// Надо найти участок с максимальной суммой (индексы начала и конца участка),
// и саму эту сумму максимальную.
// Вложенные циклы не использовать.

    public static void main(String[] args) {
        //   max summa:                    ////////////////////               - заштрихован участок максимальной суммы
        //    indexes:  0   1  2  3    4   5  6  7   8   9   10  11           - индексы массива для проверки
        int[] array = {-10, 5, 3, 2, -600, 6, 3, 1, -5, 100, 1, -20};  //     - массив для проверки

        int maximum = array[0];   //накапливаемая участками максимальная сумма - искомая сумма
        int summa = 0;            //промежуточная сумма, иногда сбрасываемая на ноль

        int startIndex = Integer.MIN_VALUE;      //индекс нчала максимального участка
        int endIndex = Integer.MIN_VALUE;        //индекс конца максимального участка

        int indexTemp = -1;

        for (int i = 0; i < array.length; ++i) {
            summa += array[i];

//            maximum = maximum > summa ? maximum : summa;
//            summa = summa > 0 ? summa : 0;

            if(maximum < summa){
                maximum = summa;
                endIndex = i;                  //индекс конца всегда равен i пока делакм "maximum = summa"
                startIndex = 1 + indexTemp;    //индекс начала - это временный индекс (там где сумма стала < 0) + 1
            }
            if(summa < 0){
                summa = 0;                    //хвост впереди участка массива, который меньше нуля, нам не интересен. обнуляем сумму.
                indexTemp = i;                //сброшеннй на "указатель" временный индекс - там где сумма стала < 0
            }
        }

        System.out.println("maximum = " + maximum);
        System.out.println("startIndex = " + startIndex);
        System.out.println("endIndex = " + endIndex);

//        результат вывода в консоль:
//        maximum = 106
//        startIndex = 5
//        endIndex = 10

    }
}