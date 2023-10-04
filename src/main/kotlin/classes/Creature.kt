package classes

abstract class Creature(shield: Int, maxHealth: Int, damageRange: IntRange, attack: Int) {
    private val attack: Int = if (attack > 0) {
        if (attack <= 30) attack
        else 30
    } else 1

    private val damageRange: IntRange = if (damageRange.isEmpty() || damageRange.first < 0) 1..damageRange.last
    else damageRange

    private var shield: Int = if (shield > 0) {
        if (shield <= 30) shield
        else 30
    } else 1
        private set(value) {
            field = if (value in 1..30) value
            else if (value <= 0) 0
            else 30
        }

    protected val maxHealth: Int = if (maxHealth > 0) {
        if (maxHealth <= 30) maxHealth
        else 30
    } else 0

    protected var health: Int = if (maxHealth > 0) {
        if (maxHealth <= 30) maxHealth
        else 30
    } else 0
        protected set(value) {
            if (value > 0) {
                isAlive = true
                field = if (value <= maxHealth) value
                else maxHealth
            } else {
                field = 0
                isAlive = false
            }
        }

    private var isAlive: Boolean = this.health > 0

    fun attack(creature: Creature) {
        if (creature.isAlive) {
            val difference = this.attack - creature.shield + 1
            val modifier = if (difference > 0) difference else 0
            var success = false

            for (i in 0..modifier) {
                val random = (1..6).random()
                if (random >= 5) success = true
            }

            if (success) {
                val randomDamage = damageRange.random()
                if (!creature.takeDamage(randomDamage)) println("Killed")
            }
        }
        else println("It's dead already")
    }

    private fun takeDamage(damage: Int): Boolean {
        health -= damage
        return isAlive
    }

    override fun toString(): String {
        return "hp: $health, attack: $attack, damage: $damageRange, shield: $shield, maxHp: $maxHealth, isAlive: $isAlive"
    }
}