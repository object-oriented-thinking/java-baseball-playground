package util;

import exception.DuplicateNumberException;
import exception.NotOnlyNumberException;

import java.util.ArrayList;
import java.util.Scanner;

import static util.Constant.*;

/**
 * 사용자가 입력한 숫자에대해 다루는 클래스
 */
public class InputNumber {
    private final Scanner sc= new Scanner(System.in);
    private final ArrayList<Integer> inputNumArray= new ArrayList<>();

    public ArrayList<Integer> getInputNumArray() {
        return inputNumArray;
    }

    public char[] inputNumberScanner() {
        this.inputNumArray.clear();
        String scStr = sc.nextLine();
        return scStr.toCharArray();
    }

    public void inputNumberValidation(char[] scChar) {
        ArrayIndexExceptionValidation(scChar);
        for (char c : scChar) {
            notOnlyExceptionValidation(c);
            DuplicateNumberExceptionValidation(c);
            this.inputNumArray.add(c - CHAR_TO_INT);
        }
    }

    private void DuplicateNumberExceptionValidation(char c) {
        if (inputNumArray.contains(c - CHAR_TO_INT)) {
            throw new DuplicateNumberException("서로다른 숫자만 입력해주세요");
        }
    }

    private void notOnlyExceptionValidation(char c) {
        if (OutOfRangeNumber(c)) {
            throw new NotOnlyNumberException("0~9사이의 숫자만 입력해주세요");
        }
    }

    private boolean OutOfRangeNumber(char scChar) {
        return scChar - CHAR_TO_INT > INPUT_NUMBER_MAXVALUE || scChar - CHAR_TO_INT < INPUT_NUMBER_MINVALUE;
    }

    private void ArrayIndexExceptionValidation(char[] scChar) {
        if (scChar.length != INPUT_NUMBER_LENGTH) {
            throw new ArrayIndexOutOfBoundsException("세자리 수를 입력해주세요.");
        }
    }
}
