package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringTest{
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

     @Test
     void split() {
         String tmp = "1,2";
         String tmp2 = "1";
         assertThat(tmp.split(",")).contains("1","2");
         assertThat(tmp2.split(",")).containsExactly("1");
    }

     @Test
     void substring() {
         String tmp = "(1,2)";
         assertThat(tmp.substring(1, 4)).isEqualTo("1,2");
     }

     @Test
     void charAt() {
         String tmp = "abc";
         assertThrows(StringIndexOutOfBoundsException.class, () -> {
                 tmp.charAt(5);
         });
     }
}
