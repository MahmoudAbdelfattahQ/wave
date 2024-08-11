package com.example.spring3.util.designpattern.factory;

import com.example.spring3.util.Animal;

public class AnimalFactory {

    public AnimalService getAnimal(Animal type) {
        switch (type) {
            case DOG:
                return new Dog();
            case CAT:
                return new Cat();
            case LION:
                return new Lion();
            default:
                return null;
        }
    }
}
