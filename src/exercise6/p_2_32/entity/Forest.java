package exercise6.p_2_32.entity;

import java.util.Objects;
import java.util.Random;

public class Forest {
    private static Forest instance;
    private Animal[][] data;
    private final Random random;

    private Forest(int maxX, int maxY) {
        this.data = new Animal[maxX][maxY];
        this.random = new Random();
    }

    public static Forest getInstance(int maxX, int maxY) {
        if (instance == null)
            instance = new Forest(maxX, maxY);
        return instance;
    }

    public Animal[][] getData() {
        return data;
    }

    public Forest add(EAnimal eAnimal, int quantity) {
        switch (eAnimal) {
            case TIGER -> {
                for (int i = 0; i < quantity; i++) {
                    Animal tiger = new Tiger("Tiger" + i, randomGender(), random.nextInt(4, 8));
                    int x, y;
                    do {
                        x = random.nextInt(0, data.length);
                        y = random.nextInt(0, data[0].length);
                    } while (data[x][y] != null);
                    add(tiger, x, y);
                }
            }
            case FISH -> {
                for (int i = 0; i < quantity; i++) {
                    Animal fish = new Fish("Fish" + i, randomGender(), random.nextInt(0, 3));
                    int x, y;
                    do {
                        x = random.nextInt(0, data.length);
                        y = random.nextInt(0, data[0].length);
                    } while (data[x][y] != null);
                    add(fish, x, y);
                }
            }
            case BEAR -> {
                for (int i = 0; i < quantity; i++) {
                    Animal bear = new Bear("Bear" + i, randomGender(), random.nextInt(6, 10));
                    int x, y;
                    do {
                        x = random.nextInt(0, data.length);
                        y = random.nextInt(0, data[0].length);
                    } while (data[x][y] != null);
                    add(bear, x, y);
                }
            }
        }
        return this;
    }

    public Forest add(Animal animal, int x, int y) {
        if (isValueNull(x, y))
            data[x][y] = animal;
        return this;
    }

    public void go() {
        boolean[][] isGo = new boolean[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                go(i, j, isGo);
            }
        }
    }

    private void go(int x, int y, boolean[][] isGo) {
        if (data[x][y] != null && !isGo[x][y]) {
            int newX = random.nextInt(3) - 1 + x;
            int newY = random.nextInt(3) - 1 + y;

            if (!isValuePos(newX, newY)) {
                //Go
                if (isValueNull(newX, newY)) {
                    isGo[newX][newY] = true;
                    data[newX][newY] = data[x][y];
                    data[x][y] = null;
                } else {
                    Animal animal = data[x][y];
                    Animal oldAnimal = data[newX][newY];

                    if (animal.getClass() == oldAnimal.getClass()) {
                        //Go and Reproduction
                        if (animal.isMale() != oldAnimal.isMale()) {
                            // Reproduction
                            int radius = 1;
                            while (true) {
                                int newAniX = newX + random.nextInt(radius * 2 + 1) - radius;
                                int newAniY = newX + random.nextInt(radius * 2 + 1) - radius;

                                if (isValueNull(newAniX, newAniY) && !isValuePos(newAniX, newAniY)) {
                                    data[newAniX][newAniY] = createNewAnimal(oldAnimal);
                                    return;
                                }
                            }
                        } else
                            System.out.println("Can't reproduce because they are of the same sex");
                    } else {
                        // Go an attack
                        if (animal.compareTo(oldAnimal) > 0) {
                            data[newX][newY] = animal;
                            data[x][y] = null;
                            isGo[newX][newY] = true;
                        } else if (animal.compareTo(oldAnimal) < 0) {
                            data[x][y] = null;
                            isGo[x][y] = true;
                        } else {
                            data[x][y] = random(animal, oldAnimal);
                            isGo[x][y] = true;
                        }
                    }
                }
            } else
                System.out.println("The forest limit has been exceeded");

        }
    }

    private Animal random(Animal animal, Animal oldAnimal) {
        int chance = random.nextInt(0, 2);
        if (chance == 0) {
            return animal;
        }
        return oldAnimal;
    }

    private boolean randomGender() {
        int chance = random.nextInt(0, 2);
        return chance == 0;
    }


    public void go2() {
        Animal[][] newData = new Animal[data.length][data[0].length];
        for (int x = 0; x < newData.length; x++) {
            for (int y = 0; y < newData[0].length; y++) {
                int newX = random.nextInt(3) - 1 + x;
                int newY = random.nextInt(3) - 1 + y;
                newData[newX][newY] = data[x][y];
            }
        }
    }

    private boolean isValueNull(int x, int y) {
        return data[x][y] == null;
    }

    private boolean isValuePos(int x, int y) {
        return x < 0 || x >= data.length || y < 0 || y >= data[0].length;
    }

    private Animal createNewAnimal(Animal animal) {
        int x = 0, y = 0;
        while (isValueNull(x, y) && isValuePos(x, y)) {
            x = random.nextInt(data.length - 1);
            y = random.nextInt(data[0].length - 1);
        }
        data[x][y] = animal;
        return data[x][y];
    }

}
