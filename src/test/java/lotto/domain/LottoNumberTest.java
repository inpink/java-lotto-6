package lotto.domain;

import static lotto.configuration.IntegerConstants.MAX_NUMBER_RANGE;
import static lotto.configuration.IntegerConstants.MIN_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    public void 로또번호_객체생성_정상문자값() {
        // Given
        String input = "1";

        // When
        LottoNumber result = LottoNumber.create(input);

        // Then
        assertTrue(result.isSameAmount(1));
    }

    @Test
    public void 로또번호_객체생성_정상정수값() {
        // Given
        int input = 5;

        // When
        LottoNumber result = LottoNumber.create(input);

        // Then
        assertTrue(result.isSameAmount(5));
    }

    @Test
    public void 로또번호_앞뒤의_공백제거() {
        // Given
        String input = " 45 ";

        // When
        LottoNumber result = LottoNumber.create(input);

        // Then
        assertTrue(result.isSameAmount(45));
    }

    @Test
    public void 로또번호_정수가아닌_문자일시_예외발생() {
        // Given
        String input = "k";

        // When && Then
        assertThatThrownBy(() -> LottoNumber.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상 2,147,483,647 이하의 정수 값이 필요합니다.");
    }

    @Test
    public void 로또번호_범위_벗어난_숫자일시_예외발생_45초과() {
        // Given
        String input = "46";

        // When && Then
        assertThatThrownBy(() -> LottoNumber.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45사이의 값이 필요합니다.");
    }

    @Test
    public void 로또번호_범위_벗어난_숫자일시_예외발생_1미만() {
        // Given
        String input = "0";

        // When && Then
        assertThatThrownBy(() -> LottoNumber.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45사이의 값이 필요합니다.");
    }

}
