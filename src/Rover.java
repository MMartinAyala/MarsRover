import java.util.List;

public class Rover {
    private int x;
    private int y;
    private String orientacion;
    private final List<Obstaculo> obstaculos;

    static final String NORTE = "N";
    static final String SUR = "S";
    static final String ESTE = "E";
    static final String OESTE = "W";

    static final String ADELANTE = "f";
    static final String ATRAS = "b";
    static final String GIRAR_IZQ = "l";
    static final String GIRAR_DER = "r";

    public Rover(int x, int y,String orientacion,List<Obstaculo> obstaculos) {
        this.x=x;
        this.y=y;
        this.orientacion = orientacion;
        this.obstaculos = obstaculos;
    }

    public void ejecutarComandos(List<String> comandos){
        for(String comando: comandos){
            if(comando.equals(ADELANTE) || comando.equals(ATRAS)){
                mover(comando);
                if(colicionaConObstaculo()){
                    break;
                }
            }
            if(comando.equals(GIRAR_IZQ) || comando.equals(GIRAR_DER)){
                girar(comando);
                if(colicionaConObstaculo()){
                    break;
                }
            }
        }
    }

    private boolean colicionaConObstaculo(){
        for(Obstaculo obstaculo : obstaculos){
            if(estaProximo(obstaculo)){
                return true;
            }
        }
        return false;
    }
    private boolean estaProximo(Obstaculo obstaculo) {
        double diferenciaX = obstaculo.x() - x;
        double diferenciaY = obstaculo.y() - y;

        double distancia = Math.sqrt(diferenciaX * diferenciaX + diferenciaY * diferenciaY);
        return distancia < obstaculo.radio();
    }

    private void mover(String comando) {
        if (comando.equals(ADELANTE)) {
            switch (orientacion) {
                case NORTE -> y--;
                case SUR -> y++;
                case ESTE -> x++;
                default -> x--;
            }
        } else if (comando.equals(ATRAS)) {
            switch (orientacion) {
                case NORTE -> y++;
                case SUR -> y--;
                case ESTE -> x--;
                default -> x++;
            }
        } else {
            throw new RuntimeException("Comando invalido");
        }
    }


    private void girar(String nuevaOrientacion){
        if(nuevaOrientacion.equals(GIRAR_DER)){
            switch (orientacion){
                case NORTE -> orientacion = ESTE;
                case SUR -> orientacion = OESTE;
                case ESTE -> orientacion = SUR;
                default -> orientacion = NORTE;
            }
        } else if (nuevaOrientacion.equals(GIRAR_IZQ)) {
            switch (orientacion){
                case NORTE -> orientacion = OESTE;
                case SUR -> orientacion = ESTE;
                case OESTE -> orientacion = SUR;
                default -> orientacion = NORTE;
            }
        }else {
            throw new RuntimeException("Comando invalido");
        }
    }

    @Override
    public String toString() {
        return "Rover{" +
                "orientacion='" + orientacion + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}