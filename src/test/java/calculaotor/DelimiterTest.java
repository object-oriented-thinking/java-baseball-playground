package calculaotor;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DelimiterTest {

    @Test
    void test1() {
        Assertions.assertThat(Delimiter.findDelimiter("+")).isEqualTo(Delimiter.PLUS);
    }
}
