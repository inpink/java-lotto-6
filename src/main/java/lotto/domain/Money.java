package lotto.domain;

import static lotto.messages.ErrorMessages.INVALID_MULTIPLE_OF_1000_MESSAGE;

import lotto.util.ExceptionUtil;
import lotto.util.IntegerUtil;
import lotto.validation.IntegerValidator;

public class Money {

    int amount;

    private Money(int amount) {
        validateMultipleOf1000(amount);
        this.amount = amount;
    }

    public static Money create(int input) {
        return new Money(input);
    }

    public static Money create(String input) {
        return new Money(processStringToInt(input));
    }

    public Money plus(Money money) {
        return new Money(this.amount + money.amount);
    }

    public boolean isSameAmount(int amount) {
        return this.amount == amount;
    }

    @Override
    public String toString() {
        return IntegerUtil.formatByThousandSeparator(amount);
    }

    private static int processStringToInt(String input) {
        input = input.trim();
        IntegerValidator.validateInteger(input);

        return Integer.parseInt(input);
    }

    private void validateMultipleOf1000(int amount) {
        if (amount % 1000 != 0) {
            ExceptionUtil.throwInvalidValueException(INVALID_MULTIPLE_OF_1000_MESSAGE.getMessage());
        }
    }
}
