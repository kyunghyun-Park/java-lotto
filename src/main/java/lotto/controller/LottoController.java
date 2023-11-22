package lotto.controller;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private static final String DELIMITER = ", ";

    private LottoController() {
    }

    public static void run() {
        final int amount = InputView.inputAmount();

        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        final int quantity = purchaseAmount.calculateLottoQuantity();
        OutputView.outputQuantity(quantity);

        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.issueLottos(quantity, new AutoLottoNumberGenerator());
        OutputView.outputLottos(lottoMachine.getLottos());

        List<Integer> winningNumbers = InputView.inputWinningNumbers(DELIMITER);
        LottoWinningMachine winningMachine = new LottoWinningMachine(new Lotto(winningNumbers));
        Map<Rank, Integer> rankCounts = winningMachine.getRankCounts(lottoMachine.getLottos());

        OutputView.outputWinningResult(rankCounts);
        OutputView.outputRateOfResult(winningMachine.calculateRateOfResult(rankCounts, amount));
    }
}
