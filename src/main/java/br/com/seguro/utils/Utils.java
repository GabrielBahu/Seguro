package br.com.seguro.utils;

import java.util.InputMismatchException;

import javax.validation.constraints.NotEmpty;

public class Utils {
	
	public static boolean isCPF(@NotEmpty(message = "CPF não pode ser vazio") String j) {
		
        if (j.equals("00000000000") ||
            j.equals("11111111111") ||
            j.equals("22222222222") || j.equals("33333333333") ||
            j.equals("44444444444") || j.equals("55555555555") ||
            j.equals("66666666666") || j.equals("77777777777") ||
            j.equals("88888888888") || j.equals("99999999999") ||
            (j.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
            num = (int)(j.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); 

            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(j.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

            if ((dig10 == j.charAt(9)) && (dig11 == j.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }

        public static String imprimeCPF(String CPF) {
            return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
            CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
        }
	}

