package secretDecoder;

import org.graalvm.compiler.loop.MathUtil;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class SecretDecoder {

    private HashMap<String, Character> decoderTable;

    SecretDecoder(){

        decoderTable = new HashMap();
        for(int i = 1; i <= 26; i++ ){
            decoderTable.put(String.valueOf(i), (char) (64+i));
        }
    }

    public int possibleSolutions(long secretCode) {
        return determineSolutions(convertIntegerToArrayOfDigits(String.valueOf(secretCode).toCharArray()));
    }

    private int[] convertIntegerToArrayOfDigits(char[] arrayOfCharDigits){
        int[] digits = new int[arrayOfCharDigits.length];
        for(int i = 0; i < arrayOfCharDigits.length; i++)
            digits[i] = Character.getNumericValue(arrayOfCharDigits[i]);
        return digits;
    }

    private int determineSolutions(int[] digits) {

        int numberOfSolutions = 0;
        int samplesWithOverlap = 0;
        int samplesWithoutOverlap = 0;
        int select = 0;
        long accumulator = 0;

        //single digit pass
        for(int i = 0; i < digits.length; i++){
            if(digits[i] == 0)
                break;
            if(i == digits.length-1)
                numberOfSolutions++;
        }

        //double digit pass
        for(int i = 0; i < digits.length-1; i++){

            String tensDigit = digits[i] != 0 ? String.valueOf(digits[i]) : "";
            String onesDigit = String.valueOf(digits[i+1]);
            String key = tensDigit + onesDigit;
            if(decoderTable.containsKey(key)){
                samplesWithOverlap++;
            }
            if(decoderTable.containsKey(key) && i >= 1 && digits[i-1] != digits[i]){
                samplesWithoutOverlap++;
            }

        }

        for(int i = 1; i <= samplesWithoutOverlap; i ++){
            accumulator += calculateCombinations(samplesWithoutOverlap, i);
        }

        System.out.println("Accumulator   "+accumulator +" samplesWithoutOverlap "+samplesWithoutOverlap + " samplesWithOverlap"+samplesWithOverlap);
        System.out.println("Number of Solution     " + accumulator + numberOfSolutions);

        return numberOfSolutions + (int) accumulator;
    }

    private long calculateCombinations(int numberOfSamples, int numberToSelect) {
        return factorial(numberOfSamples) / (factorial(numberOfSamples-numberToSelect)*factorial(numberToSelect));

    }

    public static long factorial(int number) {
        long result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }

}
