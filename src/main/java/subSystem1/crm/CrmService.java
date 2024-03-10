package subSystem1.crm;

public class CrmService {

    private CrmService(){
        super();
    }

    public static void toRecordClient(String name, String cep, String city, String state){
        System.out.println("Client saved in the system!");
        System.out.println(
                "Name: " + name + "\n" +
                "Cep: " + cep + "\n" +
                "City: " + city + "\n" +
                "State: " + state
                );
    }
}
