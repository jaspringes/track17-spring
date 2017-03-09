package track.lessons.lesson1;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringJoiner;

/**
 * Задание 1: Реализовать два метода
 *
 * Формат файла: текстовый, на каждой его строке есть (или/или)
 * - целое число (int)
 * - текстовая строка
 * - пустая строка (пробелы)
 *
 *
 * Пример файла - words.txt в корне проекта
 *
 * ******************************************************************************************
 *  Пожалуйста, не меняйте сигнатуры методов! (название, аргументы, возвращаемое значение)
 *
 *  Можно дописывать новый код - вспомогательные методы, конструкторы, поля
 *
 * ******************************************************************************************
 *
 */
public class CountWords {

    /**
     * Метод на вход принимает объект File, изначально сумма = 0
     * Нужно пройти по всем строкам файла, и если в строке стоит целое число,
     * то надо добавить это число к сумме
     * @param file - файл с данными
     * @return - целое число - сумма всех чисел из файла
     */
    public long countNumbers(File file) throws Exception {
        long answer = 0;
        try (BufferedReader inputFile = new BufferedReader(new FileReader(file))) {
            String part;
            while  ((part = inputFile.readLine()) != null ) {
                try {
                    answer += Integer.parseInt(part);
                } catch (NumberFormatException e) {
                  // ignored
                }
            }
        }
        return answer;
    }

    /**
     * Метод на вход принимает объект File, изначально результат= ""
     * Нужно пройти по всем строкам файла, и если в строка не пустая и не число
     * то надо присоединить ее к результату через пробел
     * @param file - файл с данными
     * @return - результирующая строка
     */
    public StringJoiner concatWords(File file) throws Exception {
        StringJoiner answer = new StringJoiner(" ");
        try ( BufferedReader inputFile = new BufferedReader(new FileReader(file)) ) {
            String part;
            while  ((part = inputFile.readLine()) != null ) {
                if (!part.equals("")) {
                    try {
                        int value = Integer.parseInt(part);
                    } catch (NumberFormatException e) {
                        answer.add(part);
                    }
                }
            }
        }
        return answer;
    }

}
