package ru.job4j.ood.lsp;

class PhoneNumber {

    private int countryCode;

    private int cityCode;

    private int number;

    public PhoneNumber(int countryCode, int cityCode, int number) {
        this.countryCode = countryCode;
        this.cityCode = cityCode;
        this.number = number;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public int getCityCode() {
        return cityCode;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "PhoneNumber{"
                + "countryCode=" + countryCode
                + ", cityCode=" + cityCode
                + ", number=" + number
                + '}';
    }
}
