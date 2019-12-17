/**
 * @author Heddi Brahiti <heddi@brahiti.fr>
 */
import kotlin.math.abs
import kotlin.system.exitProcess
import java.io.Console

var playing : Boolean = false
var tries : Int = 1
var radius : Int = 10
var number : Int = 0

/**
 * Fonction d'entrée, peut prendre des paramètres si voulu
 */
fun main() {
    println("Bienvenue sur le jeu du plus ou moins")
    println(" ")
    println("---")
    println("Joueur 1 : Veuillez entrer un nombre entre 1 et 100")
    // number sera = à un chiffre écrit dans la console

    // Variables
    var console : Console? = System.console()
    // CharArray vide
    var numberPw : CharArray

    try {
        numberPw = console!!.readPassword("")
        number = numberPw.joinToString(separator = "").toInt()
    }
    catch (exception: KotlinNullPointerException ){
        number = Integer.parseInt(readLine())
    }

    // Si le nombre n'est pas compris entre 1 et 100...
    if(!(number in 1..100)) {
        println("Erreur ! Le nombre choisi ($number) n'est pas compris entre 1 et 100.")
        return;
    }
    println("OK ! Le nombre a été choisi.")
    println(" ")
    println("---")
    println("SI TU VEUX QUITTER, FAIS /FF")
    println("---")
    println(" ")
    println("Joueur 2 : Essaye de trouver le nombre choisi par le joueur 1")

    // Pour activer la boucle
    playing = true;

    while (playing) {
        println("Essai n°$tries :")

        // Lecture générale
        var read : String? = readLine().toString()

        // /ff -> Termine le process
        if(read.equals("/ff")) {
            println("VOUS AVEZ ABANDONNÉ ! >:(")
            playing = false
            return
        }

        // On assume qu'à partir d'ici on lit que des chiffres
        var guess : Int = Integer.parseInt(read)

        // Si le nombre entré est égal au nombre initial...
        if(guess == number) {
            println(" ")
            println(" ")
            println(" ")
            println("------------")
            println("GG WP !")
            println("Le chiffre était : $number")
            println("Tu as fais $tries essais pour y arriver!")
            playing = false
            exitProcess(0)
        } else if(guess > number) {
            // Si le nombre entré est plus grand...
            println("-")
            tries++
        } else if(guess < number) {
            // Si le nombre entré est plus petit...
            println("+")
            tries++
        }

        // Calcul pour trouvé si c'est chaud ou froid, valeur absolue pour les nombres > à number
        if((abs(number - guess)) > radius) {
            println("Froid")
        } else {
            println("Chaud")
        }
    }
}