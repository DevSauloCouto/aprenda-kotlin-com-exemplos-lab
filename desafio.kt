// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

data class User(val name: String, val email: String, var formations: MutableList<Formation>?)

data class ContentEducational(var name: String, val stack: String, val duration: Int, val level: Nivel)

data class Formation(val name: String, var contents: List<ContentEducational>) {

    val subscribes = mutableListOf<User>()

    fun enroll(vararg users: User) {
        for(user in users){
            subscribes.add(user);
            user.formations = mutableListOf(this);
        }
    }
}

fun main() {
    val user1 = User("Saulo", "sl@teste", null);
    val user2 = User("Artur", "artur@teste", null);
    val user3 = User("Gabriele", "gabi@teste", null);
    val user4 = User("Couto", "couto@teste", null);
    val user5 = User("Beatriz", "bia@teste", null);


    val contentEducational1 = ContentEducational("Lógica de Programação c/ Java", "JAVA", 45, Nivel.BASICO);
    val contentEducational2 = ContentEducational("APIs JAVA", "JAVA", 75, Nivel.INTERMEDIARIO);
    val contentEducational3 = ContentEducational("Java c/ Spring Boot", "JAVA", 90, Nivel.AVANÇADO);

    val formation = Formation("Back-end", listOf(contentEducational1,contentEducational2,contentEducational3));
    formation.enroll(user1,user2,user3,user4,user5);

    for(user in formation.subscribes){
        println(user);
    }

}
