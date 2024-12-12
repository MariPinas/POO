package execucaoparalela;
public class ExecucaoParalela {
    
    public static void main(String[] args) {
        Trabalhador a = new Trabalhador();
        Trabalhador b=new Trabalhador();
        a.setNome("AA");
        b.setNome("BB");
        a.start();
        b.start();
        
        a.setPriority(9);
        b.setPriority(9);
//        while(true){
//            System.out.println("Principal");
//        }
        
        Thread thread = new Thread(){
            public void run(){
                while(true){
                    System.out.println("anonima");
                }
            }
        };
        thread.start();
        
        Corredor corredor = new Corredor();
        Thread t=new Thread(corredor);
        t.start();
        
        Runnable corresim = new Runnable(){
            public void run(){
                while(true){
                    System.out.println("run anonima");
                }
            }
        };
        Thread tt=new Thread(corresim);
        tt.start();
        //==
        
        Runnable correlambda=()->{
            while(true){
                System.out.println("lambda");
            }
        };
        Thread ttt=new Thread(correlambda);
        ttt.start();
    }
    
}
