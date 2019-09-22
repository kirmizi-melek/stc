package ru.kruglov.task8.ActContract;

public class Converter {

    static Act converter(Contract doc) {
        return new Act( doc.getNumber(),
                        doc.getDate(),
                        doc.getListOfGoods());
    }

    static Contract converter(Act doc) {
        return new Contract(doc.getNumber(),
                            doc.getDate(),
                            doc.getListOfGoods());
    }
}
