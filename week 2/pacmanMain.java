public class pacmanMain {
    public static void main(String[] args) {
        pacman pm1 = new pacman();
        pm1.x = 9;
        pm1.y = 5;
        pm1.weidht = 10;
        pm1.height = 10;
        pm1.moveRigth();
        pm1.moveUp();
        pm1.printPosition();
    }
}
