package util;

import exception.DuplicateNumberException;
import exception.NotOnlyNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputNumberTest {
    InputNumber inputNumber = new InputNumber();

    @ParameterizedTest
    @ValueSource(strings = {"!@#", "   ", "-13"})
    @DisplayName("0~9사이의 숫자만 입력해야한다: 특수문자, 공백, 음수")
    void NotOnlyNumberExceptionTest(String input) {
        char[] chars = toCharArray(input);
        assertThrows(NotOnlyNumberException.class, () ->{
            inputNumber.inputNumberValidation(chars);
        });
    }

    @ParameterizedTest
    @ValueSource(strings ={"","0","12","1234"} )
    @DisplayName("세자리 수만 입력해야한다")
    void InputThreeNumberTest(String input) {
        char[] chars = toCharArray(input);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->{
            inputNumber.inputNumberValidation(chars);
        });
    }

    @ParameterizedTest
    @ValueSource(strings ={"111","112","009"} )
    @DisplayName("서로 다른 수만 입력해야한다")
    void DuplicateNumberExceptionTest(String input) {
        char[] chars = toCharArray(input);
        assertThrows(DuplicateNumberException.class, () ->{
            inputNumber.inputNumberValidation(chars);
        });
    }

    private char[] toCharArray(String input) {
        return input.toCharArray();
    }
}