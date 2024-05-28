package ru.job4j.ood.lsp;

/* Нарушение принципа LSP: усиление предусловия в конструкторе класса SuperCandidate */
public class LspViolationPreconditions {
    public static class Candidate {
        public final int rate;

        public Candidate(int rate) {
            if (rate <= 0) {
                throw new IllegalArgumentException("Invalid rate");
            }
            this.rate = rate;
        }
    }

    public static class SuperCandidate extends Candidate {
        public SuperCandidate(int rate) {
            super(rate);
            if (rate <= 10) {
                throw new IllegalArgumentException("Invalid rate");
            }
        }
    }
}
