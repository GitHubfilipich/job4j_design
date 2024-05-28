package ru.job4j.ood.lsp;

/* Нарушение принципа LSP: ослабление постусловия в методе readyToExams класса SuperCandidate */
public class LspViolationPostconditions {
    public static class Candidate {
        public final int rate;

        public Candidate(int rate) {
            this.rate = rate;
        }

        public boolean readyToExams() {
            return rate > 5;
        }
    }

    public static class SuperCandidate extends Candidate {
        public SuperCandidate(int rate) {
            super(rate);
        }

        @Override
        public boolean readyToExams() {
            return true;
        }
    }
}
