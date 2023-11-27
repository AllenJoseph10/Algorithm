public abstract class Creature {
    int posX;
    int posY;
    int health;
    int power;

    public void attack(Creature c){
        //complete this method
        if (isInRange(this.posX, this.posY)) {
            c.health = c.health - this.power;
        }

    }

    public abstract boolean isInRange(int targetPosX, int targetPosY);

    public void move (int x, int y){
        //complete this method
        posX = posX + x;
        posY = posY + y;
    }

    public boolean isDefeated (){
        //complete this method
        return health <= 0;
    }
}
