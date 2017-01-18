package jp.ac.uryukyu.ie.e165740;

public class Enemy extends LivingThing {

    public Enemy(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    @Override
    public void attack(LivingThing opponent) {
        double d = Math.random();
        int damage = (int) (Math.random() * 4);
        if (getHitPoint() > 0) {
            if (damage == 0) {
                System.out.printf("%sの攻撃！,,,だが%sは攻撃を回避した!\n", getName(), opponent.getName());
            } else if (d < 0.2) {
                damage = damage * 2;
                System.out.printf("%sの痛恨の一撃！%sは%dのダメージ！\n", getName(), opponent.getName(), damage);
            } else {
                System.out.printf("%sの攻撃！%sは%dのダメージ！\n", getName(), opponent.getName(), damage);
            }
        }
        opponent.wounded(damage);

    }

    @Override
    public void wounded (int damage){
        setHitPoint(getHitPoint()-damage);
        if(getHitPoint() < 0 ) {
            setIsDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }
}
