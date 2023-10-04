import classes.Hero
import classes.Monster
import classes.MonsterType

fun main(args: Array<String>) {
    val hero = Hero(10/, 45, 6..10, 30)
    val zombie = Monster.getMonster(MonsterType.ZOMBIE)
    val ghoul = Monster.getMonster(MonsterType.GHOUL)
    val wolf = Monster.getMonster(MonsterType.WEREWOLF)

    println(hero)
    println(zombie)
    println(ghoul)
    println(wolf)

    hero.attack(zombie)
    hero.attack(ghoul)
    hero.attack(wolf)
    wolf.attack(hero)

    println(hero)
    println(zombie)
    println(ghoul)
    println(wolf)

    hero.heal()
    println(hero)
}