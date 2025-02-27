package DesignPatterns.Creational.Builder;

enum Weapon {
    SWORD, WHIP, SHIELD
}

class Enemy {
    public Weapon leftHand;
    public Weapon rightHand;
    String getWeapons() {
        return this.leftHand + " " + this.rightHand;
    }
}

interface EnemyBuilder {
    void setLeftHandWeapon(Weapon weapon);
    void setRightHandWeapon(Weapon weapon);
    Enemy get();
    void reset();
}

class SkullFaceBuilder implements EnemyBuilder {
    private Enemy skullFace;

    SkullFaceBuilder() {
        this.skullFace = new Enemy();
    }

    public void setLeftHandWeapon(Weapon weapon) {
        skullFace.leftHand = weapon;
    }

    public void setRightHandWeapon(Weapon weapon) {
        skullFace.rightHand = weapon;
    }

    public Enemy get() {
        return this.skullFace;
    }

    public void reset() {
        this.skullFace = new Enemy();
    }
}

class Director {

    EnemyBuilder builder;

    Director(EnemyBuilder builder) {
        this.builder = builder;
    }

    public Enemy createLeftShieldRightSword() {
        this.builder.reset();
        this.builder.setLeftHandWeapon(Weapon.SHIELD);
        this.builder.setRightHandWeapon(Weapon.SWORD);
        return this.builder.get();
    }
}

public class BuilderPattern {

    public static void main(String[] args) {
        EnemyBuilder eb = new SkullFaceBuilder();
        Director d = new Director(eb);

        Enemy e = d.createLeftShieldRightSword();

        System.out.println(e.getWeapons());
    }
}
