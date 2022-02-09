package ru.vsu.cs.course1;

import ru.vsu.cs.course1.Planshet;
import ru.vsu.cs.util.JTableUtils;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.*;

public class Reader {
    public static String[][] readStringArray2FromFile(String fileName) {
        try {
            return toStringArray2(readLinesFromFile(fileName));
        }
        catch(FileNotFoundException e) {
            return null;
        }
    }
    public static String[][] toStringArray2(String[] lines) {
        String[][] arr2 = new String[lines.length][];
        for (int r = 0; r < lines.length; r++) {
            arr2[r] = toStringArray(lines[r]);
        }
//        for (int r = 0; r < 5; r++) {
//            arr2[r] = toStringArray(lines[r]);
//        }
        return arr2;
    }
    public static String[] toStringArray(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("([,;])+");
        List<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }

        // из List<Integer> можно получить Integer[]
        String[] arr = list.toArray(new String[0]);
        // Integer[] -> int[]
        return arr;
    }
    public static String[] readLinesFromFile(String fileName) throws FileNotFoundException {
        List<String> lines;
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
            lines = new ArrayList<>();
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
            // обязательно, чтобы закрыть открытый файл
        }
        return lines.toArray(new String[0]);
    }
    public static void writeArrayToFile(String fileName, String[][] arr2, String itemFormat)
            throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(toString(arr2, itemFormat));
        }
    }
    public static String toString(String[][] arr2, String itemFormat) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < arr2.length; r++) {
            if (r > 0) {
                sb.append(System.lineSeparator());
            }
            sb.append(toString(arr2[r], itemFormat));
        }
        return sb.toString();
    }
    public static String toString(String[] arr, String itemFormat) {
        if (arr == null) {
            return null;
        }
        if (itemFormat == null || itemFormat.length() == 0) {
            itemFormat = "%s";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(String.format(Locale.ROOT, itemFormat, arr[i]));
        }
        return sb.toString();
    }
    public static void writeArrayToFile(String fileName, String[][] arr2)
            throws FileNotFoundException {
        writeArrayToFile(fileName, arr2, null);
    }
    public static int readNumber(JTextField textFieldFirstMoney) {
        Scanner scanner = new Scanner(System.in);
        return (scanner.nextInt());
    }
    public static ArrayList<Planshet> readListFromJtable(JTable tableInput) {
        String[][] tmp = JTableUtils.readStringMatrixFromJTable(tableInput);
        ArrayList<Planshet> answer = new ArrayList<>();
        for (int i = 0; i < tmp.length; i++) {
            Planshet planshet = new Planshet(tmp[i][0], Integer.parseInt(tmp[i][1].trim()), Integer.parseInt(tmp[i][2].trim()), Integer.parseInt(tmp[i][3].trim()));
            answer.add(planshet);
        }
        return answer;
    }

//    public static String[][] fromAnswerToString2(ArrayList<Planshet> planshets, boolean[] take) {
//        String[][] strings = new String[planshets.size()][4];
//        for (int i = 0; i < planshets.size(); i++) {
//            strings[i][0] = planshets.get(i).name;
//            strings[i][1] = String.valueOf((planshets.get(i)).price1);
//            if (take[i]) {
//                strings[i][2] = "1";
//            } else {
//                strings[i][2] = "0";
//            }
//        }
//        return strings;
//    }

    public static String intToString(int param){
        String str = String.valueOf (param);
        return str;
    }

    public static String[][] answerToString21(ArrayList<Planshet> planshets) {
        String[][] strings = new String[planshets.size()][4];
        for (int i = 0; i < planshets.size(); i++) {
            strings[i][0] = planshets.get(i).name;
            strings[i][1] = intToString(planshets.get(i).price);
            strings[i][2] = intToString(planshets.get(i).rating);
            strings[i][3] = intToString(planshets.get(i).memory);
        }
        return strings;
    }


//    public static ArrayList<Planshet> readListFromConsol(String[][] tmp) {
//        ArrayList<Candy> answer = new ArrayList<>();
//        for (int i = 0; i < tmp.length; i++) {
//            Candy candy = new Candy(tmp[i][0], Integer.valueOf(tmp[i][1]));
//            answer.add(candy);
//        }
//        return answer;
//    }
}
