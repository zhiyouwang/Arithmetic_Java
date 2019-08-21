package com.JnuWangPractice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列：可以理解为一个黑盒，向盒子内放入猫或者狗对象，设计两个队列，分别是猫队列和狗队列，当在盒子里取对象的时候，总
 * 是拿队列的第一个对象。
 */
public class DogCatQueue {

    /**
     * 宠物类
     */
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    /**
     * 狗类
     */
    public static class Dog extends Pet {
        public Dog() {
            super("Dog");
        }
    }

    /**
     * 猫类
     */
    public static class Cat extends Pet {
        public Cat() {
            super("Cat");
        }
    }

    public static class PetEnterQueue {
        private Pet pet;
        // count是时间戳
        private long count;

        public PetEnterQueue(Pet pet,long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public long getCount() {
            return this.count;
        }

        public String getEnterPetType() {
            return this.pet.getPetType();
        }
    }

    public static class DogCatQueues {
        private Queue<PetEnterQueue> dogQ;
        private Queue<PetEnterQueue> catQ;
        private long count;

        public DogCatQueues() {
            this.dogQ = new LinkedList<PetEnterQueue>();
            this.catQ = new LinkedList<PetEnterQueue>();
            this.count = 0;
        }

        public void addQueue(Pet pet) {
            if (pet.getPetType().equals("Dog")) {
                this.dogQ.add(new PetEnterQueue(pet, this.count++));
            } else if (pet.getPetType().equals("Cat")) {
                this.catQ.add(new PetEnterQueue(pet,this.count++));
            } else {
                throw new RuntimeException("error,not dog or cat");
            }
        }

        public Pet pollAll() {
            if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
                if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                    return this.dogQ.poll().getPet();
                } else {
                    return this.catQ.poll().getPet();
                }
            } else if (!this.dogQ.isEmpty()) {
                return this.dogQ.poll().getPet();
            } else if (!this.catQ.isEmpty()) {
                return this.catQ.poll().getPet();
            } else {
                throw new RuntimeException("error, Queue is empty");
            }
        }

        public Dog pollDog() {
            if (!this.isDogQueueEmpty()) {
                return (Dog)this.dogQ.poll().getPet();
            } else {
                throw new RuntimeException("Dog queue is empty!");
            }
        }

        public Cat pollCat() {
            if (!this.isCatQueueEmpty()) {
                return (Cat)this.catQ.poll().getPet();
            } else {
                throw new RuntimeException("Cat queue is empty!");
            }
        }

        public boolean isEmptyQueue() {
            return this.dogQ.isEmpty() && this.catQ.isEmpty();
        }

        private boolean isCatQueueEmpty() {
            return this.dogQ.isEmpty();
        }

        private boolean isDogQueueEmpty() {
            return this.catQ.isEmpty();
        }
    }

    public static void main(String[] args) {
        DogCatQueues test = new DogCatQueues();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.addQueue(dog1);
        test.addQueue(cat1);
        test.addQueue(dog2);
        test.addQueue(cat2);
        test.addQueue(dog3);
        test.addQueue(cat3);

        test.addQueue(dog1);
        test.addQueue(cat1);
        test.addQueue(dog2);
        test.addQueue(cat2);
        test.addQueue(dog3);
        test.addQueue(cat3);

        test.addQueue(dog1);
        test.addQueue(cat1);
        test.addQueue(dog2);
        test.addQueue(cat2);
        test.addQueue(dog3);
        test.addQueue(cat3);

        /*while (!test.isDogQueueEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }*/
        while (!test.isEmptyQueue()) {
            System.out.println(test.pollAll().getPetType());
        }
    }
}
