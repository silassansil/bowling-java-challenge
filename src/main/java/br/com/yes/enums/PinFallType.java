package br.com.yes.enums;

import br.com.yes.domain.Frame;

public enum PinFallType {

    STRIKE {
        @Override
        public Integer addScore(final Frame next) {
            if (next.getFirstShot() == 10 && next.getNext() != null)
                return next.summationNextFirstsWhenHappenConsecutiveStrikes();

            return next.partialSummationTotalPinFalls();
        }
    },
    SPARE {
        @Override
        public Integer addScore(final Frame next) {
            return next.getFirstShot();
        }
    },
    NONE {
        @Override
        public Integer addScore(final Frame next) {
            return 0;
        }
    };

    public abstract Integer addScore(final Frame next);

    public boolean isStrike() {
        return this.equals(STRIKE);
    }

    public boolean isSpare() {
        return this.equals(SPARE);
    }

    public static PinFallType performType(int firstShot, int secondShot) {
        if (firstShot == 10) {
            return STRIKE;

        } else if (firstShot + secondShot == 10) {
            return SPARE;

        } else {
            return NONE;
        }
    }
}
