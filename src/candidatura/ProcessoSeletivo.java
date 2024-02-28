package src.candidatura;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        double baseSalary = 2000.0;
        String[] candidatesArray = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

        System.out.println("Processo seletivo");
        var candidates = new ArrayList<>(Arrays.asList(candidatesArray));
        var selectedCandidates = selectCandidates(candidates, baseSalary, 5);
        printSelected(selectedCandidates);
        callCandidates(selectedCandidates);
    }

    static List<String> selectCandidates(List<String> candidates, double baseSalary, int maximumSelected){
        System.out.println("Selecionando os candidatos... máximo -> " + maximumSelected);
        List<String> selectedCandidates = new ArrayList<>();

        for(String candidate : candidates){
            double intendedSalary = intendedValue();
            boolean isApproved = analizeCandidate(baseSalary, intendedSalary);

            if(isApproved){
                selectedCandidates.add(candidate);

                if(selectedCandidates.size() >= maximumSelected){
                    break;
                }
            }
        }

        return selectedCandidates;
    }

    static double intendedValue(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static boolean analizeCandidate(double baseSalary, double intendedSalary){
        return baseSalary >= intendedSalary;
//        if(baseSalary > intendedSalary){
//            System.out.println("LIGAR PARA  " + candidate);
//            return true;
//        }else if(baseSalary == intendedSalary){
//            System.out.println("LIGAR PARA " + candidate + "  COM CONTRA PROPOSTA");
//            return true;
//        }else{
//            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
//            return false;
//        }
    }

    static void printSelected(List<String> candidates){
        System.out.println("Imprimindo a lista de candidatos");

//        for(int i = 0; i < candidates.length; i++){
//            System.out.println("O candidato de n° " + (i + 1) + " é " + candidates[i]);
//        }

        for (String candidate : candidates){
            System.out.println("O candidato selecionado foi " + candidate);
        }
    }

    static void callCandidates(List<String> candidates){
        for(String candidate : candidates){
            makeContact(candidate, 3);
        }
    }

    static boolean answerCall(){
        return new Random().nextInt(3) == 1;
    }

    static void makeContact(String candidate, int maxTries){
        int tries = 0;
        System.out.println("Entrando em contato com " + candidate);

        while(tries < maxTries){

            if(answerCall()){
                System.out.println("Conseguimos contato com " + candidate + " na tentativa " + (tries+1));
                return;
            }

            tries++;
        }

        System.out.println("Não conseguimos contato com " + candidate + " número maximo de tentativas realizado");
    }
}