package classes

class Monster private constructor(shield: Int, maxHealth: Int, damageRange: IntRange, attack: Int) :
    Creature(shield = shield, maxHealth = maxHealth, damageRange = damageRange, attack = attack) {


        companion object {
            fun getMonster(monsterType: MonsterType): Monster{
                return when (monsterType){
                    MonsterType.ZOMBIE -> Monster(5, 10, 5..6, 5)
                    MonsterType.WEREWOLF -> Monster(5, 5, 10..12, 10)
                    MonsterType.GHOUL -> Monster(10, 15, 1..3, 3)
                    else -> throw IllegalArgumentException()
                }
            }
        }
}

enum class MonsterType {
    ZOMBIE,
    WEREWOLF,
    GHOUL
}
