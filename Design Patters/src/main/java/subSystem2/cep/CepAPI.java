package subSystem2.cep;

public class CepAPI {

    private static CepAPI instace = new CepAPI();

    private CepAPI(){
        super();
    }

    public static CepAPI getInstance() {
        return instace;
    }

    public String recoverTheCity(String cep) {
        return "Campinas";
    }

    public String recoverTheState(String cep) {
        return "SP";
    }
}
