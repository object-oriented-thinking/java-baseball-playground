package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void request1(){
        String[] str1 = "1,2".split(",");
        assertThat(str1).contains("1", "2");
        String[] str2 = "1".split(",");
        assertThat(str2).containsExactly("1");
    }

    @Test
    void request2(){
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("test StringIndexOutOfBoundsException")
    void request3(){
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {"abs".charAt(4);}).withMessageMatching("String index out of range: 4");
    }
}
