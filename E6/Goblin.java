public class Goblin extends Creature {

    private final int attackDistance = 3;

    public Goblin(int posX, int posY){
        //complete constructor
        health = 80;
        power = 15;
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public boolean isInRange(int targetPosX, int targetPosY) {
        //complete this method
        if (posX - targetPosX < attackDistance && posX - targetPosX >(attackDistance * -1)) {

            if (posY - targetPosY < attackDistance && posY - targetPosY > (attackDistance * -1)) {
                return true;
            }
        }
        return false;
    }
}