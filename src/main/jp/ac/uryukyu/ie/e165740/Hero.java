package jp.ac.uryukyu.ie.e165740;

public class Hero extends LivingThing{

    public Hero(String name, int maximumHP, int attack){
        super(name,maximumHP, attack);
    }
    @Override
    public void wounded(int damage){
        setHitPoint(getHitPoint()-damage);
        if( getHitPoint() < 0 ) {
            setIsDead(true);
            System.out.printf("%sは道半ばで力尽きてしまった。\n", getName());
        }
    }
}