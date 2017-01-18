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

    @Override
    public void attack(LivingThing opponent){
        double d = Math.random();
        int damage = (int) (Math.random() * 6);
        if(getHitPoint() > 0){
            if(damage == 0){
                System.out.printf("%sの攻撃！,,,だが%sは攻撃を回避した!\n",getName(),opponent.getName());
            }
            else if(d < 0.3){
                damage = damage*2;
                System.out.printf("%sの会心の一撃！　%sに%dのダメージ！\n",getName(),opponent.getName(),damage);
            }
            else{
                System.out.printf("%sの攻撃！%sに%dのダメージ！\n",getName(),opponent.getName(),damage);
            }
        }
        opponent.wounded(damage);
    }
}