package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int NUMBERS_SIZE = 6;

    private final List<LottoNumber> numbers = new ArrayList<>();

    public Lotto(Integer... numbers) {
        this(List.of(numbers));
    }

    public Lotto(List<Integer> generatedNumbers) {
        validateDuplicate(generatedNumbers);
        validateSize(generatedNumbers);
        for (int generatedNumber : generatedNumbers) {
            numbers.add(new LottoNumber(generatedNumber));
        }
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

    public int matchCount(Lotto winningLotto) {
        int count = 0;

        for (LottoNumber number : numbers) {
            count = plusCountIfContains(winningLotto, number, count);
        }

        return count;
    }

    private int plusCountIfContains(Lotto lotto, LottoNumber number, int count) {
        if (lotto.contains(number)) {
            return count + 1;
        }
        return count;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
