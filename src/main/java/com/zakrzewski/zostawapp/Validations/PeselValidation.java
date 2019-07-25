package com.zakrzewski.zostawapp.Validations;

public class PeselValidation {
    public static String validatePeselNumber(String peselNumber){
        int[] verification = {1, 3, 7, 9, 1, 3, 7 ,9 ,1 ,3};
        boolean validation;
        if (peselNumber.length() != 11){
            validation = false;
        }
        int sumControl = 0;

        for (int i = 0; i < 10; i++) {
            sumControl = sumControl + Integer.parseInt(peselNumber.substring(i, i + 1)) * verification[i];
        }

        int controlValue = Integer.parseInt(peselNumber.substring(10, 11));
        sumControl = sumControl % 10;
        sumControl = 10 - sumControl;
        sumControl = sumControl % 10;

        if (sumControl == controlValue){
            return peselNumber;
        }else {
            throw new IllegalArgumentException();
        }
    }
}
