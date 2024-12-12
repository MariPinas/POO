package execucaoparalela;

public class Corredor implements Runnable{
//trabalha com thread como a classe threads, mas como interface permitindo o Run
    @Override
    public void run() {
        while(true){
            System.out.println("Corredor");
        }
    }
    
}
