package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        List<Sign> signList = new ArrayList<>();
        signList.add(new Sign(0,"Розгон машини до 100 км/год до 8 сек"));
        signList.add(new Sign(1,"Вага машини більше 3 тон"));
        signList.add(new Sign(2,"Об'єм двигуна більше 3л"));
        signList.add(new Sign(3,"Кількість посадкових місць більше 2"));
        signList.add(new Sign(4,"максимальна швидкість більше 250 км/год"));
        signList.add(new Sign(5,"Може їздити по болоту"));

        List<Rule> ruleList = new ArrayList<>();
        ruleList.add(new Rule("Volkswagen Passat B8", Arrays.asList(0,3)));
        ruleList.add(new Rule("Koenigsegg Agera R", Arrays.asList(0,2,4)));
        ruleList.add(new Rule("MAN Tgx ", Arrays.asList(1,2,3)));
        ruleList.add(new Rule("Nissan Navara", Arrays.asList(2,3,5)));

        List<Integer> userAnswer = new ArrayList<>();

        for (Sign sign: signList) {
            askQuestion(sign,userAnswer);
        }
        boolean find = false;
        for (Rule rule:ruleList){
            if(compare(rule.getListSingId(),userAnswer)){
                System.out.println("Ваша машина: "+rule.getRule());
                find=true;
                break;
            }
        }
        if (!find){
            System.out.println("Я не можу знайти машину по данному опису");
        }

    }

    private static boolean compare(List<Integer> list1,List<Integer> list2){
        for (Integer i : list1) {
            if(!list2.contains(i)) {
                return false;
            }
        }
        return true;
    }

    private static void askQuestion(Sign sign,List<Integer> userAnswer){
        System.out.println(sign.getSign()+"?(yes/no)");
        String answer = new Scanner(System.in).nextLine();
        if(!answer.equals("yes")&&!answer.equals("no")){
            System.out.println("Ви повинні вводити yes або no");
            askQuestion(sign,userAnswer);
        }
        if(answer.equals("yes")){
            userAnswer.add(sign.getId());
        }
    }
}
