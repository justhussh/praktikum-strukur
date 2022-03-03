public class pacman {
    int x, y, weidht, height;

    void moveLeft(){
        x = x - 1;
    }    
    void moveRigth(){
        x = x + 1;
    }
    void moveDown(){
        y = y - 1;
    }
    void moveUp(){
        y = y + 1;
    }

    void printPosition(){
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("weidht = " + weidht);
        System.out.println("height = " + height);
    }
}   
