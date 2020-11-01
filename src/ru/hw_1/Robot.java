package ru.hw_1;

public class Robot implements IRunning, IJumping {

    private String name;
    private int runRange;
    private int jumpHeight;

        public Robot(String name, int runRange, int jumpHeight){
            this.name = name;
            this.runRange = runRange;
            this.jumpHeight = jumpHeight;
        }

                @Override
                public void jumping() {
                    for (int i = 0; i < wallHeight.length ; i++) {
                        if (jumpHeight > wallHeight[i]) {
                            System.out.println(name + " перепрыгнул припятствие");
                        } else {
                            System.out.println(name + " не смог :(");
                            break;
                        }
                    }
                }

                @Override
                public void running() {
                    for (int i = 0; i < distance.length ; i++) {
                        if (jumpHeight > distance[i]) {
                            System.out.println(name + " пробежал дистанцию");
                        } else {
                            System.out.println(name + " не смог :(");
                            break;
                        }
                    }
                }
}