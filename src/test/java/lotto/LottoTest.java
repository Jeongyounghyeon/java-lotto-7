package lotto;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성자는 지정 사이즈의 리스트가 아닌 경우 지정한 메세지와 함께 IllegalArgumentException을 발생한다.")
    void constructor_WithInvalidSize_ThrowIllegalExceptionWithExpectedMessage() {
        // given
        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5);
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 6);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.SIZE_ERROR_MESSAGE);

        assertThatThrownBy(() -> new Lotto(numbers2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.SIZE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("생성자는 중복되는 숫자가 있는 경우 지정한 메세지와 함께 IllegalArgumentException을 발생한다.")
    void constructor_WithDuplicatedNumber_ThrowIllegalExceptionWithExpectedMessage() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.DUPLICATED_NUMBER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("toString은 의도한 String을 반환한다.")
    void toString_ReturnCorrectly() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        // when
        String result = lotto.toString();

        // then
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
