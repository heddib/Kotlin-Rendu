// Liste des animaux
var animaux : ArrayList<Animal> = ArrayList<Animal>()

// Fonction d'entrée
fun main() {
    add(Chat())
    add(Chien())
    add(Marsupilami())
    add(Sardoche())

    println("--------")
    println("Bienvenue dans l'animalerie")
    println("--------")
    println(" ")
    println("Animaux : ")
    affiche()
}

// Ajoute un animal
fun add(animal: Animal) {
    animaux.add(animal)
}

// Affiche chaque animaux
fun affiche() {
    for (animal in animaux) {
        println("--------")
        animal.parler()
        animal.quiSuisJe()
        println("--------")
    }
}