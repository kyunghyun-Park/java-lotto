package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> generatedNumbers) {
        validateDuplicate(generatedNumbers);
        validateSize(generatedNumbers);
        this.numbers = generatedNumbers;
    }

    private void validateDuplicate(List<Integer> generatedNumbers) {
        Set<Integer> numbersSet = new HashSet<>(generatedNumbers);

        if (numbersSet.size() != generatedNumbers.size()) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
    }

    private void validateSize(List<Integer> generatedNumbers) {
        if (generatedNumbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다. : " + generatedNumbers.size());
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
