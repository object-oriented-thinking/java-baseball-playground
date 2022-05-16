package baseball.result;

import baseball.error.CalculationFailureException;

import java.util.Objects;

public class Result {
    private int strike;
    private int ball;
    private boolean nothing;

    public Result(int strike, int ball, boolean nothing) {
        if (strike + ball > 3) {
            throw new CalculationFailureException("계산 실패");
        }
        if (nothing && strike + ball != 0) {
            throw new CalculationFailureException("계산 실패");
        }
        this.strike = strike;
        this.ball = ball;
        this.nothing = nothing;
    }

    public String hint() {
        String hint = "";
        if (ball != 0) {
            hint += this.ball + "볼";
        }
        if (strike != 0) {
            hint += this.strike + "스트라이크";
        }
        if (nothing) {
            hint = "낫싱";
        }
        return hint;
    }

    public boolean isThreeStrikes() {
        return Objects.equals(this.strike, 3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return strike == result.strike && ball == result.ball && nothing == result.nothing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball, nothing);
    }
}
