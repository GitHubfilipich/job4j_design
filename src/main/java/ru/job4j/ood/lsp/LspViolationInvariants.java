package ru.job4j.ood.lsp;

/* Нарушение принципа LSP: нарушается инвариант в методе setRate класса SuperCandidate */
public class LspViolationInvariants {
    public static class Candidate {
        protected int rate;

        public Candidate(int rate) {
            validateRate(rate);
            this.rate = rate;
        }

        public void setRate(int rate) {
            validateRate(rate);
            this.rate = rate;
        }

        protected void validateRate(int rate) {
            if (rate <= 0 || rate > 100) {
                throw new IllegalArgumentException("Invalid rate");
            }
        }
    }

    public static class SuperCandidate extends Candidate {

        public SuperCandidate(int rate) {
            super(rate);
        }

        @Override
        public void setRate(int rate) {
            super.rate = rate * 2;
        }
    }
}
