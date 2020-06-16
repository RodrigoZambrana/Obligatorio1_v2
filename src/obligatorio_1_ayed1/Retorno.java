package obligatorio_1_ayed1;

public class Retorno {
	enum Resultado {
		OK, ERROR, NO_IMPLEMENTADA
	};

	int valorEntero;
	String valorString;
         boolean valorbooleano;
	Resultado resultado;

    public Retorno(Resultado resultado) {

        this.resultado = resultado;
    }
        
        
        
}
