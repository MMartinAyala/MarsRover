import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Obstaculo> obstaculoList = new ArrayList<>(Arrays.asList(
                new Obstaculo(2, 3, 3),
                new Obstaculo(7, 1, 6),
                new Obstaculo(17, 8, 3),
                new Obstaculo(14, 3, 6)
        ));

        // Se crea el Rover con una posicion y orientacion inicial y ademas se le pasa informacion de los obstaculos
        Rover rover = new Rover(0,0, Rover.NORTE,obstaculoList);

        // Se define la lista de comandos que luego sera ejecutada por el Rover
        List<String> comandos = new ArrayList<>();

        comandos.add(Rover.ADELANTE);
        comandos.add(Rover.GIRAR_DER);
        comandos.add(Rover.ADELANTE);
        comandos.add(Rover.ADELANTE);
        comandos.add(Rover.ADELANTE);
        comandos.add(Rover.ADELANTE);
        comandos.add(Rover.ADELANTE);
        comandos.add(Rover.ADELANTE);
        comandos.add(Rover.ATRAS);

        rover.ejecutarComandos(comandos);

        // Imprimir la posición final del rover
        System.out.println("Posición final del rover: " + rover);
    }
}
