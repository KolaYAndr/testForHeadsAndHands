package classes

class Hero(shield: Int, maxHealth: Int, damageRange: IntRange, attack: Int) :
    Creature(shield = shield, maxHealth = maxHealth, damageRange = damageRange, attack = attack) {
    private var healCounter = 4
    private val healAmount: Int = (maxHealth * .3).toInt()

    fun heal(){
        if (healCounter > 0 && health < maxHealth) {
            health += healAmount
            healCounter--
        }
    }

    override fun toString(): String {
        return super.toString() + ", healCounter: $healCounter"
    }
}
